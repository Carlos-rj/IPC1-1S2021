package clase9;

/*
    Mi clase Persona que unicamente me sirve para recolectar la informacion del archivo JSON
    Recordando atajos de NetBeans:
    - CTRL + BARRA = Escribir el Constructor
    - CTRL + ALT + SHIFT + E = Encapsulamiento
*/


public class Persona {
    // ATRIBUTOS
    private String nombre;
    private int edad;
    private double tamaño;

    // CONSTRUCTOR
    public Persona(String nombre, int edad, double tamaño) {
        this.nombre = nombre;
        this.edad = edad;
        this.tamaño = tamaño;
    }

    // MOSTRAR INFORMACION
    public void Presentarme(){
        System.out.println("---------------------------");
        System.out.println("Hola, me llamo: " + nombre);
        System.out.println("Tengo: " + edad + " años.");
        System.out.println("Mido: " + tamaño + " mt");
        System.out.println("---------------------------");
    }
    
    // METODOS DE ENCAPSULAMIENTO
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }
    
    
}
