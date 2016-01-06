package hr.foi.mjurinic.postter.mvp.interactors.impl;

import android.support.annotation.Nullable;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.LoginListener;
import hr.foi.mjurinic.postter.models.Session;
import hr.foi.mjurinic.postter.models.UserCredentials;
import hr.foi.mjurinic.postter.mvp.interactors.LoginInteractor;
import hr.foi.mjurinic.postter.network.ApiService;
import hr.foi.mjurinic.postter.network.BaseCallback;
import retrofit.Call;
import retrofit.Response;

/**
 * Created by mjurinic on 06.01.16..
 */
public class LoginInteractorImpl implements LoginInteractor {

    private ApiService apiService;
    private Call<Session> call;
    private BaseCallback<Session> callback;

    @Inject
    public LoginInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void doLogin(String username, String password, final LoginListener listener) {
        call = apiService.login(new UserCredentials(username, password));

        callback = new BaseCallback<Session>() {
            @Override
            public void onUnknownError(@Nullable String error) {
                listener.onFailure(error);
            }

            @Override
            public void onSuccess(Session body, Response<Session> response) {
                listener.onSuccess(body, response.headers().get("AuthSession"));
            }
        };

        call.enqueue(callback);
    }

    @Override
    public void cancel() {
        if (call != null && callback != null) {
            call.cancel();
            callback.cancel();
        }
    }
}
