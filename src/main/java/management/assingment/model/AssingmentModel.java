/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.assingment.model;

/**
 *
 * @author marco
 */
public class AssingmentModel {

    public AssingmentModel(int id, String dsc) {
        this.id = id;
        this.dsc = dsc;
    }

    public AssingmentModel() {

    }
    private int id;
    private String dsc;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
