/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import management.employee.model.EmployeeModel;
import management.employee.services.EmployeeServices;
import org.json.JSONObject;
import util.SendEmail;
import util.Util;

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
        JSONObject data = new JSONObject();
        try {
            String pwhat = req.getParameter("pwhat");
            EmployeeServices services = new EmployeeServices();
            RequestDispatcher dis = null;
            EmployeeModel employee = null;
            switch (pwhat) {
                case "insert":
              
                    try {
                    services.insert(req);

                    data.put("header", "Alerta");
                    data.put("body", "Tudo correu como previsto, um novo funcionario foi adicionado");
                } catch (Exception e) {
                    e.printStackTrace();
                    data.put("header", "Alerta");
                    data.put("body", "Ocorreu um erro durante a inserção de um novo funcionario");
                }
                PrintWriter out = resp.getWriter();
                out.print(data);
                out.flush();
                break;
                case "login":
                    int id = 0;
                    if ((id = services.login(req)) != 0) {
                        resp.setContentType("text/html;charset=UTF-8");
                        dis = req.getRequestDispatcher("/main/main.jsp");
                        HttpSession session = req.getSession();
                        session.setAttribute("userId", id);
                        session.setAttribute("username", req.getParameter("nickname"));

                    } else {
                        resp.setContentType("text/html;charset=UTF-8");
                        resp.setHeader("Cache-Control", "no-cache");
                        dis = req.getRequestDispatcher("/");

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
                    resp.setContentType("text/html;charset=UTF-8");
                    int max = services.getMaxPage();
                    if ((n + 1) > max) {
                        n = max;
                    }
                    req.setAttribute("ppage", (n));

                    dis = req.getRequestDispatcher("/management/employee/employee_table.jsp");

                    try {
                        dis.forward(req, resp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                case "forgotPass":
                    resp.setContentType("text/html;charset=UTF-8");
                    try {
                        JSONObject obj = new JSONObject(Util.getBody(req));
                        String username = obj.getString("nickname");
                        EmployeeModel model = services.getByUsername(username);
                        if (model.getId() != 0) {
                            String email = model.getEmail();
                            String newPass = "shistudiopass";
                            SendEmail.send(email, newPass);
                            services.setNewPass(model.getId(), newPass);
                            resp.getWriter().println("Foi enviado uma menssagem para o email associado a esse username. Por favor siga os passos lá descritos.");

                        } else {
                            resp.getWriter().println("Esse username não corresponde a nenhum cadastrado na nossa base de dados.");

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            data.put("header", "Alerta");
            data.put("body", "Ocorreu um erro interno " + e.toString());
        }

    }

}
