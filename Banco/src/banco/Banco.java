/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class NTaquilla{    //Nodo taquilla
    
    NTaquilla sig=null;      //apuntador a siguiente
    boolean disponible=true;//aributo que dice si esta disponible la taquilla  
    NPila P=null,tope=null;  //Apuntador a la pila y al tope
    int cont=0; //contador de la pila
    int x=0;
     boolean vacio(){            
         return cont==0;        
    }
     
     void push(String trans){  //Agrega un nodo a la pila
                           
        NPila NN= new NPila();
        NN.llenar(trans);
            
        NN.sig=P;
        NN.sig=tope;
        P=NN;
        tope=NN;
        cont=cont+1;
            
    }
    
    void pop(){ // Saca un nodo de la pila
        
        NPila aux;
        aux=P;
        
        if (vacio()==true){            
            System.out.println("Error, pila vacia.");            
        } else {            
            P=aux.sig;
            tope=aux.sig;
            cont=cont-1;
        }           
    }
    
}

class ListaTaquillas{ //lista de taquillas

    NTaquilla L=null; 
    
    void insertar(){   // inserta las 4 taquillas
        for (int i = 0; i < 4; i++) {
            almacenar(L);
        }        
    }
    
    void almacenar(NTaquilla aux){        
           
        if (L == null) {
            NTaquilla nodo_nuevo= new NTaquilla();            
            L=nodo_nuevo;
            nodo_nuevo.sig= L;
        }else{
            if (aux.sig==L) {
                   NTaquilla nodo_nuevo= new NTaquilla();
                   aux.sig=nodo_nuevo;
                   
                   nodo_nuevo.sig=L;
                   L=nodo_nuevo;       
                   
            } else{
                almacenar(aux.sig);
            }               
        }        
    }
    
    void asignar_tiempo(Cliente C,int i){
        if (C.sig!=null) {
          C.tcola=i;    
        asignar_tiempo(C.sig,i);  
        }
        
    }
    
    void atender(ColaClientes cola, int duracion){
        int a=0,b=0,c=0,d=0;
        
        for (int i = 0; i < duracion*2; i++) { 
                        
            asignar_tiempo(cola.Q,i);
            
            if (L.disponible==true) {  //taquilla 1
                if (cola.fte.transaccion.equalsIgnoreCase("retiro")){
                    a=8;
                    L.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("deposito")){
                    a=4;
                    L.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("consulta")){
                    a=7;
                    L.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("actualizacion")){
                    a=10;
                    L.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("pagos")){
                    a=4;
                    L.disponible=false;
                }
                
                System.out.println("Se ha atendido a: "+cola.fte.nombre);
                cola.desencolar();
                
            } else {
                if (i%a==0) {
                    L.disponible=true;
                    a=0;
                }
            }
            
            if (L.sig.disponible==true) {  //taquilla 2
                if (cola.fte.transaccion.equalsIgnoreCase("retiro")){
                    b=8;
                    L.sig.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("deposito")){
                    b=4;
                    L.sig.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("consulta")){
                    b=7;
                    L.sig.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("actualizacion")){
                    b=10;
                    L.sig.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("pagos")){
                    b=4;
                    L.sig.disponible=false;
                }
                System.out.println("Se ha atendido a: "+cola.fte.nombre);
                cola.desencolar();
            } else {
                if (i%b==0) {
                    L.sig.disponible=true;
                    b=0;
                    
                }
            }
            
            if (L.sig.sig.disponible==true) {  //taquilla 3
                if (cola.fte.transaccion.equalsIgnoreCase("retiro")){
                    c=8;
                    L.sig.sig.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("deposito")){
                    c=4;
                    L.sig.sig.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("consulta")){
                    c=7;
                    L.sig.sig.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("actualizacion")){
                    c=10;
                    L.sig.sig.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("pagos")){
                    c=4;
                    L.sig.sig.disponible=false;
                }
                 System.out.println("Se ha atendido a: "+cola.fte.nombre);
                cola.desencolar();
            } else {
                if (i%c==0) {
                    L.sig.sig.disponible=true;
                    c=0;
                                  }
            }
            
            if (L.sig.sig.sig.disponible==true) {  //taquilla 4
                if (cola.fte.transaccion.equalsIgnoreCase("retiro")){
                    d=8;
                    L.sig.sig.sig.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("deposito")){
                    d=4;
                    L.sig.sig.sig.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("consulta")){
                    d=7;
                    L.sig.sig.sig.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("actualizacion")){
                    d=10;
                    L.sig.sig.sig.disponible=false;
                }
                if (cola.fte.transaccion.equalsIgnoreCase("pagos")){
                    d=4;
                    L.sig.sig.sig.disponible=false;
                }
                 System.out.println("Se ha atendido a: "+cola.fte.nombre);
                cola.desencolar();
            } else {
                if (i%d==0) {
                    L.sig.disponible=true;
                    
                    d=0;
                   
                }
            }
            
        }
        
    }
    
}
        

