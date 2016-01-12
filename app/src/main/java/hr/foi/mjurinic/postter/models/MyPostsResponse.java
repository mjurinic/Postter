package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mjurinic on 12.01.16..
 */
public class MyPostsResponse implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("key")
    private String key;

    @SerializedName("value")
    private Post post;

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public Post getPost() {
        return post;
    }
}
