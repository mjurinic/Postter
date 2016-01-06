package hr.foi.mjurinic.postter.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.activities.NewsFeedItemDetailsActivity;
import hr.foi.mjurinic.postter.adapters.NewsFeedAdapter;
import hr.foi.mjurinic.postter.dagger.components.DaggerNewsFeedComponent;
import hr.foi.mjurinic.postter.dagger.modules.NewsFeedModule;
import hr.foi.mjurinic.postter.listeners.NewsFeedClickListener;
import hr.foi.mjurinic.postter.models.FollowingResponse;
import hr.foi.mjurinic.postter.models.NewsFeedResponse;
import hr.foi.mjurinic.postter.mvp.presenters.NewsFeedPresenter;
import hr.foi.mjurinic.postter.mvp.views.NewsFeedView;

/**
 * Created by noxqs on 06.01.16..
 */
public class NewsFeedFragment extends BaseFragment implements NewsFeedView, NewsFeedClickListener {

    @Inject
    NewsFeedPresenter presenter;

    @Bind(R.id.news_feed_recyclerview)
    RecyclerView newsFeedRecyclerview;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_feed, container, false);
        ButterKnife.bind(this, view);

        DaggerNewsFeedComponent.builder()
                .newsFeedModule(new NewsFeedModule(this))
                .build()
                .inject(this);

        presenter.fetchFollowers(getActivity());

        newsFeedRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;
    }

    @Override
    public void onFollowersFetched(FollowingResponse followingResponses) {
        Log.e("Followers", "FETCHED");
        presenter.fetchNewsFeed();
    }

    @Override
    public void onFollowersError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNewsFeedFetched(ArrayList<NewsFeedResponse> newsFeedResponse) {

        newsFeedRecyclerview.setAdapter(new NewsFeedAdapter(newsFeedResponse, this));
    }

    @Override
    public void onNewsFeedError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
        Log.e("Error", error);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onNewsFeedItemClick(NewsFeedResponse response) {
        Intent intent = new Intent(getActivity(), NewsFeedItemDetailsActivity.class);
        intent.putExtra("NewsFeedItem", response);
        startActivity(intent);
    }
}
