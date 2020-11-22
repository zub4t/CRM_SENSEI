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

}
