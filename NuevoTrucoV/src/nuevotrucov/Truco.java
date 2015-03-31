/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevotrucov;

import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class Truco {
    
    Scanner in = new Scanner(System.in);
    Jugador[] J=new Jugador[2]; //arreglo de jugadores   
    Mazo mazo=new Mazo();  // objeto de mazo de cartas
    Carta vira;   // la carta que es la vira
    int puntos; 
    int ganador=0; //Quien es el ganador
    
    void jugar_mano(int turno){
       
       
       int m1=0;
       int m2=0;
       int PTruco=0;
       int PEmbiste=0;
       boolean quiero=true;
       vira=mazo.sacar1();
       
       
        for (int i=0;i<2;i++){  // Le reparte las cartas a cada jugador.                 
            J[i].crear_mano(mazo);            
        }
       
       
       for (int i=0;i<3;i++){
            
            for (int j=0;j<2;j++){                
                                
                System.out.println("Es el turno del Jugador "+J[turno-1].nombre);
                
                
                
                
                
                if (turno==1){
                    turno=2;
                } else {
                    turno=1;
                }
                
            }                  
            
        }       
        
        
    }
    
    
    void juego(){
        
        int t=0;
        String n="";
        
        for (int i=0;i<2;i++){
            
            System.out.print("Jugador "+(i+1)+" coloque su nombre: ");
            n=in.next();
            J[i] = new Jugador(i+1,n);
            
        }
        
        while (ganador == 0){   
            
            if (t==1){
                t=2;
            } else {
                t=1;
            }
            jugar_mano(t);
            
            
            
        }
        
        
        
    }
    
    
    
}
