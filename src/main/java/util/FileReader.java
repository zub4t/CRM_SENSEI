/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author marco
 */
public class FileReader {

    public static String read(String filename, String fileDirectory) {
        String text = "";
        String fileName = "/home/janbodnar/tmp/smallfile.txt";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);

            int i;

            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return text;
    }

}
