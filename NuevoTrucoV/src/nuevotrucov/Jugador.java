/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevotrucov;


public class Jugador extends Mano {
    
    int puntos=0;
    int embiste=0;
    int flor=0;
    int equipo;
    String nombre="";
    
    
    public Jugador(int x, String n){
        
        equipo=x;
        nombre=n;
        
    }
    
    
    
     
}
