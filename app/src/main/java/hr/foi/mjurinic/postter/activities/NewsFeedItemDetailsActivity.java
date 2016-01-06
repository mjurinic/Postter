package hr.foi.mjurinic.postter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.adapters.NewsFeedCommentsAdapter;
import hr.foi.mjurinic.postter.dagger.components.DaggerNewsFeedCommentsComponent;
import hr.foi.mjurinic.postter.dagger.modules.NewsFeedCommentsModule;
import hr.foi.mjurinic.postter.models.Comments;
import hr.foi.mjurinic.postter.models.NewsFeedCommentsResponse;
import hr.foi.mjurinic.postter.models.NewsFeedResponse;
import hr.foi.mjurinic.postter.mvp.presenters.NewsFeedCommentsPresenter;
import hr.foi.mjurinic.postter.mvp.views.NewsFeedCommentsView;

public class NewsFeedItemDetailsActivity extends BaseActivity implements NewsFeedCommentsView {

    @Inject
    NewsFeedCommentsPresenter presenter;

    @Bind(R.id.news_feed_comments)
    RecyclerView newsFeedComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed_item_details);
        ButterKnife.bind(this);

        DaggerNewsFeedCommentsComponent.builder()
                .newsFeedCommentsModule(new NewsFeedCommentsModule(this))
                .build()
                .inject(this);

        Intent intent = getIntent();
        NewsFeedResponse item = (NewsFeedResponse) intent.getSerializableExtra("NewsFeedItem");
        newsFeedComments.setLayoutManager(new LinearLayoutManager(this));

        presenter.fetchComments(this, item.getId());

    }

    @Override
    public void onSuccess(ArrayList<NewsFeedCommentsResponse> commentsArrayList) {
        newsFeedComments.setAdapter(new NewsFeedCommentsAdapter(commentsArrayList.get(0).getComments()));
    }

    @Override
    public void onFailure(String message) {
        showError(message);
    }
}
