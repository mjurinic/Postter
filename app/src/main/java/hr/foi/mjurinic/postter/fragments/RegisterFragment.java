package hr.foi.mjurinic.postter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.activities.StartActivity;
import hr.foi.mjurinic.postter.dagger.components.DaggerRegisterComponent;
import hr.foi.mjurinic.postter.dagger.modules.RegisterModule;
import hr.foi.mjurinic.postter.models.User;
import hr.foi.mjurinic.postter.mvp.presenters.RegisterPresenter;
import hr.foi.mjurinic.postter.mvp.views.RegisterView;

/**
 * Created by mjurinic on 06.01.16..
 */
public class RegisterFragment extends BaseFragment implements RegisterView {

    @Bind(R.id.et_register_first_name)
    EditText etFirstName;

    @Bind(R.id.et_register_last_name)
    EditText etLastName;

    @Bind(R.id.et_register_username)
    EditText etName;

    @Bind(R.id.et_register_password)
    EditText etPassword;

    @Bind(R.id.et_register_email)
    EditText etEmail;

    @Inject
    RegisterPresenter registerPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        ButterKnife.bind(this, view);

        DaggerRegisterComponent.builder()
                .registerModule(new RegisterModule(this))
                .build()
                .inject(this);

        return view;
    }

    @Override
    public void onSuccess() {
        Toast.makeText(getActivity(), getResources().getString(R.string.successful_registration), Toast.LENGTH_SHORT).show();
        ((StartActivity) getActivity()).switchToLogin();
    }

    @OnClick(R.id.btn_register)
    public void onRegisterClick() {
//        String firstName = etFirstName.getText().toString();
//        String lastName = etLastName.getText().toString();
//        String name = etName.getText().toString();
//        String password = etPassword.getText().toString();
//        String email = etEmail.getText().toString();

        String firstName = "Krešimir";
        String lastName = "Valjevac";
        String name = "kvaljeva";
        String password = "123456";
        String email = "kvaljeva@foi.hr";

        registerPresenter.registerUser(new User(firstName, lastName, name, password, email));
    }
}
