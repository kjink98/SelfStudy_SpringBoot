package com.dogether.domain;

import java.util.Date;

public class Review {
    private int review_id;
    private String user_id;
    private String user_nickname;
    private int place_id;
    private String review_title;
    private Date review_regdate;
    private String review_content;
    private float review_starRating;
    private String review_image;

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public String getReview_title() {
        return review_title;
    }

    public void setReview_title(String review_title) {
        this.review_title = review_title;
    }

    public Date getReview_regdate() {
        return review_regdate;
    }

    public void setReview_regdate(Date review_regdate) {
        this.review_regdate = review_regdate;
    }

    public String getReview_content() {
        return review_content;
    }

    public void setReview_content(String review_content) {
        this.review_content = review_content;
    }

    public float getReview_starRating() {
        return review_starRating;
    }

    public void setReview_starRating(float review_starRating) {
        this.review_starRating = review_starRating;
    }

    public String getReview_image() {
        return review_image;
    }

    public void setReview_image(String review_image) {
        this.review_image = review_image;
    }

}
