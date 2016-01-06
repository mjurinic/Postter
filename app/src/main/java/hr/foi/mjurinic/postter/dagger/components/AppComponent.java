package hr.foi.mjurinic.postter.dagger.components;

import dagger.Component;
import hr.foi.mjurinic.postter.PostterApp;
import hr.foi.mjurinic.postter.dagger.modules.ApiModule;
import hr.foi.mjurinic.postter.dagger.modules.AppContextModule;
import hr.foi.mjurinic.postter.dagger.modules.ClientModule;
import hr.foi.mjurinic.postter.dagger.modules.HostModule;

/**
 * Created by mjurinic on 06.01.16..
 */
@Component(modules = {
        AppContextModule.class,
        HostModule.class,
        ApiModule.class,
        ClientModule.class
})
public interface AppComponent {

    void inject(PostterApp app);
}
