package hr.foi.mjurinic.postter.mvp.interactors;

import java.util.ArrayList;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.MyPostsResponse;

/**
 * Created by mjurinic on 12.01.16..
 */
public interface MyPostsInteractor extends BaseInteractor {

    void getMyPosts(Listener<ArrayList<MyPostsResponse>> listener, String token);
}
