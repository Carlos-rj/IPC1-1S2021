package clase6;

// REPASO RAPIDO DE LA CLASE
// Encapsular = Ctrl + Alt + Shift + E
// Metodo Constructor = Ctrl + BarraEspaciadora
public class Clase {

    // ATRIBUTOS
    private String nombre;
    private int codigo;

    // METODO CONTRUCTOR GENERADO
    public Clase(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    // METODO CONSTRUCTOR POR DEFECTO
    public Clase() {
        this.nombre = "";
        this.codigo = 0;
    }
    
    // ENCAPSULAMIENTO
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
}
