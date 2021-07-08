/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.project.services;

import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import management.project.model.ProjectEmployeeTime;
import management.project.model.ProjectModel;
import management.project.model.ProjectModelCardView;
import management.project.repository.ProjectRepository;
import util.PaginationModel;

/**
 *
 * @author marco
 */
public class ProjectServices {

    public void setListOfModelProjectsByUser(HttpServletRequest req, HttpServletResponse resp) {
        int id = (int) req.getSession().getAttribute("userId");
        ProjectRepository repository = new ProjectRepository();
        List<ProjectModelCardView> list = repository.getProjectsByUserForCardView(id);
        req.setAttribute("projects_in_working", list);
    }

    public void setListOfAllPrj(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("projectList", new ProjectRepository().getAll());
    }

    public void insert(HttpServletRequest req) {
        ProjectRepository repository = new ProjectRepository();
        String n_process = req.getParameter("n_process");
        String nme = req.getParameter("nme");
        int client_id = Integer.parseInt(req.getParameter("client_id"));
        float expected_sale = Float.parseFloat(req.getParameter("expected_sale"));
        float effective_sale = Float.parseFloat(req.getParameter("effective_sale"));
        float effective_purchase = Float.parseFloat(req.getParameter("effective_purchase"));
        float honorary = Float.parseFloat(req.getParameter("honorary"));

        repository.insertProject(client_id, n_process, nme, expected_sale, effective_sale, effective_purchase, honorary);
    }

    public ProjectModel update(HttpServletRequest req) {
        ProjectRepository repository = new ProjectRepository();
        int id = Integer.parseInt(req.getParameter("projectId"));
        String n_process = req.getParameter("n_process");
        String nme = req.getParameter("nme");
        int client_id = Integer.parseInt(req.getParameter("client_id"));

        float expected_sale = Float.parseFloat(req.getParameter("expected_sale"));
        float effective_sale = Float.parseFloat(req.getParameter("effective_sale"));
        float effective_purchase = Float.parseFloat(req.getParameter("effective_purchase"));
        float honorary = Float.parseFloat(req.getParameter("honorary"));

        return repository.updateProject(client_id, id, n_process, nme, expected_sale, effective_sale, effective_purchase, honorary);
    }

    public void setProjects(HttpServletRequest req, HttpServletResponse resp, int n) {
        ProjectRepository repository = new ProjectRepository();
        PaginationModel pagination = new PaginationModel();
        pagination.setPage(n + 1);
        pagination.setMax_page(getMaxPage() + 1);
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

    public List<String[]> getAllEmployeeByProject(int id) {
        ProjectRepository repository = new ProjectRepository();

        return repository.getAllEmployeeByProject(id);
    }

    public Set<String> getAllEmployeeByProjectSet(int id) {
        ProjectRepository repository = new ProjectRepository();

        return repository.getAllEmployeeByProjectSet(id);
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
