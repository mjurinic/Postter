package hr.foi.mjurinic.postter.listeners;

import java.util.ArrayList;

/**
 * Created by noxqs on 06.01.16..
 */
public interface NewsFeedListener<T> {

    void onSuccess(ArrayList<T> responseArrayList);
    void onFailure(String message);

}
