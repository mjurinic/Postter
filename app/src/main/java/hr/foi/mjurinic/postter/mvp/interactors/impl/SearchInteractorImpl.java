package hr.foi.mjurinic.postter.mvp.interactors.impl;

import android.support.annotation.Nullable;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.User;
import hr.foi.mjurinic.postter.mvp.interactors.SearchInteractor;
import hr.foi.mjurinic.postter.network.ApiService;
import hr.foi.mjurinic.postter.network.BaseCallback;
import retrofit.Call;
import retrofit.Response;

/**
 * Created by mjurinic on 06.01.16..
 */
public class SearchInteractorImpl implements SearchInteractor {

    private ApiService apiService;
    private Call<User> call;
    private BaseCallback<User> callback;

    @Inject
    public SearchInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void searchUser(String token, String name, final Listener<User> listener) {
        call = apiService.getUser(token, name);

        callback = new BaseCallback<User>() {
            @Override
            public void onUnknownError(@Nullable String error) {
                listener.onFailure(error);
            }

            @Override
            public void onSuccess(User body, Response<User> response) {
                listener.onSuccess(body);
            }
        };

        call.enqueue(callback);
    }

    @Override
    public void cancel() {
        if (call != null & callback != null) {
            call.cancel();
            callback.cancel();
        }
    }
}
