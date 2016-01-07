package hr.foi.mjurinic.postter.mvp.interactors;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.BaseCouchResponse;
import hr.foi.mjurinic.postter.models.Post;

/**
 * Created by mjurinic on 07.01.16..
 */
public interface NewPostInteractor extends BaseInteractor {

    void postNewPost(String token, Post post, Listener<BaseCouchResponse> listener);
}
