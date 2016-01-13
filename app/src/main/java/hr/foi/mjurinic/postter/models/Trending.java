package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mjurinic on 13.01.16..
 */
public class Trending implements Serializable {

    @SerializedName("key")
    private String tag;

    @SerializedName("value")
    private int count;

    public String getTag() {
        return tag;
    }

    public int getCount() {
        return count;
    }
}
