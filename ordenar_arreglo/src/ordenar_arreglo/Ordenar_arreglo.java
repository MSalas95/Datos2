/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ordenar_arreglo;

/**
 *
 * @author Manuel
 */
public class Ordenar_arreglo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int a[] = new int[5];
        a[0]=9;
        a[1]=4;
        a[2]=5;
        a[3]=3;
        a[4]=10;
        int aux=0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (a[j]<a[i]) {
                    aux=a[i];
                    a[i]=a[j];
                    a[j]=aux;
                }
            }
        }
        
        for (int i = 0; i < 5; i++) {
            System.out.println(a[i]);
        }
        
    }
    
}
