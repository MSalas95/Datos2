/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alumno;

import static java.awt.PageAttributes.MediaType.A;
import java.io.*;
import java.util.StringTokenizer;

class Alumnos{
    
    String nombre="";
    String apellido="";
    int cedula=0;
    int edad=0;
    String sexo="";
    float nota1=0;
    float nota2=0;
    float nota3=0;
    
    void almacenar(Archivos obj){
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Coloque los siguientes datos:");
        
        System.out.print("Nombre: ");
        try 
        {
            nombre = lee.readLine();
        }
        catch  (Exception e)
        {
            System.out.print("");
        }
        
        System.out.print("Apellido: ");
        try 
        {
            apellido = lee.readLine();
        }
        catch  (Exception e)
        {
            System.out.print("");
        }
        
        System.out.print("Cédula: ");
        try 
        {
            cedula = Integer.parseInt(lee.readLine());
        }
        catch  (Exception e)
        {
            System.out.print("Coloque un nro");
        }
        
        System.out.print("Edad: ");
        try 
        {
            edad = Integer.parseInt(lee.readLine());
        }
        catch  (Exception e)
        {
            System.out.print("Coloque un nro ");
        }
        
        while ((!(sexo.equalsIgnoreCase("M"))) && (!(sexo.equalsIgnoreCase("F")))) {
            
            System.out.print("Sexo(M/F): ");
        
            try 
            {
                sexo = lee.readLine();
            } 
            catch (Exception e) 
            {
                System.out.println(" ");
            }
        }
        
        System.out.print("Nota 1: ");
        try 
        {
            nota1 = Float.parseFloat(lee.readLine());
        }
        catch  (Exception e)
        {
            System.out.print("");
        }
        
        System.out.print("Nota 2: ");
        try 
        {
            nota2 = Float.parseFloat(lee.readLine());
        }
        catch  (Exception e)
        {
            System.out.print("");
        }
        
        System.out.print("Nota 3: ");
        try 
        {
            nota3 = Float.parseFloat(lee.readLine());
        }
        catch  (Exception e)
        {
            System.out.print("");
        }
        
        obj.escribir(this);
        
        System.out.println("Alumno Almacenado.");
        
        
    }
    void mostrar (){
        System.out.print("Nombre: ");
        System.out.println(nombre);
        System.out.print("Apellido: ");
        System.out.println(apellido);
                        
        System.out.print("Cedula: ");
        System.out.println(cedula);
                        
        System.out.print("Edad: ");
        System.out.println(edad);
                        
        System.out.print("Sexo: ");
        System.out.println(sexo);
                        
        System.out.print("Nota 1: ");
        System.out.println(nota1);
                        
        System.out.print("Nota 2: ");
        System.out.println(nota2);
                        
        System.out.print("Nota 3: ");
        System.out.println(nota3);
        
        
    }
    
}
class Archivos{
    
    void escribir (Alumnos obj){
        
       try {
            File f = new File("Alumnos.txt");
            FileWriter linea = new FileWriter(f,true);
                 
               linea.write(obj.nombre+", "+obj.apellido+", "+obj.cedula+", "+obj.edad+", "+obj.sexo+", "+obj.nota1+", "+obj.nota2+", "+obj.nota3+"\r\n");
            
            linea.close();
            
        } catch (Exception e) {
            System.out.println("Error en escribir en el archivo Alumnos.");
        }    
        
    }
    
