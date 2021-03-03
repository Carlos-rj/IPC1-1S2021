package clase8;
// CLASE USUARIO QUE SOLO SIRVE PARA ALMACENAR LA INFORMACION
public class Usuarios {

    private String usuario;
    private String password;
    private String nombre;

    // METODO CONSTRUCTOR
    public Usuarios(String usuario, String password, String nombre) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
    }

    // METODO PARA MOSTRAR LA INFORMACION DEL USUARIO
    public void MostrarInfo(){
        System.out.println("Hola, mi nombre es: " + nombre);
        System.out.println("Mi user es: " + usuario);
        System.out.println("Mi pass es: " + password);
    }

    // ENCAPSULAMIENTO
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
