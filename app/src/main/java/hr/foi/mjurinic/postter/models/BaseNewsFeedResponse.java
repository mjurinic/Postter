package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by noxqs on 06.01.16..
 */
public class BaseNewsFeedResponse<T> {

    @SerializedName("response")
    private ArrayList<T> newsFeedResponses;

    public ArrayList<T> getNewsFeedResponses() {
        return newsFeedResponses;
    }

    public void setNewsFeedResponses(ArrayList<T> newsFeedResponses) {
        this.newsFeedResponses = newsFeedResponses;
    }
}
