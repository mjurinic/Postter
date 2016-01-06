package hr.foi.mjurinic.postter.mvp.interactors;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.FollowingResponse;

/**
 * Created by noxqs on 06.01.16..
 */
public interface NewsFeedInteractor extends BaseInteractor {

    void fetchNewsFeed(Listener<FollowingResponse> listener, String token, String username);

}
