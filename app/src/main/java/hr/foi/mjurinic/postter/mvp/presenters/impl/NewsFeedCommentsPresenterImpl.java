package hr.foi.mjurinic.postter.mvp.presenters.impl;

import android.content.Context;

import java.util.ArrayList;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.NewsFeedListener;
import hr.foi.mjurinic.postter.models.Comments;
import hr.foi.mjurinic.postter.models.NewsFeedCommentsResponse;
import hr.foi.mjurinic.postter.mvp.interactors.NewsFeedCommentsInteractor;
import hr.foi.mjurinic.postter.mvp.presenters.NewsFeedCommentsPresenter;
import hr.foi.mjurinic.postter.mvp.views.NewsFeedCommentsView;

/**
 * Created by mjurinic on 06.01.16..
 */
public class NewsFeedCommentsPresenterImpl implements NewsFeedCommentsPresenter {

    private NewsFeedCommentsInteractor interactor;
    private NewsFeedCommentsView view;

    @Inject
    public NewsFeedCommentsPresenterImpl(NewsFeedCommentsInteractor interactor, NewsFeedCommentsView view) {
        this.interactor = interactor;
        this.view = view;
    }

    @Override
    public void fetchComments(Context context, String id) {
        interactor.fetchComments(context, listener, id);
    }

    @Override
    public void cancel() {

    }

    private NewsFeedListener<NewsFeedCommentsResponse> listener = new NewsFeedListener<NewsFeedCommentsResponse>() {
        @Override
        public void onSuccess(ArrayList<NewsFeedCommentsResponse> responseArrayList) {
            view.onSuccess(responseArrayList);
        }

        @Override
        public void onFailure(String message) {
            view.onFailure(message);
        }
    };

}
