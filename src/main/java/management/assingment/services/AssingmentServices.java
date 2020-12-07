/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.assingment.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import management.assingment.repository.AssingmentRepository;

/**
 *
 * @author marco
 */
public class AssingmentServices {

    public void setListOfAllAssingment(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("list_assng", new AssingmentRepository().getAll());
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
}
