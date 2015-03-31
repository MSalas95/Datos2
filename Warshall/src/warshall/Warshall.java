/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package warshall;

import java.io.*;


class Matriz{
    
    int[][] warshall;
    int[][] MAdy;
    int n = 0;
    BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
    
    void llenar(){
    
        System.out.print("Ingrese el tamaño de la matriz: ");
        try 
        {
            n = Integer.parseInt(lee.readLine());
        } catch (Exception e) {
        }
        System.out.println("");
        
        int valor = 0;
        warshall = new int[n][n];
        MAdy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Inserte el valor de la posicion (" + i +"," + j + "): ");
                try {
                    valor = Integer.parseInt(lee.readLine());
                } catch (Exception e) {
                }
                warshall[i][j] = valor;
                MAdy[i][j] = valor;
            }
            System.out.println("");
        }        
    }
    
    int haycamino(int i, int j, int k){
        if ((warshall[i][j] == 1) || ((warshall[i][k] == 1) && (warshall[k][j] == 1))) {
            return 1;
        } else {
            return 0;
        }       
    }
    
    void matriz_final(){
        
        for (int k = 0; k <= n - 1; k++) {
            for (int i = 0; i <= n - 1; i++) {
                for (int j = 0; j <= n - 1; j++) {
                    warshall[i][j] = haycamino(i, j, k);
                }
            }

        }        
    }
    
    String mostrar(int[][] mat){
                
        
        String derecha= "",raya = "", fila ="", abajo = "", mostrar="";
        
        for (int u = 0; u < n; u++) {
                    
            fila += u+1 + "       ";                    

            raya += "_______ ";
                    
            derecha += "       " + "|";
            
            abajo += "_______" +"|";
        }        

       mostrar +=  "        " + fila + "\n" + "     " + raya + "\n";
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {                   

                    mostrar += i+1 + "   " + "|";
                }                
                
                    mostrar += "   " + mat[i][j] + "   |";               
                
                        
                if (i!=n-1){
                    if (j == n-1) {                        
                          mostrar += "\n" + "    " + "|" + derecha+ "\n";
                    }
                }
            }
            

        }
        
         mostrar += "\n" + "    " + "|" + abajo+ "\n";
        return mostrar;
        
    } 
    
    
}




public class Warshall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        Matriz obj = new Matriz();       
        int opc=0;
        
        while (opc!=4){
            
            System.out.println("");    
            System.out.println("¿Qué desea hacer?");
            System.out.println("Llenar matriz de adyacencia  (Coloque 1)");
            System.out.println("Mostrar matriz de adyacencia (Coloque 2)");
            System.out.println("Mostrar matriz resultante    (Coloque 3)");
            System.out.println("Salir                        (Coloque 4)");
            System.out.print("Coloque su opcion: ");
            
            try {
                opc = Integer.parseInt(lee.readLine());
            } catch (Exception e) {
            }
            System.out.println("");
            switch (opc){
                
                case 1: 
                    obj.llenar();
                    break;
                    
                case 2: 
                    System.out.println(obj.mostrar(obj.MAdy));
                    break;
                    
                case 3:obj.matriz_final();        
                    System.out.println(obj.mostrar(obj.warshall));
                    break;
                    
                case 4:
                    break;    
                    
                default:
                    break;               
            }
        }
    }    
}
