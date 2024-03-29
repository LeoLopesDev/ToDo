/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Leonardo
 */
public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL  = "jdbc:mysql://localhost:3306/todoapp";
    public static final String USER = "root";
    public static final String PASS = "";
    
      public static Connection getConnection() {
        try {
              Class.forName(DRIVER);
              return DriverManager.getConnection(URL, USER, PASS);
          }
       catch (Exception ex){
              throw new RuntimeException("Erro na conex�o com o banco de dados", ex);
       }
     }
    public static void closeConnection (Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        }
        catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados");
        }
        
    }
    public static void closeConnection (Connection connection, PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados");
        }
        
    }
    
    public static void closeConnection (Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }
        }
        catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conex�o com o banco de dados");
        }
        
    }
}
