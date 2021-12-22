/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.client.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import management.client.model.ClientModel;
import management.employee.model.EmployeeModel;
import util.DBManager;

/**
 *
 * @author marco
 */
public class ClientRepository {

    public void insert(String name, String email, String num_contribuinte, String tel, String location, String address) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, "insert into clientt (nme,tel,email,num_contribuinte,location,address) values(?,?,?,?,?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, tel);
            pstmt.setString(3, email);
            pstmt.setString(4, num_contribuinte);
            pstmt.setString(5, location);
            pstmt.setString(6, address);

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
    }

    public ClientModel getById(String id) {
        ClientModel model = new ClientModel();

        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from clientt  where id=?;");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                model.setId(rs.getString("id"));
                model.setName(rs.getString("nme"));
                model.setTel(rs.getString("tel"));
                model.setEmail(rs.getString("email"));
                model.setNum_contribuinte(rs.getString("num_contribuinte"));
                model.setLocation(rs.getString("location"));
                model.setAddress(rs.getString("address"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
        return model;
    }

    public ClientModel update(String id, String name, String email, String num_contribuinte, String tel, String location, String address) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        ClientModel model = getById(id);
        try {
            pstmt = DBManager.getPreparedStatement(con, "UPDATE clientt SET nme = ? , tel = ?, email = ?, num_contribuinte = ? , location = ? , address = ?  where id = ?");
            pstmt.setString(1, name);
            pstmt.setString(2, tel);
            pstmt.setString(3, email);
            pstmt.setString(4, num_contribuinte);
            pstmt.setString(5, location);
            pstmt.setString(6, address);
            pstmt.setString(7, id);

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
            return model;
        }
    }

    public void remove(String id) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {

            pstmt = DBManager.getPreparedStatement(con, "DELETE FROM clientt WHERE id = ?");
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
    }

    public List<ClientModel> getN(int n) {
        List<ClientModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from clientt order by nme ASC  limit " + (n * 20) + " , 20");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ClientModel model = new ClientModel();
                model.setId(rs.getString("id"));
                model.setName(rs.getString("nme"));
                model.setTel(rs.getString("tel"));
                model.setEmail(rs.getString("email"));
                model.setNum_contribuinte(rs.getString("num_contribuinte"));
                model.setAddress(rs.getString("address"));
                model.setLocation(rs.getString("location"));
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
            pstmt = DBManager.getPreparedStatement(con, "SELECT count(*) max  from clientt;");

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

    public List<ClientModel> getAll() {
        List<ClientModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from clientt ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ClientModel model = new ClientModel();
                model.setId(rs.getString("id"));
                model.setName(rs.getString("nme"));
                model.setTel(rs.getString("tel"));
                model.setEmail(rs.getString("email"));
                model.setNum_contribuinte(rs.getString("num_contribuinte"));
                model.setAddress(rs.getString("address"));
                model.setLocation(rs.getString("location"));
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
