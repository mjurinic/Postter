package hr.foi.mjurinic.postter.mvp.views;

import hr.foi.mjurinic.postter.models.User;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface SearchView extends BaseView {

    void onSearchSuccess(User user);

    void onSearchFailure();

    void onFollowSuccess();
}
