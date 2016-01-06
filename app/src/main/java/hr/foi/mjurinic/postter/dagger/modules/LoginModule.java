package hr.foi.mjurinic.postter.dagger.modules;

import dagger.Module;
import dagger.Provides;
import hr.foi.mjurinic.postter.mvp.interactors.LoginInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.impl.LoginInteractorImpl;
import hr.foi.mjurinic.postter.mvp.presenters.LoginPresenter;
import hr.foi.mjurinic.postter.mvp.presenters.impl.LoginPresenterImpl;
import hr.foi.mjurinic.postter.mvp.views.LoginView;

/**
 * Created by mjurinic on 06.01.16..
 */
@Module
public class LoginModule {

    private LoginView loginView;

    public LoginModule(LoginView loginView) {
        this.loginView = loginView;
    }

    @Provides
    public LoginView provideLoginView() {
        return loginView;
    }

    @Provides
    public LoginInteractor provideLoginInteractor(LoginInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    public LoginPresenter provideLoginPresenter(LoginPresenterImpl presenter) {
        return presenter;
    }
}
