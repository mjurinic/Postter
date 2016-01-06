package hr.foi.mjurinic.postter.mvp.presenters.impl;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.listeners.LoginListener;
import hr.foi.mjurinic.postter.models.Session;
import hr.foi.mjurinic.postter.models.User;
import hr.foi.mjurinic.postter.mvp.interactors.CacheInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.LoginInteractor;
import hr.foi.mjurinic.postter.mvp.presenters.LoginPresenter;
import hr.foi.mjurinic.postter.mvp.views.LoginView;

/**
 * Created by mjurinic on 06.01.16..
 */
public class LoginPresenterImpl implements LoginPresenter, LoginListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;
    private CacheInteractor cacheInteractor;

    @Inject
    public LoginPresenterImpl(LoginView loginView, LoginInteractor loginInteractor, CacheInteractor cacheInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
        this.cacheInteractor = cacheInteractor;
    }

    @Override
    public void onLoginClick(String username, String password) {
        loginInteractor.doLogin(username, password, this);
    }

    @Override
    public void cancel() {
        loginView.hideProgress();
        loginInteractor.cancel();
    }

    @Override
    public void onSuccess(Session session, String token) {
        loginView.hideProgress();

        cacheInteractor.cacheUser(new User(session.getName(), token.split(";")[0].split("=")[1]));

        loginView.onSuccess();
    }

    @Override
    public void onFailure(String message) {
        loginView.hideProgress();
        loginView.showError(message);
    }
}
