/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventaboletos;
import java.io.*;


class Boleto{
    
    int nvuelo=0;
    String asiento="";
    String clase="";
    double tarifa=0;
    
    void llenar(int v, String as, String cl, double tar){
        nvuelo=v;
        asiento=as;
        clase=cl;
        tarifa=tar;
    }
    
}
    
    
class Cliente{
        
        int cedula=0;
        String nombre="";
        String apellido="";
        String direccion="";
        String telefono="";
        Boleto boleto=new Boleto();
        
        void Almacenar(int v,String  a,String b, double tar){
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Coloque la cedula cedula del cliente: ");
        try                                                      
        {
            cedula = Integer.parseInt(lee.readLine());
        } 
        catch (Exception e) 
        {
            System.out.println("Coloque un numero entero ");
        }
        
        System.out.print("Coloque el nombre: ");
        try 
        {
            nombre = lee.readLine();
        } 
        catch (Exception e) 
        {
            System.out.println(" ");
        }
        
        System.out.print("Coloque el apellido: ");
        try 
        {
            apellido = lee.readLine();
        } 
        catch (Exception e) 
        {
            System.out.println(" ");
        }
        
        System.out.print("Coloque la direccion: ");
        try 
        {
            direccion = lee.readLine();
        } 
        catch (Exception e) 
        {
            System.out.println("");
        }
        
        System.out.print("Coloque el telefono: ");
        try 
        {
            telefono = lee.readLine();
        } 
        catch (Exception e) 
        {
            System.out.println("");
        }
        
        boleto.llenar(v,a,b,tar);
    
    }
        
}
    
class Avion{
    
    Cliente [][] asientos = new Cliente [16][6];
     
    void Instanciar(){
        
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 6; j++) {                
                asientos[i][j]= new Cliente();                
            }
        }       
    }
    
    void Insertar_Cliente(int v,double t){
        
        int i=0,j=0;
        String col="",a="",b="";
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Coloque el asiento que desea comprar: ");
        
        System.out.print("Coloque la fila (1-16): ");
        try 
        { 
            a =lee.readLine();
            i = Integer.parseInt(a)-1;
        } 
        catch (Exception e) 
        {
            System.out.println(" ");
        }
        
        System.out.print("Coloque la Columna (A-F): ");
        try 
        {
            col = lee.readLine();
        } 
        catch (Exception e) 
        {
            System.out.println(" ");
        }
        
        if (col.equalsIgnoreCase("a")) {
            j=0;
        }
        if (col.equalsIgnoreCase("b")) {
            j=1;
        }
        if (col.equalsIgnoreCase("c")) {
            j=2;
        }
        if (col.equalsIgnoreCase("d")) {
            j=3;
        }
        if (col.equalsIgnoreCase("e")) {
            j=4;
        }
        if (col.equalsIgnoreCase("f")) {
            j=5;
        }
        
        
        if (asientos[i][j].cedula==0) {
            System.out.println("Asiento disponible. Coloque los datos del cliente: ");
            System.out.println("");
            double tar=0;
            if (i<3) {
                b="A";
                tar=t*1.25;
            } else {
                if (i<8) {
                    b="B";
                    tar=t*1.15;
                } else {
                    if (i<16) {
                        b="C";
                        tar=t;
                    }
                }
            }
            
            
            
            
            asientos[i][j].Almacenar(v,a+col,b,tar);  
            System.out.println("Cliente almacenado.");
            
        } else{
            
            System.out.println("Error asiento no disponible.");
            
        }
        
        
    }
    
    
}  



    
    
    
class Vuelo{
    
    int nro=0;
    String origen="";
    String destino="";
    String h_salida="";
    double tarifa=0;
    Avion avion = new Avion();
    
