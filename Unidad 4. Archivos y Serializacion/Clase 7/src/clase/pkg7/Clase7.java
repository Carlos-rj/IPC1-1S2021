package clase.pkg7;

// IMPORTAMOS LAS LIBRERIAS
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Clase7 {
    static ObjectInputStream ois;
    static ObjectOutputStream oos;
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
    
    
    public static void Serializar(){
        personas = (Persona[]) Cargar();
        if(personas == null){
            System.out.println("No se ha creado el archivo");
            personas = new Persona[10];
        }
        System.out.println(personas[0].getNombre());
        
        personas[0] = new Persona("Carlos",22);
        Escribir(personas);
    }
    
    public static void Escribir(Object object) {
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Personas.bin"));
            oos.writeObject(object);
            oos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Object Cargar() {
        Object object;
        
        try {
            ois = new ObjectInputStream(new FileInputStream("Personas.bin"));
            object = ois.readObject();
            return object;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    
    
}
