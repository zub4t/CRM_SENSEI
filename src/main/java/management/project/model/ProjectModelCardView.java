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
public class ProjectModelCardView {
    private int id;
    private String title;
    private String cod;
    private String start_date;
    private String end_date;
    private String total_hours;
    private String week_hours;
    

    public String getFormatLabelTotalHour() {
        return total_hours.split(":")[0] + ":" + total_hours.split(":")[1];
    }

    public String getFormatLabelWeekHour() {
        return week_hours.split(":")[0] + ":" + week_hours.split(":")[1];
    }

    public String getFormatTotalToBuildCss() {
        return total_hours.split(":")[0];
    }

    public String getFormatWeekToBuildCss() {
        return week_hours.split(":")[0];
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getTotal_hours() {
        return total_hours;
    }

    public void setTotal_hours(String total_hours) {
        this.total_hours = total_hours;
    }

    public String getWeek_hours() {
        return week_hours;
    }

    public void setWeek_hours(String week_hours) {
        this.week_hours = week_hours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
