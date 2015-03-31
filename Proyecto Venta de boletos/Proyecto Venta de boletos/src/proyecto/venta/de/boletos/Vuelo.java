
package proyecto.venta.de.boletos;

import java.io.*;


public class Vuelo {
        String origen;
        String destino;
        String horadesalida;
        double numerodevuelo=0;
        double tarifaclasec=100;
        int ced;
  
        
        
        void mostrar() throws IOException
        {
            try{
                FileInputStream fstream=new FileInputStream("vuelo.txt");
            
            DataInputStream entrada=new DataInputStream(fstream);
            BufferedReader br=new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            
            while((strLinea=br.readLine())!=null){
                System.out.println(""+strLinea);
            }
            entrada.close();
            }catch (Exception ex){
                System.out.println("Ocurrio un error: " + ex.getMessage());
             }
                
        
    }

        int menuvuelo() throws IOException 
        {
            int opc = 0;
            int opc1 = 0;
           
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
                    
            
            
            System.out.println("Eliga un de los vuelos predefinidos");
            System.out.println("Y despues elija su tarifa"
                    + " 1-Clase C=100 "
                    + " 2-Clase B=115 "
                    + " 3-Clase A=125 ");
            opc=Integer.parseInt(br.readLine());
            switch(opc)
            {
                case 1:
                    System.out.println("Ha elegido el vuelo numero 1:"
                            + "Margarita/Caracas/00:00");
                    
                    System.out.println("Proceda a elegir su tarifa");
                    
                    opc1=Integer.parseInt(br.readLine());
                    switch(opc1)
                    {
                       
                        case 1:
                            
                            System.out.println("Tarifa C=100");
                            break;
                            
                        case 2:
                            
                            System.out.println("Tarifa B=115");
                            break;
                            
                        case 3:
                            
                            System.out.println("TarifaA=125");
                            break;
                    }
                break;
            
                case 2:
                    
                     System.out.println("Ha elegido el vuelo numero 2:"
                            + "Caracas/Margarita/06:00");
                    
                    System.out.println("Proceda a elegir su tarifa");
                    
                    opc1=Integer.parseInt(br.readLine());
                    switch(opc1)
                    {
                       
                        case 1:
                            
                            System.out.println("Tarifa C=100");
                            break;
                            
                        case 2:
                            
                            System.out.println("Tarifa B=115");
                            break;
                            
                        case 3:
                            
                            System.out.println("TarifaA=125");
                            break;
                    }
                break;
                
                case 3:
                    
                     System.out.println("Ha elegido el vuelo numero 3:"
                            + "Margarita/Maturin/02:00");
                    
                    System.out.println("Proceda a elegir su tarifa");
                    
                    opc1=Integer.parseInt(br.readLine());
                    switch(opc1)
                    {
                       
                        case 1:
                            
                            System.out.println("Tarifa C=100");
                            break;
                            
                        case 2:
                            
                            System.out.println("Tarifa B=115");
                            break;
                            
                        case 3:
                            
                            System.out.println("TarifaA=125");
                            break;
                    }
                break;
                case 4:
                    
                     System.out.println("Ha elegido el vuelo numero 4:"
                            + "Maturin/Margarita/08:00");
                    
                    System.out.println("Proceda a elegir su tarifa");
                    
                    opc1=Integer.parseInt(br.readLine());
                    switch(opc1)
                    {
                       
                        case 1:
                            
                            System.out.println("Tarifa C=100");
                            break;
                            
                        case 2:
                            
                            System.out.println("Tarifa B=115");
                            break;
                            
                        case 3:
                            
                            System.out.println("TarifaA=125");
                            break;
                    }
                break;
                case 5:
                    
                     System.out.println("Ha elegido el vuelo numero 5:"
                            + "Caracas/Maturin/04:00");
                    
                    System.out.println("Proceda a elegir su tarifa");
                    
                    opc1=Integer.parseInt(br.readLine());
                    switch(opc1)
                    {
                       
                        case 1:
                            
                            System.out.println("Tarifa C=100");
                            break;
                            
                        case 2:
                            
                            System.out.println("Tarifa B=115");
                            break;
                            
                        case 3:
                            
                            System.out.println("TarifaA=125");
                            break;
                    }
                break;
                case 6:
                    
                     System.out.println("Ha elegido el vuelo numero 6:"
                            + "Maturin/Caracas/10:00");
                    
                    System.out.println("Proceda a elegir su tarifa");
                    
                    opc1=Integer.parseInt(br.readLine());
                    switch(opc1)
                    {
                       
                        case 1:
                            
                            System.out.println("Tarifa C=100");
                            break;
                            
                        case 2:
                            
                            System.out.println("Tarifa B=115");
                            break;
                            
                        case 3:
                            
                            System.out.println("TarifaA=125");
                            break;
                    }
                break;
                case 7:
                    
                     System.out.println("Ha elegido el vuelo numero 7:"
                            + "Maracaibo/Caracas/06:00");
                    
                    System.out.println("Proceda a elegir su tarifa");
                    
                    opc1=Integer.parseInt(br.readLine());
                    switch(opc1)
                    {
                       
                        case 1:
                            
                            System.out.println("Tarifa C=100");
                            break;
                            
                        case 2:
                            
                            System.out.println("Tarifa B=115");
                            break;
                            
                        case 3:
                            
                            System.out.println("TarifaA=125");
                            break;
                    }
                break;
                case 8:
                    
                     System.out.println("Ha elegido el vuelo numero 8:"
                            + "Caracas/Maracaibo/12:00");
                    
                    System.out.println("Proceda a elegir su tarifa");
                    
                    opc1=Integer.parseInt(br.readLine());
                    switch(opc1)
                    {
                       
                        case 1:
                            
                            System.out.println("Tarifa C=100");
                            break;
                            
                        case 2:
                            
                            System.out.println("Tarifa B=115");
                            break;
                            
                        case 3:
                            
                            System.out.println("TarifaA=125");
                            break;
                    }
                break;
                case 9:
                    
                     System.out.println("Ha elegido el vuelo numero 9:"
                            + "Margarita/Maracaibo/08:00");
                    
                    System.out.println("Proceda a elegir su tarifa");
                    
                    opc1=Integer.parseInt(br.readLine());
                    switch(opc1)
                    {
                       
                        case 1:
                            
                            System.out.println("Tarifa C=100");
                            break;
                            
                        case 2:
                            
                            System.out.println("Tarifa B=115");
                            break;
                            
                        case 3:
                            
                            System.out.println("TarifaA=125");
                            break;
                    }
                break;
                case 10:
                    
                     System.out.println("Ha elegido el vuelo numero 10:"
                            + "Maracaibo/Margarita/14:00");
                    
                    System.out.println("Proceda a elegir su tarifa");
                    
                    opc1=Integer.parseInt(br.readLine());
                    switch(opc1)
                    {
                       
                        case 1:
                            
                            System.out.println("Tarifa C=100");
                            break;
                            
                        case 2:
                            
                            System.out.println("Tarifa B=115");
                            break;
                            
                        case 3:
                            
                            System.out.println("TarifaA=125");
                            break;
                    }
                break;
                    
                default:
                    System.out.println("Ingrese un vuelo predefinido");
                    
                
                    
                    
                            
                        
                    }
                    
         return (opc1)&(opc);
         
        }
            
            
            
        }




