package hr.foi.mjurinic.postter.mvp.interactors.impl;

import android.support.annotation.Nullable;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.BaseCouchResponse;
import hr.foi.mjurinic.postter.models.Relationship;
import hr.foi.mjurinic.postter.mvp.interactors.FollowInteractor;
import hr.foi.mjurinic.postter.network.ApiService;
import hr.foi.mjurinic.postter.network.BaseCallback;
import retrofit.Call;
import retrofit.Response;

/**
 * Created by mjurinic on 06.01.16..
 */
public class FollowInteractorImpl implements FollowInteractor {

    private ApiService apiService;
    private Call<BaseCouchResponse> call;
    private BaseCallback<BaseCouchResponse> callback;

    @Inject
    public FollowInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void followerUser(String token, Relationship relationship, final Listener<BaseCouchResponse> listener) {
        call = apiService.putNewFollow(token, relationship);

        callback = new BaseCallback<BaseCouchResponse>() {
            @Override
            public void onUnknownError(@Nullable String error) {
                listener.onFailure(error);
            }

            @Override
            public void onSuccess(BaseCouchResponse body, Response<BaseCouchResponse> response) {
                listener.onSuccess(body);
            }
        };

        call.enqueue(callback);
    }

    @Override
    public void cancel() {
        if (call != null & callback != null) {
            call.cancel();
            callback.cancel();
        }
    }
}
