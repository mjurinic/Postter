package hr.foi.mjurinic.postter.dagger.components;

import dagger.Component;
import hr.foi.mjurinic.postter.dagger.modules.AppContextModule;
import hr.foi.mjurinic.postter.dagger.modules.CacheModule;
import hr.foi.mjurinic.postter.dagger.modules.NetworkModule;
import hr.foi.mjurinic.postter.dagger.modules.SearchModule;
import hr.foi.mjurinic.postter.fragments.SearchFragment;

/**
 * Created by mjurinic on 06.01.16..
 */
@Component(modules = {
        AppContextModule.class,
        NetworkModule.class,
        CacheModule.class,
        SearchModule.class
})
public interface SearchComponent {

    void inject(SearchFragment fragment);
}
