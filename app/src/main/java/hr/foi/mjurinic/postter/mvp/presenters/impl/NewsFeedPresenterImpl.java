package hr.foi.mjurinic.postter.mvp.presenters.impl;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Base64;

import java.util.ArrayList;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.listeners.NewsFeedListener;
import hr.foi.mjurinic.postter.models.FollowingResponse;
import hr.foi.mjurinic.postter.models.NewsFeedResponse;
import hr.foi.mjurinic.postter.mvp.interactors.CacheInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.NewsFeedInteractor;
import hr.foi.mjurinic.postter.mvp.presenters.NewsFeedPresenter;
import hr.foi.mjurinic.postter.mvp.views.NewsFeedView;

/**
 * Created by noxqs on 06.01.16..
 */
public class NewsFeedPresenterImpl implements NewsFeedPresenter {

    private NewsFeedView view;

    private NewsFeedInteractor interactor;

    private CacheInteractor cacheInteractor;

    private String base64 = "";

    private String username;

    @Inject
    public NewsFeedPresenterImpl(NewsFeedView view, NewsFeedInteractor interactor, CacheInteractor cacheInteractor) {
        this.view = view;
        this.interactor = interactor;
        this.cacheInteractor = cacheInteractor;
    }

    @Override
    public void fetchFollowers(Context context) {
        String token = PreferenceManager.getDefaultSharedPreferences(context).getString("BasicAuth", "");
        username = cacheInteractor.getUser().getName();
        try {
            byte[] data = token.getBytes("UTF-8");
            base64 = Base64.encodeToString(data, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        base64 = "Basic " + base64;
        interactor.fetchFollowers(followingResponseListener, base64, username);
    }

    @Override
    public void fetchNewsFeed() {
        interactor.fetchNewsFeed(newsFeedResponseListener, base64, username);
    }

    @Override
    public void cancel() {

    }

    private Listener<FollowingResponse> followingResponseListener = new Listener<FollowingResponse>() {
        @Override
        public void onSuccess(FollowingResponse followingResponse) {
            view.onFollowersFetched(followingResponse);
        }

        @Override
        public void onFailure(String message) {
            view.onFollowersError(message);
        }
    };

    private NewsFeedListener<NewsFeedResponse> newsFeedResponseListener = new NewsFeedListener<NewsFeedResponse>() {
        @Override
        public void onSuccess(ArrayList<NewsFeedResponse> newsFeedResponses) {
            view.onNewsFeedFetched(newsFeedResponses);
        }

        @Override
        public void onFailure(String message) {
            view.onNewsFeedError(message);
        }
    };
}
