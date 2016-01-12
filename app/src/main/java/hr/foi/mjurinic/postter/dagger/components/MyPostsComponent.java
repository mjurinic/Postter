package hr.foi.mjurinic.postter.dagger.components;

import dagger.Component;
import hr.foi.mjurinic.postter.dagger.modules.AppContextModule;
import hr.foi.mjurinic.postter.dagger.modules.MyPostsModule;
import hr.foi.mjurinic.postter.dagger.modules.NetworkModule;
import hr.foi.mjurinic.postter.fragments.MyPostsFragment;

/**
 * Created by mjurinic on 12.01.16..
 */
@Component(modules = {
        AppContextModule.class,
        NetworkModule.class,
        MyPostsModule.class
})
public interface MyPostsComponent {

    void inject(MyPostsFragment fragment);
}
