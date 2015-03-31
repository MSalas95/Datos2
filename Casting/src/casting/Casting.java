/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casting;

class Cast{
    
    void prueba(){
        
        double real = 120.9;
        int numero = (int) real;
        
        System.out.println("Numero: "+numero);
    }  
    
}
       




public class Casting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cast obj = new Cast();
        obj.prueba();
    }
}
