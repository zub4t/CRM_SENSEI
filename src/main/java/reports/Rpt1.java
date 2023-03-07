/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import util.DBManager;

/**
 *
 * @author marco
 */
@WebServlet(value = "/Rpt1")
public class Rpt1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        //Nome do excel
        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss");
        String ficheirodate = sdf.format(date);
        String fileName = "rpt1" + ficheirodate;
        HttpSession session = req.getSession();
        SXSSFWorkbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk        
        wb.setCompressTempFiles(true);
        String user = session.getAttribute("user") == null ? "administrador" : (String) session.getAttribute("user");
        String[] employee_selected = req.getParameterValues("employee_selected");
        String date_in = req.getParameter("date_in");
        String date_out = req.getParameter("date_out");
        String[] prjct_selected = req.getParameterValues("prjct_selected");

        //Folha1
        String sheetName0 = "Relátorio Geral de Projetos";
        String sheetName1 = "Detalhes de Projetos";

        rptSheet0(wb, sheetName0, user, date_in, date_out, prjct_selected,employee_selected);
        rptSheet1(wb, sheetName1, user, date_in, date_out, prjct_selected,employee_selected);

        resp.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xlsx");
        resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        HttpSession objSessao = req.getSession(false);
        OutputStream out;
        try {
            out = resp.getOutputStream();
            wb.write(out);
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void rptSheet1(SXSSFWorkbook wb, String sheetName, String user, String date_in, String date_out, String[] prjct_selected, String[] employee_selected) {
        CellStyles cs = new CellStyles(wb);
        SXSSFSheet sheet = (SXSSFSheet) wb.createSheet(sheetName);

        for (int i = 0; i < 20; i++) {
            sheet.setColumnWidth(i, 8000);
        }
        createReportHeader(wb, sheet, cs, sheetName, user, 9, 8);
        String where = "  where ";
        if (date_in != null && date_out != null) {
            where += "ctr_date >='" + date_in + " 00:00:00' and  ctr_date<='" + date_out + "  23:59:59' and ";
        }
        if (prjct_selected != null) {
            where += " project.id  in (";
            for (String prj : prjct_selected) {
                where += "'" + prj + "',";
            }
            where = where.substring(0, where.length() - 1);

            where += ") and";
        }
        if (employee_selected != null) {
            where += " employee.id  in (";
            for (String empl : employee_selected) {
                where += "'" + empl + "',";
            }
            where = where.substring(0, where.length() - 1);

            where += ") and";
        }
        where += " 1=1";
        //Cabeçalho
        int lin = 7;
        int cel = 0;
        Row row = sheet.createRow(lin++);
        cel = 0;
        cs.newCellTxt(row, cel++, "Nº Processo", cs.headerBlueLeftWrap());
        cs.newCellTxt(row, cel++, "Nome do Cliente", cs.headerBlueLeftWrap());
        cs.newCellTxt(row, cel++, "Tarefa", cs.headerBlueLeftWrap());
        cs.newCellTxt(row, cel++, "Executante ", cs.headerBlueLeftWrap());
        cs.newCellTxt(row, cel++, "Data", cs.headerBlueLeftWrap());
        cs.newCellTxt(row, cel++, "Tempo Despendido", cs.headerBlueLeftWrap());
        cs.newCellTxt(row, cel++, "Custo/Hora", cs.headerBlueLeftWrap());
        cs.newCellTxt(row, cel++, "Observações", cs.headerBlueLeftWrap());

        String sql = "SELECT \n"
                + "    n_process,\n"
                + "    customer_nme,\n"
                + "    dte,\n"
                + "    (SELECT \n"
                + "            dsc\n"
                + "        FROM\n"
                + "            assingment\n"
                + "        WHERE\n"
                + "            id = assingment_id) AS assignment,\n"
                + "    (SELECT \n"
                + "            nme\n"
                + "        FROM\n"
                + "            employee\n"
                + "        WHERE\n"
                + "            id = employee_id) AS performer,\n"
                + "    (SELECT \n"
                + "            salary\n"
                + "        FROM\n"
                + "            employee\n"
                + "        WHERE\n"
                + "            id = employee_id) AS salary,\n"
                + "    spend_time,\n"
                + "    dsc,\n"
                + "	truncate((salary*(hour(spend_time) + minute(spend_time)/60)),2) as CostHour,\n"
                + "    project.ctr_date\n"
                + "    \n"
                + "FROM\n"
                + "    project_employee\n"
                + "        INNER JOIN\n"
                + "    project ON project_employee.project_id = project.id  \n"
                + "    inner join employee on project_employee.employee_id = employee.id\n "
                + "" + where + ";";
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                row = sheet.createRow(lin++);
                cel = 0;
                cs.newCellGenericValue(row, cel++, rs.getString("n_process"), cs.normal());
                cs.newCellGenericValue(row, cel++, rs.getString("customer_nme"), cs.normal());
                cs.newCellGenericValue(row, cel++, rs.getString("assignment"), cs.normal());
                cs.newCellGenericValue(row, cel++, rs.getString("performer"), cs.normal());
                String ddte = rs.getString("dte");
                cs.newCellDateValue(row, cel++, util.Util.data(ddte, "yyyy-MM-dd"));
                cs.newCellGenericValue(row, cel++, rs.getString("spend_time"), cs.normal());
                cs.newCellNum(row, cel++, rs.getFloat("CostHour"), cs.eurosCent());
                cs.newCellGenericValue(row, cel++, rs.getString("dsc"), cs.normal());

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
    }

    private void createReportHeader(SXSSFWorkbook wb, SXSSFSheet sheet, CellStyles cs, String sheetName, String user, int i, int m) {

        Cell c = null;
        Row row = null;

        sheet.setAutoFilter(CellRangeAddress.valueOf("A8:" + util.Util.numToExceString(m) + "8"));

        int rowi = 0;
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, i));
        sheet.addMergedRegion(new CellRangeAddress(1, 2, 0, 6));
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, i));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 7, i));
        sheet.addMergedRegion(new CellRangeAddress(2, 2, 7, i));

        row = sheet.createRow(0);
        cs.newCellTxt(row, 0, "", cs.headerBlueCenterWrap());

        row = sheet.createRow(1);
        cs.newCellTxt(row, 0, sheetName, cs.headerBlueCenterWrapXLargeF());

        row = sheet.createRow(2);
        cs.newCellTxt(row, 7, "", cs.headerBlueCenterWrap());

        row = sheet.createRow(3);
        cs.newCellTxt(row, 0, "", cs.headerBlueCenterWrap());

        //Data de Geracao
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String sdate = f.format(date);
        // selo de geração

        row = sheet.getRow(1);
        c = row.createCell(7);
        c.setCellValue(" Gerado  Report em:" + sdate);
        c.setCellStyle(cs.headerBlueCenterWrap());

    }

    private void rptSheet0(SXSSFWorkbook wb, String sheetName0, String user, String date_in, String date_out, String[] prjct_selected, String[] employee_selected) {

        CellStyles cs = new CellStyles(wb);
        SXSSFSheet sheet = (SXSSFSheet) wb.createSheet(sheetName0);

        for (int i = 0; i < 20; i++) {
            sheet.setColumnWidth(i, 8000);
        }
        createReportHeader(wb, sheet, cs, sheetName0, user, 8, 9);
        String where = " where ";
        //Cabeçalho
        int lin = 7;
        int cel = 0;
        Row row = sheet.createRow(lin++);
        cel = 0;
        if (date_in != null && date_out != null) {
            where += "ctr_date >='" + date_in + " 00:00:00' and  ctr_date<='" + date_out + " 23:59:59' and ";
        }
        if (prjct_selected != null) {
            where += " project.id  in (";
            for (String prj : prjct_selected) {
                where += "'" + prj + "',";
            }
            where = where.substring(0, where.length() - 1);

            where += ") and";
        }
        if (employee_selected != null) {
            where += " employee.id  in (";
            for (String empl : employee_selected) {
                where += "'" + empl + "',";
            }
            where = where.substring(0, where.length() - 1);

            where += ") and";
        }

        where += " 1=1";
        if (true) {
            cs.newCellTxt(row, cel++, "Nº Processo", cs.headerBlueLeftWrap());
            cs.newCellTxt(row, cel++, "Nome do Cliente", cs.headerBlueLeftWrap());
            cs.newCellTxt(row, cel++, "Honorários", cs.headerBlueLeftWrap());
            cs.newCellTxt(row, cel++, "Total de Horas", cs.headerBlueLeftWrap());
            cs.newCellTxt(row, cel++, "Total Custo das Horas", cs.headerBlueLeftWrap());
            cs.newCellTxt(row, cel++, "Venda Prevista", cs.headerBlueLeftWrap());
            cs.newCellTxt(row, cel++, "Venda Efetiva", cs.headerBlueLeftWrap());
            cs.newCellTxt(row, cel++, "Compra Efetiva", cs.headerBlueLeftWrap());
            cs.newCellTxt(row, cel++, "Lucro Projeto", cs.headerBlueLeftWrap());

        }
String sql = "SELECT \n"
        + "n_process,\n"
        + "customer_nme,\n"
        + "GROUP_CONCAT(DISTINCT project_id SEPARATOR ', ') AS project_ids,\n"
        + "(SELECT SEC_TO_TIME(SUM(TIME_TO_SEC(spend_time))) FROM project_employee WHERE project_employee.project_id = t.project_id GROUP BY project_employee.project_id ) AS total_hours,\n"
        + "SUM(costByProjectFunc) AS spentWithFunc,\n"
        + "expected_sale,\n"
        + "effective_sale,\n"
        + "effective_purchase,\n"
        + "honorary\n"
        + "FROM\n"
        + "(SELECT \n"
        + "n_process,\n"
        + "customer_nme,\n"
        + "project_id,\n"
        + "nme,\n"
        + "SUM(TIME_TO_SEC(spend_time)) * (salary / 3600) AS costByProjectFunc,\n"
        + "honorary,\n"
        + "expected_sale,\n"
        + "effective_sale,\n"
        + "effective_purchase,\n"
        + "ctr_date\n"
        + "FROM\n"
        + "project_employee\n"
        + "INNER JOIN project ON project_employee.project_id = project.id \n"
        + "INNER JOIN employee ON project_employee.employee_id = employee.id \n"
        + where
        + "GROUP BY n_process, customer_nme, project_employee.project_id, employee_id) AS t\n"
        + "GROUP BY n_process, customer_nme, project_id;";


        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                do {
                    row = sheet.createRow(lin++);
                    cel = 0;

                    cs.newCellGenericValue(row, cel++, rs.getString("n_process"), cs.normal());
                    cs.newCellGenericValue(row, cel++, rs.getString("customer_nme"), cs.normal());
                    cs.newCellNum(row, cel++, rs.getFloat("honorary"), cs.eurosCent());
                    cs.newCellGenericValue(row, cel++, rs.getString("total_hours"), cs.eurosCent());
                    cs.newCellNum(row, cel++, rs.getFloat("spentWithFunc"), cs.eurosCent());
                    cs.newCellNum(row, cel++, rs.getFloat("expected_sale"), cs.eurosCent());
                    cs.newCellNum(row, cel++, rs.getFloat("effective_sale"), cs.eurosCent());
                    cs.newCellNum(row, cel++, rs.getFloat("effective_purchase"), cs.eurosCent());
                    float lucro = (rs.getFloat("effective_sale") + rs.getFloat("honorary")) - ((rs.getFloat("effective_purchase") + rs.getFloat("spentWithFunc")));
                    cs.newCellNum(row, cel++, lucro, cs.eurosCent());

                } while (rs.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }

    }

}
