package clase9;
/*
    CLASE PRINCIPAL DONDE VOY A MANEJAR MIS ARREGLOS Y LOS METODOS PARA ACCEDER A ESTA INFORMACION
*/

public class Clase9 {
    // ARREGLOS PARA ALMACENAR LA INFORMACION
    // Mi arreglo tipo objeto y mi confiable contador
    static Persona[] personas = new Persona[10];
    static int cPersonas = 0;
    
    public static void main(String[] args) {
        // Mi metodo Main solo hara llamada a mi Ventana.
        Ventana nueva = new Ventana();
    }
    
    
    // METODOS PARA MANEJAR LA INFORMACION DE LOS ARREGLOS
    /*
        El objetivo es que estos metodos realicen todo lo necesario para que mis otras
        ventanas solo haga el llamado de estos metodos.
    */
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
    
    // METODO PARA CONVERTIR MI ARREGLO DE OBJETOS A UN OBJECT[][]
    public static Object[][] convertirDatos(){
        // Lo mas importante es identificar cuantos datos tengo, para eso usamos el contador
        // Y cuantas columnas vamos a almacenar, en este caso seran las columnas que queremos visualizar en la tabla
        int filas = cPersonas;
        Object[][] arreglo = new Object[filas][3];
        // Con un simple for, podemos crear el objeto y declararle los valores que necesitamos
        for (int i = 0; i < filas; i++) {
            arreglo[i][0] = personas[i].getNombre();
            arreglo[i][1] = personas[i].getEdad();
            arreglo[i][2] = personas[i].getTamaño();
        }
        // Por ultimoo, retornamos el Object[][]
        return arreglo;
    }
}
