/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Pedido;
import Servicios.ServiceClientes;
import Servicios.ServicePedidos;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cduar
 */
public class ControladorVentanaPedidoRegistro {
    
    public  Pedido buscarPedido (int pedido_id){
        Pedido pedido = ServicePedidos.getINSTANCE().buscarPedido(pedido_id);
        return pedido;
    }
    
    public ArrayList traerClientes() throws SQLException{
        ArrayList listaCategorias = ServiceClientes.getINSTANCE().obtenerClientes();
        return listaCategorias; 
    }    
    public void aniadirPedido(Object[] values){
        ServiceClientes.getINSTANCE().agregarCliente(values);
    }
    
    public boolean agregarPedido(Pedido pedido) throws SQLException{
        Object[] values = { pedido.getFecha_pedido(), pedido.getTotal() , pedido.getCliente_id() };
        boolean respuesta = ServicePedidos.getINSTANCE().agregarPedido(values);
        return respuesta;
    }
    
    public boolean editarPedido(Pedido pedido) throws SQLException{
        Object[] values = {pedido.getPedido_id(), pedido.getFecha_pedido(), pedido.getTotal() , pedido.getCliente_id() };
        boolean resultado = ServicePedidos.getINSTANCE().editarPedido(values);
        return resultado;
    }
    public void eliminarPedido( int pedido_id) throws SQLException{
        ServicePedidos.getINSTANCE().eliminarPedido(pedido_id);
    }
    
    public String obternerCliente (int cliente_id){
        String categoria = ServiceClientes.getINSTANCE().obterner(cliente_id);
        return categoria;
        
    }
    
    public ArrayList filtrarPedidos(int cliente_id) throws SQLException{
        ArrayList listaProductos = ServicePedidos.getINSTANCE().obtenerPedidosFiltro(cliente_id);
        return listaProductos ;
    }
    
}
