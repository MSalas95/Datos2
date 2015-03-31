/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rockola;

import java.io.*;
import java.util.*;

//-------------------------------------------------------NODO CANCIONES---------------------------------------------------------------

class Canciones{ // Nodo de la lista canciones 
    
    Canciones sig=null, ant=null;
    int codigo1,codigo2;  //codigo1 son los ultimos 2 digitos del codigo, y el 2 son los primeros 6
    String nombre; //nombre de la cancion 
    
    void llenar(int cod1,int cod2, String nom){ //llena los valores de las canciones
        
        codigo1 = cod1; 
        codigo2 = cod2;
        nombre = nom;
        sig=null;
        ant=null;
        
    }  
}


//---------------------------------------------PILA DE ALBUMES------------------------------------------------------

class Album {    // Nodo de la pila de albumes
    
    String Nom_Artista; //nombre del artista
    int Nro_Album; //Codigo del album
    String Nom_Album; //Nombre del Album
    Album sig=null;
    Canciones L; // Apuntador a la lista de canciones.
    
    void llenar(String Nom_Ar, int Nro_Al, String Nom_Al){     //Llena los valore de los albumes   
        
        Nom_Artista = Nom_Ar;
        Nro_Album = Nro_Al;
        Nom_Album = Nom_Al;
        sig=null;
        
    } 
    
    void insertar_cancion(int cod1,int cod2, String nom){   //Inserta una cancion en un album;
        
        Canciones NN= new Canciones();
        NN.llenar(cod1,cod2,nom);            
        NN.sig=L;        
        L=NN;
              
    }
    
    boolean buscar_can (Canciones l, int c){  //Busca si la cancion existe dentro de la lista de canciones de un album.
        
        if (l==null) {
            return false;
            
        } else {
           if (l.codigo1==c) {
            return true;
            
            } else {
               return buscar_can (l.sig, c);
            
            } 
        }
    } 
}    

class Pila_Album{ //Pila de albumes
    
    Album P;
    Album tope;
    int cont=0;
    
    boolean vacio(){     //Verifica si la pila esta vacía
        if (cont==0){
            return true;
        }
        return false;        
    }
    
    boolean lleno(){   //Verifica si la pila esta llena
        if (cont==100){
            return true;            
        }
        return false;
    }
    
    int primero(){   //Devuelve el valor del tope de la pila
        
        if (tope!=null){
            return tope.Nro_Album;
        }        
        return 0;        
    }
    
    void push(String Nom_Ar, int Nro_Al, String Nom_Al){  //Agrega un nodo a la pila
        
        if (lleno()==true){
            System.out.println("Error, pila llena.");
        } else {
            
            Album NN= new Album();
            NN.llenar(Nom_Ar,Nro_Al,Nom_Al);
            
            NN.sig=P;
            NN.sig=tope;
            P=NN;
            tope=NN;
            cont=cont+1;
        }       
    }
    
    void pop(){ // Saca un nodo de la pila
        
        Album aux;
        aux=P;
        
        if (vacio()==true){            
            System.out.println("Error, pila vacia.");            
        } else {            
            P=aux.sig;
            tope=aux.sig;
            cont=cont-1;
        }           
    }
    
    boolean buscarC (Pila_Album pil, int C,int ccanc) {  //Busca un album y una cancion dentro del album
        
        boolean bol=false;
        
        while (P.Nro_Album!=C){                
            pil.push(P.Nom_Artista, P.Nro_Album, P.Nom_Album);
            pop();
        }
            
        if (P.Nro_Album==C) {            
            if (P.buscar_can(P.L, ccanc)==true) { //Busca la cancion dentro del album
                 bol=true;
            }
        }
           
        
            
        while (pil.vacio()!=true){                
            push(pil.P.Nom_Artista, pil.P.Nro_Album, pil.P.Nom_Album);
            pil.pop();
        }
        return bol;      
        
        
    }    
}

//-------------------------------DIPOLO DE CLIENTES-----------------------------

class Cliente{ //Nodo del dipolo de clientes
    
    int[] canciones=new int[5]; //arreglo de canciones
    int pago=0; //el pago del cliente
    boolean tipo; //secuencial o aleatorio
    Cliente sig=null,ant=null;
    int ccans; //candidad de canciones compradas por el cliente
    boolean prioridad=false;
    
    
    void llenar (int[] canc, int pag, boolean tip,int ccan,boolean prior){ //Llena los valores del dipolo
        
        ccans=ccan;
        for (int i = 0; i < 5; i++) {
            canciones[i]=0;
            canciones[i]=canc[i];
        }
                        
        pago = pag;        
        tipo= tip;
        prioridad= prior;
        sig=null;
        ant=null;  
        
        
    }  
}

