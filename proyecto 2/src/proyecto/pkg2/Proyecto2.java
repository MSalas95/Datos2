/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg2;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * @author Usuario
 */
//-----------------------------------------------------CLASE NODO DOCUMENTO----------------------------------------------------
class NDoc {
    int ID=0,cant=0;
    String nombre="";
    double costo=0, costo_tot=0;
    NDoc sig=null, ant=null;
    
    void almacenar(int codigo) {              //pide los datos para almacenar un documento
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
       while (nombre.equals("")) {
            
            System.out.print("Coloque el nombre del documento: ");
        
            try {
                
                nombre = lee.readLine();
                
            } catch (Exception e) {
                
               System.out.println("Error.");
            }
        }
       
       while (costo == 0) {
            
            System.out.print("Coloque el costo del documento: ");
        
            try {
                
                costo = Double.parseDouble(lee.readLine());
                
            } catch (Exception e) {
                
                System.out.println("Error, Debe introducir un numero. ");
            }
        }
       
       while (cant == 0) {
            
            System.out.print("Coloque la cantidad de documentos: ");
        
            try {
                
                cant = Integer.parseInt(lee.readLine());
                
            } catch (Exception e) {
                
                System.out.println("Debe introducir un numero. ");
            }
        }
       
       ID = codigo;
       costo_tot = cant*costo;
       sig=null;
       ant=null;
    }
    
    void mostrar() { //muestra los datos de un documento
        
        System.out.println("El Identificador es: "+ID);
        System.out.println("El Nombre es: "+nombre);
        System.out.println("La Cantidad es: "+cant);
        System.out.println("El costo por documento es: "+costo);
        System.out.println("El Costo Total es: "+costo_tot);
        System.out.println();
    }
    
    void modificar() { //modifica los datos de un documento
        int opc=0;
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while (opc != 4){
            opc=0;
            System.out.print("¿Qué desea hacer?: ");
            System.out.println();
            System.out.println("Nombre   (1)");
            System.out.println("Costo    (2)");
            System.out.println("Cantidad (3)");
            System.out.println("Salir    (4)");
            System.out.print("Coloque la opcion: ");
           
            while (opc==0){
                
                try  {
                    
                    opc = Integer.parseInt(lee.readLine());
                    
                } catch (Exception e) {
                    
                    System.out.println("Opcion invalida, coloque un numero. ");
                }
            }
                        
            System.out.println(" ");
            
            
            switch (opc) {  
                
                 case 1: System.out.print("Coloque el nombre: ");
                 
                        nombre="";
                        while (nombre == "") {
                            
                              try {
                                  nombre = lee.readLine();
                                       
                              } catch (Exception e) {
                                  
                                   System.out.print("Error");
                               }
                         }
                    break;
                        
                  case 2: System.out.print("Coloque el costo: ");
                  
                        costo=0;
                        while (costo == 0) {
                           
                            try {
                                
                              costo = Double.parseDouble(lee.readLine());
                              
                            } catch  (Exception e) {
                            
                              System.out.print("Error, Debe introducir un numero ");
                            }
                        }
                    break;
                      
                   case 3: System.out.print("Coloque la cantidad: ");
                   
                        cant=0;
                        while (cant==0) {
                            
                            try {
                                
                              cant = Integer.parseInt(lee.readLine());
                              
                            } catch  (Exception e) {
                            
                              System.out.print("Error, Debe introducir un numero ");
                            }
                        }
                    break;
                       
                   case 4:
                       
                    break;

                   default: System.out.print("Datos invalidos, coloque un numero entre el 1 y 4: ");

                    break;  
            }

            System.out.println(" ");

        }
        costo_tot = cant*costo;
    }
}

    




//----------------------------------------------------CLASE Nodo estudiante-------------------------------------------------


class NEst {
    int cedula=0, Cdocs=0;
    String nombre="", apellido="", carrera="", telefono="";
    NEst sig=null, ant=null;
    NDoc D=null;
    
    void almacenar(int ced) { //Almacena los datos de un estudiante
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
       while (nombre == "") {
            
            System.out.print("Coloque el Nombre del Estudiante: ");
        
            try {
                
                nombre = lee.readLine();
                
            } catch (Exception e) {
                
               System.out.println("Error.");
            }
        }
       
       while (apellido == "") {
            
            System.out.print("Coloque el apellido del Estudiante: ");
        
            try {
                
                apellido = lee.readLine();
                
            } catch (Exception e) {
                
               System.out.println("Error.");
            }
        }
       
       while (carrera == "") {
            
            System.out.print("Coloque la Carrera del Estudiante: ");
        
            try {
                
                carrera = lee.readLine();
                
            } catch (Exception e) {
                
               System.out.println("Error.");
            }
        }
       
       while (telefono == "") {
            
            System.out.print("Coloque el telefono del Estudiante: ");
        
            try {
                
                telefono = lee.readLine();
                
            } catch (Exception e) {
                
               System.out.println("Error.");
            }
        }
       System.out.print("Estudiante Almacenado. ");
       System.out.print("");
       cedula=ced;
       Cdocs = 0;
       sig=null;
       ant=null;
       D=null;  
    }

    
    void mostrar_CI(NDoc aux) { //Muestra los datos de los estudiantes que pposeen constancia de inscripcion
        
        if (aux != null) {       
        
            if (aux.nombre.equalsIgnoreCase("constancia de inscripcion") ) {
            
                System.out.println("Cedula: "+ cedula);
                System.out.println("Nombre: "+ nombre);
                System.out.println("Apellido: "+ apellido);
                System.out.println("Carrera: "+ carrera);
                System.out.println("Telefono: "+ telefono);
                System.out.println();
             
            } else{               
                 
                mostrar_CI(aux.sig);
             
            }    
        }
    }
    
