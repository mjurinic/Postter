package hr.foi.mjurinic.postter.mvp.interactors;

import java.util.ArrayList;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.BaseResponse;
import hr.foi.mjurinic.postter.models.Trending;

/**
 * Created by mjurinic on 13.01.16..
 */
public interface TrendingInteractor extends BaseInteractor {

    void getTrending(String token, Listener<ArrayList<Trending>> listener);
}