class Dipolo_Cliente{ //Dipolo de clientes
    
    Cliente fte=null,f1=null,f0=null,Q=null;
    
    int cancprior=0; //cantidad de clientes con prioridad
    int cancsinprior=0; //cantidad de clientes con prioridad
    int totrep=0; //total de canciones reproducidad
    double totpagado=0; //total pagado en el dipolo
    
    String Escribir_Salida="";
    
    void Encolar(int[] canc, int pag, boolean tip, boolean prioridad,int ccans){ //Encola un cliente dependiendo de su prioridad.
        
        if (prioridad==true) { 
            if (fte==null) {
                
                Cliente CN=new Cliente();
                CN.llenar(canc, pag, tip,ccans,prioridad); 
                fte=CN;
                f1=CN;
                Q=fte;
                
                
            } else {
                if (f1!=null) {
                    
                    Cliente CN=new Cliente();
                    CN.llenar(canc, pag, tip,ccans,prioridad);
                    CN.ant=f1;
                    CN.sig=f1.sig;
                    f1.sig=CN;
                    if (f1.sig!=null) {
                        
                        f1.sig.ant=CN;
                    }
                    f1=CN;                  
                    
                } else {
                    
                    Cliente CN=new Cliente();
                    CN.llenar(canc, pag, tip,ccans,prioridad);
                    CN.sig=fte;
                    fte.ant=CN;
                    Q=CN;
                    fte=Q;
                    f1=CN;
                }              
            }
        } else {
            if (fte==null) {
                
                Cliente CN=new Cliente();
                CN.llenar(canc, pag, tip,ccans,prioridad);
                fte=CN;
                f0=CN;
                Q=fte;
            } else {
                
                if (f0!=null) {
                    
                    Cliente CN=new Cliente();
                    CN.llenar(canc, pag, tip,ccans,prioridad);                
                    CN.ant=f0;
                    f0.sig=CN; //revisar este metodo               
                    f0=CN;
                } else {
                    
                    Cliente CN=new Cliente();
                    CN.llenar(canc, pag, tip,ccans,prioridad);
                    CN.ant=f1;
                    f1.sig=CN;
                    f0=CN;
                }
                
            }
        }
    }

    void atender(Pila_Album palbum){ //Atiende un cliente
        
        if (fte.ccans<=5){ //si la cantidad de canciones es menor o igual a 5
            if (verificar_canciones(palbum)==true) { //busca las canciones en la pila de albumes                
                if (fte.prioridad==true) { //si es prioridad
                    cancprior+=1;
                } else {                    
                    cancsinprior+=1;
                }
                totrep+=fte.ccans; 
                
                float vuelto=0;
                float pagar=0;
                if (fte.ccans==1) {                     
                    pagar = 10;                
                } else {
                    if (fte.ccans==2) {
                        pagar = 20;
                    } else {
                        if ((fte.ccans==3)) {
                            pagar = 30;
                        } else {
                            if ((fte.ccans==4)) {
                                pagar = 35;
                            } else {
                                if ((fte.ccans==5)) {
                                    pagar = 40;
                                }
                            }
                        }
                
                    }
                }
                if (fte.prioridad==true) { //si es prioridad se le añade el 50% del valor                
                    pagar=pagar+(pagar/2);                
                }
            
                vuelto=fte.pago-pagar;
                if (vuelto<0) {                
                
                    Escribir_Salida+="Transaccion Cancelada, Motivo: Pago insuficiente."+"\r\n";
                    } else{
                        totpagado= totpagado + pagar;
                        if (fte.tipo==true) {
                
                        for (int i = 0; i < fte.canciones.length; i++) {
                            fte.canciones[i]=0;
                        }               
                
                    } else {
                
                        int ramdom=0;
                        
                        
                
                        while((fte.canciones[0]!=0)|| (fte.canciones[1]!=0)|| (fte.canciones[2]!=0)|| (fte.canciones[3]!=0)|| (fte.canciones[4]!=0)){
                            ramdom= (int) (Math.random()*5);
                            fte.canciones[ramdom]=0;                    
                        }   
                    }  
                    Escribir_Salida+="Transacción exitosa, vuelto: "+vuelto+"\r\n";    
                }
            
            
                
            
            }
            desencolar();
            
        } else {
            
            Escribir_Salida += "Transaccion Cancelada, Motivo: Límite de canciones excedido."+"\r\n";
            desencolar();
        }       
            
    }
    
    void desencolar(){ //Desencola el frente
        
        if (fte!=null){
            if (fte==f1) {
                f1=null;
            }
            if (fte==f0) {
                f0=null;
            }
            fte=fte.sig;
            Q=fte;
            if (fte!=null) {
                fte.ant=null;
            }         
        }       
    }
        
