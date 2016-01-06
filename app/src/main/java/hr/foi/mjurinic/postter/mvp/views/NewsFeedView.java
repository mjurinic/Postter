package hr.foi.mjurinic.postter.mvp.views;

import hr.foi.mjurinic.postter.models.FollowingResponse;
import hr.foi.mjurinic.postter.models.NewsFeedResponse;

/**
 * Created by noxqs on 06.01.16..
 */
public interface NewsFeedView {

    void onFollowersFetched(FollowingResponse followingResponses);
    void onFollowersError(String error);
    void onNewsFeedFetched(NewsFeedResponse newsFeedResponse);
    void onNewsFeedError(String error);
}
