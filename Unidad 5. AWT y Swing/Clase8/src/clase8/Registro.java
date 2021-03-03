package clase8;
/*
VENTANA DE REGISTRO:
    En esta ventana nos servira para obtener la informacion necearia para crear un nuevo
    objeto de tipo usuario, la ventana es muy parecida, solo se explicara lo "nuevo" de esta ventana
*/

// LIBRERIAS PARA EVENTOS
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// LIBRERIAS PARA INTERFAZ GRAFICA
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// RECORDAR SIEMPRE
// extends JFrame e implementes ActionListener
public class Registro extends JFrame implements ActionListener {
    // OBJETOS DE LA VENTANA
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2;
    
    /* METODO CONSTRUCTOR 
        El primer metodo a llamar para crear la ventana
        En este metodo se inicializan los objetos de los componentes con sus propiedades
        Ver la clase Ventana.java para entender mas las propiedades de este clase.
    */
    public Registro(){
        // DECLARANDO LOS LABELS
        l1 = new JLabel("Usuario");
        l1.setBounds(10, 10, 50, 50);
        l1.setVisible(true);
        this.add(l1);
        
        l2 = new JLabel("Contraseña");
        l2.setBounds(10, 50, 75, 50);
        l2.setVisible(true);
        this.add(l2);
        
        l3 = new JLabel("Nombre");
        l3.setBounds(10, 90, 75, 50);
        l3.setVisible(true);
        this.add(l3);
        
        // DECLARANDO TEXTBOX
        t1 = new JTextField();
        t1.setBounds(100, 25, 350, 25);
        t1.setVisible(true);
        this.add(t1);
        
        t2 = new JTextField();
        t2.setBounds(100, 65, 350, 25);
        t2.setVisible(true);
        this.add(t2);
        
        t3 = new JTextField();
        t3.setBounds(100, 105, 350, 25);
        t3.setVisible(true);
        this.add(t3);
        
        // DECLARANDO BOTONES
        b1 = new JButton("Registrar");
        b1.setBounds(10, 150, 120, 30);
        b1.setVisible(true);
        b1.addActionListener(this);
        this.add(b1);
        
        b2 = new JButton("Retornar");
        b2.setBounds(350, 150, 120, 30);
        b2.setVisible(true);
        b2.addActionListener(this);
        this.add(b2);
        
        this.setTitle("Clase 7 - Registro de Usuario");
        this.setBounds(100,100,500,250);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    // SOBRECARGA DE METODOS
    @Override
    public void actionPerformed(ActionEvent ae) {
        // En estos if es donde verificamos que boton recibe el boton
        // ae.getSource() -> verifica que componente es el que tuvo el evento, en este claso evento Click.
         if(ae.getSource() == b2){
             // TODO LO QUE HARA NUESTRO BOTON2
             // Esta ventana solo crea una nueva Ventana y cierra la ventana actual.
             Ventana nueva = new Ventana();
             this.dispose();
         }
         if(ae.getSource() == b1){
             /* BOTON DE REGISTRO
                Obtenemos los valores que tiene cada JTextField y lo usamos para crear el objeto Usuario
                este objeto se agregara al arreglo de Usuarios que tenemos definido como Static en la clase main
             
                RECORDEMOS QUE LA CLASE MAIN SE LLAMA Clase8
             */
             
             // DATOS DEL USUARIO
             String usuario, pass, nombre;
             usuario = t1.getText();
             pass = t2.getText();
             nombre = t3.getText();
             // OBJETO USUARIO
             Usuarios nuevo = new Usuarios(usuario, pass, nombre);
             
             // METODO CREADO EN LA CLASE MAIN PARA AGREGAR UN USUARIO AL ARREGLO DE USUARIOS
             // Como ya esta definido en nuestra clase main, solo es necesario llamar el metodo
             
             // NombreClase.Metodo();
             Clase8.AgregarUsuario(nuevo);
             JOptionPane.showMessageDialog(this, "Se agrego el usuario");
         }
    }
}
