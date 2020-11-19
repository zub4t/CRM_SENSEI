/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu.model;

/**
 *
 * @author marco
 */
public class MenuModel {

    private int id;
    private String nme;
    private int lvl;
    private int parent_id;

    public MenuModel(int id, String nme, int lvl, int parent_id) {
        this.id = id;
        this.nme = nme;
        this.lvl = lvl;
        this.parent_id = parent_id;
    }

    public MenuModel() {

    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNme() {
        return nme;
    }

    public void setNme(String nme) {
        this.nme = nme;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    @Override
    public String toString() {
        return this.nme + "\n";
    }

}
