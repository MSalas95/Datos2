/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swingpractice;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Manuel
 */
public class Panel1 extends JPanel {
    
    public Panel1(){
        
        Componentes();
        
    }
    
    private void Componentes(){
        
        Dimension size = getPreferredSize();
        size.width=140;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Manuel"));
                
        JLabel nombre = new JLabel("Nombre: ");
        JLabel ocupacion = new JLabel("Ocupacion: "); 
        JTextField namefield = new JTextField(10);
        JTextField occupationfield = new JTextField(10);
        JButton addbtn = new JButton("add");
        
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
    }
    
}
