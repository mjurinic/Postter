package hr.foi.mjurinic.postter.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.activities.MainActivity;
import hr.foi.mjurinic.postter.dagger.components.DaggerLoginComponent;
import hr.foi.mjurinic.postter.dagger.modules.LoginModule;
import hr.foi.mjurinic.postter.mvp.presenters.LoginPresenter;
import hr.foi.mjurinic.postter.mvp.views.LoginView;

/**
 * Created by mjurinic on 06.01.16..
 */
public class LoginFragment extends BaseFragment implements LoginView {

    @Inject
    LoginPresenter loginPresenter;

    @Bind(R.id.et_login_username)
    EditText etUsername;

    @Bind(R.id.et_login_password)
    EditText etPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        DaggerLoginComponent.builder()
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);

        etUsername.setText("mjurinic");
        etPassword.setText("123456");

        return view;
    }

    @OnClick(R.id.btn_login)
    public void onLoginClick() {
        loginPresenter.onLoginClick(etUsername.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void onSuccess() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
