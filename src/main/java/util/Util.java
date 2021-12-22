/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;

/**
 *
 * @author marco
 */
public class Util {

    public static java.util.Date data(String data_recebida, String strformato) {

        try {
            if (data_recebida != null) {
                java.util.Date valor;
                DateFormat formato = new SimpleDateFormat(strformato);
                valor = formato.parse(data_recebida);
                return valor;
            }
            return new java.util.Date();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static String numToExceString(int n) {
        // initialize output String as empty
        StringBuilder res = new StringBuilder();

        while (n > 0) {
            // find index of next letter and concatenate the letter
            // to the solution

            // Here index 0 corresponds to 'A' and 25 corresponds to 'Z'
            int index = (n - 1) % 26;
            res.append((char) (index + 'A'));
            n = (n - 1) / 26;
        }

        return res.reverse().toString();
    }

    public static String getBody(HttpServletRequest request) throws IOException {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();
        return body;
    }

    public static void createDirectory(String dir) {
        try {
            File theDir = new File(dir);
            if (!theDir.exists()) {
                theDir.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String randomKey() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

    public static String toJavascriptArray(String[] arr) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append("\"").append(arr[i]).append("\"");
            if (i + 1 < arr.length) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String getColorByAssignment(int id) {
        switch (id) {

        }
        return "#FF0000";
    }

    public static Color hex2Rgb(String colorStr) {
        return new Color(
                Integer.valueOf(colorStr.substring(1, 3), 16),
                Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16));
    }
}
