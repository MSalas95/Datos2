 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;
import java.io.*;
import java.util.*;
/**
 *
 * @author Manuel
 */

//----------------------------------------------CLASE VEHÍCULO------------------------------------------------------
class Vehiculo {

    String placa="", modelo, marca, color;
    int año;

    public void almacenar() {                                                                                               

        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduzca los datos del vehículo: ");


        
        while (año == 0) {
            
            System.out.print("Introduzca el año: ");
        
            try 
            {
                año = Integer.parseInt(lee.readLine());
            } 
            catch (Exception e) 
            {
                System.out.println("Debe introducir un numero. ");
            }
        }



        System.out.print("Introduzca el color: ");
        try 
        {
            color = lee.readLine();
        }
        catch  (Exception e)
        {
            System.out.print("color invalido ");
        }

    }

    public void modificar() {
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        int modif=0;

        while (modif != 6){
            
            modif=0;
            
            System.out.println("Presione 1 para modificar el año");
            System.out.println("Presione 2 para modificar el color");
            System.out.println("Presione 3 para ir atras.");
            
            while (modif==0)
            {
                System.out.print("¿Qué desea hacer?: ");
                try 
                {
                    modif = Integer.parseInt(lee.readLine());
                } 
                catch (Exception e) 
                {
                    System.out.println("Opcion invalida, coloque un numero. ");
                }
            }
                        
            System.out.println(" ");
            
            
            switch (modif) 
                   {      
                       case 1: System.out.print("Introduzca el año: ");
                     
                               while (año >= 0) 
                               {
                                   try
                                   {
                                       año = Integer.parseInt(lee.readLine());
                                   } 
                                   catch (Exception e) 
                                   {
                                       System.out.print("Debe introducir un numero. ");
                                   }
                               }
                               break;
                        

                       case 2: System.out.print("Introduzca el color: ");
            
                               try 
                               {
                                   color = lee.readLine();
                               }
                               catch  (Exception e)
                               {
                                   System.out.print("color invalido ");
                               }
                               break;
                         

                       case 3: 
                               break;

        
                       default: System.out.print("Datos invalidos, coloque un numero entre el 1 y 3: ");

                                break;  
                   }

            System.out.println(" ");

        }
    }
}
    
//----------------------------------------CLASE CARGA (Hija de Vehiculo)--------------------------------------------

class Carga extends Vehiculo {
    
    double cap_kilos, cap_metros;
    
    public void almacenar_car (){
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));      
        
        almacenar();
        
        while (cap_kilos==0){ 
            
            System.out.print("Coloque la capacidad en kilos: ");
            try 
            {
                cap_kilos = Double.parseDouble(lee.readLine());
            } 
            catch (Exception e) 
            {
                System.out.println("Debe introducir un numero. ");
            }
        }
        
        while (cap_metros==0){ 
            
            System.out.print("Coloque la capacidad en metros: ");
            try 
            {
                cap_metros = Double.parseDouble(lee.readLine());
            } 
            catch (Exception e) 
            {
                System.out.println("Debe introducir un numero.");
            }
        } 
    }
    
}


//----------------------------------------CLASE CAMIONETA (Hija de Vehiculo)--------------------------------------------

class Camioneta extends Vehiculo {
    
    String Sincronico;
    
    public void almacenar_cam (){
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));      
        
        String sincr="";
        almacenar();
        
        while (!(sincr.equals("a")) & !(sincr.equals("b"))){
            
            System.out.print ("¿Es sincrónico o automático? (a=sincronico; b=automatico): ");
            try 
            {
                sincr= lee.readLine();
            }
            catch  (Exception e)
            {
                System.out.print("Invalido ");
            }
        }
        
        
        if (sincr.equals ("a")){
           
            Sincronico="a";  
           
        } else {
       
            Sincronico="b";
           
          }
       
    }
    
}



//----------------------------------------CLASE LIVIANO (Hija de Vehiculo)--------------------------------------------

class Liviano extends Vehiculo {
    
    int asientos;
    
    public void almacenar_liv (){
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));      
        
        almacenar();
        
        while (asientos==0){
            
            System.out.print ("Coloque la cantidad de asientos: ");       
            try 
            {
                asientos = Integer.parseInt(lee.readLine());
            }
            catch (Exception e) 
            {
                System.out.println("Debe introducir un numero. ");
            }
        }   
    }
}


//--------------------------------------------- CLASE ARREGLO CARGA -----------------------------------------------------------

class Arreglo_carga {
    Carga arr_carga[]= new Carga[15];
    
    public void instanciar_car() {
        int i;
        
        for (i=0; i<15;i++) {
            arr_carga[i]= new Carga();
        }
    }

    public int buscar_placa(String placa) {
        int i;
        
        for (i=0;i<=14;i++) {
            if (arr_carga[i].placa.equals(placa)){
                return i;
            }
        }
        return -1;

   }

    public void eliminar_car(Arreglo_grupo obj) {
        int i=0;
        String placa="";
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
       while (placa.equals("")){
            System.out.print("Coloque la placa del vehiculo que desea eliminar: ");
            try 
            {
            placa = lee.readLine();
            }
            catch (Exception e) 
            {
                System.out.println("Placa Invalida ");
            }
            
        }
        
        i=buscar_placa(placa);
        if (i>=0) {
            String marca= arr_carga[i].marca;
            String modelo= arr_carga[i].modelo;
            if (obj.arr_grupo[obj.buscar_MM(marca,modelo)].disponibles!=0){
                arr_carga[i].placa="";
            
                obj.arr_grupo[obj.buscar_MM(marca,modelo)].existencia = obj.arr_grupo[obj.buscar_MM(marca,modelo)].existencia -1;
                obj.arr_grupo[obj.buscar_MM(marca,modelo)].disponibles = obj.arr_grupo[obj.buscar_MM(marca,modelo)].disponibles -1;
                System.out.println("Se ha eliminado el Vehículo.");
                System.out.println(" ");
            } else{
                 System.out.println("No hay vehiculos disponibles para eliminar.");
                 System.out.println(" ");
                }
        } else {
            System.out.println("No se encuentra el vehiculo.");
            System.out.println(" ");
          }
        
    }  
    
    public int buscar_vacio(){
       int i;
        for ( i=0; i<=14; i++) {
            
            if (arr_carga[i].placa.equals("")){
                return i;
                                        
            }
        }
        return -1;
        
    }
    
    public void modificar_car() {
        int i=0;
        String placa="";
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while (placa.equals("")){
            System.out.println("Coloque la placa del vehiculo que desea modificar: ");
            try 
            {
                placa = lee.readLine();
            }
            catch (Exception e) 
            {
                System.out.println("Placa Invalida ");
            }
            
        }
        
        i=buscar_placa(placa);
        if (i>=0) {
           arr_carga[i].modificar();
        }
        else {
            System.out.println("No se encuentra el vehiculo");
        }
    }
    
    public void almacenar (Arreglo_grupo obj){
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        String placa ="", marca ="", modelo= "";
        int i;
        
        
        if (buscar_vacio()>=0) {
                
            System.out.print("Coloque la placa del vehiculo: ");
            try 
            {
                placa = lee.readLine();
            }
                catch (Exception e) 
            {
                System.out.println("Placa Invalida ");
            }
        
            if (buscar_placa(placa)<0){
                
               
                try 
                {   
                    System.out.print("Indique la marca del vehiculo: ");
                    marca = lee.readLine();
                    System.out.print("Indique del modelo del vehiculo: ");
                    modelo = lee.readLine();
                }
                    catch (Exception e) 
                {
                    System.out.println("Datos invalidos ");
                }
                  i=buscar_vacio();
                if (obj.buscar_MM(marca,modelo) >= 0) {
                    
                    if (i>=0) {
                        arr_carga[i].almacenar_car();
                        arr_carga[i].placa = placa;
                        arr_carga[i].marca = marca;
                        arr_carga[i].modelo = modelo;
                    
                        obj.arr_grupo[obj.buscar_MM(marca,modelo)].existencia = obj.arr_grupo[obj.buscar_MM(marca,modelo)].existencia +1;
                        obj.arr_grupo[obj.buscar_MM(marca,modelo)].disponibles = obj.arr_grupo[obj.buscar_MM(marca,modelo)].disponibles +1;
                    
                        System.out.println("Se ha almacenado el vehículo en el grupo de los "+obj.arr_grupo[obj.buscar_MM(marca,modelo)].marca+" "+ obj.arr_grupo[obj.buscar_MM(marca,modelo)].modelo+".");
                        System.out.println("El codigo del grupo donde se almacenó el vehiculo es: "+obj.arr_grupo[obj.buscar_MM(marca,modelo)].codigo+".");
                        System.out.println("");
                    }
                } else {
                    int v= obj.buscar_vacio();
                    if (v >= 0) {
                      
                      System.out.println("Se debe crear un nuevo grupo para almacenar el vehiculo. Ingrese los siguientes datos: ");
                      obj.almacenar(modelo,marca);
                      
                      arr_carga[i].almacenar_car();
                      arr_carga[i].placa = placa;
                      arr_carga[i].marca = marca;
                      arr_carga[i].modelo = modelo;
                      
                      obj.arr_grupo[v].existencia = obj.arr_grupo[obj.buscar_vacio()].existencia +1;
		      obj.arr_grupo[v].disponibles = obj.arr_grupo[v].disponibles +1;
                      System.out.println("Se ha almacenado el grupo  "+obj.arr_grupo[v].nombre+". Que contiene "+obj.arr_grupo[v].marca+" "+obj.arr_grupo[v].modelo);
                      System.out.println("El codigo del grupo es: "+obj.arr_grupo[obj.buscar_MM(marca,modelo)].codigo+".");
                      System.out.println("");
                  } else {
                        
                        System.out.println("No hay espacio para almacenar mas grupos.");
                        
                    }
                
                 }
        
            
            } else {
                
                System.out.print("La placa ya se encuentra almacenada.");
            }
            
            
            
        } else {
            
            System.out.print("No se pueden almacenar mas vehiculos de carga");
            
          } 
            
            
        
    }
    
}

//--------------------------------------------------------CLASE ARREGLO CAMIONETA------------------------------------------


class Arreglo_camioneta {
    Camioneta arr_camioneta[]= new Camioneta[80];
    
    public void instanciar_cam() {
        int i;
        
        for (i=0; i<=79;i++) {
            arr_camioneta[i]= new Camioneta();
        }
    }

    public int buscar_placa(String placa) {
        int i;
        
        for (i=0;i<=79;i++) {
            if (arr_camioneta[i].placa.equals(placa)){
                return i;
            }
        }
        return -1;

   }

    public void eliminar_cam(Arreglo_grupo obj) {
        int i=0;
        String placa="";
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
       while (placa.equals("")){
            System.out.print("Coloque la placa del vehiculo que desea eliminar: ");
            try 
            {
            placa = lee.readLine();
            }
            catch (Exception e) 
            {
                System.out.println("Placa Invalida ");
            }
            
        }
        
        i=buscar_placa(placa);
        if (i>=0) {
           
            String marca= arr_camioneta[i].marca;
            String modelo= arr_camioneta[i].modelo;
            if (obj.arr_grupo[obj.buscar_MM(marca,modelo)].disponibles!=0){
                arr_camioneta[i].placa="";
            
                obj.arr_grupo[obj.buscar_MM(marca,modelo)].existencia = obj.arr_grupo[obj.buscar_MM(marca,modelo)].existencia -1;
                obj.arr_grupo[obj.buscar_MM(marca,modelo)].disponibles = obj.arr_grupo[obj.buscar_MM(marca,modelo)].disponibles -1;
                System.out.println("Se ha eliminado el Vehículo.");
                System.out.println(" ");
            } else{
                 System.out.println("No hay vehiculos disponibles para eliminar.");
                 System.out.println(" ");
                }
        
        } else {
            System.out.println("No se encuentra el vehiculo.");
            System.out.println(" ");
          }
        
    }  
    
    public int buscar_vacio(){
        
        for (int i=0; i<=79; i++) {
            
            if (arr_camioneta[i].placa.equals("")){
                return i;
            }
        }
        return -1;
        
    }
    
    public void modificar_cam() {
        int i=0;
        String placa="";
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while (placa.equals("")){
            System.out.println("Coloque la placa del vehiculo que desea modificar: ");
            try 
            {
                placa = lee.readLine();
            }
            catch (Exception e) 
            {
                System.out.println("Placa Invalida ");
            }
            
        }
        
        i=buscar_placa(placa);
        if (i>=0) {
           arr_camioneta[i].modificar();
        }
        else {
            System.out.println("No se encuentra el vehiculo");
        }
    }
    
