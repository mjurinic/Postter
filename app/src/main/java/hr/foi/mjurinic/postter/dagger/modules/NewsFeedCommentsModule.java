package hr.foi.mjurinic.postter.dagger.modules;

import dagger.Module;
import dagger.Provides;
import hr.foi.mjurinic.postter.mvp.interactors.NewsFeedCommentsInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.impl.NewsFeedCommentsInteractorImpl;
import hr.foi.mjurinic.postter.mvp.presenters.NewsFeedCommentsPresenter;
import hr.foi.mjurinic.postter.mvp.presenters.impl.NewsFeedCommentsPresenterImpl;
import hr.foi.mjurinic.postter.mvp.views.NewsFeedCommentsView;

/**
 * Created by noxqs on 06.01.16..
 */
@Module
public class NewsFeedCommentsModule {

    private NewsFeedCommentsView view;

    public NewsFeedCommentsModule(NewsFeedCommentsView view) {
        this.view = view;
    }

    @Provides
    public NewsFeedCommentsView provideNewsFeedCommentsView(){
        return view;
    }

    @Provides
    public NewsFeedCommentsPresenter provideNewsFeedCommentsPresenter(NewsFeedCommentsPresenterImpl impl){
        return impl;
    }

    @Provides
    public NewsFeedCommentsInteractor provideNewsFeedCommentsInteractor(NewsFeedCommentsInteractorImpl impl){
        return impl;
    }
}
