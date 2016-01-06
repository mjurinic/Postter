package hr.foi.mjurinic.postter.network;

import hr.foi.mjurinic.postter.models.Session;
import hr.foi.mjurinic.postter.models.UserCredentials;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface ApiService {

    @POST("/_session")
    Call<Session> login(@Body UserCredentials userCredentials);
}
