package hr.foi.mjurinic.postter.mvp.interactors;

import hr.foi.mjurinic.postter.listeners.Listener;
import hr.foi.mjurinic.postter.models.BaseCouchResponse;
import hr.foi.mjurinic.postter.models.Relationship;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface FollowInteractor extends BaseInteractor {

    void followerUser(String token, Relationship relationship, Listener<BaseCouchResponse> listener);
}
