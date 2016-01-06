package hr.foi.mjurinic.postter.dagger.components;

import dagger.Component;
import hr.foi.mjurinic.postter.dagger.modules.AppContextModule;
import hr.foi.mjurinic.postter.dagger.modules.LoginModule;
import hr.foi.mjurinic.postter.dagger.modules.NetworkModule;
import hr.foi.mjurinic.postter.fragments.LoginFragment;

/**
 * Created by mjurinic on 06.01.16..
 */
@Component(modules = {
        NetworkModule.class,
        LoginModule.class
})
public interface LoginComponent {

    void inject(LoginFragment fragment);
}
