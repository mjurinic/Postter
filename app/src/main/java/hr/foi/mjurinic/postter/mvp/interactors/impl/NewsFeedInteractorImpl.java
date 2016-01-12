package hr.foi.mjurinic.postter.mvp.interactors.impl;

import android.support.annotation.Nullable;

import java.util.ArrayList;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.listeners.NewsFeedListener;
import hr.foi.mjurinic.postter.models.BaseGetPostsResponse;
import hr.foi.mjurinic.postter.models.BaseResponse;
import hr.foi.mjurinic.postter.models.FollowingResponse;
import hr.foi.mjurinic.postter.models.NewsFeedResponse;
import hr.foi.mjurinic.postter.mvp.interactors.NewsFeedInteractor;
import hr.foi.mjurinic.postter.network.ApiService;
import hr.foi.mjurinic.postter.network.BaseCallback;
import retrofit.Call;
import retrofit.Response;

/**
 * Created by mjurinic on 06.01.16..
 */
public class NewsFeedInteractorImpl implements NewsFeedInteractor {

    public static final String ORG_COUCHDB_USER = "org.couchdb.user:";
    private ApiService apiService;

    private Call<BaseResponse<FollowingResponse>> followingResponseCall;
    private BaseCallback<BaseResponse<FollowingResponse>> followingResponseBaseCallback;
    private Call<BaseGetPostsResponse<NewsFeedResponse>> newsFeedResponseCall;
    private BaseCallback<BaseGetPostsResponse<NewsFeedResponse>> newsFeedResponseCallback;

    @Inject
    public NewsFeedInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void cancel() {
        if (followingResponseCall != null && followingResponseBaseCallback != null ) {
            followingResponseCall.cancel();
            followingResponseBaseCallback.cancel();
            if(newsFeedResponseCall != null && newsFeedResponseCallback != null){
                newsFeedResponseCall.cancel();
                newsFeedResponseCallback.cancel();
            }
        }
    }

    @Override
    public void fetchFollowers(final Listener<FollowingResponse> listener, String token, String username) {
        followingResponseCall = apiService.fetchFollowers(token.trim(), '"' + ORG_COUCHDB_USER + username + '"');

        followingResponseBaseCallback = new BaseCallback<BaseResponse<FollowingResponse>>() {
            @Override
            public void onUnknownError(@Nullable String error) {
                listener.onFailure(error);
            }

            @Override
            public void onSuccess(BaseResponse<FollowingResponse> body, Response<BaseResponse<FollowingResponse>> response) {
                listener.onSuccess(body.getResponse());
            }
        };

        followingResponseCall.enqueue(followingResponseBaseCallback);
    }

    @Override
    public void fetchNewsFeed(final NewsFeedListener<NewsFeedResponse> listener, String token, ArrayList<String> username) {
        String usernames = "";
        for(int i = 0; i<username.size();++i){
            usernames += username.get(i) + ",";
        }
        usernames = usernames.substring(0, usernames.length() -1 );
        newsFeedResponseCall = apiService.fetchNewsFeed(token.trim(), usernames);

        newsFeedResponseCallback = new BaseCallback<BaseGetPostsResponse<NewsFeedResponse>>() {
            @Override
            public void onUnknownError(@Nullable String error) {
                listener.onFailure(error);
            }

            @Override
            public void onSuccess(BaseGetPostsResponse<NewsFeedResponse> body, Response<BaseGetPostsResponse<NewsFeedResponse>> response) {
                listener.onSuccess(body.getPosts());
            }
        };

        newsFeedResponseCall.enqueue(newsFeedResponseCallback);
    }

}
