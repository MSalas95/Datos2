

package proyecto.venta.de.boletos;

import java.io.*;
                  
    public class ProyectoVentaDeBoletos {      
        public static void main(String[] args) throws IOException
        {
           
            
            
            
            Cliente cli=new Cliente();
            archivo ar=new archivo();
            Vuelo av=new Vuelo();
            Boletos bol=new Boletos();
            int opcm;
            
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Bienvenido a la Aerolinea El Pobre Que Vuela");
            System.out.println("Eliga que opcion desea realizar");
            System.out.println("1- Comprar Boletos");
            System.out.println("2-  ");
            opcm=Integer.parseInt(br.readLine());
            switch(opcm){
                
                case 1:
                
                    
                av.mostrar();  
                av.menuvuelo();
                cli.registrar();
                
                
                
            }
            
            
            
            
            
            
            
            
            ar.leer("cliente.txt");
            
            
            cli.registrar();
            
            
            
            
            
        }
        
     } 