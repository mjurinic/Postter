package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by mjurinic on 06.01.16..
 */
public class NewsFeedCommentsResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("author")
    private String author;

    @SerializedName("body")
    private String body;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("tags")
    private ArrayList<String> tags;

    @SerializedName("comments")
    private ArrayList<Comments> comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<Comments> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comments> comments) {
        this.comments = comments;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
