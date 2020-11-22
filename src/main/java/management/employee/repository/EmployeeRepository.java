/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.employee.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import management.employee.model.EmployeeModel;
import util.DBManager;

/**
 *
 * @author marco
 */
public class EmployeeRepository {

    public List<EmployeeModel> getAll() {
        List<EmployeeModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from employee;");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                EmployeeModel model = new EmployeeModel();
                model.setId(rs.getInt("id"));
                model.setNme(rs.getString("nme"));
                model.setTel(rs.getString("tel"));
                model.setEmail(rs.getString("email"));
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

    public void insertEmployee(String nme, String tel, String email) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, "insert into employee (nme,tel,email) values(?,?,?)");
            pstmt.setString(1, nme);
            pstmt.setString(2, tel);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }

    }
}