    void modificar() { //modifica los datos de los estudiantes
        int opc=0;
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while (opc != 5){
            opc=0;
            System.out.print("¿Qué desea modificar?: ");
            System.out.println();
            System.out.println("Nombre   (1)");
            System.out.println("Apellido (2)");
            System.out.println("Carrera  (3)");
            System.out.println("Telefono (4)");
            System.out.println("Salir    (5)");
            System.out.print("Coloque la opcion: ");
            while (opc==0){
                try  {
                    
                    opc = Integer.parseInt(lee.readLine());
                    
                } catch (Exception e) {
                    
                    System.out.println("Opcion invalida, coloque un numero. ");
                }
            }
                        
            System.out.println(" ");
            
            
            switch (opc) {  
                
                 case 1: System.out.print("Coloque el nombre: ");
                     
                        nombre="";
                        while (nombre.equals("")) {
                              try {
                                  nombre = lee.readLine();
                                       
                              } catch (Exception e) {
                                  
                                   System.out.print("Error");
                              }
                         }
                    break;
                        
                  case 2: System.out.print("Coloque el Apellido: ");
                     
                        apellido="";
                        while (apellido.equals("")) {
                            
                              try {
                                  
                                  apellido = lee.readLine();
                                       
                              } catch (Exception e) {
                                  
                                   System.out.print("Error");
                              }
                         }
                    break;
                      
                   case 3: System.out.print("Coloque la Carrera: ");
                     
                        carrera="";
                        while (carrera.equals("")) {
                            
                              try {
                                  
                                  carrera = lee.readLine();
                                       
                              } catch (Exception e) {
                                  
                                   System.out.print("Error");
                              }
                         }
                    break;
                       
                   case 4:System.out.print("Coloque el Telefono: ");
                     
                        telefono="";
                        while (telefono.equals("")) {
                            
                              try {
                                  
                                  telefono = lee.readLine();
                                       
                              } catch (Exception e) {
                                  
                                   System.out.print("Error");
                              }
                         }
                       
                    break;
                       
                   case 5:
                       
                    break;

                   default: System.out.print("Datos invalidos, coloque un numero entre el 1 y 5: ");

                    break;  
            }

            System.out.println(" ");

        }
    }
    
    void insertar_inicio() { //inserta un documento al inicio
        int codigo=0;
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while (codigo == 0) {
            
            System.out.print("Coloque el identificador: ");
        
            try {
                
                codigo = Integer.parseInt(lee.readLine());
                
            } catch (Exception e) {
                
                System.out.println("Error, Debe introducir un numero. ");
            }
        }
        
        if (buscar_cant(D, codigo) > 0) {
            
            System.out.println("Documento ya ingresado. Para ingresar otro de este tipo modifiquelo.");
        }
        else {
            
            NDoc nodo_nuevo= new NDoc();
            nodo_nuevo.almacenar(codigo);
            
            if (D != null) {
                
                nodo_nuevo.sig= D;
                D.ant= nodo_nuevo;
            }
            
            D= nodo_nuevo;
            Cdocs = Cdocs +1;
        }
        
    }
    
    void ordenar(NDoc aux,NDoc aux2) { //ordena los documentos comparandolos en pares
        
        if (D != null) {
            if (aux.sig != null) {
                if (aux.ID > aux2.ID) {
                    
                    aux.sig= aux2.sig;
                    aux2.ant= aux.ant;
                    aux2.sig= aux;
                    aux.ant= aux2;
                    
                    if (aux == D) {
                        
                        D= aux2;
                        
                        if (aux.sig != null) {
                            
                            aux.sig.ant= aux;
                        }
                    }
                    else {
                    
                        if (aux.sig == null) {
                        
                            aux2.ant.sig= aux2;
                        } 
                        else {
                        
                            aux2.ant.sig= aux2;
                            aux.sig.ant= aux;
                        }
                    }
                    ordenar(aux, aux.sig); 
                } else {
               ordenar(aux.sig, aux2.sig);
                }
            }
            if (verificar(D) == true) {
                
                aux= D;
                ordenar(aux, D.sig);
            }
        }
    }
    
    boolean verificar(NDoc aux) { //verifica si estan ordenads los documentos
        
        if (aux.sig == null) {
            
            return false;
        }
        else {
            if (aux.ID > aux.sig.ID) {
                
                return true;
            }
            else {
                
                return verificar(aux.sig);
            }
        }
    }
    
    int buscar_cant(NDoc aux, int codigo) { //busca la cantidad de documentos
        
        if (aux == null) {
            
            return 0;
        }
        else {
            if (aux.ID == codigo) {
                
                return aux.cant;
            }
            else {
                
                return buscar_cant(aux.sig,codigo);
            }
        }
    }
    
    void mostrar_docs(NDoc aux) { //muestra los documentos
        
        if (D == null) {
            
            System.out.println("No tiene documentos.");
        }
        else {
            if (aux != null) {
                
                aux.mostrar();
                mostrar_docs(aux.sig);
            }
        }
    }
    
