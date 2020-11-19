/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu.services;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import menu.model.MenuModel;
import menu.model.MenuStructure;
import menu.repository.MenuRepository;

/**
 *
 * @author marco
 */
public class MenuServices {

    public List<MenuStructure> createMenuStructure() {
        MenuRepository rep = new MenuRepository();
        List<MenuStructure> struct = new ArrayList<>();
        List<MenuModel> list_1 = rep.getByLvl(0);
        for (MenuModel m : list_1) {
            MenuStructure s = new MenuStructure(m);
            List<MenuModel> list_2 = rep.getByParent(m.getId());
            for (MenuModel c : list_2) {
                s.children.add(c);
            }
            struct.add(s);
        }
        return struct;
    }

    public void setMenu(HttpServletRequest req, HttpServletResponse resp) {
        MenuServices services = new MenuServices();
        req.setAttribute("structure", services.createMenuStructure());
    }
}
