package clase9;

// Luego de importar la libreria, debemos de importar el codigo
// LIBRERIAS PARA INTERPRETAR UN JSON
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

// LIBRERIAS PARA EVENTOS
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// LIBRERIAS PARA LEER UN ARCHIVO DE TEXTO
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

// LIBRERIA PARA MANEJAR COMPONENTES
import javax.swing.*;

// Si queremos que nuestra ventana haga acciones, usamos el implements
// Siempre con el extens JFrame e implementes ActionLister
public class Ventana extends JFrame implements ActionListener {
    // COMPONENTES
    JButton boton1;
    JButton boton2;
    
    // ATRIBUTOS
    String contenido = "";
    File archivo;
    FileReader fr;
    BufferedReader br;
    
    // METODO CONSTRUCTOR
    public Ventana(){
    // COMPONONTENTES DE LA VENTANA
        boton1 = new JButton("Cargar JSON");
        boton1.setBounds(10, 50, 125, 30);
        boton1.addActionListener(this);
        this.add(boton1);
        
        boton2 = new JButton("Ingresar");
        boton2.setBounds(10, 100, 125, 30);
        boton2.addActionListener(this);
        this.add(boton2);
        
    // PROPIEDADES DE LA VENTANA
        // TITULO
        this.setTitle("Leer JSON desde un boton");
        // DIMENSIONES - POSX, POSY, TAMX, TAMY
        this.setBounds(100,100,150,200);
        // TERMINAR LA EJECUCION
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // DECLARANDO LAYOUT
        this.setLayout(null);
        // LA VENTANA SEA VISIBLE
        this.setVisible(true);
    }
    
    // EL SIEMPRE CONFIABLE LEER ARCHIVOS
    public void leerArchivos(){
        // A diferencia de otros casos, lo que tenemos que hacer es obtener
        // el texto del JSON que al final es puro texto
        try{
            /* JFileChooser
                Es el componente que nos despliega una ventana para seleccionar un archivo
                El metodo getSelectedFile() nos retorna un dato tipo File,
            */
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                //System.out.println(fc.getSelectedFile());
                archivo = fc.getSelectedFile();
            }
            
            // HACEMOS LA LECTURA DEL ARCHIVO COMO TAL
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            // LEER LINEA POR LINEA
            while ((linea = br.readLine()) != null) {
                // Solo agregamos el contenido a un String
                contenido += linea;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    
    @Override
    // MANEJADOR DE EVENTOS
    public void actionPerformed(ActionEvent ae) {
        // HACK: Recuerden hacer un if por cada boton.
        if(ae.getSource() == boton1){
            // TODO LO QUE ESTE AQUI, HARA EL BOTON1
            System.out.println("Presionaste al Boton 1.");
            leerArchivos();
            System.out.println(contenido);
            // JsonParser parser -> Todos los metodos necesarios para interpretar un JSON.
            JsonParser parser = new JsonParser();
            // JsonArray arreglo de objetos JSON.
            JsonArray arreglo = parser.parse(contenido).getAsJsonArray();
            // PARA ESTE MOMENTO ARREGLO YA TIENE LO QUE ES UN ARREGLO ALMACENADO
            System.out.println("Cantidad de Objetos: " + arreglo.size());
            
            // RECORRER MI ARREGLO
            for (int i = 0; i < arreglo.size(); i++) {
                // JsonObject -> Tomar el Objeto del Arreglo
                JsonObject objeto = arreglo.get(i).getAsJsonObject();
                /* Obtener los datos del Objeto JSON
                    Una vez que tengamos nuestro objeto, usamos el metodo
                    get(nombreLlave) donde el nombreLlave viene en base al archivo
                    JSON que estemos leyendo, en este caso venia nombre, edad y tamaño
                    pero si el archivo tuviera por ejemplo: correo, telefono, codigo
                    esos campos tambien se podrian obtener con el get
                */
                
                // GUARDAMOS LOS DATOS EN VARIABLEs
                String nombre = objeto.get("nombre").getAsString();
                int edad = objeto.get("edad").getAsInt();
                double tamaño = objeto.get("tamaño").getAsDouble();
                // CREAMOS NUESTRO OBJETO PERSONA
                Persona nuevo = new Persona(nombre, edad, tamaño);
                
                // MANDAMOS A LLAMAR NUESTRO METODO QUE AGREGA PERSONAS EN EL ARREGLO
                // Recordemos que es un metodo static, por lo tanto solo basta con poner
                // NombreClase.Metodo o NombreClase.Variable para acceder a ellos
                Clase9.AgregarPersona(nuevo);
            }
            Clase9.LeerPersonas();
        }
        else if(ae.getSource() == boton2){
            /* ABRIR UNA NUEVA VENTANA
                Como el codigo del constructor crea la ventana y la hace visible
                basta con que declaremos el objeto.
            */
            Tabla nueva = new Tabla();
            /* CERRAMOS LA VENTANA ACTUAL
                Este dispose es para borrar el objeto que creamos, recordemos que
                cada ventana al final sigue siendo un objeto
            */
            this.dispose();
        }
    }
}
