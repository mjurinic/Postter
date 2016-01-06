package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by noxqs on 06.01.16..
 */
public class FollowingResponse {

    @SerializedName("user_id")
    private String userId;

    @SerializedName("following")
    private ArrayList<String> following;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ArrayList<String> getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList<String> following) {
        this.following = following;
    }
}
