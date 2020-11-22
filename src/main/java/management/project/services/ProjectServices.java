/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.project.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import management.project.repository.ProjectRepository;

/**
 *
 * @author marco
 */
public class ProjectServices {

    public void setListOfAllPrj(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("list_prj", new ProjectRepository().getAll());
    }

    public void insert(HttpServletRequest req) {
        ProjectRepository repository = new ProjectRepository();
        String n_process = req.getParameter("n_process");
        String nme = req.getParameter("nme");
        float expected_sale = Float.parseFloat(req.getParameter("expected_sale"));
        float effective_sale = Float.parseFloat(req.getParameter("effective_sale"));
        float effective_purchase = Float.parseFloat(req.getParameter("effective_purchase"));
        repository.insertProject(n_process, nme, expected_sale, effective_sale, effective_purchase);
    }
}
