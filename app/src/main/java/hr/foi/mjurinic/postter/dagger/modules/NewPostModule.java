package hr.foi.mjurinic.postter.dagger.modules;

import dagger.Module;
import dagger.Provides;
import hr.foi.mjurinic.postter.mvp.interactors.NewPostInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.impl.NewPostInteractorImpl;
import hr.foi.mjurinic.postter.mvp.presenters.NewPostPresenter;
import hr.foi.mjurinic.postter.mvp.presenters.impl.NewPostPresenterImpl;
import hr.foi.mjurinic.postter.mvp.views.NewPostView;

/**
 * Created by mjurinic on 07.01.16..
 */
@Module
public class NewPostModule {

    private NewPostView newPostView;

    public NewPostModule(NewPostView newPostView) {
        this.newPostView = newPostView;
    }

    @Provides
    public NewPostView providesNewPostView() {
        return newPostView;
    }

    @Provides
    public NewPostInteractor providesNewPostInteractor(NewPostInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    public NewPostPresenter providesNewPostPresenter(NewPostPresenterImpl presenter) {
        return presenter;
    }
}
