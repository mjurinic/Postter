package hr.foi.mjurinic.postter.dagger.modules;

import dagger.Module;
import dagger.Provides;
import hr.foi.mjurinic.postter.mvp.interactors.NewsFeedInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.impl.NewsFeedInteractorImpl;
import hr.foi.mjurinic.postter.mvp.presenters.NewsFeedPresenter;
import hr.foi.mjurinic.postter.mvp.presenters.impl.NewsFeedPresenterImpl;
import hr.foi.mjurinic.postter.mvp.views.NewsFeedView;

/**
 * Created by mjurinic on 06.01.16..
 */
@Module
public class NewsFeedModule {

    private NewsFeedView view;

    public NewsFeedModule(NewsFeedView view) {
        this.view = view;
    }

    @Provides
    public NewsFeedView provideNewsFeedView(){
        return view;
    }

    @Provides
    public NewsFeedPresenter provideNewsFeedPresenter(NewsFeedPresenterImpl impl){
        return impl;
    }

    @Provides
    public NewsFeedInteractor provideNewsFeedInteractor(NewsFeedInteractorImpl impl){
        return impl;
    }
}
