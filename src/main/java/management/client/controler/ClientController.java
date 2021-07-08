/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.client.controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import management.client.model.ClientModel;
import management.client.service.ClientService;

import org.json.JSONObject;

/**
 *
 * @author marco
 */
@WebServlet(value = "/ClientController")
public class ClientController extends HttpServlet {

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
            ClientService services = new ClientService();
            RequestDispatcher dis = null;
            ClientModel model = null;
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

                case "edit":
                    model = services.getById((req.getParameter("id")));
                    req.setAttribute("model", model);
                    resp.setContentType("text/html;charset=UTF-8");
                    dis = req.getRequestDispatcher("/management/client/client_edit.jsp");
                    try {
                        dis.forward(req, resp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "update":
                try {
                    resp.setContentType("application/json;charset=UTF-8");
                    model = services.update(req);
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

                    dis = req.getRequestDispatcher("/management/client/client_table.jsp");

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
