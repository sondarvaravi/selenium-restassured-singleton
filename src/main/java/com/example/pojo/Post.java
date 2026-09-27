package com.example.pojo;

/**
 * POJO representing the JSON body returned by (and sent to) the
 * JSONPlaceholder "/posts" endpoint, e.g.:
 *
 * {
 *   "userId": 1,
 *   "id": 1,
 *   "title": "some title",
 *   "body": "some body text"
 * }
 */

public class Post {

    private int userId;
    private int id;
    private String title;
    private String body;

    // No-arg constructor is required by Jackson for deserialization
    public Post() {
    }

    public Post(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}