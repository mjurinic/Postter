package hr.foi.mjurinic.postter.mvp.interactors;

import android.content.Context;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.listeners.NewsFeedListener;
import hr.foi.mjurinic.postter.models.BaseCouchResponse;
import hr.foi.mjurinic.postter.models.Comments;
import hr.foi.mjurinic.postter.models.NewsFeedCommentsResponse;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface NewsFeedCommentsInteractor extends BaseInteractor {

    void fetchComments(String token, NewsFeedListener<NewsFeedCommentsResponse> listener, String id);

    void postComment(Comments comment, String token, Listener<BaseCouchResponse> listener);
}
