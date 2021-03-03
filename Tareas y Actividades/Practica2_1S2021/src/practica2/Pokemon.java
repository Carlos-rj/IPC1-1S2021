package practica2;

public class Pokemon {
    // ATRIBUTOS
    private int id;
    private String tipo;
    private String nombre;
    private double vida;
    private double ataque;
    private boolean capturado;
    private boolean estado;
    
    // METODO CONSTRUCTOR
    public Pokemon(int id, String tipo, String nombre, double vida, double ataque, boolean capturado, boolean estado) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.capturado = capturado;
        this.estado = estado;
    }
    
    // METODO PARA MOSTRAR MIS DATOS
    public void MostrarInfo(){
        System.out.println("-------------------------------------------------");
        System.out.println("Hola, soy un: " + nombre);
        System.out.println("Mi codigo es: " + id);
        System.out.println("Mis puntos de ataque son: " + ataque);
        System.out.println("-------------------------------------------------");
    }
    
    // ENCAPSULAMIENTO
    // GET = OBTENER DATOS
    // SET = DECLARAR DATOS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public boolean isCapturado() {
        return capturado;
    }

    /**
     * @param capturado the capturado to set
     */
    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
