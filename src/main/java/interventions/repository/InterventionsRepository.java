/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interventions.repository;

import interventions.model.InterventionsModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import management.assingment.repository.AssingmentRepository;
import management.employee.model.EmployeeModel;
import management.employee.repository.EmployeeRepository;
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

    public void insertInterventions(int project_id, int employee_id, int assingment_id, String spend_time, String dsc) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, "insert into project_employee (project_id,employee_id,assingment_id,spend_time,dsc,dte) values(?,?,?,?,?,NOW())");
            pstmt.setInt(1, project_id);
            pstmt.setInt(2, employee_id);
            pstmt.setInt(3, assingment_id);
            pstmt.setString(4, spend_time);
            pstmt.setString(5, dsc);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }

    }
}
