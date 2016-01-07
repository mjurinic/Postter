package hr.foi.mjurinic.postter.mvp.presenters.impl;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Base64;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.helpers.ExtractHashTags;
import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.BaseCouchResponse;
import hr.foi.mjurinic.postter.models.Post;
import hr.foi.mjurinic.postter.mvp.interactors.CacheInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.NewPostInteractor;
import hr.foi.mjurinic.postter.mvp.presenters.NewPostPresenter;
import hr.foi.mjurinic.postter.mvp.views.NewPostView;

/**
 * Created by mjurinic on 07.01.16..
 */
public class NewPostPresenterImpl implements NewPostPresenter, Listener<BaseCouchResponse> {

    private NewPostView newPostView;
    private NewPostInteractor newPostInteractor;
    private CacheInteractor cacheInteractor;
    private String token = "Basic ";

    @Inject
    public NewPostPresenterImpl(NewPostView newPostView, NewPostInteractor newPostInteractor, CacheInteractor cacheInteractor, Context context) {
        this.newPostView = newPostView;
        this.newPostInteractor = newPostInteractor;
        this.cacheInteractor = cacheInteractor;

        token += Base64.encodeToString(PreferenceManager.getDefaultSharedPreferences(context).getString("BasicAuth", "").getBytes(), Base64.DEFAULT);
    }

    @Override
    public void createPost(String body) {
        String author = cacheInteractor.getUser().getName();
        Post post = new Post(author, body, ExtractHashTags.getHashTags(body));

        newPostInteractor.postNewPost(token.trim(), post, this);
    }

    @Override
    public void cancel() {
        newPostInteractor.cancel();
    }

    @Override
    public void onSuccess(BaseCouchResponse baseCouchResponse) {
        newPostView.hideProgress();
        newPostView.onSuccess();
    }

    @Override
    public void onFailure(String message) {
        newPostView.hideProgress();
        newPostView.showError(message);
    }
}
