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
import util.Constant;
import util.FileReader;
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
            req.setCharacterEncoding("utf-8");

            String pwhat = req.getParameter("pwhat");
            EmployeeServices services = new EmployeeServices();
            RequestDispatcher dis = null;
            EmployeeModel employee = null;
            PrintWriter out;
            HttpSession session = req.getSession();
            switch (pwhat) {
                case "insert":
              
                    try {
                    resp.setContentType("application/json;charset=UTF-8");
                    services.insert(req);
                    data.put("header", "Alerta");
                    data.put("body", "Registo efetuado, um novo funcionario foi adicionado");
                    data.put("redirect", false);
                } catch (Exception e) {
                    e.printStackTrace();
                    data.put("header", "Alerta");
                    data.put("body", "Ocorreu um erro durante a inserção de um novo funcionario");
                    data.put("redirect", false);

                }
                out = resp.getWriter();
                out.print(data);
                out.flush();
                break;
                case "login":
                    int id = 0;
                    if ((id = services.login(req)) != 0) {
                        resp.setContentType("text/html;charset=UTF-8");
                        dis = req.getRequestDispatcher("/main/main.jsp");
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
                try {
                    resp.setContentType("application/json;charset=UTF-8");
                    employee = services.update(req);
                    data.put("header", "Alerta");
                    data.put("body", "Registo efetuado, o  funcionario foi editado");
                    data.put("redirect", true);

                } catch (Exception e) {
                    e.printStackTrace();
                    data.put("header", "Alerta");
                    data.put("body", "Ocorreu um erro durante a inserção de um novo funcionario");
                    data.put("redirect", false);
                }
                out = resp.getWriter();
                out.print(data);
                out.flush();

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
                case "updatePass":
                    resp.setContentType("application/json;charset=UTF-8");
                    JSONObject obj = null;
                    try {
                        obj = new JSONObject(Util.getBody(req));
                        String username = obj.getString("nickname");
                        String pass = obj.getString("pass");
                        String key = obj.getString("key");
                        if (key.equals(session.getAttribute("key"))) {
                            EmployeeModel model = services.getByUsername(username);
                            if (model.getId() != 0) {
                                services.setNewPass(model.getId(), pass);
                                obj = new JSONObject();
                                obj.put("res", "OK");
                                obj.put("data", FileReader.read(Constant.utilFiles, Constant.forgotPassOK));
                            } else {
                                obj.put("res", "--");
                                obj.put("data", FileReader.read(Constant.utilFiles, Constant.forgotPassKO));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        obj.put("res", "KO");
                        obj.put("data", FileReader.read(Constant.utilFiles, Constant.forgotPassKO));

                    } finally {

                        resp.getWriter().print(obj);
                        resp.getWriter().flush();
                    }

                    break;
                case "checkUserPass":
                    resp.setContentType("application/json;charset=UTF-8");
                    out = resp.getWriter();
                    String key = Util.randomKey();
                    int aux = services.login(req);
                    aux = (aux == 9 || aux == 7) ? aux : 0;
                    data.put("id", aux);

                    if (aux != 0) {
                        data.put("key", key);
                        session.setAttribute("key", key);
                    } else {
                        data.put("key", "nãoéumachave:D");
                    }
                    out.print(data);
                    out.flush();

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
