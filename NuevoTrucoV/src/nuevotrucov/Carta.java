/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevotrucov;



public class Carta {

    int num;
    int emb;
    String fig;
    int valor;   
 
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