    void reproducir(Pila_Album palbum){ //reproduce las canciones
        
        while (fte!=null){
           atender(palbum);
        }
        
    }
    
    boolean verificar_canciones(Pila_Album pila){ //Verifica si todas las canciones seleccionadas por el cliente existen
        Pila_Album paux = new Pila_Album();
        int calbum;
        int ccanc;
        for (int i = 0; i < fte.ccans; i++) {
            
            calbum= Integer.parseInt((Integer.toString(fte.canciones[i])).substring(0, 6));
            ccanc= Integer.parseInt((Integer.toString(fte.canciones[i])).substring(6, 8));
            
            if (pila.buscarC(paux, calbum,ccanc)!=true) {
                
                return false;              
                
            } else{
                
                if (pila.buscarC(paux, calbum,ccanc)!=true) {
                   return false;
                }
            }
            
        }        
        
        
        return true;
        
    }
}

//---------------------------------Leer Archivos--------------------------------


class Archivos{ //Clase usada para los archivos
     
    
    void Leer_Artistas(Pila_Album Pila){  //Lee los artistas del archivo Artistas.in
    try
    {
        File A = new File("Artistas.in");
        FileInputStream A1 = new FileInputStream(A);
        BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
        String linea="",nombre="";
        String codigo="";
        Pila_Album PAux= new Pila_Album();
        StringTokenizer tokens;
        
        while ((linea = leer.readLine()) != null) {            
            
            
            tokens = new StringTokenizer(linea, " ");          
            codigo=tokens.nextToken();
            
            while (!((Integer.toString(Pila.P.Nro_Album)).substring(0,3).equals(codigo))){                
                PAux.push(Pila.P.Nom_Artista, Pila.P.Nro_Album, Pila.P.Nom_Album);
                Pila.pop();
            }
            nombre= tokens.nextToken();            
            while (tokens.hasMoreTokens()==true){                
                nombre= nombre +" "+tokens.nextToken();                
            }
            
            
            Pila.P.Nom_Artista=nombre;
            
            while (PAux.vacio()!=true){                
                Pila.push(PAux.P.Nom_Artista, PAux.P.Nro_Album, PAux.P.Nom_Album);
                PAux.pop();
            }
            
        }        
        
    }
    catch(Exception E)
    {
        
        System.out.println("Error en la lectura de los artistas.");
    }
    
    }
        
    
    void Leer_Albumes(Pila_Album Pila){ //Lee los albumes del archivo Albumes.in
        
    try
    {
        File A = new File("Albumes.in");
        FileInputStream A1 = new FileInputStream(A);
        BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
        String linea="", nombre="";
        int codigo=0;
        StringTokenizer tokens;
         
        while ((linea = leer.readLine()) != null) {            
            
            
            tokens = new StringTokenizer(linea, " ");            
            codigo = Integer.parseInt(tokens.nextToken());          
            
            nombre= tokens.nextToken();
            
            while (tokens.hasMoreTokens()==true){                
                nombre= nombre +" "+tokens.nextToken();                
            }
            
            Pila.push("", codigo, nombre);
            
        }
        
        
    }
    catch(Exception E)
    {
        
        System.out.println("Error en la lectura de los Albumes.");
    }
    
    }
        
