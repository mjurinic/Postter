package hr.foi.mjurinic.postter.mvp.interactors.impl;

import android.support.annotation.Nullable;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.BaseCouchResponse;
import hr.foi.mjurinic.postter.models.SecurityDoc;
import hr.foi.mjurinic.postter.models.User;
import hr.foi.mjurinic.postter.mvp.interactors.RegisterInteractor;
import hr.foi.mjurinic.postter.network.ApiService;
import hr.foi.mjurinic.postter.network.BaseCallback;
import retrofit.Call;
import retrofit.Response;

/**
 * Created by mjurinic on 06.01.16..
 */
public class RegisterInteractorImpl implements RegisterInteractor {

    private ApiService apiService;

    private Call<BaseCouchResponse> createUserCall;
    private BaseCallback<BaseCouchResponse> createUserCallback;

    private Call<SecurityDoc> getSecurityDocCall;
    private BaseCallback<SecurityDoc> getSecurityDocCallback;

    private Call<BaseCouchResponse> updateSecurityDocCall;
    private BaseCallback<BaseCouchResponse> updateSecurityDocCallCallback;

    @Inject
    public RegisterInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void createUser(String token, User user, final Listener<BaseCouchResponse> listener) {
        createUserCall = apiService.registerUser(token, user, user.getName());

        createUserCallback = new BaseCallback<BaseCouchResponse>() {
            @Override
            public void onUnknownError(@Nullable String error) {
                listener.onFailure(error);
            }

            @Override
            public void onSuccess(BaseCouchResponse body, Response<BaseCouchResponse> response) {
                listener.onSuccess(body);
            }
        };

        createUserCall.enqueue(createUserCallback);
    }

    @Override
    public void getSecurityDoc(String token, final Listener<SecurityDoc> listener) {
        getSecurityDocCall = apiService.getSecurityDoc(token);

        getSecurityDocCallback = new BaseCallback<SecurityDoc>() {
            @Override
            public void onUnknownError(@Nullable String error) {
                listener.onFailure(error);
            }

            @Override
            public void onSuccess(SecurityDoc body, Response<SecurityDoc> response) {
                listener.onSuccess(body);
            }
        };

        getSecurityDocCall.enqueue(getSecurityDocCallback);
    }

    @Override
    public void updateSecurityDoc(String token, SecurityDoc securityDoc, String databaseName, final Listener<BaseCouchResponse> listener) {
        updateSecurityDocCall = apiService.updateSecurityDoc(token, securityDoc);

        updateSecurityDocCallCallback = new BaseCallback<BaseCouchResponse>() {
            @Override
            public void onUnknownError(@Nullable String error) {
                listener.onFailure(error);
            }

            @Override
            public void onSuccess(BaseCouchResponse body, Response<BaseCouchResponse> response) {
                listener.onSuccess(body);
            }
        };

        updateSecurityDocCall.enqueue(updateSecurityDocCallCallback);
    }
}
