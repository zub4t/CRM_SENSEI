/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class MenuStructure {

    public MenuModel parent;
    public List<MenuModel> children = new ArrayList<>();

    public MenuStructure(MenuModel parent) {
        this.parent = parent;
    }

    public MenuModel getParent() {
        return parent;
    }

    public void setParent(MenuModel parent) {
        this.parent = parent;
    }

    public List<MenuModel> getChildren() {
        return children;
    }

    public void setChildren(List<MenuModel> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return (parent.getNme() + " - with " + children.size() + " childrens");

    }

}
