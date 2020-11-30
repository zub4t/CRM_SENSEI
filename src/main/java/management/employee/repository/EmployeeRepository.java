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

    public EmployeeModel getById(int id) {
        EmployeeModel model = new EmployeeModel();

        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from employee where id=?;");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                model.setId(rs.getInt("id"));
                model.setNme(rs.getString("nme"));
                model.setTel(rs.getString("tel"));
                model.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
        return model;
    }

    public int checkEmployeeAccount(String nickname, String pass) {
        int id = 0;
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "SELECT id FROM usr WHERE usrnme = ? AND pass = MD5(?);");
            pstmt.setString(1, nickname);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
            return id;
        }
    }

    public void insertEmployee(String nme, String tel, String email, String salary, String nickname, String pass) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, "insert into employee (nme,tel,email,salary) values(?,?,?,?)");
            pstmt.setString(1, nme);
            pstmt.setString(2, tel);
            pstmt.setString(3, email);
            pstmt.setString(4, salary);
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            int last_inserted_id = 0;
            if (rs.next()) {
                last_inserted_id = rs.getInt(1);
            }
            pstmt = DBManager.getPreparedStatement(con, "INSERT INTO usr (id,usrnme, pass) VALUES (?,?, MD5(?));");
            pstmt.setInt(1, last_inserted_id);
            pstmt.setString(2, nickname);
            pstmt.setString(3, pass);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }

    }
}
