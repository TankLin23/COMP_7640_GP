package model;

public class Vendor {

    private String ID;

    private String business_name;

    private Double feedback_score;

    private String geographical_presence;

    public Vendor(String business_name, Double feedback_score, String geographical_presence) {
        this.business_name = business_name;
        this.feedback_score = feedback_score;
        this.geographical_presence = geographical_presence;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
