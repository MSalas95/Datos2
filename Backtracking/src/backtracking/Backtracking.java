/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

import java.io.*;
import java.util.*;


/**
 *
 * @author Manuel* 
 * 
 */

class Muller{
    int tiempo;
    float mugre;     
    int inicio,fin; 
}
class Cloacas{
    int tiempo,ratas;
}
class Matriz{
    int n;
    Cloacas M[][];
    int recorrido[];    
    int rec_optimo[];
    int topt;
    float mopt;
    void instanciar(Muller rata){
        M=new Cloacas[n][n];
        recorrido=new int[n];
         rec_optimo=new int[n];
        for (int i=0;i<n;i++){
            if (i==0){
                recorrido[i]= rata.inicio;
            } else{
                recorrido[i]=-1;
                rec_optimo[i]=-1;
            }
            
        }
               
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                M[i][j]=new Cloacas();                
            }            
        }
        
    }
    
    String mostrar(){
        
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
                String tam1= Integer.toString(M[i][j].tiempo);
                String tam2=Integer.toString(M[i][j].ratas);
                if (tam1.length() == 2) {
                    mostrar += "  " + M[i][j].tiempo+"/"+M[i][j].ratas + " |";
                } else {
                    if (tam1.length() == 1) {
                        mostrar += "  " + M[i][j].tiempo+"/"+M[i][j].ratas + "  |";
                    } else{
                        if (tam1.length() == 3) {
                            mostrar += " " + M[i][j].tiempo+"/"+M[i][j].ratas + " |";
                        }
                    }
                }
                
                        
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
    
    void recorrido(Muller rata,int i,int j){
       int a=0;
       int b=0;           
           for (j=0; j<n;j++){               
               
               if (verificar(j)==true){
                   if (M[i][j].tiempo!=0){
                       rata.tiempo += M[i][j].tiempo;
                       
                       while ((a!=n-1) && (recorrido[a]!=-1)){
                           a+=1;                            
                       }
                       recorrido[a]=j;
                       if (M[i][j].ratas == 1){
                           rata.mugre -= rata.mugre/4;                           
                       }                     
                       
                       
                        if (j==rata.fin){
                            recorrido_optimo(rata);
                                                        
                        } else {
                            recorrido(rata,j,0);  //llamada recursiva                           
                        }
                        
                        recorrido[a]=-1;
                        rata.tiempo-=M[i][j].tiempo;
                        if (M[i][j].ratas == 1){
                           rata.mugre += ((rata.mugre/3));                           
                        }                                                  
                   }     
               }               
       } 
    }
    
    void recorrido_optimo(Muller rata){
        if (topt==0){
            topt = rata.tiempo;
            mopt= rata.mugre;
            System.arraycopy(recorrido, 0, rec_optimo, 0, n);     
            
        } else {
            
            if (rata.tiempo<=topt && (rata.mugre>=mopt)){               
                    topt = rata.tiempo;
                    mopt =rata.mugre;
                    System.arraycopy(recorrido, 0, rec_optimo, 0, n);                     
                              
                
            } else {
                
                if ((rata.tiempo>topt) && (rata.mugre>mopt) && ((rata.tiempo-topt)<=10)){
                    topt = rata.tiempo;
                    mopt= rata.mugre;
                    System.arraycopy(recorrido, 0, rec_optimo, 0, n);                        
                } 
            }            
        }          
    }
    
    boolean verificar(int a){
        
       for  (int i=0; i<n; i++){            
            if (a==recorrido[i]){
                return false;
            }            
       }        
       return true;      
    }
    
}


public class Backtracking {

    static void leer_archivo(Muller obj, Matriz obj1) {
        
        try
        {
            File A = new File("Entrada.txt");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            StringTokenizer tokens;
            String linea = "";
            int t=-1,l=0;
            
            while ((linea = leer.readLine()) != null) {
                l+=1;
                
                tokens = new StringTokenizer(linea, "/");               
               
                       
                    if (l==1){          
                                           
                        obj.inicio = (Integer.parseInt(tokens.nextToken())-1);                        
                        obj.fin = (-1 + Integer.parseInt(tokens.nextToken()));                        
                        obj.mugre = Float.parseFloat(tokens.nextToken());
                        
                        
                    } else{
                        if (l==2){                            
                            obj1.n=(tokens.countTokens()/2);                            
                            obj1.instanciar(obj);
                        }                        
                        int i=-1;
                        t+=1;
                        while (tokens.hasMoreTokens()) {                              
                            i+=1;                           
                            obj1.M[t][i].tiempo = Integer.parseInt(tokens.nextToken());
                            obj1.M[t][i].ratas = Integer.parseInt(tokens.nextToken());                              
                       }                        
                    }               
            }            
        }
        catch (Exception E)
        {
            System.out.println("error en archivo");            
        }
    
    }
    
    static void guardar_archivo(Muller obj, Matriz obj1){
        
        try        
        {
           File f = new File("Solución.txt");
           FileWriter linea = new FileWriter(f, false); 
           
           
           if (obj1.topt!=0){
              linea.write("Mejor camino: ");          
              int b=0;       
              while ((b<=obj1.n-1) && obj1.rec_optimo[b]!=-1){               
                 linea.write((obj1.rec_optimo[b]+1)+" ");                               
                 b+=1;                           
              } 
              linea.write("\r\n");
              linea.write("Tiempo: "+obj1.topt+"\r\n");
              linea.write("Mugre: "+obj1.mopt+"\r\n");
           } else {
               linea.write("No hay solución."); 
               
           }
           
           linea.close();
           
        }
        catch(Exception E)
        {
            
        }
        
        
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Matriz obj1=new Matriz();
        Muller obj2=new Muller();
        obj1.instanciar(obj2);
        leer_archivo(obj2,obj1);        
        System.out.println(obj1.mostrar());
        obj1.recorrido(obj2,obj2.inicio,0);        
        
        int b=0;
        if (obj1.topt!=0) {       
            System.out.print("Recorrido optimo: ");
            while ((b<=obj1.n-1) && obj1.rec_optimo[b]!=-1){               
                System.out.print((obj1.rec_optimo[b]+1)+" ");                               
                b+=1;                           
            }
            System.out.println("");
            System.out.println("Tiempo: "+obj1.topt);
            System.out.println("Mugre: "+obj1.mopt);        
         } else {
            System.out.println("No hay solucion.");
        }       
        guardar_archivo(obj2,obj1);   
    }
}
