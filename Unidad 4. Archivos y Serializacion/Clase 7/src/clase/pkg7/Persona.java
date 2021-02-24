package clase.pkg7;

import java.io.Serializable;

// PASO IMPORTANTE PARA LA SERIALIZACION
// Debemos de implementar la interfaz Serializable, si no nos va dar error como en el laboratorio

// Para implementar una interefaz usamos la palabra implements seguidos del nombre de la interfaz
// en este caso la interfaz es Serializable (Mas adelante se explicara mas a detalle esto)

// Con estos pequeños cambios, nuestro objeto puede pasar a ser un objeto binario con las librerias anteriormente mencionadas
public class Persona implements Serializable {
    // En este caso, vamos a trabajar con una persona que puede tener 5 carros a su nombre
    private String nombre;
    private int edad;
    
    // Entonces creamos nuestra clase "Carro" y en los atributos de la persona, lo agregamos como un arreglo
    private Carro[] carros;
    // Se recomienda llevar un contador, para tener un mejor manejo de estos datos
    private int contador;
    
    // Para este punto, todas los objetos declarados de esta clase, es decir todas las personas
    // pueden tener un arreglo de carros.
    
    // METODO CONSTRUCTOR
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        // Se recomienda que en el constructor se inicialicen estos valores es decir, darle un tamaño al arreglo
        // Como sabemos que la persona puede tener 5 carros unicamente, entonces lo vamos a guardar asi
        this.carros = new Carro[5];
        
        // Y el contador empieza en 0, pues es el momento donde se esta creando el objeto
        this.contador = 0;
    }
    
    // COMO ESTAMOS MANEJANDO UN ARREGLO DE OBJETOS DEBEMOS DE HACER METODOS PARA EL MANEJO DE ESTA INFORMACION

    // GUARDAR UN CARRO AL OBJETO DE CARROS
    public void AsignarCarro(Carro carro){
        // Este metodo recibe un objeto del tipo Carro, por que es lo que vamos a almacenar en nuestro arreglo
        
        // En este caso, vamos de la mano con el contador, si el contador es menor a la cantida de carros a guardar
        // Si podemos almacenar ese valor, de lo contrario, deberia de mostrar un error
        if(contador < carros.length){
            // Vamos a lo mismo, el contador es nuestro indice clave y en esa posicion vamos a almacenar el objeto que mandamos
            // como parametro
            this.carros[contador] = carro;
            // Para que el flujo siga correctamente, debemos aumentar el contador por cada dato guardado
            contador++;            
        }else{
            System.out.println("Has llegado al limite de carros");
        }
    }

    // MOSTRAR LOS DATOS DE MI OBJETO
    public void MostrarDatos(){
        // En este caso, estamos mostrando la informacion necesaria del objeto
        // podemos acceder a la informacion de la persona y de su arreglo de Carros por medio de un recorrido
        System.out.println("Hola, me llamo " + nombre);
        System.out.println("Tengo " + contador + " carros.");
        for (int i = 0; i < contador; i++) {
            System.out.println("Tengo un carro marca: " + carros[i].getMarca());
            System.out.println("El numero de placa es: " + carros[i].getPlaca());   
            System.out.println("----------------------------------------------");
        }
    }

    // METODOS QUE VIENEN DEL ENCAPSULAMIENTO
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    
}
