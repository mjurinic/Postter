package hr.foi.mjurinic.postter.mvp.interactors.impl;

import android.support.annotation.Nullable;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.FollowingResponse;
import hr.foi.mjurinic.postter.mvp.interactors.NewsFeedInteractor;
import hr.foi.mjurinic.postter.network.ApiService;
import hr.foi.mjurinic.postter.network.BaseCallback;
import retrofit.Call;
import retrofit.Response;

/**
 * Created by noxqs on 06.01.16..
 */
public class NewsFeedInteractorImpl implements NewsFeedInteractor {

    private ApiService apiService;

    private Call<FollowingResponse> followingResponseCall;

    private BaseCallback<FollowingResponse> followingResponseBaseCallback;

    @Inject
    public NewsFeedInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void cancel() {
        if (followingResponseCall != null && followingResponseBaseCallback != null) {
            followingResponseCall.cancel();
            followingResponseBaseCallback.cancel();
        }
    }

    @Override
    public void fetchNewsFeed(final Listener<FollowingResponse> listener, String token, String username) {
        followingResponseCall = apiService.fetchFollowers(token, username);

        followingResponseBaseCallback = new BaseCallback<FollowingResponse>() {
            @Override
            public void onUnknownError(@Nullable String error) {
                listener.onFailure(error);
            }

            @Override
            public void onSuccess(FollowingResponse body, Response<FollowingResponse> response) {
                listener.onSuccess(body);
            }
        };

        followingResponseCall.enqueue(followingResponseBaseCallback);
    }


}