    void modificar(NDoc aux, int codigo) { //modifica los documentos
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        if (aux == null) {
            
            System.out.println("No se encontro el documento.");
        }
        else {
            if (aux == D) {
                
                while (codigo == 0) {
            
                    System.out.print("Coloque el identificador del documento que desea modificar: ");
        
                    try {
                
                        codigo = Integer.parseInt(lee.readLine());
                
                    } catch (Exception e) {
                
                        System.out.println("Error, Debe introducir un numero. ");
                    }
                }
            }
            if (aux.ID == codigo) {
                
                aux.modificar();
            }
            else {
                
                    modificar(aux.sig,codigo);
            }
        }
    }
    
    void eliminar_prim() { //elimina el primer documento
        
        if (D == null) {
            
            System.out.println("Lista Vacia");
        }
        else {
            if (D.sig == null) {
                
                D= null;
            }
            else {
                
                D= D.sig;
                D.ant= null;
            }
            
            System.out.println("Documento eliminado.");
            System.out.println("");
        }
    }
    
    double costo_docs(NDoc aux, double costo) { //malcula el costo de los documentos
        
        if (aux == null) {
            
            return costo;
        }
        else {
            
            return costo_docs(aux.sig, costo+ aux.costo_tot);
        }
    }

    void insertar_nodonuevo(NDoc NN) { //inserta un nodo del archivo
        
        if (D != null) {
                
                NN.sig= D;
                D.ant= NN;
            }
            
            D= NN;
            
        
    }
}
    

//----------------------------------------------------CLASE NODO TAQUILLAS-------------------------------------------------


class NTaq {
    String persona="";
    NEst E=null;
    
    void almacenar(){ //Almacena una taquilla
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        while (persona.equals("")) {
            
              System.out.print("Persona Encargada: ");
        
              try {
                
                   persona = lee.readLine();
                    
                
              } catch (Exception e) {
                
                   System.out.println("Error");
              }
        }
        
    }
    
    void mostrar() { //muestra los datos de una taquilla
        
        System.out.print("Persona Encargada: "+persona);
    }
    
    void modificar() {
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        persona="";
        while (persona.equals("")) {
            
              System.out.print("Persona Encargada: ");
        
              try {
                
                   persona = lee.readLine();
                
              } catch (Exception e) {
                
                   System.out.println("Error");
              }
        }
    }
    
    void insertar_est(NEst aux, int cedula, ATaquillas obj1, int i, int cont) { //inserta un estudiante
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        if (E == aux) {
            
                       
            System.out.println("Coloque los siguientes datos:");
            
            while (cedula == 0) {
                
                System.out.print("Introduzca la cedula: ");
                try 
                {
                    cedula = Integer.parseInt(lee.readLine());
                } 
                catch (Exception e) 
                {
                    System.out.println("Cedula inválida.");
                }
            }
            
            cont = obj1.verificar (cedula, 0, 0);
        }
        
        if (cont == 0) {
                        
            if (E == null) {
                NEst nodo_nuevo= new NEst();
                nodo_nuevo.almacenar(cedula);
                E= nodo_nuevo;
            }
            else {
                if (aux.sig == null) {
                    NEst nodo_nuevo= new NEst();
                    nodo_nuevo.almacenar(cedula);
                    aux.sig= nodo_nuevo;
                    nodo_nuevo.ant = aux;
                }
                else {
                    
                    insertar_est(aux.sig, cedula, obj1, i, cont);
                }
            }
        
        }
        else {
            
            System.out.println("Error. El Estudiante ya esta en una taquilla.");
            System.out.println("");
        }
    }
    
    
    void insertar_doc (NEst aux){ //inserta un documento
        
        aux.insertar_inicio();
    }
    
    
    int buscar_E (NEst aux, int ced, int cont) { //busca un estudiante
        
        if (aux == null) {
                                  
           return -1;           
            
        }
        else {
            if (aux.cedula == ced) {
                
                return cont;
            }
            else {
                
                return (buscar_E(aux.sig,ced,cont+1));
            }
        }
    }
    
    double costo_est(NEst aux, double costo) { //calcula el costo de todos los estudiantes
        
        if (aux == null) {
            
            return costo;
        }
        else {
            
            return costo_est(aux.sig, costo+ aux.costo_docs(aux.D, 0));
        }
    }
    
    void mostrar_est(NEst aux) { //muestra los datos de un estudiante que posee constancia de inscripcion
        
        if (aux != null) {
            
            aux.mostrar_CI(aux.D);
            mostrar_est(aux.sig);
        }
    }

    
    void modificar_est(NEst aux,int ced){ //modifica los datos de un estudiante
         BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
         
       if  (aux == null) {

        System.out.println("Lista Vacia");
      }
      else {
        if (aux == E) {

          
        }
        
        if (aux.cedula == ced) {
            
            aux.modificar();  
        }
        else {
                
            modificar_est(aux.sig,ced);
            
        }
      }
    }
    
    void insertar_doc(NEst aux, int cedula) { //inserta un documento en un estudiante
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        if (E == null) {
            
            System.out.println("Lista Vacia");
        }
        else {
            if (aux == E) {
                
                while (cedula == 0) {
            
                    System.out.print("Introduzca la cedula del estudiante: ");
        
                    try { 
                
                        cedula = Integer.parseInt(lee.readLine());
                
                    } catch (Exception e) {
                
                        System.out.println("Error, Debe introducir un numero. ");
                    }
                }
            }
            if (aux != null) {
                if (aux.cedula == cedula) {
                    
                    aux.insertar_inicio();
                }
                else {
                    
                    insertar_doc(aux.sig, cedula);
                }
            }
            else {
                
                System.out.println("No se encuentra almacenado el estudiante");
            }
        }
        
    }
    
