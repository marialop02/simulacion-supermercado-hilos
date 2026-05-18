import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Definir los productos disponibles en la tienda (Nombre, Precio, Tiempo en seg)
        Producto p1 = new Producto("Leche", 3500, 1);       
        Producto p2 = new Producto("Arroz 1kg", 4500, 2);   
        Producto p3 = new Producto("Aceite", 12000, 3);     
        Producto p4 = new Producto("Café", 8000, 2);        

        // 2. Crear los clientes y ponerles productos en su carrito
        Cliente carlos = new Cliente("Carlos Pérez", Arrays.asList(p1, p2, p3)); // Demora: 6 seg
        Cliente ana = new Cliente("Ana Gómez", Arrays.asList(p4, p1));        // Demora: 3 seg
        Cliente luis = new Cliente("Luis Restrepo", Arrays.asList(p3, p4));    // Demora: 5 seg
        Cliente marta = new Cliente("Marta Soler", Arrays.asList(p2, p1, p1));  // Demora: 4 seg

        // 3. Crear las filas de atención para las dos cajeras
        List<Cliente> filaInes = new ArrayList<>(Arrays.asList(carlos, ana));  
        List<Cliente> filaDora = new ArrayList<>(Arrays.asList(luis, marta));  

        // Guardar el tiempo exacto en que inicia la simulación
        long initialTime = System.currentTimeMillis();

        // 4. Instanciar los hilos de las dos cajeras
        Cajera cajera1 = new Cajera("Inés", filaInes, initialTime);
        Cajera cajera2 = new Cajera("Dora", filaDora, initialTime);

        System.out.println("=== INICIANDO SIMULACIÓN DE SUPERMERCADO ===");
        
        // Arrancamos ambos hilos simultáneamente
        cajera1.start();
        cajera2.start();

        // Forzamos al programa principal a esperar que ambas terminen para dar el tiempo global
        try {
            cajera1.join(); 
            cajera2.join(); 
        } catch (InterruptedException e) {
            System.out.println("La simulación fue interrumpida.");
        }

        // 5. Mostrar el tiempo total de cobro de toda la tienda
        long tiempoTotalGlobal = (System.currentTimeMillis() - initialTime) / 1000;
        
        System.out.println("=================================================");
        System.out.println("SIMULACIÓN COMPLETADA");
        System.out.println("Tiempo total de cobro para todas las compras: " + tiempoTotalGlobal + " segundos.");
        System.out.println("=================================================");
    }
}