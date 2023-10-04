/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;


import ConexioDB.ConexionDB;
import Modelos.Pedido;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cduar
 */
public class ServicePedidos {
    private static ServicePedidos INSTANCE;
    
    private static Connection conn;
    
    private ServicePedidos() {   
        conn = ConexionDB.getINSTANCE().getConnection();
    }

    public static ServicePedidos getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new ServicePedidos();
        }
        return INSTANCE;
    }
    
    public static Pedido buscarPedido(int pedido_id){
        try {
            String sqlBuscarLibro = "SELECT * FROM pedidos WHERE pedido_id = ?";
            PreparedStatement buscarLibroStmt = conn.prepareStatement(sqlBuscarLibro);
            buscarLibroStmt.setInt(1, pedido_id);
            ResultSet rs = buscarLibroStmt.executeQuery();
            
            if(rs.next()){
                
                String fecha_pedido = rs.getString("fecha_pedido");
                float total = rs.getFloat("total");
                int cliente_id = rs.getInt("cliente_id");
                
                
                Pedido pedido = new Pedido(pedido_id, fecha_pedido, total, cliente_id);
                return pedido;

                
            }else{
                JOptionPane.showMessageDialog(null, "El pedido con el codigo " + pedido_id + " no está registrado", "Error", JOptionPane.ERROR_MESSAGE);   
            }
            
        }catch( Exception ex){
            Logger.getLogger(ServicePedidos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
        
    }    
    
    public static ResultSet buscar_verificar(int pedido_id){
         try{
            String sqlBuscarCodigoLibro = "SELECT pedido_id FROM pedidos WHERE pedido_id = ?";            
            PreparedStatement buscarLibroStmt1 = conn.prepareStatement(sqlBuscarCodigoLibro);            
            buscarLibroStmt1.setInt(1, pedido_id);
            ResultSet resultado = buscarLibroStmt1.executeQuery();
            return resultado;
        
        }catch( Exception ex){
            Logger.getLogger(ServicePedidos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
        
    }
    
    public boolean agregarPedido ( Object[] values  ) throws SQLException{
        try{ 
            
            String fecha_pedido = values[0].toString();
            float total = Float.parseFloat(values[1].toString());
            int cliente_id = Integer.parseInt(values[2].toString()) ;

            String sql = "INSERT INTO pedidos(fecha_pedido,total,cliente_id)" +  "VALUES(?,?,?);";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);


            preparedStatement.setString(1, fecha_pedido);
            preparedStatement.setFloat(2, total);
            preparedStatement.setInt(3, cliente_id);          
            preparedStatement.executeUpdate();
            preparedStatement.close();
            JOptionPane.showMessageDialog(null, "Pedido agregado");
            return true;
            
                   
        }catch( Exception ex){
            Logger.getLogger(ServicePedidos.class.getName()  ).log(Level.SEVERE, null, ex);
        }   
        return false;
    }
    
    
    
    public boolean editarPedido ( Object[] values ){
        try {
            int pedido_id = Integer.parseInt(values[0].toString()) ;
            String fecha_pedido = values[1].toString();
            float total = Float.parseFloat(values[2].toString());
            int cliente_id = Integer.parseInt(values[3].toString()) ;

            ResultSet resultado = buscar_verificar(pedido_id);

            if(resultado.next()){

                String sql = "UPDATE pedidos set fecha_pedido=?,total=?,cliente_id=? where pedido_id=?;";

                PreparedStatement preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setString(1, fecha_pedido);
                preparedStatement.setFloat(2, total);
                preparedStatement.setInt(3, cliente_id);
                preparedStatement.setInt(4, pedido_id);
                
                preparedStatement.executeUpdate();

                preparedStatement.close();
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                return true;
            }
            else {
                JOptionPane.showMessageDialog(null, "El pedido con el codigo " + pedido_id + " no está registrado", "Error", JOptionPane.ERROR_MESSAGE);                 
                return false;
            }
                   
        }catch( Exception ex){
            Logger.getLogger(ServicePedidos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    
    public static  void eliminarPedido( int pedido_id ){
        
        
        try{
            ResultSet rs = buscar_verificar(pedido_id);
            if(rs.next()){
                String sql = "DELETE from pedidos where pedido_id =?;";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, pedido_id );
                preparedStatement.executeUpdate();
                preparedStatement.close();           
                JOptionPane.showMessageDialog(null, "Datos eliminados");
                
            }else{
                JOptionPane.showMessageDialog(null, "El pedido con el codigo " + pedido_id + " no está registrado", "Error", JOptionPane.ERROR_MESSAGE);                 
            }  
        }catch(Exception ex){
            Logger.getLogger(ServicePedidos.class.getName()).log(Level.SEVERE, null, ex);  
        }

    }
    
    
        public static ArrayList obtenerPedidosFiltro(int cliente_id){
        ResultSet rs = null;
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            
            String sql = "SELECT pedido_id,fecha_pedido,total FROM pedidos WHERE cliente_id=? ;" ;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, cliente_id );
            


            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int pedido_id = rs.getInt("pedido_id");
                String fecha_pedido = rs.getString("fecha_pedido");
                float total = rs.getFloat("total");
                
                
                
                
                
                
                Pedido pedido = new Pedido(pedido_id, fecha_pedido, total, cliente_id);
                pedidos.add(pedido);         
           }
            
           return pedidos;

        } catch (SQLException ex) {
            Logger.getLogger(ServicePedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    
    
    
    
//        public static ArrayList obtenerLibros(){
//        ArrayList<Libro> listaLibros = new ArrayList();
//        try {
//            String sql = "SELECT id_categoria,nombre_categoria FROM categorias;" ;
//            //System.out.println(sql);
//            PreparedStatement preparedStatement = conn.prepareStatement(sql);
//
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                int id_categoria = rs.getInt("id_categoria");
//                String nombre_categoria = rs.getString("nombre_categoria");
//                Categoria categoria = new Categoria(id_categoria, nombre_categoria);
//                listaLibros.add(categoria);
//            }
//
//        } catch (Exception ex) {
//            Logger.getLogger(ServiceProducto.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
//
//        return listaLibros;     
//    }
   
    
}
