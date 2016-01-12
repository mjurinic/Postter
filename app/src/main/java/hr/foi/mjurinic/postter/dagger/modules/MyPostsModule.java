package hr.foi.mjurinic.postter.dagger.modules;

import dagger.Module;
import dagger.Provides;
import hr.foi.mjurinic.postter.mvp.interactors.MyPostsInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.impl.MyPostsInteractorImpl;
import hr.foi.mjurinic.postter.mvp.presenters.MyPostsPresenter;
import hr.foi.mjurinic.postter.mvp.presenters.impl.MyPostsPresenterImpl;
import hr.foi.mjurinic.postter.mvp.views.MyPostsView;

/**
 * Created by mjurinic on 12.01.16..
 */
@Module
public class MyPostsModule {

    private MyPostsView myPostsView;

    public MyPostsModule(MyPostsView myPostsView) {
        this.myPostsView = myPostsView;
    }

    @Provides
    public MyPostsView providesMyPostsView() {
        return myPostsView;
    }

    @Provides
    public MyPostsInteractor providesMyPostsInteractor(MyPostsInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    public MyPostsPresenter providesMyPostsPresenteR(MyPostsPresenterImpl presenter) {
        return presenter;
    }
}
