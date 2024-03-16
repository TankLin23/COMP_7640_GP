package model;

public class Order {
    private String ID;
    private String c_id;
    private String date;

    public Order(String c_id, String date) {
        this.c_id = c_id;
        this.date = date;
    }

    public Order(String ID, String c_id, String date) {
        this.ID = ID;
        this.c_id = c_id;
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
