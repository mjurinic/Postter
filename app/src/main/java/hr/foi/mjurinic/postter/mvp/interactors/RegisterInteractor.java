package hr.foi.mjurinic.postter.mvp.interactors;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.BaseCouchResponse;
import hr.foi.mjurinic.postter.models.SecurityDoc;
import hr.foi.mjurinic.postter.models.User;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface RegisterInteractor {

    void createUser(String token, User user, Listener<BaseCouchResponse> listener);

    void getSecurityDoc(String token, Listener<SecurityDoc> listener);

    void updateSecurityDoc(String token, SecurityDoc securityDoc, String databaseName, Listener<BaseCouchResponse> listener);
}
