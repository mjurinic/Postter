package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by mjurinic on 06.01.16..
 */
public class BaseGetPostsResponse<T> {

    @SerializedName("response")
    private ArrayList<T> posts;

    public ArrayList<T> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<T> posts) {
        this.posts = posts;
    }
}