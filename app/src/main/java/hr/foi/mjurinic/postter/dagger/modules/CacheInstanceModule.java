package hr.foi.mjurinic.postter.dagger.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hr.foi.mjurinic.postter.mvp.interactors.CacheInteractor;
import hr.foi.mjurinic.postter.mvp.interactors.impl.CacheInteractorImpl;

/**
 * Created by mjurinic on 27.10.15..
 */
@Module
public class CacheInstanceModule {

    @Provides
    @Singleton
    public CacheInteractor cacheInteractor() {
        return new CacheInteractorImpl();
    }
}
