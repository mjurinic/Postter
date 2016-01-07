package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mjurinic on 07.01.16..
 */
public class Post implements Serializable {

    @SerializedName("author")
    private String author;

    @SerializedName("author_id")
    private String author_id;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("type")
    private String type = "post";

    @SerializedName("body")
    private String body;

    @SerializedName("created_at")
    private DateTime createdAt;

    @SerializedName("tags")
    private ArrayList<String> tags;

    @SerializedName("active")
    private boolean active;

    public Post(String author, String body, ArrayList<String> tags) {
        this.author = author;
        this.body = body;
        this.tags = tags;

        author_id = "org.couchdb.user:" + author;
        createdAt = new DateTime();
        active = true;
        // fulle name?...
    }
}