    public void almacenar (Arreglo_grupo obj){
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        String placa ="", marca ="", modelo= "";
        int i;
        
        
        if (buscar_vacio()>=0) {
                
            System.out.print("Coloque la placa del vehiculo: ");
            try 
            {
                placa = lee.readLine();
            }
                catch (Exception e) 
            {
                System.out.println("Placa Invalida ");
            }
        
            if (buscar_placa(placa)<0){
                
               
                try 
                {   
                    System.out.print("Indique la marca del vehiculo: ");
                    marca = lee.readLine();
                    System.out.print("Indique del modelo del vehiculo: ");
                    modelo = lee.readLine();
                }
                    catch (Exception e) 
                {
                    System.out.println("Datos invalidos ");
                }
                 i=buscar_vacio();
                if (obj.buscar_MM(marca,modelo) >= 0) {
                    
                   
                    if (i>=0){
                        arr_camioneta[i].almacenar_cam();
                        arr_camioneta[i].placa = placa;
                        arr_camioneta[i].marca = marca;
                        arr_camioneta[i].modelo = modelo;
                    
                        obj.arr_grupo[obj.buscar_MM(marca,modelo)].existencia = obj.arr_grupo[obj.buscar_MM(marca,modelo)].existencia +1;
                        obj.arr_grupo[obj.buscar_MM(marca,modelo)].disponibles = obj.arr_grupo[obj.buscar_MM(marca,modelo)].disponibles +1;
                    
                        System.out.println("Se ha almacenado el vehículo en el grupo de los "+obj.arr_grupo[obj.buscar_MM(marca,modelo)].marca+" "+ obj.arr_grupo[obj.buscar_MM(marca,modelo)].modelo+".");
                        System.out.println("El codigo del grupo donde se almacenó el vehiculo es: "+obj.arr_grupo[obj.buscar_MM(marca,modelo)].codigo+".");
                        System.out.println("");
                    }
                } else {
                    int v= obj.buscar_vacio();
                    if (v >= 0) {
                      
                      System.out.println("Se debe crear un nuevo grupo para almacenar el vehiculo. Ingrese los siguientes datos: ");
                      obj.almacenar(modelo,marca);
                      
                      arr_camioneta[i].almacenar_cam();
                      arr_camioneta[i].placa = placa;
                      arr_camioneta[i].marca = marca;
                      arr_camioneta[i].modelo = modelo;
                      
                      obj.arr_grupo[v].existencia = obj.arr_grupo[obj.buscar_vacio()].existencia +1;
		      obj.arr_grupo[v].disponibles = obj.arr_grupo[v].disponibles +1;
                      System.out.println("Se ha almacenado el grupo  "+obj.arr_grupo[v].nombre+". Que contiene "+obj.arr_grupo[v].marca+" "+obj.arr_grupo[v].modelo);
                      System.out.println("El codigo del grupo es: "+obj.arr_grupo[obj.buscar_MM(marca,modelo)].codigo+".");
                      System.out.println("");
                  } else {
                        
                        System.out.println("No hay espacio para almacenar mas grupos.");
                        
                    }
                
                 }
        
            
            } else {
                
                System.out.print("La placa ya se encuentra almacenada.");
            }
            
            
            
        } else {
            
            System.out.print("No se pueden almacenar mas camionetas");
            
          } 
            
            
        
    }
    
}


//--------------------------------------------------------CLASE ARREGLO LIVIANO------------------------------------------

class Arreglo_liviano {
    Liviano[] arr_liviano= new Liviano[300];
    
    public void instanciar_liv() {
        int i;
        
        for (i=0; i<=299;i++) {
            arr_liviano[i]= new Liviano();
        }
    }

    public int buscar_placa(String placa) {
        int i;
        
        for (i=0;i<=299;i++) {
            if (arr_liviano[i].placa.equals(placa)){
                return i;
            }
        }
        return -1;

   }

    public void eliminar_liv(Arreglo_grupo obj) {
        int i=0;
        String placa="";
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
       while (placa.equals("")){
            System.out.print("Coloque la placa del vehiculo que desea eliminar: ");
            try 
            {
            placa = lee.readLine();
            }
            catch (Exception e) 
            {
                System.out.println("Placa Invalida ");
            }
            
        }
        
        i=buscar_placa(placa);
        if (i>=0) {
            String marca= arr_liviano[i].marca;
            String modelo= arr_liviano[i].modelo;
            if (obj.arr_grupo[obj.buscar_MM(marca,modelo)].disponibles!=0){
                arr_liviano[i].placa="";
            
                obj.arr_grupo[obj.buscar_MM(marca,modelo)].existencia = obj.arr_grupo[obj.buscar_MM(marca,modelo)].existencia -1;
                obj.arr_grupo[obj.buscar_MM(marca,modelo)].disponibles = obj.arr_grupo[obj.buscar_MM(marca,modelo)].disponibles -1;
                System.out.println("Se ha eliminado el Vehículo.");
                System.out.println(" ");
            } else{
                 System.out.println("No hay vehiculos disponibles para eliminar.");
                 System.out.println(" ");
                }
        
        } else {
            System.out.println("No se encuentra el vehiculo.");
            System.out.println(" ");
          }
        
    }  
    
    public int buscar_vacio(){
        
        for (int i=0; i<=299; i++) {
            
            if (arr_liviano[i].placa.equals("")){
                return i;
            }
        }
        return -1;
        
    }
    
    public void modificar_liv() {
        int i=0;
        String placa="";
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while (placa.equals("")){
            System.out.println("Coloque la placa del vehiculo que desea modificar: ");
            try 
            {
                placa = lee.readLine();
            }
            catch (Exception e) 
            {
                System.out.println("Placa Invalida ");
            }
            
        }
        
        i=buscar_placa(placa);
        if (i>=0) {
           arr_liviano[i].modificar();
        }
        else {
            System.out.println("No se encuentra el vehiculo");
        }
    }
    
    public void almacenar (Arreglo_grupo obj){
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        String placa ="", marca ="", modelo= "";
        int i;
        
        
        if (buscar_vacio()>=0) {
                
            System.out.print("Coloque la placa del vehiculo: ");
            try 
            {
                placa = lee.readLine();
            }
                catch (Exception e) 
            {
                System.out.println("Placa Invalida ");
            }
        
            if (buscar_placa(placa)<0){
                
               
                try 
                {   
                    System.out.print("Indique la marca del vehiculo: ");
                    marca = lee.readLine();
                    System.out.print("Indique del modelo del vehiculo: ");
                    modelo = lee.readLine();
                }
                    catch (Exception e) 
                {
                    System.out.println("Datos invalidos ");
                }
                i=buscar_vacio();
                if (obj.buscar_MM(marca,modelo) >= 0) {
                     
                   
                    if (i>=0){
                        arr_liviano[i].almacenar_liv();
                        arr_liviano[i].placa = placa;
                        arr_liviano[i].marca = marca;
                        arr_liviano[i].modelo = modelo;
                    
                        obj.arr_grupo[obj.buscar_MM(marca,modelo)].existencia = obj.arr_grupo[obj.buscar_MM(marca,modelo)].existencia +1;
                        obj.arr_grupo[obj.buscar_MM(marca,modelo)].disponibles = obj.arr_grupo[obj.buscar_MM(marca,modelo)].disponibles +1;
                    
                        System.out.println("Se ha almacenado el vehículo en el grupo de los "+obj.arr_grupo[obj.buscar_MM(marca,modelo)].marca+" "+ obj.arr_grupo[obj.buscar_MM(marca,modelo)].modelo+".");
                        System.out.println("El codigo del grupo donde se almacenó el vehiculo es: "+obj.arr_grupo[obj.buscar_MM(marca,modelo)].codigo+".");
                        System.out.println("");
                    }
                } else {
                    int v= obj.buscar_vacio();
                    if (v >= 0) {
                      
                      System.out.println("Se debe crear un nuevo grupo para almacenar el vehiculo. Ingrese los siguientes datos: ");
                      obj.almacenar(modelo,marca);
                      
                      arr_liviano[i].almacenar_liv();
                      arr_liviano[i].placa = placa;
                      arr_liviano[i].marca = marca;
                      arr_liviano[i].modelo = modelo;
                      
                      obj.arr_grupo[v].existencia = obj.arr_grupo[obj.buscar_vacio()].existencia +1;
		      obj.arr_grupo[v].disponibles = obj.arr_grupo[v].disponibles +1;
                      System.out.println("Se ha almacenado el grupo  "+obj.arr_grupo[v].nombre+". Que contiene "+obj.arr_grupo[v].marca+" "+obj.arr_grupo[v].modelo);
                      System.out.println("El codigo del grupo es: "+obj.arr_grupo[obj.buscar_MM(marca,modelo)].codigo+".");
                      System.out.println("");
                  } else {
                        
                        System.out.println("No hay espacio para almacenar mas grupos.");
                        
                    }
                
                 }
        
            
            } else {
                
                System.out.print("La placa ya se encuentra almacenada.");
            }
            
            
            
        } else {
            
            System.out.print("No se pueden almacenar vehiculos livianos.");
            
          } 
            
            
        
    }
    
}

//--------------------------------------------------------CLASE GRUPO------------------------------------------
    
class Grupo {
    int codigo=0, disponibles, existencia;
    String nombre,marca="",modelo="";
    Double costo;
    
    
    public void almacenar() {
        costo=0.0;
        nombre="";
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        while (nombre.equals("")) {
            System.out.print("Introduzca el nombre del grupo: ");
            try 
            {
                nombre= lee.readLine();
            } 
            catch (Exception e) 
            {
                System.out.println("Nombre invalido ");
            }
        }
        
        while (costo== 0) {
            System.out.print("Introduzca el costo por dia del grupo: ");
            
            try 
            {
                costo = Double.parseDouble(lee.readLine());
            }
            catch (Exception e)
            {
                System.out.println("Costo invalido ");
            }
        }
       
    }
    
    public void modificar() {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        int modif=0;
       while (modif != 3) {

            System.out.print("¿Qué desea hacer?: ");
            System.out.println(" ");
            System.out.println("Presione 1 para modificar el Nombre");
            System.out.println("Presione 2 para modificar el Costo");
            System.out.println("Presione 3 para salir");
            System.out.print("Coloque su opcion: ");
                try 
                {   
                    modif = Integer.parseInt(lee.readLine());
                } 
                catch (Exception e) 
                {
                    System.out.println("Opcion invalida ");
                }
            
            System.out.println(" ");
            switch (modif) {

            case 1: System.out.print("Introduzca el nombre: ");
            
                    
                        try 
                        {
                            nombre= lee.readLine();
                        }
                        catch  (Exception e)
                        {
                            System.out.println("Nombre invalido ");
                        }
                    
                        
                    break;

            case 2: System.out.print("Introduzca el Costo: ");
            
                try{
                    costo =Double.parseDouble(lee.readLine());

                } catch (Exception e) {
                    System.out.println("Costo Invalido ");
                }
                
            break;
                
            default: System.out.println("Datos invalidos, coloque un numero entre el 1 y 3: ");
     
            break;  
                
            }

            System.out.println(" ");

        }
        
    }
    
    public void mostrar(){
        System.out.print("Nombre: ");
        System.out.println(nombre);
        System.out.print("Codigo: "); 
        System.out.println(codigo);
        System.out.print("Marca: ");
        System.out.println(marca);
        System.out.print("Modelo: ");
        System.out.println(modelo);
        System.out.print("Costo.: ");
        System.out.println(costo);
        System.out.print("Disponibles: ");
        System.out.println(disponibles);
        System.out.print("Existencia: ");
        System.out.println(existencia);
    }
}
    
//--------------------------------------------- CLASE ARREGLO GRUPO-----------------------------------------

class Arreglo_grupo {
    Grupo arr_grupo[]= new Grupo[50];
    
   public void instanciar() {
        int i;
        
        for(i=0; i<50; i++){
            arr_grupo[i]= new Grupo();
            
        }
    }
    
   public int buscar_cod(int cod) {
    int i;
       
        for (i=0; i<=49; i++){
            if (arr_grupo[i].codigo==cod) {
                return i;
            }
        }
    return -1;
   }
   
   public int buscar_vacio() {
       int i;
       
       for (i=0; i<=49; i++) {
           if (arr_grupo[i].codigo==0) {
               return i;
           }
       }
       return-1;
      
   }
   
   public void almacenar(String modelo, String marca) {
       int i=0;
       
       i=buscar_vacio();
       if (i>=0) {
           arr_grupo[i].almacenar();
           arr_grupo[i].modelo = modelo;
	   arr_grupo[i].marca = marca;
           int codigo;
           Random cod = new Random();
           
           do {
               arr_grupo[i].codigo=0;
               codigo=100+cod.nextInt(900);
               
           }while (buscar_cod(codigo)>0);
           
           arr_grupo[i].codigo= codigo;
           
           System.out.println("El Codigo asignado al grupo "+arr_grupo[i].nombre+" es: "+arr_grupo[i].codigo);
           System.out.println("");
       } else {
           System.out.println("No es Posible almacenar mas grupos");
         }
   }
   
   public void eliminar(){
        int cod=0;
        String seguro="";
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while (cod== 0) {
            System.out.print("Coloque el codigo del grupo que desea eliminar: ");
            try 
            {
                cod= Integer.parseInt(lee.readLine());
            }
            catch (Exception e) 
            {
                System.out.println("Codigo invalido, ingrese numeros. ");
            }
        }
        if (buscar_cod(cod)<0){
           System.out.println("El grupo no se encuentra almacenado");
         } else {
            if (arr_grupo[buscar_cod(cod)].existencia ==0) {
                    
               while ((!((seguro.equals("s")) || (seguro.equals("S")))) && (!(seguro.equals("n")) || (seguro.equals("N")))) {
                 System.out.println("Esta seguro que desea eliminar el grupo? (S/N)");
                     try 
                     {   
                         seguro= lee.readLine();
                     }
                     catch  (Exception e)
                     {
                         System.out.println("Opcion invalida "); 
                     }
              }
               
              if ((seguro.equals("s")) || (seguro.equals("S"))){
                  arr_grupo[buscar_cod(cod)].modelo="";
                  arr_grupo[buscar_cod(cod)].marca="";
                  arr_grupo[buscar_cod(cod)].codigo=0;
                  System.out.println("El grupo ha sido Eliminado");
                  
                  } else {
                     System.out.println("No se ha eliminado ningun grupo");
                  }
              }
              else {
                 System.out .println("No se puede eliminar un grupo que tenga vehiculos almacenados");
              }
                
          }
    }
    
   public void modificar(){
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        int cod= 0;
        while (cod== 0) {
            System.out.print("Coloque el codigo del grupo que desea modificar: ");
            try 
            {
                cod= Integer.parseInt(lee.readLine());
            }
            catch (Exception e) 
            {
                System.out.print("Codigo invalido ");
            }
        }
        
        if (buscar_cod(cod)<0){
           System.out.println("El grupo no se encuentra almacenado");
         } else {
            
            arr_grupo[buscar_cod(cod)].modificar();
        
        }
        
    }
    
   public int buscar_MM(String marca,String modelo){
       
       for (int i= 0 ; i<=49; i++){
           
           if ((arr_grupo[i].marca.equals(marca)) && (arr_grupo[i].modelo.equals(modelo))) {
           return i;
                    
          }
       }
       return -1;
   }
   
   public void mostrar_grupos(){
       
       for (int i=0; i<50; i++){
           if (arr_grupo[i].codigo>0){
          
          System.out.println("Grupo"+(i+1)+":");
          arr_grupo[i].mostrar();
          System.out.println("");
          
          }
           
                    
       }
       if (buscar_vacio()==0){
             System.out.println(""); 
             System.out.println("No hay grupos que mostrar"); 
             System.out.println("");  
          }
   }
    
    
}

