/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CriaConexao {
    
    public static Connection getConexao() throws SQLException {
        
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Conectando ao banco de dados.");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Amazonia,postgres,postgresql4321");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }    
        
    }
    
}
