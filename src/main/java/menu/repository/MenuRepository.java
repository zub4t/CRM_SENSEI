/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu.repository;

import com.sun.javafx.scene.control.skin.VirtualFlow;
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

        try {
            PreparedStatement pstmt = DBManager.getPreparedStatement(con, "select * from main_menu where lvl= ? ");
            pstmt.setInt(1, lvl);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MenuModel model = new MenuModel();
                model.setId(rs.getInt("id"));
                model.setLvl(lvl);
                model.setNme(rs.getString("nme"));
                model.setParent_id(rs.getString("parent_id") == null ? 0 : rs.getInt("parent_id"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closeConnection(con);
        }
        return list;
    }
}
