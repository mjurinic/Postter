package hr.foi.mjurinic.postter.models;

/**
 * Created by mjurinic on 06.01.16..
 */
public class User {

    private String name;

    private String token;

    public User(String name, String token) {
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }
}
