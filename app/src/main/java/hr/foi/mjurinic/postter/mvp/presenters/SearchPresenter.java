package hr.foi.mjurinic.postter.mvp.presenters;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface SearchPresenter extends BasePresenter {

    void searchUser(String userId);

    void followUser(String userId);
}
