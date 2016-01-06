package hr.foi.mjurinic.postter.mvp.presenters;

import android.content.Context;

/**
 * Created by noxqs on 06.01.16..
 */
public interface NewsFeedPresenter extends BasePresenter{

    void fetchFollowers(Context context);
    void fetchNewsFeed();

}
