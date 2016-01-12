package hr.foi.mjurinic.postter.mvp.views;

import java.util.ArrayList;

import hr.foi.mjurinic.postter.models.MyPostsResponse;

/**
 * Created by mjurinic on 12.01.16..
 */
public interface MyPostsView extends BaseView {

    void onSuccess(ArrayList<MyPostsResponse> posts);
}
