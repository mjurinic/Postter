package hr.foi.mjurinic.postter.mvp.presenters;

import hr.foi.mjurinic.postter.models.SecurityDoc;
import hr.foi.mjurinic.postter.models.User;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface RegisterPresenter {

    void registerUser(User user);

    void getSecurityDoc();

    void updateSecurityDocEurope(SecurityDoc securityDoc);

    void updateSecurityDocUnitedStates(SecurityDoc securityDoc);

    void updateSecurityDocAsia(SecurityDoc securityDoc);
}
