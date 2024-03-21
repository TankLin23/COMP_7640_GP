package model;

public class Order {
    private String ID;
    private int c_id;
    private int p_id;
    private String status;
    private int v_id;
    private String p_name;
    private int quantity;
    private double price;
    private String v_name;

    private int feedbackStatus;

    public Order(int c_id,String status, String v_name,int v_id, String p_name, int quantity, double price, int feedbackStatus) {
        this.c_id = c_id;
        this.status = status;
        this.v_name = v_name;
        this.v_id = v_id;
        this.p_name = p_name;
        this.quantity = quantity;
        this.price = price;
        this.feedbackStatus = feedbackStatus;

    }


    public String getID() {
        return ID;
    }
    public  String getV_name(){return v_name; }

    public  void setV_name(String V_name){this.v_name =V_name;}

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {this.price = price;}

    public int getFeedbackStatus(){return feedbackStatus;}
    public void setFeedbackStatus(int feedbackStatus){this.feedbackStatus =feedbackStatus;}
    public int getP_id(){return p_id;}

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }
}

