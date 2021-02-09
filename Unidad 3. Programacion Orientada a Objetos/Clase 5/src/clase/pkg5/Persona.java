package clase.pkg5;

// Para declarar una clase, se utiliza el public class Persona
// NOTA: Estas no poseen un metodo main.

public class Persona {
    // Cada clase tiene atributos y acciones
    // NOTA: Atributos -> Variables
    // NOTA: Acciones -> Metodos y/o funciones
    
    /* DECLARANDO LOS ATRIBUTOS
        No es mas que declarar variables para que cada objeto pueda utilizar estos atributos
        Todas las variables que declaremos aqui, seran parte del objeto que inicialicemos mas 
        adelante.
    */
    
    /* ENCAPSULAMINETO
        Segun la teoria, sabemos que estos tipos de datos no deben de ser accedidos por
        otra clase que no sea la actual, por lo tanto se declaran como private.
    
        Para que NetBeans realice el encapsulamiento automaticamente, vamos a seleccionar
        nuestras variables.
    
        Click izquierdo -> Refactor -> Encapsulate Fields
    
        Esto nos hara el encapsulado de manera automatica y generara los metodos
        necesarios para acceder a la informacion por medio de metodos.
    */
    private String nombre;
    private int edad;
    private double tamaño;
    
    // ESTOS METODOS FUERON GENERADOS AUTOMATICAMENTE POR EL ENCAPSULATE FIELDS
    // NOTA: Los metodos GET sirven para obtener el valor de la variable.
    // NOTA: Los metodos SET sirven para almacenar un valor en la variable.
    
    // Por ejemplo, getNombre -> Nos retorna el valor de nombre
    public String getNombre() {
        return nombre;
    }

    // Por ejemplo, setNombre(variable) -> Almacena el valor de variable en la variable nombre
    public void setNombre(String nombre) {
        /* ¿Porque utilizamos this?
            Porque hay dos variables que se llaman igual, el nombre global
            y el nombre que se manda como parametro, el this hace referencia
            a la clase actual, es decir al entorno global.
        
            Si queremos acceder a la variable global usamos this.variable
            Si queremos acceder a la variable local usamos variable
        */
        this.nombre = nombre;
    }

    // ESTOS METODOS TRABAJARAN IGUAL QUE EL ANTERIOR
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

    /* METODOS GENERADOS
        Como bien dijimos, un objeto puede realizar un metodo
        y podemos declarar n metodos, pero el comportamiento varia segun
        los valores de sus variables, en este caso tenemos un metodo de
        Saludar, el cual nos dice el nombre del objeto.
    
        Regresar a la Clase5.
    */
    public void Saludar(){
        //String nombre;
        System.out.println("Hola, mi nombre es: " + nombre);
    }
    
    // Creamos un metodo para mostrar los datos del objeto
    public void MostrarDatos(){
        System.out.println("DATOS DEL OBJETO");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + tamaño);
    }
    
}
