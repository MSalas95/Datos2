/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamientopilas;

import java.io.*;

/**
 *
 * @author Manuel
 */


class Nodo{
    
    int x;
    Nodo sig=null;
    
    
    void almacenar(int num){
        
        x=num;
        sig=null;
        
    }
}

class Pila{
    
    Nodo top=null;
    int cant=0;
    
    void push(int x){
        
        Nodo nodo_nuevo= new Nodo();
        nodo_nuevo.almacenar(x);
        
        if (top!=null){                   
            nodo_nuevo.sig= top;             
        } 
        top= nodo_nuevo;
        cant=cant+1;
    }
    
    void pop(){
        
       if (top.sig == null) {                
          top= null;
       }
       else {                
          top= top.sig;
       }
       cant=cant-1;
    }   
}

class Ordenar{
    
    Pila pila2 = new Pila();
    Pila pila3 = new Pila();
    
    public int menor(Pila pila1){
        int m=pila1.top.x,cant=pila1.cant-1;
        
        for (int i=0;i<cant;i++){
            
            pila2.push(pila1.top.x);
            pila1.pop();
            
            
            if (pila1.top.x<m){
                m=pila1.top.x;
            }            
        }
        
        for (int i=0;i<cant;i++){
            pila1.push(pila2.top.x);
            pila2.pop();            
        }       
        return m;
    }
    
    void ordenar(Pila pila1,Archivos archivo){
        
        while (pila1.top!=null){   
            
            while (pila1.top.x!=menor(pila1)){
                
                pila2.push(pila1.top.x);
                pila1.pop();                
            
            }
            
            pila3.push(pila1.top.x);
            pila1.pop();
            
            
            while (pila2.top!=null){
                
                pila1.push(pila2.top.x);
                pila2.pop();
            
            }           
        }
        archivo.escribir(pila3);
    }   
}

class Archivos{
    
    void leer(Pila pila){
        try
        {
            File A = new File("Entrada.txt");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea = "";
            
            while ((linea = leer.readLine()) != null) {                
                
                pila.push(Integer.parseInt(linea));
                
            }           
        }
        catch(Exception E)
        {
                System.out.println("Error en archivo de entrada.");
        }       
    }
    
    void escribir(Pila pila){
        
        try
        {
            File f = new File("Salida.txt");
            FileWriter linea = new FileWriter(f, false);
            
            while(pila.top != null){
                
                linea.write(pila.top.x+"\r\n");
                pila.pop();
                
            }
            linea.close();
            
        }
        catch(Exception E)
        {
             System.out.println("Error en archivo de salida.");
        }        
    }       
}


public class OrdenamientoPilas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Pila obj1 = new Pila();        
        Archivos obj2 = new Archivos();
        Ordenar obj3 = new Ordenar();
       
        
        obj2.leer(obj1);
        obj3.ordenar(obj1,obj2);       
        
    }
}
