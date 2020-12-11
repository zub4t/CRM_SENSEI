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
import javax.servlet.http.HttpSession;
import management.employee.model.EmployeeModel;
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
        EmployeeModel employee = null;
        switch (pwhat) {
            case "insert":
                services.insert(req);
                resp.setContentType("text/html;charset=UTF-8");
                dis = req.getRequestDispatcher("/management/employee/employee_res.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "login":
                int id = 0;
                if ((id = services.login(req)) != 0) {
                    resp.setContentType("text/html;charset=UTF-8");
                    dis = req.getRequestDispatcher("/main/main.jsp");
                    HttpSession session = req.getSession();
                    session.setAttribute("userId", id);
                } else {
                    resp.setContentType("text/html;charset=UTF-8");
                    dis = req.getRequestDispatcher("/login/login.jsp");

                }
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                employee = services.getById(Integer.parseInt(req.getParameter("empId")));
                req.setAttribute("model", employee);
                resp.setContentType("text/html;charset=UTF-8");
                dis = req.getRequestDispatcher("/management/employee/employee_edit.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "update":
                employee = services.update(req);
                req.setAttribute("model", employee);
                resp.setContentType("text/html;charset=UTF-8");
                dis = req.getRequestDispatcher("/management/employee/employee_psq.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                services.remove(req);
                resp.setContentType("text/html;charset=UTF-8");
                dis = req.getRequestDispatcher("/management/employee/employee_psq.jsp");
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
                req.setAttribute("ppage", (n));
                resp.setContentType("text/html;charset=UTF-8");
                dis = req.getRequestDispatcher("/management/employee/employee_table.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
        }
    }

}
