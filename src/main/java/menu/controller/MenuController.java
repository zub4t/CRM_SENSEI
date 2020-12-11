/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import menu.model.MenuModel;
import menu.services.MenuServices;

/**
 *
 * @author marco
 */
@WebServlet("/MenuController")
public class MenuController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pwhat = req.getParameter("pwhat");
        MenuServices services = new MenuServices();
        RequestDispatcher dis = null;
        MenuModel menu = null;

        switch (pwhat) {
            case "get":
                req.setAttribute("structure", services.createMenuStructure());
                resp.setContentType("text/html;charset=UTF-8");
                dis = req.getRequestDispatcher("/menu/menu.jsp");
                dis.forward(req, resp);
                break;
            case "edit":
                menu = services.getById(Integer.parseInt(req.getParameter("menuId")));
                req.setAttribute("model", menu);
                resp.setContentType("text/html;charset=UTF-8");
                dis = req.getRequestDispatcher("/management/gestMenu/gestMenu_edit.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "update":
                menu = services.update(req);
                req.setAttribute("model", menu);
                resp.setContentType("text/html;charset=UTF-8");
                dis = req.getRequestDispatcher("/management/gestMenu/gestMenu_psq.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "pagination":
                int n = 0;
                if (req.getParameter("page") != null) {
                    n = Integer.parseInt(req.getParameter("page"));
                }
                resp.setContentType("text/html;charset=UTF-8");
                req.setAttribute("ppage", (n));
                dis = req.getRequestDispatcher("/management/gestMenu/gestMenu_table.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
        }
    }


}
