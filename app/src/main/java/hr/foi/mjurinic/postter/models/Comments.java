package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

/**
 * Created by mjurinic on 06.01.16..
 */
public class Comments {

    public static final String COMMENT = "comment";

    @SerializedName("id")
    private String id;

    @SerializedName("author")
    private String author;

    @SerializedName("body")
    private String body;

    @SerializedName("created_at")
    private DateTime createdAt;

    @SerializedName("type")
    private String type;

    @SerializedName("active")
    private boolean active;

    @SerializedName("post_id")
    private String postId;

    public Comments(String author, String body, DateTime createdAt, String postId) {
        this.author = author;
        this.body = body;
        this.createdAt = createdAt;
        this.active = true;
        this.type = COMMENT;
        this.postId = postId;
    }

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

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }
}
