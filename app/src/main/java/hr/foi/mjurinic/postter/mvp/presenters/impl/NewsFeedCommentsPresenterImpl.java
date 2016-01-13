package hr.foi.mjurinic.postter.mvp.presenters.impl;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Base64;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.listeners.NewsFeedListener;
import hr.foi.mjurinic.postter.models.BaseCouchResponse;
import hr.foi.mjurinic.postter.models.Comments;
import hr.foi.mjurinic.postter.models.NewsFeedCommentsResponse;
import hr.foi.mjurinic.postter.mvp.interactors.CacheInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.NewsFeedCommentsInteractor;
import hr.foi.mjurinic.postter.mvp.presenters.NewsFeedCommentsPresenter;
import hr.foi.mjurinic.postter.mvp.views.NewsFeedCommentsView;

/**
 * Created by mjurinic on 06.01.16..
 */
public class NewsFeedCommentsPresenterImpl implements NewsFeedCommentsPresenter {

    private NewsFeedCommentsInteractor interactor;
    private NewsFeedCommentsView view;
    private CacheInteractor cacheInteractor;
    private String token = "Basic ";
    private Comments comment;

    @Inject
    public NewsFeedCommentsPresenterImpl(NewsFeedCommentsInteractor interactor, NewsFeedCommentsView view,
                                         CacheInteractor cacheInteractor, Context context) {
        this.interactor = interactor;
        this.view = view;
        this.cacheInteractor = cacheInteractor;

        token += Base64.encodeToString(PreferenceManager.getDefaultSharedPreferences(context).getString("BasicAuth", "").getBytes(), Base64.DEFAULT);
    }

    @Override
    public void fetchComments(String id) {
        interactor.fetchComments(token, listener, id);
    }

    private NewsFeedListener<NewsFeedCommentsResponse> listener = new NewsFeedListener<NewsFeedCommentsResponse>() {
        @Override
        public void onSuccess(ArrayList<NewsFeedCommentsResponse> responseArrayList) {
            view.hideProgress();

            Collections.sort(responseArrayList, new Comparator<NewsFeedCommentsResponse>() {
                @Override
                public int compare(NewsFeedCommentsResponse lhs, NewsFeedCommentsResponse rhs) {
                    return lhs.getCreatedAt().compareTo(rhs.getCreatedAt());
                }
            });

            view.onSuccess(responseArrayList);
        }

        @Override
        public void onFailure(String message) {
            view.hideProgress();
            view.onFailure(message);
        }
    };

    @Override
    public void postComment(String commentBody, String postId) {
        comment = new Comments(cacheInteractor.getUser().getName(), commentBody, new DateTime(), postId);
        interactor.postComment(comment, token.trim(), postCommentListener);
    }

    Listener<BaseCouchResponse> postCommentListener = new Listener<BaseCouchResponse>() {
        @Override
        public void onSuccess(BaseCouchResponse baseCouchResponse) {
            view.hideProgress();
            view.onSuccessfulPost(comment);
        }

        @Override
        public void onFailure(String message) {
            view.hideProgress();
            view.showError(message);
        }
    };

    @Override
    public void cancel() {

    }
}
