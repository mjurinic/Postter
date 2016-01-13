package hr.foi.mjurinic.postter.mvp.presenters.impl;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Base64;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.Trending;
import hr.foi.mjurinic.postter.mvp.interactors.TrendingInteractor;
import hr.foi.mjurinic.postter.mvp.presenters.TrendingPresenter;
import hr.foi.mjurinic.postter.mvp.views.TrendingView;

/**
 * Created by mjurinic on 13.01.16..
 */
public class TrendingPresenterImpl implements TrendingPresenter, Listener<ArrayList<Trending>> {

    private TrendingInteractor interactor;
    private TrendingView view;
    private String token = "Basic ";

    @Inject
    public TrendingPresenterImpl(TrendingInteractor interactor, TrendingView view, Context context) {
        this.interactor = interactor;
        this.view = view;

        token += Base64.encodeToString(PreferenceManager.getDefaultSharedPreferences(context).getString("BasicAuth", "").getBytes(), Base64.DEFAULT);
    }

    @Override
    public void getTrends() {
        interactor.getTrending(token.trim(), this);
    }

    @Override
    public void cancel() {

    }

    @Override
    public void onSuccess(ArrayList<Trending> trends) {
        view.hideProgress();

        Collections.sort(trends, new Comparator<Trending>() {
            @Override
            public int compare(Trending lhs, Trending rhs) {
                return lhs.getCount() < rhs.getCount() ? 1 : -1;
            }
        });

        view.onSuccess(trends);
    }

    @Override
    public void onFailure(String message) {
        view.hideProgress();
        view.showError(message);
    }
}
