package pruebajoption;




import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Pruebajoption extends JFrame implements ActionListener{
  JButton btn_Hola;
  JTextField txt_Nombre;
  int Respuesta;
  public void Ejemplo_JOptionPane(){
   // super("Ejemplo de JOptionPane");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    btn_Hola = new JButton("Presionar");
    btn_Hola.addActionListener(this);
    btn_Hola.setMnemonic('P');

    txt_Nombre = new JTextField(60);

    getContentPane().setLayout(new BorderLayout(10,10));
    getContentPane().add(btn_Hola, BorderLayout.SOUTH);
    getContentPane().add(txt_Nombre, BorderLayout.NORTH);

    setSize(200,200);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void main(String[] args) throws IOException{
    JFrame.setDefaultLookAndFeelDecorated(true);
    JDialog.setDefaultLookAndFeelDecorated(true);
    
  }

  public void actionPerformed(ActionEvent ae){
    if (ae.getSource().equals(btn_Hola)) {
      JOptionPane.showMessageDialog(null,"Hola " + txt_Nombre.getText(),"Esto sólo dice Hola",JOptionPane.INFORMATION_MESSAGE);
      Respuesta = JOptionPane.showConfirmDialog(null,"Quieres que te diga Chao antes de salir???","Pregunta",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
      if (Respuesta == 0) {
        JOptionPane.showMessageDialog(null,"CHAO!!!!","Cerrando",JOptionPane.INFORMATION_MESSAGE);
      }
      System.exit(0);
    }
  }
}
