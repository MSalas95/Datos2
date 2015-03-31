
package proyecto.venta.de.boletos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Cliente {
        String cedula;
        String nombre;
        String apellido;
        String direccion;
        double telefono=0;
        int m;
        int contadorc=0;
        public Cliente cl[]=new Cliente[m];
        
         
         void registrar() throws IOException
        {
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
           
         if(contadorc<1){   
            
                
            System.out.println("Cedula");
            Cliente.this.cedula=br.readLine();
            System.out.println("Nombre");
            Cliente.this.nombre=br.readLine();
            System.out.println("Apellido");
            Cliente.this.apellido=br.readLine();
            System.out.println("Direccion");
            Cliente.this.direccion=br.readLine();
            System.out.println("Telefono");
            Cliente.this.telefono=Double.parseDouble(br.readLine());
            guardar();
             contadorc++;
        }
        }
           
        public void mostrarc() throws IOException
        {
            for(m=0;m<cl.length;m++)
            {
            System.out.println(cl[m].cedula+cl[m].nombre+cl[m].apellido+cl[m].direccion+cl[m].telefono);
            
            
        }
        }
         
         void guardar()throws IOException
        {
            String datos;
            datos=cedula+"/"+nombre+"/"+apellido+"/"+direccion+"/"+telefono;
            archivo arch=new archivo();
            arch.crear("cliente.txt",datos);
        }
        
        
    }
 
class archivo
    {
        PrintWriter pf;
        FileReader fr;
        void crear(String pNombre,String pDatos) throws IOException
        {
            pf=new PrintWriter(new FileWriter(pNombre,true));
            pf.println(pDatos);
            pf.close();
            System.out.println("Registrado exitosamente :D");
            
        }
   
        void leer(String pnombre) throws IOException
        {
            
            fr=new FileReader(pnombre);
            BufferedReader br=new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null)
            {
                String[]datos=new String[4];
                datos=linea.split(" ");
                for(int i=0;i<=datos.length-1;i++)
                    System.out.println(datos[i]);
                
                    
            }
        }
    }
