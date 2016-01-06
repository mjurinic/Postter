package hr.foi.mjurinic.postter.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {

    @SerializedName("response")
    private T response;

    public T getResponse() {
        return response;
    }
}
