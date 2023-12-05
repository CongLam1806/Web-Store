/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.entity;

/**
 *
 * @author Trần Công Lâm
 */
public class User {
    private String userID;
    private boolean status;
    private String fullName;
    private String roleID;
    private String password;

    public User() {
    }

    public User(String userID, boolean status, String fullName, String roleID, String password) {
        this.userID = userID;
        this.status = status;
        this.fullName = fullName;
        this.roleID = roleID;
        this.password = password;
    }

    public User(String userID, boolean status, String fullName, String password) {
        this.userID = userID;
        this.status = status;
        this.fullName = fullName;
        this.password = password;
    }
    
    

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
