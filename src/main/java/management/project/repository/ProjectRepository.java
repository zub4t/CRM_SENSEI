/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.project.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import management.employee.model.EmployeeModel;
import management.employee.services.EmployeeServices;
import management.project.model.ProjectEmployeeTime;
import management.project.model.ProjectModel;
import management.project.model.ProjectModelCardView;
import menu.repository.MenuRepository;
import menu.services.MenuServices;
import util.DBManager;

/**
 *
 * @author marco
 */
public class ProjectRepository {

    public List<ProjectModel> getAll() {
        List<ProjectModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from project order by customer_nme;");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProjectModel model = new ProjectModel();
                model.setId(rs.getInt("id"));
                model.setCustomer_nme(rs.getString("customer_nme"));
                model.setN_process(rs.getString("n_process"));
                model.setExpected_sale(rs.getFloat("expected_sale"));
                model.setEffective_sale(rs.getFloat("effective_sale"));
                model.setEffective_purchase(rs.getFloat("effective_purchase"));
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

    public ProjectModel getById(int id) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        ProjectModel model = new ProjectModel();
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from project where id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                model.setCtr_date(rs.getString("ctr_date"));
                model.setId(rs.getInt("id"));
                model.setClient_id(rs.getInt("clientt_id"));
                model.setCustomer_nme(rs.getString("customer_nme"));
                model.setN_process(rs.getString("n_process"));
                model.setExpected_sale(rs.getFloat("expected_sale"));
                model.setEffective_sale(rs.getFloat("effective_sale"));
                model.setEffective_purchase(rs.getFloat("effective_purchase"));
                model.setHonorary(rs.getFloat("honorary"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
        return model;
    }

    public void insertProject(int client_id, String n_process, String nme, float expected_sale, float effective_sale, float effective_purchase, float honorary) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, "insert into project (clientt_id,n_process,customer_nme,expected_sale,effective_sale,effective_purchase,honorary) values(?,?,?,?,?,?,?)");
            pstmt.setInt(1, client_id);
            pstmt.setString(2, n_process);
            pstmt.setString(3, nme);
            pstmt.setFloat(4, expected_sale);
            pstmt.setFloat(5, effective_sale);
            pstmt.setFloat(6, effective_purchase);
            pstmt.setFloat(7, honorary);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
    }