    void ordenar1(NEst aux, int cedula) { //ordena los documentos de un estudiante
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        if (E == null) {
            
           System.out.println("Lista Vacia"); 
        }
        else {
            
            
            if (aux != null) {
                if (buscar_E(E, cedula,0) >= 0) {
                    
                    if (aux.cedula==cedula){
                        if (aux.D!=null){
                            aux.ordenar(aux.D,aux.D.sig);
                            System.out.println("Lista Ordenada.");
                        } else {
                            System.out.println("");
                            System.out.println("No posee documentos.");
                            System.out.println("");
                        }
                         
                    
                    } else {
                         ordenar1(aux.sig, cedula);
                    }
                   
                }
                else {
                    
                    ordenar1(aux.sig, cedula);
                }
            }
            else {
                
                System.out.println("Cedula no encontrada.");
            }
        }
    }
    
    void ordenar2(NEst aux) { //ordena los documentos de varios estudiantes
        
        if (E != null) {
             
            if (aux != null) {
                
                if (aux.D!= null){
                    
                    aux.ordenar(aux.D, aux.D.sig);
                    
                }
                
                
                ordenar2(aux.sig);
            }
            else {
                
               
            }
        } 
    }
        
    int buscar_cant_E(NEst aux, int codigo,int cont) { //Cuenta la cantidad de documentos de un mismo tipo de todos los estudiantes de esa lista
        
            if (E == null) {
                
                return 0;
            }
            else {
                if (aux != null) {
                    
                    return (buscar_cant_E(aux.sig, codigo,cont+ aux.buscar_cant(aux.D, codigo)));
                } else {
                    
                     return cont;
                             
                }
            }
        }
    
        void modificar_doc(NEst aux, int cedula) { //modifica los datos de un documento
            BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
            
            if (E == null) {
                
                System.out.println("Lista vacia.");
            }
            else {
                
                
                if (aux != null) {
                    if (buscar_E(E, cedula,0) >= 0) {
                        
                        aux.modificar(aux.D, 0);
                    }
                    else {
                        
                        modificar_doc(aux.sig, cedula);
                    }
                }
                else {
                    
                    System.out.println("No se encuentra almacenada la cedula");
                }
            }
        }
            
    void eliminar_prim_E() { //elimina el primer estudiante
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        
        if (E == null) {
            
            System.out.println("Lista Vacia.");
        }
        else {
            
            if (E.sig!=null){               
                
                E.sig.ant=null;
                
            }
            
            E = E.sig;
            System.out.println("Procesado. ");
           System.out.println("");
        }
            
            
            
    }
    
    void mostrar_docs_E(NEst aux) { //muestra ls documentos de los estudiantes de lic en estadistica
        
        if (E == null) {
            
            
        }
        else {
            if (aux != null) {
                if (aux.carrera.equalsIgnoreCase("licenciatura en estadística") || aux.carrera.equalsIgnoreCase("licenciatura en estadistica")  ) {
                    
                    aux.mostrar_docs(aux.D); 
                }
                else {
                    
                    mostrar_docs_E(aux.sig);
                }
            }
        }
    }

    void Insertar_Estudiante_Archivo(NEst NN, NEst aux) { //inserta un estudiante del archivo
        
        if (E == null) {
                
                E= NN;
                
            }
            else {
                if (aux.sig == null) {
                    
                    aux.sig= NN;
                    NN.ant = aux;
                }
                else {
                    
                    Insertar_Estudiante_Archivo(NN, aux.sig);
                }
            }      
        
        
    }

    void Insertar_Documento_Archivo(NDoc NN, int cedula, NEst aux) { //inserta un documento del archivo
        
        if (aux.cedula == cedula){
            
            aux.insertar_nodonuevo(NN);
            
        } else {
            
            Insertar_Documento_Archivo(NN, cedula, aux.sig);
            
        }
        
    }
    
    void eliminar_doc(NEst aux, int cedula){ //Elimina un documento
        
        if (E==null) {
            System.out.println("Lista Vacia.");
            
        } else {
          if (aux!=null){
             if (cedula== aux.cedula) {
               if (aux.D!=null){
                 aux.eliminar_prim();       
                E.Cdocs =E.Cdocs -1; 
             }
               
               
           } else {
               
               eliminar_doc(aux.sig,cedula);
              
           } 
          } else{
              
              System.out.println("No se encontró.");
          } 
               
        }
        
    }
    
}

//----------------------------------------------------CLASE ARREGLO TAQUILLAS-------------------------------------------------


class ATaquillas{
    
    NTaq[] A = new NTaq[3];
    
    void instanciar(int i){
        
        if (i<3){            
            A[i] = new NTaq();
            instanciar(i+1);
        }
        
    }
    
    void insertar_estudiante(ATaquillas obj){ //inserta un estudiante
        
    BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
  
        int taq = 0;
        
        while ((taq!=1) && (taq!=2) && (taq!=3)){
        
           System.out.print("Coloque la taquilla donde lo desea insertar: ");
           try
           {
               taq= Integer.parseInt(lee.readLine());
           }
           catch (Exception e)
           {
               System.out.println("Error.");
        
           }
           
           if ((taq!=1) && (taq!=2) && (taq!=3)){
               
               System.out.println("Error. Coloque un valor entre 1 y 3. ");
               
           }
           
        }
        
         if (!(A[taq-1].persona).equals ("")){ 
         A[taq-1].insertar_est(A[taq-1].E,0,obj,0,0);
         } else {
           System.out.println("Error. No se puede almacenar en una taquilla cerrada. ");
           System.out.println(" ");
             
         }
    }
    
