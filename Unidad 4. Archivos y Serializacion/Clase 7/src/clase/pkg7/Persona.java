package clase.pkg7;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre;
    private int edad;
    private Carro[] carros;
    private int contador;
    
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.carros = new Carro[5];
        this.contador = 0;
    }
    
    public void MostrarDatos(){
        System.out.println("Hola, me llamo " + nombre);
        System.out.println("Tengo " + contador + " carros.");
        for (int i = 0; i < contador; i++) {
            System.out.println("Tengo un carro marca: " + carros[i].getMarca());
            System.out.println("El numero de placa es: " + carros[i].getPlaca());   
            System.out.println("----------------------------------------------");
        }
    }

    public void AsignarCarro(Carro carro){
        if(contador < carros.length){
            this.carros[contador] = carro;
            contador++;            
        }else{
            System.out.println("Has llegado al limite de carros");
        }
    }
         
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
