/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package spooling;

import java.io.*;
/**
 *
 * @author Manuel
 */

class Nodo{
    
    int x=0;
    Nodo sig=null;
    Nodo ant=null;
    
    void almacenar(int num){        
        
        sig=null;
        
    }    
}

class Cola{
    
    Nodo Q=null;
    Nodo Frente=null;
    Nodo Fondo=null;
    
    void encolar(){
        
        Nodo nodo_nuevo= new Nodo();
        nodo_nuevo.almacenar(0);
        
         if (Q != null) {
                nodo_nuevo.sig= Q;
                Q.ant= nodo_nuevo;
         }
            
         Q= nodo_nuevo;
            
         if (Q.sig==null){
             Frente=Q;
             Fondo=Q;           
         } else {
             Fondo=Q;             
         }       
    }
    
    void desencolar(){
        
        if (Q.sig!=null){            
            Frente=Frente.ant;
            Frente.sig.ant=null;
            Frente.sig=null;
        } else {
            Q=null;
        }        
    }   
}

class Spool{
    int at,pd,added;
    
    void spool(Cola C){
        int random=0;
        int j=0,k=0;       
        added=0;
        pd=0;
        at=0;
        
        for (int i=0;i<120;i++){
            
            j+=1;
            k+=1;
            
            if (j==10){
                random=(int)(Math.random()*5+1);
                for(int a=0;a<random;a++){
                    added+=1;
                    C.encolar();
                }
                j=0;
            }
            
            if (C.Q!=null){
                at+=1;
                C.desencolar();                
            }          
        }
        
        pd=added-at;   
    
    }
    
    void demonio(){
        
        try
        {
            File f = new File("Demonio.txt");
            FileWriter linea = new FileWriter(f, false);  
           
                
                linea.write("Trabajos atendidos: "+at+"\r\n");
                linea.write("Trabajos agregados: "+added+"\r\n");
                linea.write("Trabajos pendientes: "+pd+"\r\n");
                               
            linea.close();
            
        }
        catch(Exception E)
        {
             System.out.println("Error en archivo de salida.");
        }
        
    }
            
}



public class Spooling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Spool obj=new Spool();
        Cola cola=new Cola();
        
        obj.spool(cola);
        System.out.println("agregados: "+obj.added);
        System.out.println("atendidos: "+obj.at);
        System.out.println("pendientes: "+obj.pd);
        obj.demonio();
    }
}
