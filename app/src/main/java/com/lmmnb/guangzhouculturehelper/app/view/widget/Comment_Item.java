package com.lmmnb.guangzhouculturehelper.app.view.widget;

public class Comment_Item {
    private String food_name;
    private float rating;
    private String comment;

    public Comment_Item(String food_name, float rating, String comment) {
        this.food_name = food_name;
        this.rating = rating;
        this.comment = comment;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
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
}
