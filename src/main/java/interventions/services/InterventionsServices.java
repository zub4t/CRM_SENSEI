/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interventions.services;

import interventions.repository.InterventionsRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import management.employee.repository.EmployeeRepository;
import management.project.repository.ProjectRepository;

/**
 *
 * @author marco
 */
public class InterventionsServices {

    public void setListOfAllInterventions(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("list_interventions", new InterventionsRepository().getAll());
    }

    public void insert(HttpServletRequest req) {
        InterventionsRepository repository = new InterventionsRepository();
        int project_id = Integer.parseInt(req.getParameter("project_id"));
        HttpSession session = req.getSession();
        int employee_id = Integer.parseInt(session.getAttribute("userId").toString());
        int assingment_id = Integer.parseInt(req.getParameter("assingment_id"));
        String spend_time = req.getParameter("spend_time");
        String dsc = req.getParameter("dsc");
        repository.insertInterventions(project_id, employee_id, assingment_id, spend_time, dsc);
    }
}
