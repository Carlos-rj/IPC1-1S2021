package clase8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Inicial extends JFrame implements ActionListener {
    JLabel l1;
    Usuarios logeado;
    
    public Inicial(Usuarios user){
        // DECLARANDO LOS LABELS
        logeado = user;
        JOptionPane.showMessageDialog(this, "BIENVENIDO SEAS " + logeado.getNombre());
        logeado.MostrarInfo();
        
        l1 = new JLabel(logeado.getNombre());
        l1.setBounds(10, 10, 50, 50);
        l1.setVisible(true);
        this.add(l1);
        
        this.setTitle("Clase 7 - Pantalla Inicial");
        this.setBounds(100,100,500,200);
        this.setLayout(null);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    
    }

    
}
