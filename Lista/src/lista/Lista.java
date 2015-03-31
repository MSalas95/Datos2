/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;
import java.io.*;
import java.util.LinkedList;

/**
 *
 * @author Manuel
 */

class Nodo{
    
    int cedula=0;
    String nombre = "";
    
    void almacenar(){
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));        
        
         while (cedula == 0) {            
            System.out.print("Coloque la cedula: ");        
            try {                
                cedula = Integer.parseInt(lee.readLine());                
            } catch (Exception e) {                
                System.out.println("Error, Debe introducir un numero. ");
            }
         }
        
         while (nombre.equals("")) {            
            System.out.print("Coloque el nombre: ");        
            try {                
                nombre = lee.readLine();                
            } catch (Exception e) {                
               System.out.println("Error.");
            }
        }
         
        
    }
    
}



public class Lista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        
    }
}
