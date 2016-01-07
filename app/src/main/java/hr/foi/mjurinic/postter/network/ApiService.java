package hr.foi.mjurinic.postter.network;

import hr.foi.mjurinic.postter.models.BaseNewsFeedResponse;
import hr.foi.mjurinic.postter.models.BaseResponse;
import hr.foi.mjurinic.postter.models.FollowingResponse;
import hr.foi.mjurinic.postter.models.NewsFeedCommentsResponse;
import hr.foi.mjurinic.postter.models.NewsFeedResponse;
import hr.foi.mjurinic.postter.models.BaseCouchResponse;
import hr.foi.mjurinic.postter.models.Post;
import hr.foi.mjurinic.postter.models.Relationship;
import hr.foi.mjurinic.postter.models.SecurityDoc;
import hr.foi.mjurinic.postter.models.Session;
import hr.foi.mjurinic.postter.models.User;
import hr.foi.mjurinic.postter.models.UserCredentials;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;


/**
 * Created by mjurinic on 06.01.16..
 */
public interface ApiService {

    @POST("/_session")
    Call<Session> login(@Body UserCredentials userCredentials);

    @GET("/tbp_europe/_design/designs/_list/pretty_following/following")
    Call<BaseResponse<FollowingResponse>> fetchFollowers( @Header("Authorization") String token, @Query("key") String name);

    @GET("/tbp_europe/_design/designs/_list/with_comment_count/post_and_comments")
    Call<BaseNewsFeedResponse<NewsFeedResponse>> fetchNewsFeed(@Header("Authorization") String token, @Query("following") String username);

    @PUT("/_users/org.couchdb.user:{name}")
    Call<BaseCouchResponse> registerUser(@Header("Authorization") String token, @Body User user, @Path("name") String name);

    @GET("/tbp_europe/_security")
    Call<SecurityDoc> getSecurityDoc(@Header("Authorization") String token);

    @PUT("/tbp_europe/_security")
    Call<BaseCouchResponse> updateSecurityDoc(@Header("Authorization") String token, @Body SecurityDoc securityDoc);

    @GET("/_users/org.couchdb.user:{name}")
    Call<User> getUser(@Header("Authorization") String token, @Path("name") String name);

    @POST("/tbp_europe/")
    Call<BaseCouchResponse> putNewFollow(@Header("Authorization") String token, @Body Relationship relationship);

    @POST("/tbp_europe/")
    Call<BaseCouchResponse> postNewPost(@Header("Authorization") String token, @Body Post post);

    @GET("/tbp_europe/_design/designs/_list/filter_by_post_id/post_and_comments")
    Call<BaseNewsFeedResponse<NewsFeedCommentsResponse>> fetchComments(@Header("Authorization") String token, @Query("post_id") String id);
}
