package hr.foi.mjurinic.postter.mvp.presenters.impl;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Base64;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.BaseCouchResponse;
import hr.foi.mjurinic.postter.models.Relationship;
import hr.foi.mjurinic.postter.models.User;
import hr.foi.mjurinic.postter.mvp.interactors.CacheInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.FollowInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.SearchInteractor;
import hr.foi.mjurinic.postter.mvp.presenters.SearchPresenter;
import hr.foi.mjurinic.postter.mvp.views.SearchView;

/**
 * Created by mjurinic on 06.01.16..
 */
public class SearchPresenterImpl implements SearchPresenter {

    public static final String ORG_COUCHDB_USER = "org.couchdb.user:";

    private SearchView searchView;
    private SearchInteractor searchInteractor;
    private FollowInteractor followInteractor;
    private CacheInteractor cacheInteractor;
    private Context context;
    private String token = "Basic ";

    @Inject
    public SearchPresenterImpl(SearchView searchView, SearchInteractor searchInteractor,
                               FollowInteractor followInteractor, CacheInteractor cacheInteractor, Context context) {
        this.searchView = searchView;
        this.searchInteractor = searchInteractor;
        this.followInteractor = followInteractor;
        this.cacheInteractor = cacheInteractor;
        this.context = context;

        token += Base64.encodeToString(PreferenceManager.getDefaultSharedPreferences(context).getString("BasicAuth", "") .getBytes(), Base64.DEFAULT);
    }

    @Override
    public void searchUser(String userId) {
        searchInteractor.searchUser(token.trim(), userId, searchListener);
    }

    @Override
    public void followUser(String userId) {
        Relationship relationship = new Relationship(ORG_COUCHDB_USER + cacheInteractor.getUser().getName(), ORG_COUCHDB_USER + userId);
        followInteractor.followerUser(token.trim(), relationship, followListener);
    }

    @Override
    public void cancel() {
        searchInteractor.cancel();
    }

    Listener<User> searchListener = new Listener<User>() {
        @Override
        public void onSuccess(User user) {
            searchView.hideProgress();
            searchView.onSearchSuccess(user);
        }

        @Override
        public void onFailure(String message) {
            searchView.hideProgress();
            searchView.onSearchFailure();
        }
    };

    Listener<BaseCouchResponse> followListener = new Listener<BaseCouchResponse>() {
        @Override
        public void onSuccess(BaseCouchResponse baseCouchResponse) {
            searchView.hideProgress();
            searchView.onFollowSuccess();
        }

        @Override
        public void onFailure(String message) {
            searchView.hideProgress();
            searchView.showError(message);
        }
    };
}
