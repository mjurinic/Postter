package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mjurinic on 06.01.16..
 */
public class BaseCouchResponse implements Serializable {

    @SerializedName("ok")
    private boolean ok;

    public boolean isOk() {
        return ok;
    }
}
