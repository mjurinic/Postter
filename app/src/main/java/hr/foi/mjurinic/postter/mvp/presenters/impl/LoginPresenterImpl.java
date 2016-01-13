package hr.foi.mjurinic.postter.mvp.presenters.impl;

import android.util.Base64;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.listeners.LoginListener;
import hr.foi.mjurinic.postter.models.Session;
import hr.foi.mjurinic.postter.models.User;
import hr.foi.mjurinic.postter.mvp.interactors.CacheInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.LoginInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.SearchInteractor;
import hr.foi.mjurinic.postter.mvp.presenters.LoginPresenter;
import hr.foi.mjurinic.postter.mvp.views.LoginView;

/**
 * Created by mjurinic on 06.01.16..
 */
public class LoginPresenterImpl implements LoginPresenter, LoginListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;
    private CacheInteractor cacheInteractor;
    private SearchInteractor searchInteractor;
    private String token = "Basic ";

    @Inject
    public LoginPresenterImpl(LoginView loginView, LoginInteractor loginInteractor,
                              CacheInteractor cacheInteractor, SearchInteractor searchInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
        this.cacheInteractor = cacheInteractor;
        this.searchInteractor = searchInteractor;
    }

    @Override
    public void onLoginClick(String username, String password) {
        String cred = username + ':' + password;
        token += Base64.encodeToString(cred.getBytes(), Base64.DEFAULT);

        loginInteractor.doLogin(username, password, this);
    }

    @Override
    public void getUser(String name) {
        searchInteractor.searchUser(token.trim(), name, searchListener);
    }

    Listener<User> searchListener = new Listener<User>() {
        @Override
        public void onSuccess(User user) {
            loginView.hideProgress();

            user.setToken(token);
            cacheInteractor.cacheUser(user);

            loginView.onSuccess();
        }

        @Override
        public void onFailure(String message) {
            loginView.hideProgress();
            loginView.showError(message);
        }
    };

    @Override
    public void cancel() {
        loginView.hideProgress();
        loginInteractor.cancel();
    }

    @Override
    public void onSuccess(Session session, String token) {
        getUser(session.getName());
    }

    @Override
    public void onFailure(String message) {
        loginView.hideProgress();
        loginView.showError(message);
    }
}
