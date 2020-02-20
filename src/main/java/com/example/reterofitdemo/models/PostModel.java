package com.example.reterofitdemo.models;

import com.google.gson.annotations.SerializedName;

public class PostModel {

    private int id;

    private int userId;

    @SerializedName("body") //  FOR HAING DIFFERENT NAME AS IN "Json placeholder its is body" *BASICALLY A MAPPING
    private String textBody;

    private String title;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTextBody() {
        return textBody;
    }

    public String getTitle() {
        return title;
    }
}
