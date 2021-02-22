/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interventions.services;

import interventions.model.InterventionsModel;
import interventions.repository.InterventionsRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.PaginationModel;

/**
 *
 * @author marco
 */
public class InterventionsServices {

    public void setListOfAllInterventions(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("list_interventions", new InterventionsRepository().getAll());
        int max = getMaxPage();
        PaginationModel pagination = new PaginationModel();
        pagination.setPage(1);
        pagination.setMax_page(max + 1);
        req.setAttribute("pagination", pagination);
        pagination.setUrl("/CRM_SENSEI_EXTERNAL/InterventionsController?pwhat=pagination");
        req.setAttribute("pagination", pagination);

    }

    public void setInterventions(HttpServletRequest req, HttpServletResponse resp, int n) {
        int max = getMaxPage();
        InterventionsRepository repository = new InterventionsRepository();
        PaginationModel pagination = new PaginationModel();
        pagination.setPage(n + 1);
        pagination.setMax_page(max + 1);
        req.setAttribute("pagination", pagination);
        pagination.setUrl("/CRM_SENSEI_EXTERNAL/InterventionsController?pwhat=pagination");

        req.setAttribute("interventionList", repository.getN(n));
    }

    public void insert(HttpServletRequest req) {
        InterventionsRepository repository = new InterventionsRepository();
        int project_id = Integer.parseInt(req.getParameter("project_id"));
        HttpSession session = req.getSession();
        int employee_id = Integer.parseInt(session.getAttribute("userId").toString());
        int assingment_id = Integer.parseInt(req.getParameter("assingment_id"));
        String spend_time = req.getParameter("spend_time");
        String dsc = req.getParameter("dsc");
        String dte = req.getParameter("date_in");

        repository.insertInterventions(project_id, employee_id, assingment_id, spend_time, dsc,dte);
    }

    public InterventionsModel getById(int id) {
        InterventionsRepository repository = new InterventionsRepository();
        return repository.getById(id);
    }

    public void remove(int id) {
        InterventionsRepository repository = new InterventionsRepository();

        repository.remove(id);
    }

    public void update(HttpServletRequest req) {
        InterventionsRepository repository = new InterventionsRepository();
        int id = Integer.parseInt(req.getParameter("id"));
        int project_id = Integer.parseInt(req.getParameter("project_id"));
        HttpSession session = req.getSession();
        int employee_id = Integer.parseInt(session.getAttribute("userId").toString());
        int assingment_id = Integer.parseInt(req.getParameter("assingment_id"));
        String spend_time = req.getParameter("spend_time");
        String dsc = req.getParameter("dsc");
        repository.updateInterventions(id, project_id, employee_id, assingment_id, spend_time, dsc);

    }

    public int getMaxPage() {
        InterventionsRepository repository = new InterventionsRepository();
        return repository.getMaxPage();

    }
}
