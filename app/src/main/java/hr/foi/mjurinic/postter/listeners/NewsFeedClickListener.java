package hr.foi.mjurinic.postter.listeners;

import hr.foi.mjurinic.postter.models.NewsFeedResponse;

/**
 * Created by noxqs on 06.01.16..
 */
public interface NewsFeedClickListener {

    void onNewsFeedItemClick(NewsFeedResponse response);
}
