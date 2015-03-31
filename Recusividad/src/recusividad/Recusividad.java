/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recusividad;
import java.io.*;
import java.util.*;

/**
 *
 * @author Manuel
 */

class Arreglo{
    
    int[] a= new int[10];
    BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
    
    
    public void inicializar(int i){
        
        if (i>9){
            
            
            
        } else {
            
            a[i]=0;
            inicializar(i+1);
            
        }
        
    }
    public void almacenar(int i){
        
        if (i>9){
            
            System.out.println("Datos guardados");
            
        } else {
            
            while (a[i]==0){
                System.out.print("Coloque el valor del arreglo en la posicion "+i+": ");
                try
                {
                    a[i] = Integer.parseInt(lee.readLine());
                }
                catch(Exception e)                 
                {
                System.out.println("Debe introducir un numero. ");
                }
            }
                
         almacenar(i+1);  
                     
            
        }
        
    }
    
     public void ordenar(int i, int j){
         
         if (j>9){
            
             if (i<9){
                 
                 ordenar(i+1,j=0);
             } else {
                 
                
                 
             }
             
            
        } else {
             
             if (a[j]>a[i]){
                 int v;
                 v=a[j];
                 a[j]=a[i];
                 a[i]=v;
                 ordenar(i,j+1);
             } else {
                 ordenar(i,j+1);
                 
             }
                 
             
             
         }
         
         
     }
    
    
    
    public void mostrar(int i){
        
        if (i>9){
            
            
            
        } else {
            
            System.out.println("Posicion "+i+"= "+ a[i]);
            mostrar(i+1);
            
        }
    }
    
    
}





public class Recusividad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Arreglo a=new Arreglo();
        
        a.inicializar(0);
        a.almacenar(0);
        System.out.println("-------------Datos sin ordenar");
        a.mostrar(0);
        System.out.println("-------------Datos ordenados");
        a.ordenar(0,1);
        a.mostrar(0);
        
    }
}
