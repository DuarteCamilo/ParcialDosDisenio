/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import ConexioDB.ConexionDB;
import java.sql.Connection;

/**
 *
 * @author cduar
 */
public class Service {
    private static Service  INSTANCE ;
    
    private static Connection conn ;
    
 
    private Service () {
        conn = ConexionDB.getINSTANCE().getConnection();
    }
    
    public static Service getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new Service();
        }
        return INSTANCE;
    }
    
    
}
