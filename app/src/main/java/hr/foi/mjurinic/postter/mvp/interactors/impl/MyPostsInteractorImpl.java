package hr.foi.mjurinic.postter.mvp.interactors.impl;

import android.support.annotation.Nullable;

import java.util.ArrayList;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.BaseGetPostsResponse;
import hr.foi.mjurinic.postter.models.MyPostsResponse;
import hr.foi.mjurinic.postter.mvp.interactors.MyPostsInteractor;
import hr.foi.mjurinic.postter.network.ApiService;
import hr.foi.mjurinic.postter.network.BaseCallback;
import retrofit.Call;
import retrofit.Response;

/**
 * Created by mjurinic on 12.01.16..
 */
public class MyPostsInteractorImpl implements MyPostsInteractor {

    private ApiService apiService;
    private Call<BaseGetPostsResponse<MyPostsResponse>> call;
    private BaseCallback<BaseGetPostsResponse<MyPostsResponse>> callback;

    @Inject
    public MyPostsInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getMyPosts(final Listener<ArrayList<MyPostsResponse>> listener, String token) {
        call = apiService.getMyPosts(token);

        callback = new BaseCallback<BaseGetPostsResponse<MyPostsResponse>>() {
            @Override
            public void onUnknownError(@Nullable String error) {
                listener.onFailure(error);
            }

            @Override
            public void onSuccess(BaseGetPostsResponse<MyPostsResponse> body, Response<BaseGetPostsResponse<MyPostsResponse>> response) {
                listener.onSuccess(body.getPosts());
            }
        };

        call.enqueue(callback);
    }

    @Override
    public void cancel() {
        if (call != null && callback != null) {
            call.cancel();
            callback.cancel();
        }
    }
}