    void consultar(Alumnos obj, int ced){        
        try 
        {
            File A = new File("Alumnos.txt");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea = "";
            boolean fin=false;
            
            while ((linea = leer.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(linea, ", ");
                while (tokens.hasMoreTokens()) {                    
                    
                    obj.nombre=tokens.nextToken();
                    obj.apellido=tokens.nextToken();
                    obj.cedula=Integer.parseInt(tokens.nextToken());
                    obj.edad=Integer.parseInt(tokens.nextToken());
                    obj.sexo=tokens.nextToken();
                    obj.nota1=Float.parseFloat(tokens.nextToken());
                    obj.nota2=Float.parseFloat(tokens.nextToken());
                    obj.nota3=Float.parseFloat(tokens.nextToken());
                    
                    if (ced==obj.cedula) {
                        System.out.println("Consulta:");
                        
                        obj.mostrar();
                        fin=true;
                        break;
                    }
                    
                }               
                if (fin==true) {
                    break;
                }
               linea=""; 
            }
            if (fin==false) {
                System.out.println("Alumno no encontrado.");
            }
            
            
        } catch (Exception e) {
            System.out.println("Error en consultar.");
        }
        
        
        
        
    }
    
    void modificar (Alumnos obj, int ced){
        try 
        {
            File A = new File("Alumnos.txt");            
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea = "";
            boolean fin=false;
            Alumnos[] array = new Alumnos[100];
            for (int i = 0; i < 100; i++) {
                array[i]=new Alumnos();
            }
            int j=-1;
            
            while ((linea = leer.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(linea, ", ");
                while (tokens.hasMoreTokens()) {                    
                    j=j+1;
                    array[j].nombre=tokens.nextToken();
                    array[j].apellido=tokens.nextToken();
                    array[j].cedula=Integer.parseInt(tokens.nextToken());
                    array[j].edad=Integer.parseInt(tokens.nextToken());
                    array[j].sexo=tokens.nextToken();
                    array[j].nota1=Float.parseFloat(tokens.nextToken());
                    array[j].nota2=Float.parseFloat(tokens.nextToken());
                    array[j].nota3=Float.parseFloat(tokens.nextToken());
                }
                linea="";
            }    
            for (int h = 0; h < 100; h++) {              
   
                if (ced==array[h].cedula) {
                    BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
                    int opc=0;
                    while(opc!=8){                            
                            System.out.println("");
                            System.out.println("¿Qué desea modificar? ");
                            System.out.println("Nombre   (1) ");
                            System.out.println("Apellido (2) ");
                            System.out.println("Edad     (3) ");
                            System.out.println("Sexo     (4) ");
                            System.out.println("Nota 1   (5) ");
                            System.out.println("Nota 2   (6) ");
                            System.out.println("Nota 3   (7) ");
                            System.out.println("Salir    (8) ");

                            System.out.print("Opcion: ");
                            try {
                            opc=Integer.parseInt(lee.readLine());
                            } catch (Exception e) {
                            }
                             
                             
                            switch(opc)
                            {
                                case 1:  System.out.print("Nombre: ");
                                         try 
                                        {
                                        array[h].nombre = lee.readLine();
                                        }
                                        catch  (Exception e)
                                        {
                                        System.out.print("");
                                        }
                                    break;
                                case 2:  System.out.print("Apellido: ");
                                         try 
                                        {
                                        array[h].apellido = lee.readLine();
                                        }
                                        catch  (Exception e)
                                        {
                                        System.out.print("");
                                        }
                                    break;
                                case 3: System.out.print("Edad: ");
                                        try 
                                        {
                                        array[h].edad = Integer.parseInt(lee.readLine());
                                        }
                                        catch  (Exception e)
                                        {
                                        System.out.print("");
                                        }
                                    break;
                                case 4: array[h].sexo="*";
                                        while ((!(array[h].sexo.equalsIgnoreCase("M"))) && (!(array[j].sexo.equalsIgnoreCase("F")))) {
                                            System.out.print("sexo: ");
                                            try 
                                            {
                                            array[h].sexo = lee.readLine();
                                            }
                                            catch  (Exception e)
                                            {
                                            System.out.print("");
                                            }
                                        }
                                    break;    
                                case 5: System.out.print("Nota 1: ");
                                        try 
                                        {
                                        array[h].nota1 = Float.parseFloat(lee.readLine());
                                        }
                                        catch  (Exception e)
                                        {
                                        System.out.print("");
                                        }
                                    break;    
                                case 6: System.out.print("Nota 2: ");
                                        try 
                                        {
                                        array[h].nota2 = Float.parseFloat(lee.readLine());
                                        }
                                        catch  (Exception e)
                                        {
                                        System.out.print("");
                                        }
                                    break;
                                case 7: System.out.print("Nota 3: ");
                                        try 
                                        {
                                        array[h].nota3 = Float.parseFloat(lee.readLine());
                                        }
                                        catch  (Exception e)
                                        {
                                        System.out.print("");
                                        }
                                    break;    
                                case 8:
                                    break;                                 
                                default:
                                    break;
                                    
                            }           
                            
                    }
                        
                    FileWriter line = new FileWriter(A, false);
                        
                        
                    for (int k = 0; k <= j; k++) {
                        line.write(array[k].nombre+", "+array[k].apellido+", "+array[k].cedula+", "+array[k].edad+", "+array[k].sexo+", "+array[k].nota1+", "+array[k].nota2+", "+array[k].nota3+"\r\n");
                    }           
                        
                    line.close();
                    fin=true;
                    
                    }
                }
                  
                   
            
            if (fin==false) {
                System.out.println("Alumno no encontrado.");
            }
            
            
        } catch (Exception e) {
            System.out.println("Error en modificar.");
        }
        
    }
    
    void mostar_aprobados(Alumnos obj) {
        
        try 
        {
            
            File A = new File("Alumnos.txt");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea = "";
            
            
            while ((linea = leer.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(linea, ", ");
                while (tokens.hasMoreTokens()) {                    
                    
                    obj.nombre=tokens.nextToken();
                    obj.apellido=tokens.nextToken();
                    obj.cedula=Integer.parseInt(tokens.nextToken());
                    obj.edad=Integer.parseInt(tokens.nextToken());
                    obj.sexo=tokens.nextToken();
                    obj.nota1=Float.parseFloat(tokens.nextToken());
                    obj.nota2=Float.parseFloat(tokens.nextToken());
                    obj.nota3=Float.parseFloat(tokens.nextToken());
                    
                    if ((obj.nota1+obj.nota2+obj.nota3)/3>=9.5) {
                        System.out.println("");                        
                        obj.mostrar();
                    }
                    
                }               
                
               linea=""; 
            }        
            
        } catch (Exception e) {
        }
        
        
    }   
    
    void mostar_reprobados(Alumnos obj) {
        
        try 
        {
            
            File A = new File("Alumnos.txt");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea = "";
            
            
            while ((linea = leer.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(linea, ", ");
                while (tokens.hasMoreTokens()) {                    
                    
                    obj.nombre=tokens.nextToken();
                    obj.apellido=tokens.nextToken();
                    obj.cedula=Integer.parseInt(tokens.nextToken());
                    obj.edad=Integer.parseInt(tokens.nextToken());
                    obj.sexo=tokens.nextToken();
                    obj.nota1=Float.parseFloat(tokens.nextToken());
                    obj.nota2=Float.parseFloat(tokens.nextToken());
                    obj.nota3=Float.parseFloat(tokens.nextToken());
                    
                    if ((obj.nota1+obj.nota2+obj.nota3)/3<9.5) {
                        System.out.println("");                        
                        obj.mostrar();
                    }
                    
                }               
                
               linea=""; 
            }        
            
        } catch (Exception e) {
        }
        
        
    }
    
    float promedio_edades(Alumnos obj){
        
        try 
        {
            
            File A = new File("Alumnos.txt");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea = "";
            int edades=0,i=0;
            float prom=0;
            
            while ((linea = leer.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(linea, ", ");
                while (tokens.hasMoreTokens()) {                    
                    
                    obj.nombre=tokens.nextToken();
                    obj.apellido=tokens.nextToken();
                    obj.cedula=Integer.parseInt(tokens.nextToken());
                    obj.edad=Integer.parseInt(tokens.nextToken());
                    obj.sexo=tokens.nextToken();
                    obj.nota1=Float.parseFloat(tokens.nextToken());
                    obj.nota2=Float.parseFloat(tokens.nextToken());
                    obj.nota3=Float.parseFloat(tokens.nextToken());
                    i=i+1;
                    edades=edades+obj.edad;
                    
                }               
                
               linea=""; 
            }
        prom= edades/i;
        return prom;
            
        } catch (Exception e) {
        }
        return 0;
        
    }    
        
    
    
    void mostrar_ultimo(Alumnos obj){
        
        try 
        {
            
            File A = new File("Alumnos.txt");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea = "";
            Alumnos obj2=new Alumnos();
            
            while ((linea = leer.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(linea, ", ");
                while (tokens.hasMoreTokens()) {                    
                    
                    obj.nombre=tokens.nextToken();
                    obj.apellido=tokens.nextToken();
                    obj.cedula=Integer.parseInt(tokens.nextToken());
                    obj.edad=Integer.parseInt(tokens.nextToken());
                    obj.sexo=tokens.nextToken();
                    obj.nota1=Float.parseFloat(tokens.nextToken());
                    obj.nota2=Float.parseFloat(tokens.nextToken());
                    obj.nota3=Float.parseFloat(tokens.nextToken());                    
                    
                    
                    if (((obj.nota1+obj.nota2+obj.nota3)/3<=16)) {                        
                        if (((obj.nota1+obj.nota2+obj.nota3)/3>=12)) {                            
                            if ((obj.edad>promedio_edades(obj2))) {                                
                                if ((obj.sexo.equalsIgnoreCase("m"))) {
                                    System.out.println("");
                                    obj.mostrar();
                                }                              
                            }
                        }
                    }                    
                }                        
               linea=""; 
            }        
            
        } catch (Exception e) {
        }
        
    }
}
    
    




public class Alumno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        Alumnos obj = new Alumnos();
        Archivos obj2 = new Archivos();
        
        
        int opc=0,ced=0;
        
        while(opc!=7){
            System.out.println("");
            System.out.println("Coloque la opcion: ");
            System.out.println("Ingresar Alumno           (1). ");
            System.out.println("Consultar Alumno          (2). ");
            System.out.println("Modificar                 (3) ");
            System.out.println("Mostrar Alumnos Aprobados (4) ");
            System.out.println("Mostrar Alumnos Reprobados(5) ");
            System.out.println("Mostrar Ultimo            (6) ");
            System.out.println("Salir                     (7) ");
            System.out.print("Opcion: ");
            try {
            opc=Integer.parseInt(lee.readLine());
            } catch (Exception e) {
            }
            
            
            switch(opc)
            {
                case 1: obj.almacenar(obj2);
                    break;
                case 2: 
                    System.out.print("Coloque la cédula: ");
                    try 
                    {
                        ced = Integer.parseInt(lee.readLine());
                    } 
                    catch (Exception e) 
                    {
                    }
                    System.out.println("");
                    obj2.consultar(obj, ced);
                    break;
                case 3:
                    System.out.print("Coloque la cédula: ");
                    try 
                    {
                        ced = Integer.parseInt(lee.readLine());
                    } 
                    catch (Exception e) 
                    {
                    }
                    System.out.println("");
                    obj2.modificar(obj, ced);
                    break;
                case 4: obj2.mostar_aprobados(obj);
                    break;
                case 5: obj2.mostar_reprobados(obj);
                    break;
                case 6: obj2.mostrar_ultimo(obj);
                    break;
                case 7: 
                    break;
                default:
                    break;                    
            }
            
            
            
        }
        
    }
    
}
