package hr.foi.mjurinic.postter.mvp.interactors.impl;

import android.content.Context;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.NewsFeedListener;
import hr.foi.mjurinic.postter.models.BaseNewsFeedResponse;
import hr.foi.mjurinic.postter.models.Comments;
import hr.foi.mjurinic.postter.models.NewsFeedCommentsResponse;
import hr.foi.mjurinic.postter.mvp.interactors.NewsFeedCommentsInteractor;
import hr.foi.mjurinic.postter.network.ApiService;
import hr.foi.mjurinic.postter.network.BaseCallback;
import retrofit.Call;
import retrofit.Response;

/**
 * Created by noxqs on 06.01.16..
 */
public class NewsFeedCommentsInteractorImpl implements NewsFeedCommentsInteractor {

    private ApiService apiService;
    private Call<BaseNewsFeedResponse<NewsFeedCommentsResponse>> call;
    private BaseCallback<BaseNewsFeedResponse<NewsFeedCommentsResponse>> callback;

    @Inject
    public NewsFeedCommentsInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }
    @Override
    public void fetchComments(Context context, final NewsFeedListener<NewsFeedCommentsResponse> listener, String id) {
        String token = PreferenceManager.getDefaultSharedPreferences(context).getString("BASE64","");
        call = apiService.fetchComments(token.trim(), id);

        callback = new BaseCallback<BaseNewsFeedResponse<NewsFeedCommentsResponse>>() {
            @Override
            public void onUnknownError(@Nullable String error) {
                listener.onFailure(error);
            }

            @Override
            public void onSuccess(BaseNewsFeedResponse<NewsFeedCommentsResponse> body, Response<BaseNewsFeedResponse<NewsFeedCommentsResponse>> response) {
                listener.onSuccess(body.getNewsFeedResponses());
            }
        };
        call.enqueue(callback);
    }

    @Override
    public void cancel() {

    }


}
