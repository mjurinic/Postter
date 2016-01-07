package hr.foi.mjurinic.postter.mvp.views;

import java.util.ArrayList;

import hr.foi.mjurinic.postter.models.Comments;
import hr.foi.mjurinic.postter.models.NewsFeedCommentsResponse;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface NewsFeedCommentsView {

    void onSuccess(ArrayList<NewsFeedCommentsResponse> commentsArrayList);

    void onFailure(String message);
}