class NPila{ //Nodo de la pila de transacciones
    
    NPila sig=null;
    String transaccion="";
    
    void llenar(String trans){
        
        transaccion = trans;
    }
    
    
}


class Cliente{ // Nodo de Clientes
    
    String nombre,transaccion;
    Cliente sig=null,ant=null;
    double tcola=0;
    
    void almacenar( String a, String b){
        nombre=a;
        transaccion=b;          
    }
        
}

class ColaClientes{ //Cola de clientes
    
    Cliente fte=null,fdo=null,Q=null;
       
    
     void encolar( String a, String b){
        
         if (fte==null) {
                
                Cliente CN=new Cliente();
                CN.almacenar(a,b); 
                fte=CN;
                fdo=CN;
                Q=fte;                
                
            } else {
                if (fdo!=null) {
                    
                    Cliente CN=new Cliente();
                    CN.almacenar(a,b);
                    CN.ant=fdo;
                    CN.sig=fdo.sig;
                    fdo.sig=CN;
                    if (fdo.sig!=null) {
                        
                        fdo.sig.ant=CN;
                    }
                    fdo=CN;                  
                    
                } else {
                    
                    Cliente CN=new Cliente();
                    CN.almacenar(a,b);
                    CN.sig=fte;
                    fte.ant=CN;
                    Q=CN;
                    fte=Q;
                    fdo=CN;
                }              
            }
        
    }
     
     void desencolar(){ //Desencola el frente
        
        if (fte!=null){
            
            fte=fte.sig;
            Q=fte;
            if (fte!=null) {
                fte.ant=null;
            }         
        }       
    }
}



class Archivos{
    
    void Leer_Clientes(ColaClientes cola){ //Lee los clientes del archivo Rockola.in
        
    try
    {
        File A = new File("Clientes.txt");
        FileInputStream A1 = new FileInputStream(A);
        BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
        String linea="", a="",b="";
        
        
        StringTokenizer tokens;
         
        while ((linea = leer.readLine()) != null) {                  
            
            tokens = new StringTokenizer(linea, " ");          
            
            a=tokens.nextToken();           
            
            while (tokens.hasMoreTokens()){                
              
                b=tokens.nextToken();
                
            }
            
            cola.encolar(a, b);
                      
        }       
    }
    catch(Exception E)
    {
        
        System.out.println("Error en la lectura de los Clientes.");
    }
    
    }
    
}

public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        ColaClientes cola = new ColaClientes();
        ListaTaquillas taquillas = new ListaTaquillas();
        Archivos obj = new Archivos();
        obj.Leer_Clientes(cola);        
        taquillas.insertar();
        int opc=0;
        
        while (opc != 3){
            
            System.out.println("Bienvenido al Banco Universal"+"\n");        
            System.out.println("1. Ingresar Cliente");        
            System.out.println("2. Atender Cliente");
            System.out.println("3. Salir");            
            System.out.println("Indique su opcion: "); 
            
            opc = Integer.parseInt(lee.readLine());
                    
            switch (opc){
                
                case 1: 
                    break;
                case 2: taquillas.atender(cola, 50);
                    break;
                case 3:
                    break;
                default:
                    break;                
                
            }
            
        }
        
        
        
        
        
        
        
        
    }
    
}
