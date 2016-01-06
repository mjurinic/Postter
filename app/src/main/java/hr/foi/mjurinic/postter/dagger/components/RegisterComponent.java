package hr.foi.mjurinic.postter.dagger.components;

import dagger.Component;
import hr.foi.mjurinic.postter.dagger.modules.AppContextModule;
import hr.foi.mjurinic.postter.dagger.modules.CacheModule;
import hr.foi.mjurinic.postter.dagger.modules.NetworkModule;
import hr.foi.mjurinic.postter.dagger.modules.RegisterModule;
import hr.foi.mjurinic.postter.fragments.RegisterFragment;

/**
 * Created by mjurinic on 06.01.16..
 */
@Component(modules = {
        AppContextModule.class,
        CacheModule.class,
        NetworkModule.class,
        RegisterModule.class
})
public interface RegisterComponent {

    void inject(RegisterFragment fragment);
}
