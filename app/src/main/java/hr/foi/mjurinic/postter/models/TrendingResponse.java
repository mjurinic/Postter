package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mjurinic on 13.01.16..
 */
public class TrendingResponse implements Serializable {

    @SerializedName("rows")
    private ArrayList<Trending> trends;

    public ArrayList<Trending> getTrends() {
        return trends;
    }
}
