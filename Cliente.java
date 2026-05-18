import java.util.List;

public class Cliente {
    private String nombre;
    private List<Producto> carroCompras; // Lista con sus productos

    // Constructor: Define cómo se crea un cliente
    public Cliente(String nombre, List<Producto> carroCompras) {
        this.nombre = nombre;
        this.carroCompras = carroCompras;
    }

    // Métodos Getters
    public String getNombre() { return nombre; }
    public List<Producto> getCarroCompras() { return carroCompras; }
}