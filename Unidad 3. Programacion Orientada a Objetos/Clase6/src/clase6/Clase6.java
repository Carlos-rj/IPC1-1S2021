package clase6;

// Importamos el Scanner de toda la vida
import java.util.Scanner;

/* La situacion ahora es un poco distinta, vamos a ver que nuestra clase main
   CLASE MAIN: ES LA CLASE PRINCIPAL DEL PROYECTO
   Ahora la vamos a ver como un "Objeto" situacion, es decir que este objeto es el flujo del programa
   y las variables globales, van a ser los atributos y los metodos las funciones que hace ese objeto

    POR EJEMPLO:
    Tenemos una aplicacion que maneje un grupo de personas, entonces tenemos una clase para
    manejar toda la informacion y sus metodos como "Buscar en el arreglo", "Modificar en el arreglo"
    
   Esto es cuestion de logica, pero es un ejemplo para que vayan viendo como funciona
*/
public class Clase6 {
    // En este caso, los atributos si se declaran static, por lo mismo que estamos trabajando en la clase main
    
        /*
        Expliacion del porque usamos Static (Clase anterior)
        SE DECLARA STATIC, PORQUE TODO LO STATIC SE ALMACENA PRIMERO EN MEMORIA ANTES DE EJECUTAR EL PROGRAMA
        JAVA SABE QUE EL PRIMER METODO QUE VA A CORRER ES EL METODO MAIN Y ESTE DEBE DE TENER TODAS LAS VARIABLES
        Y METODOS DECLARADOS ANTES DE CORRERLO, POR ESO USAMOS STATIC
        */
    
    // Para declarar un arreglo de objetos, utilizamos la misma estructura que un tipo de dato primitivo
    // Objeto [] nombre_variable == new Objeto[tamaño];
    static Persona[] personas = new Persona[5];
    
    // Usamos un scanner para leer numeros y otro para leer Strings.
    static Scanner sc = new Scanner(System.in);
    static Scanner lector = new Scanner(System.in);
        
    public static void main(String[] args) {
        /* MANIPULACION DE OBJETOS
            Un objeto es la instancia de una clase, es decir un objeto representa a la clase
            Y una clase puede tener muchos objetos, pero sus valores no son los mismos
        */
        
        // OBJETOS CON EL CONTRUCTOR GENERICO
        /*
            Cuando nosotros declaramos una clase, esta viene con una clase por defecto que no se "ve" pero si esta declarada
            este metodo es un Public Objeto() (Ver clase Persona)
        */
        // En este punto estamos creando una Persona, llamada persona1
        Persona persona1 = new Persona();
        // Para este punto, mandamos a llamar el metodo Persona() que esta en la clase Persona, es decir el constructor
        // Si miramos el metodo, lo unico que hizo fue decirle persona1 tus atributos son los siguientes... (ver metodo)

        // ASIGNANDO VALORES A UN OBJETO
        /*
           Luego de crear un objeto, queremos darle un valor, entonces utilizamos el Encapsulamiento para cumplir con POO
           ver la clase Persona para la explicacion.
        */
        persona1.setNombre("Carlos");
        persona1.setEdad(22);
        persona1.setSexo('M');
        persona1.setCUI(2987);
        System.out.print("¿Cual es tu estado actual?");
        String estado = sc.nextLine();
        
        // LOS STRING UTILIZAN EL METODO EQUALS PARA COMPARAR TEXTO
        if(estado.equals("Morido")){
            persona1.setEstado(false);
        }else{
            persona1.setEstado(true);
        }
        
        Persona persona2 = new Persona("Paco",9497,'M',21,true);
        
        persona1.MostrarDatos();
        System.out.println("------------------------");
        persona2.MostrarDatos();
    }
    

    
    
    public static void ArregloDentroObjeto(){
        Persona Carlos = new Persona("Carlos",1234,'M',22,true);
        Carlos.AsignarCurso("Sistemas Operativos 2", 777);
        Carlos.AsignarCurso("IPC1", 777);
        Carlos.AsignarCurso("IPC2", 777);
        Carlos.AsignarCurso("Logica de Sistemas", 777);
        Carlos.AsignarCurso("Mate Computo", 777);
        Carlos.AsignarCurso("Mate Computo 2", 777);
        Carlos.MostrarCursos();

    }
    
    public static void ArreglosDeObjetos(){
        // ARREGLOS DE OBJETOS
        /*
        Persona persona1;
        Persona persona2;
        Persona persona3;
        Persona persona4;
        Persona persona5;
        */
        
        //personas[0].setNombre("Carlos");
        
        // PRIMERO QUE HAY QUE HACER ES INICIALIZAR LOS OBJETOS DEL ARREGLO
        for (int i = 0; i < personas.length; i++) {
            personas[i] = new Persona();
            // persona1 = new Persona();
            // persona2 = new Persona();
            // persona3 = new Persona();
            // persona4 = new Persona();
            // persona5 = new Persona();
        }
        
        // CUANDO NOSOTROS YA SABEMOS LOS DATOS A ASIGNAR
        
        for (int i = 0; i < personas.length; i++) {
            String nombre;
            int edad;
            System.out.print("Escribe tu nombre: ");
            nombre = lector.nextLine();
            System.out.print("Escribe tu edad: ");
            edad = sc.nextInt();
            personas[i] = new Persona(nombre,1234,'M',edad,true);
        }
        
        
//        System.out.println("MOSTRAR LOS DATOS");
//        MostrarPersonas(personas);
        
/*        Persona busqueda = BuscarPersona("Juana");
        if(busqueda != null){
            busqueda.MostrarDatos();
        }else{
            System.out.println("El dato no existe");
        }
*/
    BuscarPorNombre("Carlos");
    }
    
    public static void BuscarPorNombre(String nombre){
        for (int i = 0; i < personas.length; i++) {
            if(personas[i].getNombre().equals(nombre)){
                System.out.println("LO ENCONTRAMOS");
                personas[i].MostrarDatos();
                System.out.println("--------------");
            }
        }
    }
    
    public static Persona BuscarPersona(String nombre){
        for (int i = 0; i < personas.length; i++) {
            if(personas[i].getNombre().equals(nombre)){
                System.out.println("LO ENCONTRAMOS");
                return personas[i];
            }
        }
        return null;
    }
    
    public static void MostrarPersonas(Persona[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i].MostrarDatos();
            System.out.println("-------------------------------");
        }
    }

}
