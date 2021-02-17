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
    private Clase[] cursos;
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
    public Persona(String nombre, int CUI, char sexo, int edad, boolean estado) {
        this.nombre = nombre;
        this.CUI = CUI;
        this.sexo = sexo;
        this.edad = edad;
        this.estado = estado;
        this.cursos = new Clase[5];
        this.contador_cursos = 0;
        System.out.println("TERMINAMOS DE INSTANCIAR EL OBJETO");
    }
          
    public void MostrarDatos(){
        System.out.println("Hola");
        System.out.println("Mi nombre es: " + nombre);
        System.out.println("Mi edad es: " + edad);
        if(estado == true){
            System.out.println("Hoy me siento vivito y coleando");
        }else{
            System.out.println("Que perras ganas de morir xd");
        }
    }
    
    public void AsignarCurso(String nombre, int codigo){
        if(contador_cursos < cursos.length){
            Clase curso = new Clase(nombre, codigo);
            cursos[contador_cursos] = curso;
            contador_cursos++;            
        }else{
            System.out.println("Llegaste al limite de cursos");
        }
    }
    
    public void MostrarCursos(){
        for (int i = 0; i < cursos.length; i++) {
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
    */
    // GET -> Obtener el valor del dato.
    // SET -> Almacenar un valor en el dato.
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