    void Leer_Canciones(Pila_Album Pila){ //Lee las canciones del archivo Canciones.in
        
    try
    {
        File A = new File("Canciones.in");
        FileInputStream A1 = new FileInputStream(A);
        BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
        String linea="", nombre="",codigo="";
        int codigo2=0;
        Pila_Album PAux= new Pila_Album();
        StringTokenizer tokens;
        
        while ((linea = leer.readLine()) != null) {            
            
            
            tokens = new StringTokenizer(linea, " ");            
            codigo = tokens.nextToken();          
            codigo2 = Integer.parseInt(codigo.substring(0, 6));
            codigo = codigo.substring(6, 8);
            
            nombre= tokens.nextToken();          
            
            while (tokens.hasMoreTokens()==true){                
                nombre= nombre +" "+tokens.nextToken();                
            }
            
            //Canciones.insertar_cancion(codigo, nombre);
            
            while (Pila.P.Nro_Album!=codigo2){                
                PAux.push(Pila.P.Nom_Artista, Pila.P.Nro_Album, Pila.P.Nom_Album);
                Pila.pop();
            }
            
            Pila.P.insertar_cancion(Integer.parseInt(codigo), codigo2, nombre);
            
            while (PAux.vacio()!=true){                
                Pila.push(PAux.P.Nom_Artista, PAux.P.Nro_Album, PAux.P.Nom_Album);
                PAux.pop();
            }
            
        }        
        
    }
    catch(Exception E)
    {
        
        System.out.println("Error en la lectura de las Canciones.");
    }
    
    }
    
    
    void Leer_Clientes(Dipolo_Cliente dipolo){ //Lee los clientes del archivo Rockola.in
        
    try
    {
        File A = new File("Rockola.in");
        FileInputStream A1 = new FileInputStream(A);
        BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
        String linea="",cancion="",tipo="",a="",b="";
        boolean prioridad=false,secuencial=false;
        int dinero=0,i=0,ccans=0;
        
        int[] canciones=new int[5];
        StringTokenizer tokens;
         
        while ((linea = leer.readLine()) != null) {                  
            
            tokens = new StringTokenizer(linea, " ");          
            
            i=0;
            ccans=0;
            prioridad=false;
            secuencial=false;
            dinero=0;
            a="";
            b="";
            tipo="";
            cancion="";
            boolean din=true;
            
            try {
                dinero= Integer.parseInt(tokens.nextToken());
            } catch (Exception e) {
                din=false;
            }
            
            
            for (int j = 0; j < 5; j++) {                
                canciones[j]=0;                
            }
            
            
            while (entero6(cancion=tokens.nextToken())==true){               
                if (i<5) {
                    canciones[i]= Integer.parseInt(cancion); 
                }
                i+=1;                 
                ccans+=1;
            }           
            
            if (cancion.equalsIgnoreCase("aceptar")){
                        
                tipo=tokens.nextToken();
                
                if ((tipo.equalsIgnoreCase("secuencial") || tipo.equalsIgnoreCase("aleatorio"))) {           
            
                    if (tipo.equalsIgnoreCase("secuencial")) {
                        secuencial=true;
                    }
            
                    if(tokens.hasMoreTokens()==true){
                        a=tokens.nextToken();
                    }
                    if (a.equalsIgnoreCase("prioridad")) {
                        b="";
                        if(tokens.hasMoreTokens()==true){
                            b=tokens.nextToken();
                        }
                        prioridad=true;
                        
                        if (b.equalsIgnoreCase("Finalizar")){                
                               if(tokens.hasMoreTokens()==false){
                                   if (din==true) {
                                       dipolo.Encolar(canciones, dinero, secuencial, prioridad,ccans);
                                   }                                   
                               }           
                        }
                
                    } else{
                        if (a.equalsIgnoreCase("Finalizar")){
                            if(tokens.hasMoreTokens()==false){
                                if (din==true) {
                                    dipolo.Encolar(canciones, dinero, secuencial, prioridad,ccans);
                                }                                   
                            }                                           
                        }                           
                    }                        
                }
            }           
        }       
    }
    catch(Exception E)
    {
        
        System.out.println("Error en la lectura de los Clientes.");
    }
    
    }
    
    void Salida(Dipolo_Cliente dipolo){ //Escribe en el archivo de salida reportes.out
        
        try 
        {
            PrintWriter escribir = new PrintWriter("REPORTES.out") ;            
            escribir.println(dipolo.Escribir_Salida);
            System.out.println(dipolo.Escribir_Salida+"Número de canciones sin prioridad: "+dipolo.cancsinprior+"\r\n"+
                    "Número de canciones con prioridad: "+dipolo.cancprior+"\r\n"+
                    "Numero de canciones reproducidas: "+dipolo.totrep+"\r\n"+
                    "Total de ganancia: "+ dipolo.totpagado+"\r\n");
            escribir.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Error en el archivo de salida.");  
            
        }
        
    }  
    
    boolean entero6(String a){ //Verifica que una cadena sea un numero entero de 8 digitos.
        
        if (a.length()==8){
            
            for (int i = 0; i < 8; i++) {
                if (!((a.charAt(i)=='0') || (a.charAt(i)=='1') || (a.charAt(i)=='2') || (a.charAt(i)=='3') || (a.charAt(i)=='4') || (a.charAt(i)=='5') || (a.charAt(i)=='6') || (a.charAt(i)=='7') || (a.charAt(i)=='8') || (a.charAt(i)=='9'))) {
                    return false;
                }
            }
            return true;
        }
       return false; 
   }
    
}

public class Rockola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Pila_Album Albumes = new Pila_Album();
        Dipolo_Cliente cliente = new Dipolo_Cliente();        
        Archivos obj = new Archivos();        
        Archivos salida=new Archivos();
        
        obj.Leer_Albumes(Albumes);
        obj.Leer_Artistas(Albumes);
        obj.Leer_Canciones(Albumes);
        obj.Leer_Clientes(cliente);
        cliente.reproducir(Albumes);
        salida.Salida(cliente);

    }
}
