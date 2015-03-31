package arbolavl;

import java.io.*;
import java.util.*;

/**
 *
 * @author Manuel y Joseph
 */
class Nodo{
    int x=0;
    int fe=0;
    Nodo der=null;
    Nodo izq=null;
    
    void almacenar (int y) {        
        x=y;
        der=null;
        izq=null;
    }  
}

class Arbol{
    Nodo R=null;
    
    void insertar_balanceado(int e, Nodo a){
        
        insertar(e,a);
        asignar_altura(R);       
        if (balanceado(R)!=true){
            buscar_desb(R);           
        }
    }
    
    void buscar_desb(Nodo raiz){
        
        if (raiz!=null) {
            if (balanceado(R)!=true) {
                 
                buscar_RD(raiz, 0);
                asignar_altura(R);
            }
            if (balanceado(R)!=true) {
                 
                buscar_RS(raiz, 0);
                asignar_altura(R);
            }
            
            buscar_desb(raiz.izq);
            buscar_desb(raiz.der);
        }  
    }
    
    void buscar_RD(Nodo aux, int c) {
        
        if (aux!=null) {
            if (aux.fe==2) {
                
                c=1;
                if (aux.der.fe==-1) {
                    
                    RDI(aux);
                    c=0;
                } else {
                    
                    buscar_RD(aux.der, c);
                }
            } else {
                if (aux.fe==-2) {
                    
                    c=2;
                    if (aux.izq.fe==1) {
                        
                        RDD(aux);
                        c=0;
                    } else {
                        
                        buscar_RD(aux.izq, c);
                    }
                }
            }
            if (c==1) {
                
                buscar_RD(aux.der, c);
            } else {
                if (c==2) {
                    
                    buscar_RD(aux.izq, c);
                }
            }
        }
    }
    
    void buscar_RS(Nodo aux, int c) {
        
        if (aux!=null) {
            if (aux.fe==2) {
                
                c=1;
                if ((aux.der.fe==1)||(aux.der.fe==0)) {
                    
                    RSI(aux);
                    c=0;
                } else {
                    
                    buscar_RS(aux.der, c);
                    c=0;
                }
            } else {
                if (aux.fe==-2) {
                    
                    c=2;
                    if ((aux.izq.fe==-1)||(aux.izq.fe==0)) {
                        
                        RSD(aux);
                        c=0;
                    } else {
                        
                        buscar_RS(aux.izq, c);
                        c=0;
                    }
                }
            }
            if (c==1) {
                
                buscar_RS(aux.der, c);
            } else {
                if (c==2) {
                    
                    buscar_RS(aux.izq, c);
                }
            }
        }
    }
    
    boolean balanceado(Nodo raiz){
       
        if (raiz!=null) {
            if ((raiz.fe==2) || (raiz.fe==-2)){
                
                return false;
            } else {
                
                return (balanceado(raiz.izq) & balanceado(raiz.der));                                
            }  
        } else{
            
            return true;
        }
        
    }
    
    void asignar_altura(Nodo raiz){       
        
        if (raiz!=null) {
            
            raiz.fe= (altura (raiz.der) - altura (raiz.izq));            
            asignar_altura(raiz.izq);
            asignar_altura(raiz.der);
        }        
        
    }
      
    void insertar (int E, Nodo A) {
        
        if (A==null) {
            
            Nodo nodo_nuevo=new Nodo();
            nodo_nuevo.almacenar(E);
            R=nodo_nuevo;                        
        } else {
            
            if (E>A.x) {
                if (A.der==null) {
                    
                    Nodo nodo_nuevo=new Nodo();
                    nodo_nuevo.almacenar(E);
                    A.der=nodo_nuevo;
                } else {
                    
                     insertar(E,A.der);
                }
            } else {
                if (A.izq==null) {
                    
                    Nodo nodo_nuevo=new Nodo();
                    nodo_nuevo.almacenar(E);
                    A.izq=nodo_nuevo;  
                } else {
                    
                    insertar(E, A.izq);
                }
                
            }
        }        
        
    }
    
    void eliminar_balanceado(int e, Nodo a) {
    
        eliminar(a, e, null);
        asignar_altura(R);       
        if (balanceado(R)!=true){
            buscar_desb(R);           
        }
    }
    
