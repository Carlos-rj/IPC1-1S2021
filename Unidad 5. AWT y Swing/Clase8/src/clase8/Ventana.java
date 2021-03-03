package clase8;
/*
VENTANA: Esta clase funcionara como nuestra ventana principal
    Con esta ventana voy a tratar de explicar la mayoria de cosas que se vieron hoy
*/

// IMPORTAMOS LAS LIBRERIAS NECESARIAS

// LIBRERIAS PARA EVENTOS
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// LIBRERIAS PARA COMPONENTES
import javax.swing.*;

// Tenemos algo "nuevo" en este caso y es que como queremos que nuestra clase sea una ventana
// Le vamos a agregar el extends JFrame, es decir que nuestra clase HEREDA la clase JFrame

// Tambien agregamos el implements, esto es para llamar una interfaz, es decir metodos que ya existen
// Usamos la interfaz ActionListener, para que esta clase sea capaz de reconocer las acciones

// Al momento de usar el extends y el implements, nos tira un error de que la clase no tiene los metodos
// Entonces le damos click al error y que nos agregue el metodo, este metodo se agrega en la parte del
// Override, normalmente se agrega hasta abajo
public class Ventana extends JFrame implements ActionListener {
    /*
        Resulta que los componentes para agregar a nuestra ventana, siguen siendo objetos
        Por lo tanto, lo podemos utilizar como "atributos" de nuestra clase, es decir...
    */
    
    // OBJETOS DE LA VENTANA
    // JLabel hace referencia a las etiquetas de texto
    JLabel l1, l2;
    // JTextField hace referencia a los cuadros de texto
    JTextField t1, t2;
    // JButton hace referencia a los botones
    JButton b1, b2;
   
    // Todos estos Objetos ya tienen sus propios metodos para configurarlos dentro de la ventana

    // ATRIBUTOS
    // A su vez, tambien tenemos "variables" que vamos a usar en toda la ventana, para almacenar informacion
    String usuario, pass;
    
    
    /* METODO CONSTRUCTOR EN VENTANAS
        Se recomienda que este metodo sea el que cree todos los componentes de nuestra ventana
        es decir que dentro de el, vamos a agregar todos los botones, etiquetas, etc.
    */
    public Ventana(){
        /* DECLARANDO LOS LABELS
            - Usamos el constructor, para darle un texto al JLabel
            - Usamos setBounds para agregar PosX, PosY, TamX, TamY
            - Usamos setVisible para que se pueda visualizar
        */
        l1 = new JLabel("Usuario");
        l1.setBounds(10, 10, 50, 50);
        l1.setVisible(true);
        // Es necesario agregar el componente creado dentro de nuestra ventana
        // En este caso, nuestra ventana se hace referencia con this, por que es "ESTA" clase
        this.add(l1);
        
        l2 = new JLabel("Contraseña");
        l2.setBounds(10, 50, 75, 50);
        l2.setVisible(true);
        this.add(l2);
        
        /* DECLARANDO TEXTBOX
            -Usamos el constructor sin texto adentro, si quisieramos que tuviera un texto por defecto
             se le agrega en el constructor
            -Usamos el setBounds para agregarle PosX, PosY, TamX, TamY
            -Usamos el setVisible para que sea visible en la ventana
        */
        t1 = new JTextField();
        t1.setBounds(100, 25, 350, 25);
        t1.setVisible(true);
        // Al igual que los labels, es necesario agregar el componente a la ventana siempre con add.
        this.add(t1);
        
        t2 = new JTextField();
        t2.setBounds(100, 65, 350, 25);
        t2.setVisible(true);
        this.add(t2);
        
        /* DECLARANDO BOTONES
            - Usamos el constructor con un nombre adentro, para indicarle el texto del boton.
            - Usamos el setBounds para asignarle PosX, PosY, TamX, TamY
            - Usamos el setVisible para que sea visible dentro de la ventana
        */
        b1 = new JButton("Iniciar Sesion");
        b1.setBounds(10, 100, 120, 30);
        b1.setVisible(true);
        /* ACCIONES DEL BOTON
            Como nuestra interfaz grafica se basa en eventos generados por botones, agregamos
            la propiedad addActionListener(this); haciendo referencia que los eventos que ocurran
            en ESTA ventana, son los que el boton podra escuchar
        
            Para esto es necesario usar el implementes ActionListener de alla arribita.
        */
        b1.addActionListener(this);
        // Agregamos el boton a nuestra ventana con add
        this.add(b1);
        
        b2 = new JButton("Registro");
        b2.setBounds(350, 100, 120, 30);
        b2.setVisible(true);
        b2.addActionListener(this);
        this.add(b2);
        
        /*  PROPIEDADES DE LA VENTANA
            Una vez que tenemos creados los componentes que acompañan a nuestra ventana
            tambien tenemos que darle propiedades a nuestra ventana
            - Usamos setTitle para ponerele un titulo a la ventana
            - Usamos setBounds para asignarle PosX, PosY, TamX, TamY
            - Usamos setLayout(null) para decirle que los componentes los colocaremos segun nuestra
                configuracion, al usar un Layout, los componentes se colocan en base del Layout
            - Usamos setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) para que la aplicacion se termine
                cuando cerramos la ventana
            - Usamos setResizable(false) para decirle a la ventana que su tamaño es fijo.
            - Usamos setVisible par que nuestra ventana sea visible
        */
        this.setTitle("Clase 7 - Interfaz Grafica");
        this.setBounds(100,100,500,200);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        
        // PARA ESTE PUNTO, SABEMOS QUE EL CONSTRUCTOR ES EL PRIMER METODO A EJECUTARSE
        // Cada vez que llamemos una Ventana de este tipo, se construyen estos objetos y se agregan
        // a la ventana

        /* METODO PARA LEER LA INFORMACION DEL USUARIO
            Tenemos que nuestro arreglo esta declarado como STATIC en el main, por lo tanto
            podemos hacer uso de estos objetos si colocamos ClaseMain.Objeto
        
            Para este ejemplo, mandamos a llamar al metodo static que esta declarado en el main
            (Clase8.java) para este ejemplo, el cual recorre o muestra la informacion de los usuarios
            registrados.
        */
        Clase8.LeerUsuarios();
    }

