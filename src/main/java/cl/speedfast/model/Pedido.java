package cl.speedfast.model;

import cl.speedfast.config.AppConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un pedido dentro del sistema.
 */
public class Pedido{

    private int id;
    private String direccionEntrega;
    private AppConfig.EstadoPedido estado;

    /**
     * Constructor base de un pedido.
     */
    public Pedido(int id, String direccionEntrega) {
        this.id = id;
        this.direccionEntrega = direccionEntrega;
        this.estado = AppConfig.EstadoPedido.PENDIENTE;
    }

    // Getters
    public int getId() { return id; }
    public String getDireccion() { return direccionEntrega; }
    public AppConfig.EstadoPedido getEstado() { return estado; }

    // Setters
    public void setEstado(AppConfig.EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", direccionEntrega='" + direccionEntrega + '\'' +
                ", estado=" + estado.obtenerNombre() +
                '}';
    }

}
