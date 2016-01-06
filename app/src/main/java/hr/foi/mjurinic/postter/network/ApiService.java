package hr.foi.mjurinic.postter.network;

import javax.inject.Qualifier;

import hr.foi.mjurinic.postter.models.FollowingResponse;
import hr.foi.mjurinic.postter.models.NewsFeedResponse;
import hr.foi.mjurinic.postter.models.Session;
import hr.foi.mjurinic.postter.models.UserCredentials;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface ApiService {

    @POST("/_session")
    Call<Session> login(@Body UserCredentials userCredentials);

    @GET("/tbp_europe/_design/designs/_list/pretty_following/following?key=\"org.coucbdb.user:{name}\"")
    Call<FollowingResponse> fetchFollowers( @Header("Authorization") String token, @Path("name") String name);

    @GET("/tbp_europe/_design/designs/_list/with_comment_count/post_and_comments?following={username}")
    Call<NewsFeedResponse> fetchNewsFeed(@Path("username") String username);
}
