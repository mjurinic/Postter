package hr.foi.mjurinic.postter.dagger.components;

import dagger.Component;
import hr.foi.mjurinic.postter.dagger.modules.AppContextModule;
import hr.foi.mjurinic.postter.dagger.modules.CacheModule;
import hr.foi.mjurinic.postter.dagger.modules.NetworkModule;
import hr.foi.mjurinic.postter.dagger.modules.NewPostModule;
import hr.foi.mjurinic.postter.fragments.NewPostFragment;

/**
 * Created by mjurinic on 07.01.16..
 */
@Component(modules = {
        AppContextModule.class,
        NetworkModule.class,
        CacheModule.class,
        NewPostModule.class
})
public interface NewPostComponent {

    void inject(NewPostFragment fragment);
}
