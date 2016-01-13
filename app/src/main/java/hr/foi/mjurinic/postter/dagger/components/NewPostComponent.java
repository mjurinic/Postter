package hr.foi.mjurinic.postter.dagger.components;

import dagger.Component;
import hr.foi.mjurinic.postter.activities.ComposeActivity;
import hr.foi.mjurinic.postter.dagger.modules.CacheModule;
import hr.foi.mjurinic.postter.dagger.modules.NetworkModule;
import hr.foi.mjurinic.postter.dagger.modules.NewPostModule;

/**
 * Created by mjurinic on 07.01.16..
 */
@Component(modules = {
        NetworkModule.class,
        CacheModule.class,
        NewPostModule.class
})
public interface NewPostComponent {

    void inject(ComposeActivity activity);
}
