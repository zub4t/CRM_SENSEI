/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class DBManager {

    public static List<Connection> connection_list = new ArrayList<>();

    public static PreparedStatement getPreparedStatement(int con, String sql_cod) {
        try {
            PreparedStatement pstmt = connection_list.get(con).prepareStatement(sql_cod, Statement.RETURN_GENERATED_KEYS);
            return pstmt;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static int getConnetion() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String BD_URL = "jdbc:mysql://mouraazevedo.dyndns.org:3306/crm?useTimezone=true&serverTimezone=UTC&user=monty&password=marco";
            Connection con = DriverManager.getConnection(BD_URL);
            connection_list.add(con);
            return connection_list.size() - 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    public static void closeConnection(int i) {
        try {
            connection_list.get(i).close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void closePstmt(PreparedStatement pstmt) {
        try {
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
