/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.employee.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import management.employee.services.EmployeeServices;

/**
 *
 * @author marco
 */
@WebServlet(value = "/EmployeeController")
public class EmployeeController extends HttpServlet {

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
        EmployeeServices services = new EmployeeServices();
        RequestDispatcher dis = null;
        switch (pwhat) {
            case "insert":
                services.insert(req);
                dis = req.getRequestDispatcher("/management/employee/employee_res.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "login":
                if(services.login(req)){
                    dis = req.getRequestDispatcher("/main/main.jsp");
                } else {
                    dis = req.getRequestDispatcher("/login/login.jsp");
                }
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

}
