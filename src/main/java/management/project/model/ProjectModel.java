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
    private int client_id;
    private String customer_nme;
    private float expected_sale;
    private float effective_sale;
    private float effective_purchase;
    private float expected_purchase;

    private String n_process;
    private float honorary;
    private String ctr_date;

    public float getExpected_purchase() {
        return expected_purchase;
    }

    public void setExpected_purchase(float expected_purchase) {
        this.expected_purchase = expected_purchase;
    }

    public String getCtr_date() {
        return ctr_date;
    }

    public void setCtr_date(String ctr_date) {
        this.ctr_date = ctr_date;
    }

    public float getHonorary() {
        return honorary;
    }

    public void setHonorary(float honorary) {
        this.honorary = honorary;
    }

    public ProjectModel(int id, String customer_nme, float expected_sale, float effective_sale, float effective_purchase, String n_process, float honorary) {
        this.id = id;
        this.customer_nme = customer_nme;
        this.expected_sale = expected_sale;
        this.effective_sale = effective_sale;
        this.effective_purchase = effective_purchase;
        this.n_process = n_process;
        this.honorary = honorary;
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

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

}
