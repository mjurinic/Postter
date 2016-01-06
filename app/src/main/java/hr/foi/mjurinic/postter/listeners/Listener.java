package hr.foi.mjurinic.postter.listeners;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface Listener<Type> {

    void onSuccess(Type type);

    void onFailure(String message);
}
