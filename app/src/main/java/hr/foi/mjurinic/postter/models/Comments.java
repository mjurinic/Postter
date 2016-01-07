package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mjurinic on 06.01.16..
 */
public class Comments {

    @SerializedName("id")
    private String id;

    @SerializedName("author")
    private String author;

    @SerializedName("body")
    private String body;

    @SerializedName("created_at")
    private String createdAt;

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
}
