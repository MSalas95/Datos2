/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevotrucov;

/**
 *
 * @author Manuel
 */
public class Mano {
    
    Carta[] mano = new Carta[3];
    int[] exis = new int[3];
    
    
    public void crear_mano(Mazo mazo){        
         
        
        for(int i=0;i<3;i++){ //Inicializa el arreglo binario en 1 y le asigna las cartas a la mano.
            exis[i]= 1;
            mano[i]=mazo.sacar1();
        }     
        
    }  
    
}
