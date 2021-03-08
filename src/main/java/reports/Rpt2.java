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
@WebServlet(value = "/Rpt2")
public class Rpt2 extends HttpServlet {

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
        String fileName = "rpt2" + ficheirodate;
        HttpSession session = req.getSession();
        SXSSFWorkbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk        
        wb.setCompressTempFiles(true);
        String user = session.getAttribute("user") == null ? "administrador" : (String) session.getAttribute("user");

        String date_in = req.getParameter("date_in");
        String date_out = req.getParameter("date_out");
        String[] prjct_selected = req.getParameterValues("prjct_selected");
        int id = (int) session.getAttribute("userId");
        String username = (String) session.getAttribute("username");
        //Folha1
        String sheetName1 = "Intervenções de  " + username;
        String sheetName2 = "Detalhes";

        rptSheet1(wb, sheetName1, user, date_in, date_out, prjct_selected, id);
        rptSheet2(wb, sheetName2, user, date_in, date_out, prjct_selected, id);

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

    private void rptSheet2(SXSSFWorkbook wb, String sheetName, String user, String date_in, String date_out, String[] prjct_selected, int id) {
        CellStyles cs = new CellStyles(wb);
        SXSSFSheet sheet = (SXSSFSheet) wb.createSheet(sheetName);

        for (int i = 0; i < 20; i++) {
            sheet.setColumnWidth(i, 8000);
        }
        createReportHeader(wb, sheet, cs, sheetName, user, 9, 5);
        String where = "  where employee.id=" + id + " and ";

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
        where += " 1=1";
        //Cabeçalho
        int lin = 7;
        int cel = 0;
        Row row = sheet.createRow(lin++);
        cel = 0;
        cs.newCellTxt(row, cel++, "Nome do projeto", cs.headerBlueLeftWrap());
        cs.newCellTxt(row, cel++, "Tempo despedido", cs.headerBlueLeftWrap());
        cs.newCellTxt(row, cel++, "Tarefa", cs.headerBlueLeftWrap());
        cs.newCellTxt(row, cel++, "Observações", cs.headerBlueLeftWrap());
        cs.newCellTxt(row, cel++, "Data", cs.headerBlueLeftWrap());

        String sql = "SELECT CONCAT(project.n_process,\" | \",project.customer_nme) project_name, project_employee.spend_time,assingment.dsc assignment , project_employee.dsc , project_employee.dte,employee.nme  FROM project_employee INNER JOIN project  ON  project_employee.project_id = project.id\n"
                + "INNER JOIN employee ON project_employee.employee_id = employee.id INNER JOIN assingment ON project_employee.assingment_id = assingment.id\n"
                + where;
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                row = sheet.createRow(lin++);
                cel = 0;
                cs.newCellGenericValue(row, cel++, rs.getString("project_name"), cs.normal());
                cs.newCellGenericValue(row, cel++, rs.getString("spend_time"), cs.normal());
                cs.newCellGenericValue(row, cel++, rs.getString("assignment"), cs.normal());
                cs.newCellGenericValue(row, cel++, rs.getString("dsc"), cs.normal());
                String ddte = rs.getString("dte");
                cs.newCellDateValue(row, cel++, util.Util.data(ddte, "yyyy-MM-dd"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
    }

    private void rptSheet1(SXSSFWorkbook wb, String sheetName, String user, String date_in, String date_out, String[] prjct_selected, int id) {
        CellStyles cs = new CellStyles(wb);
        SXSSFSheet sheet = (SXSSFSheet) wb.createSheet(sheetName);

        for (int i = 0; i < 20; i++) {
            sheet.setColumnWidth(i, 8000);
        }
        createReportHeader(wb, sheet, cs, sheetName, user, 9, 2);
        String where = "  where employee.id=" + id + " and ";

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
        where += " 1=1";
        //Cabeçalho
        int lin = 7;
        int cel = 0;
        Row row = sheet.createRow(lin++);
        cel = 0;
        cs.newCellTxt(row, cel++, "Nome do projeto", cs.headerBlueLeftWrap());
        cs.newCellTxt(row, cel++, "Tempo total despedido", cs.headerBlueLeftWrap());

        String sql = "SELECT CONCAT(project.n_process,\" | \",project.customer_nme) project_name, sec_to_time(SUM(time_to_sec(spend_time))) hours FROM project_employee INNER JOIN project  ON  project_employee.project_id = project.id\n"
                + "INNER JOIN employee ON project_employee.employee_id = employee.id\n"
                + where + " GROUP BY project_name";
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                row = sheet.createRow(lin++);
                cel = 0;
                cs.newCellGenericValue(row, cel++, rs.getString("project_name"), cs.normal());
                cs.newCellGenericValue(row, cel++, rs.getString("hours"), cs.normal());

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

}
