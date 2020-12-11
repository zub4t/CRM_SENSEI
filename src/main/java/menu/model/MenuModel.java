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
    private String url;
    private int userLevel;

    public MenuModel(int id, String nme, int lvl, int parent_id, String url) {
        this.id = id;
        this.nme = nme;
        this.lvl = lvl;
        this.parent_id = parent_id;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }
    
    

}
