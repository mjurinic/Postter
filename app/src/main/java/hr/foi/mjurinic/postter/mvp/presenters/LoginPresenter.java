package hr.foi.mjurinic.postter.mvp.presenters;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface LoginPresenter extends BasePresenter {

    void onLoginClick(String username, String password);
}
