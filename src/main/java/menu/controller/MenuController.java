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
        RequestDispatcher requestDispatcher = null;

        switch (pwhat) {
            case "get":
                req.setAttribute("structure", services.createMenuStructure());
                requestDispatcher = req.getRequestDispatcher("/menu/menu.jsp");
                requestDispatcher.forward(req, resp);
                break;
        }
    }


}
