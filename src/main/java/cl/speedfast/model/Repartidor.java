package cl.speedfast.model;

import cl.speedfast.config.AppConfig;

/**
 * Representa un repartidor que procesa pedidos de forma concurrente.
 */
public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    /**
     * Constructor base de un repartidor.
     */
    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {
        while (true) {
            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {
                break;
            }

            System.out.println(
                    "[Repartidor - " + nombre + "] Procesando pedido #" +
                            pedido.getId() + " (" + pedido.getEstado().obtenerNombre() + ")"
            );

            try {
                System.out.println(
                        "[Repartidor - " + nombre + "] Entregando pedido #" + pedido.getId() + "..."
                );
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            pedido.setEstado(AppConfig.EstadoPedido.ENTREGADO);
            System.out.println(
                    "[Repartidor - " + nombre + "] Estado: " + pedido.getEstado().obtenerNombre() + "."
            );
        }
    }
}
