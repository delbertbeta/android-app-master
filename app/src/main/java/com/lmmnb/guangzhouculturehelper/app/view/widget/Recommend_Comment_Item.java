package com.lmmnb.guangzhouculturehelper.app.view.widget;

public class Recommend_Comment_Item {

    private float rating;
    private String comment;
    private String label1;
    private String label2;
    private String label3;

    public Recommend_Comment_Item(float rating, String comment, String label1, String label2, String label3) {
        this.rating = rating;
        this.comment = comment;
        this.label1 = label1;
        this.label2 = label2;
        this.label3 = label3;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLabel1() {
        return label1;
    }

    public void setLabel1(String label1) {
        this.label1 = label1;
    }

    public String getLabel2() {
        return label2;
    }

    public void setLabel2(String label2) {
        this.label2 = label2;
    }

    public String getLabel3() {
        return label3;
    }

    public void setLabel3(String label3) {
        this.label3 = label3;
    }
}
