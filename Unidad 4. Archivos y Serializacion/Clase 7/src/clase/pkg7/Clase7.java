package clase.pkg7;

// LIBRERIAS PARA LA SERIALIZACION
/*
    Resulta que el proceso de serializar un objeto ya esta definido y por eso es que existen estas librerias
    Si, necesitamos las 4 a fuerzas, tambien podriamos importar todas las librerias de java.io con la siguiente instruccion

import java.io.*;

    Pero es cuestion del desarrollador
*/
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Clase7 {
    // Para serializar es bastante importante que manejemos los objetos tanto para guardar el objeto
    // Como para poder cargarlo, entonces declaramos los siguientes objetos
    
    // OIS -> ObjectInputStream es el que nos permite leer un Objeto
    static ObjectInputStream ois;
    // OOS -> ObjectOutputStream es el que nos permite convertir un Objeto para guardarlo.
    static ObjectOutputStream oos;
    
    // Un arreglo cualquiera, ya que queremos realizar una persistencia de datos
    // tomaremos el ejemplo de Persona
    static Persona[] personas;

    
    public static void main(String[] args) {
        Persona persona = new Persona("Carlos",22);
        Carro carro = new Carro("Toyota","Gris","P-123ABC");
        persona.AsignarCarro(carro);
        carro = new Carro("Toyota", "Rojo", "P-456CDE");
        persona.AsignarCarro(carro);
                carro = new Carro("Toyota", "Rojo", "P-456CDE");
        persona.AsignarCarro(carro);
        persona.MostrarDatos();
    }
    
    // PERSISTENCIA DE DATOS
    /*
        Se recomienda que estos metodos sean lo primero que hara el programa, la lectura de datos
        Y cada vez que se maneje informacion, actualizar, eliminar o algo por el estilo, se guarden los datos
    
        Cada objeto va a tener su archivo serializado O si ustedes desean pueden hacer un objeto que guarde
        un arreglo de cada objeto, como un Objeto "Serializador", decision del desarrollador
    */
    public static void Serializar(){
        /* 
            En este caso, lo primero que debemos de hacer es que a nuestro arreglo le vamos a asignar
            el objeto que rescatamos de la lectura.
        
            Sabemos que existe este archivo por el flujo de memoria, pero siempre se recomienda hacer la validacion
            Por si llegara a eliminarse el archivo o algo por el estilo
        */
        
        // Nuestro arreglo personas = Cargar()
        // Cargar hace referencia al archivo binario que guardo el objeto serializado, como la funcion retorna
        // un objeto, hay que hacer una conversion explicita, si. Si podemos convertir los datos a un objeto tambien
        personas = (Persona[]) Cargar();
        // Esta validacion es la mas importante, puesto que si retornamos null es porque el objeto aun no existe o no se
        // guardo previamente, entonces si no existe, es como declarar el arreglo como nuevo.
        
        // NOTA: Si quisieramos saber el contador actual, deberiamos de hacer un recorrido hasta encontrar el dato que sea nulo.
        // HACK: Hacer esta carga al iniciar el programa, que lo primero que haga sea la verificacion de estos archivos
        if(personas == null){
            System.out.println("No se ha creado el archivo");
            personas = new Persona[10];
        }
        
        // PARA ESTE PUNTO, SABEMOS QUE TENEMOS UN OBJETO SERIALIZADO Y YA LO ALMACENAMOS
        // Entonces podemos seguir trabajando con el objeto como tal, sin ningun problema
        System.out.println(personas[0].getNombre());
        
        // N INSTRUCCIONES CON EL OBJETO
        personas[0] = new Persona("Carlos",22);
        
        // Cuando terminamos de almacenar los valores en el objeto, necesitamos guardar los cambios, por lo tanto
        // Se recomienda que cada vez que se haga un cambio en los arreglos donde estemos manejando la informacion
        // Se mande a llamar el objeto Escribir para que la informacion sea la mas actualizada.
        Escribir(personas);
    }
    
    
    // METODOS DEFINIDOS PARA LA SERIALIZACION
    
    // CREAR UN ARCHIVO SERIALIZADO
    /*
        Como bien vimos en laboratorio, todo esto lleva un flujo y este flujo es representado en este metodo
        siempre tomando en consideracion que estamos trabajando con un Objeto serializado
    */
    
    // Le mandamos un parametro tipo Object, porque puede recibir cualquier objeto
    // Un objeto de una clase puede ser un objeto.
    public static void Escribir(Object object) {
        try {
            // Creamos un archivo, entre comillas va la ruta donde queremos almacenar el archivo
            // SE RECOMIENDA UTILIZAR RUTAS RELATIVAS PARA ESTE CASO.
            oos = new ObjectOutputStream(new FileOutputStream("Personas.bin"));
            // Utilizamos el metodo writeObject, para convertir el objeto serializable en parte del archivo
            oos.writeObject(object);
            // Cerramos el archivo para que se efectuen los cambios
            oos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    // ABRIR UN ARCHIVO SERIALIZADO
    /*
        Mas que abrirlo, tenemos que interpretar la informacion del archivo binario, por lo tanto hacemos
        una lectura del archivo "ya creado", si el archivo no se ha creado, de nada sirve hacer una lectura
    */
    public static Object Cargar() {
        // Creamos un objeto Object, porque podemos recuperar cualquier cosa del archivo binario
        Object object;
        
        try {
            // Abrimos el archivo en la direccion que esta entre comillas
            // SE RECOMIENDA UTILIZAR LA RUTA RELATIVA
            ois = new ObjectInputStream(new FileInputStream("Personas.bin"));
            // Ahora el objeto que creamos, le asignamos el objeto que leimos del archivo
            object = ois.readObject();
            // Retornamos el objeto serializado ya interpreado por el lector de la libreria
            return object;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Si no existiera el objeto, le vamos a retornar un null, es decir que no existe un archivo
        // por lo tanto, no hay un registro guardado anteriormente
        return null;
    }
    
    
}
