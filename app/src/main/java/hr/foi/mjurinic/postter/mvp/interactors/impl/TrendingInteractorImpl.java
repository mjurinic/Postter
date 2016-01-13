package hr.foi.mjurinic.postter.mvp.interactors.impl;

import android.support.annotation.Nullable;

import java.util.ArrayList;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.Trending;
import hr.foi.mjurinic.postter.models.TrendingResponse;
import hr.foi.mjurinic.postter.mvp.interactors.TrendingInteractor;
import hr.foi.mjurinic.postter.network.ApiService;
import hr.foi.mjurinic.postter.network.BaseCallback;
import retrofit.Call;
import retrofit.Response;

/**
 * Created by mjurinic on 13.01.16..
 */
public class TrendingInteractorImpl implements TrendingInteractor {

    private ApiService apiService;
    private Call<TrendingResponse> call;
    private BaseCallback<TrendingResponse> callback;

    @Inject
    public TrendingInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getTrending(String token, final Listener<ArrayList<Trending>> listener) {
        call = apiService.getTrending(token);

        callback = new BaseCallback<TrendingResponse>() {
            @Override
            public void onUnknownError(@Nullable String error) {
                listener.onFailure(error);
            }

            @Override
            public void onSuccess(TrendingResponse body, Response<TrendingResponse> response) {
                listener.onSuccess(body.getTrends());
            }
        };

        call.enqueue(callback);
    }

    @Override
    public void cancel() {

    }
}
