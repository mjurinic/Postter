package hr.foi.mjurinic.postter.mvp.presenters;

import android.content.Context;

import hr.foi.mjurinic.postter.models.Comments;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface NewsFeedCommentsPresenter extends BasePresenter {

    void fetchComments(String id);


    void postComment(String commentBody, String postId);
}
