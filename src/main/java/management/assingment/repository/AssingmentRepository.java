package management.assingment.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import management.assingment.model.AssingmentModel;
import management.employee.model.EmployeeModel;
import org.json.JSONObject;
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
            pstmt = DBManager.getPreparedStatement(con, "select * from assingment order by ord;");
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
                model.setColor(rs.getString("color"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
        return model;
    }

    public void insertAssingment(String dsc, String color) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, "insert into assingment (dsc,color) values(?,?)");
            pstmt.setString(1, dsc);
            pstmt.setString(2, color);

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

    public List<AssingmentModel> getN(int n) {
        List<AssingmentModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from assingment order by ord limit " + (n * 20) + " , 20");
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

    public int getMaxPage() {

        int max = 0;
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "SELECT count(*) max  from assingment;");

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

    public boolean setOrder(int size, JSONObject json) {
        boolean flag = true;
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        AssingmentModel model = new AssingmentModel();
        pstmt = DBManager.getPreparedStatement(con, "   SET FOREIGN_KEY_CHECKS=0;");

        try {
            pstmt.executeQuery();
            for (String key : json.keySet()) {
                int id = json.getInt(key);
                String update = "UPDATE assingment SET ord=? WHERE id=?";

                pstmt = DBManager.getPreparedStatement(con, update);
                pstmt.setString(1, key);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();

            }
            pstmt = DBManager.getPreparedStatement(con, "   SET FOREIGN_KEY_CHECKS=1;");
            pstmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);

        }
        return flag;
    }

    public void update(String dsc, String color, int id) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, "update  assingment set dsc=?, color=? where id = ?");
            pstmt.setString(1, dsc);
            pstmt.setString(2, color);
            pstmt.setInt(3, id);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
    }
}
