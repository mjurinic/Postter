package hr.foi.mjurinic.postter.dagger.components;

import dagger.Component;
import hr.foi.mjurinic.postter.activities.NewsFeedItemDetailsActivity;
import hr.foi.mjurinic.postter.dagger.modules.NetworkModule;
import hr.foi.mjurinic.postter.dagger.modules.NewsFeedCommentsModule;

/**
 * Created by mjurinic on 06.01.16..
 */
@Component(modules = {
        NetworkModule.class,
        NewsFeedCommentsModule.class
})
public interface NewsFeedCommentsComponent {

    void inject(NewsFeedItemDetailsActivity activity);
}
