package hr.foi.mjurinic.postter.dagger.modules;

import dagger.Module;
import dagger.Provides;
import hr.foi.mjurinic.postter.mvp.interactors.CacheInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.LoginInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.RegisterInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.impl.CacheInteractorImpl;
import hr.foi.mjurinic.postter.mvp.interactors.impl.LoginInteractorImpl;
import hr.foi.mjurinic.postter.mvp.interactors.impl.RegisterInteractorImpl;
import hr.foi.mjurinic.postter.mvp.presenters.RegisterPresenter;
import hr.foi.mjurinic.postter.mvp.presenters.impl.RegisterPresenterImpl;
import hr.foi.mjurinic.postter.mvp.views.RegisterView;

/**
 * Created by mjurinic on 06.01.16..
 */
@Module
public class RegisterModule {

    private RegisterView registerView;

    public RegisterModule(RegisterView registerView) {
        this.registerView = registerView;
    }

    @Provides
    public RegisterView provideRegisterView() {
        return registerView;
    }

    @Provides
    public RegisterInteractor provideRegisterInteractor(RegisterInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    public LoginInteractor providesLoginInteractor(LoginInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    public RegisterPresenter provideRegisterPresenter(RegisterPresenterImpl presenter) {
        return presenter;
    }
}
