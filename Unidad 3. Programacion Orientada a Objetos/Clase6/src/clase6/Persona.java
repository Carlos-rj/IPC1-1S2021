package clase6;

// ESTO ES UNA CLASE :)
public class Persona {
    // La clase tiene atributos, los atributos son tomados como las variables
    // Los atributos son las caracteristicas de un objeto, en este caso estamos tomando los datos generales
    // de una persona

    // ATRIBUTOS GENERALES
    private String nombre;
    private int CUI;
    private char sexo;
    private int edad;
    private boolean estado; 

    // ARREGLO DE OBJETOS DENTRO DE UN OBJETO
    // Creamos un arreglo de objetos, mas no lo inicializamos, hasta que se haga en el constructor
    private Clase[] cursos;
    // El contador que nos ayuda a saber cuantos datos se van llenando de ese arreglo
    private int contador_cursos;
    
    /* METODO CONSTRUCTOR POR DEFECTO
        Pasa que si nosotros no hemos utilizado un Constructor Generado, tenemos el que es por defecto
        el fin de este metodo es darle un valor inicial a los atributos del objeto
    */
    
    // La estructura del constructor es la siguiente:
    // public nombreObjeto() 
    public Persona(){
        // En este caso nos toco declararlo porque estamos trabajando con un metodo constructor
        // generado tambien, pero es decision del estudiante como quiera manejarlo
        // Por fines explicativos se crearon los dos.
        nombre = "";
        CUI = 0;
        sexo = 0;
        edad = 0;
        estado = false;
    }
    
    /* CONCLUSION: 
    Este es el metodo que se va a ejecutar cuando hagamos la instancia de una clase
    es decir, cuando creemos un objeto de esta clase, podemos agregar el codigo que querramos
    y este se va a ejecutar igual, pero se recomienda que solo se le de un valor inicial a los valores
    Regresar a la clase Main para seguir con la explicacion.
    */
    
    
    // METODO CONSTRUCTOR GENERADO
    /*
        A diferencia del metodo generico, este metodo constructor generado es para asignarle valores
        especificos sin usar los metodos Set, si no que cuando se cree el objeto, inicialmente sus valores
        seran los que les mandemos por medio de los parametros
    */
    
    // HACK: para hacer este metodo constructor podemos utilizar la siguiente combinacion de teclas
    // Ctrl + Tab y nos despliega el metodo con todo y los atributos actuales
    public Persona(String nombre, int CUI, char sexo, int edad, boolean estado) {
        // Entonces a diferencia del metodo anterior, este metodo pide parametros y asigna valores automaticamente
        // Y cuando creemos un objeto, este objeto tendra por valor inicial los datos mandados por los parametros
        this.nombre = nombre;
        this.CUI = CUI;
        this.sexo = sexo;
        this.edad = edad;
        this.estado = estado;
        // Pero recordemos que este sigue siendo un metodo cualquiera, es decir que nosotros llamamos este metodo cuandi
        // se inicializa la clase y el codigo de aqui adentro se va a ejecutar siempre.
        
        // Para este punto, queremos que cada persona tenga un arreglo que pueda guardar clases y que su limite sea 5
        // Como lo estamos creando, sabemos que su contador empieza en 0, entonces ahora cada objeto que creemos
        // Tendra estos atributos
        this.cursos = new Clase[5];
        this.contador_cursos = 0;
        System.out.println("TERMINAMOS DE INSTANCIAR EL OBJETO");
    }
          
    
    // METODO PARA MOSTRAR MIS DATOS
    public void MostrarDatos(){
        /* Es un metodo propio de las personas, y es para presentarnos
           Pero cabe destacar que sus valores son distintos por cada objeto, es decir
           No es lo mismo que persona1 llame a MostrarDatos que persona2 porque
           tienen los mismos atributos, pero no los mismos valores
        */
        System.out.println("Hola");
        System.out.println("Mi nombre es: " + nombre);
        System.out.println("Mi edad es: " + edad);
        
        // En este metodo tambien modificamos la respuesta segun el estado de la Persona
        if(estado == true){
            System.out.println("Hoy me siento vivito y coleando");
        }else{
            System.out.println("Que perras ganas de morir xd");
        }
    }
    
    
    // CUMPLIENDO CON POO, NOSOTROS MANEJAMOS ESTE ARREGLO UNICAMENTE POR METODOS Y FUNCIONES
    // Vamos a hacer un metodo que cree un objeto Clase y este objeto lo almacene en el arreglo de cada persona
    public void AsignarCurso(String nombre, int codigo){
        // Le mandamos como parametros los datos necesarios
        
        // IMPORTANTE, el contador siempre debe de ser menor del tamaño del arreglo
        // Si no es menor, significa que ya llegamos al limite de los cursos
        if(contador_cursos < cursos.length){
            // En este caso creamos un objeto Clase y esta Clase la agregamos a nuestro arreglo de Cursos
            // No nos da error, porque el objeto lo estamos inicializando antes de almacenarlo en la posicion
            Clase curso = new Clase(nombre, codigo);
            cursos[contador_cursos] = curso;
            
            // Aumentamos su contador, para llevar un "manejo" de la informacion
            contador_cursos++;            
        }else{
            System.out.println("Llegaste al limite de cursos");
        }
    }
    
    public void MostrarCursos(){
        // Como queremos mostrar "Informacion" se recomienda que usemos como limite el contador
        // Y asi no tocamos posiciones del arreglo que no han sido inicializadas
        for (int i = 0; i < contador_cursos; i++) {
            System.out.println("Curso numero: " + i);
            System.out.println("Nombre del Curso: " + cursos[i].getNombre());
            System.out.println("Codigo del Curso: " + cursos[i].getCodigo());
            System.out.println("-------------------------------------------");
        }
    }
    
    
    
    // ENCAPSULAMIENTO DE DATOS
    /*
        Como se indico anteriormente, una de las reglas de POO es que se acceda a la informacion
        del objeto unicamente por metodos y funciones, unos tips para hacer el encapsulamiento son:
        - Seleccionamos los atributos, Click derecho -> Refactor -> Encapsulate Fields
        - Ctrl + Alt + Shift + E en los atributos
    
        Estas dos acciones nos abren un cuadro de texto, seleccionamos los atributos que queremos encapsular
        y seleccionamos refactor
    */
    
    // Luego de encapsultar, vamos a tener varios metodos y funciones generados por NetBeans
    // Son los metodos Get y Set de cada atributo, para un manejo mas simple de esto es
        // GET -> Obtener el valor del dato.
        // SET -> Almacenar un valor en el dato.
        // IS -> Obtener el valor de un Booleano.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCUI() {
        return CUI;
    }

    public void setCUI(int CUI) {
        this.CUI = CUI;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
