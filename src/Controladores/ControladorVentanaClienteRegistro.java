/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Cliente;
import java.sql.SQLException;
import Servicios.ServiceClientes;

/**
 *
 * @author cduar
 */
public class ControladorVentanaClienteRegistro {

    public ControladorVentanaClienteRegistro() {
    }
    
    
    public boolean aniadirCliente(Cliente cliente){
        Object[] values = {cliente.getCliente_id(), cliente.getNombre() , cliente.getEmail()};
        boolean respuesta  = ServiceClientes.getINSTANCE().agregarCliente(values);
        return respuesta;
    }
    public boolean editarCliente(Cliente cliente ) throws SQLException{    
        Object[] values = {cliente.getCliente_id(), cliente.getNombre() , cliente.getEmail()};
        boolean respuesta  = ServiceClientes.getINSTANCE().editarCliente(values);
        return respuesta;
    }
    public void eliminarCliente(int cliente_id) throws SQLException{
        ServiceClientes.getINSTANCE().eliminarCliente(cliente_id);
    }
    
    
}
