/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.awt.Color;
import java.util.Date;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;

public class CellStyles {

    SXSSFWorkbook wb;

    public CellStyles(SXSSFWorkbook wb) {
        this.wb = wb;
    }

    /////////////////////////////////////////////////
    //CORES
    XSSFColor black = newColorRGB(0, 0, 0);
    XSSFColor blue = newColorRGB(226, 239, 218);
    XSSFColor blue_dark = newColorRGB(0, 124, 255);
    XSSFColor gray_1 = newColorRGB(61, 61, 61);
    XSSFColor gray_2 = newColorRGB(104, 104, 104);
    XSSFColor gray_3 = newColorRGB(144, 144, 144);
    XSSFColor gray_4 = newColorRGB(185, 185, 185);
    XSSFColor gray_5 = newColorRGB(225, 225, 225);
    XSSFColor gray_6 = newColorRGB(250, 250, 250);
    XSSFColor green = newColorRGB(84, 200, 83);
    XSSFColor green_light = newColorRGB(146, 208, 80);
    XSSFColor orange = newColorRGB(255, 139, 88);
    XSSFColor grey = newColorRGB(153, 153, 153);
    XSSFColor red = newColorRGB(255, 65, 81);
    XSSFColor yellow = newColorRGB(255, 233, 109);
    XSSFColor yellow_light = newColorRGB(216, 228, 188);
    XSSFColor white = newColorRGB(255, 255, 255);
    XSSFColor pink = newColorRGB(255, 192, 203);
    XSSFColor orange_light = newColorRGB(255, 207, 158);

    //Cores GT
    XSSFColor light_yellow = newColorRGB(255, 255, 204);
    XSSFColor med_yellow = newColorRGB(255, 255, 153);
    XSSFColor light_blue = newColorRGB(184, 204, 228);
    XSSFColor lighter_blue = newColorRGB(220, 230, 241);
    XSSFColor sky_blue = newColorRGB(83, 141, 213);
    XSSFColor dark_blue = newColorRGB(54, 96, 146);
    XSSFColor dark_green = newColorRGB(79, 98, 40);
    XSSFColor med_green = newColorRGB(118, 147, 60);
    XSSFColor light_grey = newColorRGB(128, 128, 128);
    XSSFColor lighter_grey = newColorRGB(191, 191, 191);
    XSSFColor light_green = newColorRGB(118, 147, 60);
    XSSFColor brown = newColorRGB(150, 54, 52);
    XSSFColor pure_yellow = newColorRGB(255, 255, 0);
    XSSFColor red_light = newColorRGB(242, 220, 219);
    XSSFColor brownBrown = newColorRGB(151, 71, 6);

    //RPT
    XSSFColor epharma_blue = newColorRGB(0, 102, 204);
    XSSFColor epharma_orange = newColorRGB(255, 204, 153);
    XSSFColor epharma_trp_blue = newColorRGB(0, 204, 255);

    /////////////////////////////////////////////////
    //FONTES
    String fontName = "Lato Light";

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    XSSFFont fnormal = null;

    public Font fnormal(SXSSFWorkbook wb) {
        if (fnormal == null) {
            fnormal = (XSSFFont) wb.createFont();
            fnormal.setFontHeightInPoints((short) 8);
            fnormal.setFontName(fontName);
        }
        return fnormal;
    }

    XSSFFont fnormal11 = null;

    public Font fnormal11(SXSSFWorkbook wb) {
        if (fnormal11 == null) {
            fnormal11 = (XSSFFont) wb.createFont();
            fnormal11.setFontHeightInPoints((short) 11);
            fnormal11.setFontName(fontName);
        }
        return fnormal11;
    }

    XSSFFont fnormalbold11 = null;

    public Font fnormalbold11(SXSSFWorkbook wb) {
        if (fnormalbold11 == null) {
            fnormalbold11 = (XSSFFont) wb.createFont();
            fnormalbold11.setFontHeightInPoints((short) 11);
            fnormalbold11.setFontName(fontName);
            fnormalbold11.setBold(true);
        }
        return fnormalbold11;
    }

    XSSFFont fnormalwhite = null;

    public Font fnormalwhite(SXSSFWorkbook wb) {
        if (fnormalwhite == null) {
            XSSFColor white1 = new XSSFColor();
            byte b[] = new byte[4];
            b[0] = (byte) 255;
            b[0] = (byte) 255;
            b[0] = (byte) 255;
            white.setRgb(b);
            fnormalwhite = (XSSFFont) wb.createFont();
            fnormalwhite.setFontHeightInPoints((short) 8);
            fnormalwhite.setFontName(fontName);
            fnormalwhite.setColor(white);

        }
        return fnormalwhite;
    }

    XSSFFont fnormalred = null;

    public Font fnormalred(SXSSFWorkbook wb) {
        if (fnormalred == null) {
            fnormalred = (XSSFFont) wb.createFont();
            fnormalred.setFontHeightInPoints((short) 8);
            fnormalred.setFontName(fontName);
            fnormalred.setColor(red);
        }
        return fnormalred;
    }

    XSSFFont fnormalgreen = null;

    public Font fnormalgreen(SXSSFWorkbook wb) {
        if (fnormalgreen == null) {
            fnormalgreen = (XSSFFont) wb.createFont();
            fnormalgreen.setFontHeightInPoints((short) 8);
            fnormalgreen.setFontName(fontName);
            fnormalgreen.setColor(green);
        }
        return fnormalgreen;
    }

    XSSFFont fheaderwhite = null;

    public Font fheaderwhite(SXSSFWorkbook wb) {
        if (fheaderwhite == null) {
            fheaderwhite = (XSSFFont) wb.createFont();
            fheaderwhite.setColor(white);
            fheaderwhite.setFontHeightInPoints((short) 11);
            fheaderwhite.setFontName(fontName);

        }
        return fheaderwhite;
    }

    XSSFFont fheaderboldwhiteXLargeF = null;

    public Font fheaderboldwhiteXLargeF(SXSSFWorkbook wb) {
        if (fheaderboldwhiteXLargeF == null) {
            fheaderboldwhiteXLargeF = (XSSFFont) wb.createFont();
            fheaderboldwhiteXLargeF.setFontHeightInPoints((short) 28);
            fheaderboldwhiteXLargeF.setFontName(fontName);
            fheaderboldwhiteXLargeF.setColor(white);
            fheaderboldwhiteXLargeF.setBold(true);
        }
        return fheaderboldwhiteXLargeF;
    }

    XSSFFont fheaderboldwhite = null;

    public Font fheaderboldwhite(SXSSFWorkbook wb) {
        if (fheaderboldwhite == null) {
            fheaderboldwhite = (XSSFFont) wb.createFont();
            fheaderboldwhite.setFontHeightInPoints((short) 11);
            fheaderboldwhite.setFontName(fontName);
            fheaderboldwhite.setColor(white);
            fheaderboldwhite.setBold(true);
        }
        return fheaderboldwhite;
    }

    XSSFFont fheaderboldwhiteepharma = null;

    public Font fheaderboldwhiteepharma(SXSSFWorkbook wb) {
        if (fheaderboldwhiteepharma == null) {
            fheaderboldwhiteepharma = (XSSFFont) wb.createFont();
            fheaderboldwhiteepharma.setFontHeightInPoints((short) 9);
            fheaderboldwhiteepharma.setFontName(fontName);
            fheaderboldwhiteepharma.setColor(white);
            fheaderboldwhiteepharma.setBold(true);
        }
        return fheaderboldwhiteepharma;
    }

    XSSFFont fheaderblackbold = null;

    public Font fheaderblackbold(SXSSFWorkbook wb) {
        if (fheaderblackbold == null) {
            fheaderblackbold = (XSSFFont) wb.createFont();
            fheaderblackbold.setFontHeightInPoints((short) 11);
            fheaderblackbold.setFontName(fontName);
            fheaderblackbold.setColor(black);
            fheaderblackbold.setBold(true);
        }
        return fheaderblackbold;
    }

    XSSFFont fheaderboldblackepharma = null;

    public Font fheaderboldblackepharma(SXSSFWorkbook wb) {
        if (fheaderboldblackepharma == null) {
            fheaderboldblackepharma = (XSSFFont) wb.createFont();
            fheaderboldblackepharma.setFontHeightInPoints((short) 9);
            fheaderboldblackepharma.setFontName(fontName);
            fheaderboldblackepharma.setColor(black);
            fheaderboldblackepharma.setBold(true);
        }
        return fheaderboldblackepharma;
    }

    XSSFFont fheaderblackbold14 = null;

    public Font fheaderblackbold14(SXSSFWorkbook wb) {
        if (fheaderblackbold14 == null) {
            fheaderblackbold14 = (XSSFFont) wb.createFont();
            fheaderblackbold14.setFontHeightInPoints((short) 14);
            fheaderblackbold14.setFontName(fontName);
            fheaderblackbold14.setColor(black);
            fheaderblackbold14.setBold(true);
        }
        return fheaderblackbold14;
    }

    XSSFFont fRptTitle = null;

    public Font fRptTitle(SXSSFWorkbook wb) {
        if (fRptTitle == null) {
            fRptTitle = (XSSFFont) wb.createFont();
            fRptTitle.setFontHeightInPoints((short) 24);
            fRptTitle.setFontName(fontName);
            fRptTitle.setColor(white);
        }
        return fRptTitle;
    }

    XSSFFont fbold = null;

    public Font fbold(SXSSFWorkbook wb) {
        if (fbold == null) {
            fbold = (XSSFFont) wb.createFont();
            fbold.setFontHeightInPoints((short) 8);
            fbold.setFontName(fontName);
            fbold.setBold(true);
        }
        return fbold;
    }

    XSSFFont fboldSheetTitle = null;

    public Font fboldSheetTitle(SXSSFWorkbook wb) {
        if (fboldSheetTitle == null) {
            fboldSheetTitle = (XSSFFont) wb.createFont();
            fboldSheetTitle.setFontHeightInPoints((short) 20);
            fboldSheetTitle.setFontName(fontName);
            fboldSheetTitle.setColor(light_grey);
            fboldSheetTitle.setBold(true);
        }
        return fboldSheetTitle;
    }

    /////////////////////////////////////////////////    
    //ESTILOS
    XSSFCellStyle headerBlueCenterWrapXLargeF = null;

