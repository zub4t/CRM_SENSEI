/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedule.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import schedule.services.ScheduleService;

/**
 *
 * @author Marco
 */
@WebServlet(value = "/ScheduleController")
public class ScheduleController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject data = new JSONObject();
        try {

            String pwhat = req.getParameter("pwhat");
            //BufferedReader body = req.getReader();
            ScheduleService services = new ScheduleService();
            RequestDispatcher dis = null;
            resp.setContentType("text/html;charset=UTF-8");

            PrintWriter out = resp.getWriter();

            switch (pwhat) {
                case "insert":
                    try {
                    int id = services.insert(req);
                    data.put("header", "Alerta");
                    data.put("body", "Registo efetuado uma nova tarefa foi adicionada");
                    data.put("id", id);

                } catch (Exception e) {
                    e.printStackTrace();
                    data.put("header", "Alerta");
                    data.put("body", "Ocorreu um erro durante a inserção de um nova tarefa");
                    data.put("id", -1);
                }
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                out.print(data);
                out.flush();
                break;
                case "delete":
                    services.remove(req);
                    resp.setContentType("text/html;charset=UTF-8");

                    break;
                case "update":
                    services.update(req);
                    resp.setContentType("text/html;charset=UTF-8");
                    dis = req.getRequestDispatcher("/management/assingment/assingment_psq.jsp");
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
        }

    }

}
