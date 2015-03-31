/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodatos2;

import java.io.*;

/**
 *
 * @author Manuel
 */


//----------------------------------------------CLASE VEHÍCULO--------------------------------------------
class Vehiculo {

    String placa, modelo, marca, color;
    int año = 0;

    public void almacenar() {

        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduzca los datos del vehículo: ");

        System.out.print("Introduzca la placa: ");
         try {
                          
             placa = lee.readLine();
                      }
         catch  (Exception e){
                          
             System.out.print("Placa invalida ");
                          
              }

        System.out.print("Introduzca el año: ");
        while (año == 0) {
            try {
                año = Integer.parseInt(lee.readLine());

            } catch (Exception e) {
                System.out.print("año invalido ");
            }
        }


        System.out.print("Introduzca el modelo: ");
            try {
                          
                modelo = lee.readLine();
                }
            catch  (Exception e){
                          
                System.out.print("modelo invalido ");
                          
            }

        System.out.print("Introduzca la marca: ");
            try {
                          
                marca = lee.readLine();
                }
            catch  (Exception e){
                          
                System.out.print("marca invalida ");
                          
            }

        System.out.print("Introduzca el color: ");
        try {
                          
            color = lee.readLine();
            }
        catch  (Exception e){
                          
            System.out.print("color invalido ");
                          
            }

    }

    public void modificar() {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        int modif = 0;

        while (modif != 6) {

            
            System.out.println("Presione 1 para modificar la placa");
            System.out.println("Presione 2 para modificar el año");
            System.out.println("Presione 3 para modificar el modelo");
            System.out.println("Presione 4 para modificar la marca");
            System.out.println("Presione 5 para modificar el color");
            System.out.println("Presione 6 para salir");
            System.out.println(" ");
            System.out.print("¿Qué desea hacer?: ");

            
                try {
                    modif = Integer.parseInt(lee.readLine());

                } catch (Exception e) {
                    System.out.print("Opcion invalida ");
                }
            
            System.out.println(" ");
            switch (modif) {






            
            case 1: System.out.print("Introduzca la placa: ");
                        
                      try {
                          
                          placa = lee.readLine();
                      }
                      catch  (Exception e){
                          
                          System.out.print("Placa invalida ");
                          
                      }
                      
                    
              break;

            case 2: System.out.print("Introduzca el año: ");
            while (año >= 0) {
                try{
                    año = Integer.parseInt(lee.readLine());

                } catch (Exception e) {
                    System.out.print("año invalido ");
                }
            }
            break;

            case 3: System.out.print("Introduzca el modelo: ");
            
            
                      try {
                          
                          modelo = lee.readLine();
                      }
                      catch  (Exception e){
                          
                          System.out.print("modelo invalido ");
                          
                      }
            
            break;      
                                  

            case 4: System.out.print("Introduzca la marca: ");
                      
                      try {
                          
                          marca = lee.readLine();
                      }
                      catch  (Exception e){
                          
                          System.out.print("marca invalida ");
                          
                      }          
            
            
            break;
               
                  
            case 5: System.out.print("Introduzca el color: ");
            
                      try {
                          
                          color = lee.readLine();
                      }
                      catch  (Exception e){
                          
                          System.out.print("color invalido ");
                          
                      }
            
                      
            break;

            case 6: System.out.print("Presione una tecla para ir al menu... ");

            break;

        
            default: System.out.print("Datos invalidos, coloque un numero entre el 1 y 6: ");

                    
            break;  
                
            

            }

            System.out.println(" ");

        }
    }
}

//----------------------------------------CLASE CARGA (Hija de Vehiculo)--------------------------------------------

class Carga extends Vehiculo {
    
    
    float cap_kilos, cap_metros;
    
    
    public void almacenar_car (){
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));      
        
        almacenar();
        
        System.out.print("Coloque la capacidad en kilos: ");
        
        try {
                cap_kilos = Integer.parseInt(lee.readLine());

            } catch (Exception e) {
                System.out.print("Valor invalido ");
            }
        
        System.out.print("Coloque la capacidad en metros: ");
        
        try {
                cap_metros = Integer.parseInt(lee.readLine());

            } catch (Exception e) {
                System.out.print("Valor invalido ");
            }
        
    }
    
    
    
}


//----------------------------------------CLASE CAMIONETA (Hija de Vehiculo)--------------------------------------------

class Camioneta extends Vehiculo {
    
    
    boolean Sincronico;
    
    
    public void almacenar_cam (){
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));      
        
       String sincr="";
       almacenar();
        
       System.out.print ("¿Es sincrónico o automático? (a=sincronico; b=automatico): ");
        
       try {
                          
             sincr = lee.readLine();
           }
       catch  (Exception e)
           {
                          
             System.out.print("Invalido ");
                          
           }
       
       if (sincr.equals ("a"))
       {
           
           Sincronico=true;  
           
       }
       else
       {
       
           Sincronico=false;
           
       }
       
    }
    
    
    
}

//----------------------------------------CLASE LIVIANO (Hija de Vehiculo)--------------------------------------------

class Liviano extends Vehiculo {
    
    
    int asientos;
    
    
    public void almacenar_liv (){
        
       BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));      
        
       almacenar();
        
       System.out.print ("Coloque la cantidad de asientos: ");
       
       try 
       {
          asientos = Integer.parseInt(lee.readLine());
       }
       catch (Exception e) 
       {
          System.out.print("numero invalido ");
       }
               
               
       
       
    }
    
       
    
    
}


//----------------------------------------CLASE ARREGLO_CARGA (Asociado con Carga)--------------------------------------------







//----------------------------------------------ALGORITMO PRINCIPAL--------------------------------------------


public class Proyectodatos2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Carga vehiculo_carga = new Carga();
        Camioneta vehiculo_camioneta = new Camioneta();
        Liviano vehiculo_liviano = new Liviano();   
        int a=0;
       do{
        
        vehiculo_carga.almacenar_car();
        
        System.out.println("Placa: "+vehiculo_carga.placa);
        
        System.out.println("Año: "+vehiculo_carga.año);
        
        System.out.println("Color: "+vehiculo_carga.color);
        
        System.out.println();
        
        System.out.println();
        
        System.out.println();
        
        System.out.println();
        
         a=a+1;
        
        
            }while(a!=2);



    }
}
