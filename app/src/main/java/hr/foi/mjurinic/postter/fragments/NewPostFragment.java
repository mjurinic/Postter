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
import hr.foi.mjurinic.postter.dagger.components.DaggerNewPostComponent;
import hr.foi.mjurinic.postter.dagger.modules.NewPostModule;
import hr.foi.mjurinic.postter.mvp.presenters.NewPostPresenter;
import hr.foi.mjurinic.postter.mvp.views.NewPostView;

/**
 * Created by mjurinic on 06.01.16..
 */
public class NewPostFragment extends BaseFragment implements NewPostView {

    @Bind(R.id.et_post_body)
    EditText postBody;

    @Inject
    NewPostPresenter postPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_post, container, false);

        ButterKnife.bind(this, view);

        DaggerNewPostComponent.builder()
                .newPostModule(new NewPostModule(this))
                .build()
                .inject(this);

        return view;
    }

    @OnClick(R.id.btn_new_post)
    public void onPostButtonClick() {
        String body = postBody.getText().toString();

        postPresenter.createPost(body);
    }

    @Override
    public void onSuccess() {
        postBody.setText("");

        Toast.makeText(getActivity(), "New post created!", Toast.LENGTH_SHORT).show();
    }
}