    int verificar(int cedula, int i, int cont){ //verifica si se encuentra el estudiante
        
        
        if ((cont==1) || (i==3)){
        
            return  cont;
        
        } else {
            
            if (A[i].buscar_E(A[i].E,cedula,0) >= 0){
                
                cont=1;
                              
            }
				
            return verificar (cedula, i+1, cont);			
                  
        }     
    }
    
    void insertar_doc (int cedula){ //inserta un documento en un estudiante
        
        if (verificar(cedula,0,0) == 0) {
            
            System.out.println("No se encunetra almacenado.");
            
        } else {
                        
                if ( A[0].buscar_E(A[0].E,cedula,0)>= 0) {
                
                     A[0].insertar_doc(A[0].E,cedula);
                     
                } else {
                
                        if ( A[1].buscar_E(A[1].E,cedula,0)>= 0) {
                
                             A[1].insertar_doc(A[1].E,cedula);

                        } else {
                                if ( A[2].buscar_E(A[2].E,cedula,0)>= 0) {
                
                                    A[2].insertar_doc(A[2].E,cedula);

                    
                                }
                         }    
               }
        }
        
        
        
    }
    
    
    double costo_taq(){ //calcula el costo total para una taquilla
        
        return A[0].costo_est(A[0].E, 0) + A[1].costo_est(A[1].E, 0) + A[2].costo_est(A[2].E, 0);
                
    }
    
    void mostar_constancia(int i){ //muestra los estudiantes que tienen constancia de inscripcion
        
        
        if (i<3) {
            
            A[i].mostrar_est(A[i].E);
            mostar_constancia(i+1);
            
        } 
    }
    
    
    void modificar_estudiante(int cedula) {      //Modifica los datos de un esudiante
        
        if (verificar(cedula,0,0) == 0) {
            
            System.out.println("No se encunetra almacenado.");
            
        } else {
                        
                if ( A[0].buscar_E(A[0].E,cedula,0)>= 0) {
                
                     A[0].modificar_est(A[0].E, cedula);
                     
                } else {
                
                        if ( A[1].buscar_E(A[1].E,cedula,0)>= 0) {
                
                             A[1].modificar_est(A[1].E, cedula);

                        } else {
                                if ( A[2].buscar_E(A[2].E,cedula,0)>= 0) {
                
                                    A[2].modificar_est(A[2].E, cedula);

                    
                                }
                         }    
               }
        }
    }
    
    void modificar_documento(int cedula) {         //Modifica un documento
        
        if (verificar(cedula,0,0) == 0) {
            
            System.out.println("No se encuentra almacenado.");
            
        } else {
                        
                if ( A[0].buscar_E(A[0].E,cedula,0)>= 0) {
                
                     A[0].modificar_doc(A[0].E, cedula);
                     
                } else {
                
                        if ( A[1].buscar_E(A[1].E,cedula,0)>= 0) {
                
                             A[1].modificar_doc(A[1].E, cedula);

                        } else {
                                if ( A[2].buscar_E(A[2].E,cedula,0)>= 0) {
                
                                    A[2].modificar_doc(A[2].E, cedula);

                    
                                }
                        }    
                }
        }
    }
    
    
    void ordenar1(int cedula){           //Ordena todos los documentos para un solo estudiante.
        
         if (verificar(cedula,0,0) == 0) {       //Verifica si el estudiante se encuentra almacenado
            
            System.out.println("No se encuentra almacenado.");
            
        } else {           //si se encuentra almacenado busca en que posicion del arreglo se encuentra
                        
                if ( A[0].buscar_E(A[0].E,cedula,0)>= 0) {
                
                     A[0].ordenar1(A[0].E, cedula);   //Llama al metodo en la posicion del arreglo donde se encuentra
                     
                } else {
                
                        if ( A[1].buscar_E(A[1].E,cedula,0)>= 0) {
                
                             A[1].ordenar1(A[1].E, cedula);

                        } else {
                                if ( A[2].buscar_E(A[2].E,cedula,0)>= 0) {
                
                                    A[2].ordenar1(A[2].E, cedula);

                    
                                }
                        }    
                }
        }
    }
    
    
    void ordenar_2(int i){   //Ordena todos los documentos de todos los estudiantes
    
    if (i==3){
        
        System.out.println("Documentos de todos los estudiantes ordenados.");
        System.out.println("");
        
    } else {
         
        A[i].ordenar2(A[i].E);
        ordenar_2(i+1);
        
    }
    
    
    
}
        
    int buscar_cant_A(int codigo){ //cuenta la cantidad de documentos de un mismo tipo en el arreglo
        
        
        return (A[0].buscar_cant_E(A[0].E, codigo,0)+A[1].buscar_cant_E(A[1].E, codigo,0)+A[2].buscar_cant_E(A[2].E, codigo,0));
        
    }     
    
    
    void mostrar_estadistica(int i){ //muesra los datos de los estudiantes de lic en estadistica
        
        if (i==3){
            
        } else {
            
            A[i].mostrar_docs_E(A[i].E);
            mostrar_estadistica(i+1);
        }
                
    }
    
