/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author cduar
 */
public class Pedido {
    
    private int pedido_id;
    private String fecha_pedido;
    private float total;
    private int cliente_id;

    public Pedido(int pedido_id, String fecha_pedido, float total, int cliente_id) {
        this.pedido_id = pedido_id;
        this.fecha_pedido = fecha_pedido;
        this.total = total;
        this.cliente_id = cliente_id;
    }

    public Pedido(String fecha_pedido, float total, int cliente_id) {
        this.fecha_pedido = fecha_pedido;
        this.total = total;
        this.cliente_id = cliente_id;
    }
    
    

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }

    public String getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(String fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }
    
    
    
    
}
