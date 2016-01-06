package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mjurinic on 06.01.16..
 */
public class UserCredentials implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("password")
    private String password;

    public UserCredentials(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
