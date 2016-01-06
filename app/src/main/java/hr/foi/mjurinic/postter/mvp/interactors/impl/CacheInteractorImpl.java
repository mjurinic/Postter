package hr.foi.mjurinic.postter.mvp.interactors.impl;

import android.util.LruCache;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.models.SecurityDoc;
import hr.foi.mjurinic.postter.models.User;
import hr.foi.mjurinic.postter.mvp.interactors.CacheInteractor;

/**
 * Created by mjurinic on 27.10.15..
 */
public class CacheInteractorImpl implements CacheInteractor {

    private static final int CACHE_SIZE = 2 * 1024; // in number of items not in bytes

    public static final String USER = "token";
    public static final String DOC = "doc";

    private volatile LruCache<String, Object> lruCache;

    @Inject
    public CacheInteractorImpl() {
        lruCache = new LruCache<>(CACHE_SIZE);
    }

    private synchronized void setCache(String key, Object object) {
        lruCache.put(key, object);
    }

    private synchronized Object getCache(String key) {
        return lruCache.get(key);
    }


    @Override
    public void cacheUser(User user) {
        setCache(USER, user);
    }

    @Override

    public User getUser() {
        return (User) getCache(USER);
    }

    @Override
    public void cacheSecurityDoc(SecurityDoc securityDoc) {
        setCache(DOC, securityDoc);
    }

    @Override
    public SecurityDoc getSecurityDoc() {
        return (SecurityDoc) getCache(DOC);
    }


}
