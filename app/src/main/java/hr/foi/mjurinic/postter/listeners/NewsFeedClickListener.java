package hr.foi.mjurinic.postter.listeners;

import hr.foi.mjurinic.postter.models.NewsFeedResponse;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface NewsFeedClickListener {

    void onNewsFeedItemClick(NewsFeedResponse response);
}
