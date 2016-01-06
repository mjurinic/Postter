package hr.foi.mjurinic.postter.dagger.modules;

import dagger.Module;
import dagger.Provides;
import hr.foi.mjurinic.postter.PostterApp;
import hr.foi.mjurinic.postter.mvp.interactors.CacheInteractor;

/**
 * Created by mjurinic on 06.01.16..
 */
@Module
public class CacheModule {

    @Provides
    public CacheInteractor provideCacheInteractor() {
        return PostterApp.getInstance().getCacheInteractor();
    }
}
