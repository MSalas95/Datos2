/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discretas;
import javax.swing.*;


/**
 *
 * @author Manuel
 */


class Matriz{
    
    int T;    
    char M[][];
    char A[]= new char[6];
    char letras[]={'1','2','3','4','5','6','7','8','9','0','q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','ñ','z','x','c','v','b','n','m'};
    JFrame frame;
    
    boolean validar(char a){        
         int c=0;       
        for  (int i=0; i<6; i++){
            
            if (a==A[i]){
                c +=1;
            }            
        }
        
        if (c>1){
            return false;
        }
        
        for (int i=0;i<37;i++){  
           
            if (a==letras[i]){                 
                return true;                    
            }            
        }        
        return false;                       
    }
    
    
    void almacenar(){
        
        frame = new JFrame("Discretas..");

        frame.setUndecorated( true );
        frame.setVisible( true );
        frame.setLocationRelativeTo( null );
        
        
        int i,j=0;
        char opc=' ';
        int otro=-10;
        String r="";
        for (i=0; i<6;i++){
            A[i]='-';                    
        }
        
        
        i=0;

        JOptionPane.showMessageDialog(frame, "Indique los caracteres alfanuméricos.", "Información", JOptionPane.INFORMATION_MESSAGE);
        
        while (i<6 && otro!=1){
           opc=' ';
                       
           while (validar(A[i]) == false){         
               try
               {  
                  r="  ";
                  while (r.length()>1){
                       r = JOptionPane.showInputDialog(frame, "Caracter "+(i+1)+":", "Conjunto A", JOptionPane.PLAIN_MESSAGE);
                       if (r==null){
                           JOptionPane.showMessageDialog(frame, "La operacion ha sido cancelada.", "Cancelado", JOptionPane.PLAIN_MESSAGE);
                           System.exit(0);
                       }
                  }                   
                  A[i]=r.charAt(0);                        
               } 
               catch( Exception e)             
               {                          
                   
               }
          
           }
                          
           if (i!=5){
              otro=JOptionPane.showConfirmDialog(frame, "¿Desea ingresar otro?","Confirmar",JOptionPane.YES_NO_OPTION);
              
           }                     
               i=i+1;        
        }
        
        T=i;
        M= new char[T][T];
                
        for (i=0; i<T;i++){
            for (j=0; j<T;j++){
                M[i][j]=' ';                
            }
        }        
        
        
        for (i=0; i<T;i++){
            for (j=0; j<T;j++){ 
                
                while (validar(M[i][j]) == false){               
           
                   try
                   {  
                      r="  ";
                      while (r.length()>1){
                         r = JOptionPane.showInputDialog(frame, "Operacion "+A[i]+"*"+ A[j], "Operación \"*\"", JOptionPane.PLAIN_MESSAGE);                         
                         if (r==null){
                           JOptionPane.showMessageDialog(frame, "La operacion ha sido cancelada", "", JOptionPane.PLAIN_MESSAGE);
                           System.exit(0);
                       }
                      }                
                      M[i][j]=r.charAt(0);
                   } 
                   catch( Exception e)
                   {               
                                  
                   }
                }                    
                
            }         
            
        }            
        System.out.println(matriz());
        
    }
    
    
    String matriz(){
        
        String derecha= "",raya = "", fila ="", abajo = "", mostrar="";
        
        for (int u = 0; u < T; u++) {
                    
            fila += A[u] + "       ";                    

            raya += "_______ ";
                    
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
        
    } 
    
    
    boolean OI(){
        
        int i,j,k,c=0;
        
        for (i=0; i<T;i++){
            for (j=0; j<T;j++){
                for (k=0; k<T;k++){                    
                    if (M[i][j]!=A[k]) {                    
                        c+=1;                            
                    }                    
                }
                if (c==T) {
                    return false;
                } 
                c=0;
            }           
        }
        return true;
    }
   
    boolean asociativa(){
       
       int x, y ,z, i;
       char v1, v2;
       
           for (x=0; x<T;x++){
               for (y=0; y<T;y++){
                   for (z=0; z<T;z++){
                       
                       i=-1;
                       
                       do{                   
                           i+=1;                          
                       }while(A[i]!=M[x][y]);
                       
                       v1= M[i][z];
                       
                       i=-1;
                       
                       do{                   
                           i+=1;                          
                       }while(A[i]!=M[y][z]);
                       
                       v2= M[x][i];
                       
                       if (v1!=v2){                           
                           return false;                          
                       }                      
                   }
               }                            
           }       
       return true;
   }
   
    char elemento_n(){
       
       int cont=0, y=0, j=0;
       char e=' ';
       
       cont =0;
       
       for(y=0;y<T;y++){
            for(j=0;j<T;j++){                  
                if ((M[y][j]==A[j]) && (M[j][y]==A[j])){                
                    cont += 1;                    
                    if (cont == T){                        
                        e=A[y];
                        y=T;                        
                    }                
               } else{
                    cont =0;
                    j=T;                 
               }             
            }           
       }
       
       if (cont==T){
           return e;
       } else{
           return '-';
       }
           
       
   }
     
    boolean inversiva(){
       
       int c1=0,c2=0,i,j;
       
       for(i=0;i<T;i++){
           for(j=0;j<T;j++){
               if (M[i][j]== elemento_n()){
                   c1 += 1;
                   if (M[j][i]== elemento_n()){
                       c2+=1;
                   }               
               }
           }          
       }
       if ((c1==c2)&&(c1==T)){
           return true;
       } else{
           return false;
       }
       
   }

    boolean conmutativa(){
       
       int i,j;
       
       for (i=0;i<T;i++){
           for (j=0;j<T;j++){
               if (M[i][j] != M[j][i]){
                   return false;
               }
           }
       }
       return true;
       
   }
    
    void mostrar(){              
         
        String mostrar="";
         if (OI()==true){ 
            mostrar+="Es una operacion binaria interna.\n";
            if (asociativa()==true){
                mostrar+="Es asociativa.\nEs semigrupo.\n";
                if (elemento_n()!='-'){
                    mostrar+=("Tiene elemento neutro.\nEl elemento neutro es: "+"E= "+elemento_n()+"\nEs monoide."+"\n");
                    if (inversiva()==true){
                        mostrar+= ("Cumple con la ley inversiva.\nEs grupo\n");
                        if (conmutativa()==true){
                            mostrar+= "Es conmutativa.\nEs grupo abeliano.\n";
                        } else{//                            
                             mostrar+= "No es conmutativa.\n";
                        }                       
                    } else{//                       
                         mostrar+= "No cumple con la ley inversiva.\n";
                    }                   
                } else{
                     mostrar+= "No tiene elemento neutro.\n";
                }               
            } else{
                mostrar+= "No es asociativa.\n";
            }    
        }else{
            mostrar+= "No es una operacion binaria interna.\n";
        } 
         
       JOptionPane.showMessageDialog(frame, mostrar, "Resultado", JOptionPane.PLAIN_MESSAGE); 
        
    }
}



public class Discretas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        Matriz obj = new Matriz();        
        obj.almacenar();      
        obj.mostrar();       
        obj.frame.dispose(); 
    }
}
