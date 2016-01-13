package hr.foi.mjurinic.postter.dagger.components;

import dagger.Component;
import hr.foi.mjurinic.postter.dagger.modules.AppContextModule;
import hr.foi.mjurinic.postter.dagger.modules.NetworkModule;
import hr.foi.mjurinic.postter.dagger.modules.TrendingModule;
import hr.foi.mjurinic.postter.fragments.TrendingFragment;

/**
 * Created by mjurinic on 13.01.16..
 */
@Component(modules = {
        AppContextModule.class,
        NetworkModule.class,
        TrendingModule.class
})
public interface TrendingComponent {

    void inject(TrendingFragment fragment);
}
