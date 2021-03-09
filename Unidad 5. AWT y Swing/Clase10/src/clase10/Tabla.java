package clase10;

// IMPORTAMOS LA LIBRERIA DE LOS COMPONENTES
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// EN ESTE CASO, NO QUEREMOS ACCIONES SOLO MOSTRAR INFORMACION
public class Tabla extends JFrame implements MouseListener{
    // AHORA EL JTABLE LO HACEMOS GLOBAL
    JTable t;
    // PARA MANEJAR IMAGENES USAMOS UN JLABEL
    JLabel imagen;
    
    public Tabla(){
        // Obtenemos el arreglo de objetos
        Object[][] datos = Clase10.convertirDatos();
        // Agregamos las columnas
        String[] columnas = {"Codigo", "Nombre","Edad","Tamaño","Accion"};
        
        // A diferencia del caso anterior, no le mandamos parametros a nuestro jTable.
        t = new JTable();
        
        /*  DEFAULT TABLE MODEL
            En este caso, la tabla es nuestro contenedor y el TableModel es el que tiene toda la informacion
            Entonces el DefaultTableModel nos pide dos arreglos de Objetos, en este caso mandamos los datos y columnas
        
            PEROOOOO, este DefaultTableModel tiene algo peculiar, que luego de la asignacion, le definimos un metodo
            este metodo le indica que no podemos editar las celdas, por eso es que se hace distinto a la clase pasada.
            Ya que si dejamos los datos "estaticos" solo es para mostrar informacion
        */
        DefaultTableModel d = new DefaultTableModel(datos,columnas){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        // AGREGAMOS EL TABLEMODEL A LA TABLE
        t.setModel(d);
        
        // EN ESTE CASO, No usamos un AddActionListener, si no un MouseListener, para obtener el evento click en especifico.
        t.addMouseListener(this);
        // Para agregarlo tuvimos que haber implementado la interfaz MouseListener, la misma logica que el ActionListener
        
        // REDIMENSIONAR COLUMNAS
        // Obtenemos el modelo de Columnas y le definimos el tamaño por cada columna
        // Cada columna se puede representar con un arreglo, solo que usamos parentesis en vez de corchetes para acceder a la columna
        t.getColumnModel().getColumn(0).setPreferredWidth(10);
        t.getColumnModel().getColumn(1).setPreferredWidth(10);
        t.getColumnModel().getColumn(2).setPreferredWidth(10);
        t.getColumnModel().getColumn(3).setPreferredWidth(10);
        t.getColumnModel().getColumn(4).setPreferredWidth(100);
        
        // METODO PARA RENDERIZAR LOS DATOS
        // La tabla ahora tiene un Renderizado en especifico que nosotros asignamos, ver la clase Render
        // para entender como es que funciona.
        t.setDefaultRenderer(Object.class, new Render());
        
        
        // AGREGAMOS LA TABLA CON TODOS LOS CAMBIOS AL SCROLL PANE
        JScrollPane sp = new JScrollPane(t);        
        sp.setBounds(10, 10, 300, 300);
        sp.setVisible(true);
        this.add(sp);
        
        
        // AGREGANDO UNA IMAGEN COMO ICONO
        imagen = new JLabel();
        // Creamos un objeto ImageIcon donde ingresamos la ruta del archivo
        ImageIcon img = new ImageIcon("44eggm.png");
        // Le agregamos el tamaño :)
        imagen.setBounds(350, 10, 300, 300);
        // Creamos un objeto Image, con este objeto haremos una redimension.
        // usamos el ImageIcon que tiene la imagen y obtenemos la imagen
        // usamos el metodo getScaledInstance para redimensionar la imagen.
        // los parametros a mandar son el ancho del objeto, el largo del objeto y el metodo SCALE_SMOOTH
        Image nuevo = img.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH);
        
        // Creamos un nuevo objeto con la imagen que redimensionamos
        ImageIcon render = new ImageIcon(nuevo);
        
        // Le agregamos al Label el icono ya redimensionado.
        imagen.setIcon(render);
        imagen.setVisible(true);
        this.add(imagen);

        
        // PROPIEDADES DE LA VENTANA
        this.setTitle("Tabla de Datos");
        this.setBounds(100,100,700,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }   

    // Una vez implementado el MouseListener, JAVA nos pide que implementemos los metodos abstractos.
    // No se eliminan los metodos, solo se ignoran :3 el que mas nos interesa es el mouseClicked
    @Override
    public void mouseClicked(MouseEvent me) {
        // Hagamos de cuenta que el objeto que recibe el evento, siempre hara este metodo.
        // Segun la logica, nos dice que esta tabla recibira clicks unicamente
        System.out.println("Se le dio click a la tabla");
        
        // Obtenemos la columna con el MouseEvent.getX
        int columna = t.getColumnModel().getColumnIndexAtX(me.getX());
        // Obtenemos la fila con el MouseEvent.getY
        int fila = me.getY()/t.getRowHeight();
        System.out.println("Click en la posicion: " + fila + "-" + columna);
        
        // Solo validamos que se haya dado click dentro de la tabla, pero esto esta de mas.
        if(fila < t.getRowCount()&& fila >= 0 && columna < t.getColumnCount() && columna >= 0){
            // Obtenemos el objeto que esta dentro de la tabla, tomando en cuenta la fila y columna
            Object value = t.getValueAt(fila, columna);
            // TABLA DEVOLVEME EL OBJETO QUE TENES EN [FILA][COLUMNA]
            if(value instanceof JButton){
                /* FORMA 1
                    Como ya obtuvimos la fila, es decir le dimos click al boton, sabemos en que columna esta 
                    guardado el codigo, esto funciona si el codigo se mostrara en la tabla
                */
                System.out.println("OBTENIENDO EL ID POR MEDIO DE LA COLUMNA");
                String codigo = t.getValueAt(fila, 0).toString();
                Clase10.LeerPersona(codigo);
                
                /* FORMA 2
                    Si no mostraramos el codigo del objeto, es decir no tenemos referencia a este dato
                    podemos usar el hack del nombre del boton, que lo nombramos con el identificador unico
                */
                System.out.println("OBTENIENDO EL ID POR EL NOMBRE");
                JButton boton = (JButton) value;
                Clase10.LeerPersona(boton.getName());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
