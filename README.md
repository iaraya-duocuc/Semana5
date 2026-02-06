# Sincronizando procesos en sistemas concurrentes

Proyecto Java que simula la coordinación de entregas en una empresa de delivery llamada **SpeedFast**, incorporando **programación concurrente** y **mecanismos de sincronización** para el acceso seguro a recursos compartidos.

---

## Características del sistema

* Los pedidos ingresan a una **zona de carga compartida**.
* Varios repartidores trabajan de forma concurrente.
* Cada pedido tiene un **estado controlado** durante su ciclo de vida:
    * `PENDIENTE`
    * `EN_REPARTO`
    * `ENTREGADO`
* El acceso a la zona de carga está **sincronizado** para evitar interferencias.
* Cada repartidor simula el tiempo de entrega utilizando hilos.

---

## Conceptos aplicados

* Programación concurrente en Java
* Uso de `Runnable` y `ExecutorService`
* Métodos sincronizados (`synchronized`)
* Control de condiciones de carrera
* Enumeraciones (`enum`) para estados
* Diseño orientado a objetos

---

## Estructura del proyecto

```
config   -> configuraciones y enums del sistema
model    -> lógica de negocio y concurrencia
ui       -> clase Main y ejecución del programa
```

---

## Ejecución del proyecto

1. Clonar o descargar el proyecto.
2. Abrirlo en un IDE compatible con Java.
3. Ejecutar la clase `Main.java`.

