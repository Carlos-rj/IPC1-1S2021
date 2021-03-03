package clase9;

// IMPORTAMOS LA LIBRERIA DE LOS COMPONENTES
import javax.swing.*;

// EN ESTE CASO, NO QUEREMOS ACCIONES SOLO MOSTRAR INFORMACION
public class Tabla extends JFrame {
    
    public Tabla(){
        /* CREAR TABLAS: Basado en el PDF de Lecturas
            Tenemos que crear un arreglo de Objetos, entonces creamos un metodo en el main
            solo para retornar ese arreglo de objetos
        */
        Object[][] datos = Clase9.convertirDatos();
        // Creamos un arreglo donde tenga los encabezados
        String[] columnas = {"Nombre","Edad","Tamaño"};
        // De parte de Swing, podemos crear una tabla con un arreglo de objetos y un arreglo de strings
        // Para que cree el componente con la informacion que necesitamos
        JTable t = new JTable(datos, columnas);
        // Debemos agregar esta tabla a un ScrollPane (Este tiene un Scroll para visualizar la tabla)
        JScrollPane sp = new JScrollPane(t);
        // Como usamos un Layout(null); debemos de agregarle el tamaño a cada componente que estemos utilizando
        sp.setBounds(10, 10, 300, 300);
        sp.setVisible(true);
        // Por ultimo agregamos el ScrollPane que tiene dentro la tabla.
        this.add(sp);
        
        // PROPIEDADES DE LA VENTANA
        this.setTitle("Tabla de Datos");
        this.setBounds(100,100,500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
    }
    

}