    /* SOBRECARGA DE METODOS
        Como estamos implementando el ActionListener, este metodo es el general para hacer
        uso de los eventos, entonces en este metodo vamos a configurar las acciones de los botones.
    */
    @Override
    public void actionPerformed(ActionEvent ae) {
        // el parametro ae es el evento que se "disparo" o se "acciono" en la ventana
        
        // Para diferenciar entre botones vamos a hacer una secuencias de if con la siguiente estructura
        // ae.getSource -> es decir que componente fue el que capto la accion de la ventana
        // ae.getSource == componente, esto se haria para cada componente
        if(ae.getSource() == b1){
            /*
                En este caso configuramos el b1, lo que este aqui adentro es lo que hara el b1
                cada vez que reciba un evento, en este caso, serian los clicks
            */
            
            // OBTENIENDO LA INFORMACION DE LOS TEXTBOX
            //  Usamos el metodo getText(); el cual nos devuelve el string del texto
            //  Si fuera un valor numerico, habria que parsear la informacion
            usuario = t1.getText();
            pass = t2.getText();
            
            // MOSTRANDO EN CONSOLA LA INFORMACION QUE OBTUVIMOS
            System.out.println("Los datos para iniciar sesion son: ");
            System.out.println("Usuario: " + usuario);
            System.out.println("Password: " + pass);
            
            /* INICIANDO SESION 
                Como bien se vio anteriormente, se creo un metodo para verificar las credenciales
                del usuario, como este metodo esta en la clase main (Clase8.java) solo es necesario
                agregar el nombre de la clase y llamar al metodo
            
                como nuestra funcion retorna un usuario la guardamos en un objeto de tipo Usuario
            */
            Usuarios logeado = Clase8.VerificarUsuario(usuario, pass);
            // SI EL USUARIO ES DIFERENTE DE NULL
            if(logeado != null){
                /* MOSTRAR MENSAJES DESPLEGABLES
                    Usamos el JOptionPane.showMessageDialog para mostrar MessageBox
                    Se le puede agregar mas estilos y segun el tipo de mensaje
                */
                        
                JOptionPane.showMessageDialog(this, "Se encontro el usuario de nombre: " + logeado.getNombre());
                /*  ABRIR UNA NUEVA VENTANA
                    En este caso, tenemos una ventana llamada Inicial, esta ventana sera la Pagina Principal
                    y queremos manejar la informacion del usuario que encontramos dentro de la nueva ventana
                
                    Podemos enviar la informacion como parametros dentro del constructor, para que a la hora de 
                    crear la ventana, en el constructor de la otra ventana podemos manejar esta informacion
                */
                Inicial ini = new Inicial(logeado);
                
                /*
                ACLARACION:
                    No es la unica forma de manejar ventanas, pero es la forma que yo lo manejo, creando un objeto por cada
                    vez que se necesite y cerrando la ventana actual, para "no sobrecargar la memoria"
                
                    Usamos el metodo dispose(); para cerrar la ventana, esta la elimina de la memoria como tal, no solo la oculta.
                */
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "No se encontro ningun usuario");
            }
        }else if(ae.getSource() == b2){
            // TODO LO QUE VA A HACER EL BOTON2
            System.out.println("Tocaste el boton de Registrarse");
            Registro registro = new Registro();
            this.dispose();
        }
    }
    
    
}
