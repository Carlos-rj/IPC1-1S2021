package clase.pkg7;

public class Carro {

    private String marca;
    private String color;
    private String placa;

    public Carro(String marca, String color, String placa) {
        this.marca = marca;
        this.color = color;
        this.placa = placa;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
}