    void procesar(int opc){ //procesa un estudiante
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
       if (opc==4){
           
           
           
       } else {
           
           System.out.println("¿En que taquilla desea procesar un estudiante? ");
           System.out.println("¿Taquilla 1 (Presione 1). ");
           System.out.println("¿Taquilla 2 (Presione 2). ");
           System.out.println("¿Taquilla 3 (Presione 3). ");
           System.out.println("Salir       (Presione 4). ");
           System.out.print("Coloque la opcion: ");
           try 
            {   
                opc = Integer.parseInt(lee.readLine());
            } 
                catch (Exception e) 
            {
                System.out.println("Opcion invalida ");
            }
           System.out.println();
           
           if ((opc ==1) || (opc==2) || (opc==3)){
           if (!(A[opc-1].persona).equals ("")){
           A[opc-1].eliminar_prim_E();
           } else {
               
               System.out.println("Error. No se puede procesar una taquilla cerrada. ");
               System.out.println(" ");
               
           }
               
           
           } else {
               
               procesar(opc);
               
           }
           
           
       }   
        
        
        
        
    }
  
    void abrir_taquilla(int opc){ //abre una taquilla
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));

        if (opc ==3){
        
        
        } else{
    
           System.out.println("¿Que desea taquilla desea abrir? ");
           System.out.println("¿Taquilla 1 (Presione 1). ");
           System.out.println("¿Taquilla 2 (Presione 2). ");
           System.out.println("¿Taquilla 3 (Presione 3). ");
           System.out.println("Salir       (Presione 4). ");
           System.out.print("Coloque la opcion: ");
            try 
            {   
                opc = Integer.parseInt(lee.readLine());
            } 
                catch (Exception e) 
            {
                System.out.println("Opcion invalida ");
            }
           System.out.println();
           
            if ((opc ==1) || (opc==2) || (opc==3)){
           
           if ((A[opc-1].persona).equals ("")){
                
                A[opc-1].almacenar();
                 System.out.println("Se ha abierto la taquilla.");
                 System.out.println();
            } else {
               
               System.out.println("Error. Esta taquilla ya esta abierta.");
               System.out.println();
           }
          
           
           } else {
               
              abrir_taquilla(opc);
               
           }
    
        }
        
        
    }
    
    void cerrar_taquilla(int opc){ //cierra una taquilla
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));

        if (opc ==3){
        
        
        } else{
    
           System.out.println("¿Que desea taquilla desea cerrar? ");
           System.out.println("¿Taquilla 1 (Presione 1). ");
           System.out.println("¿Taquilla 2 (Presione 2). ");
           System.out.println("¿Taquilla 3 (Presione 3). ");
           System.out.println("Salir       (Presione 4). ");
           System.out.print("Coloque la opcion: ");
            try 
            {   
                opc = Integer.parseInt(lee.readLine());
            } 
                catch (Exception e) 
            {
                System.out.println("Opcion invalida ");
            }
           System.out.println();
           
           
           
            if ((opc ==1) || (opc==2) || (opc==3)){
           
           if (!(A[opc-1].persona).equals ("")){
                String s="";
               
               while (!(s.equalsIgnoreCase("S") ||  s.equalsIgnoreCase("N"))){
                           System.out.println("Si cierra la taquilla se eliminará la lista.");   
                           System.out.println("¿Está seguro? (S/N).");
                           System.out.print("Coloque la opcion: ");
                           try
                           {
                               s= lee.readLine();
                           }
                           catch (Exception e)
                           {
                               System.out.println("Error. Coloque s o n");
        
                           }
              }
              
              if (s.equalsIgnoreCase("s")) {
                  
              
               
               A[opc-1].persona = "";
               System.out.println("Se ha cerrado la taquilla."); 
               A[opc-1].E = null;
               System.out.println();
               } else {
                  
                  System.out.println("No se ha cerrado la taquilla");
               System.out.println();
                  
              }
            } else {
               
               System.out.println("Esta taquilla ya se encuentra cerrada.");
               System.out.println();
           }
          
           
           } else {
               
              cerrar_taquilla(opc);
               
           }
    
        }
        
        
    }
    
    
    void eliminar_documento(int cedula){ //elimina el primer documento de una persona
        
        if (verificar(cedula,0,0) == 0) {       //Verifica si el estudiante se encuentra almacenado
            
            System.out.println("No se encuentra almacenado.");
            
        } else {           //si se encuentra almacenado busca en que posicion del arreglo se encuentra
                        
                if ( A[0].buscar_E(A[0].E,cedula,0)>= 0) {
                
                     A[0].eliminar_doc(A[0].E, cedula);
                     
                } else {
                
                        if ( A[1].buscar_E(A[1].E,cedula,0)>= 0) {
                
                            A[1].eliminar_doc(A[1].E, cedula);

                        } else {
                                if ( A[2].buscar_E(A[2].E,cedula,0)>= 0) {
                
                                    A[2].eliminar_doc(A[2].E, cedula);

                    
                                }
                        }    
                }
        }
        
        
        
    }
    
    
}



public class Proyecto2 {    
    
    
     static void leer_archivo_taquillas(ATaquillas arreglo){ // lee el archivo y guarda la informacion de las taquillas
    
         try 
         {
             
            File A = new File("Taquillas.txt");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea = "";
            StringTokenizer tokens;
            int i=0;
            while ((linea = leer.readLine()) != null) {
                
                tokens = new StringTokenizer(linea, "#");
                
                while (tokens.hasMoreTokens()) {
                    
                    arreglo.A[i].persona = tokens.nextToken();       
                    
                    i++;
                    
                }
                
                
            } 
             
         }
         catch(Exception E)
         {
             
             
         }   
    
    
    }
     
