package hr.foi.mjurinic.postter.mvp.interactors;

import java.util.ArrayList;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.listeners.NewsFeedListener;
import hr.foi.mjurinic.postter.models.FollowingResponse;
import hr.foi.mjurinic.postter.models.NewsFeedResponse;

/**
 * Created by noxqs on 06.01.16..
 */
public interface NewsFeedInteractor extends BaseInteractor {

    void fetchFollowers(Listener<FollowingResponse> listener, String token, String username);

    void fetchNewsFeed(NewsFeedListener<NewsFeedResponse> listener, String token, ArrayList<String> username);

}
