/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.project.model;

/**
 *
 * @author pedro
 */
public class ProjectEmployeeTime {
    private String n_process;
    private long time_spent;
    private String employee;

    public String getN_process() {
        return n_process;
    }

    public void setN_process(String n_process) {
        this.n_process = n_process;
    }

    public long getTime_spent() {
        return time_spent;
    }

    public void setTime_spent(long time_spent) {
        this.time_spent = time_spent;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
    
}
