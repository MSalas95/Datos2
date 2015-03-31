/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.*;

/**
 *
 * @author Manuel
 */

class Matriz{
    
    int T;    
    char M[][];
    char A[]= new char[6];
    char letras[]={'1','2','3','4','5','6','7','8','9','0','q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','ñ','z','x','c','v','b','n','m'};
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    boolean validar(char a){
        
        for (int i=0;i<37;i++){  
           
            if (a==letras[i]){ 
                
                return true;       
                 
            }
            
        }
         
        return false;   
                    
    }
    
    
    void almacenar(){
        JFrame frame = new JFrame("Discretas..");

        frame.setUndecorated( true );
        frame.setVisible( true );
        frame.setLocationRelativeTo( null );
        
        int i,j=0;
        char opc=' ';
        int otro;
        
        for (i=0; i<6;i++){
            A[i]=' ';                    
        }
        otro=-10;
        
        i=0;

          JOptionPane.showMessageDialog(frame, "Indique los caracteres alfanuméricos.", "", JOptionPane.INFORMATION_MESSAGE);


        while (i<6 && otro!=1){
           opc=' ';
                      
           while (validar(A[i]) == false){               
           
               try
               {     
                   
                  A[i]=JOptionPane.showInputDialog("Caracter "+(i+1)+":").charAt(0);
                    
               } 
               catch( Exception e)
               {               
                  JOptionPane.showMessageDialog(null, "Error. Coloque un caracter.", "Error.", JOptionPane.ERROR_MESSAGE);

               }
               
               
               
           }          
           
           
           otro=JOptionPane.showConfirmDialog(null, "¿Otro?");
           if (otro==0){
               i=i+1; 
           }
           
        }
        
        T=i+1;
        M= new char[T][T];
                
        for (i=0; i<T;i++){
            for (j=0; j<T;j++){
                M[i][j]=' ';
            }
        }        
        
        
        for (i=0; i<T;i++){
            for (j=0; j<T;j++){ 
                
                while (validar(M[i][j]) == false){               
           
                   try
                   {               
//                       System.out.print( "Operacion "+A[i]+"*"+ A[j]+" = ");                       
//                       M[i][j] =read.readLine().charAt(0);
                        M[i][j]=JOptionPane.showInputDialog("Operacion "+A[i]+"*"+ A[j]+" = ").charAt(0);
                       
                   } 
                   catch( Exception e)
                   {               
                       System.out.println("Error. Coloque un caracter.");
                   }
               
               }                
                    
                
            }
            
            
        }
            
        System.out.println(mostrar());
        JOptionPane.showMessageDialog(null, mostrar(), "Resultado",JOptionPane.PLAIN_MESSAGE );
        
    }
    
    String mostrar(){
        
        String derecha= "",raya = "", fila ="", abajo = "", mostrar="";
        
        for (int u = 0; u < T; u++) {
                    
            fila += A[u] + "     ";                    

            raya += "____";
                    
            derecha += "    " + "|";
            
            abajo += "____" +"|";
        }        

          mostrar +=  "*       " + fila + "\n" + "     " + raya + "\n";
        
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
                if (j == 0) {                   

                    mostrar += A[i] + "   " + "|";
                }                

                mostrar += "   " + M[i][j] + "   |";
                        
                if (i!=T-1){
                    if (j == T-1) {                        
                          mostrar += "\n" + "    " + "|" + derecha+ "\n";
                    }
                }
            }
            

        }
        
         mostrar += "\n" + "     " + "|" + abajo+ "\n";
        return mostrar;
        
    }
    
    


void dialogo(){

JOptionPane.showMessageDialog(null,"asd");

}
}

public class Prueba2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         Matriz obj = new Matriz();
         obj.almacenar();
        
        
        
    }
}
