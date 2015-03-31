/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alumnos;

import java.io.*;

class Alumno{
    
    String nombre="";
    String apellido="";
    int cedula=0;
    int edad=0;
    String sexo="";
    float nota1=0;
    float nota2=0;
    float nota3=0;
    
    void almacenar(){
        
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
        
        while ((!(sexo.equalsIgnoreCase("M"))) || (!(sexo.equalsIgnoreCase("F")))) {
            
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
        
        
        
        
    }
    
    
    
    
}



public class Alumnos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno obj = new Alumno();
        obj.almacenar();
    }
    
}