    static void leer_archivo_estudiantes(ATaquillas At){ //lee el archiv y guarda la informacion de los estudiantes
        
        try 
         {
             
            File A = new File("Estudiantes.txt");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea, nombre, apellido, telefono, carrera= "";
            StringTokenizer tokens;
            int i=0;
            int numero,cedula, CDocs = 0;
           
            while ((linea = leer.readLine()) != null) {
                
                 NEst NN=new NEst();
                tokens = new StringTokenizer(linea, "#");
                
               
                       
                       numero = Integer.parseInt(tokens.nextToken());
                       
                       NN.cedula = Integer.parseInt(tokens.nextToken()); 
                               
                       NN.nombre = tokens.nextToken();
                               
                       NN.apellido = tokens.nextToken();
                               
                       NN.telefono = tokens.nextToken();
                           
                       NN.carrera = tokens.nextToken();
                            
                       NN.Cdocs = Integer.parseInt(tokens.nextToken());
                              
                                         
                   
                   At.A[numero].Insertar_Estudiante_Archivo(NN,At.A[numero].E);                    
                   
                
                
            } 
             
         }
         catch(Exception E)
         {
             
             
         }   
        
        
        
        
        
   } 
    
   
    static void leer_archivo_documentos(ATaquillas At){ //lee el archivo y guarda la informacion en los documentos
        
       try 
         {
             
            File A = new File("Documentos.txt");
            FileInputStream A1 = new FileInputStream(A);
            BufferedReader leer = new BufferedReader(new InputStreamReader(A1));
            String linea, nombre, apellido, telefono, carrera= "";
            StringTokenizer tokens;
            int i=0;
            int cedula=0, posicion =0;
            
            
            while ((linea = leer.readLine()) != null) {
                
                NDoc NN=new NDoc();
                tokens = new StringTokenizer(linea, "#");
                
               
                       
                       cedula = Integer.parseInt(tokens.nextToken());
                       
                       NN.ID = Integer.parseInt(tokens.nextToken());
                               
                       NN.nombre = tokens.nextToken();
                               
                       NN.costo = Double.parseDouble(tokens.nextToken()); 
                               
                       NN.cant = Integer.parseInt(tokens.nextToken());
                               
                       NN.costo_tot = Double.parseDouble(tokens.nextToken()); 
                           
                       
                   for (i=0; i<3;i++){
                       
                        if (At.A[i].buscar_E(At.A[i].E, cedula, 0) >= 0){
                       
                       
                        At.A[i].Insertar_Documento_Archivo(NN,cedula, At.A[i].E);    
                       
                         }           
                  
                   
                   }                
                
                
                
            } 
             
         }
         catch(Exception E)
         {
             
             
         }   
        
        
        
     
        
   }
    
  
    
    static void escribir_archivo_taquillas(ATaquillas obj){ //escribe los datos de las taquillas en el archivo
        
        try
        {
             File f = new File("Taquillas.txt");
             FileWriter linea = new FileWriter(f, false);
             for (int i=0; i<3; i++){
                 
                  linea.write(obj.A[i].persona+"\r\n");
                 
             }
                linea.close(); 
        }
        catch (Exception E)
        {
            
            
            
        }
                               
        
    }
    
  
        
    
    static void escribir_archivo_documentos(ATaquillas obj){ //escribe los datos de los documentos en el archivo
         try{
             NEst aux=null;
             
             File f = new File("Documentos.txt");
             FileWriter linea = new FileWriter(f, false);
             
             for (int i=0;i<3;i++){
                 aux=obj.A[i].E;
                 while (aux!=null){
                     while (aux.D!=null){
                         
                         linea.write(aux.cedula+"#"+aux.D.ID+"#"+aux.D.nombre+"#"+aux.D.costo+"#"+aux.D.cant+"#"+aux.D.costo_tot+"\r\n");
                         aux.D=aux.D.sig;
                     }
                     aux=aux.sig;
                 }               
                 
                 
             }
             linea.close();
             
         }
        catch (Exception E)
        {
            
            
            
        }
        
        
    }
    
