/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.assingment.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import management.assingment.services.AssingmentServices;
import management.employee.services.EmployeeServices;
import org.json.JSONObject;
import util.Util;

/**
 *
 * @author marco
 */
@WebServlet(value = "/AssingmentController")
public class AssingmentController extends HttpServlet {

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
            AssingmentServices services = new AssingmentServices();
            RequestDispatcher dis = null;
            resp.setContentType("text/html;charset=UTF-8");

            PrintWriter out = resp.getWriter();

            switch (pwhat) {
                case "getColor":
                    try {
                    data.put("colors", services.getColor(req));

                } catch (Exception e) {
                    e.printStackTrace();
                    data.put("color", "[]");
                }
                resp.setContentType("application/json;charset=UTF-8");
                resp.setHeader("Access-Control-Allow-Origin", "*");
                out.print(data);
                out.flush();
                break;
                case "getAll":
                    try {
                    data.put("assignments", services.getAll(req));
                } catch (Exception e) {
                    e.printStackTrace();
                    data.put("assignments", "[]");
                }
                resp.setContentType("application/json;charset=UTF-8");
                resp.setHeader("Access-Control-Allow-Origin", "*");
                out.print(data);
                out.flush();
                break;
                case "getColorAll":
                    try {
                    data.put("color", services.getColorAll(req));
                } catch (Exception e) {
                    e.printStackTrace();
                    data.put("color", "#000000");
                }
                resp.setContentType("application/json;charset=UTF-8");
                resp.setHeader("Access-Control-Allow-Origin", "*");
                out.print(data);
                out.flush();
                break;
                case "insert":
                    try {
                    services.insert(req);
                    data.put("header", "Alerta");
                    data.put("body", "Registo efetuado uma nova tarefa foi adicionada");
                } catch (Exception e) {
                    e.printStackTrace();
                    data.put("header", "Alerta");
                    data.put("body", "Ocorreu um erro durante a inserção de um nova tarefa");
                }
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                out.print(data);
                out.flush();
                break;
                case "delete":
                    services.remove(req);
                    resp.setContentType("text/html;charset=UTF-8");
                    dis = req.getRequestDispatcher("/management/assingment/assingment_psq.jsp");
                    try {
                        dis.forward(req, resp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "update":
                    try {
                    services.update(req);
                    data.put("header", "Alerta");
                    data.put("body", "Registo efetuado uma nova tarefa foi atualizada");
                } catch (Exception e) {
                    e.printStackTrace();
                    data.put("header", "Alerta");
                    data.put("body", "Ocorreu um erro durante a inserção de um nova tarefa");
                }
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                out.print(data);
                out.flush();
                break;
                case "edit":
                    services.edit(req);
                    resp.setContentType("text/html;charset=UTF-8");

                    dis = req.getRequestDispatcher("/management/assingment/assingment_nar.jsp");
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
                    dis = req.getRequestDispatcher("/management/assingment/assingment_table.jsp");
                    try {
                        dis.forward(req, resp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                case "saveOrder":
                    String payloadRequest = Util.getBody(req);
                    int size = Integer.parseInt(req.getParameter("size"));
                    JSONObject json = new JSONObject(payloadRequest);
                    boolean flag = services.serOrder(size, json);
                    if (flag) {
                        out.println("Ordenação salva !!");
                    } else {
                        out.println("Ordenação salva !!");

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
