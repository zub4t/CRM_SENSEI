/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import menu.model.MenuModel;
import util.DBManager;

/**
 *
 * @author marco
 */
public class MenuRepository {

    public List<MenuModel> getByLvl(int lvl) {
        List<MenuModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from main_menu where lvl= ? ");
            pstmt.setInt(1, lvl);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MenuModel model = new MenuModel();
                model.setId(rs.getInt("id"));
                model.setLvl(lvl);
                model.setNme(rs.getString("nme"));
                model.setUrl(rs.getString("url"));
                model.setParent_id(rs.getString("parent_id") == null ? 0 : rs.getInt("parent_id"));
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

    public List<MenuModel> getByParent(int parent_id) {
        List<MenuModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from main_menu where parent_id= ? ");
            pstmt.setInt(1, parent_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MenuModel model = new MenuModel();
                model.setId(rs.getInt("id"));
                model.setLvl(rs.getInt("parent_id"));
                model.setNme(rs.getString("nme"));
                model.setUrl(rs.getString("url"));
                model.setParent_id(rs.getString("parent_id") == null ? 0 : rs.getInt("parent_id"));
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

    public MenuModel getById(int id) {
        MenuModel menu = null;
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from main_menu where id= ? ");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                menu = new MenuModel();
                menu.setId(rs.getInt("id"));
                menu.setLvl(rs.getInt("parent_id"));
                menu.setNme(rs.getString("nme"));
                menu.setUrl(rs.getString("url"));
                menu.setParent_id(rs.getString("parent_id") == null ? 0 : rs.getInt("parent_id"));
                menu.setUserLevel(rs.getInt("user_level"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
        return menu;
    }

    public List<MenuModel> getN(int n) {
        List<MenuModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from main_menu where lvl =0 order by nme limit " + (n * 20) + " , 20 ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MenuModel model = new MenuModel();
                model.setId(rs.getInt("id"));
                model.setLvl(rs.getInt("parent_id"));
                model.setNme(rs.getString("nme"));
                model.setUrl(rs.getString("url"));
                model.setParent_id(rs.getString("parent_id") == null ? 0 : rs.getInt("parent_id"));
                model.setUserLevel(rs.getInt("user_level"));
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

    public MenuModel update(int id, String name, String userLevel) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        MenuModel menuModel = getById(id);
        try {
            pstmt = DBManager.getPreparedStatement(con, "UPDATE main_menu SET nme = ? , user_level = ? where id = ?");
            pstmt.setString(1, name);
            pstmt.setString(2, userLevel);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            menuModel.setNme(name);
            menuModel.setUserLevel(Integer.parseInt(userLevel));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
            return menuModel;
        }
    }

    public int getUserLevelById(int id) {
        int userLevel = 0;
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select user_level from main_menu where id=?;");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                userLevel = rs.getInt("user_level");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
        return userLevel;

    }
     public int getMaxPage() {

        int max = 0;
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "SELECT count(*) max  from main_menu where `lvl`!=0;");

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
}
