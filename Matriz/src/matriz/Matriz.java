/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz;

/**
 *
 * @author Manuel
 */

String mostrar(){
        
        String derecha= "",raya = "", fila ="", abajo = "", mostrar="";
        
        for (int u = 0; u < T; u++) {
                    
            fila += A[u] + "       ";                    

            raya += "________";
                    
            derecha += "       " + "|";
            
            abajo += "_______" +"|";
        }        

          mostrar +=  "*       " + fila + "\n" + "     " + raya + "\n";
        
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
                if (j == 0) {                   

                    mostrar += A[i] + "   " + "|";
                }                

                mostrar += "   " + M[i][j] + "   |";
                        
                if (i!=T-1){
                    if (j == T-1) {                        
                          mostrar += "\n" + "    " + "|" + derecha+ "\n";
                    }
                }
            }
            

        }
        
         mostrar += "\n" + "    " + "|" + abajo+ "\n";
        return mostrar;




public class Matriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