//--------------------------------------------- CLASE CLIENTE -----------------------------------------------------------     

class Cliente {
    int cedula=0, edad=0;
    String nombre="", apellido="", direccion="", telefono="";
    
    public void almacenar() { 
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Introduzca los siguientes datos: ");
        while (cedula == 0) {
            System.out.print("Introduzca la cedula: ");
            try 
            {
                cedula = Integer.parseInt(lee.readLine());
            } 
            catch (Exception e) 
            {
                System.out.println("Cedula invalida ");
            }
        }
        while (edad == 0) {
            System.out.print("Introduzca la Edad: ");
            try 
            {
                edad = Integer.parseInt(lee.readLine());
            } 
            catch (Exception e) 
            {
                System.out.println("Edad invalid ");
            }
        }
        while (nombre.equals("")) {
            System.out.print("Introduzca el Nombre: ");
            try {
                          
             nombre= lee.readLine();
           }
            catch  (Exception e){
                          
                System.out.println("Nombre invalido ");
                          
              }
        }
        while (apellido.equals("")) {
            System.out.print("Introduzca el Apellido: ");
            try {   
                      
             apellido= lee.readLine();
            }
            catch  (Exception e){
                          
             System.out.println("Apellido invalido ");
                          
            }
        }
        while (direccion.equals("")) {
            System.out.print("Introduzca la Dirección: ");
            try {
                          
             direccion = lee.readLine();
            }
            catch  (Exception e){
                          
             System.out.println("Dirección invalida ");
                          
            }
        }
        while (telefono.equals("")) {
            System.out.print("Introduzca el Telefono: ");
            try {
                          
             telefono= lee.readLine();
           }
            catch  (Exception e){
                          
             System.out.println("Telefono invalido ");
                          
           }
        }
    }
    public void modificar(){
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        int modif=0;
       while (modif != 6) {

            System.out.print("¿Qué desea hacer?: ");
            System.out.println(" ");
            System.out.println("Presione 1 para modificar la edad");
            System.out.println("Presione 2 para modificar el nombre");
            System.out.println("Presione 3 para modificar el apellido");
            System.out.println("Presione 4 para modificar la dirección");
            System.out.println("Presione 5 para modificar el telefono");
            System.out.println("Presione 6 para salir");
            
                try 
                {
                    modif = Integer.parseInt(lee.readLine());

                } catch (Exception e) 
                {
                    System.out.println("Opcion invalida ");
                }
            
            System.out.println(" ");
            switch (modif) {

            case 1: System.out.print("Introduzca la edad: ");
            
                    
                      try 
                      {
                          
                          edad = Integer.parseInt(lee.readLine());
                      }
                      catch  (Exception e)
                      {
                          
                          System.out.println("Edad invalida ");
                          
                      }
                    
                        
              break;

            case 2: System.out.print("Introduzca el Nombre: ");
            
                try
                {
                    nombre =lee.readLine();

                } catch (Exception e) 
                {
                    System.out.println("Nombre Invalido ");
                }
                
            break;

            case 3: System.out.print("Introduzca el Apellido: ");
           
                      try 
                      {
                          
                          apellido= lee.readLine();
                      }
                      catch  (Exception e)
                      {
                          
                          System.out.println("Apellido invalido ");
                          
                      }
            break;      
          
            case 4: System.out.print("Introduzca la Dirección: ");
                      
                      try 
                      {
                      direccion= lee.readLine();
                      }
                      catch  (Exception e)
                      {
                      System.out.println("Dirección Invalida ");
                      }  
            
            break;
                 
            case 5: System.out.print("Introduzca el Telefono: ");
            
                      try 
                      {
                      telefono= lee.readLine();
                      }
                      catch  (Exception e)
                      {
                      System.out.println("Telefono Invalido ");
                      }      
            break;
                
            case 6: System.out.print("Presione una tecla para ir al menu... ");

            break;
                
            default: System.out.println("Datos invalidos, coloque un numero entre el 1 y 6: ");
     
            break;  
                
            }

            System.out.println(" ");

        }
    }
    
}

//--------------------------------------------- CLASE ARREGLO CLIENTES-----------------------------------------
class Arreglo_clientes {
    Cliente arr_client[]= new Cliente[500];
    
    public void instanciar(){
        int i;
        
        for (i=0; i<=499; i++){
            arr_client[i]= new Cliente();
        }
        
    }
    public void almacenar(){
        int i=0;
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while((arr_client[i].cedula !=0)&&(i<=499)){
          i=i+1;
        }
        if (i<=499){
            arr_client[i].almacenar();
        }
        else{
            System.out.println("No se puede almacenar mas clientes.");
        }
    }
    public int buscar_ced(int ced){
        int i=0;
        
        for (i=0; i<=49; i++){
            if (arr_client[i].cedula==ced) {
                return i;
            }
        }
         return -1;
    }
    public void modificar(){
        int i, ced=0;
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
            while (ced == 0){
                System.out.println("Introduzca la cedula del cliente que quiere modificar");
                try 
                {
                    ced = Integer.parseInt(lee.readLine());
                } 
                catch (Exception e) 
                {
                    System.out.println("Cedula invalida ");
                }
            }
            i= buscar_ced(ced);
            if (i!=-1){
                arr_client[i].modificar();
            }
            
    }
    public void eliminar(){
        int i, ced=0;
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while (ced== 0) {
            System.out.print("Introduzca la cedula del cliente que quiere eliminar: ");
            try 
            {
                ced = Integer.parseInt(lee.readLine());

            } catch (Exception e) {
                System.out.println("Cedula invalida ");
            }
        }
            i= buscar_ced(ced);
            if (i!=-1){
                arr_client[i].cedula=0;
                System.out.println("");
                System.out.println("El cliente ha sido eliminado. ");
                System.out.println("");
            } else {
                System.out.println("");
                System.out.println("No se encontro la cedula. ");
                System.out.println("");
            }
    }
    
    public int mas_65() {
        int i=0,cont=0;
        
        for (i=0; i<499; i++) {
            if (arr_client[i].edad>=65) {
                cont=cont+1;
            }
        }
        return cont;
    }
}

//--------------------------------------------- CLASE RESERVACIONES---------------------------------------------

class Reservaciones {
    String nombre_cli="";
    int ced_cli=0, cod_grupo=0;
    int fecha_res[]= new int[3];
    int fecha_deseo[]= new int[3];
    
    public void almacenar(Arreglo_clientes obj1, Arreglo_grupo obj2) {
       int dia=0, mes=0, ano=0;
       BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
       
            
       
       
       
       while (ced_cli==0) {
          System.out.print("Introduzca la cedula del cliente que desea hacer la reservacion: ");
              try {   
                 ced_cli=Integer.parseInt(lee.readLine());
              }
               catch  (Exception e){      
                   System.out.println("Cedula invalida "); 
               }
        }
       
       if (obj1.buscar_ced(ced_cli)<0) {
           System.out.print("El cliente no se encuentra almacenado. ");
           obj1.almacenar();
           System.out.println("");
           System.out.println("Cliente almacenado. ");
           System.out.println("");
           
       }
       
       while (cod_grupo==0) {
          System.out.print("Introduzca el codigo del grupo del que desea hacer la reservacion: ");
              try {   
                 cod_grupo=Integer.parseInt(lee.readLine());
              }
               catch  (Exception e){      
                   System.out.println("Codigo invalido "); 
               }
        }
       
       if (obj2.buscar_cod(cod_grupo)>=0) {
           
           System.out.println("Indique la fecha de hoy");
           while (fecha_res[0]==0) {
                 System.out.print("Dia: ");
                    try 
                    {   
                      
                      fecha_res[0]=Integer.parseInt(lee.readLine());
                      
                     }
                     catch  (Exception e){
                          
                       System.out.println("Dia invalido "); 
                     }
            }
           fecha_res[0]=dia;
           
            while (mes==0) {
               System.out.print("Mes: ");
                  try {   
                      
                    mes= Integer.parseInt(lee.readLine());
                    fecha_res[1]=mes;
                  }
                  catch  (Exception e){
                          
                  System.out.println("Mes invalido "); 
                  }
            }
            while (ano==0) {
               System.out.print("Año: ");
                 try {   
                      
                    ano= Integer.parseInt(lee.readLine());
                    fecha_res[2]=ano;
                 }
                 catch  (Exception e){
                          
                   System.out.println("Año invalido"); 
                 }
            }
            dia=0;
            mes=0;
            ano=0;
            System.out.println("Indique la fecha para la cual desea hacer la reservacion: ");
            while (dia==0) {
                 System.out.print("Dia: ");
                    try {   
                      
                      dia=Integer.parseInt(lee.readLine());
                      fecha_deseo[0]=dia;
                     }
                     catch  (Exception e){
                          
                       System.out.println("Dia invalido "); 
                     }
            }
            while (mes==0) {
               System.out.print("Mes: ");
                  try {   
                      
                    mes= Integer.parseInt(lee.readLine());
                    fecha_deseo[1]=mes;
                  }
                  catch  (Exception e){
                          
                  System.out.println("Mes invalido "); 
                  }
            }
            while (ano==0) {
               System.out.print("Año: ");
                 try {   
                      
                    ano= Integer.parseInt(lee.readLine());
                    fecha_deseo[2]=ano;
                 }
                 catch  (Exception e){
                          
                   System.out.println("Año invalido"); 
                 }
            }
            
            
            System.out.println("Se ha realizado la reservacion");
            System.out.println("");
       }
       else {
          System.out.println("El grupo no se encuentra almacenado"); 
          System.out.println("");
       }
       
    }
}

//--------------------------------------------- CLASE ARREGLO RESERVACIONES -----------------------------------------

class Arreglo_reservaciones {
    Reservaciones arr_reservaciones[] = new Reservaciones [25000];
    
    
    public void instanciar() {
        int i;
        
        for (i=0; i<=24999; i++) {
            arr_reservaciones[i]= new Reservaciones();
        }
    }
    
