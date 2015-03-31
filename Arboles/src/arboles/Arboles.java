

package arboles;

/**
 *
 * @author JosephAlejandro
 */
class Nodo {
    int x=0,fe=0;
    Nodo der, izq;
    
    void almacenar (int y) {
        
        x=y;
        der=null;
        izq=null;
    }
    
}

class Arbol {
    Nodo A=null;
    
    void insertar (int E, Nodo A) {
        
        if (A==null) {
            
            Nodo nodo_nuevo=new Nodo();
            nodo_nuevo.almacenar(E);
            A=nodo_nuevo;
        } else {
            
            if (E>A.x) {
                
                insertar(E, A.der);
            } else {
                
                insertar(E, A.izq);
            }
        }
    }
    
    void eliminar(Nodo A, int E, Nodo aux) {
        
        if (A!=null) {
            if (A.x==E) {
                if ((A.izq==null)&&(A.der==null)) {
                    
                    A=null; 
                } else {
                    if (((A.izq!=null)&&(A.der==null)||(A.izq==null)&&(A.der!=null))) {
                        if (A.izq!=null) {
                            
                            A=A.izq;
                        } else {
                            
                            A=A.der;
                        }
                    } else {
                        
                        aux=buscarDizq(A.izq);
                        A.x=aux.x;
                        aux.x=E;
                        eliminar(aux,E,null);
                    }
                }
            } else {
                if (A.x>E) {
                    
                    eliminar(A.izq,E,null);
                } else {
                    
                    eliminar(A.der,E,null);
                }
            }
        } 
    }
    
    Nodo buscarDizq(Nodo A) {
        
        if (A.der==null) {
            
            return A;
        } else {
            
            return buscarDizq(A.der);
        }
    }
}

public class Arboles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
