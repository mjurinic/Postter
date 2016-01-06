package hr.foi.mjurinic.postter.dagger.modules;

import android.content.Context;
import android.content.res.Resources;

import dagger.Module;
import dagger.Provides;
import hr.foi.mjurinic.postter.PostterApp;

/**
 * Created by mjurinic on 06.01.16..
 */
@Module
public class AppContextModule {

    @Provides
    public Context provideContext() {
        return PostterApp.getInstance();
    }

    @Provides
    public Resources provideResources(Context context) {
        return context.getResources();
    }
}
