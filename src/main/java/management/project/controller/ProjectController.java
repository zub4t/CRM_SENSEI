/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.json.JSONObject;
import util.PaginationModel;

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
        JSONObject data = new JSONObject();
        try {
            HttpSession session = req.getSession();
            RequestDispatcher dis = null;
            String pwhat = req.getParameter("pwhat");
            ProjectServices services = new ProjectServices();
            ProjectModel projectModel = null;
            PrintWriter out;
            switch (pwhat) {
                case "changeStts":
               try {
                    services.changeStts(req);
                    data.put("header", "Alerta");
                    data.put("body", "Registo efetuado, o status do projeto foi alterado");
                    data.put("redirect", false);

                } catch (Exception e) {
                    e.printStackTrace();
                    data.put("header", "Alerta");
                    data.put("body", "Ocorreu um erro ao inserir um novo projeto");
                    data.put("redirect", false);

                }
                out = resp.getWriter();
                out.print(data);
                out.flush();
                break;
                case "getAll":
               try {
                   
                    data.put("projects", services.getAll());
                } catch (Exception e) {
                    e.printStackTrace();
                    data.put("projects", "[]");

                }
                resp.setContentType("application/json;charset=UTF-8");
                resp.setHeader("Access-Control-Allow-Origin", "*");
                out = resp.getWriter();
                out.print(data);
                out.flush();
                break;
                case "insert":
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    try {
                        services.insert(req);
                        data.put("header", "Alerta");
                        data.put("body", "Registo efetuado, o projeto foi inserido");
                        data.put("redirect", false);

                    } catch (Exception e) {
                        e.printStackTrace();
                        data.put("header", "Alerta");
                        data.put("body", "Ocorreu um erro ao inserir um novo projeto");
                        data.put("redirect", false);

                    }
                    out = resp.getWriter();
                    out.print(data);
                    out.flush();
                    break;
                case "setCurProjectId":
                    session.setAttribute("curProjectId", req.getParameter("curProjectId"));
                    resp.setContentType("text/html;charset=UTF-8");
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
                    resp.setContentType("text/html;charset=UTF-8");
                    dis = req.getRequestDispatcher("/management/project/project_edit.jsp");
                    try {
                        dis.forward(req, resp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "update":
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    try {
                        projectModel = services.update(req);
                        req.setAttribute("model", projectModel);
                        data.put("header", "Alerta");
                        data.put("body", "Registo efetuado, o projeto foi alterado");
                        data.put("redirect", true);
                    } catch (Exception e) {
                        e.printStackTrace();
                        data.put("header", "Alerta");
                        data.put("body", "Ocorreu um erro ao inserir um novo projeto");
                        data.put("redirect", false);

                    }
                    out = resp.getWriter();
                    out.print(data);
                    out.flush();

                    break;
                case "delete":
                    services.remove(req);
                    resp.setContentType("text/html;charset=UTF-8");
                    dis = req.getRequestDispatcher("/management/project/project_psq.jsp");
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
                    int max = services.getMaxPage();
                    if ((n + 1) > max) {
                        n = max;
                    }
                    req.setAttribute("ppage", (n));
                    resp.setContentType("text/html;charset=UTF-8");
                    dis = req.getRequestDispatcher("/management/project/project_table.jsp");
                    try {
                        dis.forward(req, resp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            data.put("header", "Alerta");
            data.put("body", "Ocorreu um erro interno " + e.toString());
            data.put("redirect", false);

        }

    }

}
