package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by mjurinic on 06.01.16..
 */
public class SecurityDoc implements Serializable {

    /**
     * {
         "admins": {
             "names": [],
             "roles": []
         },
         "readers": {
             "names": [
                 "skliba",
                 "mjurinic"
             ],
             "roles": []
         }
     }
     */

    @SerializedName("admins")
    private SecurityDocUsers admins;

    @SerializedName("readers")
    private SecurityDocUsers readers;

    public SecurityDocUsers getAdmins() {
        return admins;
    }

    public SecurityDocUsers getReaders() {
        return readers;
    }
}
