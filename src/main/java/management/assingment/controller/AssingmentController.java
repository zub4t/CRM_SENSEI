/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.assingment.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import management.assingment.services.AssingmentServices;
import management.employee.services.EmployeeServices;

/**
 *
 * @author marco
 */
@WebServlet(value = "/AssingmentController")
public class AssingmentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String pwhat = req.getParameter("pwhat");
        AssingmentServices services = new AssingmentServices();
        switch (pwhat) {
            case "insert":
                services.insert(req);
                RequestDispatcher dis = req.getRequestDispatcher("/management/assingment/assingment_res.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                services.remove(req);
                dis = req.getRequestDispatcher("/management/assingment/assingment_psq.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

}
