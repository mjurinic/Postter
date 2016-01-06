package hr.foi.mjurinic.postter.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import hr.foi.mjurinic.postter.PostterApp;
import hr.foi.mjurinic.postter.dagger.modules.ApiModule;
import hr.foi.mjurinic.postter.dagger.modules.AppContextModule;
import hr.foi.mjurinic.postter.dagger.modules.ClientModule;
import hr.foi.mjurinic.postter.dagger.modules.GsonConverterModule;
import hr.foi.mjurinic.postter.dagger.modules.HostModule;
import hr.foi.mjurinic.postter.dagger.modules.NetworkModule;

/**
 * Created by mjurinic on 06.01.16..
 */
@Component(modules = {
        AppContextModule.class,
        HostModule.class,
        ClientModule.class,
        GsonConverterModule.class,
        ApiModule.class
})
@Singleton
public interface AppComponent {

    void inject(PostterApp app);
}
