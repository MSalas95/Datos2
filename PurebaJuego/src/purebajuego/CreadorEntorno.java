/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package purebajuego;
import javax.swing.*;

/**
 *
 * @author Manuel
 */
public class CreadorEntorno extends JFrame {
    
    private Base Basevirtual = new Base();
    private JLabel[][] BaseGrafica= new JLabel[4][4];
    
    public CreadorEntorno() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(100, 100);
        setVisible(true);
    
    }
    
    public void CreadorGrafico(){
        
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                System.out.println(Basevirtual.Imagenes[i][j]);
                BaseGrafica[i][j]= new JLabel();
                add(BaseGrafica[i][j]);
                BaseGrafica[i][j].setIcon(new ImageIcon("C:/Users/Manuel/Pictures/Matrices/Prueba1/"+Basevirtual.Imagenes[i][j]+".ico"));
            }        
        
       }
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                BaseGrafica[i][j].setBounds(i*Basevirtual.alto, j*Basevirtual.largo,*Basevirtual.alto, Basevirtual.largo);
                BaseGrafica[i][j].validate();
            }
            
        }
            
    
   }
}