/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu.services;

import menu.repository.MenuRepository;

/**
 *
 * @author marco
 */
public class MenuServices {

    public void createMenuStructure() {
        MenuRepository rep = new MenuRepository();
        rep.getByLvl(0);
        rep.getByLvl(1);

    }
}
