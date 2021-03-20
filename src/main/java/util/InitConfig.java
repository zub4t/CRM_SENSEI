/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author marco
 */
public class InitConfig extends HttpServlet {

    public InitConfig() {
    }

    @Override
    public void init() throws ServletException {
        String dir = System.getProperty("user.dir");
        dir = dir.replaceAll("bin", "utilFiles");
        Util.createDirectory(dir);
        Constant.utilFiles = dir;

    }

}