    static void escribir_archivo_estudiantes(ATaquillas obj){ //escribe los datos de estudiantes en el archivo
        
        try{
             
             
             File f = new File("Estudiantes.txt");
             FileWriter linea = new FileWriter(f, false);
             
             for (int i=0;i<3;i++){
                 while (obj.A[i].E!=null){
                         
                         linea.write(i+"#"+obj.A[i].E.cedula+"#"+obj.A[i].E.nombre+"#"+obj.A[i].E.apellido+"#"+obj.A[i].E.telefono+"#"+obj.A[i].E.carrera+"#"+obj.A[i].E.Cdocs+"\r\n");
                         obj.A[i].E=obj.A[i].E.sig;
                     }
                  
                               
                 
                 
             }
             linea.close();
             
         }
        catch (Exception E)
        {
            
            
            
        }
        
        
        
        
    }
    
     
     
    
    public static void main(String[] args) { //Algoritmo principal
     
        ATaquillas obj=new ATaquillas();
       
        obj.instanciar(0);
        leer_archivo_taquillas(obj);
        leer_archivo_estudiantes(obj);
        leer_archivo_documentos(obj);
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        int opc=0;
        
         while (opc!=14){
            
            System.out.println("Bienvenido al sistema de DACE. ");            
            System.out.println("¿Qué desea hacer?");
            System.out.println("Insertar un estudiante.                                             (Presione 1)");
            System.out.println("Insertar un documento.                                              (Presione 2)");
            System.out.println("Monto total en las 3 taquillas.                                     (Presione 3)");
            System.out.println("Mostrar estudiantes que solicitan constancia de escripcion.         (Presione 4)");
            System.out.println("Modificar un estudiante.                                            (Presione 5)");
            System.out.println("Modificar un documento.                                             (Presione 6)");
            System.out.println("Ordenar documentos.                                                 (Presione 7)");
            System.out.println("Solicitudes documento especifico.                                   (Presione 8)");
            System.out.println("Mostrar documentos de los estudiantes de Lic. en Estadistica.       (Presione 9)");
            System.out.println("Procesar estudiante.                                                (Presione 10)");
            System.out.println("Abrir una Taquilla.                                                 (Presione 11)");
            System.out.println("Cerrar una Taquilla.                                                (Presione 12)");  
            System.out.println("Eliminar un documento.                                              (Presione 13)");   
            System.out.println("Guardar y salir.                                                    (Presione 14)");
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
                       obj.insertar_estudiante(obj);
                        break;
                case 2:
                       
                       int cedula=0;
                       while (cedula==0){
        
                           System.out.print("Coloque la cedula: ");
                           try
                           {
                               cedula= Integer.parseInt(lee.readLine());
                           }
                           catch (Exception e)
                           {
                               System.out.println("Error.");
        
                           }
                       }
                       
                       obj.insertar_doc(cedula);
                       break;   
                    
                case 3:
                        System.out.println("El monto en las 3 taquillas es de: "+obj.costo_taq()+" Bs.");
                        System.out.println("");

                        break;  
                    
                 case 4:
                     obj.mostar_constancia(0);
                     System.out.println("");
                     
                     
                     break;
                     
                 case 5:   
                            int ced=0;
                            while (ced == 0) {            
                                System.out.print("Introduzca la cedula del estudiante que desea modificar: ");
        
                                try
                                {                 
                                    ced = Integer.parseInt(lee.readLine());                
                                } 
                                catch (Exception e) 
                                {                
                                    System.out.println("Debe introducir un numero. ");
                                }
                            }
                            obj.modificar_estudiante(ced);
                                    
                     
                         break;                     
                 
                 case 6:    ced=0;
                            while (ced == 0) {            
                                System.out.print("Introduzca la cedula del estudiante que posee el documento que desea modificar: ");
        
                                try
                                {                 
                                    ced = Integer.parseInt(lee.readLine());                
                                } 
                                catch (Exception e) 
                                {                
                                    System.out.println("Debe introducir un numero. ");
                                }
                            }
                            obj.modificar_documento(ced);
                     break; 
                 case 7: 
                        int opc2 = 0;
                        while (opc2!=3){
            
                            System.out.println("¿De quién desea ordenar los documentos? ");            
                            System.out.println("De un solo estudiante       (Presione 1)");
                            System.out.println("De todos los estudiantes    (Presione 2)");
                            System.out.println("Ir atras                    (Presione 3)");
                            System.out.println("Coloque su opción: ");
                            
                            try 
                            {   
                                opc2 = Integer.parseInt(lee.readLine());
                            } 
                                catch (Exception e) 
                            {
                             System.out.println("Opcion invalida ");
                            }
                            
                            
                            switch (opc2){                                
                                
                                case 1: 
                                       cedula =0;
                                       
                                       while (cedula == 0) {
            
                                          System.out.print("Introduzca la cedula del estudiante: ");
        
                                          try { 
                
                                               cedula = Integer.parseInt(lee.readLine());
                
                                          } 
                                          catch (Exception e) 
                                          {
                
                                              System.out.println("Error, Debe introducir un numero.");
                                          }
                                       }
                                    
                                       obj.ordenar1(cedula);
                                    break;
                                    
                                case 2: obj.ordenar_2(0);
                                    break;
                                    
                                case 3:
                                    break;
                                default:     System.out.println("Debe introducir un numero entre el 1 y 3.");

                                    break;
                                
                            }
                            
                            
                        }
                     break;
                 
                 case 8:
                         int cod=0;
                          while (cod == 0) {            
                                System.out.print("Coloque el código del documento: ");
        
                                try
                                {                 
                                    cod = Integer.parseInt(lee.readLine());                
                                } 
                                catch (Exception e) 
                                {                
                                    System.out.println("Debe introducir un numero. ");
                                }
                            }
                     
                         System.out.println("Solicitudes para el documento: "+obj.buscar_cant_A(cod));
                     break;
                     case 9: obj.mostrar_estadistica(0);
                     break;
                     case 10: obj.procesar(0);
                     break;
                     case 11: obj.abrir_taquilla(0);
                     break; 
                     case 12: obj.cerrar_taquilla(0);
                     break; 
                     case 13: cedula =0;
                                       
                              while (cedula == 0) {
            
                                  System.out.print("Introduzca la cedula del estudiante: ");
        
                                  try 
                                  { 
                
                                        cedula = Integer.parseInt(lee.readLine());
                
                                  } 
                                  catch (Exception e) 
                                  {
                
                                         System.out.println("Error, Debe introducir un numero.");
                                  }
                             }
                              
                             obj.eliminar_documento(cedula);
                                       
                     break; 
                     case 14: escribir_archivo_documentos(obj); 
                              escribir_archivo_taquillas(obj); 
                              escribir_archivo_estudiantes(obj); 
                     
                     break; 
                default: System.out.println("Datos invalidos, coloque un numero entre el 1 y 14. ");
                         break;
                    
            }
         }
    }
}