    public List<ProjectEmployeeTime> getAllProjectEmployeeTime(String id) {
        List<ProjectEmployeeTime> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmtt = null;
        try {
            pstmtt = DBManager.getPreparedStatement(con, "SELECT n_process, HOUR(SEC_TO_TIME(SUM(TIME_TO_SEC(spend_time)))) AS time_spent, nme as performer from project_employee inner join project on project_employee.project_id = project.id INNER JOIN employee ON project_employee.employee_id = employee.id WHERE project.id = ? GROUP BY project.id,employee.id;");
            pstmtt.setString(1, id);
            ResultSet rs = pstmtt.executeQuery();
            while (rs.next()) {
                ProjectEmployeeTime model = new ProjectEmployeeTime();
                model.setN_process(rs.getString("n_process"));
                model.setTime_spent(rs.getLong("time_spent"));
                model.setEmployee(rs.getString("performer"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmtt);
            DBManager.closeConnection(con);
        }
        return list;
    }

    public ProjectModel updateProject(int client_id, int id, String n_process, String nme, float expected_sale, float effective_sale, float effective_purchase, float honorary) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        ProjectModel projectModel = getById(id);
        try {
            pstmt = DBManager.getPreparedStatement(con, "update project SET clientt_id = ?, n_process = ?, customer_nme = ?, expected_sale = ?, effective_sale = ?, effective_purchase = ? , honorary = ? where id = ?");
            pstmt.setInt(1, client_id);
            pstmt.setString(2, n_process);
            pstmt.setString(3, nme);
            pstmt.setFloat(4, expected_sale);
            pstmt.setFloat(5, effective_sale);
            pstmt.setFloat(6, effective_purchase);
            pstmt.setFloat(7, honorary);
            pstmt.setInt(8, id);
            pstmt.executeUpdate();
            projectModel.setCustomer_nme(nme);
            projectModel.setN_process(n_process);
            projectModel.setExpected_sale(expected_sale);
            projectModel.setEffective_sale(effective_sale);
            projectModel.setEffective_purchase(effective_purchase);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
            return projectModel;
        }
    }

    public void remove(int id) {
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "delete from project_employee where project_id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt = DBManager.getPreparedStatement(con, "delete from project where id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
    }

    public List<ProjectModel> getN(int n) {
        List<ProjectModel> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        try {
            pstmt = DBManager.getPreparedStatement(con, "select * from project order by id DESC limit " + (n * 20) + " , 20");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProjectModel model = new ProjectModel();
                model.setId(rs.getInt("id"));
                model.setCustomer_nme(rs.getString("customer_nme"));
                model.setN_process(rs.getString("n_process"));
                model.setExpected_sale(rs.getFloat("expected_sale"));
                model.setEffective_sale(rs.getFloat("effective_sale"));
                model.setEffective_purchase(rs.getFloat("effective_purchase"));
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
            pstmt = DBManager.getPreparedStatement(con, "SELECT count(*) max  from project;");

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

    public Set<String> getAllEmployeeByProjectSet(int id) {

        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        Set<String> set = new TreeSet<>();
        try {
            pstmt = DBManager.getPreparedStatement(con, "select nme , assingment.dsc from project_employee inner join employee on employee_id = employee.id inner join assingment on assingment_id= assingment.id where project_id = ?  order by project_employee.id desc");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                set.add(rs.getString("nme"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
            return set;
        }
    }

    public List<String[]> getAllEmployeeByProject(int id) {

        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        List<String[]> list = new ArrayList<>();
        try {
            pstmt = DBManager.getPreparedStatement(con, "select nme , assingment.dsc from project_employee inner join employee on employee_id = employee.id inner join assingment on assingment_id= assingment.id where project_id = ?  order by project_employee.id desc");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new String[]{rs.getString("nme"), rs.getString("dsc")});

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
            return list;
        }
    }

    public List<ProjectModelCardView> getProjectsByUserForCardView(int id) {
        List<ProjectModelCardView> list = new ArrayList<>();
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        String adminView = "";
        MenuRepository repository = new MenuRepository();
        if (repository.getUserLevelById(id) == 0) {
            adminView = "or 1=1";
        }

        try {
            pstmt = DBManager.getPreparedStatement(con, "SELECT \n"
                    + "    n_process,\n"
                    + "    customer_nme,\n"
                    + "    project_id AS proj_id,\n"
                    + "    (SELECT SEC_TO_TIME(SUM(TIME_TO_SEC(spend_time))) FROM project_employee WHERE project_employee.project_id = t.project_id GROUP BY project_employee.project_id ) \n"
                    + "    total_hours,\n"
                    + "    DATE(ctr_date)  ctr_date\n"
                    + " \n"
                    + "FROM\n"
                    + "    (SELECT \n"
                    + "        n_process,\n"
                    + "        customer_nme,\n"
                    + "        project_id,\n"
                    + "            nme,\n"
                    + "            SUM(TIME_TO_SEC(spend_time)) * (salary / 3600) AS costByProjectFunc,\n"
                    + "            honorary,\n"
                    + "            expected_sale,\n"
                    + "            effective_sale,\n"
                    + "            effective_purchase,\n"
                    + "            ctr_date\n"
                    + "    FROM\n"
                    + "        project_employee\n"
                    + "    INNER JOIN project ON project_employee.project_id = project.id \n"
                    + "    INNER JOIN employee ON project_employee.employee_id = employee.id \n"
                    + "	where employee.id  in (?)" + adminView + " and 1=1     GROUP BY project_id , employee_id) AS t\n"
                    + "GROUP BY project_id;\n"
                    + "");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProjectModelCardView model = new ProjectModelCardView();
                model.setId(rs.getInt("proj_id"));
                model.setCod(rs.getString("n_process"));
                model.setStart_date(rs.getString("ctr_date"));
                model.setTitle(rs.getString("customer_nme"));
                model.setEnd_date("9999-99-99");
                model.setTotal_hours(rs.getString("total_hours"));
                pstmt = DBManager.getPreparedStatement(con, "SELECT  IFNULL(SEC_TO_TIME(SUM(TIME_TO_SEC(spend_time))),'00:00:00') week_hours FROM project_employee WHERE project_id = ? AND employee_id = ? AND YEARWEEK(dte, 1) = YEARWEEK(CURDATE(), 1)");
                pstmt.setString(1, rs.getString("proj_id"));
                pstmt.setInt(2, id);
                ResultSet rs1 = pstmt.executeQuery();
                rs1.next();
                model.setWeek_hours(rs1.getString("week_hours"));
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