    void eliminar_hoja(Nodo aux, int e){
        
        if (aux.izq!=null) {
            if (aux.izq.x==e) {
                if ((aux.izq.izq==null)&&(aux.izq.der==null)) {
                    
                    aux.izq=null;
                }
            }
        }
        if (aux.der!=null) {
            if (aux.der.x==e) {
                if ((aux.der.izq==null)&&(aux.der.der==null)) {
                            
                    aux.der=null;
                } 
            } 
        }
    }
    
    void eliminar(Nodo A, int E, Nodo aux) {
        
        if (A!=null) {
            eliminar_hoja(A, E);
            if (A.x==E) {
                if (((A.izq!=null)&&(A.der==null))||((A.izq==null)&&(A.der!=null))) {
                    if (A.izq!=null) {
                            
                        A.x=A.izq.x;
                        A.izq.x=E;
                        eliminar(A, E, null);
                    } else {
                            
                        A.x=A.der.x;
                        A.der.x=E;
                        eliminar(A, E, null);
                    }
                } else {
                        
                    aux=buscarDizq(A.izq);
                    A.x=aux.x;
                    aux.x=E;
                    if ((A.izq.der!=null) || (A.izq.izq!=null)){
                            
                        eliminar(A.izq,E,null);
                    } else {
                            
                        eliminar(A, E, null);
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
    
    int altura(Nodo A){
        
        if ((A==null)){
            
            return 0; 
            
        } else{
            
            if ((A.der==null) && (A.izq==null)) { 
                
                return 1;
                
            } else {
                
                return (1+max(altura(A.izq),altura(A.der)));        
                
            }  
        }       
    }
    
    int max(int a, int b){
        if (a>b) {
            return a;
        } else {
            return b;
        }        
    }
    
    void RSI (Nodo c){
        
        Nodo aux, aux1=new Nodo();
            
        aux = c.der;
        aux1.almacenar(c.x);
        if (aux.izq != null) {   
            
            aux1.der=aux.izq;
        }
        
        c.x=aux.x;
        c.der=aux.der;
        aux1.izq=c.izq;
        c.izq=aux1;
    }
    
    void RSD (Nodo c){
        
        Nodo aux, aux1=new Nodo();
            
        aux = c.izq;
        aux1.almacenar(c.x);
        if (aux.der != null) {
            
            aux1.izq=aux.der;
        }
        
        c.x=aux.x;
        c.izq=aux.izq;
        aux1.der=c.der;
        c.der=aux1;        
    }
    
    void RDD(Nodo a){
        
        RSI(a.izq);
        RSD(a);
    }
    
    void RDI(Nodo a){
        
        RSD(a.der);
        RSI(a); 
    }     
    
    
}

class Archivos{
    
    void leer(Arbol obj){
        
        try 
        {
            File A = new File("Arbol.in");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea="";
            int a;
            int c=0;
            while ((linea = leer.readLine()) != null) {
                c+=1;
                StringTokenizer tokens = new StringTokenizer(linea, " ");
                if (c==1) {
                    
                    while (tokens.hasMoreTokens()) {
                    
                    a = Integer.parseInt(tokens.nextToken());

                    obj.insertar_balanceado(a, obj.R);                    
                    }
                } else {
                    while (tokens.hasMoreTokens()) {
                    
                    a = Integer.parseInt(tokens.nextToken());

                    obj.eliminar_balanceado(a, obj.R);              
                    }
                    
                }                             
            }
            
            
        } 
        catch (Exception e) {
            
            System.out.println("Error en la lectura del archivo.");
        } 
    }
    
    void imprimir(Nodo N,String[] A,int cont){
        
        if (N!=null) {
            A[cont]=A[cont]+" "+N.x;                  
            imprimir(N.izq,A,cont+1);
            imprimir(N.der,A,cont+1);
        }       
    }
    
    void salida(Nodo N,String[] A,int cont){
        try 
        {
            File f = new File("Salida.out");
            FileWriter linea = new FileWriter(f, false);  
            imprimir(N,A,cont);
            
            for (int i = 0; i < A.length; i++) {
                linea.write(A[i]+"\r\n");
                System.out.println(A[i]);
            }
            
            
            linea.close();
        } catch (Exception e) {
        }
        
        
    }
    
    
}

public class ArbolAVL {
    
    public static void main(String[] args) {
        
        Arbol arbol = new Arbol();
        Archivos arch = new Archivos();        
        arch.leer(arbol);
        String[] A=new String[arbol.altura(arbol.R)];
        
        for (int i = 0; i < A.length; i++) {
            A[i]=new String();
        }
        int cont=0;
        arch.salida(arbol.R, A, cont);
        
        
        
    }
    
}
