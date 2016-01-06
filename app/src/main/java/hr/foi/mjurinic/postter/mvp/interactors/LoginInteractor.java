package hr.foi.mjurinic.postter.mvp.interactors;

import hr.foi.mjurinic.postter.listeners.LoginListener;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface LoginInteractor extends BaseInteractor {

    void doLogin(String username, String password, LoginListener listener);
}
