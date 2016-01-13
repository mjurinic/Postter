package hr.foi.mjurinic.postter.activities;

import android.os.Bundle;
import android.view.MenuItem;
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

public class ComposeActivity extends BaseActivity implements NewPostView {

    @Bind(R.id.et_post_body)
    EditText postBody;

    @Inject
    NewPostPresenter postPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        DaggerNewPostComponent.builder()
                .newPostModule(new NewPostModule(this))
                .build()
                .inject(this);
    }

    @OnClick(R.id.btn_new_post)
    public void onPostButtonClick() {
        postPresenter.createPost(postBody.getText().toString());
    }

    @Override
    public void onSuccess() {
        postBody.setText("");
        Toast.makeText(this, "New post created!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }
}
