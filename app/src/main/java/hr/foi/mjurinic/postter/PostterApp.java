package hr.foi.mjurinic.postter;

import android.app.Application;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.dagger.components.DaggerAppComponent;
import hr.foi.mjurinic.postter.mvp.interactors.CacheInteractor;
import hr.foi.mjurinic.postter.network.ApiService;

/**
 * Created by mjurinic on 06.01.16..
 */
public class PostterApp extends Application {

    protected static PostterApp instance;

    @Inject
    protected ApiService apiService;

    @Inject
    protected CacheInteractor cacheInteractor;

    public static PostterApp getInstance() {
        return instance;
    }

    public static void setInstance(PostterApp instance) {
        PostterApp.instance = instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance(this);

        DaggerAppComponent.create().inject(this);
    }

    public ApiService getApiService() {
        return apiService;
    }

    public CacheInteractor getCacheInteractor() {
        return cacheInteractor;
    }
}
