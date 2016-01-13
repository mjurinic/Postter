package hr.foi.mjurinic.postter.mvp.views;

import java.util.ArrayList;

import hr.foi.mjurinic.postter.models.Trending;

/**
 * Created by mjurinic on 13.01.16..
 */
public interface TrendingView extends BaseView {

    void onSuccess(ArrayList<Trending> trends);
}
