/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trucovenezolano;

/**
 *
 * @author Manuel
 */
import javafx.scene.image.Image;

public class Carta {

    int num;
    int emb;
    String fig;
    int valor;
    Image image;

    void crear(String Dir, String nombre) {
        image = new Image(Carta.class.getResourceAsStream(Dir + nombre));
    }
 
    int tipo (Carta vira){
    if (vira.fig==fig){
        if((num==11)|((vira.num==11)&(num==12))){
         return 2; //perico  
        }
        if((num==10)|((vira.num==10)&(num==12))){
         return 1; // perica 
        }
    }
     return 0;   
    }
    
}
