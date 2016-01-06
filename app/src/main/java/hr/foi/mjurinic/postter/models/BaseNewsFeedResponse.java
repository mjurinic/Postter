package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by noxqs on 06.01.16..
 */
public class BaseNewsFeedResponse<NewsFeedResponse> {

    @SerializedName("response")
    private ArrayList<NewsFeedResponse> newsFeedResponses;

    public ArrayList<NewsFeedResponse> getNewsFeedResponses() {
        return newsFeedResponses;
    }

    public void setNewsFeedResponses(ArrayList<NewsFeedResponse> newsFeedResponses) {
        this.newsFeedResponses = newsFeedResponses;
    }
}
