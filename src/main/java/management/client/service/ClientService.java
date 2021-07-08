/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.client.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import management.client.model.ClientModel;
import management.client.repository.ClientRepository;
import management.employee.model.EmployeeModel;
import management.employee.repository.EmployeeRepository;
import util.PaginationModel;

/**
 *
 * @author marco
 */
public class ClientService {

    ClientRepository repository = new ClientRepository();

    public void insert(HttpServletRequest req) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String num_contribuinte = req.getParameter("num_contribuinte");
        String tel = req.getParameter("tel");
        String location = req.getParameter("location");
        String address = req.getParameter("address");
        repository.insert(name, email, num_contribuinte, tel, location, address);

    }

    public ClientModel getById(String id) {
        return repository.getById(id);
    }

    public void setClient(HttpServletRequest req, HttpServletResponse resp, int n) {
        PaginationModel pagination = new PaginationModel();
        pagination.setPage(n + 1);
        pagination.setMax_page(getMaxPage() + 1);
        req.setAttribute("pagination", pagination);
        pagination.setUrl("/CRM_SENSEI/ClientController?pwhat=pagination");

        req.setAttribute("clientList", repository.getN(n));
    }

    public void setAll(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("clientListAll", repository.getAll());

    }

    public ClientModel update(HttpServletRequest req) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String num_contribuinte = req.getParameter("num_contribuinte");
        String tel = req.getParameter("tel");
        String location = req.getParameter("location");
        String address = req.getParameter("address");
        return repository.update(id, name, email, num_contribuinte, tel, location, address);
    }

    public void remove(HttpServletRequest req) {
        String id = req.getParameter("id");
        repository.remove(id);
    }

    public int getMaxPage() {
        return repository.getMaxPage();
    }

}
