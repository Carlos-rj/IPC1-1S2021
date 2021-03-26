package clase11;

public class Clase11 {
    
    public static void main(String[] args) {
        /* OBJETOS QUE HEREDAN DE UN HILO
        Podemos crear un objeto que tenga todas las propiedades de un hilo, usamos el hilo para
        correr diferentes procesos.
        
        Creamos dos objetos diferentes para mostrar la diferencia de cada uno de los objetos, el cambio mas
        notable es el intervalo con el que manejaremos el hilo, ver la clase Cronometro para entender mejor
        */
        Cronometro c1 = new Cronometro("C1",100);
        Cronometro c2 = new Cronometro("C2",500);
        
        // NOTA: Llamar siempre el metodo start, para que se sincronice con la ejecucion del proyecto.
        c1.start();
        c2.start();
        Ventana nueva = new Ventana();
        nueva.setVisible(true);
    }
    
}
