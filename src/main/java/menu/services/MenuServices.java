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
import util.PaginationModel;

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
    
    public void setMenu(HttpServletRequest req, HttpServletResponse resp, int n) {
        MenuRepository repository = new MenuRepository();
        PaginationModel pagination = new PaginationModel();
        pagination.setPage(n);
        req.setAttribute("pagination", pagination);
        pagination.setUrl("/CRM_SENSEI/MenuController?pwhat=pagination");

        req.setAttribute("menuList", repository.getN(n));
    }

    public void setMenu(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("structure", createMenuStructure());
    }

    public MenuModel getById(int id) {
        MenuRepository repository = new MenuRepository();
        return repository.getById(id);
    }

    public MenuModel update(HttpServletRequest req) {
        MenuRepository repository = new MenuRepository();
        return repository.update(Integer.parseInt(req.getParameter("menuId")),req.getParameter("nme"), req.getParameter("userLevel"));
    }
}
