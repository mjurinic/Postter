package hr.foi.mjurinic.postter.mvp.presenters;

import android.content.Context;

/**
 * Created by noxqs on 06.01.16..
 */
public interface NewsFeedCommentsPresenter extends BasePresenter {

    void fetchComments(Context context, String id);

}
