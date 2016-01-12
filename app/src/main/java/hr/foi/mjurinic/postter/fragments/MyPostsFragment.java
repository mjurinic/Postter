package hr.foi.mjurinic.postter.fragments;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.adapters.MyPostsAdapter;
import hr.foi.mjurinic.postter.dagger.components.DaggerMyPostsComponent;
import hr.foi.mjurinic.postter.dagger.modules.MyPostsModule;
import hr.foi.mjurinic.postter.models.MyPostsResponse;
import hr.foi.mjurinic.postter.mvp.presenters.MyPostsPresenter;
import hr.foi.mjurinic.postter.mvp.views.MyPostsView;

/**
 * Created by mjurinic on 12.01.16..
 */
public class MyPostsFragment extends BaseFragment implements MyPostsView {

    @Bind(R.id.my_posts_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Bind(R.id.my_posts_recycler_view)
    RecyclerView recyclerView;

    @Inject
    MyPostsPresenter myPostsPresenter;

    private MyPostsAdapter myPostsAdapter;
    private boolean isRefreshed = false;
    private LinearLayoutManager layoutManager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_posts, container, false);
        ButterKnife.bind(this, view);

        DaggerMyPostsComponent.builder()
                .myPostsModule(new MyPostsModule(this))
                .build()
                .inject(this);

        init();

        this.showProgress();
        myPostsPresenter.getMyPosts();

        return view;
    }

    @Override
    public void onSuccess(ArrayList<MyPostsResponse> posts) {
        this.hideProgress();

        if (isRefreshed) {
            refreshAdapter(posts);
        } else {
            initAdapter(posts);
        }
    }

    private void init() {
        layoutManager = new LinearLayoutManager(getActivity());

        swipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefreshed = true;
                myPostsPresenter.getMyPosts();
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initAdapter(ArrayList<MyPostsResponse> posts) {
        myPostsAdapter = new MyPostsAdapter(posts);
        recyclerView.setAdapter(myPostsAdapter);
    }

    private void refreshAdapter(ArrayList<MyPostsResponse> posts) {
        if (myPostsAdapter != null) {
            isRefreshed = false;

            myPostsAdapter.refresh(posts);

            swipeRefreshLayout.setRefreshing(false);
        }
    }
}
