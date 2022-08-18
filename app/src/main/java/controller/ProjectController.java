/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
        
    public void update(Project project) {
      
        String sql = "UPDATE projects SET name = ?"
                + "description = ?"
                + "creatAt = ?"
                + "updateAt = ?"
                + "WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
                try {
                    conn = ConnectionFactory.getConnection();
                    statement = conn.prepareStatement(sql);
                    
                    statement.setString(1, project.getName());
                    statement.setString(2, project.getDescription());
                    statement.setDate(3, new Date(project.getCreatAt().getTime()));
                    statement.setDate(4, new Date(project.getUpdateAt().getTime()));
                    statement.setInt(5, project.getId());
                    statement.execute();
                   
                    }catch (Exception ex) {
                        throw new RuntimeException("Erro ao atualizar o projeto" + ex.getMessage(), ex);
                    }finally {
                    
                    ConnectionFactory.closeConnection(conn, statement);  
                }
    }
                
                public List<Project> getAll(){
                    
                    String sql = "SELECT * FROM pojects WHERE idProject = ?";
                    Connection conn = null;
                    PreparedStatement statement = null;
                    ResultSet resultSet = null;
                    
                    List<Project> projects = new ArrayList<Project>();
                    
                    try {
                        conn = ConnectionFactory.getConnection();
                        statement = conn.prepareStatement(sql);
                        resultSet = statement.executeQuery();
                        
                        while (resultSet.next()) {
                            
                            Project project = new Project();
                            
                            project.setId(resultSet.getInt("id"));
                            project.setName(resultSet.getString("name"));
                            project.setDescription(resultSet.getString("description"));
                            project.setUpdateAt(resultSet.getDate("updateAt"));
                            project.setCreatAt(resultSet.getDate("creatAt"));
                            
                            projects.add(project);

                        }
                        
                        
                    }catch (Exception ex){
                        throw new RuntimeException("Erro ao buscar projetos", ex);
                        
                    }finally{
                    
                        ConnectionFactory.closeConnection(conn, statement, resultSet);
                }
                    return projects;
                }
}

