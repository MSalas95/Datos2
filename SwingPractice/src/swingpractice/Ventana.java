/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swingpractice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.SwingUtilities;


public class Ventana extends JFrame {
    
    public Ventana(){        
        Componentes();
        this.setSize(200,200);
        
    }

    private void Componentes() {
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana de prueba.");
        setBounds(new Rectangle(475, 200, 0, 0));
        setResizable(true);
        
        //crear layout
        setLayout(new BorderLayout());
        
        //crear componentes
        texto = new JTextArea();
        click = new JButton("Click aqui!");
        panel1 = new Panel1();
        //agregar los componentes al pane
        Container c = getContentPane();
        
        c.add(texto,BorderLayout.CENTER);
        c.add(click,BorderLayout.SOUTH);
        c.add(panel1,BorderLayout.WEST);
        
        //colocar tamaño y ubicacion a los componentes (en caso de ser necesario)
        
        //texto.setBounds(10, 10, 170, 120);
        //click.setBounds(45, 140, 100, 30);
        
        //agregar comportamiento
        
        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickAccion(e);
            }
        });
        
        
        
    }
    
    
    void clickAccion(ActionEvent e){
        
        texto.append("Hola soy manuel\n");
                
        
    }
    
    
    
    
    
    public static void main(String args[]) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana().setVisible(true);
            }
        });       
        
    }
    
    
    
//    DECLARACION DE VARIABLES
    
     private JButton click;
     private JTextArea texto;
     private Panel1 panel1;
}
