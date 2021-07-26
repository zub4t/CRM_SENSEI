/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interventions.controller;

import interventions.model.InterventionsModel;
import interventions.services.InterventionsServices;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import management.assingment.services.AssingmentServices;
import org.json.JSONObject;

/**
 *
 * @author marco
 */
@WebServlet(value = "/InterventionsController")
public class InterventionsController extends HttpServlet {

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
        InterventionsServices services = new InterventionsServices();
        HttpSession session = req.getSession();
        JSONObject data = new JSONObject();
        PrintWriter out;
        try {
            RequestDispatcher dis;
            switch (pwhat) {
                case "insert":
                try {
                    services.insert(req);
                    data.put("header", "Alerta");
                    data.put("body", "Registo efetuado");
                    data.put("redirect", false);

                } catch (Exception e) {
                    data.put("header", "Alerta");
                    data.put("body", "Algo correu mal durante a inserção da nova intervenção " + e.toString());
                    data.put("redirect", false);

                }
                out = resp.getWriter();
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                out.print(data);
                out.flush();
                break;
                case "search":
                
                    session.setAttribute("employee_selected", req.getParameterValues("employee_selected"));
                    session.setAttribute("assingment_id", req.getParameterValues("assingment_id"));
                    session.setAttribute("date_filter_in", req.getParameterValues("date_filter_in"));
                    session.setAttribute("date_filter_out", req.getParameterValues("date_filter_out"));
                    dis = req.getRequestDispatcher("/interventions/interventions_psq.jsp");
                    dis.forward(req, resp);
                    break;
                case "edit":
                    InterventionsModel model = services.getById(Integer.parseInt(req.getParameter("id")));
                    req.setAttribute("model", model);
                    req.setAttribute("edit", "true");
                    resp.setContentType("text/html;charset=UTF-8");
                    dis = req.getRequestDispatcher("/interventions/interventions_nar.jsp");
                    dis.forward(req, resp);
                    break;
                case "delete":
                    services.remove(Integer.parseInt(req.getParameter("id")));
                    resp.setContentType("text/html;charset=UTF-8");
                    dis = req.getRequestDispatcher("/interventions/interventions_psq.jsp");
                    dis.forward(req, resp);
                    break;
                case "update":

                    try {
                    services.update(req);
                    data.put("header", "Alerta");
                    data.put("body", "Registo efetuado, a intervenção foi alterada");
                    data.put("redirect", true);

                } catch (Exception e) {
                    data.put("header", "Alerta");
                    data.put("body", "Algo correu mal durante a inserção da nova intervenção " + e.toString());
                    data.put("redirect", false);

                }

                out = resp.getWriter();
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                out.print(data);
                out.flush();

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
                    req.setAttribute("pmax", (max));
                    resp.setContentType("text/html;charset=UTF-8");
                    dis = req.getRequestDispatcher("/interventions/interventions_table.jsp");
                    dis.forward(req, resp);

                    break;
            }
        } catch (Exception e) {
            data.put("header", "Algo Correu mal internamente");
            data.put("body", e.toString());
            data.put("redirect", false);

        }

    }
}
