/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.project.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import management.employee.services.EmployeeServices;
import management.project.model.ProjectModel;
import management.project.services.ProjectServices;

/**
 *
 * @author marco
 */
@WebServlet(value = "/ProjectController")
public class ProjectController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        RequestDispatcher dis = null;
        String pwhat = req.getParameter("pwhat");
        ProjectServices services = new ProjectServices();
        ProjectModel projectModel = null;
        switch (pwhat) {
            case "insert":
                services.insert(req);
                dis = req.getRequestDispatcher("/management/project/project_res.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "setCurProjectId":
                session.setAttribute("curProjectId", req.getParameter("curProjectId"));
                dis = req.getRequestDispatcher("/main/main.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                projectModel = services.getById(Integer.parseInt(req.getParameter("projectId")));
                req.setAttribute("model", projectModel);
                dis = req.getRequestDispatcher("/management/project/project_edit.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "update":
                projectModel = services.update(req);
                req.setAttribute("model", projectModel);
                dis = req.getRequestDispatcher("/management/project/project_psq.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                services.remove(req);
                dis = req.getRequestDispatcher("/management/project/project_psq.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

}
