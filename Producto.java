public class Producto {
    private String nombre;
    private double costo;
    private int tiempoProcesamiento; // Tiempo en segundos que toma registrarlo

    // Constructor: Define cómo se crea un producto
    public Producto(String nombre, double costo, int tiempoProcesamiento) {
        this.nombre = nombre;
        this.costo = costo;
        this.tiempoProcesamiento = tiempoProcesamiento;
    }

    // Métodos para obtener los datos del producto (Getters)
    public String getNombre() { return nombre; }
    public double getCosto() { return costo; }
    public int getTiempoProcesamiento() { return tiempoProcesamiento; }
}