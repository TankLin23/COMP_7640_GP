package model;

public class Customer {
    private String ID;

    private String contact_number;

    private String shipping_details;


    public Customer(String contact_number, String shipping_details) {
        this.contact_number = contact_number;
        this.shipping_details = shipping_details;
    }

    public Customer(String ID, String contact_number, String shipping_details) {
        this.ID = ID;
        this.contact_number = contact_number;
        this.shipping_details = shipping_details;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getShipping_details() {
        return shipping_details;
    }

    public void setShipping_details(String shipping_details) {
        this.shipping_details = shipping_details;
    }
}
