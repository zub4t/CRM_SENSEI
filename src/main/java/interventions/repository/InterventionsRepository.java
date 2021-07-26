/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interventions.repository;

import interventions.model.InterventionsModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import management.assingment.repository.AssingmentRepository;
import management.employee.model.EmployeeModel;
import management.employee.repository.EmployeeRepository;
import management.project.model.ProjectModel;
import management.project.repository.ProjectRepository;
import util.DBManager;

/**
 *
 * @author marco
 */
public class InterventionsRepository {

    public List<InterventionsModel> getAll() {
        List<InterventionsModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from project_employee;");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                InterventionsModel model = new InterventionsModel();
                model.setProject_id(rs.getInt("project_id"));
                model.setEmployee_id(rs.getInt("employee_id"));
                model.setAssingment_id(rs.getInt("assingment_id"));
                model.setSpeend_time(rs.getString("spend_time"));
                model.setDsc(rs.getString("dsc"));
                model.setId(rs.getInt("id"));

                ProjectRepository prjR = new ProjectRepository();
                model.setPrj_nme((prjR.getById(model.getProject_id())).getN_process());

                EmployeeRepository employeeR = new EmployeeRepository();
                model.setEmployee_nme((employeeR.getById(model.getEmployee_id())).getNme());

                AssingmentRepository assingmentRepositoryR = new AssingmentRepository();
                model.setAssingment_nme((assingmentRepositoryR.getById(model.getAssingment_id())).getDsc());

                list.add(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
        return list;
    }

    public void insertInterventions(int project_id, int employee_id, int assingment_id, String spend_time, String dsc, String dte) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, "insert into project_employee (project_id,employee_id,assingment_id,spend_time,dsc,dte) values(?,?,?,?,?,?)");
            pstmt.setInt(1, project_id);
            pstmt.setInt(2, employee_id);
            pstmt.setInt(3, assingment_id);
            pstmt.setString(4, spend_time);
            pstmt.setString(5, dsc);
            pstmt.setString(6, dte);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }

    }

    public void remove(int id) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "delete from project_employee where id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
    }

    public InterventionsModel getById(int id) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        InterventionsModel model = new InterventionsModel();
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from project_employee where id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                model.setId(rs.getInt("id"));
                model.setProject_id(rs.getInt("project_id"));
                model.setEmployee_id(rs.getInt("employee_id"));
                model.setAssingment_id(rs.getInt("assingment_id"));
                model.setSpeend_time(rs.getString("spend_time"));
                model.setDsc(rs.getString("dsc"));
                //  String dte = rs.getString("dte").split("-")[2] + "/" + rs.getString("dte").split("-")[1] + "/" + rs.getString("dte").split("-")[0];
                model.setDate(rs.getString("dte"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
        return model;
    }

    public void updateInterventions(int id, int project_id, int employee_id, int assingment_id, String spend_time, String dsc) {

        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, "update  project_employee set project_id = ? ,employee_id=?,assingment_id=?,spend_time=?,dsc=?,dte=NOW() where id=?");
            pstmt.setInt(1, project_id);
            pstmt.setInt(2, employee_id);
            pstmt.setInt(3, assingment_id);
            pstmt.setString(4, spend_time);
            pstmt.setString(5, dsc);
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
    }

    public List<InterventionsModel> getN(int n) {
        List<InterventionsModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from project_employee inner join project  on project_employee.project_id = project.id order by project_employee.id DESC limit " + (n * 20) + " , 20 ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                InterventionsModel model = new InterventionsModel();
                model.setProject_id(rs.getInt("project_id"));
                model.setEmployee_id(rs.getInt("employee_id"));
                model.setAssingment_id(rs.getInt("assingment_id"));
                model.setSpeend_time(rs.getString("spend_time"));
                model.setDsc(rs.getString("dsc"));
                model.setId(rs.getInt("id"));
                model.setCustomer(rs.getString("customer_nme"));
                ProjectRepository prjR = new ProjectRepository();
                model.setPrj_nme((prjR.getById(model.getProject_id())).getN_process());

                EmployeeRepository employeeR = new EmployeeRepository();
                model.setEmployee_nme((employeeR.getById(model.getEmployee_id())).getNme());

                AssingmentRepository assingmentRepositoryR = new AssingmentRepository();
                model.setAssingment_nme((assingmentRepositoryR.getById(model.getAssingment_id())).getDsc());

                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
        return list;
    }

    public int getMaxPage() {

        int max = 0;
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "SELECT count(*) max  from project_employee;");

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                max = rs.getInt("max");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
            max = (int) (Math.ceil(max) / 20.0);
            return max;
        }
    }

    public Object getN(int n, String[] employee_selected, String assingment_id, String date_filter_in, String date_filter_out) {
        List<InterventionsModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            String where = " where ";

            if (employee_selected != null) {
                where += " employee_id in (";
                for (String str : employee_selected) {
                    where += "'" + str + "',";
                }
                where += "'0') and ";
            }
            if (assingment_id != null && !assingment_id.equals("-1")) {
                where += "assingment_id='" + assingment_id + "' and ";
            }
            if (date_filter_in != null) {
                where += "dte >= '" + date_filter_in + "' and ";
            }

            if (date_filter_out != null) {
                where += "dte <= '" + date_filter_out + "' and ";
            }
            where += " 1=1";
            pstmt = DBManager.getPreparedStatement(con, "select * from project_employee inner join project  on project_employee.project_id = project.id " + where + " order by project_employee.id DESC limit " + (n * 20) + " , 20 ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                InterventionsModel model = new InterventionsModel();
                model.setProject_id(rs.getInt("project_id"));
                model.setEmployee_id(rs.getInt("employee_id"));
                model.setAssingment_id(rs.getInt("assingment_id"));
                model.setSpeend_time(rs.getString("spend_time"));
                model.setDsc(rs.getString("dsc"));
                model.setId(rs.getInt("id"));
                model.setCustomer(rs.getString("customer_nme"));
                ProjectRepository prjR = new ProjectRepository();
                model.setPrj_nme((prjR.getById(model.getProject_id())).getN_process());

                EmployeeRepository employeeR = new EmployeeRepository();
                model.setEmployee_nme((employeeR.getById(model.getEmployee_id())).getNme());

                AssingmentRepository assingmentRepositoryR = new AssingmentRepository();
                model.setAssingment_nme((assingmentRepositoryR.getById(model.getAssingment_id())).getDsc());

                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
        return list;
    }

    public int getMaxPage(String[] employee_selected, String assingment_id, String date_filter_in, String date_filter_out) {

        String where = " where ";

        if (employee_selected != null) {
            where += " employee_id in (";
            for (String str : employee_selected) {
                where += "'" + str + "',";
            }
            where += "'0') and ";
        }
        if (assingment_id != null && !assingment_id.equals("-1")) {
            where += "assingment_id='" + assingment_id + "' and ";
        }
        if (date_filter_in != null) {
            where += "dte >= '" + date_filter_in + "' and ";
        }

        if (date_filter_out != null) {
            where += "dte <= '" + date_filter_out + "' and ";
        }
        where += " 1=1";
        int max = 0;
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "SELECT count(*) max  from project_employee inner join project  on project_employee.project_id = project.id " + where + " order by project_employee.id");

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                max = rs.getInt("max");
            }

        } catch (SQLException ex) {
            System.out.println("interventions.repository.InterventionsRepository.getMaxPage()");
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
            max = (int) (Math.ceil(max) / 20.0);

        }
        return max;

    }
}
