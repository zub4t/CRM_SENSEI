/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import management.employee.services.EmployeeServices;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.SheetVisibility;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.DBManager;
import util.Util;

/**
 *
 * @author marco
 */
@WebServlet(value = "/Rpt3")
public class Rpt3 extends HttpServlet {

    public static final String SAMPLE_XLSX_FILE_PATH = System.getProperty("java.io.tmpdir") + "/calendar.xlsx";

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
        String fileName = "rpt3" + ficheirodate;
        HttpSession session = req.getSession();

        //String user = session.getAttribute("user") == null ? "administrador" : (String) session.getAttribute("user");
        String[] employee_selected = req.getParameterValues("employee_selected");
        String startYear = req.getParameter("startYear");

        int startYear_int = Integer.parseInt(startYear);
        int endYear_int = 0;
        XSSFWorkbook wb = readTemplate();

        //Folha1
        int i = 1;
        for (String employee : employee_selected) {
            int employee_int = Integer.parseInt(employee);
            EmployeeServices service = new EmployeeServices();
            String name = service.getById(employee_int).getNme();
            rptSheet(wb, name, startYear_int, employee_int);
            wb.setSheetName(i, "Calendário " + startYear + " " + name);
            i++;
        }
        wb.setSheetVisibility(0, SheetVisibility.VERY_HIDDEN);
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

    private void rptSheet(XSSFWorkbook wb, String user, int startYear, int employee_selected) {

        // CellStyles cs = new CellStyles(wb);
        XSSFSheet sheet = wb.cloneSheet(0);

        sheet.getRow(0).getCell(0).setCellValue("Calendário " + startYear + " " + user);

        // createReportHeader(wb, sheet, cs, sheetName, user, 9, 8);
        String where = "  where ";
        where += "YEAR(str_date)  ='" + startYear + "' and   employee_id= '" + employee_selected + "'";

        String sql = " select \n"
                + "calendar.str_date,calendar.end_date,assingment.dsc,assingment.color,employee.nme,project.customer_nme\n"
                + "from calendar inner join assingment on assingment.id = assingment_id inner join employee on employee_id = employee.id inner join project on project.id = project_id "
                + "" + where + ";";
        int con = DBManager.getConnetion();
        PreparedStatement pstmt = null;
        Row row;
        int cel = 0;
        int lin = 0;
        try {
            pstmt = DBManager.getPreparedStatement(con, sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String str_date = rs.getString("calendar.str_date");
                String end_date = rs.getString("calendar.end_date");
                String dsc = rs.getString("dsc");
                String color = rs.getString("color");
                String customer_nme = rs.getString("customer_nme");

                int str_date_day = Integer.parseInt(str_date.split("-")[2]);
                int str_date_month = Integer.parseInt(str_date.split("-")[1]);

                int end_date_day = Integer.parseInt(end_date.split("-")[2]);
                int end_date_month = Integer.parseInt(end_date.split("-")[1]);

                row = sheet.getRow(str_date_day + 1) == null ? sheet.createRow(str_date_day + 1) : sheet.getRow(str_date_day + 1);
                cel = (2 * str_date_month) + (str_date_month - 1);
                int i = str_date_day + 1;
                while (i <= (end_date_day + 1)) {
                    Cell cell = row.getCell(cel) == null ? row.createCell(cel) : row.getCell(cel);
                    try {
                        XSSFCellStyle normal = null;

                        normal = (XSSFCellStyle) wb.createCellStyle();

                        normal.setWrapText(false);
                        normal.setAlignment(HorizontalAlignment.LEFT);
                        normal.setVerticalAlignment(VerticalAlignment.CENTER);
                        normal.setFillForegroundColor(new XSSFColor(Util.hex2Rgb(color)));
                        normal.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        normal.setFillBackgroundColor(new XSSFColor(Util.hex2Rgb(color)));
                        cell.setCellStyle(normal);
                        cell.setCellValue(customer_nme);

                    } catch (Exception e) {

                    }
                    i++;

                    row = sheet.getRow(i) == null ? sheet.createRow(i) : sheet.getRow(i);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.closePstmt(pstmt);
            DBManager.closeConnection(con);
        }
    }

    private void createReportHeader(XSSFWorkbook wb, SXSSFSheet sheet, CellStyles cs, String sheetName, String user, int i, int m) {

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

    private XSSFWorkbook readTemplate() {
        try {

            File file = new File(SAMPLE_XLSX_FILE_PATH);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            System.out.println(file.getAbsolutePath());
            return workbook;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
        return null;
    }

}
