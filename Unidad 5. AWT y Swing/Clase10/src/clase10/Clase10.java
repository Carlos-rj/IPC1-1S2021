package clase10;


import javax.swing.JButton;
import javax.swing.UIManager;


public class Clase10 {
    // ARREGLOS PARA ALMACENAR LA INFORMACION
    static Persona[] personas = new Persona[50];
    static int cPersonas = 0;
    
    public static void main(String[] args) {
        /* AGREGANDO UN LOOK AND FEEL (LAF)
            El mirar y sentir es el que nos permite agregar una Skin a nuestro programa, de manera sencilla podemos cambiar
            toda nuestra interfaz con una simple linea de codigo.
        
            Los LAFs que estan por defectos los puede encontrar en la presentacion y en el README, pero si tenemos el tiempo suficiente
            podemos buscar una libreria que incluya LAFs y seria de importarla como en este caso que importamos la libreria jtattoo
        
            jtattoo tiene sus propios LAF y solo es de saber como "Agregarlos"
        */
        try{
            // COMANDO PARA AGREGAR UN LOOK AND FEEL
            // Debemos de agregar en comillas lo que pondriamos en el import y siempre acompañado de un try-catch.
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            // Mi metodo Main solo hara llamada a mi Ventana.
            Ventana nueva = new Ventana();            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    // METODOS PARA MANEJAR LA INFORMACION DE LA PERSONA
    public static void AgregarPersona(Persona persona){
        if(cPersonas < personas.length){
            personas[cPersonas] = persona;
            cPersonas++;
        }else{
            System.out.println("Ya llegaste al limite de Personas");
        }
    }
    
    public static void LeerPersonas(){
        for (int i = 0; i < cPersonas; i++) {
            personas[i].Presentarme();
        }
    }
    
    // METODO PARA BUSCAR UNA PERSONA POR SU CODIGO
    public static void LeerPersona(String Codigo){
        for (int i = 0; i < cPersonas; i++) {
            if(personas[i].getCodigo().equals(Codigo)){
                personas[i].Presentarme();    
                return;
            }
        }
        System.out.println("No se encontro el nombre");
    }
    
    /* MODIFICAR DEL CONVERTIR DATOS
        En este caso, queremos agregar componentes a nuestra tabla, es posible pero tenemos que tener claro
        que todo lo que agrega a un arreglo de Object[][] es considerado como un Objeto, es decir
        JButton puede ser considerado como un Object pero un Object no es considerado como JButton, a menos que se haga un casteo
    */
    public static Object[][] convertirDatos(){
        int filas = cPersonas;
        Object[][] arreglo = new Object[filas][5];
        for (int i = 0; i < filas; i++) {
            arreglo[i][0] = personas[i].getCodigo();
            arreglo[i][1] = personas[i].getNombre();
            arreglo[i][2] = personas[i].getEdad();
            arreglo[i][3] = personas[i].getTamaño();
            // CREAMOS EL BOTON QUE VAMOS A AGREGAR EN NUESTRA TABLA
            JButton nuevo = new JButton("Ver mas");
            // HACK: Le asignaremos el nombre del boton el identificador unico, para hacer referencia a nuestro identificador del objeto
            nuevo.setName(personas[i].getCodigo());
            arreglo[i][4] = nuevo;
        }
        return arreglo;
    }
}
