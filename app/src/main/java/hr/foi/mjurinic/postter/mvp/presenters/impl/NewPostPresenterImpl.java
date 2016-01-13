package hr.foi.mjurinic.postter.mvp.presenters.impl;

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
    private String token;

    @Inject
    public NewPostPresenterImpl(NewPostView newPostView, NewPostInteractor newPostInteractor, CacheInteractor cacheInteractor) {
        this.newPostView = newPostView;
        this.newPostInteractor = newPostInteractor;
        this.cacheInteractor = cacheInteractor;

        token = cacheInteractor.getUser().getToken();
    }

    @Override
    public void createPost(String body) {
        String fullName = cacheInteractor.getUser().getFirstName() + ' ' + cacheInteractor.getUser().getLastName();
        String author = cacheInteractor.getUser().getName();

        Post post = new Post(fullName, author, body, ExtractHashTags.getHashTags(body));

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
