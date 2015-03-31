/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevotrucov;

import java.util.Random;

public class Mazo {
    
     Carta [] mazo= new Carta[40]; //Mazo de cartas.
     int[] exis= new int[40];      //Arreglo binario que dice si una carta se encuentra en el mazo.
     
     
     void juntar() { // Inicializa el arreglo Binario en 1.
         
        for(int i=0;i!=40;i++){
            exis[i]=1;
        }
        
     }
     
     public Mazo(){ // constructor
         
        Datos in=new Datos(); //Objeto con los datos de las cartas.
        int f=0;
        int n=0;
     
        for(int i=0;i<40;i++){ //Llena cada carta con los datos.
            
            mazo[i]=new Carta();        
            mazo[i].num=in.num[n];
            mazo[i].emb=in.emb[n];
            n++;
            mazo[i].valor =in.jrquia[i];
            mazo[i].fig =in.fig[f]; 
            
            if (mazo[i].num==12){             
                f++;
                n=0; // o  if (n==10) tambn es valid for sta asigcn       
            }
            
        }
        juntar(); //Inicializa el arreglo binario en 1.
     }
     
     Carta sacar1(){ //Saca una carta del mazo al azar.
         
        Random suerte = new Random();   
        int x;
        do{
           x=suerte.nextInt(40);
        } while((exis[x]==0));
        
        exis[x]=0; //Elimina la carta del arreglo binario.
      
        return mazo[x];
        
     }     
        
    
}
