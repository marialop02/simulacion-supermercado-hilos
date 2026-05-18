import java.util.List;

public class Cajera extends Thread {
    private String nombre;
    private List<Cliente> clientesAsignados; // Fila de clientes asignados a esta caja
    private long initialTime; // Tiempo de referencia para medir el reloj global

    public Cajera(String nombre, List<Cliente> clientesAsignados, long initialTime) {
        this.nombre = nombre;
        this.clientesAsignados = clientesAsignados;
        this.initialTime = initialTime;
    }

    // El método run() se ejecuta automáticamente cuando el hilo arranca
    @Override
    public void run() {
        // El requerimiento exige procesar cliente a cliente secuencialmente en su fila
        for (Cliente cliente : clientesAsignados) {
            this.procesarCompra(cliente);
        }
    }

    private void procesarCompra(Cliente cliente) {
        long tiempoInicio = (System.currentTimeMillis() - this.initialTime) / 1000;
        System.out.println("-> La cajera " + this.nombre + " COMIENZA A PROCESAR al cliente " 
                + cliente.getNombre() + " en el segundo: " + tiempoInicio);

        double costoTotalCliente = 0;

        // Recorrer los productos del cliente uno a uno
        for (Producto producto : cliente.getCarroCompras()) {
            // Simulamos que registrar el producto toma tiempo deteniendo el hilo
            this.esperarXSegundos(producto.getTiempoProcesamiento());
            
            costoTotalCliente += producto.getCosto();

            long tiempoActual = (System.currentTimeMillis() - this.initialTime) / 1000;
            System.out.println("[" + this.nombre + "] Producto: " + producto.getNombre() 
                    + " | Costo: $" + producto.getCosto() 
                    + " | Tiempo de procesamiento: " + producto.getTiempoProcesamiento() + " seg"
                    + " | Reloj global: " + tiempoActual + " seg");
        }

        long tiempoFin = (System.currentTimeMillis() - this.initialTime) / 1000;
        System.out.println("=> La cajera " + this.nombre + " HA TERMINADO con " 
                + cliente.getNombre() + ". Total: $" + costoTotalCliente 
                + " | Completado en el segundo: " + tiempoFin + "\n");
    }

    // Función auxiliar para pausar la cajera simulando el escaneo del artículo
    private void esperarXSegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000); // Thread.sleep funciona en milisegundos
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}