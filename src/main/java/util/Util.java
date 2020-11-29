/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

}
