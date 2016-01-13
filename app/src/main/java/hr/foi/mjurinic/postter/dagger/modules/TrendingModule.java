package hr.foi.mjurinic.postter.dagger.modules;

import dagger.Module;
import dagger.Provides;
import hr.foi.mjurinic.postter.mvp.interactors.TrendingInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.impl.TrendingInteractorImpl;
import hr.foi.mjurinic.postter.mvp.presenters.TrendingPresenter;
import hr.foi.mjurinic.postter.mvp.presenters.impl.TrendingPresenterImpl;
import hr.foi.mjurinic.postter.mvp.views.TrendingView;

/**
 * Created by mjurinic on 13.01.16..
 */
@Module
public class TrendingModule {

    private TrendingView view;

    public TrendingModule(TrendingView view) {
        this.view = view;
    }

    @Provides
    public TrendingView providesView() {
        return view;
    }

    @Provides
    public TrendingInteractor providesTrendingInteractor(TrendingInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    public TrendingPresenter providesTrendingPresenter(TrendingPresenterImpl presenter) {
        return presenter;
    }
}
