/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.project.model;

/**
 *
 * @author marco
 */
public class ProjectModel {

    private int id;
    private String customer_nme;
    private float expected_sale;
    private float effective_sale;
    private float effective_purchase;
    private String n_process;

    public ProjectModel(int id, String customer_nme, float expected_sale, float effective_sale, float effective_purchase, String n_process) {
        this.id = id;
        this.customer_nme = customer_nme;
        this.expected_sale = expected_sale;
        this.effective_sale = effective_sale;
        this.effective_purchase = effective_purchase;
        this.n_process = n_process;
    }

    public String getN_process() {
        return n_process;
    }

    public void setN_process(String n_process) {
        this.n_process = n_process;
    }

    public ProjectModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_nme() {
        return customer_nme;
    }

    public void setCustomer_nme(String customer_nme) {
        this.customer_nme = customer_nme;
    }

    public float getExpected_sale() {
        return expected_sale;
    }

    public void setExpected_sale(float expected_sale) {
        this.expected_sale = expected_sale;
    }

    public float getEffective_sale() {
        return effective_sale;
    }

    public void setEffective_sale(float effective_sale) {
        this.effective_sale = effective_sale;
    }

    public float getEffective_purchase() {
        return effective_purchase;
    }

    public void setEffective_purchase(float effective_purchase) {
        this.effective_purchase = effective_purchase;
    }

}
