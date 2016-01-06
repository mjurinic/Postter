package hr.foi.mjurinic.postter.mvp.interactors;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.User;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface SearchInteractor extends BaseInteractor {

    void searchUser(String token, String name, Listener<User> listener);
}
