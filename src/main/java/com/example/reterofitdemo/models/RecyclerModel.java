package com.example.reterofitdemo.models;

public class RecyclerModel {
    private String id, userId, Title, body;

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return Title;
    }

    public String getBody() {
        return body;
    }
}
