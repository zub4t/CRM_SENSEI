/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedule.repository;

import interventions.model.InterventionsModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import management.assingment.repository.AssingmentRepository;
import management.employee.repository.EmployeeRepository;
import management.project.repository.ProjectRepository;
import schedule.model.ScheduleModel;
import util.DBManager;

/**
 *
 * @author Marco
 */
public class ScheduleRepository {

    public int insert(ScheduleModel model) {

        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, "insert into calendar (project_id,employee_id,assingment_id,dsc,str_date,end_date) values(?,?,?,?,?,?)");
            pstmt.setInt(1, model.getProject_id());
            pstmt.setInt(2, model.getEmployee_id());
            pstmt.setInt(3, model.getAssignment_id());
            pstmt.setString(4, model.getDsc());
            pstmt.setString(5, model.getStr_dte());
            pstmt.setString(6, model.getEnd_dte());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);

        }
        return -1;
    }

    public void update(ScheduleModel model) {

        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, "update  calendar set project_id=?, employee_id = ? ,assingment_id=?,dsc=?,str_date=?,end_date=? where id=?");
            pstmt.setInt(1, model.getProject_id());
            pstmt.setInt(2, model.getEmployee_id());
            pstmt.setInt(3, model.getAssignment_id());
            pstmt.setString(4, model.getDsc());
            pstmt.setString(5, model.getStr_dte());
            pstmt.setString(6, model.getEnd_dte());
            pstmt.setInt(7, model.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
    }

    public List<ScheduleModel> getByYear(int year) {
        List<ScheduleModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from calendar inner join assingment on assingment.id = assingment_id inner join employee on employee_id = employee.id inner join project on project.id = project_id  where YEAR(str_date) = '" + year + "';");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ScheduleModel model = new ScheduleModel();
                model.setId(rs.getInt("id"));
                model.setAssignment_id(rs.getInt("assingment_id"));
                model.setEmployee_id(rs.getInt("employee_id"));
                model.setDsc(rs.getString("dsc"));
                model.setStr_dte(rs.getString("str_date"));
                model.setEnd_dte(rs.getString("end_date"));
                model.setAssignment_name(rs.getString("assingment.dsc"));
                model.setEmployee_name(rs.getString("employee.nme"));
                model.setProject_id(rs.getInt("project.id"));
                model.setProject_name(rs.getString("project.customer_nme"));

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

    public void remove(int id) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "delete from calendar where id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
    }

}
