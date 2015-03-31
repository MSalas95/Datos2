/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdisc;

import java.io.*;

/**
 *
 * @author Manuel
 */

class conjuntos{
    
    char C[][]= new char[6][6];
    char MA[] = new char[6];
    String otro="";
    int i=0;
    BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
    int tamaño;
    
    void almacenar(){
    
    System.out.println("Coloque los datos del conjunto A:");
    String otro="s";
    while ((otro.equalsIgnoreCase("s")) && (i<6)){
        
        System.out.print("Valor "+(i+1)+ ": ");
        try 
        {                
            MA[i]= lee.readLine().charAt(0);
                
        } 
             catch (Exception e) {
                
                System.out.println("Debe introducir un numero. ");
            }
         i=i+1;
        System.out.print("¿desea ingresar otro?(s/n): ");
        try 
        {                
            otro= lee.readLine();
                
        } 
             catch (Exception e) {
                
                System.out.println("error.. ");
            }
        
        
    }
    
    
    tamaño=i;
    for (int a=0;a<tamaño;a++){
         for (int b=0;b<tamaño;b++){
             System.out.print("operacion "+MA[a]+"*"+ MA[b]+ ": ");
        try 
        {                
            C[a][b]= lee.readLine().charAt(0);
                
        } 
             catch (Exception e) {
                
                System.out.println("Debe introducir un numero. ");
            }
             
             
         }
        
        
    }
    
    
}
    
    
    boolean operacion_interna(){
        int cont= 0;
        
       for (i=0; i<tamaño;i++){
           
            for (int a=0; a<tamaño;a++){
                for (int b=0; b<tamaño;b++){                    
                    if (C[i][a]!=MA[b]) {                    
                        cont =cont+ 1;                            
                    }                    
                }
                if (cont==tamaño) {
                    System.out.println("no es operacion interna");
                    return false;
                } 
                cont=0;
              }           
          }
         
          System.out.println("Es operacion interna");
           return true;     
    } 
    
    
   }
    
    
    
    

public class PDisc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        conjuntos objeto = new conjuntos();
        objeto.almacenar();
        objeto.operacion_interna();
    }
}
