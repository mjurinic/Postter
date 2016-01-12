package hr.foi.mjurinic.postter.mvp.presenters.impl;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Base64;

import java.util.ArrayList;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.MyPostsResponse;
import hr.foi.mjurinic.postter.mvp.interactors.MyPostsInteractor;
import hr.foi.mjurinic.postter.mvp.presenters.MyPostsPresenter;
import hr.foi.mjurinic.postter.mvp.views.MyPostsView;

/**
 * Created by mjurinic on 12.01.16..
 */
public class MyPostsPresenterImpl implements MyPostsPresenter, Listener<ArrayList<MyPostsResponse>> {

    private MyPostsView myPostsView;
    private MyPostsInteractor myPostsInteractor;
    private String token = "Basic ";

    @Inject
    public MyPostsPresenterImpl(MyPostsView myPostsView, MyPostsInteractor myPostsInteractor, Context context) {
        this.myPostsView = myPostsView;
        this.myPostsInteractor = myPostsInteractor;

        token += Base64.encodeToString(PreferenceManager.getDefaultSharedPreferences(context).getString("BasicAuth", "").getBytes(), Base64.DEFAULT);
    }

    @Override
    public void getMyPosts() {
        myPostsInteractor.getMyPosts(this, token.trim());
    }

    @Override
    public void onSuccess(ArrayList<MyPostsResponse> myPostsResponses) {
        myPostsView.hideProgress();
        myPostsView.onSuccess(myPostsResponses);
    }

    @Override
    public void onFailure(String message) {
        myPostsView.hideProgress();
        myPostsView.showError(message);
    }
}
