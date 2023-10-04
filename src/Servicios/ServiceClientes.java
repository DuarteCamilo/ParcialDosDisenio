/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import ConexioDB.ConexionDB;
import Modelos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.postgresql.util.PSQLException;

/**
 *
 * @author cduar
 */
public class ServiceClientes {
    
    private static ServiceClientes  INSTANCE ;
    
    private static Connection conn ;
    
    private ServiceClientes () {
        conn = ConexionDB.getINSTANCE().getConnection();
    }
    
    public static ServiceClientes getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new ServiceClientes();
        }
        return INSTANCE;
    }

     
    
    public String obterner(int cliente_id){
        String nombre = null;
        try {
            String sql = "SELECT nombre FROM clientes WHERE cliente_id=?;" ;

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
             preparedStatement.setInt(1, cliente_id);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                
                nombre = rs.getString("nombre");
                preparedStatement.close();
                
                return nombre;
            }

        } catch (Exception ex) {
            Logger.getLogger(ServiceClientes.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return nombre;
        
    }
    
    public static ArrayList obtenerClientes(){
        ArrayList<Cliente> listaClientes = new ArrayList();
        try {
            String sql = "SELECT cliente_id,nombre,email FROM clientes;" ;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int cliente_id = rs.getInt("cliente_id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                Cliente cliente = new Cliente(cliente_id, nombre, email);
                listaClientes.add(cliente);
     
                
            }
            preparedStatement.close();

        } catch (Exception ex) {
            Logger.getLogger(ServiceClientes.class.getName()).log(Level.SEVERE, null, ex);

        }

        return listaClientes;     
    }
    
    
    public boolean agregarCliente ( Object[] values ){
        try {
            
            int cliente_id = Integer.parseInt(values[0].toString()) ;
            String nombre = values[1].toString();
            String email = values[2].toString();
            ResultSet rs = buscar_verificar( cliente_id);
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "El cliente con el id: " +  cliente_id + " ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);               
            }else{
                try{
                    String sql = "INSERT INTO clientes(cliente_id,nombre,email) VALUES(?,?,?);";

                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setInt(1,  cliente_id);
                    preparedStatement.setString(2,  nombre);
                    preparedStatement.setString(3,  email);

                    preparedStatement.executeUpdate();

                    preparedStatement.close();
                    JOptionPane.showMessageDialog(null, "Cliente agregada");
                    return true;
                } catch (Exception ex) {
                    Logger.getLogger(ServiceClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ServiceClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
   
    
    public static  ResultSet buscar_verificar (  int  cliente_id  ){
        try{
            String sqlBuscar = "SELECT  cliente_id FROM clientes WHERE  cliente_id=?";
            PreparedStatement buscarStmt = conn.prepareStatement(sqlBuscar);
            buscarStmt.setInt(1,  cliente_id);
            ResultSet resultado = buscarStmt.executeQuery();
            return resultado;         
        }catch( Exception ex){
            Logger.getLogger(ServiceClientes.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;
        
    }
     
     
     public boolean editarCliente (  Object[] values   ){
        try{
            
            int cliente_id = Integer.parseInt(values[0].toString()) ;
            String nombre = values[1].toString();
            String email = values[2].toString();
            ResultSet rs = buscar_verificar( cliente_id);

                
            if(!rs.next()){
                
                JOptionPane.showMessageDialog(null, "El cliente con el id: " +  cliente_id + " no está registrado", "Error", JOptionPane.ERROR_MESSAGE);                  
                return false;
            }else {
                String sql = "UPDATE clientes SET nombre=?,email=? WHERE cliente_id=?;";          
            
                PreparedStatement preparedStatement = conn.prepareStatement(sql);


                
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, email);
                preparedStatement.setInt(3, cliente_id);
            

                preparedStatement.executeUpdate();

                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                return true;
                

            }
                   
        }catch(Exception ex){
            Logger.getLogger(ServiceClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     public static  void eliminarCliente( int cliente_id ){
        try{
            ResultSet rs = buscar_verificar(cliente_id);
            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "El cliente con id " + cliente_id+" no esta registrado");

            }else{
                try {
                        String sql = "DELETE from clientes where cliente_id=?";
                        PreparedStatement preparedStatement = conn.prepareStatement(sql);
                        preparedStatement.setInt(1, cliente_id);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        JOptionPane.showMessageDialog(null, "cliente eliminado");
                    } catch (PSQLException ex) {
                        if (ex.getMessage().contains("violates foreign key constraint \"pedidos_cliente_id_fkey\"")) {
                            JOptionPane.showMessageDialog(null, "No se puede eliminar el cliente porque hay pedidos asignados a este cliente.");
                        } else {
                            Logger.getLogger(ServiceClientes.class.getName()).log(Level.SEVERE, null, ex);
                        }
                } catch (Exception ex) {
                    Logger.getLogger(ServiceClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
                    Logger.getLogger(ServiceClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
     }
     
     
    
}
