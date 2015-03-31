/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grafica;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Manuel
 */
public class Ventana extends JFrame {
    
    JPanel panel;
    JLabel texto;
    JButton boton;
    
    public Ventana()
    {        
        panel = new JPanel();
        texto = new JLabel();
        boton = new JButton();
        
        this.add(panel);
        panel.add(texto);
        panel.add(boton);
        texto.setText("Hola mundo!!");
        boton.setText("Oprime");
    }
    
     public static void main(String[] args) { 
         
         
         
         
         
     }
    
    
    
}
