package model;

public class Product {
    private String ID;
    private String vendor_ID;
    private String name;
    private Double price;
    private String tag1;
    private String tag2;
    private String tag3;

    public Product(String ID, String vendor_ID, String name, Double price, String tag1, String tag2, String tag3) {
        this.ID = ID;
        this.vendor_ID = vendor_ID;
        this.name = name;
        this.price = price;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
    }

    public Product(String ID, String vendor_ID, String name, Double price, String tag1) {
        this.ID = ID;
        this.vendor_ID = vendor_ID;
        this.name = name;
        this.price = price;
        this.tag1 = tag1;
    }

    public Product(String ID, String vendor_ID, String name, Double price, String tag1, String tag2) {
        this.ID = ID;
        this.vendor_ID = vendor_ID;
        this.name = name;
        this.price = price;
        this.tag1 = tag1;
        this.tag2 = tag2;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getVendor_ID() {
        return vendor_ID;
    }

    public void setVendor_ID(String vendor_ID) {
        this.vendor_ID = vendor_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }
}
