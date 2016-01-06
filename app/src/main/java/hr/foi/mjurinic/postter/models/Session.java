package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mjurinic on 06.01.16..
 */
public class Session implements Serializable {

    @SerializedName("ok")
    private boolean ok;

    @SerializedName("name")
    private String name;

    @SerializedName("roles")
    private String[] roles;

    public String getName() {
        return name;
    }
}
