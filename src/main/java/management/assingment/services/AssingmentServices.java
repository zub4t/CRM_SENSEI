/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.assingment.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import management.assingment.repository.AssingmentRepository;
import org.json.JSONObject;
import util.PaginationModel;

/**
 *
 * @author marco
 */
public class AssingmentServices {

    public void setListOfAllAssingment(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("list_assng", new AssingmentRepository().getAll());
    }

    public void setAssingment(HttpServletRequest req, HttpServletResponse resp, int n) {
        AssingmentRepository repository = new AssingmentRepository();
        PaginationModel pagination = new PaginationModel();
        pagination.setPage(n + 1);
        pagination.setMax_page(getMaxPage() + 1);
        req.setAttribute("pagination", pagination);
        pagination.setUrl("/CRM_SENSEI/AssingmentController?pwhat=pagination");
        req.setAttribute("assingmentList", repository.getN(n));
    }

    public void insert(HttpServletRequest req) {
        AssingmentRepository repository = new AssingmentRepository();
        String dsc = req.getParameter("dsc");

        repository.insertAssingment(dsc);
    }

    public void remove(HttpServletRequest req) {

        AssingmentRepository repository = new AssingmentRepository();
        int id = Integer.parseInt(req.getParameter("id"));
        repository.remove(id);
    }

    public int getMaxPage() {
        AssingmentRepository repository = new AssingmentRepository();
        return repository.getMaxPage();

    }

    public boolean serOrder(int size, JSONObject json) {
        AssingmentRepository repository = new AssingmentRepository();
        return repository.setOrder(size, json);
    }
}
