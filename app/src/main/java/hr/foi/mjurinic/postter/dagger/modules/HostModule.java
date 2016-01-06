package hr.foi.mjurinic.postter.dagger.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hr.foi.mjurinic.postter.BuildConfig;

/**
 * Created by mjurinic on 06.01.16..
 */
@Module
public class HostModule {

    @Provides
    @Singleton
    public String provideHost() {
        return BuildConfig.API_URL_EU;
    }
}
