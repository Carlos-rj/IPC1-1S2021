package clase.pkg5;

public class Clase5 {

    public static void main(String[] args) {
    // CASTEO Y PARSEO
        /*Casteo implicito
            Nos referimos a un casteo implicito cuando un tipo
            de dato se puede guardar en otro tipo de dato mas grande
            y no hay necesidad de hacer una conversion.
            
            Usando los tipos de datos mas comunes tendriamos
            char -> int -> float -> double
        */
        int valor1 = 10;
        char letra = 'A';
        int valor_ascii = letra;
        System.out.println("Caracter: " + letra);
        System.out.println("Valor ascii: " + valor_ascii);
        double valor2 = valor1;
        System.out.println("Valor double: " + valor2);

        /* Casteo explicito
            En este caso es cuando queremos guardar un tipo de dato
            que no cabe dentro de la variable objetivo, esta puede ocasionar
            perdida de datos y si es necesasrio hacer la conversion.
        
            Para hacer la conversion unicamente usamos entre
            parentesis el tipo de dato que queremos usar.
        */
        double valor3 = 50.75;
        int valor4 = (int) valor3;
        char ascii = (char) valor3;
        System.out.println("Valor del double en int: " + valor4);
        System.out.println("Valor del ascci del double: " + ascii);
        
        /* PARSEOS
            Es cuando queremos guardar valores de cadenas en un tipo de dato
            primitivo, estos se utilizan para los Strings.
        
            Su sintaxis es la siguiente.
            TipoDato.parseTipDato(variable_String);
            Double.parseDouble(var);
            Integer.parseDouble(var);
            Float.parseFloat(var);
        */
        String numero = "25";
        double num = Double.parseDouble(numero);
        double division = num / 3;
        int num2 = (int) division;
        System.out.println(division);
        System.out.println(num2);

    // CREACION DE CLASES
        /*
            Para crear una clase seleccionamos el paquete en nuestro
            cuadro de la izquiera, donde visualizamos los proyectos.
            Click izquierdo -> new -> Java Class
            Con esto estamos indicando que crearemos una nueva clase.
    
            Una Clase es un "Paquete" que nos sirve para hacer una variable
            y estas variables pueden utilizar varias variables definidas en
            su clase.
    
            Ver la Clase Persona para seguir con la explicacion.
        */
        
        // DECLARANDO OBJETOS
        // Podemos decir que un Objeto se vuelve un nuevo tipo de dato
        // Y para declararlo la sintaxis es la siguiente:
        
        // NombreClase variable = new NombreClase();
        
        // En este caso vamos a crear dos objetos diferentes
        Persona objeto = new Persona();
        Persona objeto2 = new Persona();
        
        /*
            Cada objeto es diferente, tienen la misma estructura
            pero sus valores son diferentes.
        */
        
        // PRIMER OBJETO
        // Utilizamos los metodos SET para guardar los datos
        objeto.setEdad(22);
        objeto.setNombre("Carlos Jimenez");
        objeto.setTamaño(1.78);
        
        // Como creamos un metodo para saludar, lo mandamos a llamar
        // Con el objeto creado.
        System.out.println("----------------------------");        
        objeto.Saludar();
        objeto.MostrarDatos();
        
        // SEGUNDO OBJETO
        objeto2.setEdad(24);
        objeto2.setNombre("Juan Paco");
        objeto2.setTamaño(1.70);
  
        System.out.println("----------------------------");        
        objeto2.Saludar();
        objeto2.MostrarDatos();
        
        // EN CONSOLA PODEMOS VER QUE NOS MUESTRA INFORMACION DIFERENTE
        // Porque los metodos muestran la informacion de cada objeto
        // Es decir no es lo mismo objeto que objeto2, porque tienen valores
        // distintos.
        
    // HEREDANDO CLASES
    
        /*
            Para este aspecto, necesitamos crear otra clase
            dirigirse a la clase Estudiantes para seguir con la explicacion.
        */
        
        // Una vez leida la explicacion nos damos cuenta que
        // Un objeto Estudiante tiene los atributos de un objeto Persona
        // Pero una Persona no tiene los atributos de un objeto Estudiante.
        
        // Declaramos nuestro objeto Estudiante
        Estudiantes persona = new Estudiantes();
        
        // Podemos asignar un valor a los atributos de Persona, 
        // por medio de sus metodos set. Ya que en la clase decidimos heredar esos atributos
        
                
        // ATRIBUTOS DE PERSONA EN UN ESTUDIANTE
        persona.setEdad(22);
        persona.setNombre("Carlos Jimenez");
        persona.setTamaño(1.78);
        
        // ATRIBUTOS PROPIOS DEL ESTUDIANTE
        persona.setCarnet(201504143);
        persona.setCarrera("Sistemas");
        
        
        // Y tambien podemos usar los metodos de ambas clases.
        
        // METODOS DE PERSONA
        System.out.println("-----------------------");
        System.out.println("METODOS HEREDADOS DE PERSONA");
        persona.Saludar();

        persona.MostrarDatos();
        
        
        System.out.println("-----------------------");
        System.out.println("METODO PROPIO DE ESTUDIANTE");
        // Metodos de Estudiante
        persona.DecirCarrera();  

    }
    
}
