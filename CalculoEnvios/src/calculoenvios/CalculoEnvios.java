/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculoenvios;
import javax.swing.*;
/**
 *
 * @author Manuel
 */

class Peso_volumetrico{
    
    double largo;
    double ancho;
    double alto;
    JFrame frame;
    
    double calculo(){
        
        frame = new JFrame("Peso vol...");
        frame.setUndecorated( true );
        frame.setVisible( true );
        frame.setLocationRelativeTo( null );
        boolean exc=false;
        double pvol=0;
        double red =0;
        String cad="";
        JOptionPane.showMessageDialog(frame, "Coloque las dimensiones del paquete.", "Información", JOptionPane.INFORMATION_MESSAGE);
        
        while (exc!=true){
            exc=true;
            try
            {
                cad = JOptionPane.showInputDialog(frame, "largo: ", "Dimensiones", JOptionPane.PLAIN_MESSAGE);
                if (cad==null){
                    JOptionPane.showMessageDialog(frame, "La operacion ha sido cancelada.", "Cancelado", JOptionPane.PLAIN_MESSAGE);
                }
                largo = Double.parseDouble(cad);
            }
            catch(Exception E)
            {
                exc =false;
            }
        }
        exc =false;
        while (exc!=true){
            exc=true;
            try
            {
                cad = JOptionPane.showInputDialog(frame, "Ancho: ", "Dimensiones", JOptionPane.PLAIN_MESSAGE);
                if (cad==null){
                    JOptionPane.showMessageDialog(frame, "La operacion ha sido cancelada.", "Cancelado", JOptionPane.PLAIN_MESSAGE);
                }
                ancho = Double.parseDouble(cad);
            }
            catch(Exception E)
            {
                exc =false;
            }
        }
        exc =false;
        while (exc!=true){
            exc=true;
            try
            {
                cad = JOptionPane.showInputDialog(frame, "Alto: ", "Dimensiones", JOptionPane.PLAIN_MESSAGE);
                if (cad==null){
                    JOptionPane.showMessageDialog(frame, "La operacion ha sido cancelada.", "Cancelado", JOptionPane.PLAIN_MESSAGE);
                }
                alto= Double.parseDouble(cad);
            }
            catch(Exception E)
            {
                exc =false;
            }
        }
        
        
        
        pvol = Math.floor((largo*ancho*alto)/5000)+0.5;
        
        if (pvol<(largo*ancho*alto)/5000){        
            pvol+=0.5;
        }
        
        return pvol; 
    
     }   
    
}






public class CalculoEnvios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Peso_volumetrico pvol= new Peso_volumetrico();
        
        System.out.println(pvol.calculo());
        pvol.frame.dispose(); 
    }
}
