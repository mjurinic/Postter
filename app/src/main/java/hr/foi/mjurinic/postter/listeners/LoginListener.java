package hr.foi.mjurinic.postter.listeners;

import hr.foi.mjurinic.postter.models.Session;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface LoginListener {

    void onSuccess(Session session, String token);

    void onFailure(String message);
}
