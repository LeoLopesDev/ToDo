/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Leonardo
 */
public class Task {
    private int id;
    private int idProject;
    private String name;
    private String notes;
    private String description;
    private boolean isCompleted;
    private Date deadline;
    private Date createdAt;
    private Date updatedAt;

    
    public Task(){
  }

    public Task(int id, int idProject, String name, String notes, String description,
        boolean isCompleted, Date deadline, Date createdAt, Date updatedAt) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.notes = notes;
        this.description = description;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setIdProject(int idProject){
        this.idProject = idProject;
    }
    public int getIdProject() {
        return idProject;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public String getNotes() {
        return notes;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public void setIsCompleted(boolean isCompleted) { 
        this.isCompleted = isCompleted;
    }
    public boolean getIsCompleted() { 
        return isCompleted;
    }
    public void setCreatAt(Date createdAt) { 
        this.createdAt = createdAt;
    }
    public Date getCreateAt() { 
        return createdAt;
    }
    public void setUpdateAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Date getUpdateAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", notes=" + notes + ", description=" + description + ", isCompleted=" + isCompleted + ", deadline=" + deadline + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    
}



