/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package preparaduria;

import java.io.*;

/**
 *
 * @author Manuel
 */
class Empleado {
    //ATRIBUTOS

    int cedula=0, anoi;
    String nombre, apellido, profesion;

    //METODOS
    void almacenar() {
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introduzca su cedula ");
        while (cedula==0) {
            try {
                cedula = Integer.parseInt(lee.readLine());

            } catch (Exception e) {
                System.out.print("Cedula invalida ");
            }
        }
        
        System.out.print("Introduzca su Nombre ");
        nombre= lee.readLine();
        System.out.print("Introduzca su Apellido ");
        apellido= lee.readLine();
        System.out.print("Introduzca su profesion ");
        profesion= lee.readLine();
        
    }
}

class ArregloE {

    Empleado[] a = new Empleado[20];

    void instanciar() {
        for (int i = 0; i < 20; i++) {
            a[i] = new Empleado();
        }
    }

    void almacenar() {
        int i = 0;
        while ((a[i]!=0)&&(i<20)) {
            i=i++;
        }
        if(i<20){
            
        }
    }
}

public class Preparaduria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArregloE obj = new ArregloE();
        obj.instanciar();

        System.out.println("Hola Mundo");
    }
}
