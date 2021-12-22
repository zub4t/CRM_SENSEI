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
import management.assingment.model.AssingmentModel;
import management.assingment.services.AssingmentServices;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import schedule.model.ScheduleModel;
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
                case "api":
                    int id_employee = Integer.parseInt(req.getParameter("id"));
                    data.put("events", services.getAll(id_employee));
                    resp.setContentType("application/json");
                    resp.setHeader("Access-Control-Allow-Origin", "*");
                    resp.setCharacterEncoding("UTF-8");
                    out = resp.getWriter();
                    out.print(data);
                    out.flush();
                    break;
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
                case "insert2":
                    try {
                    if (req.getParameter("event_id") != null) {
                        data.put("id", services.update2(req));
                    } else {
                        data.put("id", services.insert2(req));

                    }

                    data.put("status", 200);
                } catch (Exception e) {
                    e.printStackTrace();
                    data.put("status", 500);
                }
                resp.setContentType("application/json");
                resp.setHeader("Access-Control-Allow-Origin", "*");
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
                case "calendar":

                    resp.setContentType("application/json;charset=UTF-8");

                    int year = Integer.parseInt(req.getParameter("year"));

                    AssingmentServices assingment = new AssingmentServices();
                    JSONArray jArray = new JSONArray();

                    try {
                        for (ScheduleModel model : services.getByYear(year, req)) {
                            JSONObject modelJSON = new JSONObject();

                            String strDateDay = model.getStr_dte().split("-")[2];
                            String strDateMonth = model.getStr_dte().split("-")[1];
                            String endDateDay = model.getEnd_dte().split("-")[2];
                            String endDateMonth = model.getEnd_dte().split("-")[1];
                            int endDateMonthInt = Integer.parseInt(endDateMonth) - 1;
                            int strDateMonthInt = Integer.parseInt(strDateMonth) - 1;
                            AssingmentModel assinmentModel = assingment.getById(model.getAssignment_id());

                            modelJSON.put("id", model.getId());
                            modelJSON.put("name", model.getProject_name());
                            modelJSON.put("color", assinmentModel.getColor());
                            modelJSON.put("location", model.getDsc());
                            modelJSON.put("assignment", model.getAssignment_name());
                            modelJSON.put("startYear", year);
                            modelJSON.put("startMonth", strDateMonthInt);
                            modelJSON.put("startDay", strDateDay);
                            modelJSON.put("endYear", year);
                            modelJSON.put("endMonth", endDateMonthInt);
                            modelJSON.put("endDay", endDateDay);

                            jArray.put(modelJSON);
                        }
                    } catch (JSONException jse) {
                        jse.printStackTrace();
                    }
                    out = resp.getWriter();
                    out.print(jArray);
                    out.flush();
                    break;

            }

        } catch (Exception e) {
            e.printStackTrace();
            data.put("header", "Alerta");
            data.put("body", "Ocorreu um erro interno " + e.toString());
        }

    }

}
