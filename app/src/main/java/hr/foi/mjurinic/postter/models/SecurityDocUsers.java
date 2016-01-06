package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mjurinic on 06.01.16..
 */
public class SecurityDocUsers implements Serializable {

    @SerializedName("names")
    private ArrayList<String> names;

    @SerializedName("roles")
    private ArrayList<String> roles;

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }
}
