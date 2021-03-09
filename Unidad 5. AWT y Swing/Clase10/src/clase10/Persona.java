package clase10;

public class Persona {

    private String codigo;
    private String nombre;
    private int edad;
    private double tamaño;

    public Persona(String codigo, String nombre, int edad, double tamaño) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.tamaño = tamaño;
    }

    public void Presentarme(){
        System.out.println("-------------------------------");
        System.out.println("Hola, me llamo: " + nombre);
        System.out.println("Mi codigo es: " + codigo);
        System.out.println("-------------------------------");
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

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
