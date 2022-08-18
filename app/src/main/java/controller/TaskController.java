/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author Leonardo
 */
public class TaskController {
    public void save(Task task){
        String sql = "INSERT INTO tasks (idProject, "
                + "name, description, completed,"
                + "notes, deadline, createdAt, updatedAt) VALUES (?, ?, ?, ?, ?, ? , ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();
            
        } catch(Exception ex){
            throw new RuntimeException("Erro ao salvar tarefa" + 
                    ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    public void update(Task task) {
        String sql = "UPDATE tasks SET (idProject, "
                + "name, description, completed,"
                + "notes, deadline, createdAt, updatedAt) WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            
            //Estabelecendo a conexão com o banco de dados.
            
            conn = ConnectionFactory.getConnection();
            
            //Preparando a conexão com o banco de dados
            statement = conn.prepareStatement(sql);
            
            //Setando os valores statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            
            // Executando a query
            statement.execute();
            
        }catch (Exception ex) {
            
            throw new RuntimeException("Erro ao atualizar tarefa" + ex);
        }
    }
    public void removeById(int taskId) throws SQLException{
     
        String sql = "DELETE FROM tasks WHERE id= ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            //Criação da conexão com o banco de dados
            conn = ConnectionFactory.getConnection();
            
            //Preparando a query
            statement = conn.prepareStatement(sql);
            
            //Setando os valores statement
            statement.setInt(1, taskId);
            
            //executando a query
            statement.execute();
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar a tarefa");
        } finally {
            ConnectionFactory.closeConnection(conn, statement);
            
        }
        
    }
    
    public List<Task> getAll(int idProject){
        
        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        //Criando a lista de taferas que será retornada
        
        List<Task> tasks = new ArrayList<Task>();
        
        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            
            //Setando o valor do filtro de busca
            statement.setInt(1, idProject);
            
            //Valor retornado pela excução da query
            resultSet = statement.executeQuery();
            
            //Enquanto houver valores a serem percorridos no resultSet
            while(resultSet.next()) {
                
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                tasks.add(task);
            }
            
        }catch (Exception ex){
            
            throw new RuntimeException("Erro ao inserir a tarefa" + ex.getMessage(), ex);
            
        } finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
         //Lista de taferas que foi criada e carregada do banco de dados
        return tasks;
    }
}

