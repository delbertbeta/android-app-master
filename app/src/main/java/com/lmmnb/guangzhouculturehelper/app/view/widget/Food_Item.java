package com.lmmnb.guangzhouculturehelper.app.view.widget;

import com.idlestar.ratingstar.RatingStarView;

public class Food_Item {

    private String name;
    private int Img;
    private float ratingStarView;
    private String intro;
    private Boolean if_like;
    private String l1;
    private String l2;

    public Food_Item(String name, int img, float ratingStarView, String intro, Boolean if_like, String l1, String l2) {
        this.name = name;
        Img = img;
        this.ratingStarView = ratingStarView;
        this.intro = intro;
        this.if_like = if_like;
        this.l1 = l1;
        this.l2 = l2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return Img;
    }

    public void setImg(int img) {
        Img = img;
    }

    public float getRatingStarView() {
        return ratingStarView;
    }

    public void setRatingStarView(float ratingStarView) {
        this.ratingStarView = ratingStarView;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Boolean getIf_like() {
        return if_like;
    }

    public void setIf_like(Boolean if_like) {
        this.if_like = if_like;
    }

    public String getL1() {
        return l1;
    }

    public void setL1(String l1) {
        this.l1 = l1;
    }

    public String getL2() {
        return l2;
    }

    public void setL2(String l2) {
        this.l2 = l2;
    }
}