    public int buscar_deseo(int ced, int fecha[]) {
        int i;
        
        for (i=0; i<=24999; i++) {
            if (arr_reservaciones[i].fecha_deseo[0]==fecha[0]) {
                if (arr_reservaciones[i].fecha_deseo[1]==fecha[1]) {
                    if (arr_reservaciones[i].fecha_deseo[2]==fecha[2]) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    
    public void almacenar(Arreglo_clientes obj1, Arreglo_grupo obj2) {
        int i=0;
        
        while ((arr_reservaciones[i].ced_cli!=0) && (i<=24999)) {
            i=i+1;
        }
        
        if (i<=24999) {
            arr_reservaciones[i].almacenar(obj1, obj2);
        }
        else {
            System.out.println("No hay espacio para mas reservaciones");
            System.out.println("");
        }
    }
    
    public void eliminar() {
        int i, ced=0;
        int fecha[] = new int[3];
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while (ced==0) {
            System.out.print("Introduzca la cedula del cliente que realizo la reservacion: ");
            try 
            {   
                ced= Integer.parseInt(lee.readLine());
            }
            catch  (Exception e)
            {
                System.out.println("Cedula invalida"); 
            }
       }
           
       System.out.println("Coloque la fecha para cuando se realizo la reservacion");
       
       while (fecha[0]==0) {
           System.out.print("Dia: ");
           try 
           {   
               fecha[0]=Integer.parseInt(lee.readLine());
           }
           catch  (Exception e)
           {
               System.out.println("Dia invalido "); 
           }
       }
       while (fecha[1]==0) {
       System.out.print("Mes: ");
           try 
           {   
               fecha[1]= Integer.parseInt(lee.readLine());
           }
           catch  (Exception e)
           {
               System.out.println("Mes invalido "); 
           }
       }
       
       
       while (fecha[2]==0) {
       System.out.print("Año: ");
           try 
           {   
               fecha[2]= Integer.parseInt(lee.readLine());
           }
           catch  (Exception e)
           {
               System.out.println("Año invalido"); 
           }
       }
            for (i=0; i<24999; i++) {
            
                if (arr_reservaciones[i].ced_cli==ced) {
                    if (arr_reservaciones[i].fecha_deseo[0]==fecha[0]) {
                        if (arr_reservaciones[i].fecha_deseo[1]==fecha[1]) {
                            if (arr_reservaciones[i].fecha_deseo[2]==fecha[2]) {
                                arr_reservaciones[i].ced_cli=0;
                                i=30000;
                                System.out.println("Se ha eliminado la reservacion");
                                System.out.println("");
                            }
                        }
                    }
                }
            }
            
            if (i==24999) {
                System.out.println("");
                System.out.println("No se ha encontrado la reservacion");
                System.out.println("");
            }
    }
      
}

//--------------------------------------------- CLASE ALQUILER CARGA -----------------------------------------

class Alquiler_carga {
    int cedula=0, numero=0;
    String placa="";
    Double costo=0.0, kilom_inicial=0.0, kilom_final=0.0;
    int[] fecha_retiro= new int[3];
    int[] fecha_dev= new int[3];
    int[] fecha_DP = new int[3];
    BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
    
   public void almacenar(Arreglo_reservaciones obj1) {
    int i;
    int[] fecha =new int[3];
    
    
    while (cedula==0) {
            System.out.print("Introduzca la cedula: ");
            try {   
                      
               cedula= Integer.parseInt(lee.readLine());
             }
             catch  (Exception e){
                          
               System.out.println("Cedula invalida"); 
             }
          }
           System.out.println("Introduzca la fecha de hoy: ");
           while (fecha[0]==0) {
                 System.out.print("Dia: ");
                    try {   
                      
                      fecha[0]=Integer.parseInt(lee.readLine());
                     }
                     catch  (Exception e){
                          
                       System.out.println("Dia invalido "); 
                     }
            }
            while (fecha[1]==0) {
               System.out.print("Mes: ");
                  try {   
                      
                    fecha[1]= Integer.parseInt(lee.readLine());
                  }
                  catch  (Exception e){
                          
                  System.out.println("Mes invalido "); 
                  }
            }
            while (fecha[2]==0) {
               System.out.print("Año: ");
                 try {   
                      
                    fecha[2]= Integer.parseInt(lee.readLine());
                 }
                 catch  (Exception e){
                          
                   System.out.println("Año invalido"); 
                 }
            }
            i=obj1.buscar_deseo(cedula, fecha);
            fecha_retiro[0]=fecha[0];
            fecha_retiro[1]=fecha[1];
            fecha_retiro[2]=fecha[2];
            if (i>=0){
                
                
                System.out.println("Coloque los siguientes datos: ");
                while (placa.equals("")) {
                    System.out.print("Placa del vehiculo: ");
                    try {   
                      
                        placa= lee.readLine();
                    }
                    catch  (Exception e){
                          
                        System.out.println("Placa invalida"); 
                    }
                }
                kilom_inicial=0.0;
                while (kilom_inicial==0) {
                    System.out.print("Kilometraje Inicial: ");
                    try {   
                      
                        kilom_inicial= Double.parseDouble(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Valor invalido"); 
                    }
                }
                System.out.println("Indique la fecha de entrega: ");
                while (fecha_DP[0]==0) {
                    System.out.print("Dia: ");
                        try {   
                      
                            fecha_DP[0]=Integer.parseInt(lee.readLine());
                        }
                        catch  (Exception e){
                          
                            System.out.println("Dia invalido "); 
                        }
                }
                while (fecha_DP[1]==0) {
                    System.out.print("Mes: ");
                    try {   
                      
                        fecha_DP[1]= Integer.parseInt(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Mes invalido "); 
                    }
                }
                while (fecha_DP[2]==0) {
                    System.out.print("Año: ");
                    try {   
                      
                        fecha_DP[2]= Integer.parseInt(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Año invalido"); 
                    }
                }
            }
            
     } 
}



//--------------------------------------------- CLASE ARREGLO ALQUILER CARGA -----------------------------------------

class Arreglo_alq_carga {
    Alquiler_carga a_alq_carga[] =new Alquiler_carga[7500];
    
    public void instanciar() {
        int i;
        
        for (i=0; i<=7499; i++) {
            a_alq_carga[i]= new Alquiler_carga();
        }
    }
    
    public Double desc65(int ced, Arreglo_clientes obj) {
        
        if (obj.buscar_ced(ced)>=0) {
            if (obj.arr_client[obj.buscar_ced(ced)].edad>=65) {
           return 0.10; 
        }
        }
        
            return 0.0;
        
    }
    
    public int transf_dias(int[] fecha) {
        
        
        switch (fecha[1]) {

            case 1: return fecha[0]+(fecha[2]*365);
                        
                    

            case 2: return 31+fecha[0]+(fecha[2]*365);
                
                    

            case 3: return 59+fecha[0]+(fecha[2]*365);
                
                      
          
            case 4: return 90+fecha[0]+(fecha[2]*365);  
            
                    
                 
            case 5: return 120+fecha[0]+(fecha[2]*365);
                
                    
                
            case 6: return 151+fecha[0]+(fecha[2]*365);

                    
                
            case 7: return 181+fecha[0]+(fecha[2]*365);
                
                    
                
            case 8: return 212+fecha[0]+(fecha[2]*365);
                
                    
                
            case 9: return 243+fecha[0]+(fecha[2]*365);
            
                    
                
            case 10: return 273+fecha[0]+(fecha[2]*365);
                
                    
                
            case 11: return 304+fecha[0]+(fecha[2]*365);
                
                    
               
            case 12: return 334+fecha[0]+(fecha[2]*365);
              
                    
                
                
         }
        return 0;
    }
    
    public void almacenar(Arreglo_reservaciones obj1, Arreglo_grupo obj2, Arreglo_alq_camioneta obj3, Arreglo_alq_liviano obj4, Arreglo_clientes obj5) {
       int i=0, dias;
       int j=0;
       Double multcosto, fidelidad, d65;
       
       while ((a_alq_carga[i].cedula!=0) && (i<=7499)) {
           i=i+1;
       }
       
       if (i<=7499) {
           a_alq_carga[i].almacenar(obj1);
            j=obj1.buscar_deseo(a_alq_carga[i].cedula,a_alq_carga[i].fecha_retiro);
           if (j>=0){
           fidelidad= descuento_fid(a_alq_carga[i].cedula, obj3, obj4);
           d65= desc65(a_alq_carga[i].cedula,obj5);
           dias= transf_dias(a_alq_carga[i].fecha_DP) - transf_dias(a_alq_carga[i].fecha_retiro);
           multcosto= obj2.arr_grupo[obj2.buscar_cod(obj1.arr_reservaciones[j].cod_grupo)].costo;
           
           System.out.println("El costo del alquiler por "+dias+" dias es de Bs. "+multcosto*dias);
           
           if (fidelidad==0.15) {
               System.out.println("Tiene un descuento de un 15% por tener mas de 3 alquileres finalizados");
               
           }
           
           if (d65==0.10) {
               System.out.println("Tiene un descuento de un 10% por ser persona de la tercera edad");
               
           }
           
           if ((fidelidad==0.15)||(d65==0.10)) {
               System.out.println("Incluyendo los descuentos el total a pagar es: "+((multcosto*dias)-(multcosto*dias*fidelidad)-(multcosto*dias*d65)));
           }
           else {
               System.out.println("Usted no tiene descuentos");
           }
           
           
               System.out.println("Se ha realizado el alquiler.");
               a_alq_carga[i].numero=i+100;
               System.out.println("El numero del alquiler es: "+a_alq_carga[i].numero);
               obj2.arr_grupo[obj2.buscar_cod(obj1.arr_reservaciones[j].cod_grupo)].disponibles=obj2.arr_grupo[obj2.buscar_cod(obj1.arr_reservaciones[j].cod_grupo)].disponibles -1;
      
           }else {
               System.out.println("No tiene una reservacion.");
           }
               
            }else {
       
           System.out.println("No se pueden almecenar mas alquileres");
            }    
           
           
    }
    
    public Double descuento_fid(int ced, Arreglo_alq_camioneta obj1, Arreglo_alq_liviano obj2) {
        int cont=0, i=0;
        
        do {
            i=i+1;
            if ((obj1.a_alq_camioneta[i].cedula==ced) && (obj1.a_alq_camioneta[i].costo>0)) {
                cont=cont+1;
            }
        } while((cont>=3) || (i==39999));
        i=0;
        
        do {
            
            if ((obj2.a_alq_liviano[i].cedula==ced) && (obj2.a_alq_liviano[i].costo>0)) {
                cont=cont+1;
                i=i+1;
            }
        } while((cont>=3) || (i==149999));
        i=0;
        
        do {
            
            if ((a_alq_carga[i].cedula==ced) && (a_alq_carga[i].costo>0)) {
               i=i+1;
               cont=cont+1;
            }
        } while((cont>=3) || (i==7499));
        if (cont>=3) {
            return 0.15;
        }
        else {
            return 0.0;
        }
    
    }
    
    public void entrega (Arreglo_alq_camioneta obj1, Arreglo_alq_liviano obj2, Arreglo_clientes obj3, Arreglo_grupo obj4, Arreglo_reservaciones obj5) {
        double recargo, fidelidad, d65, multcosto;
        int diasdemas=0, dias=0;
        int numero=0;
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while (numero<=0) {
            System.out.print("Coloque el numero del alquiler: ");
            try {   
                      
               numero=Integer.parseInt(lee.readLine());
             }
             catch  (Exception e){
                          
               System.out.println("numero invalido"); 
             }
        }
        int i=0;
        i = buscar_numero(numero);
        if(i>=0) {
           
            System.out.println("Indique la fecha de hoy: ");
                while (a_alq_carga[i].fecha_dev[0]==0) {
                    System.out.print("Dia: ");
                        try {   
                      
                            a_alq_carga[i].fecha_dev[0]=Integer.parseInt(lee.readLine());
                        }
                        catch  (Exception e){
                          
                            System.out.println("Dia invalido "); 
                        }
                }
                while (a_alq_carga[i].fecha_dev[1]==0) {
                    System.out.print("Mes: ");
                    try {   
                      
                        a_alq_carga[i].fecha_dev[1]= Integer.parseInt(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Mes invalido "); 
                    }
                }
                while (a_alq_carga[i].fecha_dev[2]==0) {
                    System.out.print("Año: ");
                    try {   
                      
                        a_alq_carga[i].fecha_dev[2]= Integer.parseInt(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Año invalido"); 
                    }
                }
                while (a_alq_carga[i].kilom_final==0) {
                    
                    
                    System.out.print("Coloque el kilometraje final: "); 
                    try {   
                        
                        a_alq_carga[i].kilom_final= Double.parseDouble(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Valor invalido"); 
                    }
                }
                diasdemas= transf_dias(a_alq_carga[i].fecha_dev)- transf_dias(a_alq_carga[i].fecha_DP);
                
                if(diasdemas>0) {
                    recargo=0.25;
                    System.out.println("Tiene un recargo del 25% por no entregar a tiempo.");
                }
                else {
                    recargo=0.0;
                }
                int j=obj5.buscar_deseo(a_alq_carga[i].cedula,a_alq_carga[i].fecha_retiro);
                dias= transf_dias(a_alq_carga[i].fecha_DP) - transf_dias(a_alq_carga[i].fecha_retiro);
                fidelidad = descuento_fid(a_alq_carga[i].cedula, obj1, obj2);
                d65= desc65(a_alq_carga[i].cedula, obj3);
                multcosto= obj4.arr_grupo[obj4.buscar_cod(obj5.arr_reservaciones[j].cod_grupo)].costo;
                a_alq_carga[i].costo= ((multcosto*dias)-(multcosto*dias*fidelidad)-(multcosto*dias*d65)+(multcosto*dias*recargo));
                System.out.println("El total a pagar  Bs. "+a_alq_carga[i].costo);
                System.out.println("Se ha entregado el alquiler.");
                System.out.println("");
                obj4.arr_grupo[obj4.buscar_cod(obj5.arr_reservaciones[j].cod_grupo)].disponibles=obj4.arr_grupo[obj4.buscar_cod(obj5.arr_reservaciones[j].cod_grupo)].disponibles +1;
        }
        else {
            System.out.println("El alquiler no se encuentra almacenado");
        }
    }
    
    public int buscar_numero(int numero) {
        int i;
        
        for (i=0; i<=7499; i++) {
             
           if (a_alq_carga[i].numero==numero) {
               return i;
           }
        }
        return -1;
    }
      
}


//--------------------------------------------- CLASE ALQUILER CAMIONETA -----------------------------------------

class Alquiler_camioneta {
    int numero=0, cedula=0;
    String placa="";
    double costo=0.0, kilom_inicial, kilom_final;
    int[] fecha_retiro= new int [3]; 
    int[] fecha_DP = new int [3]; 
    int[] fecha_dev= new int [3];
    
    public void almacenar(Arreglo_reservaciones obj1) {
        int ced=0, i=0;
        int fecha[]= new int[3];
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while (ced==0) {
            System.out.print("Introduzca la cedula del cliente: ");
            try {   
                      
               ced=Integer.parseInt(lee.readLine());
             }
             catch  (Exception e){
                          
               System.out.println("Cedula invalida"); 
             }
        }
        System.out.println("Introduzca la fecha de hoy: ");
           while (fecha[0]==0) {
                 System.out.print("Dia: ");
                    try {   
                      
                      fecha[0]=Integer.parseInt(lee.readLine());
                     }
                     catch  (Exception e){
                          
                       System.out.println("Dia invalido "); 
                     }
            }
            while (fecha[1]==0) {
               System.out.print("Mes: ");
                  try {   
                      
                    fecha[1]= Integer.parseInt(lee.readLine());
                  }
                  catch  (Exception e){
                          
                  System.out.println("Mes invalido "); 
                  }
            }
            while (fecha[2]==0) {
               System.out.print("Año: ");
                 try {   
                      
                    fecha[2]= Integer.parseInt(lee.readLine());
                 }
                 catch  (Exception e){
                          
                   System.out.println("Año invalido"); 
                 }
            }
        
        fecha_retiro[0]=fecha[0];
        fecha_retiro[1]= fecha[1];
        fecha_retiro[2]= fecha[2];
        i= obj1.buscar_deseo(ced, fecha);
        if(i>=0) {
            
            
            System.out.println("Coloque los siguientes datos");
            while (placa.equals("")) {
                    System.out.print("Placa del Vehiculo: ");
                    try {   
                      
                        placa= lee.readLine();
                    }
                    catch  (Exception e){
                          
                        System.out.println("Placa invalida "); 
                    }
                }
                while (kilom_inicial==0) {
                    System.out.print("Kilometraje Inicial: ");
                    try {   
                      
                        kilom_inicial= Integer.parseInt(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Valor invalido"); 
                    }
                }
                System.out.println("Indique la fecha de entrega: ");
                while (fecha_DP[0]==0) {
                    System.out.print("Dia: ");
                        try {   
                      
                            fecha_DP[0]=Integer.parseInt(lee.readLine());
                        }
                        catch  (Exception e){
                          
                            System.out.println("Dia invalido "); 
                        }
                }
                while (fecha_DP[1]==0) {
                    System.out.print("Mes: ");
                    try {   
                      
                        fecha_DP[1]= Integer.parseInt(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Mes invalido "); 
                    }
                }
                while (fecha_DP[2]==0) {
                    System.out.print("Año: ");
                    try {   
                      
                        fecha_DP[2]= Integer.parseInt(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Año invalido"); 
                    }
                }
        }     
    }
}

//--------------------------------------------- CLASE ARREGLO ALQUILER CAMIONETA -----------------------------------------

class Arreglo_alq_camioneta {
    Alquiler_camioneta a_alq_camioneta[] = new Alquiler_camioneta[40000];
    
    
    public void instanciar() {
        int i;
        
        for (i=0; i<=39999; i++) {
            a_alq_camioneta[i]= new Alquiler_camioneta();
        }
    }
    
    public double desc65(int ced, Arreglo_clientes obj) {
        
        
        if (obj.arr_client[obj.buscar_ced(ced)].edad >=65) {
           return 0.10; 
        }
        else {
            return 0.0;
        }
    }
    
    public int transf_dias(int fecha[]) {
        
        
        switch (fecha[1]) {

            case 1: return fecha[0]+(fecha[2]*365);
                        
            

            case 2: return 31+fecha[0]+(fecha[2]*365);
                
            

            case 3: return 59+fecha[0]+(fecha[2]*365);
                
               
        
            case 4: return 90+fecha[0]+(fecha[2]*365);  
            
           
                 
            case 5: return 120+fecha[0]+(fecha[2]*365);
                
            
                
            case 6: return 151+fecha[0]+(fecha[2]*365);

            
                
            case 7: return 181+fecha[0]+(fecha[2]*365);
                
            
                
            case 8: return 212+fecha[0]+(fecha[2]*365);
                
            
                
            case 9: return 243+fecha[0]+(fecha[2]*365);
                
            
                
            case 10: return 273+fecha[0]+(fecha[2]*365);
                
            
                
            case 11: return 304+fecha[0]+(fecha[2]*365);
                
            
                
            case 12: return 334+fecha[0]+(fecha[2]*365);
                
                
         }
        return 0;
        
    }
    
    public void almacenar(Arreglo_reservaciones obj1, Arreglo_grupo obj2, Arreglo_alq_carga obj3, Arreglo_alq_liviano obj4, Arreglo_clientes obj5,Arreglo_camioneta obj6) {
       int i=0,j=0, dias=0;
       double multcosto, fidelidad, d65,d10;
       
       while ((a_alq_camioneta[i].cedula!=0) && (i<=39999)) {
           i=i+1;
       }
       
       if (i<=39999) {
           a_alq_camioneta[i].almacenar(obj1);
           
           j= obj1.buscar_deseo(a_alq_camioneta[i].cedula,a_alq_camioneta[i].fecha_retiro);
           if(j>=0) {
           
           fidelidad= descuento_fid(a_alq_camioneta[i].cedula, obj3, obj4);
           d65= desc65(a_alq_camioneta[i].cedula,obj5);
           dias= transf_dias(a_alq_camioneta[i].fecha_DP)- transf_dias(a_alq_camioneta[i].fecha_retiro);
           multcosto= obj2.arr_grupo[obj2.buscar_cod(obj1.arr_reservaciones[j].cod_grupo)].costo;
           d10= desc10 (a_alq_camioneta[i].placa, obj6);
           System.out.println("El costo del alquiler por "+dias+" dias es de Bs. "+multcosto*dias);
           
           if (fidelidad==0.15) {
               System.out.println("Tiene un descuento de un 15% por tener mas de 3 alquileres finalizados");
               
           }
           
           if (d65==0.10) {
               System.out.println("Tiene un descuento de un 10% por ser persona de la tercera edad");
               
           }
           
           if (d10==0.10){
               System.out.println("Tiene un descuento de un 10% por alquilar una camioneta sincronica.");
           }
           
           if ((fidelidad==0.15)||(d65==0.10)||(d10==0.10)) {
               System.out.println("Incluyendo los descuentos el total a pagar es: "+((multcosto*dias)-(multcosto*dias*fidelidad)-(multcosto*dias*d65)-(multcosto*dias*d10)));
           }
           else {
               System.out.println("Usted no tiene descuentos");
           }
           System.out.println("Se ha realizado el alquiler.");
           obj2.arr_grupo[obj2.buscar_cod(obj1.arr_reservaciones[j].cod_grupo)].disponibles=obj2.arr_grupo[obj2.buscar_cod(obj1.arr_reservaciones[j].cod_grupo)].disponibles -1;
           a_alq_camioneta[i].numero=i+100;
           System.out.println("El numero del alquiler es: "+a_alq_camioneta[i].numero);
          
           }else{
                System.out.println("No tiene una reservacion.");
           }
          
       }
       else {
           System.out.println("No se pueden almecenar mas alquileres");
       }
    }
    
    public double descuento_fid(int ced, Arreglo_alq_carga obj1, Arreglo_alq_liviano obj2) {
        int cont=0, i=0;
        
        do {
            i=i+1;

            if ((obj1.a_alq_carga[i].cedula==ced) && (obj1.a_alq_carga[i].costo>0)) {
                cont=cont+1;
            }
        } while((cont>=3) || (i==7499));
        i=0;
        
        do {
            i=i+1;
            if ((obj2.a_alq_liviano[i].cedula==ced) && (obj2.a_alq_liviano[i].costo>0)) {
                cont=cont+1;
            }
        } while((cont>=3) || (i==149999));
        i=0;
        
        do {
            
            if ((a_alq_camioneta[i].cedula==ced) && (a_alq_camioneta[i].costo>0)) {
                cont=cont+1;
                i=i+1;
            }
        } while((cont>=3) || (i==39999));
        
        if (cont>=3) {
            return 0.15;
        }
        else {
            return 0.0;
        }
    }
    
    public void entrega (Arreglo_alq_carga obj1, Arreglo_alq_liviano obj2, Arreglo_clientes obj3, Arreglo_grupo obj4, Arreglo_reservaciones obj5, Arreglo_camioneta obj6) {
        double recargo, fidelidad, d65, multcosto,d10;
        int diasdemas=0, dias=0;
        int numero=0;
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while (numero==0){
            System.out.print("Coloque el numero del alquiler: ");
            try {   
                      
               numero=Integer.parseInt(lee.readLine());
             }
             catch  (Exception e){
                          
               System.out.println("Placa invalida"); 
             }
        }
        int i=0;
        i= buscar_numero(numero);
        if(i>=0) {
           
      
            System.out.println("Indique la fecha de hoy: ");
                while (a_alq_camioneta[i].fecha_dev[0]==0) {
                    System.out.print("Dia: ");
                        try {   
                      
                            a_alq_camioneta[i].fecha_dev[0]=Integer.parseInt(lee.readLine());
                        }
                        catch  (Exception e){
                          
                            System.out.println("Dia invalido "); 
                        }
                }
                while (a_alq_camioneta[i].fecha_dev[1]==0) {
                    System.out.print("Mes: ");
                    try {   
                      
                        a_alq_camioneta[i].fecha_dev[1]= Integer.parseInt(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Mes invalido "); 
                    }
                }
                while (a_alq_camioneta[i].fecha_dev[2]==0) {
                    System.out.print("Año: ");
                    try {   
                      
                        a_alq_camioneta[i].fecha_dev[2]= Integer.parseInt(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Año invalido"); 
                    }
                }
                while (a_alq_camioneta[i].kilom_final==0) {
                    System.out.print("Coloque el kilometraje final: "); 
                    
                    try {   
                      
                        a_alq_camioneta[i].kilom_final= Double.parseDouble(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Valor invalido"); 
                    }
                }
                diasdemas= transf_dias(a_alq_camioneta[i].fecha_dev)- transf_dias(a_alq_camioneta[i].fecha_DP);
                
                if(diasdemas>0) {
                    recargo=0.25;
                     System.out.println("Tiene un recargo del 25% por no entregar a tiempo.");
                }
                else {
                    recargo=0.0;
                }
                
                dias= transf_dias(a_alq_camioneta[i].fecha_DP) - transf_dias(a_alq_camioneta[i].fecha_retiro);
                fidelidad = descuento_fid(a_alq_camioneta[i].cedula, obj1, obj2);
                d65= desc65(a_alq_camioneta[i].cedula, obj3);
                multcosto= obj4.arr_grupo[obj4.buscar_cod(obj5.arr_reservaciones[i].cod_grupo)].costo;
                d10= desc10 (a_alq_camioneta[i].placa, obj6);
                a_alq_camioneta[buscar_numero(numero)].costo= ((multcosto*dias)-(multcosto*dias*fidelidad)-(multcosto*dias*d65)+(multcosto*dias*recargo)-(multcosto*dias*d10));
                System.out.println("El costo del alquiler es: Bs. "+a_alq_camioneta[buscar_numero(numero)].costo);
                int j=obj5.buscar_deseo(a_alq_camioneta[i].cedula,a_alq_camioneta[i].fecha_retiro);
                obj4.arr_grupo[obj4.buscar_cod(obj5.arr_reservaciones[j].cod_grupo)].disponibles=obj4.arr_grupo[obj4.buscar_cod(obj5.arr_reservaciones[j].cod_grupo)].disponibles +1;
        }
        else {
            System.out.println("El alquiler no se encuentra almacenado");
        }
    }
    
    public double desc10 (String placa, Arreglo_camioneta obj) {
        
        
        
        if (obj.arr_camioneta[obj.buscar_placa(placa)].Sincronico.equals("a")) {
            return 0.10;
        }
        else {
            return 0.0;
        }
    }
    
    public int buscar_numero(int numero) {
        int i;
        
        
        for (i=0; i<=39999; i++) {
            if (a_alq_camioneta[i].numero==numero) {
                return i;
            }
        }
        return -1;
    } 
    
}

//--------------------------------------------- CLASE ALQUILER LIVIANO -----------------------------------------

class Alquiler_liviano {
    int numero=0, cedula=0;
    String placa="";
    double costo=0.0, kilom_inicial, kilom_final;
    int[] fecha_retiro= new int [3]; 
    int[] fecha_DP = new int [3]; 
    int[] fecha_dev= new int [3];
    
    public void almacenar (Arreglo_reservaciones obj1) {
        int ced=0, i=0;
        int fecha[]= new int[3];
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while (ced==0) {
            System.out.print("Introduzca la cedula del cliente: ");
            try {   
                      
               ced=Integer.parseInt(lee.readLine());
             }
             catch  (Exception e){
                          
               System.out.println("Cedula invalida"); 
             }
        }
        System.out.println("Indique la fecha de hoy: ");
        while (fecha[0]==0) {
           System.out.print("Dia: ");
               try {   
                      
                   fecha[0]=Integer.parseInt(lee.readLine());
              }
              catch  (Exception e){
                          
                   System.out.println("Dia invalido "); 
              }
         }
         while (fecha[1]==0) {
             System.out.print("Mes: ");
                try {   
                      
                   fecha[1]= Integer.parseInt(lee.readLine());
                }
                catch  (Exception e){
                          
                   System.out.println("Mes invalido "); 
                }
         }
         while (fecha[2]==0) {
             System.out.print("Año: ");
                 try {   
                      
                    fecha[2]= Integer.parseInt(lee.readLine());
                 }
                 catch  (Exception e){
                          
                    System.out.println("Año invalido"); 
                 }
         }
         i= obj1.buscar_deseo(ced, fecha);
         fecha_retiro[0]=fecha[0];
         fecha_retiro[1]= fecha[1];
         fecha_retiro[2]= fecha[2];
         
         if(i>=0) {
            
            
            System.out.println("Coloque los siguientes datos");
            while (placa.equals("")) {
                    System.out.println("Placa del Vehiculo: ");
                    try {   
                      
                        placa= lee.readLine();
                    }
                    catch  (Exception e){
                          
                        System.out.println("Placa invalida "); 
                    }
                }
                while (kilom_inicial==0) {
                    System.out.println("Kilometraje Inicial: ");
                    try {   
                      
                        kilom_inicial= Double.parseDouble(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Valor invalido"); 
                    }
                }
                System.out.println("Indique la fecha de entrega: ");
                while (fecha_DP[0]==0) {
                    System.out.print("Dia: ");
                        try {   
                      
                            fecha_DP[0]=Integer.parseInt(lee.readLine());
                        }
                        catch  (Exception e){
                          
                            System.out.println("Dia invalido "); 
                        }
                }
                while (fecha_DP[1]==0) {
                    System.out.print("Mes: ");
                    try {   
                      
                        fecha_DP[1]= Integer.parseInt(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Mes invalido "); 
                    }
                }
                while (fecha_DP[2]==0) {
                    System.out.print("Año: ");
                    try {   
                      
                        fecha_DP[2]= Integer.parseInt(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Año invalido"); 
                    }
                }
        }
    }
    
}

//--------------------------------------------- CLASE ARREGLO ALQUILER LIVIANO -----------------------------------------

class Arreglo_alq_liviano {
   Alquiler_liviano a_alq_liviano[]= new Alquiler_liviano[150000];
    
    
    public void instanciar() {
        int i;
        
        for (i=0; i<150000; i++) {
            a_alq_liviano[i]= new Alquiler_liviano();
        }
    }
    
    public double desc65(int ced, Arreglo_clientes obj) {
        
        
        if (obj.arr_client[obj.buscar_ced(ced)].edad >=65) {
            return 0.10;
        }
        else {
            return 0.0;
        }
    }
    
   public int transf_dias(int[] fecha) {
        
        
        switch (fecha[1]) {

            case 1: return fecha[0]+(fecha[2]*365);
                        

            case 2: return 31+fecha[0]+(fecha[2]*365);
                

            case 3: return 59+fecha[0]+(fecha[2]*365);
                   
          
            case 4: return 90+fecha[0]+(fecha[2]*365);  
            
                 
            case 5: return 120+fecha[0]+(fecha[2]*365);
                
                
            case 6: return 151+fecha[0]+(fecha[2]*365);

                
            case 7: return 181+fecha[0]+(fecha[2]*365);
                
                
            case 8: return 212+fecha[0]+(fecha[2]*365);
                
                
            case 9: return 243+fecha[0]+(fecha[2]*365);
                
                
            case 10: return 273+fecha[0]+(fecha[2]*365);
                
                
            case 11: return 304+fecha[0]+(fecha[2]*365);
                
                
            case 12: return 334+fecha[0]+(fecha[2]*365);  
                
         }
        return 0;
        
    }
   
    public void almacenar(Arreglo_reservaciones obj1, Arreglo_grupo obj2, Arreglo_alq_camioneta obj3, Arreglo_alq_carga obj4, Arreglo_clientes obj5) {
       int i=0,j=0, dias=0;
       double multcosto, fidelidad, d65;
       
       while ((a_alq_liviano[i].cedula!=0) && (i<=149999)) {
           i=i+1;
       }
       
       if (i<=149999) {
           a_alq_liviano[i].almacenar(obj1);
           j= obj1.buscar_deseo(a_alq_liviano[i].cedula,a_alq_liviano[i].fecha_retiro);
           if (j>=0) {
           
           fidelidad= descuento_fid(a_alq_liviano[i].cedula, obj3, obj4);
           d65= desc65(a_alq_liviano[i].cedula,obj5);
           dias= transf_dias(a_alq_liviano[i].fecha_DP)- transf_dias(a_alq_liviano[i].fecha_retiro);
           multcosto= obj2.arr_grupo[obj2.buscar_cod(obj1.arr_reservaciones[j].cod_grupo)].costo;
           
           System.out.println("El costo del alquiler por "+dias+" dias es de Bs. "+multcosto*dias);
           
           if (fidelidad==0.15) {
               System.out.println("Tiene un descuento de un 15% por tener mas de 3 alquileres finalizados");
               
           }
           
           if (d65==0.10) {
               System.out.println("Tiene un descuento de un 10% por ser persona de la tercera edad");
               
           }
           
           if ((fidelidad==0.15)||(d65==0.10)) {
               System.out.println("Incluyendo los descuentos el total a pagar es: "+((multcosto*dias)-(multcosto*dias*fidelidad)-(multcosto*dias*d65)));
           }
           else {
               System.out.println("Usted no tiene descuentos.");
           }
           System.out.println("Se ha realizado el alquiler.");
           obj2.arr_grupo[obj2.buscar_cod(obj1.arr_reservaciones[j].cod_grupo)].disponibles=obj2.arr_grupo[obj2.buscar_cod(obj1.arr_reservaciones[j].cod_grupo)].disponibles -1;
           a_alq_liviano[i].numero=i+100;
           System.out.println("El numero del alquiler es: "+a_alq_liviano[i].numero);
            
           }else{
               System.out.println("No tiene una reservacion.");
           }
       }
       else {
           System.out.println("No se pueden almecenar mas alquileres");
       }
    }
    
    public double descuento_fid(int ced, Arreglo_alq_camioneta obj1, Arreglo_alq_carga obj2) {
        int cont=0, i=0;
        
        do {
            i=i+1;
            if ((obj1.a_alq_camioneta[i].cedula==ced) && (obj1.a_alq_camioneta[i].costo>0)) {
                cont=cont+1;
            }
        } while((cont>=3) || (i==39999));
        i=0;
        
        do {
            i=i+1;
            if ((obj2.a_alq_carga[i].cedula==ced) && (obj2.a_alq_carga[i].costo>0)) {
                cont=cont+1;
            }
        } while((cont>=3) || (i==7499));
        i=0;
        
        do {
           
            if ((a_alq_liviano[i].cedula==ced) && (a_alq_liviano[i].costo>0)) {
                cont=cont+1;
                i=i+1;
            }
        } while((cont>=3) || (i==149999));
        
        if (cont>=3) {
            return 0.15;
        }
        else {
            return 0.0;
        }
    }
    
    public void entrega (Arreglo_alq_camioneta obj1, Arreglo_alq_carga obj2, Arreglo_clientes obj3, Arreglo_grupo obj4, Arreglo_reservaciones obj5, Arreglo_liviano obj6) {
        double recargo, fidelidad, d65, multcosto;
        int diasdemas=0, dias=0;
        int numero=0;
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while (numero==0) {
            System.out.print("Coloque el numero del alquiler: ");
            try {   
                      
              numero=Integer.parseInt(lee.readLine());
             }
             catch  (Exception e){
                          
               System.out.println("Placa invalida"); 
             }
        }
        int i=0;
        i=buscar_numero(numero);
        if(i>=0) {
           
            System.out.println("Indique la fecha de hoy: ");
                while (a_alq_liviano[i].fecha_dev[0]==0) {
                    System.out.print("Dia: ");
                        try {   
                      
                            a_alq_liviano[i].fecha_dev[0]=Integer.parseInt(lee.readLine());
                        }
                        catch  (Exception e){
                          
                            System.out.println("Dia invalido "); 
                        }
                }
                while (a_alq_liviano[i].fecha_dev[1]==0) {
                    System.out.print("Mes: ");
                    try {   
                      
                        a_alq_liviano[i].fecha_dev[1]= Integer.parseInt(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Mes invalido "); 
                    }
                }
                while (a_alq_liviano[i].fecha_dev[2]==0) {
                    System.out.print("Año: ");
                    try {   
                      
                        a_alq_liviano[i].fecha_dev[2]= Integer.parseInt(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Año invalido"); 
                    }
                }
                while (a_alq_liviano[i].kilom_final==0) {
                    System.out.print("Coloque el kilometraje final: ");
                    try {   
                      
                        a_alq_liviano[i].kilom_final= Double.parseDouble(lee.readLine());
                    }
                    catch  (Exception e){
                          
                        System.out.println("Valor invalido"); 
                    }
                }
                diasdemas= transf_dias(a_alq_liviano[i].fecha_dev)- transf_dias(a_alq_liviano[i].fecha_DP);
                
                if(diasdemas>0) {
                    recargo=0.25;
                }
                else {
                    recargo=0.0;
                }
                dias= transf_dias(a_alq_liviano[i].fecha_DP) - transf_dias(a_alq_liviano[i].fecha_retiro);
                fidelidad = descuento_fid(a_alq_liviano[i].cedula, obj1, obj2);
                d65= desc65(a_alq_liviano[i].cedula, obj3);
                multcosto= obj4.arr_grupo[obj4.buscar_cod(obj5.arr_reservaciones[i].cod_grupo)].costo;
                a_alq_liviano[buscar_numero(numero)].costo= ((multcosto*dias)-(multcosto*dias*fidelidad)-(multcosto*dias*d65)+(multcosto*dias*recargo));
                System.out.print("El costo del alquiler es: Bs. "+a_alq_liviano[buscar_numero(numero)].costo);
                System.out.print("Se ha realizado el alquiler.");
                System.out.print("");
                int j=obj5.buscar_deseo(a_alq_liviano[i].cedula,a_alq_liviano[i].fecha_retiro);
                obj4.arr_grupo[obj4.buscar_cod(obj5.arr_reservaciones[j].cod_grupo)].disponibles=obj4.arr_grupo[obj4.buscar_cod(obj5.arr_reservaciones[j].cod_grupo)].disponibles +1;
        }
        else {
            System.out.println("El alquiler no se encuentra almacenado.");
        }
    }
    
    public int buscar_numero(int numero) {
        int i;
        
        
        for (i=0; i<=149999; i++) {
            if (a_alq_liviano[i].numero==numero) {
                return i;
            }
        }
        return -1;
    } 
    
}

//------------------------------------------------CLASE ARCHIVO GRUPO--------------------------------------------------


class Archivo_grupo{
    
    void leer(Arreglo_grupo obj1) {
        try {
            
            File A = new File("Grupos.txt");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea = "";
           int i=-1;
            while ((linea = leer.readLine()) != null) {
                i=i+1;
                StringTokenizer tokens = new StringTokenizer(linea, "#");
                int j=0;
                while (tokens.hasMoreTokens()) {
                    j=j+1;
		    switch (j){
                        
                        case 1:
                               obj1.arr_grupo[i].nombre= tokens.nextToken();
                               break;
                        case 2: 
                               obj1.arr_grupo[i].codigo= Integer.parseInt(tokens.nextToken());
                               break;
                        case 3:
                               obj1.arr_grupo[i].disponibles = Integer.parseInt(tokens.nextToken());
                               break;
                        case 4:
                               obj1.arr_grupo[i].existencia = Integer.parseInt(tokens.nextToken());
                               break;
                        case 5:
                               obj1.arr_grupo[i].costo = Double.parseDouble(tokens.nextToken());
                               break;
                        case 6:
                               obj1.arr_grupo[i].marca = tokens.nextToken();
                               break;
                        case 7:
                               obj1.arr_grupo[i].modelo = tokens.nextToken();
                               break;
                                         
                    }
						
			
                }
                System.out.println();
                linea="";
            }

        } catch (Exception e) {
        }
        
    }
    
    
    void escribir (Arreglo_grupo obj1){
        
       try {
            File f = new File("Grupos.txt");
            FileWriter linea = new FileWriter(f, false);
            for (int i=0; i<50; i++){
                if (obj1.arr_grupo[i].codigo>0){
                     linea.write(obj1.arr_grupo[i].nombre+"#"+obj1.arr_grupo[i].codigo+"#"+obj1.arr_grupo[i].disponibles+"#"+obj1.arr_grupo[i].existencia+"#"+obj1.arr_grupo[i].costo+"#"+obj1.arr_grupo[i].marca+"#"+obj1.arr_grupo[i].modelo+"\r\n");
                }
             }  
            
            
        } catch (Exception e) {
            
        }
        
        
    }
    
    
    
    
}

//------------------------------------------------CLASE ARCHIVO CLIENTE--------------------------------------------------

class Archivo_cliente{
    
    void leer(Arreglo_clientes obj1) {
        try {
            
            File A = new File("Clientes.txt");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea = "";
           int i=-1;
            while ((linea = leer.readLine()) != null) {
                i=i+1;
                StringTokenizer tokens = new StringTokenizer(linea, "#");
                int j=0;
                while (tokens.hasMoreTokens()) {
                    j=j+1;
		    switch (j){
                        
                        case 1:
                               obj1.arr_client[i].cedula= Integer.parseInt(tokens.nextToken());
                               break;
                        case 2: 
                               obj1.arr_client[i].nombre= tokens.nextToken();
                               break;
                        case 3:
                               obj1.arr_client[i].apellido = tokens.nextToken();
                               break;
                        case 4:
                               obj1.arr_client[i].edad = Integer.parseInt(tokens.nextToken());
                               break;
                        case 5:
                               obj1.arr_client[i].direccion = tokens.nextToken();
                               break;
                        case 6:
                               obj1.arr_client[i].telefono = tokens.nextToken();
                               break;
                        
                                         
                    }
						
			
                }
                System.out.println();
                linea="";
            }

        } catch (Exception e) {
        }
        
    }
    
    
    void escribir (Arreglo_clientes obj1){
        
       try {
            File f = new File("Clientes.txt");
            FileWriter linea = new FileWriter(f, false);
            for (int i=0; i<500; i++){
                if (obj1.arr_client[i].cedula>0){
                     linea.write(obj1.arr_client[i].cedula+"#"+obj1.arr_client[i].nombre+"#"+obj1.arr_client[i].apellido+"#"+obj1.arr_client[i].edad+"#"+obj1.arr_client[i].direccion+"#"+obj1.arr_client[i].telefono+"\r\n");
                }
             }  
            linea.close();
            
        } catch (Exception e) {
            
        }
        
        
    }
    
    
    
    
}

//------------------------------------------------CLASE ARCHIVO RESERVACIONES--------------------------------------------------


class Archivo_reservaciones{
    
    void leer(Arreglo_reservaciones obj1) {
        try {
            
            File A = new File("Reservaciones.txt");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea = "";
            
           int i=-1;
            while ((linea = leer.readLine()) != null) {
                i=i+1;
                StringTokenizer tokens = new StringTokenizer(linea, "#");
                int j=0;
                while (tokens.hasMoreTokens()) {
                    j=j+1;
		    switch (j){
                        
                        case 1:
                               obj1.arr_reservaciones[i].nombre_cli= tokens.nextToken();
                               break;
                        case 2: 
                               obj1.arr_reservaciones[i].ced_cli= Integer.parseInt(tokens.nextToken());
                               break;
                        case 3:
                               obj1.arr_reservaciones[i].cod_grupo = Integer.parseInt(tokens.nextToken());
                               break;
                        case 4:
                               obj1.arr_reservaciones[i].fecha_res[1]= Integer.parseInt(tokens.nextToken());
                               break;
                        case 5:
                               obj1.arr_reservaciones[i].fecha_res[2] =Integer.parseInt(tokens.nextToken());
                              break;
                        case 6:
                               obj1.arr_reservaciones[i].fecha_res[3] = Integer.parseInt(tokens.nextToken());
                               break;
                       
                        case 7:
                               obj1.arr_reservaciones[i].fecha_deseo[1] = Integer.parseInt(tokens.nextToken());
                              break;
                        case 8:
                               obj1.arr_reservaciones[i].fecha_deseo[2] = Integer.parseInt(tokens.nextToken());
                               break;
                        case 9:
                               obj1.arr_reservaciones[i].fecha_deseo[3] = Integer.parseInt(tokens.nextToken());
                               break;
                        
                            
                            
                                         
                    }
						
			
                }
                System.out.println();
                linea="";
            }

        } catch (Exception e) {
        }
        
    }
    
    
    void escribir (Arreglo_reservaciones obj1){
        
       try {
            File f = new File("Reservaciones.txt");
            FileWriter linea = new FileWriter(f, false);
            linea.write("SDSA");
            for (int i=0; i<25000; i++){
               
               if (obj1.arr_reservaciones[i].ced_cli>0){
                     linea.write(obj1.arr_reservaciones[i].nombre_cli+"#"+obj1.arr_reservaciones[i].ced_cli+"#"+obj1.arr_reservaciones[i].cod_grupo+"#"+obj1.arr_reservaciones[i].fecha_res[0]+"#"+obj1.arr_reservaciones[i].fecha_res[1]+"#"+obj1.arr_reservaciones[i].fecha_res[2]+"#"+obj1.arr_reservaciones[i].fecha_deseo[0]+"#"+obj1.arr_reservaciones[i].fecha_deseo[1]+"#"+obj1.arr_reservaciones[i].fecha_deseo[2]+"\r\n");
               }
               }  
            linea.close();
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        
        
    }
    
}


//------------------------------------------------------------------CLASE ARCHIVO VEHICULOS ----------------------------------------------------



class Archivo_vehiculos{
    
    void leer(Arreglo_carga obj1, Arreglo_camioneta obj2, Arreglo_liviano obj3  ) {
        try {
            
            File A = new File("Vehiculos.txt");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea ="";
            int k;
            int i=-1;
            while ((linea = leer.readLine()) != null) {
                i=i+1;
                String prim="";
                k=1;  
                
                StringTokenizer tokens = new StringTokenizer(linea, "#");
                int j=0;
                while (tokens.hasMoreTokens()) {
                   j=j+1;
                   
                   if (k==1){
                       
                     prim=tokens.nextToken();
                     k=2;
                   }
                    
                   switch (prim){
                       
                       case "Carga":  switch (j){
                           
                                          case 2:
                                                 obj1.arr_carga[i].placa=tokens.nextToken();
                                                 break;
                                          case 3:
                                                 obj1.arr_carga[i].modelo=tokens.nextToken();
                                                 break;
                                          case 4:
                                                 obj1.arr_carga[i].marca=tokens.nextToken();
                                                 break;
                                          case 5:
                                                 obj1.arr_carga[i].color=tokens.nextToken();
                                                 break;
                                          case 6:
                                                 obj1.arr_carga[i].año=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 7:
                                                 obj1.arr_carga[i].cap_kilos=Double.parseDouble(tokens.nextToken());
                                                 break;
                                          case 8:
                                                 obj1.arr_carga[i].cap_metros=Double.parseDouble(tokens.nextToken());
                                                 break;
                                        
                                      }
                           
                              
                           
                                    break;
                       case "Camioneta":switch (j){
                           
                                          case 2:
                                                 obj2.arr_camioneta[i].placa=tokens.nextToken();
                                                 break;
                                          case 3:
                                                 obj2.arr_camioneta[i].modelo=tokens.nextToken();
                                                 break;
                                          case 4:
                                                 obj2.arr_camioneta[i].marca=tokens.nextToken();
                                                 break;
                                          case 5:
                                                 obj2.arr_camioneta[i].color=tokens.nextToken();
                                                 break;
                                          case 6:
                                                 obj2.arr_camioneta[i].año=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 7:
                                                 obj2.arr_camioneta[i].Sincronico=tokens.nextToken();
                                                 break;
                                          
                                      }
                                    break;
                       case "Liviano":switch (j){
                           
                                          case 2:
                                                 obj3.arr_liviano[i].placa=tokens.nextToken();
                                                 break;
                                          case 3:
                                                 obj3.arr_liviano[i].modelo=tokens.nextToken();
                                                 break;
                                          case 4:
                                                 obj3.arr_liviano[i].marca=tokens.nextToken();
                                                 break;
                                          case 5:
                                                 obj3.arr_liviano[i].color=tokens.nextToken();
                                                 break;
                                          case 6:
                                                 obj3.arr_liviano[i].año=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 7:
                                                 obj3.arr_liviano[i].asientos=Integer.parseInt(tokens.nextToken());
                                                 break;
                                                                                  
                                      }
                                    break;
                       
                   } 
						
			
                }
                System.out.println();
                linea="";
            }

        } catch (Exception e) {
        }
        
    }
    
    void escribir (Arreglo_carga obj1, Arreglo_camioneta obj2, Arreglo_liviano obj3){
        
       try {
            File f = new File("Vehiculos.txt");
            FileWriter linea = new FileWriter(f, false);
            for (int i=0; i<15; i++){
                if (obj1.arr_carga[i].placa!=""){
                     linea.write("Carga#"+obj1.arr_carga[i].placa+"#"+obj1.arr_carga[i].modelo+"#"+obj1.arr_carga[i].marca+"#"+obj1.arr_carga[i].color+"#"+obj1.arr_carga[i].año+"#"+obj1.arr_carga[i].cap_kilos+"#"+obj1.arr_carga[i].cap_metros+"\r\n");
                }
             } 
            
            for (int i=0; i<80; i++){
                if (obj2.arr_camioneta[i].placa!=""){
                     linea.write("Camioneta#"+obj2.arr_camioneta[i].placa+"#"+obj2.arr_camioneta[i].modelo+"#"+obj2.arr_camioneta[i].marca+"#"+obj2.arr_camioneta[i].color+"#"+obj2.arr_camioneta[i].año+"#"+obj2.arr_camioneta[i].Sincronico+"\r\n");
                }
             }  
            
            for (int i=0; i<300; i++){
                if (obj3.arr_liviano[i].placa!=""){
                     linea.write("Liviano#"+obj3.arr_liviano[i].placa+"#"+obj3.arr_liviano[i].modelo+"#"+obj3.arr_liviano[i].marca+"#"+obj3.arr_liviano[i].color+"#"+obj3.arr_liviano[i].año+"#"+obj3.arr_liviano[i].asientos+"\r\n");
                }
             }  
            linea.close();
            
        } catch (Exception e) {
            
        }
        
        
    }
    
    

}

//------------------------------------------------------------------CLASE ARCHIVO ALQUILERES----------------------------------------------------



class Archivo_Alquileres{
    
    void leer(Arreglo_alq_carga obj1, Arreglo_alq_camioneta obj2, Arreglo_alq_liviano obj3  ) {
        try {
            
            File A = new File("Alquileres.txt");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea = "";
            int k;
            int i=-1;
            while ((linea = leer.readLine()) != null) {
                i=i+1;
                String prim="";
                k=1;  
                
                StringTokenizer tokens = new StringTokenizer(linea, "#");
                int j=0;
                while (tokens.hasMoreTokens()) {
                   j=j+1;
                   
                   if (k==1){
                       
                     prim=tokens.nextToken();
                     k=2;
                   }
                    
                   switch (prim){
                       
                       case "Carga":  switch (j){
                           
                                          case 2:
                                                 obj1.a_alq_carga[i].cedula=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 3:
                                                 obj1.a_alq_carga[i].numero=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 4:
                                                 obj1.a_alq_carga[i].placa=tokens.nextToken();
                                                 break;
                                          case 5:
                                                 obj1.a_alq_carga[i].costo=Double.parseDouble(tokens.nextToken());
                                                 break;
                                          case 6:
                                                 obj1.a_alq_carga[i].kilom_inicial=Double.parseDouble(tokens.nextToken());
                                                 break;
                                          case 7:
                                                 obj1.a_alq_carga[i].kilom_final=Double.parseDouble(tokens.nextToken());
                                                 break;
                                          case 8:
                                                 obj1.a_alq_carga[i].fecha_retiro[1]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 9:
                                                 obj1.a_alq_carga[i].fecha_retiro[2]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 10:
                                                 obj1.a_alq_carga[i].fecha_retiro[3]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 11:
                                                 obj1.a_alq_carga[i].fecha_dev[1]=Integer.parseInt(tokens.nextToken());
                                                 break; 
                                          case 12:
                                                 obj1.a_alq_carga[i].fecha_dev[2]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 13:
                                                 obj1.a_alq_carga[i].fecha_dev[3]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 14:
                                                 obj1.a_alq_carga[i].fecha_DP[1]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 15:
                                                 obj1.a_alq_carga[i].fecha_DP[2]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 16:
                                                 obj1.a_alq_carga[i].fecha_DP[3]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                              
                                              
                                      }
                           
                              
                           
                                    break;
                       case "Camioneta":switch (j){
                           
                                          case 2:
                                                 obj2.a_alq_camioneta[i].cedula=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 3:
                                                 obj2.a_alq_camioneta[i].numero=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 4:
                                                 obj2.a_alq_camioneta[i].placa=tokens.nextToken();
                                                 break;
                                          case 5:
                                                 obj2.a_alq_camioneta[i].costo=Double.parseDouble(tokens.nextToken());
                                                 break;
                                          case 6:
                                                 obj2.a_alq_camioneta[i].kilom_inicial=Double.parseDouble(tokens.nextToken());
                                                 break;
                                          case 7:
                                                 obj2.a_alq_camioneta[i].kilom_final=Double.parseDouble(tokens.nextToken());
                                                 break;
                                          case 8:
                                                 obj2.a_alq_camioneta[i].fecha_retiro[1]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 9:
                                                 obj2.a_alq_camioneta[i].fecha_retiro[2]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 10:
                                                 obj2.a_alq_camioneta[i].fecha_retiro[3]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 11:
                                                 obj2.a_alq_camioneta[i].fecha_dev[1]=Integer.parseInt(tokens.nextToken());
                                                 break; 
                                          case 12:
                                                 obj2.a_alq_camioneta[i].fecha_dev[2]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 13:
                                                 obj2.a_alq_camioneta[i].fecha_dev[3]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 14:
                                                 obj2.a_alq_camioneta[i].fecha_DP[1]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 15:
                                                 obj2.a_alq_camioneta[i].fecha_DP[2]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 16:
                                                 obj2.a_alq_camioneta[i].fecha_DP[3]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          
                                      }
                                    break;
                       case "Liviano":switch (j){
                           
                                          case 2:
                                                 obj3.a_alq_liviano[i].cedula=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 3:
                                                 obj3.a_alq_liviano[i].numero=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 4:
                                                 obj3.a_alq_liviano[i].placa=tokens.nextToken();
                                                 break;
                                          case 5:
                                                 obj3.a_alq_liviano[i].costo=Double.parseDouble(tokens.nextToken());
                                                 break;
                                          case 6:
                                                 obj3.a_alq_liviano[i].kilom_inicial=Double.parseDouble(tokens.nextToken());
                                                 break;
                                          case 7:
                                                 obj3.a_alq_liviano[i].kilom_final=Double.parseDouble(tokens.nextToken());
                                                 break;
                                          case 8:
                                                 obj3.a_alq_liviano[i].fecha_retiro[1]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 9:
                                                 obj3.a_alq_liviano[i].fecha_retiro[2]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 10:
                                                 obj3.a_alq_liviano[i].fecha_retiro[3]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 11:
                                                 obj3.a_alq_liviano[i].fecha_dev[1]=Integer.parseInt(tokens.nextToken());
                                                 break; 
                                          case 12:
                                                 obj3.a_alq_liviano[i].fecha_dev[2]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 13:
                                                 obj3.a_alq_liviano[i].fecha_dev[3]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 14:
                                                 obj3.a_alq_liviano[i].fecha_DP[1]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 15:
                                                 obj3.a_alq_liviano[i].fecha_DP[2]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                          case 16:
                                                 obj3.a_alq_liviano[i].fecha_DP[3]=Integer.parseInt(tokens.nextToken());
                                                 break;
                                                                                  
                                      }
                                    break;
                       
                   } 
						
			
                }
                System.out.println();
                linea="";
            }

        } catch (Exception e) {
        }
        
    }
    
    void escribir (Arreglo_alq_carga obj1, Arreglo_alq_camioneta obj2, Arreglo_alq_liviano obj3  ){
        
       try {
            File f = new File("Alquileres.txt");
            FileWriter linea = new FileWriter(f, false);
            for (int i=0; i<7500; i++){
                
                if (obj1.a_alq_carga[i].placa!="") {
                    linea.write("Carga#"+obj1.a_alq_carga[i].cedula+"#"+obj1.a_alq_carga[i].numero+"#"+obj1.a_alq_carga[i].placa+"#"+obj1.a_alq_carga[i].costo+"#"+obj1.a_alq_carga[i].kilom_inicial+"#"+obj1.a_alq_carga[i].kilom_final+"#"+obj1.a_alq_carga[i].fecha_retiro[0]+"#"+obj1.a_alq_carga[i].fecha_retiro[1]+"#"+obj1.a_alq_carga[i].fecha_retiro[2]+"#"+obj1.a_alq_carga[i].fecha_dev[0]+"#"+obj1.a_alq_carga[i].fecha_dev[1]+"#"+obj1.a_alq_carga[i].fecha_dev[2]+"#"+obj1.a_alq_carga[i].fecha_DP[0]+"#"+obj1.a_alq_carga[i].fecha_DP[1]+"#"+obj1.a_alq_carga[i].fecha_DP[2]+"\r\n");
                }
             } 
            
            for (int i=0; i<80; i++){
                
                if (obj2.a_alq_camioneta[i].placa!="") {
                    linea.write("Carga#"+obj2.a_alq_camioneta[i].cedula+"#"+obj2.a_alq_camioneta[i].numero+"#"+obj2.a_alq_camioneta[i].placa+"#"+obj2.a_alq_camioneta[i].costo+"#"+obj2.a_alq_camioneta[i].kilom_inicial+"#"+obj2.a_alq_camioneta[i].kilom_final+"#"+obj2.a_alq_camioneta[i].fecha_retiro[0]+"#"+obj2.a_alq_camioneta[i].fecha_retiro[1]+"#"+obj2.a_alq_camioneta[i].fecha_retiro[2]+"#"+obj2.a_alq_camioneta[i].fecha_dev[0]+"#"+obj2.a_alq_camioneta[i].fecha_dev[1]+"#"+obj2.a_alq_camioneta[i].fecha_dev[2]+"#"+obj2.a_alq_camioneta[i].fecha_DP[0]+"#"+obj2.a_alq_camioneta[i].fecha_DP[1]+"#"+obj2.a_alq_camioneta[i].fecha_DP[2]+"\r\n");

                }
             }  
            
            for (int i=0; i<150000; i++){
                
                if (obj3.a_alq_liviano[i].placa!="") {
                    linea.write("Liviano#"+obj3.a_alq_liviano[i].cedula+"#"+obj3.a_alq_liviano[i].numero+"#"+obj3.a_alq_liviano[i].placa+"#"+obj3.a_alq_liviano[i].costo+"#"+obj3.a_alq_liviano[i].kilom_inicial+"#"+obj3.a_alq_liviano[i].kilom_final+"#"+obj3.a_alq_liviano[i].fecha_retiro[0]+"#"+obj3.a_alq_liviano[i].fecha_retiro[1]+"#"+obj3.a_alq_liviano[i].fecha_retiro[2]+"#"+obj3.a_alq_liviano[i].fecha_dev[0]+"#"+obj3.a_alq_liviano[i].fecha_dev[1]+"#"+obj3.a_alq_liviano[i].fecha_dev[2]+"#"+obj3.a_alq_liviano[i].fecha_DP[0]+"#"+obj3.a_alq_liviano[i].fecha_DP[1]+"#"+obj3.a_alq_liviano[i].fecha_DP[2]+"\r\n");
                
                }
             }  
            linea.close();
            
        } catch (Exception e) {
            
        }
        
        
    }
    
    

}





public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Arreglo_carga a_carga= new Arreglo_carga();
        Arreglo_camioneta a_camioneta= new Arreglo_camioneta();
        Arreglo_liviano a_liviano= new Arreglo_liviano();
        Arreglo_grupo a_grupo= new Arreglo_grupo();
        Arreglo_clientes a_clientes= new Arreglo_clientes();
        Arreglo_reservaciones a_reservaciones= new Arreglo_reservaciones();
        Arreglo_alq_carga alq_carga = new Arreglo_alq_carga();
        Arreglo_alq_camioneta alq_camioneta = new Arreglo_alq_camioneta();
        Arreglo_alq_liviano alq_liviano = new Arreglo_alq_liviano();
        Archivo_grupo arch_grupo= new Archivo_grupo();
        Archivo_cliente arch_cliente= new Archivo_cliente();
        Archivo_reservaciones arch_reserv= new Archivo_reservaciones();
        Archivo_vehiculos arch_vehiculos= new Archivo_vehiculos();
        Archivo_Alquileres arch_alquileres= new Archivo_Alquileres();
        alq_carga.instanciar();
        alq_camioneta.instanciar();
        alq_liviano.instanciar();
        a_reservaciones.instanciar();
        a_clientes.instanciar();
        a_carga.instanciar_car();
        a_camioneta.instanciar_cam();
        a_liviano.instanciar_liv();
        a_grupo.instanciar();
        int opc=0;
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        arch_grupo.leer(a_grupo);
        arch_cliente.leer(a_clientes);
        arch_reserv.leer(a_reservaciones);
        arch_vehiculos.leer(a_carga, a_camioneta, a_liviano);
        arch_alquileres.leer(alq_carga, alq_camioneta, alq_liviano);
        while (opc!=10){
            
            System.out.println("Bienvenido al sistema de gestion de vehiculos. ");
            System.out.println(" ");
            System.out.println("¿Qué desea hacer?");
            System.out.println("Almacenar (Vehículo,Cliente o Grupo).  (Presione 1)");
            System.out.println("Modificar (Vehículo, Cliente o Grupo). (Presione 2)");
            System.out.println("Eliminar  (Vehículo, Cliente o Grupo). (Presione 3)");
            System.out.println("Mostrar los datos de los grupos.       (Presione 4)");
            System.out.println("Realizar una reservacion.              (Presione 5)");
            System.out.println("Eliminar una reservacion.              (Presione 6)");
            System.out.println("Realizar un alquiler.                  (Presione 7)");
            System.out.println("Entregar un alquiler.                  (Presione 8)");
            System.out.println("Mostrar mayores de 65 años.            (Presione 9)");
            System.out.println("Guardar y salir.                       (Presione 10)");
            System.out.println("");
            System.out.print("Coloque su opcion: ");
            try 
            {   
                opc = Integer.parseInt(lee.readLine());
            } 
                catch (Exception e) 
            {
                System.out.println("Opcion invalida ");
            }
            
            System.out.println(" ");
            switch (opc) {
                
                case 1:
                        int opc2=0;
                        while (opc2!=4){
                           System.out.println("¿Que desea almacenar?.");
                           System.out.println("Vehiculo  (Presione 1)");
                           System.out.println("Cliente. (Presione 2)");
                           System.out.println("Grupo. (Presione 3)");  
                           System.out.println("Ir atras. (Presione 4)"); 
                           System.out.println("");
                           System.out.print("Coloque su opcion: ");
                           
                            try
                            {   
                                opc2 = Integer.parseInt(lee.readLine());
                            } 
                                catch (Exception e) 
                            {
                                System.out.println("Opcion invalida ");
                            }
                           System.out.println(" ");
                           switch (opc2){
                               
                               case 1:
                                      int opc3= 0;
                                      while (opc3!=4){
                                          
                                          System.out.println("¿Que desea almacenar?.");
                                          System.out.println("Carga.  (Presione 1)");
                                          System.out.println("Camioneta. (Presione 2)");
                                          System.out.println("Liviano. (Presione 3)");  
                                          System.out.println("Ir atras. (Presione 4)"); 
                                          System.out.println("");
                                          System.out.print("Coloque su opcion: ");
                                          
                                          try
                                          {   
                                              opc3 = Integer.parseInt(lee.readLine());
                                          } 
                                              catch (Exception e) 
                                          {
                                              System.out.println("Opcion invalida ");
                                          }
                                          System.out.println(" ");
                                          switch (opc3) {
                                              
                                              case 1: a_carga.almacenar(a_grupo);
                                                  break;
                                              
                                              case 2:
                                                     a_camioneta.almacenar(a_grupo);
                                                                    
                                                     break;
                                              case 3:
                                                     a_liviano.almacenar(a_grupo);
                                                                                                          
                                                     break;
                                              case 4:
                                                      break;
                                             default:
                                                     System.out.println("Datos invalidos, coloque un numero entre el 1 y 4: ");
                                                                    
                                                      break;    
                                              
                                        }
                                                       
                                      }                              
                                      break;
                                                    
                                   
                               case 2:
                                      a_clientes.almacenar();
                                                                    
                                      break;
                               case 3:
                                      System.out.println ("Introduzca los siguientes datos: ");
                                      
                                      
                                      System.out.print ("Marca: ");
                                      
                                      String marca="";
                                      try
                                      {   
                                          marca= lee.readLine();
                                      } 
                                       catch (Exception e) 
                                      {
                                          System.out.println("Opcion invalida ");
                                      }
                                      
                                      System.out.print ("Modelo: ");
                                      String modelo="";
                                      try
                                      {   
                                          modelo = lee.readLine();
                                      } 
                                       catch (Exception e) 
                                      {
                                          System.out.println("Opcion invalida ");
                                      }
                                       
                                      a_grupo.almacenar(modelo,marca);
                                      
                                      
                                      break;
                               case 4:
                                     break;
                               default:
                                      System.out.println("Datos invalidos, coloque un numero entre el 1 y 4: ");
                                                                    
                                      break;
                       
                               
                           }
                       
                        }
                       break;
                
                case 2: 
                        int opc4=0;
                        while (opc4!=4){
                           System.out.println("¿Que desea modificar?.");
                           System.out.println("Vehículo.  (Presione 1)");
                           System.out.println("Persona. (Presione 2)");
                           System.out.println("Grupo. (Presione 3)");  
                           System.out.println("Salir. (Presione 4)"); 
                           System.out.println("");
                           System.out.print("Coloque su opcion: ");
                           
                           try
                            {   
                                opc4 = Integer.parseInt(lee.readLine());
                            } 
                                catch (Exception e) 
                            {
                                System.out.println("Opcion invalida ");
                            }
                           System.out.println(" ");
                           switch (opc4){
                               
                               case 1:
                                      int opc5=0;
                                      while (opc5!=4){
                                      System.out.println("¿Que tipo de vehiculo desea modificar?.");
                                      System.out.println("Carga.  (Presione 1)");
                                      System.out.println("Camioneta. (Presione 2)");
                                      System.out.println("Liviano. (Presione 3)");  
                                      System.out.println("Salir. (Presione 4)"); 
                                      System.out.println("");
                                      System.out.print("Coloque su opcion: ");
                           
                                     try
                                     {   
                                         opc5 = Integer.parseInt(lee.readLine());
                                     } 
                                     catch (Exception e) 
                                     {
                                         System.out.println("Opcion invalida ");
                                     }
                           
                                     switch (opc5){
                               
                                         case 1:
                                                a_carga.modificar_car();
                                                                    
                                                break;
                                         case 2:
                                                a_camioneta.modificar_cam();
                                                                    
                                                break;
                                         case 3:
                                                a_clientes.modificar();
                                                                                                          
                                                break;
                                         case 4:
                                                break;
                                         default:
                                                 System.out.println("Datos invalidos, coloque un numero entre el 1 y 4: ");
                                                                    
                                                 break;
                               
                                        }
                       
                                    }
                                                                    
                                      break;
                               case 2:
                                      a_grupo.modificar();
                                                                    
                                      break;
                               case 3:
                                      a_grupo.modificar();
                                                                                                          
                                      break;
                               case 4:
                                     break;
                               default:
                                      System.out.println("Datos invalidos, coloque un numero entre el 1 y 4: ");
                                                                    
                                      break;
                               
                           }
                       
                        }
                        break;
                
                case 3: 
                        int opc6=0;
                        while (opc6!=4){
                           System.out.println("¿Que desea eliminar?.");
                           System.out.println("Vehículo.  (Presione 1)");
                           System.out.println("Cliente. (Presione 2)");
                           System.out.println("Grupo. (Presione 3)");  
                           System.out.println("Ir atras. (Presione 4)"); 
                           System.out.println("");
                           System.out.print("Coloque su opcion: ");
                           
                           try
                            {   
                                opc6 = Integer.parseInt(lee.readLine());
                            } 
                                catch (Exception e) 
                            {
                                System.out.println("Opcion invalida ");
                            }
                           System.out.println(" ");
                           switch (opc6){
                               
                               case 1:
                                      int opc7=0;
                                      while (opc7!=4){
                                      System.out.println("¿Que tipo de vehiculo desea eliminar?.");
                                      System.out.println("Carga.  (Presione 1)");
                                      System.out.println("Camioneta. (Presione 2)");
                                      System.out.println("Liviano. (Presione 3)");  
                                      System.out.println("Ir atras. (Presione 4)"); 
                                      System.out.println("");
                                      System.out.print("Coloque su opcion: ");
                           
                                      try
                                      {   
                                          opc7 = Integer.parseInt(lee.readLine());
                                      } 
                                          catch (Exception e) 
                                      {
                                          System.out.println("Opcion invalida ");
                                      }
                           
                                      switch (opc7){
                               
                                          case 1:
                                                 a_carga.eliminar_car(a_grupo);
                                                                    
                                                 break;
                                          case 2:
                                                 a_camioneta.eliminar_cam(a_grupo);
                                                                    
                                                 break;
                                          case 3:
                                                 a_liviano.eliminar_liv(a_grupo);
                                                                                                          
                                                 break;
                                          case 4:
                                                 break;
                                          default:
                                                  System.out.println("Datos invalidos, coloque un numero entre el 1 y 4: ");
                                                                    
                                                  break;
                               
                                             }
                       
                                         }
                                                                    
                                      break;
                               case 2:
                                      a_clientes.eliminar();
                                                                    
                                      break;
                               case 3:
                                      a_grupo.eliminar();
                                                                                                          
                                      break;
                               case 4:
                                     break;
                               default:
                                      System.out.println("Datos invalidos, coloque un numero entre el 1 y 4: ");
                                                                    
                                      break;
                               
                           }
                       
                        }
                        
                    
                    break;
                    
                    
                case 4: a_grupo.mostrar_grupos();
                    break;
                case 5: a_reservaciones.almacenar(a_clientes, a_grupo);
                    break;
                case 6: a_reservaciones.eliminar();
                    break;    
                case 7: int opc8=0;
                         while (opc8!=4){
                         System.out.println("¿Qué tipo de vehiculo desea alquilar?.");
                         System.out.println("Carga.  (Presione 1)");
                         System.out.println("Camioneta. (Presione 2)");
                         System.out.println("Liviano. (Presione 3)");  
                         System.out.println("Ir atras. (Presione 4)"); 
                         System.out.println("");
                         System.out.print("Coloque su opcion: ");
                           
                         try
                         {   
                             opc8 = Integer.parseInt(lee.readLine());
                         } 
                         catch (Exception e) 
                         {
                             System.out.println("Opcion invalida ");
                         }
                           
                         switch (opc8){
                               
                         case 1:
                                 alq_carga.almacenar(a_reservaciones, a_grupo, alq_camioneta, alq_liviano, a_clientes);
                                                                    
                                 break;
                         case 2:
                                 alq_camioneta.almacenar(a_reservaciones, a_grupo, alq_carga, alq_liviano, a_clientes,a_camioneta);
                                                                    
                                 break;
                         case 3:
                                alq_liviano.almacenar(a_reservaciones, a_grupo, alq_camioneta, alq_carga, a_clientes);
                                                                                                          
                                break;
                         case 4:
                         break;
                               default:
                                       System.out.println("Datos invalidos, coloque un numero entre el 1 y 4: ");
                                                                    
                                       break;
                               
                         }
                       
                     }
                    break;  
                
                case 8: int opc9=0;
                         while (opc9!=4){
                         System.out.println("¿Qué tipo de vehiculo desea entregar?.");
                         System.out.println("Carga.  (Presione 1)");
                         System.out.println("Camioneta. (Presione 2)");
                         System.out.println("Liviano. (Presione 3)");  
                         System.out.println("Ir atras. (Presione 4)"); 
                         System.out.println("");
                         System.out.print("Coloque su opcion: ");
                           
                         try
                         {   
                             opc9 = Integer.parseInt(lee.readLine());
                         } 
                         catch (Exception e) 
                         {
                             System.out.println("Opcion invalida ");
                         }
                           
                         switch (opc9){
                               
                         case 1:
                                 alq_carga.entrega(alq_camioneta, alq_liviano, a_clientes, a_grupo, a_reservaciones);
                                                                    
                                 break;
                         case 2:
                                 alq_camioneta.entrega(alq_carga, alq_liviano, a_clientes, a_grupo, a_reservaciones, a_camioneta);
                                                                    
                                 break;
                         case 3:
                                alq_liviano.entrega(alq_camioneta, alq_carga, a_clientes, a_grupo, a_reservaciones, a_liviano);
                                                                                                          
                                break;
                         case 4:
                         break;
                               default:
                                       System.out.println("Datos invalidos, coloque un numero entre el 1 y 4: ");
                                                                    
                                       break;
                               
                         }
                       
                     }
                    break;
                case 9:System.out.println("La cantidad de clientes mayores a 65 años es:"+a_clientes.mas_65());
                       System.out.println("LA cedula es"+a_reservaciones.arr_reservaciones[0].ced_cli);             
                    break;
                case 10:arch_grupo.escribir(a_grupo);
                        arch_cliente.escribir(a_clientes);
                        arch_reserv.escribir(a_reservaciones);
                        arch_vehiculos.escribir(a_carga, a_camioneta, a_liviano);
                        arch_alquileres.escribir(alq_carga, alq_camioneta, alq_liviano);
                        
                System.out.println("Datos Guardados. ");
                    break;
                default:System.out.println("Datos invalidos, coloque un numero entre el 1 y 10: ");
                    break;
            }
            
            
        }
        
        
    }
}