    void abrir(int numero){
        
        
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        nro=numero;
        
        System.out.print("Coloque el origen del vuelo: ");
        try                                                      
        {
            origen = lee.readLine();
        } 
        catch (Exception e) 
        {
            System.out.println("");
        }
        System.out.print("Coloque el destino del vuelo: ");
        try 
        {
            destino = lee.readLine();
        } 
        catch (Exception e) 
        {
            System.out.println("");
        }
        System.out.print("Coloque la hora de salida: ");
        try 
        {
            h_salida = lee.readLine();
        } 
        catch (Exception e) 
        {
            System.out.println(" ");
        }
        System.out.print("Coloque la tarifa: ");
        try 
        {
            tarifa = Double.parseDouble(lee.readLine());
        } 
        catch (Exception e) 
        {
            System.out.print("Debe introducir un numero. ");
        }
        avion.Instanciar();
        
    } 
    
    void mostrar(){
        
        System.out.println("Vuelo número "+nro);
        System.out.println("Origen "+origen);
        System.out.println("Destino "+destino);
        System.out.println("Tarifa "+tarifa);
        System.out.println("Hora de salida "+h_salida);
        System.out.println("");
        
    }
    
    void Comprar_Boleto(int v){
        
        avion.Insertar_Cliente(v,tarifa);    
        
    }
    
}

class AVuelos {
    
    Vuelo[] vuelos = new Vuelo[10];
    
    void instanciar(){
        
        for (int i = 0; i < 10; i++) {
            vuelos[i] = new Vuelo();
            vuelos[i].nro=0;
        }
    }
    
    void abrir(){
        
        for (int i = 0; i < 10; i++) {
            
            if (vuelos[i].nro==0) {
                vuelos[i].abrir(i+1);
                break;
            }
            if (i==9) {
                System.out.println("Error no se pueden abrir mas vuelos.");
            }
            
        }       
        
    }
    
    void almacenar(){
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        int nvuelo=0;
        System.out.println("Indique el vuelo que desea comprar: ");
        System.out.println("");
        int i =0;
        
        while (vuelos[i].nro!=0){
                        
            vuelos[i].mostrar();
            i+=1;
        }    
        
        try 
        {
            nvuelo = Integer.parseInt(lee.readLine())-1;
        } 
        catch (Exception e) 
        {
            System.out.println("Debe introducir un numero. ");
        }
        
        vuelos[nvuelo].Comprar_Boleto(i);
        
        
        
    }
}



class Archivos{
    
    void escribir_cliente (AVuelos obj){
        
       try {
            File f = new File("Clientes.txt");
            FileWriter linea = new FileWriter(f, false);
            int i=0;
            while (obj.vuelos[i].nro!=0){
                for (int j = 0; j < 16; j++) {
                    for (int k = 0; k < 6; k++) {
                        if (obj.vuelos[i].avion.asientos[j][k].cedula!=0) {                        
                        
                            linea.write(obj.vuelos[i].avion.asientos[j][k].cedula+"/"+obj.vuelos[i].avion.asientos[j][k].nombre+"/"+obj.vuelos[i].avion.asientos[j][k].apellido+"/"+obj.vuelos[i].avion.asientos[j][k].direccion+"/"+obj.vuelos[i].avion.asientos[j][k].telefono+"\r\n");
                        }
                    }                    
                }                    
               i+=1;       
               
            }
            linea.close();
            
        } catch (Exception e) {
            System.out.println("Error en el archivo clientes.");
        }
        
        
    }
    
     void escribir_vuelos (AVuelos obj){
         
         try {
            File f = new File("Vuelos.txt");
            FileWriter linea = new FileWriter(f, false);
            int i=0;
            while (obj.vuelos[i].nro!=0){
               linea.write(obj.vuelos[i].nro+"/"+obj.vuelos[i].origen+"/"+obj.vuelos[i].destino+"/"+obj.vuelos[i].h_salida+"/"+obj.vuelos[i].tarifa+"\r\n");                    
               i+=1;       
               
            }
            linea.close();
            
        } catch (Exception e) {
            System.out.println("Error en el archivo vuelos.");
        }
         
         
     }
     
