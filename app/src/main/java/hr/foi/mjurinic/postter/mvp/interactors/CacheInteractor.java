package hr.foi.mjurinic.postter.mvp.interactors;

import hr.foi.mjurinic.postter.models.SecurityDoc;
import hr.foi.mjurinic.postter.models.User;

/**
 * Created by mjurinic on 27.10.15..
 */
public interface CacheInteractor {

    void cacheUser(User user);

    User getUser();

    void cacheSecurityDoc(SecurityDoc securityDoc);

    SecurityDoc getSecurityDoc();
}
