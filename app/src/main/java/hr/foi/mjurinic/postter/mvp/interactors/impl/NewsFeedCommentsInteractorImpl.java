package hr.foi.mjurinic.postter.mvp.interactors.impl;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.listeners.NewsFeedListener;
import hr.foi.mjurinic.postter.models.BaseCouchResponse;
import hr.foi.mjurinic.postter.models.BaseGetPostsResponse;
import hr.foi.mjurinic.postter.models.Comments;
import hr.foi.mjurinic.postter.models.NewsFeedCommentsResponse;
import hr.foi.mjurinic.postter.mvp.interactors.NewsFeedCommentsInteractor;
import hr.foi.mjurinic.postter.network.ApiService;
import hr.foi.mjurinic.postter.network.BaseCallback;
import retrofit.Call;
import retrofit.Response;

/**
 * Created by mjurinic on 06.01.16..
 */
public class NewsFeedCommentsInteractorImpl implements NewsFeedCommentsInteractor {

    private ApiService apiService;
    private Call<BaseGetPostsResponse<NewsFeedCommentsResponse>> getCommentsCall;
    private BaseCallback<BaseGetPostsResponse<NewsFeedCommentsResponse>> getCommentsCallback;
    private Call<BaseCouchResponse> postCommentCall;
    private BaseCallback<BaseCouchResponse> postCommentCallback;

    @Inject
    public NewsFeedCommentsInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void fetchComments(String token, final NewsFeedListener<NewsFeedCommentsResponse> listener, String id) {
        getCommentsCall = apiService.fetchComments(token.trim(), id);

        getCommentsCallback = new BaseCallback<BaseGetPostsResponse<NewsFeedCommentsResponse>>() {
            @Override
            public void onUnknownError(@Nullable String error) {
                listener.onFailure(error);
            }

            @Override
            public void onSuccess(BaseGetPostsResponse<NewsFeedCommentsResponse> body, Response<BaseGetPostsResponse<NewsFeedCommentsResponse>> response) {
                listener.onSuccess(body.getPosts());
            }
        };
        getCommentsCall.enqueue(getCommentsCallback);
    }

    @Override
    public void postComment(Comments comment, String token, final Listener<BaseCouchResponse> listener) {
        postCommentCall = apiService.postNewDoc(token, comment);

        postCommentCallback = new BaseCallback<BaseCouchResponse>() {
            @Override
            public void onUnknownError(@Nullable String error) {
                listener.onFailure(error);
            }

            @Override
            public void onSuccess(BaseCouchResponse body, Response<BaseCouchResponse> response) {
                listener.onSuccess(body);
            }
        };

        postCommentCall.enqueue(postCommentCallback);
    }

    @Override
    public void cancel() {

    }
}
