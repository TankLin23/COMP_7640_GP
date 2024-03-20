package model;

public class Order {
    private String ID;
    private String c_id;
    private int status;
    private String v_id;
    private String p_id;
    private int quantity;
    private int price;

    public Order(String c_id, int status, String v_id, String p_id, int quantity, int price) {
        this.c_id = c_id;
        this.status = status;
        this.v_id = v_id;
        this.p_id = p_id;
        this.quantity = quantity;
        this.price = price;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getV_id() {
        return v_id;
    }

    public void setV_id(String v_id) {
        this.v_id = v_id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

