package hr.foi.mjurinic.postter.dagger.modules;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mjurinic on 06.01.16..
 */
@Module
public class ClientModule {

    @Provides
    @Singleton
    public OkHttpClient provideClient() {
        OkHttpClient client = new OkHttpClient();

        return client;
    }
}
