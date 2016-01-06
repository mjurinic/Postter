package hr.foi.mjurinic.postter.dagger.components;

import dagger.Component;
import hr.foi.mjurinic.postter.dagger.modules.CacheModule;
import hr.foi.mjurinic.postter.dagger.modules.NetworkModule;
import hr.foi.mjurinic.postter.dagger.modules.NewsFeedModule;
import hr.foi.mjurinic.postter.fragments.NewsFeedFragment;

/**
 * Created by noxqs on 06.01.16..
 */
@Component(modules = {
        NetworkModule.class,
        CacheModule.class,
        NewsFeedModule.class

})
public interface NewsFeedComponent {

    void inject(NewsFeedFragment fragment);
}
