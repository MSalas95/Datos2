/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newtrucovenezolano;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Manuel
 */
public class Mesa extends JFrame {
    
    int i=0;
    private JLabel Carta;
    private Mazo mazo;
    private JButton sacar;
    private JLabel fondo;
    
    public Mesa(){
        
        componentes();
        this.setSize(605,629);
        
        
    }
    
    private void componentes(){
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prueba imagenes cartas");
        setBounds(new Rectangle(475, 200, 0, 0));
        setResizable(false);  
        
        //crear componentes
        
        mazo = new Mazo();
        Carta=new JLabel();
        mazo.crear();  
        sacar = new JButton("Saca una carta");
        fondo = new JLabel(new ImageIcon(getClass().getResource("Mesa/F1.jpg")));
        //crear layout        
        setLayout(null);
        setBounds(new Rectangle(400, 75, 0, 0));
        
        //agregar componentes al pane
        final Container c = getContentPane();
        c.add(sacar);
        c.add(Carta);
        c.add(fondo);
        //colocar tamaño y ubicacion a los componentes 
        
        sacar.setBounds(230, 100, 150, 40);
        Carta.setBounds(275,225,59,92);
        fondo.setBounds(0, 0, 600, 600);
        //agregar comportamiento
        
        sacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                
                if (i==40){
                    Carta.setVisible(false);
                    
                    
                } else {
                    
                    Carta.setIcon(mazo.mazo[i].image);
                    i=i+1;
                }
               
               
            }
                                
        });
        
        
        
    }
    
    
    
    
    
    
}
