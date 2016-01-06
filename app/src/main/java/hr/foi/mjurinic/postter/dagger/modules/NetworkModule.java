package hr.foi.mjurinic.postter.dagger.modules;

import dagger.Module;
import dagger.Provides;
import hr.foi.mjurinic.postter.PostterApp;
import hr.foi.mjurinic.postter.network.ApiService;

/**
 * Created by mjurinic on 06.01.16..
 */
@Module
public class NetworkModule {

    @Provides
    public ApiService provideApiService() {
        return PostterApp.getInstance().getApiService();
    }
}
