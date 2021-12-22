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
import management.employee.services.EmployeeServices;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.DBManager;

/**
 *
 * @author marco
 */
@WebServlet(value = "/Rpt4")
public class Rpt4 extends HttpServlet {

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

        String[] employee_selected = req.getParameterValues("employee_selected");
        String startYear = req.getParameter("startYear");

        int startYear_int = Integer.parseInt(startYear);
        int endYear_int = 0;

        //Folha1
        int i = 1;
        for (String employee : employee_selected) {
            int employee_int = Integer.parseInt(employee);
            EmployeeServices service = new EmployeeServices();
            String name = service.getById(employee_int).getNme();
            rptSheet(wb, name, startYear_int, employee_int, user);
            i++;
        }

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

    private void rptSheet(SXSSFWorkbook wb, String employeName, int yearTarget, int employee_int, String user) {
        CellStyles cs = new CellStyles(wb);
        SXSSFSheet sheet = (SXSSFSheet) wb.createSheet(employeName);

        for (int i = 0; i < 20; i++) {
            sheet.setColumnWidth(i, 8000);
        }
        createReportHeader(wb, sheet, cs, "Projetos associados a " + employeName + " no ano de " + yearTarget + " ", user, 9, 2);
        String where = " where ownr = " + employee_int + " and YEAR(ctr_date) = '" + yearTarget + "' ";

        //Cabeçalho
        int lin = 7;
        int cel = 0;
        Row row = sheet.createRow(lin++);
        cel = 0;
        cs.newCellTxt(row, cel++, "Nome do projeto", cs.headerBlueLeftWrap());
        cs.newCellTxt(row, cel++, "Data limite ", cs.headerBlueLeftWrap());

        String sql = "select * from project  " + where;
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;

        try {
            pstmt = DBManager.getPreparedStatement(con, sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                row = sheet.createRow(lin++);
                cel = 0;
                cs.newCellGenericValue(row, cel++, rs.getString("n_process")+"|"+rs.getString("customer_nme"), cs.normal());
                cs.newCellGenericValue(row, cel++, rs.getString("end_date"), cs.normal());

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
