package hr.foi.mjurinic.postter.mvp.presenters.impl;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.FollowingResponse;
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

    @Inject
    public NewsFeedPresenterImpl(NewsFeedView view, NewsFeedInteractor interactor, CacheInteractor cacheInteractor) {
        this.view = view;
        this.interactor = interactor;
        this.cacheInteractor = cacheInteractor;
    }

    @Override
    public void fetchFollowers(Context context) {
        String token = PreferenceManager.getDefaultSharedPreferences(context).getString("BasicAuth", "");
        String username = cacheInteractor.getUser().getName();
        String base64 = "";
        try{
            byte[] data = token.getBytes("UTF-8");
            base64 = Base64.encodeToString(data, Base64.DEFAULT);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        base64 = "Basic " + base64;
        interactor.fetchNewsFeed(followingResponseListener, base64, username);
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
}
