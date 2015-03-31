/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trucovenzolano;

import javafx.scene.image.Image;

/**
 *
 * @author Manuel
 */
public class Carta {
    
    int num;      // Numero de la carta.
    int emb;      // Valor de embiste de la carta.
    String fig;   // Pinta de la carta.
    int valor;    // Valor de la carta.
    Image image;  //Imagen de la carta.

    void crear(String Dir, String nombre) {
        image = new Image(Carta.class.getResourceAsStream(Dir + nombre));  // Le asigna una imagen a la carta.
    }
 
    int tipo (Carta vira){    //Devuelve si la carta es perico, perica o normal.
        
        if (vira.fig==fig){
            if((num==11)|((vira.num==11)&(num==12))){  //Si la carta es perico
                return 2; //perico  
            }
            if((num==10)|((vira.num==10)&(num==12))){  //Si la carta es perica.
                return 1; // perica 
            }
        }
        return 0;   //La carta no es perico ni perica.
    }
    
}
