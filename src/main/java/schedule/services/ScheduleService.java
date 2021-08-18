/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedule.services;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import schedule.model.ScheduleModel;
import schedule.repository.ScheduleRepository;

/**
 *
 * @author Marco
 */
public class ScheduleService {

    ScheduleRepository repo = new ScheduleRepository();

    public int insert(HttpServletRequest req) {
        HttpSession session = req.getSession();
        ScheduleModel model = new ScheduleModel();

        int assingment_id = Integer.parseInt(req.getParameter("assingment_id"));
        int employee_id = (int) session.getAttribute("userId");
        int prjct_selected = Integer.parseInt(req.getParameter("prjct_selected"));

        String str_date = req.getParameter("event-start-date");

        String str_date_day = str_date.split("/")[1];
        String str_date_month = str_date.split("/")[0];
        String str_date_year = str_date.split("/")[2];
        str_date = str_date_year + "-" + str_date_month + "-" + str_date_day;

        String end_date = req.getParameter("event-end-date");

        String end_date_day = end_date.split("/")[1];
        String end_date_month = end_date.split("/")[0];
        String end_date_year = end_date.split("/")[2];
        end_date = end_date_year + "-" + end_date_month + "-" + end_date_day;

        String dsc = req.getParameter("dsc");

        model.setAssignment_id(assingment_id);
        model.setEmployee_id(employee_id);
        model.setStr_dte(str_date);
        model.setEnd_dte(end_date);
        model.setDsc(dsc);
        model.setProject_id(prjct_selected);
        return repo.insert(model);
    }

    public void remove(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        repo.remove(id);
    }

    public List<ScheduleModel> getByYear(int year) {
        return repo.getByYear(year);
    }

    public void update(HttpServletRequest req) {
        ScheduleModel model = new ScheduleModel();
        HttpSession session = req.getSession();

        int id = Integer.parseInt(req.getParameter("id"));

        int assingment_id = Integer.parseInt(req.getParameter("assingment_id"));
        int employee_id = (int) session.getAttribute("userId");
        int prjct_selected = Integer.parseInt(req.getParameter("prjct_selected"));

        String str_date = req.getParameter("event-start-date");
        String end_date = req.getParameter("event-end-date");

        String str_date_day = str_date.split("/")[1];
        String str_date_month = str_date.split("/")[0];
        String str_date_year = str_date.split("/")[2];
        str_date = str_date_year + "-" + str_date_month + "-" + str_date_day;

        String end_date_day = end_date.split("/")[1];
        String end_date_month = end_date.split("/")[0];
        String end_date_year = end_date.split("/")[2];
        end_date = end_date_year + "-" + end_date_month + "-" + end_date_day;

        String dsc = req.getParameter("dsc");

        model.setAssignment_id(assingment_id);
        model.setEmployee_id(employee_id);
        model.setStr_dte(str_date);
        model.setEnd_dte(end_date);
        model.setDsc(dsc);
        model.setProject_id(prjct_selected);
        model.setId(id);
        repo.update(model);
    }

}
