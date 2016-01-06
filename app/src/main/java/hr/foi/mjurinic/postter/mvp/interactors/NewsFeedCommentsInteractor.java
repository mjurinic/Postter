package hr.foi.mjurinic.postter.mvp.interactors;

import android.content.Context;

import hr.foi.mjurinic.postter.listeners.NewsFeedListener;
import hr.foi.mjurinic.postter.models.Comments;
import hr.foi.mjurinic.postter.models.NewsFeedCommentsResponse;

/**
 * Created by noxqs on 06.01.16..
 */
public interface NewsFeedCommentsInteractor extends BaseInteractor {

    void fetchComments(Context context, NewsFeedListener<NewsFeedCommentsResponse> listener, String id);

}