     void escribir_boletos (AVuelos obj){
        
       try {
            File f = new File("Boletos.txt");
            FileWriter linea = new FileWriter(f, false);
            int i=0;
            while (obj.vuelos[i].nro!=0){
                for (int j = 0; j < 16; j++) {
                    for (int k = 0; k < 6; k++) {
                        if (obj.vuelos[i].avion.asientos[j][k].cedula!=0) {                        
                        
                            linea.write(obj.vuelos[i].avion.asientos[j][k].cedula+"/"+obj.vuelos[i].avion.asientos[j][k].boleto.nvuelo+"/"+obj.vuelos[i].avion.asientos[j][k].boleto.asiento+"/"+obj.vuelos[i].avion.asientos[j][k].boleto.clase+"/"+obj.vuelos[i].avion.asientos[j][k].boleto.tarifa+"\r\n");
                        }
                    }                    
                }                    
               i+=1;       
               
            }
            linea.close();
            
        } catch (Exception e) {
            System.out.println("Error en el archivo clientes.");
        }
        
        
    }
    
    
}




public class VentaBoletos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc=0;
        AVuelos obj = new AVuelos();
        Archivos obj1= new Archivos();
        obj.instanciar();
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        
        while (opc!=4){
            System.out.println("");
            System.out.println("Coloque la opcion: ");
            System.out.println("1 para abrir vuelo. ");
            System.out.println("2 para comprar un boleto. ");
            System.out.println("3 para reportes. ");
            System.out.println("4 para salir. ");
            System.out.print("Opcion: ");
            try {
            opc=Integer.parseInt(lee.readLine());
            } catch (Exception e) {
            }
            switch(opc)
            {
                case 1:
                  obj.abrir();
                  break;
                            
                case 2:
                  obj.almacenar();
                  break;
                            
                case 3:
                        int i=0;
                        double MTA=0;
                        double MTB=0;
                        double MTC=0;
                        int CBVA=0;
                        int CBVB=0;
                        int CBVC=0;
                        
                        while (obj.vuelos[i].nro!=0){
                            for (int j = 0; j < 3; j++) {
                                for (int k = 0; k < 6; k++) {
                                    if (obj.vuelos[i].avion.asientos[j][k].cedula!=0) {                        
                                        MTA += obj.vuelos[i].tarifa * 1.25;
                                        CBVA+=1;
                                    }
                                }                    
                            }                    
                        i+=1;       
               
                        }
                        i=0;
                        while (obj.vuelos[i].nro!=0){
                            for (int j = 3; j < 8; j++) {
                                for (int k = 0; k < 6; k++) {
                                    if (obj.vuelos[i].avion.asientos[j][k].cedula!=0) {                        
                                        MTB += obj.vuelos[i].tarifa * 1.15;
                                        CBVB+=1;
                                    }
                                }                    
                            }                    
                        i+=1;       
               
                        }
                        i=0;
                        while (obj.vuelos[i].nro!=0){
                            for (int j = 8; j < 16; j++) {
                                for (int k = 0; k < 6; k++) {
                                    if (obj.vuelos[i].avion.asientos[j][k].cedula!=0) {                        
                                        MTC += obj.vuelos[i].tarifa;
                                        CBVC+=1;
                                    }
                                }                    
                            }                    
                        i+=1;       
               
                        }
                        
                            System.out.println("Monto total de la venta: "+(MTA+MTB+MTC));
                            System.out.println("Cantidad total de boletos vendidos: "+(CBVA+CBVB+CBVC));
                            System.out.println("Monto total de ventas de las Clases: ");
                            System.out.println("A: "+MTA);
                            System.out.println("B: "+MTB);
                            System.out.println("C: "+MTC);
                            System.out.println("Cantidad total de boletos vendidos de las Clases: ");
                            System.out.println("A: "+CBVA);
                            System.out.println("B: "+CBVB);
                            System.out.println("C: "+CBVC);
                  break;
                case 4:
                  obj1.escribir_boletos(obj);
                  obj1.escribir_cliente(obj);
                  obj1.escribir_vuelos(obj);
                  break;
                default: break;    
            }
        }
        
    }

    
    
}
