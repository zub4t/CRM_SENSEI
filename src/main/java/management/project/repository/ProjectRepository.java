/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.project.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import management.employee.model.EmployeeModel;
import management.project.model.ProjectEmployeeTime;
import management.project.model.ProjectModel;
import util.DBManager;

/**
 *
 * @author marco
 */
public class ProjectRepository {

    public List<ProjectModel> getAll() {
        List<ProjectModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from project;");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProjectModel model = new ProjectModel();
                model.setId(rs.getInt("id"));
                model.setCustomer_nme(rs.getString("customer_nme"));
                model.setN_process(rs.getString("n_process"));
                model.setExpected_sale(rs.getFloat("expected_sale"));
                model.setEffective_sale(rs.getFloat("effective_sale"));
                model.setEffective_purchase(rs.getFloat("effective_purchase"));
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

    public ProjectModel getById(int id) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        ProjectModel model = new ProjectModel();
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from project where id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                model.setId(rs.getInt("id"));
                model.setCustomer_nme(rs.getString("customer_nme"));
                model.setN_process(rs.getString("n_process"));
                model.setExpected_sale(rs.getFloat("expected_sale"));
                model.setEffective_sale(rs.getFloat("effective_sale"));
                model.setEffective_purchase(rs.getFloat("effective_purchase"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
        return model;
    }

    public void insertProject(String n_process, String nme, float expected_sale, float effective_sale, float effective_purchase, float honorary) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, "insert into project (n_process,customer_nme,expected_sale,effective_sale,effective_purchase,honorary) values(?,?,?,?,?,?)");
            pstmt.setString(1, n_process);
            pstmt.setString(2, nme);
            pstmt.setFloat(3, expected_sale);
            pstmt.setFloat(4, effective_sale);
            pstmt.setFloat(5, effective_purchase);
            pstmt.setFloat(6, honorary);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
    }

    public List<ProjectEmployeeTime> getAllProjectEmployeeTime(String id) {
        List<ProjectEmployeeTime> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmtt = null;
        try {
            pstmtt = DBManager.getPreparedStatement(con, "SELECT n_process, HOUR(SEC_TO_TIME(SUM(TIME_TO_SEC(spend_time)))) AS time_spent, nme as performer from project_employee inner join project on project_employee.project_id = project.id INNER JOIN employee ON project_employee.employee_id = employee.id WHERE project.id = ? GROUP BY project.id,employee.id;");
            pstmtt.setString(1, id);
            ResultSet rs = pstmtt.executeQuery();
            while (rs.next()) {
                ProjectEmployeeTime model = new ProjectEmployeeTime();
                model.setN_process(rs.getString("n_process"));
                model.setTime_spent(rs.getLong("time_spent"));
                model.setEmployee(rs.getString("performer"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmtt);
            DBManager.closeConnection(con);
        }
        return list;
    }

    public ProjectModel updateProject(int id, String n_process, String nme, float expected_sale, float effective_sale, float effective_purchase) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        ProjectModel projectModel = getById(id);
        try {
            pstmt = DBManager.getPreparedStatement(con, "update project SET n_process = ?, customer_nme = ?, expected_sale = ?, effective_sale = ?, effective_purchase = ? where id = ?");
            pstmt.setString(1, n_process);
            pstmt.setString(2, nme);
            pstmt.setFloat(3, expected_sale);
            pstmt.setFloat(4, effective_sale);
            pstmt.setFloat(5, effective_purchase);
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
            projectModel.setCustomer_nme(nme);
            projectModel.setN_process(n_process);
            projectModel.setExpected_sale(expected_sale);
            projectModel.setEffective_sale(effective_sale);
            projectModel.setEffective_purchase(effective_purchase);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
            return projectModel;
        }
    }

    public void remove(int id) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "delete from project_employee where project_id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt = DBManager.getPreparedStatement(con, "delete from project where id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
    }

    public List<ProjectModel> getN(int n) {
        List<ProjectModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from project limit " + (n * 20) + " , 20");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProjectModel model = new ProjectModel();
                model.setId(rs.getInt("id"));
                model.setCustomer_nme(rs.getString("customer_nme"));
                model.setN_process(rs.getString("n_process"));
                model.setExpected_sale(rs.getFloat("expected_sale"));
                model.setEffective_sale(rs.getFloat("effective_sale"));
                model.setEffective_purchase(rs.getFloat("effective_purchase"));
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
}
