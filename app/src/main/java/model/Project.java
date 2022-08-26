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
public class Project {
    private int id;
    private String name;
    private String description;
    private Date createAt;
    private Date updateAt;
    
    public Project(){
        
    }

 
    public Project(int id, String name, String description, Date createAt, Date updateAt){
        this.createAt = createAt;
        this.description = description;
        this.id = id;
        this.name = name;
        this.updateAt = updateAt;
    }
    
    public void setCreatAt(Date createAt) {
    this.createAt = createAt;
}
    public Date getCreatAt() { 
        return createAt;
    }
    public void setDescription(String description) { 
        this.description = description;
        
    }
    public String getDescription() { 
        return description;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
    public Date getUpdateAt(){
        return updateAt;
    }
}





