/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interventions.model;

/**
 *
 * @author marco
 */
public class InterventionsModel {
    private int id;
    private int project_id;
    private int employee_id;
    private int assingment_id;
    private String speend_time;
    private String dsc;
    private String prj_nme;
    private String employee_nme;
    private String assingment_nme;

    public InterventionsModel(int project_id, int employee_id, int assingment_id, String speend_time, String dsc) {
        this.project_id = project_id;
        this.employee_id = employee_id;
        this.assingment_id = assingment_id;
        this.speend_time = speend_time;
        this.dsc = dsc;
    }

    public InterventionsModel() {
    }

    public int getId() {
        return id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getAssingment_id() {
        return assingment_id;
    }

    public void setAssingment_id(int assingment_id) {
        this.assingment_id = assingment_id;
    }

    public String getSpeend_time() {
        return speend_time;
    }

    public void setSpeend_time(String speend_time) {
        this.speend_time = speend_time;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public String getPrj_nme() {
        return prj_nme;
    }

    public void setPrj_nme(String prj_nme) {
        this.prj_nme = prj_nme;
    }

    public String getEmployee_nme() {
        return employee_nme;
    }

    public void setEmployee_nme(String employee_nme) {
        this.employee_nme = employee_nme;
    }

    public String getAssingment_nme() {
        return assingment_nme;
    }

    public void setAssingment_nme(String assingment_nme) {
        this.assingment_nme = assingment_nme;
    }

    public void setId(int id) {
        this.id = id;
    }

}
