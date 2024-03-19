package model;

public class Vendor {

    private String ID;
    private String contact_number;

    private String shipping_details;
    public Vendor() {
    }
    public Vendor(String id, String password) {
        this.ID = id;
        this.password = password;
    }
    public Vendor(String ID, String password, String business_name, Double feedback_score, String geographical_presence) {
        this.ID = ID;
        this.password = password;
        this.business_name = business_name;
        this.feedback_score = feedback_score;
        this.geographical_presence = geographical_presence;
    }

    private String password;

    private String business_name;

    private Double feedback_score;

    private String geographical_presence;

    public Vendor(String business_name, Double feedback_score, String geographical_presence,String password) {
        this.business_name = business_name;
        this.feedback_score = feedback_score;
        this.geographical_presence = geographical_presence;
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public Double getFeedback_score() {
        return feedback_score;
    }

    public void setFeedback_score(Double feedback_score) {
        this.feedback_score = feedback_score;
    }

    public String getGeographical_presence() {
        return geographical_presence;
    }

    public void setGeographical_presence(String geographical_presence) {
        this.geographical_presence = geographical_presence;
    }

}
