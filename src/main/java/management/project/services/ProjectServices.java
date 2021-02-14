/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.project.services;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import management.project.model.ProjectEmployeeTime;
import management.project.model.ProjectModel;
import management.project.repository.ProjectRepository;
import util.PaginationModel;

/**
 *
 * @author marco
 */
public class ProjectServices {

    public void setListOfAllPrj(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("projectList", new ProjectRepository().getAll());
    }

    public void insert(HttpServletRequest req) {
        ProjectRepository repository = new ProjectRepository();
        String n_process = req.getParameter("n_process");
        String nme = req.getParameter("nme");
        float expected_sale = Float.parseFloat(req.getParameter("expected_sale"));
        float effective_sale = Float.parseFloat(req.getParameter("effective_sale"));
        float effective_purchase = Float.parseFloat(req.getParameter("effective_purchase"));
        float honorary = Float.parseFloat(req.getParameter("honorary"));

        repository.insertProject(n_process, nme, expected_sale, effective_sale, effective_purchase, honorary);
    }

    public ProjectModel update(HttpServletRequest req) {
        ProjectRepository repository = new ProjectRepository();
        int id = Integer.parseInt(req.getParameter("projectId"));
        String n_process = req.getParameter("n_process");
        String nme = req.getParameter("nme");
        float expected_sale = Float.parseFloat(req.getParameter("expected_sale"));
        float effective_sale = Float.parseFloat(req.getParameter("effective_sale"));
        float effective_purchase = Float.parseFloat(req.getParameter("effective_purchase"));
        return repository.updateProject(id, n_process, nme, expected_sale, effective_sale, effective_purchase);
    }

    public void setProjects(HttpServletRequest req, HttpServletResponse resp, int n) {
        ProjectRepository repository = new ProjectRepository();
        PaginationModel pagination = new PaginationModel();
        pagination.setPage(n);
        req.setAttribute("pagination", pagination);
        pagination.setUrl("/CRM_SENSEI/ProjectController?pwhat=pagination");

        req.setAttribute("projectList", repository.getN(n));
    }

    public List<ProjectEmployeeTime> getProjectEmployees(String id) {
        ProjectRepository repository = new ProjectRepository();
        return repository.getAllProjectEmployeeTime(id);
    }

    public ProjectModel getById(int id) {
        ProjectRepository repository = new ProjectRepository();
        return repository.getById(id);
    }

    public void remove(HttpServletRequest req) {
        ProjectRepository repository = new ProjectRepository();
        int id = Integer.parseInt(req.getParameter("projectId"));
        repository.remove(id);
    }
    
    public int getMaxPage() {
        ProjectRepository repository = new ProjectRepository();
        return repository.getMaxPage();

    }
}
