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
public class ComesticError {
    private String Id;
    private String name;
    private String description;
    private float price;
    private boolean status;

    public ComesticError() {
    }

    public ComesticError(String Id, String name, String description, float price, boolean status) {
        this.Id = Id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
