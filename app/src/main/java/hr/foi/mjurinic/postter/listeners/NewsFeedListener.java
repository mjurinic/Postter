package hr.foi.mjurinic.postter.listeners;

import java.util.ArrayList;

import hr.foi.mjurinic.postter.models.NewsFeedResponse;

/**
 * Created by noxqs on 06.01.16..
 */
public interface NewsFeedListener<NewsFeedResponse> {

    void onSuccess(ArrayList<NewsFeedResponse> responseArrayList);
    void onFailure(String message);

}
