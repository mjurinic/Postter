package hr.foi.mjurinic.postter.mvp.views;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Created by mjurinic on 06.01.16..
 */
public interface BaseView {

    void showProgress();

    void hideProgress();

    void showError(String message);

    void showDialog(String title, String message, MaterialDialog.SingleButtonCallback positiveCallback,
                    MaterialDialog.SingleButtonCallback negativeCallback, String positiveButtonText, String negativeButtonText);
}
