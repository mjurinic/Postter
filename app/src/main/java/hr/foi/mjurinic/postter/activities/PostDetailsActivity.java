package hr.foi.mjurinic.postter.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.adapters.NewsFeedCommentsAdapter;
import hr.foi.mjurinic.postter.dagger.components.DaggerNewsFeedCommentsComponent;
import hr.foi.mjurinic.postter.dagger.modules.NewsFeedCommentsModule;
import hr.foi.mjurinic.postter.models.Comments;
import hr.foi.mjurinic.postter.models.NewsFeedCommentsResponse;
import hr.foi.mjurinic.postter.models.NewsFeedResponse;
import hr.foi.mjurinic.postter.mvp.presenters.NewsFeedCommentsPresenter;
import hr.foi.mjurinic.postter.mvp.views.NewsFeedCommentsView;

public class PostDetailsActivity extends BaseActivity implements NewsFeedCommentsView {

    public static final String NEWS_FEED_ITEM = "NewsFeedItem";

    @Inject
    NewsFeedCommentsPresenter presenter;

    @Bind(R.id.news_feed_comments)
    RecyclerView recyclerView;

    @Bind(R.id.comments_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Bind(R.id.et_new_comment)
    EditText commentBody;

    private LinearLayoutManager layoutManager;
    private boolean isRefreshed = false;
    private NewsFeedResponse item;
    private NewsFeedCommentsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed_item_details);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DaggerNewsFeedCommentsComponent.builder()
                .newsFeedCommentsModule(new NewsFeedCommentsModule(this))
                .build()
                .inject(this);

        init();

        this.showProgress();
        presenter.fetchComments(item.getId());
    }

    @OnClick(R.id.btn_send_comment)
    public void btnSendPressed() {
        this.showProgress();
        presenter.postComment(commentBody.getText().toString(), item.getId());
    }

    private void init() {
        item = (NewsFeedResponse) getIntent().getSerializableExtra(NEWS_FEED_ITEM);
        layoutManager = new LinearLayoutManager(this);

        swipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefreshed = true;
                presenter.fetchComments(item.getId());
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initAdapter(ArrayList<NewsFeedCommentsResponse> comments) {
        adapter = new NewsFeedCommentsAdapter(comments.get(0).getComments());
        recyclerView.setAdapter(adapter);
    }

    private void refreshAdapter(ArrayList<NewsFeedCommentsResponse> comments) {
        if (adapter != null) {
            isRefreshed = false;

            adapter.refresh(comments.get(0).getComments());

            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onSuccessfulPost(Comments comment) {
        adapter.appendComment(comment);
        commentBody.setText("");
    }

    @Override
    public void onSuccess(ArrayList<NewsFeedCommentsResponse> comments) {
        this.hideProgress();

        if (isRefreshed) {
            refreshAdapter(comments);
        } else {
            initAdapter(comments);
        }
    }

    @Override
    public void onFailure(String message) {
        showError(message);
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