    public CellStyle headerBlueCenterWrapXLargeF() {
        if (headerBlueCenterWrapXLargeF == null) {
            headerBlueCenterWrapXLargeF = (XSSFCellStyle) wb.createCellStyle();
            fheaderwhite(wb);
            headerBlueCenterWrapXLargeF.setFont(this.fheaderboldwhiteXLargeF(this.wb));
            headerBlueCenterWrapXLargeF.setWrapText(true);
            headerBlueCenterWrapXLargeF.setAlignment(HorizontalAlignment.CENTER);
            headerBlueCenterWrapXLargeF.setVerticalAlignment(VerticalAlignment.CENTER);
            headerBlueCenterWrapXLargeF.setFillForegroundColor(blue);
            headerBlueCenterWrapXLargeF.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerBlueCenterWrapXLargeF;
    }

    XSSFCellStyle headerRpt = null;

    public CellStyle headerRpt() {
        if (headerRpt == null) {
            headerRpt = (XSSFCellStyle) wb.createCellStyle();
            fheaderwhite(wb);
            headerRpt.setFont(fheaderwhite);
            headerRpt.setWrapText(false);
            headerRpt.setAlignment(HorizontalAlignment.LEFT);
            headerRpt.setVerticalAlignment(VerticalAlignment.CENTER);
            headerRpt.setFillForegroundColor(blue);
            headerRpt.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerRpt;
    }

    XSSFCellStyle headerRptTitle = null;

    public CellStyle headerRptTitle() {
        if (headerRptTitle == null) {
            headerRptTitle = (XSSFCellStyle) wb.createCellStyle();
            fRptTitle(wb);
            headerRptTitle.setFont(fRptTitle);
            headerRptTitle.setWrapText(false);
            headerRptTitle.setAlignment(HorizontalAlignment.LEFT);
            headerRptTitle.setVerticalAlignment(VerticalAlignment.CENTER);
            headerRptTitle.setFillForegroundColor(blue);
            headerRptTitle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerRptTitle;
    }

    XSSFCellStyle headerWhiteCenterWrap = null;

    public CellStyle headerWhiteCenterWrap() {
        if (headerWhiteCenterWrap == null) {
            headerWhiteCenterWrap = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerWhiteCenterWrap.setFont(fheaderblackbold);
            headerWhiteCenterWrap.setWrapText(true);
            headerWhiteCenterWrap.setAlignment(HorizontalAlignment.CENTER);
            headerWhiteCenterWrap.setVerticalAlignment(VerticalAlignment.CENTER);
            headerWhiteCenterWrap.setFillForegroundColor(white);
            headerWhiteCenterWrap.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerWhiteCenterWrap.setBorderBottom(BorderStyle.THIN);
        }
        return headerWhiteCenterWrap;
    }

    XSSFCellStyle headerBlueLeft = null;

    public CellStyle headerBlueLeft() {
        if (headerBlueLeft == null) {
            headerBlueLeft = (XSSFCellStyle) wb.createCellStyle();
            fheaderwhite(wb);
            headerBlueLeft.setFont(fheaderwhite);
            headerBlueLeft.setWrapText(false);
            headerBlueLeft.setAlignment(HorizontalAlignment.LEFT);
            headerBlueLeft.setVerticalAlignment(VerticalAlignment.CENTER);
            headerBlueLeft.setFillForegroundColor(blue);
            headerBlueLeft.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerBlueLeft.setBorderBottom(BorderStyle.THIN);
        }
        return headerBlueLeft;
    }

    XSSFCellStyle headerBlueLeftWrap = null;

    public CellStyle headerBlueLeftWrap() {
        if (headerBlueLeftWrap == null) {
            headerBlueLeftWrap = (XSSFCellStyle) wb.createCellStyle();
            fnormalwhite(wb);
            headerBlueLeftWrap.setFont(fheaderwhite);
            headerBlueLeftWrap.setWrapText(true);
            headerBlueLeftWrap.setAlignment(HorizontalAlignment.LEFT);
            headerBlueLeftWrap.setVerticalAlignment(VerticalAlignment.CENTER);
            headerBlueLeftWrap.setFillForegroundColor(blue);
            headerBlueLeftWrap.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerBlueLeftWrap;
    }

    XSSFCellStyle headerBlueCenterWrap = null;

    public CellStyle headerBlueCenterWrap() {
        if (headerBlueCenterWrap == null) {
            headerBlueCenterWrap = (XSSFCellStyle) wb.createCellStyle();
            fheaderwhite(wb);
            headerBlueCenterWrap.setFont(fheaderwhite);
            headerBlueCenterWrap.setWrapText(true);
            headerBlueCenterWrap.setAlignment(HorizontalAlignment.CENTER);
            headerBlueCenterWrap.setVerticalAlignment(VerticalAlignment.CENTER);
            headerBlueCenterWrap.setFillForegroundColor(blue);
            headerBlueCenterWrap.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerBlueCenterWrap;
    }

    XSSFCellStyle headerYellowLeft = null;

    public CellStyle headerYellowLeft() {
        if (headerYellowLeft == null) {
            headerYellowLeft = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerYellowLeft.setFont(fheaderblackbold);
            headerYellowLeft.setWrapText(false);
            headerYellowLeft.setAlignment(HorizontalAlignment.LEFT);
            headerYellowLeft.setVerticalAlignment(VerticalAlignment.CENTER);
            headerYellowLeft.setFillForegroundColor(yellow);
            headerYellowLeft.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerYellowLeft;
    }

    XSSFCellStyle headerPureYellowLeft = null;

    public CellStyle headerPureYellowLeft() {
        if (headerPureYellowLeft == null) {
            headerPureYellowLeft = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerPureYellowLeft.setFont(fheaderblackbold);
            headerPureYellowLeft.setWrapText(false);
            headerPureYellowLeft.setAlignment(HorizontalAlignment.LEFT);
            headerPureYellowLeft.setVerticalAlignment(VerticalAlignment.CENTER);
            headerPureYellowLeft.setFillForegroundColor(pure_yellow);
            headerPureYellowLeft.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerPureYellowLeft.setBorderRight(BorderStyle.THIN);
            headerPureYellowLeft.setBorderLeft(BorderStyle.THIN);
        }
        return headerPureYellowLeft;
    }

    public CellStyle date() {

        CreationHelper createHelper = wb.getCreationHelper();
        CellStyle date = wb.createCellStyle();
        date.setDataFormat(createHelper.createDataFormat().getFormat("dd-mm-yyyy"));
        date.setFont(fnormal);
        return date;
    }

    XSSFCellStyle porcentoYellow = null;

    public CellStyle porcentoYellow() {
        if (porcentoYellow == null) {
            porcentoYellow = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            porcentoYellow.setFont(fheaderblackbold);
            porcentoYellow.setWrapText(false);
            porcentoYellow.setAlignment(HorizontalAlignment.RIGHT);
            porcentoYellow.setVerticalAlignment(VerticalAlignment.CENTER);
            porcentoYellow.setFillForegroundColor(yellow);
            porcentoYellow.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            DataFormat dfEurosCent = wb.createDataFormat();
            porcentoYellow.setDataFormat(dfEurosCent.getFormat("0.00%"));
        }
        return porcentoYellow;
    }

    XSSFCellStyle headerYellowLeftWrap = null;

    public CellStyle headerYellowLeftWrap() {
        if (headerYellowLeftWrap == null) {
            headerYellowLeftWrap = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerYellowLeftWrap.setFont(fheaderblackbold);
            headerYellowLeftWrap.setWrapText(true);
            headerYellowLeftWrap.setAlignment(HorizontalAlignment.LEFT);
            headerYellowLeftWrap.setVerticalAlignment(VerticalAlignment.CENTER);
            headerYellowLeftWrap.setFillForegroundColor(yellow);
            headerYellowLeftWrap.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerYellowLeftWrap;
    }

    XSSFCellStyle headerYellowCenter = null;

    public CellStyle headerYellowCenter() {
        if (headerYellowCenter == null) {
            headerYellowCenter = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerYellowCenter.setFont(fheaderblackbold);
            headerYellowCenter.setWrapText(false);
            headerYellowCenter.setAlignment(HorizontalAlignment.CENTER);
            headerYellowCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            headerYellowCenter.setFillForegroundColor(yellow);
            headerYellowCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerYellowCenter;
    }

    XSSFCellStyle headerYellowCenterWrap = null;

    public CellStyle headerYellowCenterWrap() {
        if (headerYellowCenterWrap == null) {
            headerYellowCenterWrap = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerYellowCenterWrap.setFont(fheaderblackbold);
            headerYellowCenterWrap.setWrapText(true);
            headerYellowCenterWrap.setAlignment(HorizontalAlignment.CENTER);
            headerYellowCenterWrap.setVerticalAlignment(VerticalAlignment.CENTER);
            headerYellowCenterWrap.setFillForegroundColor(yellow);
            headerYellowCenterWrap.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerYellowCenterWrap;
    }

    XSSFCellStyle headerBlueDarkLeft = null;

    public CellStyle headerBlueDarkLeft() {
        if (headerBlueDarkLeft == null) {
            headerBlueDarkLeft = (XSSFCellStyle) wb.createCellStyle();
            fheaderwhite(wb);
            headerBlueDarkLeft.setFont(fheaderwhite);
            headerBlueDarkLeft.setWrapText(false);
            headerBlueDarkLeft.setAlignment(HorizontalAlignment.LEFT);
            headerBlueDarkLeft.setVerticalAlignment(VerticalAlignment.CENTER);
            headerBlueDarkLeft.setFillForegroundColor(blue_dark);
            headerBlueDarkLeft.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerBlueDarkLeft;
    }

    XSSFCellStyle headerOrangeLeft = null;

    public CellStyle headerOrangeLeft() {
        if (headerOrangeLeft == null) {
            headerOrangeLeft = (XSSFCellStyle) wb.createCellStyle();
            fheaderwhite(wb);
            headerOrangeLeft.setFont(fheaderwhite);
            headerOrangeLeft.setWrapText(false);
            headerOrangeLeft.setAlignment(HorizontalAlignment.LEFT);
            headerOrangeLeft.setVerticalAlignment(VerticalAlignment.CENTER);
            headerOrangeLeft.setFillForegroundColor(orange);
            headerOrangeLeft.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerOrangeLeft;
    }

    XSSFCellStyle headerOrangeCenter = null;

    public CellStyle headerOrangeCenter() {
        if (headerOrangeCenter == null) {
            headerOrangeCenter = (XSSFCellStyle) wb.createCellStyle();
            fheaderwhite(wb);
            headerOrangeCenter.setFont(fheaderwhite);
            headerOrangeCenter.setWrapText(false);
            headerOrangeCenter.setAlignment(HorizontalAlignment.CENTER);
            headerOrangeCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            headerOrangeCenter.setFillForegroundColor(orange);
            headerOrangeCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerOrangeCenter;
    }

    XSSFCellStyle headerGreyLeft = null;

    public CellStyle headerGreyLeft() {
        if (headerGreyLeft == null) {
            headerGreyLeft = (XSSFCellStyle) wb.createCellStyle();
            fheaderwhite(wb);
            headerGreyLeft.setFont(fheaderwhite);
            headerGreyLeft.setWrapText(false);
            headerGreyLeft.setAlignment(HorizontalAlignment.LEFT);
            headerGreyLeft.setVerticalAlignment(VerticalAlignment.CENTER);
            headerGreyLeft.setFillForegroundColor(grey);
            headerGreyLeft.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerGreyLeft;
    }

    XSSFCellStyle headerGreyRight = null;

    public CellStyle headerGreyRight() {
        if (headerGreyRight == null) {
            headerGreyRight = (XSSFCellStyle) wb.createCellStyle();
            fheaderwhite(wb);
            headerGreyRight.setFont(fheaderwhite);
            headerGreyRight.setWrapText(false);
            headerGreyRight.setAlignment(HorizontalAlignment.RIGHT);
            headerGreyRight.setVerticalAlignment(VerticalAlignment.CENTER);
            headerGreyRight.setFillForegroundColor(grey);
            headerGreyRight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerGreyRight;
    }

    XSSFCellStyle headerGreyLightLeft = null;

    public CellStyle headerGreyLightLeft() {
        if (headerGreyLightLeft == null) {
            headerGreyLightLeft = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerGreyLightLeft.setFont(fheaderblackbold);
            headerGreyLightLeft.setWrapText(false);
            headerGreyLightLeft.setAlignment(HorizontalAlignment.LEFT);
            headerGreyLightLeft.setVerticalAlignment(VerticalAlignment.CENTER);
            headerGreyLightLeft.setFillForegroundColor(gray_5);
            headerGreyLightLeft.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerGreyLightLeft;
    }
    XSSFCellStyle headerGreyLightLeftNormal = null;

    public CellStyle headerGreyLightLeftNormal() {
        if (headerGreyLightLeftNormal == null) {
            headerGreyLightLeftNormal = (XSSFCellStyle) wb.createCellStyle();
            fnormal11(wb);
            headerGreyLightLeftNormal.setFont(fnormal11);
            headerGreyLightLeftNormal.setWrapText(false);
            headerGreyLightLeftNormal.setAlignment(HorizontalAlignment.LEFT);
            headerGreyLightLeftNormal.setVerticalAlignment(VerticalAlignment.CENTER);
            headerGreyLightLeftNormal.setFillForegroundColor(gray_5);
            headerGreyLightLeftNormal.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerGreyLightLeftNormal;
    }

    XSSFCellStyle headerRedLightLeft = null;

    public CellStyle headerRedLightLeft() {
        if (headerRedLightLeft == null) {
            headerRedLightLeft = (XSSFCellStyle) wb.createCellStyle();
            fnormal11(wb);
            headerRedLightLeft.setFont(fnormal11);
            headerRedLightLeft.setWrapText(false);
            headerRedLightLeft.setAlignment(HorizontalAlignment.LEFT);
            headerRedLightLeft.setVerticalAlignment(VerticalAlignment.CENTER);
            headerRedLightLeft.setFillForegroundColor(red_light);
            headerRedLightLeft.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerRedLightLeft.setBorderRight(BorderStyle.THIN);
            headerRedLightLeft.setBorderLeft(BorderStyle.THIN);
        }
        return headerRedLightLeft;
    }

    XSSFCellStyle inteiroGreyLight = null;

    public CellStyle inteiroGreyLight() {
        if (inteiroGreyLight == null) {
            inteiroGreyLight = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            inteiroGreyLight.setFont(fheaderblackbold);
            inteiroGreyLight.setWrapText(false);
            inteiroGreyLight.setAlignment(HorizontalAlignment.RIGHT);
            inteiroGreyLight.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroGreyLight.setFillForegroundColor(gray_5);
            inteiroGreyLight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            DataFormat df = wb.createDataFormat();
            inteiroGreyLight.setDataFormat(df.getFormat("#,###,###,##0"));
        }
        return inteiroGreyLight;
    }

    XSSFCellStyle inteiroRedLight = null;

    public CellStyle inteiroRedLight() {
        if (inteiroRedLight == null) {
            inteiroRedLight = (XSSFCellStyle) wb.createCellStyle();
            fnormal11(wb);
            inteiroRedLight.setFont(fnormal11);
            inteiroRedLight.setWrapText(false);
            inteiroRedLight.setAlignment(HorizontalAlignment.RIGHT);
            inteiroRedLight.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroRedLight.setFillForegroundColor(red_light);
            inteiroRedLight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            DataFormat df = wb.createDataFormat();
            inteiroRedLight.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroRedLight.setBorderRight(BorderStyle.THIN);
            inteiroRedLight.setBorderLeft(BorderStyle.THIN);
        }
        return inteiroRedLight;
    }

    XSSFCellStyle porcentoRedLight = null;

    public CellStyle porcentoRedLight() {
        if (porcentoRedLight == null) {
            porcentoRedLight = (XSSFCellStyle) wb.createCellStyle();
            fnormal11(wb);
            porcentoRedLight.setFont(fnormal11);
            porcentoRedLight.setWrapText(false);
            porcentoRedLight.setAlignment(HorizontalAlignment.RIGHT);
            porcentoRedLight.setVerticalAlignment(VerticalAlignment.CENTER);
            porcentoRedLight.setFillForegroundColor(red_light);
            porcentoRedLight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            DataFormat dfEurosCent = wb.createDataFormat();
            porcentoRedLight.setDataFormat(dfEurosCent.getFormat("0.00%"));
            porcentoRedLight.setBorderRight(BorderStyle.THIN);
            porcentoRedLight.setBorderLeft(BorderStyle.THIN);
        }
        return porcentoRedLight;
    }

    XSSFCellStyle porcentoGreyLight = null;

    public CellStyle porcentoGreyLight() {
        if (porcentoGreyLight == null) {
            porcentoGreyLight = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            porcentoGreyLight.setFont(fheaderblackbold);
            porcentoGreyLight.setWrapText(false);
            porcentoGreyLight.setAlignment(HorizontalAlignment.RIGHT);
            porcentoGreyLight.setVerticalAlignment(VerticalAlignment.CENTER);
            porcentoGreyLight.setFillForegroundColor(gray_5);
            porcentoGreyLight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            DataFormat dfEurosCent = wb.createDataFormat();
            porcentoGreyLight.setDataFormat(dfEurosCent.getFormat("0.00%"));
        }
        return porcentoGreyLight;
    }

    XSSFCellStyle headerGreyLightCenter = null;

    public CellStyle headerGreyLightCenter() {
        if (headerGreyLightCenter == null) {
            headerGreyLightCenter = (XSSFCellStyle) wb.createCellStyle();
            fheaderwhite(wb);
            headerGreyLightCenter.setFont(fheaderwhite);
            headerGreyLightCenter.setWrapText(false);
            headerGreyLightCenter.setAlignment(HorizontalAlignment.CENTER);
            headerGreyLightCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            headerGreyLightCenter.setFillForegroundColor(light_grey);
            headerGreyLightCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerGreyLightCenter;
    }

    XSSFCellStyle headerGreyLightCenterWrap = null;

    public CellStyle headerGreyLightCenterWrap() {
        if (headerGreyLightCenterWrap == null) {
            headerGreyLightCenterWrap = (XSSFCellStyle) wb.createCellStyle();
            fheaderwhite(wb);
            headerGreyLightCenterWrap.setFont(fheaderwhite);
            headerGreyLightCenterWrap.setWrapText(true);
            headerGreyLightCenterWrap.setAlignment(HorizontalAlignment.CENTER);
            headerGreyLightCenterWrap.setVerticalAlignment(VerticalAlignment.CENTER);
            headerGreyLightCenterWrap.setFillForegroundColor(light_grey);
            headerGreyLightCenterWrap.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerGreyLightCenterWrap;
    }

    XSSFCellStyle headerBlueDarkerCenterWrap = null;

    public CellStyle headerBlueDarkerCenterWrap() {
        if (headerBlueDarkerCenterWrap == null) {
            headerBlueDarkerCenterWrap = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerBlueDarkerCenterWrap.setFont(fheaderblackbold);
            headerBlueDarkerCenterWrap.setWrapText(true);
            headerBlueDarkerCenterWrap.setAlignment(HorizontalAlignment.CENTER);
            headerBlueDarkerCenterWrap.setVerticalAlignment(VerticalAlignment.CENTER);
            headerBlueDarkerCenterWrap.setFillForegroundColor(dark_blue);
            headerBlueDarkerCenterWrap.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerBlueDarkerCenterWrap;
    }

    XSSFCellStyle headerBlueLighterCenterWrap = null;

    public CellStyle headerBlueLighterCenterWrap() {
        if (headerBlueLighterCenterWrap == null) {
            headerBlueLighterCenterWrap = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerBlueLighterCenterWrap.setFont(fheaderblackbold);
            headerBlueLighterCenterWrap.setWrapText(true);
            headerBlueLighterCenterWrap.setAlignment(HorizontalAlignment.CENTER);
            headerBlueLighterCenterWrap.setVerticalAlignment(VerticalAlignment.CENTER);
            headerBlueLighterCenterWrap.setFillForegroundColor(lighter_blue);
            headerBlueLighterCenterWrap.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerBlueLighterCenterWrap;
    }

    XSSFCellStyle headerBlueLightCenter = null;

    public CellStyle headerBlueLightCenter() {
        if (headerBlueLightCenter == null) {
            headerBlueLightCenter = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerBlueLightCenter.setFont(fheaderblackbold);
            headerBlueLightCenter.setWrapText(false);
            headerBlueLightCenter.setAlignment(HorizontalAlignment.CENTER);
            headerBlueLightCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            headerBlueLightCenter.setFillForegroundColor(light_blue);
            headerBlueLightCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerBlueLightCenter.setBorderTop(BorderStyle.THIN);
            headerBlueLightCenter.setBorderRight(BorderStyle.THIN);
            headerBlueLightCenter.setBorderLeft(BorderStyle.THIN);
            headerBlueLightCenter.setBorderBottom(BorderStyle.THIN);
        }
        return headerBlueLightCenter;
    }

    XSSFCellStyle headerBlueLightCenter14 = null;

    public CellStyle headerBlueLightCenter14() {
        if (headerBlueLightCenter14 == null) {
            headerBlueLightCenter14 = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold14(wb);
            headerBlueLightCenter14.setFont(fheaderblackbold14);
            headerBlueLightCenter14.setWrapText(false);
            headerBlueLightCenter14.setAlignment(HorizontalAlignment.CENTER);
            headerBlueLightCenter14.setVerticalAlignment(VerticalAlignment.CENTER);
            headerBlueLightCenter14.setFillForegroundColor(light_blue);
            headerBlueLightCenter14.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerBlueLightCenter14;
    }

    XSSFCellStyle headerBlueLightLeftNormal = null;

    public CellStyle headerBlueLightLeftNormal() {
        if (headerBlueLightLeftNormal == null) {
            headerBlueLightLeftNormal = (XSSFCellStyle) wb.createCellStyle();
            fnormal11(wb);
            headerBlueLightLeftNormal.setFont(fnormal11);
            headerBlueLightLeftNormal.setWrapText(false);
            headerBlueLightLeftNormal.setAlignment(HorizontalAlignment.LEFT);
            headerBlueLightLeftNormal.setVerticalAlignment(VerticalAlignment.CENTER);
            headerBlueLightLeftNormal.setFillForegroundColor(light_blue);
            headerBlueLightLeftNormal.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerBlueLightLeftNormal.setBorderRight(BorderStyle.THIN);
            headerBlueLightLeftNormal.setBorderLeft(BorderStyle.THIN);
        }
        return headerBlueLightLeftNormal;
    }

    XSSFCellStyle headerBlueLightLeft = null;

    public CellStyle headerBlueLightLeft() {
        if (headerBlueLightLeft == null) {
            headerBlueLightLeft = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerBlueLightLeft.setFont(fheaderblackbold);
            headerBlueLightLeft.setWrapText(false);
            headerBlueLightLeft.setAlignment(HorizontalAlignment.LEFT);
            headerBlueLightLeft.setVerticalAlignment(VerticalAlignment.CENTER);
            headerBlueLightLeft.setFillForegroundColor(light_blue);
            headerBlueLightLeft.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerBlueLightLeft.setBorderRight(BorderStyle.THIN);
            headerBlueLightLeft.setBorderLeft(BorderStyle.THIN);
        }
        return headerBlueLightLeft;
    }

    XSSFCellStyle headerBlueLightRight = null;

    public CellStyle headerBlueLightRight() {
        if (headerBlueLightRight == null) {
            headerBlueLightRight = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerBlueLightRight.setFont(fheaderblackbold);
            headerBlueLightRight.setWrapText(false);
            headerBlueLightRight.setAlignment(HorizontalAlignment.RIGHT);
            headerBlueLightRight.setVerticalAlignment(VerticalAlignment.CENTER);
            headerBlueLightRight.setFillForegroundColor(light_blue);
            headerBlueLightRight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerBlueLightRight;
    }

    XSSFCellStyle headerBlueLightRight14 = null;

    public CellStyle headerBlueLightRight14() {
        if (headerBlueLightRight14 == null) {
            headerBlueLightRight14 = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold14(wb);
            headerBlueLightRight14.setFont(fheaderblackbold14);
            headerBlueLightRight14.setWrapText(false);
            headerBlueLightRight14.setAlignment(HorizontalAlignment.RIGHT);
            headerBlueLightRight14.setVerticalAlignment(VerticalAlignment.CENTER);
            headerBlueLightRight14.setFillForegroundColor(light_blue);
            headerBlueLightRight14.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerBlueLightRight14.setBorderRight(BorderStyle.THIN);
            headerBlueLightRight14.setBorderLeft(BorderStyle.THIN);
        }
        return headerBlueLightRight14;
    }

    XSSFCellStyle inteiroBlueLightNormal = null;

    public CellStyle inteiroBlueLightNormal() {
        if (inteiroBlueLightNormal == null) {
            inteiroBlueLightNormal = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            inteiroBlueLightNormal.setFont(fnormal);
            inteiroBlueLightNormal.setWrapText(false);
            inteiroBlueLightNormal.setAlignment(HorizontalAlignment.RIGHT);
            inteiroBlueLightNormal.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroBlueLightNormal.setFillForegroundColor(light_blue);
            inteiroBlueLightNormal.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            DataFormat df = wb.createDataFormat();
            inteiroBlueLightNormal.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroBlueLightNormal.setBorderRight(BorderStyle.THIN);
            inteiroBlueLightNormal.setBorderLeft(BorderStyle.THIN);
        }
        return inteiroBlueLightNormal;
    }

    XSSFCellStyle inteiroBlueLight = null;

    public CellStyle inteiroBlueLight() {
        if (inteiroBlueLight == null) {
            inteiroBlueLight = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            inteiroBlueLight.setFont(fheaderblackbold);
            inteiroBlueLight.setWrapText(false);
            inteiroBlueLight.setAlignment(HorizontalAlignment.RIGHT);
            inteiroBlueLight.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroBlueLight.setFillForegroundColor(light_blue);
            inteiroBlueLight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            DataFormat df = wb.createDataFormat();
            inteiroBlueLight.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroBlueLight.setBorderRight(BorderStyle.THIN);
            inteiroBlueLight.setBorderLeft(BorderStyle.THIN);
        }
        return inteiroBlueLight;
    }

    XSSFCellStyle inteiroBlueLight14 = null;

    public CellStyle inteiroBlueLight14() {
        if (inteiroBlueLight14 == null) {
            inteiroBlueLight14 = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold14(wb);
            inteiroBlueLight14.setFont(fheaderblackbold14);
            inteiroBlueLight14.setWrapText(false);
            inteiroBlueLight14.setAlignment(HorizontalAlignment.RIGHT);
            inteiroBlueLight14.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroBlueLight14.setFillForegroundColor(light_blue);
            inteiroBlueLight14.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            DataFormat df = wb.createDataFormat();
            inteiroBlueLight14.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroBlueLight14.setBorderRight(BorderStyle.THIN);
            inteiroBlueLight14.setBorderLeft(BorderStyle.THIN);
        }
        return inteiroBlueLight14;
    }

    XSSFCellStyle porcentoBlueLight = null;

    public CellStyle porcentoBlueLight() {
        if (porcentoBlueLight == null) {
            porcentoBlueLight = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            porcentoBlueLight.setFont(fheaderblackbold);
            porcentoBlueLight.setWrapText(false);
            porcentoBlueLight.setAlignment(HorizontalAlignment.RIGHT);
            porcentoBlueLight.setVerticalAlignment(VerticalAlignment.CENTER);
            porcentoBlueLight.setFillForegroundColor(light_blue);
            porcentoBlueLight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            DataFormat dfEurosCent = wb.createDataFormat();
            porcentoBlueLight.setDataFormat(dfEurosCent.getFormat("0.00%"));
            porcentoBlueLight.setBorderRight(BorderStyle.THIN);
            porcentoBlueLight.setBorderLeft(BorderStyle.THIN);
        }
        return porcentoBlueLight;
    }

    XSSFCellStyle porcentoBlueLight14 = null;

    public CellStyle porcentoBlueLight14() {
        if (porcentoBlueLight14 == null) {
            porcentoBlueLight14 = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold14(wb);
            porcentoBlueLight14.setFont(fheaderblackbold14);
            porcentoBlueLight14.setWrapText(false);
            porcentoBlueLight14.setAlignment(HorizontalAlignment.RIGHT);
            porcentoBlueLight14.setVerticalAlignment(VerticalAlignment.CENTER);
            porcentoBlueLight14.setFillForegroundColor(light_blue);
            porcentoBlueLight14.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            DataFormat dfEurosCent = wb.createDataFormat();
            porcentoBlueLight14.setDataFormat(dfEurosCent.getFormat("0.00%"));
            porcentoBlueLight14.setBorderRight(BorderStyle.THIN);
            porcentoBlueLight14.setBorderLeft(BorderStyle.THIN);
        }
        return porcentoBlueLight14;
    }

    XSSFCellStyle headerYellowMedCenterWrap = null;

    public CellStyle headerYellowMedCenterWrap() {
        if (headerYellowMedCenterWrap == null) {
            headerYellowMedCenterWrap = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerYellowMedCenterWrap.setFont(fheaderblackbold);
            headerYellowMedCenterWrap.setWrapText(true);
            headerYellowMedCenterWrap.setAlignment(HorizontalAlignment.CENTER);
            headerYellowMedCenterWrap.setVerticalAlignment(VerticalAlignment.CENTER);
            headerYellowMedCenterWrap.setFillForegroundColor(med_yellow);
            headerYellowMedCenterWrap.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerYellowMedCenterWrap.setBorderBottom(BorderStyle.THIN);
        }
        return headerYellowMedCenterWrap;
    }

    XSSFCellStyle headerLightYellowCenterWrap = null;

    public CellStyle headerLightYellowCenterWrap() {
        if (headerLightYellowCenterWrap == null) {
            headerLightYellowCenterWrap = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerLightYellowCenterWrap.setFont(fheaderblackbold);
            headerLightYellowCenterWrap.setWrapText(true);
            headerLightYellowCenterWrap.setAlignment(HorizontalAlignment.CENTER);
            headerLightYellowCenterWrap.setVerticalAlignment(VerticalAlignment.CENTER);
            headerLightYellowCenterWrap.setFillForegroundColor(light_yellow);
            headerLightYellowCenterWrap.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerLightYellowCenterWrap.setBorderTop(BorderStyle.THIN);
            headerLightYellowCenterWrap.setBorderRight(BorderStyle.THIN);
            headerLightYellowCenterWrap.setBorderBottom(BorderStyle.THIN);
            headerLightYellowCenterWrap.setBorderLeft(BorderStyle.THIN);
        }
        return headerLightYellowCenterWrap;
    }

    XSSFCellStyle headerLightYellowLeft = null;

    public CellStyle headerLightYellowLeft() {
        if (headerLightYellowLeft == null) {
            headerLightYellowLeft = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerLightYellowLeft.setFont(fheaderblackbold);
            headerLightYellowLeft.setWrapText(false);
            headerLightYellowLeft.setAlignment(HorizontalAlignment.LEFT);
            headerLightYellowLeft.setVerticalAlignment(VerticalAlignment.CENTER);
            headerLightYellowLeft.setFillForegroundColor(light_yellow);
            headerLightYellowLeft.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerLightYellowLeft.setBorderTop(BorderStyle.THIN);
            headerLightYellowLeft.setBorderRight(BorderStyle.THIN);
            headerLightYellowLeft.setBorderBottom(BorderStyle.THIN);
            headerLightYellowLeft.setBorderLeft(BorderStyle.THIN);
        }
        return headerLightYellowLeft;
    }

    XSSFCellStyle headerDarkGreenLeft = null;

    public CellStyle headerDarkGreenLeft() {
        if (headerDarkGreenLeft == null) {
            headerDarkGreenLeft = (XSSFCellStyle) wb.createCellStyle();
            fheaderwhite(wb);
            headerDarkGreenLeft.setFont(fheaderwhite);
            headerDarkGreenLeft.setWrapText(false);
            headerDarkGreenLeft.setAlignment(HorizontalAlignment.LEFT);
            headerDarkGreenLeft.setVerticalAlignment(VerticalAlignment.BOTTOM);
            headerDarkGreenLeft.setFillForegroundColor(dark_green);
            headerDarkGreenLeft.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerDarkGreenLeft;
    }

    XSSFCellStyle headerDarkGreenCenter = null;

    public CellStyle headerDarkGreenCenter() {
        if (headerDarkGreenCenter == null) {
            headerDarkGreenCenter = (XSSFCellStyle) wb.createCellStyle();
            fheaderwhite(wb);
            headerDarkGreenCenter.setFont(fheaderwhite);
            headerDarkGreenCenter.setWrapText(false);
            headerDarkGreenCenter.setAlignment(HorizontalAlignment.CENTER);
            headerDarkGreenCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            headerDarkGreenCenter.setFillForegroundColor(dark_green);
            headerDarkGreenCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerDarkGreenCenter;
    }

    XSSFCellStyle headerGreyLightLeftWrap = null;

    public CellStyle headerGreyLightLeftWrap() {
        if (headerGreyLightLeftWrap == null) {
            headerGreyLightLeftWrap = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerGreyLightLeftWrap.setFont(fheaderblackbold);
            headerGreyLightLeftWrap.setWrapText(true);
            headerGreyLightLeftWrap.setAlignment(HorizontalAlignment.LEFT);
            headerGreyLightLeftWrap.setVerticalAlignment(VerticalAlignment.CENTER);
            headerGreyLightLeftWrap.setFillForegroundColor(gray_5);
            headerGreyLightLeftWrap.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerGreyLightLeftWrap;
    }

    XSSFCellStyle headerGreenLightLeft = null;

    public CellStyle headerGreenLightLeft() {
        if (headerGreenLightLeft == null) {
            headerGreenLightLeft = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerGreenLightLeft.setFont(fheaderblackbold);
            headerGreenLightLeft.setWrapText(false);
            headerGreenLightLeft.setAlignment(HorizontalAlignment.LEFT);
            headerGreenLightLeft.setVerticalAlignment(VerticalAlignment.CENTER);
            headerGreenLightLeft.setFillForegroundColor(green_light);
            headerGreenLightLeft.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerGreenLightLeft.setBorderRight(BorderStyle.THIN);
            headerGreenLightLeft.setBorderLeft(BorderStyle.THIN);
        }
        return headerGreenLightLeft;
    }

    XSSFCellStyle headerGreenLightCenter = null;

    public CellStyle headerGreenLightCenter() {
        if (headerGreenLightCenter == null) {
            headerGreenLightCenter = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerGreenLightCenter.setFont(fheaderblackbold);
            headerGreenLightCenter.setWrapText(true);
            headerGreenLightCenter.setAlignment(HorizontalAlignment.CENTER);
            headerGreenLightCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            headerGreenLightCenter.setFillForegroundColor(green_light);
            headerGreenLightCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerGreenLightCenter;
    }

    XSSFCellStyle headerYellowLightCenter = null;

    public CellStyle headerYellowLightCenter() {
        if (headerYellowLightCenter == null) {
            headerYellowLightCenter = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerYellowLightCenter.setFont(fheaderblackbold);
            headerYellowLightCenter.setWrapText(true);
            headerYellowLightCenter.setAlignment(HorizontalAlignment.CENTER);
            headerYellowLightCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            headerYellowLightCenter.setFillForegroundColor(yellow_light);
            headerYellowLightCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerYellowLightCenter.setBorderTop(BorderStyle.THIN);
            headerYellowLightCenter.setBorderRight(BorderStyle.THIN);
            headerYellowLightCenter.setBorderLeft(BorderStyle.THIN);
            headerYellowLightCenter.setBorderBottom(BorderStyle.THIN);
        }
        return headerYellowLightCenter;
    }

    XSSFCellStyle headerLightGreenCenterBorderBottom = null;

    public CellStyle headerLightGreenCenterBorderBottom() {
        if (headerLightGreenCenterBorderBottom == null) {
            headerLightGreenCenterBorderBottom = (XSSFCellStyle) wb.createCellStyle();
            fheaderboldwhite(wb);
            headerLightGreenCenterBorderBottom.setFont(fheaderboldwhite);
            headerLightGreenCenterBorderBottom.setWrapText(true);
            headerLightGreenCenterBorderBottom.setAlignment(HorizontalAlignment.CENTER);
            headerLightGreenCenterBorderBottom.setVerticalAlignment(VerticalAlignment.CENTER);
            headerLightGreenCenterBorderBottom.setFillForegroundColor(light_green);
            headerLightGreenCenterBorderBottom.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerLightGreenCenterBorderBottom.setBorderBottom(BorderStyle.THIN);
        }
        return headerLightGreenCenterBorderBottom;
    }

    XSSFCellStyle headerLightGreenCenter = null;

    public CellStyle headerLightGreenCenter() {
        if (headerLightGreenCenter == null) {
            headerLightGreenCenter = (XSSFCellStyle) wb.createCellStyle();
            fheaderboldwhite(wb);
            headerLightGreenCenter.setFont(fheaderboldwhite);
            headerLightGreenCenter.setWrapText(true);
            headerLightGreenCenter.setAlignment(HorizontalAlignment.CENTER);
            headerLightGreenCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            headerLightGreenCenter.setFillForegroundColor(light_green);
            headerLightGreenCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerLightGreenCenter.setBorderTop(BorderStyle.THIN);
            headerLightGreenCenter.setBorderRight(BorderStyle.THIN);
            headerLightGreenCenter.setBorderBottom(BorderStyle.THIN);
            headerLightGreenCenter.setBorderLeft(BorderStyle.THIN);
        }
        return headerLightGreenCenter;
    }

    XSSFCellStyle headerBrownBrownCenter = null;

    public CellStyle headerBrownBrownCenter() {
        if (headerBrownBrownCenter == null) {
            headerBrownBrownCenter = (XSSFCellStyle) wb.createCellStyle();
            fheaderboldwhite(wb);
            headerBrownBrownCenter.setFont(fheaderboldwhite);
            headerBrownBrownCenter.setWrapText(true);
            headerBrownBrownCenter.setAlignment(HorizontalAlignment.CENTER);
            headerBrownBrownCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            headerBrownBrownCenter.setFillForegroundColor(brownBrown);
            headerBrownBrownCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerBrownBrownCenter;
    }

    XSSFCellStyle headerBrownCenter = null;

    public CellStyle headerBrownCenter() {
        if (headerBrownCenter == null) {
            headerBrownCenter = (XSSFCellStyle) wb.createCellStyle();
            fheaderboldwhite(wb);
            headerBrownCenter.setFont(fheaderboldwhite);
            headerBrownCenter.setWrapText(true);
            headerBrownCenter.setAlignment(HorizontalAlignment.CENTER);
            headerBrownCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            headerBrownCenter.setFillForegroundColor(brown);
            headerBrownCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerBrownCenter.setBorderTop(BorderStyle.THIN);
            headerBrownCenter.setBorderRight(BorderStyle.THIN);
            headerBrownCenter.setBorderBottom(BorderStyle.THIN);
            headerBrownCenter.setBorderLeft(BorderStyle.THIN);
        }
        return headerBrownCenter;
    }

    XSSFCellStyle headerGreenLeft = null;

    public CellStyle headerGreenLeft() {
        if (headerGreenLeft == null) {
            headerGreenLeft = (XSSFCellStyle) wb.createCellStyle();
            fheaderwhite(wb);
            headerGreenLeft.setFont(fheaderwhite);
            headerGreenLeft.setWrapText(false);
            headerGreenLeft.setAlignment(HorizontalAlignment.LEFT);
            headerGreenLeft.setVerticalAlignment(VerticalAlignment.CENTER);
            headerGreenLeft.setFillForegroundColor(med_green);
            headerGreenLeft.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerGreenLeft;
    }

    XSSFCellStyle inteiroGreenLight = null;

    public CellStyle inteiroGreenLight() {
        if (inteiroGreenLight == null) {
            inteiroGreenLight = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            inteiroGreenLight.setFont(fheaderblackbold);
            inteiroGreenLight.setWrapText(false);
            inteiroGreenLight.setAlignment(HorizontalAlignment.RIGHT);
            inteiroGreenLight.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroGreenLight.setFillForegroundColor(green_light);
            inteiroGreenLight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            DataFormat df = wb.createDataFormat();
            inteiroGreenLight.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroGreenLight.setBorderRight(BorderStyle.THIN);
            inteiroGreenLight.setBorderLeft(BorderStyle.THIN);
        }
        return inteiroGreenLight;
    }

    XSSFCellStyle porcentoGreenLight = null;

    public CellStyle porcentoGreenLight() {
        if (porcentoGreenLight == null) {
            porcentoGreenLight = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            porcentoGreenLight.setFont(fheaderblackbold);
            porcentoGreenLight.setWrapText(false);
            porcentoGreenLight.setAlignment(HorizontalAlignment.RIGHT);
            porcentoGreenLight.setVerticalAlignment(VerticalAlignment.CENTER);
            porcentoGreenLight.setFillForegroundColor(green_light);
            porcentoGreenLight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            DataFormat dfEurosCent = wb.createDataFormat();
            porcentoGreenLight.setDataFormat(dfEurosCent.getFormat("0.00%"));
        }
        return porcentoGreenLight;
    }

    XSSFCellStyle headerPinkCenter = null;

    public CellStyle headerPinkCenter() {
        if (headerPinkCenter == null) {
            headerPinkCenter = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerPinkCenter.setFont(fheaderblackbold);
            headerPinkCenter.setWrapText(false);
            headerPinkCenter.setAlignment(HorizontalAlignment.CENTER);
            headerPinkCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            headerPinkCenter.setFillForegroundColor(pink);
            headerPinkCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerPinkCenter;
    }
    XSSFCellStyle headerPinkLeft = null;

    public CellStyle headerPinkLeft() {
        if (headerPinkLeft == null) {
            headerPinkLeft = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerPinkLeft.setFont(fheaderblackbold);
            headerPinkLeft.setWrapText(false);
            headerPinkLeft.setAlignment(HorizontalAlignment.LEFT);
            headerPinkLeft.setVerticalAlignment(VerticalAlignment.CENTER);
            headerPinkLeft.setFillForegroundColor(pink);
            headerPinkLeft.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerPinkLeft;
    }

    XSSFCellStyle headerPinkLeftWrap = null;

    public CellStyle headerPinkLeftWrap() {
        if (headerPinkLeftWrap == null) {
            headerPinkLeftWrap = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            headerPinkLeftWrap.setFont(fheaderblackbold);
            headerPinkLeftWrap.setWrapText(true);
            headerPinkLeftWrap.setAlignment(HorizontalAlignment.LEFT);
            headerPinkLeftWrap.setVerticalAlignment(VerticalAlignment.CENTER);
            headerPinkLeftWrap.setFillForegroundColor(pink);
            headerPinkLeftWrap.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerPinkLeftWrap;
    }

    XSSFCellStyle GreenCell = null;

    public CellStyle GreenCell() {
        if (GreenCell == null) {
            GreenCell = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            GreenCell.setFont(fnormal);
            GreenCell.setWrapText(false);
            GreenCell.setAlignment(HorizontalAlignment.LEFT);
            GreenCell.setVerticalAlignment(VerticalAlignment.CENTER);
            GreenCell.setFillForegroundColor(green_light);
            GreenCell.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return GreenCell;
    }

    XSSFCellStyle LightOrangeCell = null;

    public CellStyle LightOrangeCell() {
        if (LightOrangeCell == null) {
            LightOrangeCell = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            LightOrangeCell.setFont(fnormal);
            LightOrangeCell.setWrapText(false);
            LightOrangeCell.setAlignment(HorizontalAlignment.LEFT);
            LightOrangeCell.setVerticalAlignment(VerticalAlignment.CENTER);
            LightOrangeCell.setFillForegroundColor(orange_light);
            LightOrangeCell.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return LightOrangeCell;
    }

    XSSFCellStyle normal = null;

    public CellStyle normal() {
        if (normal == null) {
            normal = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            normal.setFont(fnormal);
            normal.setWrapText(false);
            normal.setAlignment(HorizontalAlignment.LEFT);
            normal.setVerticalAlignment(VerticalAlignment.CENTER);
        }
        return normal;
    }

    XSSFCellStyle normalOrange = null;

    public CellStyle normalOrange() {
        if (normalOrange == null) {
            normalOrange = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            normalOrange.setFont(fnormal);
            normalOrange.setWrapText(false);
            normalOrange.setAlignment(HorizontalAlignment.LEFT);
            normalOrange.setVerticalAlignment(VerticalAlignment.CENTER);
            normalOrange.setFillForegroundColor(epharma_orange);
            normalOrange.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return normalOrange;
    }

    XSSFCellStyle normal11 = null;

    public CellStyle normal11() {
        if (normal11 == null) {
            normal11 = (XSSFCellStyle) wb.createCellStyle();
            fnormal11(wb);
            normal11.setFont(fnormal11);
            normal11.setWrapText(false);
            normal11.setAlignment(HorizontalAlignment.LEFT);
            normal11.setVerticalAlignment(VerticalAlignment.CENTER);
            normal11.setFillForegroundColor(white);
            normal11.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            normal11.setBorderRight(BorderStyle.THIN);
            normal11.setBorderLeft(BorderStyle.THIN);
        }
        return normal11;
    }

    XSSFCellStyle normalWithBorders = null;

    public CellStyle normalWithBorders() {
        if (normalWithBorders == null) {
            normalWithBorders = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            normalWithBorders.setFont(fnormal);
            normalWithBorders.setWrapText(false);
            normalWithBorders.setAlignment(HorizontalAlignment.LEFT);
            normalWithBorders.setVerticalAlignment(VerticalAlignment.CENTER);
            normalWithBorders.setFillForegroundColor(white);
            normalWithBorders.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            normalWithBorders.setBorderRight(BorderStyle.THIN);
            normalWithBorders.setBorderLeft(BorderStyle.THIN);
            normalWithBorders.setBorderTop(BorderStyle.THIN);
            normalWithBorders.setBorderBottom(BorderStyle.THIN);
        }
        return normalWithBorders;
    }

    XSSFCellStyle normalWrap = null;

    public CellStyle normalWrap() {
        if (normalWrap == null) {
            normalWrap = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            normalWrap.setFont(fnormal);
            normalWrap.setWrapText(true);
            normalWrap.setAlignment(HorizontalAlignment.LEFT);
            normalWrap.setVerticalAlignment(VerticalAlignment.CENTER);
            //normal.setBorderBottom(BorderStyle.DASHED);
            //normal.setBottomBorderColor(gray_5);  
        }
        return normalWrap;
    }

    XSSFCellStyle normalCenter = null;

    public CellStyle normalCenter() {
        if (normalCenter == null) {
            normalCenter = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            normalCenter.setFont(fnormal);
            normalCenter.setWrapText(false);
            normalCenter.setAlignment(HorizontalAlignment.CENTER);
            normalCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            //normal.setBorderBottom(BorderStyle.DASHED);
            //normal.setBottomBorderColor(gray_5);  
        }
        return normalCenter;
    }

    XSSFCellStyle normalGreen = null;

    public CellStyle normalGreen() {
        if (normalGreen == null) {
            normalGreen = (XSSFCellStyle) wb.createCellStyle();
            fnormalgreen(wb);
            normalGreen.setFont(fnormalgreen);
            normalGreen.setWrapText(false);
            normalGreen.setAlignment(HorizontalAlignment.LEFT);
            normalGreen.setVerticalAlignment(VerticalAlignment.CENTER);
            //normal.setBorderBottom(BorderStyle.DASHED);
            //normal.setBottomBorderColor(gray_5);  
        }
        return normalGreen;
    }

    XSSFCellStyle normalRed = null;

    public CellStyle normalRed() {
        if (normalRed == null) {
            normalRed = (XSSFCellStyle) wb.createCellStyle();
            fnormalred(wb);
            normalRed.setFont(fnormalred);
            normalRed.setWrapText(false);
            normalRed.setAlignment(HorizontalAlignment.LEFT);
            normalRed.setVerticalAlignment(VerticalAlignment.CENTER);
            //normal.setBorderBottom(BorderStyle.DASHED);
            //normal.setBottomBorderColor(gray_5);  
        }
        return normalRed;
    }

    XSSFCellStyle normalCenterGrey = null;

    public CellStyle normalCenterGrey() {
        if (normalCenterGrey == null) {
            normalCenterGrey = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            normalCenterGrey.setFont(fnormal);
            normalCenterGrey.setWrapText(false);
            normalCenterGrey.setAlignment(HorizontalAlignment.CENTER);
            normalCenterGrey.setVerticalAlignment(VerticalAlignment.CENTER);
            normalCenterGrey.setFillForegroundColor(gray_5);
            normalCenterGrey.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return normalCenterGrey;
    }

    XSSFCellStyle decimal = null;

    public CellStyle decimal() {
        if (decimal == null) {
            decimal = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            decimal.setFont(fnormal);
            DataFormat df = wb.createDataFormat();
            decimal.setDataFormat(df.getFormat("###,###,##0.00"));
            decimal.setWrapText(false);
            decimal.setAlignment(HorizontalAlignment.RIGHT);
            decimal.setVerticalAlignment(VerticalAlignment.CENTER);
        }
        return decimal;
    }

    XSSFCellStyle decimalGreyBold = null;

    public CellStyle decimalGreyBold() {
        if (decimalGreyBold == null) {
            decimalGreyBold = (XSSFCellStyle) wb.createCellStyle();
            fbold(wb);
            decimalGreyBold.setFont(fbold);
            DataFormat df = wb.createDataFormat();
            decimalGreyBold.setDataFormat(df.getFormat("###,###,##0.00"));
            decimalGreyBold.setWrapText(false);
            decimalGreyBold.setAlignment(HorizontalAlignment.RIGHT);
            decimalGreyBold.setVerticalAlignment(VerticalAlignment.CENTER);
            decimalGreyBold.setFillForegroundColor(gray_5);
            decimalGreyBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return decimalGreyBold;
    }

    XSSFCellStyle eurosCent = null;

    public CellStyle eurosCent() {
        if (eurosCent == null) {
            eurosCent = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            eurosCent.setFont(fnormal);
            DataFormat df = wb.createDataFormat();
            eurosCent.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCent.setWrapText(false);
            eurosCent.setAlignment(HorizontalAlignment.RIGHT);
            eurosCent.setVerticalAlignment(VerticalAlignment.CENTER);
        }
        return eurosCent;
    }

    XSSFCellStyle eurosCentOrange = null;

    public CellStyle eurosCentOrange() {
        if (eurosCentOrange == null) {
            eurosCentOrange = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            eurosCentOrange.setFont(fnormal);
            DataFormat df = wb.createDataFormat();
            eurosCentOrange.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentOrange.setWrapText(false);
            eurosCentOrange.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentOrange.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentOrange.setFillForegroundColor(epharma_orange);
            eurosCentOrange.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return eurosCentOrange;
    }

    XSSFCellStyle eurosCentGreenDark = null;

    public CellStyle eurosCentGreenDark() {
        if (eurosCentGreenDark == null) {
            eurosCentGreenDark = (XSSFCellStyle) wb.createCellStyle();
            fheaderboldwhite(wb);
            eurosCentGreenDark.setFont(fheaderboldwhite);
            DataFormat df = wb.createDataFormat();
            eurosCentGreenDark.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentGreenDark.setWrapText(false);
            eurosCentGreenDark.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentGreenDark.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentGreenDark.setFillForegroundColor(dark_green);
            eurosCentGreenDark.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return eurosCentGreenDark;
    }
    XSSFCellStyle eurosCentGreenBold = null;

    public CellStyle eurosCentGreenBold() {
        if (eurosCentGreenBold == null) {
            eurosCentGreenBold = (XSSFCellStyle) wb.createCellStyle();
            fheaderboldwhite(wb);
            eurosCentGreenBold.setFont(fheaderboldwhite);
            DataFormat df = wb.createDataFormat();
            eurosCentGreenBold.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentGreenBold.setWrapText(false);
            eurosCentGreenBold.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentGreenBold.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentGreenBold.setFillForegroundColor(med_green);
            eurosCentGreenBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            eurosCentGreenBold.setBorderTop(BorderStyle.THIN);
            eurosCentGreenBold.setBorderRight(BorderStyle.THIN);
            eurosCentGreenBold.setBorderBottom(BorderStyle.THIN);
            eurosCentGreenBold.setBorderLeft(BorderStyle.THIN);
        }
        return eurosCentGreenBold;
    }

    XSSFCellStyle eurosCentGreen = null;

    public CellStyle eurosCentGreen() {
        if (eurosCentGreen == null) {
            eurosCentGreen = (XSSFCellStyle) wb.createCellStyle();
            fnormalwhite(wb);
            eurosCentGreen.setFont(fnormalwhite);
            DataFormat df = wb.createDataFormat();
            eurosCentGreen.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentGreen.setWrapText(false);
            eurosCentGreen.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentGreen.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentGreen.setFillForegroundColor(med_green);
            eurosCentGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return eurosCentGreen;
    }

    XSSFCellStyle eurosCentNormal = null;

    public CellStyle eurosCentNormal() {
        if (eurosCentNormal == null) {
            eurosCentNormal = (XSSFCellStyle) wb.createCellStyle();
            fnormal11(wb);
            eurosCentNormal.setFont(fnormal11);
            DataFormat df = wb.createDataFormat();
            eurosCentNormal.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentNormal.setWrapText(false);
            eurosCentNormal.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentNormal.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentNormal.setFillForegroundColor(gray_6);
            eurosCentNormal.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            eurosCentNormal.setBorderRight(BorderStyle.THIN);
            eurosCentNormal.setBorderLeft(BorderStyle.THIN);
        }
        return eurosCentNormal;
    }

    XSSFCellStyle eurosCentNormalBold = null;

    public CellStyle eurosCentNormalBold() {
        if (eurosCentNormalBold == null) {
            eurosCentNormalBold = (XSSFCellStyle) wb.createCellStyle();
            fnormalbold11(wb);
            eurosCentNormalBold.setFont(fnormalbold11);
            DataFormat df = wb.createDataFormat();
            eurosCentNormalBold.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentNormalBold.setWrapText(false);
            eurosCentNormalBold.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentNormalBold.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentNormalBold.setFillForegroundColor(gray_6);
            eurosCentNormalBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            eurosCentNormalBold.setBorderRight(BorderStyle.THIN);
            eurosCentNormalBold.setBorderLeft(BorderStyle.THIN);
        }
        return eurosCentNormalBold;
    }
    XSSFCellStyle eurosCentGreyLighter = null;

    public CellStyle eurosCentGreyLighter() {
        if (eurosCentGreyLighter == null) {
            eurosCentGreyLighter = (XSSFCellStyle) wb.createCellStyle();
            fnormalbold11(wb);
            eurosCentGreyLighter.setFont(fnormalbold11);
            DataFormat df = wb.createDataFormat();
            eurosCentGreyLighter.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentGreyLighter.setWrapText(false);
            eurosCentGreyLighter.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentGreyLighter.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentGreyLighter.setFillForegroundColor(lighter_grey);
            eurosCentGreyLighter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            eurosCentGreyLighter.setBorderTop(BorderStyle.THIN);
            eurosCentGreyLighter.setBorderRight(BorderStyle.THIN);
            eurosCentGreyLighter.setBorderBottom(BorderStyle.THIN);
            eurosCentGreyLighter.setBorderLeft(BorderStyle.THIN);
        }
        return eurosCentGreyLighter;
    }

    XSSFCellStyle eurosCentGreyLight = null;

    public CellStyle eurosCentGreyLight() {
        if (eurosCentGreyLight == null) {
            eurosCentGreyLight = (XSSFCellStyle) wb.createCellStyle();
            fheaderboldwhite(wb);
            eurosCentGreyLight.setFont(fheaderboldwhite);
            DataFormat df = wb.createDataFormat();
            eurosCentGreyLight.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentGreyLight.setWrapText(false);
            eurosCentGreyLight.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentGreyLight.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentGreyLight.setFillForegroundColor(light_grey);
            eurosCentGreyLight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return eurosCentGreyLight;
    }

    XSSFCellStyle eurosCentGreyLighterBlack = null;

    public CellStyle eurosCentGreyLighterBlack() {
        if (eurosCentGreyLighterBlack == null) {
            eurosCentGreyLighterBlack = (XSSFCellStyle) wb.createCellStyle();
            fbold(wb);
            eurosCentGreyLighterBlack.setFont(fbold);
            DataFormat df = wb.createDataFormat();
            eurosCentGreyLighterBlack.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentGreyLighterBlack.setWrapText(false);
            eurosCentGreyLighterBlack.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentGreyLighterBlack.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentGreyLighterBlack.setFillForegroundColor(lighter_grey);
            eurosCentGreyLighterBlack.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return eurosCentGreyLighterBlack;
    }

    XSSFCellStyle eurosCentGrey = null;

    public CellStyle eurosCentGrey() {
        if (eurosCentGrey == null) {
            eurosCentGrey = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            eurosCentGrey.setFont(fnormal);
            DataFormat df = wb.createDataFormat();
            eurosCentGrey.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentGrey.setWrapText(false);
            eurosCentGrey.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentGrey.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentGrey.setFillForegroundColor(gray_5);
            eurosCentGrey.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return eurosCentGrey;
    }

    XSSFCellStyle eurosCentYellowLight = null;

    public CellStyle eurosCentYellowLight() {
        if (eurosCentYellowLight == null) {
            eurosCentYellowLight = (XSSFCellStyle) wb.createCellStyle();
            fnormalbold11(wb);
            eurosCentYellowLight.setFont(fnormalbold11);
            DataFormat df = wb.createDataFormat();
            eurosCentYellowLight.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentYellowLight.setWrapText(false);
            eurosCentYellowLight.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentYellowLight.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentYellowLight.setFillForegroundColor(light_yellow);
            eurosCentYellowLight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            eurosCentYellowLight.setBorderTop(BorderStyle.THIN);
            eurosCentYellowLight.setBorderRight(BorderStyle.THIN);
            eurosCentYellowLight.setBorderLeft(BorderStyle.THIN);
            eurosCentYellowLight.setBorderBottom(BorderStyle.THIN);
        }
        return eurosCentYellowLight;
    }

    XSSFCellStyle eurosCentYellow = null;

    public CellStyle eurosCentYellow() {
        if (eurosCentYellow == null) {
            eurosCentYellow = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            eurosCentYellow.setFont(fnormal);
            DataFormat df = wb.createDataFormat();
            eurosCentYellow.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentYellow.setWrapText(false);
            eurosCentYellow.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentYellow.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentYellow.setFillForegroundColor(yellow);
            eurosCentYellow.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return eurosCentYellow;
    }

    XSSFCellStyle eurosCentLightGreenCenter = null;

    public CellStyle eurosCentLightGreenCenter() {
        if (eurosCentLightGreenCenter == null) {
            eurosCentLightGreenCenter = (XSSFCellStyle) wb.createCellStyle();
            fheaderboldwhite(wb);
            eurosCentLightGreenCenter.setFont(fheaderboldwhite);
            DataFormat df = wb.createDataFormat();
            eurosCentLightGreenCenter.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentLightGreenCenter.setWrapText(true);
            eurosCentLightGreenCenter.setAlignment(HorizontalAlignment.CENTER);
            eurosCentLightGreenCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentLightGreenCenter.setFillForegroundColor(light_green);
            eurosCentLightGreenCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            eurosCentLightGreenCenter.setBorderRight(BorderStyle.THIN);
            eurosCentLightGreenCenter.setBorderLeft(BorderStyle.THIN);
        }
        return eurosCentLightGreenCenter;
    }

    XSSFCellStyle eurosCentPureYellowRight = null;

    public CellStyle eurosCentPureYellowRight() {
        if (eurosCentPureYellowRight == null) {
            eurosCentPureYellowRight = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            eurosCentPureYellowRight.setFont(fheaderblackbold);
            DataFormat df = wb.createDataFormat();
            eurosCentPureYellowRight.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentPureYellowRight.setWrapText(true);
            eurosCentPureYellowRight.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentPureYellowRight.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentPureYellowRight.setFillForegroundColor(pure_yellow);
            eurosCentPureYellowRight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            eurosCentPureYellowRight.setBorderRight(BorderStyle.THIN);
            eurosCentPureYellowRight.setBorderLeft(BorderStyle.THIN);
        }
        return eurosCentPureYellowRight;
    }

    XSSFCellStyle porcentoPureYellowRight = null;

    public CellStyle porcentoPureYellowRight() {
        if (porcentoPureYellowRight == null) {
            porcentoPureYellowRight = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            porcentoPureYellowRight.setFont(fheaderblackbold);
            porcentoPureYellowRight.setWrapText(false);
            porcentoPureYellowRight.setAlignment(HorizontalAlignment.RIGHT);
            porcentoPureYellowRight.setVerticalAlignment(VerticalAlignment.CENTER);
            porcentoPureYellowRight.setFillForegroundColor(pure_yellow);
            porcentoPureYellowRight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            DataFormat dfEurosCent = wb.createDataFormat();
            porcentoPureYellowRight.setDataFormat(dfEurosCent.getFormat("0.00%"));
            porcentoPureYellowRight.setBorderRight(BorderStyle.THIN);
            porcentoPureYellowRight.setBorderLeft(BorderStyle.THIN);
        }
        return porcentoPureYellowRight;
    }

    XSSFCellStyle eurosCentBlueDarker = null;

    public CellStyle eurosCentBlueDarker() {
        if (eurosCentBlueDarker == null) {
            eurosCentBlueDarker = (XSSFCellStyle) wb.createCellStyle();
            fnormalbold11(wb);
            eurosCentBlueDarker.setFont(fnormalbold11);
            DataFormat df = wb.createDataFormat();
            eurosCentBlueDarker.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentBlueDarker.setWrapText(false);
            eurosCentBlueDarker.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentBlueDarker.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentBlueDarker.setFillForegroundColor(dark_blue);
            eurosCentBlueDarker.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return eurosCentBlueDarker;
    }

    XSSFCellStyle normalBlueLighter = null;

    public CellStyle normalBlueLighter() {
        if (normalBlueLighter == null) {
            normalBlueLighter = (XSSFCellStyle) wb.createCellStyle();
            fnormalbold11(wb);
            normalBlueLighter.setFont(fnormalbold11);
            normalBlueLighter.setWrapText(false);
            normalBlueLighter.setAlignment(HorizontalAlignment.LEFT);
            normalBlueLighter.setVerticalAlignment(VerticalAlignment.CENTER);
            normalBlueLighter.setFillForegroundColor(lighter_blue);
            normalBlueLighter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            normalBlueLighter.setBorderRight(BorderStyle.THIN);
            normalBlueLighter.setBorderLeft(BorderStyle.THIN);
        }
        return normalBlueLighter;
    }

    XSSFCellStyle eurosCentBlueLighter = null;

    public CellStyle eurosCentBlueLighter() {
        if (eurosCentBlueLighter == null) {
            eurosCentBlueLighter = (XSSFCellStyle) wb.createCellStyle();
            fnormalbold11(wb);
            eurosCentBlueLighter.setFont(fnormalbold11);
            DataFormat df = wb.createDataFormat();
            eurosCentBlueLighter.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentBlueLighter.setWrapText(false);
            eurosCentBlueLighter.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentBlueLighter.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentBlueLighter.setFillForegroundColor(lighter_blue);
            eurosCentBlueLighter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            eurosCentBlueLighter.setBorderRight(BorderStyle.THIN);
            eurosCentBlueLighter.setBorderLeft(BorderStyle.THIN);
        }
        return eurosCentBlueLighter;
    }

    XSSFCellStyle eurosCentSkyBlue = null;

    public CellStyle eurosCentSkyBlue() {
        if (eurosCentSkyBlue == null) {
            eurosCentSkyBlue = (XSSFCellStyle) wb.createCellStyle();
            fnormalbold11(wb);
            eurosCentSkyBlue.setFont(fheaderwhite);
            DataFormat df = wb.createDataFormat();
            eurosCentSkyBlue.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentSkyBlue.setWrapText(false);
            eurosCentSkyBlue.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentSkyBlue.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentSkyBlue.setFillForegroundColor(sky_blue);
            eurosCentSkyBlue.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            eurosCentSkyBlue.setBorderRight(BorderStyle.THIN);
            eurosCentSkyBlue.setBorderLeft(BorderStyle.THIN);
        }
        return eurosCentSkyBlue;
    }

    XSSFCellStyle eurosCentBlueLight = null;

    public CellStyle eurosCentBlueLight() {
        if (eurosCentBlueLight == null) {
            eurosCentBlueLight = (XSSFCellStyle) wb.createCellStyle();
            fnormalbold11(wb);
            eurosCentBlueLight.setFont(fnormalbold11);
            DataFormat df = wb.createDataFormat();
            eurosCentBlueLight.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentBlueLight.setWrapText(false);
            eurosCentBlueLight.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentBlueLight.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentBlueLight.setFillForegroundColor(light_blue);
            eurosCentBlueLight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            eurosCentBlueLight.setBorderRight(BorderStyle.THIN);
            eurosCentBlueLight.setBorderLeft(BorderStyle.THIN);
        }
        return eurosCentBlueLight;
    }

    XSSFCellStyle eurosCentGreenLight = null;

    public CellStyle eurosCentGreenLight() {
        if (eurosCentGreenLight == null) {
            eurosCentGreenLight = (XSSFCellStyle) wb.createCellStyle();
            fnormalbold11(wb);
            eurosCentGreenLight.setFont(fnormalbold11);
            DataFormat df = wb.createDataFormat();
            eurosCentGreenLight.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentGreenLight.setWrapText(false);
            eurosCentGreenLight.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentGreenLight.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentGreenLight.setFillForegroundColor(green_light);
            eurosCentGreenLight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            eurosCentGreenLight.setBorderRight(BorderStyle.THIN);
            eurosCentGreenLight.setBorderLeft(BorderStyle.THIN);
        }
        return eurosCentGreenLight;
    }

    XSSFCellStyle eurosCentRed = null;

    public CellStyle eurosCentRed() {
        if (eurosCentRed == null) {
            eurosCentRed = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            eurosCentRed.setFont(fnormalwhite);
            DataFormat df = wb.createDataFormat();
            eurosCentRed.setDataFormat(df.getFormat("###,###,##0.00€"));
            eurosCentRed.setWrapText(false);
            eurosCentRed.setAlignment(HorizontalAlignment.RIGHT);
            eurosCentRed.setVerticalAlignment(VerticalAlignment.CENTER);
            eurosCentRed.setFillForegroundColor(red);
            eurosCentRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return eurosCentRed;
    }

    XSSFCellStyle inteiro = null;

    public CellStyle inteiro() {
        if (inteiro == null) {
            inteiro = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            inteiro.setFont(fnormal);
            DataFormat df = wb.createDataFormat();
            inteiro.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiro.setWrapText(false);
            inteiro.setAlignment(HorizontalAlignment.RIGHT);
            inteiro.setVerticalAlignment(VerticalAlignment.CENTER);
        }
        return inteiro;
    }
    XSSFCellStyle inteiroWithBorders = null;

    public CellStyle inteiroWithBorders() {
        if (inteiroWithBorders == null) {
            inteiroWithBorders = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            inteiroWithBorders.setFont(fnormal);
            DataFormat df = wb.createDataFormat();
            inteiroWithBorders.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroWithBorders.setWrapText(false);
            inteiroWithBorders.setAlignment(HorizontalAlignment.RIGHT);
            inteiroWithBorders.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroWithBorders.setBorderRight(BorderStyle.THIN);
            inteiroWithBorders.setBorderLeft(BorderStyle.THIN);
            inteiroWithBorders.setBorderTop(BorderStyle.THIN);
            inteiroWithBorders.setBorderBottom(BorderStyle.THIN);
        }
        return inteiroWithBorders;
    }

    XSSFCellStyle inteiroOrange = null;

    public CellStyle inteiroOrange() {
        if (inteiroOrange == null) {
            inteiroOrange = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            inteiroOrange.setFont(fnormal);
            DataFormat df = wb.createDataFormat();
            inteiroOrange.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroOrange.setWrapText(false);
            inteiroOrange.setAlignment(HorizontalAlignment.RIGHT);
            inteiroOrange.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroOrange.setFillForegroundColor(epharma_orange);
            inteiroOrange.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return inteiroOrange;
    }

    XSSFCellStyle inteiroNormal = null;

    public CellStyle inteiroNormal() {
        if (inteiroNormal == null) {
            inteiroNormal = (XSSFCellStyle) wb.createCellStyle();
            fnormal11(wb);
            inteiroNormal.setFont(fnormal11);
            DataFormat df = wb.createDataFormat();
            inteiroNormal.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroNormal.setWrapText(false);
            inteiroNormal.setAlignment(HorizontalAlignment.RIGHT);
            inteiroNormal.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroNormal.setFillForegroundColor(gray_6);
            inteiroNormal.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            inteiroNormal.setBorderRight(BorderStyle.THIN);
            inteiroNormal.setBorderLeft(BorderStyle.THIN);
        }
        return inteiroNormal;
    }

    XSSFCellStyle inteiroNormalBold = null;

    public CellStyle inteiroNormalBold() {
        if (inteiroNormalBold == null) {
            inteiroNormalBold = (XSSFCellStyle) wb.createCellStyle();
            fnormalbold11(wb);
            inteiroNormalBold.setFont(fnormalbold11);
            DataFormat df = wb.createDataFormat();
            inteiroNormalBold.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroNormalBold.setWrapText(false);
            inteiroNormalBold.setAlignment(HorizontalAlignment.RIGHT);
            inteiroNormalBold.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroNormalBold.setFillForegroundColor(gray_6);
            inteiroNormalBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            inteiroNormalBold.setBorderRight(BorderStyle.THIN);
            inteiroNormalBold.setBorderLeft(BorderStyle.THIN);
        }
        return inteiroNormalBold;
    }

    XSSFCellStyle inteiroGreen = null;

    public CellStyle inteiroGreen() {
        if (inteiroGreen == null) {
            inteiroGreen = (XSSFCellStyle) wb.createCellStyle();
            fnormalwhite(wb);
            inteiroGreen.setFont(fnormalwhite);
            DataFormat df = wb.createDataFormat();
            inteiroGreen.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroGreen.setWrapText(false);
            inteiroGreen.setAlignment(HorizontalAlignment.RIGHT);
            inteiroGreen.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroGreen.setFillForegroundColor(med_green);
            inteiroGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return inteiroGreen;
    }

    XSSFCellStyle inteiroRed = null;

    public CellStyle inteiroRed() {
        if (inteiroRed == null) {
            inteiroRed = (XSSFCellStyle) wb.createCellStyle();
            fnormalwhite(wb);
            inteiroRed.setFont(fnormalwhite);
            DataFormat df = wb.createDataFormat();
            inteiroRed.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroRed.setWrapText(false);
            inteiroRed.setAlignment(HorizontalAlignment.RIGHT);
            inteiroRed.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroRed.setFillForegroundColor(red);
            inteiroRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return inteiroRed;
    }

    XSSFCellStyle inteiroRedtxt = null;

    public CellStyle inteiroRedtxt() {
        if (inteiroRedtxt == null) {
            inteiroRedtxt = (XSSFCellStyle) wb.createCellStyle();
            fnormalred(wb);
            inteiroRedtxt.setFont(fnormalred);
            DataFormat df = wb.createDataFormat();
            inteiroRedtxt.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroRedtxt.setWrapText(false);
            inteiroRedtxt.setAlignment(HorizontalAlignment.RIGHT);
            inteiroRedtxt.setVerticalAlignment(VerticalAlignment.CENTER);
        }
        return inteiroRedtxt;
    }

    XSSFCellStyle inteiroGrey = null;

    public CellStyle inteiroGrey() {
        if (inteiroGrey == null) {
            inteiroGrey = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            inteiroGrey.setFont(fnormal);
            DataFormat df = wb.createDataFormat();
            inteiroGrey.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroGrey.setWrapText(false);
            inteiroGrey.setAlignment(HorizontalAlignment.RIGHT);
            inteiroGrey.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroGrey.setFillForegroundColor(gray_5);
            inteiroGrey.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return inteiroGrey;
    }

    XSSFCellStyle inteiroGreyMed = null;

    public CellStyle inteiroGreyMed() {
        if (inteiroGreyMed == null) {
            inteiroGreyMed = (XSSFCellStyle) wb.createCellStyle();
            fbold(wb);
            inteiroGreyMed.setFont(fbold);
            DataFormat df = wb.createDataFormat();
            inteiroGreyMed.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroGreyMed.setWrapText(false);
            inteiroGreyMed.setAlignment(HorizontalAlignment.RIGHT);
            inteiroGreyMed.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroGreyMed.setFillForegroundColor(lighter_grey);
            inteiroGreyMed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return inteiroGreyMed;
    }

    XSSFCellStyle inteiroGreyBold = null;

    public CellStyle inteiroGreyBold() {
        if (inteiroGreyBold == null) {
            inteiroGreyBold = (XSSFCellStyle) wb.createCellStyle();
            fbold(wb);
            inteiroGreyBold.setFont(fbold);
            DataFormat df = wb.createDataFormat();
            inteiroGreyBold.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroGreyBold.setWrapText(false);
            inteiroGreyBold.setAlignment(HorizontalAlignment.RIGHT);
            inteiroGreyBold.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroGreyBold.setFillForegroundColor(gray_5);
            inteiroGreyBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return inteiroGreyBold;
    }
    XSSFCellStyle inteiroYellow = null;

    public CellStyle inteiroYellow() {
        if (inteiroYellow == null) {
            inteiroYellow = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            inteiroYellow.setFont(fnormal);
            DataFormat df = wb.createDataFormat();
            inteiroYellow.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroYellow.setWrapText(false);
            inteiroYellow.setAlignment(HorizontalAlignment.RIGHT);
            inteiroYellow.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroYellow.setFillForegroundColor(yellow);
            inteiroYellow.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return inteiroYellow;
    }

    XSSFCellStyle inteiroYellowBold = null;

    public CellStyle inteiroYellowBold() {
        if (inteiroYellowBold == null) {
            inteiroYellowBold = (XSSFCellStyle) wb.createCellStyle();
            fnormalbold11(wb);
            inteiroYellowBold.setFont(fnormalbold11);
            DataFormat df = wb.createDataFormat();
            inteiroYellowBold.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroYellowBold.setWrapText(false);
            inteiroYellowBold.setAlignment(HorizontalAlignment.RIGHT);
            inteiroYellowBold.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroYellowBold.setFillForegroundColor(yellow);
            inteiroYellowBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return inteiroYellowBold;
    }

    XSSFCellStyle inteiroLightGreenCenter = null;

    public CellStyle inteiroLightGreenCenter() {
        if (inteiroLightGreenCenter == null) {
            inteiroLightGreenCenter = (XSSFCellStyle) wb.createCellStyle();
            fheaderboldwhite(wb);
            inteiroLightGreenCenter.setFont(fheaderboldwhite);
            DataFormat df = wb.createDataFormat();
            inteiroLightGreenCenter.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroLightGreenCenter.setWrapText(true);
            inteiroLightGreenCenter.setAlignment(HorizontalAlignment.CENTER);
            inteiroLightGreenCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroLightGreenCenter.setFillForegroundColor(light_green);
            inteiroLightGreenCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            inteiroLightGreenCenter.setBorderRight(BorderStyle.THIN);
            inteiroLightGreenCenter.setBorderLeft(BorderStyle.THIN);
        }
        return inteiroLightGreenCenter;
    }

    XSSFCellStyle inteiroPureYellowRight = null;

    public CellStyle inteiroPureYellowRight() {
        if (inteiroPureYellowRight == null) {
            inteiroPureYellowRight = (XSSFCellStyle) wb.createCellStyle();
            fheaderblackbold(wb);
            inteiroPureYellowRight.setFont(fheaderblackbold);
            DataFormat df = wb.createDataFormat();
            inteiroPureYellowRight.setDataFormat(df.getFormat("#,###,###,##0"));
            inteiroPureYellowRight.setWrapText(true);
            inteiroPureYellowRight.setAlignment(HorizontalAlignment.RIGHT);
            inteiroPureYellowRight.setVerticalAlignment(VerticalAlignment.CENTER);
            inteiroPureYellowRight.setFillForegroundColor(pure_yellow);
            inteiroPureYellowRight.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            inteiroPureYellowRight.setBorderRight(BorderStyle.THIN);
            inteiroPureYellowRight.setBorderLeft(BorderStyle.THIN);
        }
        return inteiroPureYellowRight;
    }

    XSSFCellStyle porcento = null;

    public CellStyle porcento() {
        if (porcento == null) {
            porcento = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            porcento.setFont(fnormal);
            DataFormat dfEurosCent = wb.createDataFormat();
            porcento.setDataFormat(dfEurosCent.getFormat("0.00%"));
            porcento.setWrapText(false);
            porcento.setAlignment(HorizontalAlignment.RIGHT);
            porcento.setVerticalAlignment(VerticalAlignment.CENTER);
        }
        return porcento;
    }

    XSSFCellStyle porcentoOrange = null;

    public CellStyle porcentoOrange() {
        if (porcentoOrange == null) {
            porcentoOrange = (XSSFCellStyle) wb.createCellStyle();
            fnormal(wb);
            porcentoOrange.setFont(fnormal);
            DataFormat dfEurosCent = wb.createDataFormat();
            porcentoOrange.setDataFormat(dfEurosCent.getFormat("0.00%"));
            porcentoOrange.setWrapText(false);
            porcentoOrange.setAlignment(HorizontalAlignment.RIGHT);
            porcentoOrange.setVerticalAlignment(VerticalAlignment.CENTER);
            porcentoOrange.setFillForegroundColor(epharma_orange);
            porcentoOrange.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return porcentoOrange;
    }

    XSSFCellStyle porcentoNormal = null;

    public CellStyle porcentoNormal() {
        if (porcentoNormal == null) {
            porcentoNormal = (XSSFCellStyle) wb.createCellStyle();
            fnormal11(wb);
            porcentoNormal.setFont(fnormal11);
            DataFormat dfEurosCent = wb.createDataFormat();
            porcentoNormal.setDataFormat(dfEurosCent.getFormat("0.00%"));
            porcentoNormal.setWrapText(false);
            porcentoNormal.setAlignment(HorizontalAlignment.RIGHT);
            porcentoNormal.setVerticalAlignment(VerticalAlignment.CENTER);
            porcentoNormal.setFillForegroundColor(gray_6);
            porcentoNormal.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            porcentoNormal.setBorderRight(BorderStyle.THIN);
            porcentoNormal.setBorderLeft(BorderStyle.THIN);
        }
        return porcentoNormal;
    }

    XSSFCellStyle porcentoNormalLightGreenCenter = null;

    public CellStyle porcentoNormalLightGreenCenter() {
        if (porcentoNormalLightGreenCenter == null) {
            porcentoNormalLightGreenCenter = (XSSFCellStyle) wb.createCellStyle();
            fheaderboldwhite(wb);
            porcentoNormalLightGreenCenter.setFont(fheaderboldwhite);
            DataFormat dfEurosCent = wb.createDataFormat();
            porcentoNormalLightGreenCenter.setDataFormat(dfEurosCent.getFormat("0.00%"));
            porcentoNormalLightGreenCenter.setWrapText(false);
            porcentoNormalLightGreenCenter.setAlignment(HorizontalAlignment.RIGHT);
            porcentoNormalLightGreenCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            porcentoNormalLightGreenCenter.setFillForegroundColor(light_green);
            porcentoNormalLightGreenCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            porcentoNormalLightGreenCenter.setBorderRight(BorderStyle.THIN);
            porcentoNormalLightGreenCenter.setBorderLeft(BorderStyle.THIN);
        }
        return porcentoNormalLightGreenCenter;
    }

    XSSFCellStyle porcentoNormalBold = null;

    public CellStyle porcentoNormalBold() {
        if (porcentoNormalBold == null) {
            porcentoNormalBold = (XSSFCellStyle) wb.createCellStyle();
            fnormalbold11(wb);
            porcentoNormalBold.setFont(fnormalbold11);
            DataFormat dfEurosCent = wb.createDataFormat();
            porcentoNormalBold.setDataFormat(dfEurosCent.getFormat("0.00%"));
            porcentoNormalBold.setWrapText(false);
            porcentoNormalBold.setAlignment(HorizontalAlignment.RIGHT);
            porcentoNormalBold.setVerticalAlignment(VerticalAlignment.CENTER);
            porcentoNormalBold.setFillForegroundColor(gray_6);
            porcentoNormalBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            porcentoNormalBold.setBorderRight(BorderStyle.THIN);
            porcentoNormalBold.setBorderLeft(BorderStyle.THIN);
        }
        return porcentoNormalBold;
    }

    XSSFCellStyle porcentoGreen = null;

    public CellStyle porcentoGreen() {
        if (porcentoGreen == null) {
            porcentoGreen = (XSSFCellStyle) wb.createCellStyle();
            fnormalwhite(wb);
            porcentoGreen.setFont(fnormalwhite);
            DataFormat dfEurosCent = wb.createDataFormat();
            porcentoGreen.setDataFormat(dfEurosCent.getFormat("0.00%"));
            porcentoGreen.setWrapText(false);
            porcentoGreen.setAlignment(HorizontalAlignment.RIGHT);
            porcentoGreen.setVerticalAlignment(VerticalAlignment.CENTER);
            porcentoGreen.setFillForegroundColor(med_green);
            porcentoGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return porcentoGreen;
    }

    XSSFCellStyle porcentoGreyBold = null;

    public CellStyle porcentoGreyBold() {
        if (porcentoGreyBold == null) {
            porcentoGreyBold = (XSSFCellStyle) wb.createCellStyle();
            fbold(wb);
            porcentoGreyBold.setFont(fbold);
            DataFormat dfEurosCent = wb.createDataFormat();
            porcentoGreyBold.setDataFormat(dfEurosCent.getFormat("0.00%"));
            porcentoGreyBold.setWrapText(false);
            porcentoGreyBold.setAlignment(HorizontalAlignment.RIGHT);
            porcentoGreyBold.setVerticalAlignment(VerticalAlignment.CENTER);
            porcentoGreyBold.setFillForegroundColor(gray_5);
            porcentoGreyBold.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return porcentoGreyBold;
    }

    XSSFCellStyle porcentoGreyMed = null;

    public CellStyle porcentoGreyMed() {
        if (porcentoGreyMed == null) {
            porcentoGreyMed = (XSSFCellStyle) wb.createCellStyle();
            fbold(wb);
            porcentoGreyMed.setFont(fbold);
            DataFormat dfEurosCent = wb.createDataFormat();
            porcentoGreyMed.setDataFormat(dfEurosCent.getFormat("0.00%"));
            porcentoGreyMed.setWrapText(false);
            porcentoGreyMed.setAlignment(HorizontalAlignment.RIGHT);
            porcentoGreyMed.setVerticalAlignment(VerticalAlignment.CENTER);
            porcentoGreyMed.setFillForegroundColor(lighter_grey);
            porcentoGreyMed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return porcentoGreyMed;
    }

    XSSFCellStyle headerEpharmaBlue = null;

    public CellStyle headerEpharmaBlue() {
        if (headerEpharmaBlue == null) {
            headerEpharmaBlue = (XSSFCellStyle) wb.createCellStyle();
            fheaderboldwhiteepharma(wb);
            headerEpharmaBlue.setFont(fheaderboldwhiteepharma);
            headerEpharmaBlue.setWrapText(true);
            headerEpharmaBlue.setAlignment(HorizontalAlignment.LEFT);
            headerEpharmaBlue.setVerticalAlignment(VerticalAlignment.CENTER);
            headerEpharmaBlue.setFillForegroundColor(epharma_blue);
            headerEpharmaBlue.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerEpharmaBlue;
    }

    XSSFCellStyle headerEpharmaBlueCenter = null;

    public CellStyle headerEpharmaBlueCenter() {
        if (headerEpharmaBlueCenter == null) {
            headerEpharmaBlueCenter = (XSSFCellStyle) wb.createCellStyle();
            fheaderboldwhiteepharma(wb);
            headerEpharmaBlueCenter.setFont(fheaderboldwhiteepharma);
            headerEpharmaBlueCenter.setWrapText(true);
            headerEpharmaBlueCenter.setAlignment(HorizontalAlignment.CENTER);
            headerEpharmaBlueCenter.setVerticalAlignment(VerticalAlignment.CENTER);
            headerEpharmaBlueCenter.setFillForegroundColor(epharma_blue);
            headerEpharmaBlueCenter.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerEpharmaBlueCenter;
    }

    XSSFCellStyle headerEpharmaTrpBlue = null;

    public CellStyle headerEpharmaTrpBlue() {
        if (headerEpharmaTrpBlue == null) {
            headerEpharmaTrpBlue = (XSSFCellStyle) wb.createCellStyle();
            fheaderboldblackepharma(wb);
            headerEpharmaTrpBlue.setFont(fheaderboldblackepharma);
            headerEpharmaTrpBlue.setWrapText(true);
            headerEpharmaTrpBlue.setAlignment(HorizontalAlignment.CENTER);
            headerEpharmaTrpBlue.setVerticalAlignment(VerticalAlignment.CENTER);
            headerEpharmaTrpBlue.setFillForegroundColor(epharma_trp_blue);
            headerEpharmaTrpBlue.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerEpharmaTrpBlue;
    }

    XSSFCellStyle headerEpharmaTfoGrey = null;

    public CellStyle headerEpharmaTfoGrey() {
        if (headerEpharmaTfoGrey == null) {
            headerEpharmaTfoGrey = (XSSFCellStyle) wb.createCellStyle();
            fheaderboldwhiteepharma(wb);
            headerEpharmaTfoGrey.setFont(fheaderboldwhiteepharma);
            headerEpharmaTfoGrey.setWrapText(true);
            headerEpharmaTfoGrey.setAlignment(HorizontalAlignment.CENTER);
            headerEpharmaTfoGrey.setVerticalAlignment(VerticalAlignment.CENTER);
            headerEpharmaTfoGrey.setFillForegroundColor(light_grey);
            headerEpharmaTfoGrey.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        }
        return headerEpharmaTfoGrey;
    }

    XSSFCellStyle csSheetHeader = null;

    public CellStyle csSheetHeader() {
        if (csSheetHeader == null) {
            csSheetHeader = (XSSFCellStyle) wb.createCellStyle();
            fboldSheetTitle(wb);
            csSheetHeader.setFont(fboldSheetTitle);
            csSheetHeader.setWrapText(true);
            csSheetHeader.setAlignment(HorizontalAlignment.LEFT);
            csSheetHeader.setVerticalAlignment(VerticalAlignment.CENTER);
        }
        return csSheetHeader;
    }

    /////////////////////////////////////////////////    
    //METODOS 
    public XSSFColor newColorRGB(int red, int green, int blue) {
        XSSFColor color = new XSSFColor(new Color(red, green, blue));
        return color;
    }

    public void newCellTxt(Row row, int cel, String value, CellStyle cs) {
        try {
            Cell cell = row.createCell(cel);
            cell.setCellValue(value);
            cell.setCellStyle(cs);
        } catch (Exception e) {
            if (value == null) {
                value = "NULL";
            }
            System.out.print("CellStyles.newCellTxt(Linha:" + row.getRowNum() + ", Coluna:" + cel + ", Valor: " + value + "): " + e);
        }

    }

    public void newCellNum(Row row, int cel, double value, CellStyle cs) {
        try {
            Cell cell = row.createCell(cel);
            cell.setCellValue(value);
            cell.setCellStyle(cs);
        } catch (Exception e) {
            System.out.print("CellStyles.newCellNum(Linha:" + row.getRowNum() + ", Coluna:" + cel + ", Valor: " + value + "): " + e);
        }
    }

    public void newCellGenericValue(Row row, int cel, Object value, CellStyle cs) {
        Cell cell = row.getCell(cel) == null ? row.createCell(cel) : row.getCell(cel);
        try {

            cell.setCellValue(value.toString());
            cell.setCellStyle(cs);
        } catch (Exception e) {
            cell.setCellValue("");
            cell.setCellStyle(cs);

        }
    }

    public void newCellDateValue(Row row, int cel, Date value) {
        Cell cell = row.getCell(cel) == null ? row.createCell(cel) : row.getCell(cel);
        try {

            cell.setCellValue(value);
            cell.setCellStyle(date());
        } catch (Exception e) {
            cell.setCellValue("");
            cell.setCellStyle(date());

        }
    }

    public void newCellIntValue(Row row, int cel, int value, CellStyle cs) {
        Cell cell = row.createCell(cel);
        try {

            cell.setCellValue(value);
            cell.setCellStyle(cs);
        } catch (Exception e) {
            cell.setCellValue("");
            cell.setCellStyle(cs);

        }
    }

    public void newCellFormula(Row row, int cel, String Formula, CellStyle cs) {
        try {
            String letra = CellReference.convertNumToColString(cel);
            Cell cell = row.createCell(cel);
            cell.setCellFormula(Formula);
            cell.setCellStyle(cs);
        } catch (Exception e) {
            System.out.print("CellStyles.newCellFormula(Linha:" + row.getRowNum() + ", Coluna:" + cel + ", Formula: " + Formula + "): " + e);
        }

    }

}
