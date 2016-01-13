package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mjurinic on 06.01.16..
 */
public class User implements Serializable {

    public static final String ORG_COUCHDB_USER = "org.couchdb.user:";
    public static final String USER = "user";

    @SerializedName("_id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("password")
    private String password;

    @SerializedName("roles")
    private ArrayList<String> roles;     // always empty at the moment

    @SerializedName("type")
    private String type;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("email")
    private String email;

    private String token;

    /**
     * For storing basic user info into cache
     *
     * @param name
     * @param token
     */
    public User(String name, String token) {
        this.name = name;
        this.token = token;
    }

    /**
     * For creating new users on Register process
     *
     * @param name
     * @param firstName
     * @param lastName
     * @param email
     */
    public User(String firstName, String lastName, String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        id = ORG_COUCHDB_USER + name;
        type = USER;
        roles = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
