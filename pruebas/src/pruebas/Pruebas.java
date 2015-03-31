/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;
import java.io.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Manuel
 */



class prueba{
    
    int[] A= new int[6]; 
    int T=0;
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    void llenar(){
       for (int i=0; i<6; i++){ 
            try
            {
                A[i] = Integer.parseInt(read.readLine());
            }
            catch (Exception E)
            {            
                System.out.println("Error. Coloque un numero entero.");
            }
            
       }
       JOptionPane.showMessageDialog(null, "El valor ingresado es: ");
    }
    


String string(){
    
    System.out.print("Cadena.");
    return "asd"+ "\n" +"ASD2";
    
    
}

void mostrar(){
    
     JOptionPane.showMessageDialog(null, string());
    
}
    

}



public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        prueba obj=new prueba();
        System.out.println("asd");
        obj.llenar();
    }
}
