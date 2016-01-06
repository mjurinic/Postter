package hr.foi.mjurinic.postter.mvp.presenters.impl;

import android.content.res.Resources;
import android.util.Base64;
import android.util.Log;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.BuildConfig;
import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.listeners.LoginListener;
import hr.foi.mjurinic.postter.models.BaseCouchResponse;
import hr.foi.mjurinic.postter.models.SecurityDoc;
import hr.foi.mjurinic.postter.models.Session;
import hr.foi.mjurinic.postter.models.User;
import hr.foi.mjurinic.postter.mvp.interactors.CacheInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.LoginInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.RegisterInteractor;
import hr.foi.mjurinic.postter.mvp.presenters.RegisterPresenter;
import hr.foi.mjurinic.postter.mvp.views.RegisterView;

/**
 * Created by mjurinic on 06.01.16..
 */
public class RegisterPresenterImpl implements RegisterPresenter {

    private RegisterView registerView;
    private LoginInteractor loginInteractor;
    private RegisterInteractor registerInteractor;
    private CacheInteractor cacheInteractor;
    private Resources resources;
    private String adminToken = "Basic ";
    private String username = "";

    @Inject
    public RegisterPresenterImpl(RegisterView registerView, LoginInteractor loginInteractor, RegisterInteractor registerInteractor,
                                 Resources resources, CacheInteractor cacheInteractor) {
        this.registerView = registerView;
        this.loginInteractor = loginInteractor;
        this.registerInteractor = registerInteractor;
        this.resources = resources;
        this.cacheInteractor = cacheInteractor;
    }

    @Override   // 1st
    public void registerUser(User user) {
        username = user.getName();

        String cred = resources.getString(R.string.admin_username)+ ":" +resources.getString(R.string.admin_password);

        adminToken += Base64.encodeToString(cred.getBytes(), Base64.DEFAULT);

        registerInteractor.createUser(adminToken.trim(), user, registerUserListener);
    }

    @Override   // 2nd
    public void getSecurityDoc() {
        registerInteractor.getSecurityDoc(adminToken.trim(), getSecurityDocListener);
    }

    @Override   // 3rd
    public void updateSecurityDocEurope(SecurityDoc securityDoc) {
        registerInteractor.updateSecurityDoc(adminToken.trim(), securityDoc, BuildConfig.EU_DB, updateSecurityDocListenerEuropeListener);
    }

    @Override   // 4th
    public void updateSecurityDocUnitedStates(SecurityDoc securityDoc) {
        registerInteractor.updateSecurityDoc(adminToken.trim(), securityDoc, BuildConfig.US_DB, updateSecurityDocListenerUnitedStatesListener);
    }

    @Override   // 5th
    public void updateSecurityDocAsia(SecurityDoc securityDoc) {
        registerInteractor.updateSecurityDoc(adminToken.trim(), securityDoc, BuildConfig.ASIA_DB, updateSecurityDocListenerAsiaListener);
    }

    // 1st
    private Listener<BaseCouchResponse> registerUserListener = new Listener<BaseCouchResponse>() {
        @Override
        public void onSuccess(BaseCouchResponse response) {
            getSecurityDoc();
        }

        @Override
        public void onFailure(String message) {
            registerView.hideProgress();
            registerView.showError(message);
        }
    };

    // 2nd
    private Listener<SecurityDoc> getSecurityDocListener = new Listener<SecurityDoc>() {
        @Override
        public void onSuccess(SecurityDoc securityDoc) {
            securityDoc.getReaders().getNames().add(username);

            cacheInteractor.cacheSecurityDoc(securityDoc);

            updateSecurityDocEurope(securityDoc);
        }

        @Override
        public void onFailure(String message) {
            registerView.hideProgress();
            registerView.showError(message + " [1]");
        }
    };

    // 3rd
    private Listener<BaseCouchResponse> updateSecurityDocListenerEuropeListener = new Listener<BaseCouchResponse>() {
        @Override
        public void onSuccess(BaseCouchResponse baseCouchResponse) {
            updateSecurityDocUnitedStates(cacheInteractor.getSecurityDoc());
        }

        @Override
        public void onFailure(String message) {
            registerView.hideProgress();
            registerView.showError(message + " EU");
        }
    };

    // 4th
    private Listener<BaseCouchResponse> updateSecurityDocListenerUnitedStatesListener = new Listener<BaseCouchResponse>() {
        @Override
        public void onSuccess(BaseCouchResponse baseCouchResponse) {
            updateSecurityDocAsia(cacheInteractor.getSecurityDoc());
        }

        @Override
        public void onFailure(String message) {
            registerView.hideProgress();
            registerView.showError(message + " US");
        }
    };

    // 5th
    private Listener<BaseCouchResponse> updateSecurityDocListenerAsiaListener = new Listener<BaseCouchResponse>() {
        @Override
        public void onSuccess(BaseCouchResponse baseCouchResponse) {
            registerView.hideProgress();
            registerView.onSuccess();
        }

        @Override
        public void onFailure(String message) {
            registerView.hideProgress();
            registerView.showError(message + " Asia");
        }
    };
}
