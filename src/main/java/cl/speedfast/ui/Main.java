package cl.speedfast.ui;

import cl.speedfast.model.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Clase principal de la aplicacion.
 */
public class Main {

    /**
     * Punto de entrada del programa.
     */
    public static void main(String[] args) {

        // Crear la zona de carga compartida
        ZonaDeCarga zona = new ZonaDeCarga();

        // Crear pedidos
        zona.agregarPedido(new Pedido(1, "Av. Central 123"));
        zona.agregarPedido(new Pedido(2, "Los Pinos 456"));
        zona.agregarPedido(new Pedido(3, "Calle Sur 789"));
        zona.agregarPedido(new Pedido(4, "Av. Norte 321"));
        zona.agregarPedido(new Pedido(5, "Camino Real 654"));
        zona.agregarPedido(new Pedido(6, "Ruta 5 111"));

        Repartidor r1 = new Repartidor("Luis Perales", zona);
        Repartidor r2 = new Repartidor("Daniela Tapia", zona);
        Repartidor r3 = new Repartidor("Pedro Soto", zona);

        // Ejecutar repartidores (hilos) en paralelo
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);

        // Cerrar el executor y esperar finalización
        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
            System.out.println("Todos los pedidos han sido entregados correctamente.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Ejecución interrumpida.");
        }

    }
}
