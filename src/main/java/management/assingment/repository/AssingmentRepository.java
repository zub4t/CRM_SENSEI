package management.assingment.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import management.assingment.model.AssingmentModel;
import management.employee.model.EmployeeModel;
import util.DBManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author marco
 */
public class AssingmentRepository {

    public List<AssingmentModel> getAll() {
        List<AssingmentModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from assingment;");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                AssingmentModel model = new AssingmentModel();
                model.setId(rs.getInt("id"));
                model.setDsc(rs.getString("dsc"));
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

    public AssingmentModel getById(int id) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        AssingmentModel model = new AssingmentModel();

        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from assingment where id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                model.setId(rs.getInt("id"));
                model.setDsc(rs.getString("dsc"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
        return model;
    }

    public void insertAssingment(String dsc) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, "insert into assingment (dsc) values(?)");
            pstmt.setString(1, dsc);
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
            pstmt = DBManager.getPreparedStatement(con, "delete from project_employee where assingment_id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt = DBManager.getPreparedStatement(con, "delete from assingment where id = ?");
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
