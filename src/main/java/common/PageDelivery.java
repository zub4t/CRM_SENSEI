/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Constant;
import util.FileReader;

/**
 *
 * @author marco
 */
@WebServlet(value = "/PageDelivery")
public class PageDelivery extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        String pwhat = req.getParameter("pwhat");
        PrintWriter out = null;
        try {

            out = resp.getWriter();
            switch (pwhat) {
                case "forgotPass":
                    resp.setContentType("text/html;charset=UTF-8");
                    String text = FileReader.read(Constant.utilFiles, Constant.forgotPass);
                    out.print(text);
                    out.flush();
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
