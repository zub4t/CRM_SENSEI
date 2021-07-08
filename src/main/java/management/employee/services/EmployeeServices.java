/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.employee.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import management.employee.model.EmployeeModel;
import management.employee.repository.EmployeeRepository;
import management.project.repository.ProjectRepository;
import util.PaginationModel;

/**
 *
 * @author marco
 */
public class EmployeeServices {
    
    public void setListOfAllEmployes(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("list", new EmployeeRepository().getAll());
    }
    
    public void setEmployee(HttpServletRequest req, HttpServletResponse resp, int n) {
        EmployeeRepository repository = new EmployeeRepository();
        PaginationModel pagination = new PaginationModel();
        pagination.setPage(n + 1);
        pagination.setMax_page(getMaxPage() + 1);
        req.setAttribute("pagination", pagination);
        pagination.setUrl("/CRM_SENSEI/EmployeeController?pwhat=pagination");
        
        req.setAttribute("employeeList", repository.getN(n));
    }
    
    public void insert(HttpServletRequest req) {
        EmployeeRepository repository = new EmployeeRepository();
        String nme = req.getParameter("nme");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");
        String salary = req.getParameter("salary");
        String nickname = req.getParameter("nickname");
        String pass = req.getParameterValues("pass")[0];
        String level = req.getParameter("userLevel");
        repository.insertEmployee(nme, tel, email, salary, nickname, pass, level);
    }
    
    public EmployeeModel update(HttpServletRequest req) {
        EmployeeRepository repository = new EmployeeRepository();
        int id = Integer.parseInt(req.getParameter("empId"));
        String nme = req.getParameter("nme");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");
        String salary = req.getParameter("salary");
        String level = req.getParameter("userLevel");
        
        return repository.updateEmployee(id, nme, tel, email, salary, level);
    }
    
    public int login(HttpServletRequest req) {
        EmployeeRepository repository = new EmployeeRepository();
        String nickname = req.getParameter("nickname");
        String pass = req.getParameter("pass");
        return repository.checkEmployeeAccount(nickname, pass);
    }
    
    public void setProjects(HttpServletRequest req, HttpServletResponse resp) {
        EmployeeRepository repository = new EmployeeRepository();
        req.setAttribute("employeeList", repository.getAll());
    }
    
    public EmployeeModel getById(int id) {
        EmployeeRepository repository = new EmployeeRepository();
        return repository.getById(id);
    }
    
    public EmployeeModel getByUsername(String username) {
        EmployeeRepository repository = new EmployeeRepository();
        return repository.getByUsername(username);
    }
    
    public boolean setNewPass(int id, String newPass) {
        EmployeeRepository repository = new EmployeeRepository();
        return repository.setNewPass(id, newPass);
    }
    
    public void remove(HttpServletRequest req) {
        EmployeeRepository repository = new EmployeeRepository();
        int id = Integer.parseInt(req.getParameter("id"));
        repository.removeEmployee(id);
    }
    
    public int getMaxPage() {
        EmployeeRepository repository = new EmployeeRepository();
        return repository.getMaxPage();
        
    }
    
}
