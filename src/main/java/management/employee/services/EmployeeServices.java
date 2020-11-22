/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.employee.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import management.employee.repository.EmployeeRepository;

/**
 *
 * @author marco
 */
public class EmployeeServices {

    public void setListOfAllEmployes(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("list", new EmployeeRepository().getAll());
    }

    public void insert(HttpServletRequest req) {
        EmployeeRepository repository = new EmployeeRepository();
        String nme = req.getParameter("nme");
        String tel = req.getParameter("tel");
        String email = req.getParameter("email");
        String nickname = req.getParameter("nickname");
        String pass = req.getParameterValues("pass")[0];
        repository.insertEmployee(nme, tel, email, nickname, pass);
    }
    
    public boolean login(HttpServletRequest req){
        EmployeeRepository repository = new EmployeeRepository();
        String nickname = req.getParameter("nickname");
        String pass = req.getParameter("pass");
        return repository.checkEmployeeAccount(nickname, pass);
    }

}
