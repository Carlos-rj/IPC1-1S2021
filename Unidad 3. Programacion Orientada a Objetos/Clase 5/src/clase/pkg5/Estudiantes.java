package clase.pkg5;

// Resulta que tenemos un objeto que tiene los mismos atributos que otro
// Por lo tanto es valido usar la herencia.

// Para utilizar la herencia solo agregamos la palabra reservada extends NombreClase
public class Estudiantes extends Persona {
    
    // Declaramos los atributos que queremos de esta clase
    private int carnet;
    private String carrera;
    
    // Pero como es una clase heredada, tambien obtenemos los valores de la clase heredada
    // En este caso, la clase Estudiantes tambien poseen los atributos de Persona
    // Pero no se ven en el codigo, por concepto sabemos que exite.

    
    // EL ENCAPSULAMIENTO:
    // Click derecho en las variables -> Refactor -> Encapsulate Fields
    
    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    // Esta clase tiene sus propios metodos, es decir que si creamos un objeto de esta clase
    // Obtendra los metodos declarados en esta clase y los declarados en su clase heredad
    
    // Pero la clase heredada no puede acceder a estos metodos, ya que no son lo mismo.
    
    
    // SI QUEREMOS ACCEDER A LOS ATRIBUTOS DE LA CLASE HEREDADA, TENEMOS QUE USAR LOS METODOS ENCAPSULADOS
    // YA QUE LOS ATRIBUTOS SOLO SON ACCEDIDOS POR SU CLASE
    
    // PARA ESO UTILIZAMOS EL METODO GET.
    // El nombre no es parte de la clase estudiante, pero si de la clase persona, por lo tanto
    // usamos getNombre()
    public void DecirCarrera() {
        System.out.println("Hola mi nombre es: " + getNombre() + " y estudio: " + carrera);
    }
    
}
