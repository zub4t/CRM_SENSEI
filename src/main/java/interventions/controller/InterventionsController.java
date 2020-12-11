/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interventions.controller;

import interventions.model.InterventionsModel;
import interventions.services.InterventionsServices;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import management.assingment.services.AssingmentServices;

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
        switch (pwhat) {
            case "insert":
                services.insert(req);
                RequestDispatcher dis = req.getRequestDispatcher("/interventions/interventions_res.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "edit":
                InterventionsModel model = services.getById(Integer.parseInt(req.getParameter("id")));
                req.setAttribute("model", model);
                req.setAttribute("edit", "true");
                dis = req.getRequestDispatcher("/interventions/interventions_nar.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "delete":

                services.remove(Integer.parseInt(req.getParameter("id")));
                dis = req.getRequestDispatcher("/interventions/interventions_psq.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "update":
                services.update(req);
                dis = req.getRequestDispatcher("/interventions/interventions_psq.jsp");
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
                dis = req.getRequestDispatcher("/interventions/interventions_table.jsp");
                try {
                    dis.forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
        }
    }
}
