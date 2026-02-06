package cl.speedfast.model;

import cl.speedfast.config.AppConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la zona de carga.
 */
public class ZonaDeCarga {

    /**
     * Constructor por defecto de una zona de carga.
     */
    public ZonaDeCarga() {
        System.out.println("[Zona de carga inicializada]");
    }

    private final List<Pedido> pedidos = new ArrayList<>();

    public synchronized void agregarPedido(Pedido p) {
        pedidos.add(p);
        System.out.println(
                "Pedido #" + p.getId() +
                        " agregado. Destino: " + p.getDireccion()
        );
    }

    public synchronized Pedido retirarPedido() {
        if (pedidos.isEmpty()) {
            return null;
        }

        Pedido pedido = pedidos.remove(0);
        pedido.setEstado(AppConfig.EstadoPedido.EN_REPARTO);

        return pedido;

    }
}
