package hr.foi.mjurinic.postter.dagger.modules;

import dagger.Module;
import dagger.Provides;
import hr.foi.mjurinic.postter.mvp.interactors.FollowInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.SearchInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.impl.FollowInteractorImpl;
import hr.foi.mjurinic.postter.mvp.interactors.impl.SearchInteractorImpl;
import hr.foi.mjurinic.postter.mvp.presenters.SearchPresenter;
import hr.foi.mjurinic.postter.mvp.presenters.impl.SearchPresenterImpl;
import hr.foi.mjurinic.postter.mvp.views.SearchView;

/**
 * Created by mjurinic on 06.01.16..
 */
@Module
public class SearchModule {

    private SearchView searchView;

    public SearchModule(SearchView searchView) {
        this.searchView = searchView;
    }

    @Provides
    public SearchView provideSearchView() {
        return searchView;
    }

    @Provides
    public SearchInteractor provideSearchInteractor(SearchInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    public FollowInteractor provideFollowInteractor(FollowInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    public SearchPresenter provideSearchPresenter(SearchPresenterImpl presenter) {
        return presenter;
    }
}
