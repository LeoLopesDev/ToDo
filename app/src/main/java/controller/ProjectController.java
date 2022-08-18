/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author Leonardo
 */
public class ProjectController {
    public void save(Project project) {
        String sql = "INSERT INTO projects (name +,"
                + "description, "
                + "createAt ,"
                + "updateAt ,"
                + "VALUES ( ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatAt().getTime()));
            statement.setDate(4, new Date(project.getUpdateAt().getTime()));

        }catch (Exception ex){
            throw new RuntimeException("Erro ao criar projeto" + ex.getMessage(), ex);
 
        }finally{
            
           ConnectionFactory.closeConnection(conn, statement);
            
        }
        
        
        
    }
}
