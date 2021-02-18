package clase6;

// Importamos el Scanner de toda la vida
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    static int contador_personas = 0;
    
    // Usamos un scanner para leer numeros y otro para leer Strings.
    static Scanner sc = new Scanner(System.in);
    static Scanner lector = new Scanner(System.in);
        
    public static void main(String[] args) {
        
        CargarPersonas();
        personas = new Persona[5];
        /* MANIPULACION DE OBJETOS
            Un objeto es la instancia de una clase, es decir un objeto representa a la clase
            Y una clase puede tener muchos objetos, pero sus valores no son los mismos
        */
        
        // OBJETOS CON EL CONTRUCTOR POR DEFECTO
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
        
        // Utilizamos los metodos Set para guardar la informacion, nos damos cuenta que mandamos como parametro
        // el valor que queremos asignar en el atributo
        persona1.setNombre("Carlos");
        persona1.setEdad(22);
        persona1.setSexo('M');
        persona1.setCUI(2987);
        
        /* INTERPRETANDO DATOS
         En este ejemplo tenemos un atributo llamado estado, este estado es para saber si estamos vivos o muertos
         Si estamos vivos, se guarda True
         Si estamos moridos, se guarda False
         Pero nosotros no le preguntamos a alguien y nos dice "True" o "False"
         Entonces interpretamos su respueta
        */
        
        // PREGUNTAMOS EL ESTADO DE LA PERSONA
        System.out.print("¿Cual es tu estado actual?");
        String estado = sc.nextLine();
        // Recordemos, si la respuesta es Morido -> entonces guardamos false
        // si la respuesta no es Morido -> entonces guardamos true.
        if(estado.equals("Morido")){
            persona1.setEstado(false);
        }else{
            persona1.setEstado(true);
        }
        // NOTA: Las cadenas no se comparan con ==, tienen su propio metodo para comparar texto
        // El metodo utilizado es variable.equals(variable) si son iguales devuelve true
        
        // PARA ESTE PUNTO TENEMOS UNA PERSONA CON LOS DATOS ASIGNADOS ANTERIORMENTE
        // Y en la clase Persona hicimos un metodo que nos muestre su informacion
        // entonces el objeto manda a llamar ese metodo
        persona1.MostrarDatos();
        System.out.println("------------------------");
        

        // OBJETOS CON UN CONSTRUCTOR GENERADO
        /*
            Este constructor es "Especial" ya que nosotros lo creamos y nosotros decimos que valores tendra y como se comportara
            ver la explicacion en la clase Persona.
        */
        
        // Se recomienda utilizar este constructor cuando ya sabemos que el flujo del programa nos dara los datos del objeto
        // Para que cuando lo creemos, le asignemos sus valores desde un inicio
        
        // En este caso, creamos a la persona2 con los datos que le mandamos por parametros y lo que hace es llamar al metodo constructor
        // generado con la cantidad de parametros
        
        // NOTA: Podemos hacer varios de estos constructores, depende de la cantidad de dato que querramos guardar, todo depende del programador.
        Persona persona2 = new Persona("Paco",9497,'M',21,true);
        
        // persona2 tambien puede usar MostrarDatos, porque es un metodo de la clase, pero los valores son distintos para cada objeto
        // Y con esto tenemos el manejode Objetos en individual.
        persona2.MostrarDatos();
        
        
        // ARREGLOS DE OBJETOS
        /*
            Esta situacion se da cuando queremos almacenar cantidades grandes de este objeto, por ejemplo 100 objetos
            Entonces usamosa un arreglo de objetos para esto.
        
            Es decir que en vez de tener estas variables
                    Persona persona1;
                    Persona persona2;
                    Persona persona3;
                    ...
                    Persona persona99;
                    Persona persona100;
        
            Vamos a tener lo siguiente:
            Persona[] personas = new Personas[100];
        
            La estructura es la misma que un arreglo normal, siempre con un tamaño fijo.
        */
        
        // NOTA: NO ES LO MISMO DECLARARAR UN ARREGLO DE OBJETOS QUE UN OBJETO, ES DECIR
        // HAY QUE INICIALIZAR CADA OBJETO DEL ARREGLO
                               
        /* INICIALIZAR CON VALORES VACIOS
            Lo que podemos hacer es un recorrido que recorra cada posicion del arreglo y en esta posicion utilice
            el Constructor por defecto, para darle valores vacios.
        */
        for (int i = 0; i < personas.length; i++) {
            personas[i] = new Persona();
            // persona1 = new Persona();
            // persona2 = new Persona();
            // persona3 = new Persona();
            // persona4 = new Persona();
            // persona5 = new Persona();
        }
        
        /* NOTA IMPORTANTE:
            Se recomienda tener un contador para cada arrreglo, es decir si queremos hacer un recorrido del arreglo para obtener informacion
            vamos a recorrer desde 0 hasta contador, en vez de recorrer todo el arreglo, para evitar los valores no inicializados y que nos de error
        */
        
        // ASIGNANDO VALORES A UN ARREGLO DE OBJETOS
        for (int i = 0; i < personas.length; i++) {
            // Vamos a guardar el nombre y la edad por cada posicion, entonces usamos el codigo necesario para obtener esta informacion 
            // Y por ultimo, mandamos a inicializar el objeto
            String nombre;
            int edad;
            System.out.print("Escribe tu nombre: ");
            nombre = lector.nextLine();
            System.out.print("Escribe tu edad: ");
            edad = sc.nextInt();
            personas[i] = new Persona(nombre,1234,'M',edad,true);
        }
        // En que situaciones usar este tipo de metodos:
        /*
            Cuando estamos leyendo un archivo con n cantidad de datos, podemos hacer la lectura del archivo por filas
            Y cada fila es una posicion del arreglo, es decir, el contador y podemos mandar el constructor generado para almacenar
            su informacion
        */
        
 
        // METODOS UTILIZADOS EN UN ARREGLO DE OBJETOS
        System.out.println("MOSTRAR LOS DATOS");
        MostrarPersonas(personas);
        
        // FUNCION PARA BUSCAR UNA PERSONA
        Persona busqueda = BuscarPersona("Juana");
        // Entonces para este punto busqueda es un objeto tipo Persona
        // que ejecuto una busqueda para encontrar una persona llamada Juana
        // y segun su valor, hace el siguiente comportamiento.
        if(busqueda != null){
            busqueda.MostrarDatos();
        }else{
            System.out.println("El dato no existe");
        }

        // METODO PARA BUSCAR TODOS LOS USUARIOS DE UN ATRIBUTO
        BuscarPorNombre("Carlos");
    
    
        // MANEJAR UN ARREGLO DE OBJETOS DENTRO DE OTRO OBJETO
        /*
            Existe la posibiildad de que un objeto tenga relacion con mas objetos
            para este caso vamos a crear una clase llamada "Clase" en relacion a los cursos de la U
            y sabemos que una persona puede llevar Cursos, para este ejemplo seran un maximo de 5.
            - VER LA CLASE "CLASE"
            - VER LA CLASE "PERSONA"
        */
        
        // Para este punto, ya tenemos la estructura para guardar cursos dentro de una persona
        // Creamos la persona "Carlos" con su constructor generado
        Persona Carlos = new Persona("Carlos",1234,'M',22,true);
        // AHORA EL METODO AsignarCurso VIENE DE LA CLASE PERSONA, ES DECIR CADA PERSONA PUEDE ASIGNARSE CURSOS
        // La logica dice que este metodo recibe los datos de los cursos por agregar, en este caso
        // Nos solicita que para asignar curso, ingresemos el codigo y el nombre
        Carlos.AsignarCurso("Sistemas Operativos 2", 777);
        Carlos.AsignarCurso("IPC1", 777);
        Carlos.AsignarCurso("IPC2", 777);
        Carlos.AsignarCurso("Logica de Sistemas", 777);
        Carlos.AsignarCurso("Mate Computo", 777);
        Carlos.AsignarCurso("Mate Computo 2", 777);
        // Para este punto, Carlos ya tiene asignados sus cursos y solo mandamos a llamar el metodo de MostrarCursos
        // Recordemos que este metodo es propio de la persona, entonces cada persona tiene este metodo pero sus valores no son los mismos.
        Carlos.MostrarCursos();
    }
    
    // METODO PARA MOSTRAR TODAS LAS PERSONAS GUARDADAS
    public static void MostrarPersonas(Persona[] arreglo){
        // Para hacer estos recorridos, se recomienda que se utilice como limite el contador, asi no usamos valores
        // que no se han inicializado :)
        
        // Hacemos un recorrido que va ir viendo posicion por posicion y mandara a llamar el metodo de MostrarDatos de cada persona
        // Recordemos que cada posicion del arreglo representa un objeto distinto con valores distintos.
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i].MostrarDatos();
            System.out.println("-------------------------------");
        }
    }
    
    // AL FINAL DE CUENTAS, UN OBJETO PUEDE SER UNA VARIABLE, ENTONCES PODEMOS HACER FUNCIONES DE ESA "VARIABLE"
    public static Persona BuscarPersona(String nombre){
        // En este caso quisimos hacer un arreglo que encuentre el primer objeto con el nombre que mandemos a llamar
        // entonces hacemos un recorrido y hacemos la validacion
        for (int i = 0; i < personas.length; i++) {
            if(personas[i].getNombre().equals(nombre)){
                System.out.println("LO ENCONTRAMOS");
                // Si lo encontramos, vamos a devolver el objeto, recordemos que cada posicion del arreglo es una posicion
                return personas[i];
            }
        }
        // Y si salimos del for, es decir que no lo encontramos, retornamos un null, porque no existe
        return null;
    }
    
    // METODO PARA MOSTRAR A TODAS LAS PERSONAS QUE SE LLAMEN (nombre)
    public static void BuscarPorNombre(String nombre){
        // La logica es distinta, la funcion anterior nos retornaba un dato, en este caso queremos mostrar todos los datos
        // entonces hacemos el mismo recorrido y si el nombre coincide con el que buscamos, mostrara su informacion con el
        // metodo creado de mostrarDatos
        
        // NOTA: CADA POSICION DEL ARREGLO ES UN OBJETO DISTINTO, MISMA ESTRUCTURA, DIFERENTES VALORES
        for (int i = 0; i < personas.length; i++) {
            if(personas[i].getNombre().equals(nombre)){
                System.out.println("LO ENCONTRAMOS");
                personas[i].MostrarDatos();
                System.out.println("--------------");
            }
        }
    }

    // METODO EXTRA: COMO LEER DATOS DESDE UN CSV
    public static void CargarPersonas(){
        // Este metodo solo sirve para reforzar lo que hemos visto en la Practica 1
        // Pedimos la ruta del archivo que tenemos que leer
        String ruta;
        System.out.print("Ingresar la ruta del archivo csv a leer: ");
        ruta = lector.nextLine();
        // CODIGO PARA ABRIR UN ARCHIVO
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // OBJETOS PARA ABRIR LOS ARCHIVOS
            // Una libreria no es mas que una clase que ya esta en JAVA, entonces cuando importamos "librerias"
            // Estamos importando una clase
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // LEYENDO EL ARCHIVO
            // Hack: si el archivo tiene encabezado, utilizar un br.readLine() antes de la lectura 
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                // Aqui estamos leyendo fila por fila, entonces vamos a almacenar esa informacion en nuestro arreglo de personas
                System.out.println(linea);
                // Separando los datos por una coma
                String[] Datos = linea.split(",");
               
                // Segun la estructura del archivo, sabemos que como vienen los datos:
                // Recordemos que estos datos son string, entonces si es necesario convertimos los datos
                String nombre = Datos[0];
                int CUI = Integer.parseInt(Datos[1]);
                char Sexo = Datos[2].charAt(0);
                int edad = Integer.parseInt(Datos[3]);
                boolean estado = false;
                if(Datos[4].equals("Morido")){
                    estado = false;
                }else if(Datos[4].equals("Vivido")){
                    estado = true;
                }
                // Con nuestros datos, podemos crear un objeto de tipo Persona
                Persona nuevo = new Persona(nombre, CUI, Sexo, edad, estado);
                // Y ahora solo agregamos este objeto a nuestro arreglo
                personas[contador_personas] = nuevo;
                // Y aumentamos en uno nuestro contador
                contador_personas++;
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
        
        // UNA VEZ TERMINADO NUESTRA CARGA DE DATOS, VAMOS A VISUALIZAR LA INFORMACION
        MostrarPersonas(personas);
    }
}
