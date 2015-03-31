/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mostrar.matriz;


import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Manuel
 */
public class MostrarMatriz {
public static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    public static String llenarmatriz() {
        int mat[][];
        int a = 0;
        try {
            a = Integer.parseInt(JOptionPane.showInputDialog("ingrese el tamaño de la matriz"));
        } catch (Exception e) {
        }

        mat = new int[a][a];

        llenarmatriz2(mat = new int[a][a], a);

        return "";
    }

    public static void llenarmatriz2(int[][] mat, int a) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                
                try{
//                    System.out.print("Posicion ["+i+","+j+"]: ");
//                    mat[i][j] = Integer.parseInt(read.readLine());                    
                }catch(Exception E){
                    System.out.print("Error. Coloque un número.");
                }
                 
            }

        }
        String derecha= "",raya = "", fila ="", abajo = "";
        
        for (int u = 0; u < a; u++) {
                    
            fila += u + "       ";                    

            raya += "________";
                    
            derecha += "       " + "|";
            
            abajo += "_______" +"|";
        }
        
        System.out.println("*       " + fila + "\n" + "     " + raya);

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (j == 0) {
                   
                   System.out.print(i + "   " + "|");
                    
                }
                
                System.out.print("   " + mat[i][j] + "   |");
                
                if (i!=a-1){
                    if (j == a - 1) {
                        System.out.println("\n" + "    " + "|" + derecha);
                    }
                }
            }
            

        }
        
        System.out.println("\n" + "    " + "|" + abajo);
//        System.out.println("     " + raya);
        
    }

    /**
     * @param args the command line arguments
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("");
        llenarmatriz();
    }
}
