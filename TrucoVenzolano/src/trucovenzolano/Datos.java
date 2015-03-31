/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trucovenzolano;

/**
 *
 * @author Manuel
 */
public class Datos {  //Esta clase solo contiene informacion de las cartas
    
    public final String[] imag = new String[]{     //Nombre del archivo de las imagenes de cada carta
        "O1.png", "O2.png", "O3.png", "O4.png", "O5.png", "O6.png", "O7.png", "O10.png", "O11.png", "O12.png",
        "C1.png", "C2.png", "C3.png", "C4.png", "C5.png", "C6.png", "C7.png", "C10.png", "C11.png", "C12.png",
        "E1.png", "E2.png", "E3.png", "E4.png", "E5.png", "E6.png", "E7.png", "E10.png", "E11.png", "E12.png",
        "B1.png", "B2.png", "B3.png", "B4.png", "B5.png", "B6.png", "B7.png", "B10.png", "B11.png", "B12.png",};
     public final int[] jrquia = new int[]{ //Valor de cada carta
        7, 8, 9, 0, 1, 2, 10, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 13, 8, 9, 0, 1, 2, 11, 4, 5, 6, 12, 8, 9, 0, 1, 2, 3, 4, 5, 6,};
     public final int[] num = new int[]{ //Numero de cada carta.
        1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
     public final int[] emb= new int[]{  //Valor de embiste de cada carta.
        1,2,3,4,5,6,7,0,0,0,
        };
     public final String[] fig = new String[]{ //Pinta de cada carta.
        "Oro", "Copa", "Espada", "Basto"};
    
}
