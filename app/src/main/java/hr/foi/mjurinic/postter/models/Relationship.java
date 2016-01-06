package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mjurinic on 06.01.16..
 */
public class Relationship implements Serializable {

    @SerializedName("type")
    private String type = "relationship";

    @SerializedName("follower_id")
    private String followerId;

    @SerializedName("following_id")
    private String followingId;

    public Relationship(String followerId, String followingId) {
        this.followerId = followerId;
        this.followingId = followingId;
    }

    public String getFollowerId() {
        return followerId;
    }

    public String getFollowingId() {
        return followingId;
    }
}
