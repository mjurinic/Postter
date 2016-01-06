package hr.foi.mjurinic.postter.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;

import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.dagger.components.DaggerNewsFeedComponent;
import hr.foi.mjurinic.postter.dagger.modules.NewsFeedModule;
import hr.foi.mjurinic.postter.models.FollowingResponse;
import hr.foi.mjurinic.postter.models.NewsFeedResponse;
import hr.foi.mjurinic.postter.mvp.presenters.NewsFeedPresenter;
import hr.foi.mjurinic.postter.mvp.views.NewsFeedView;

/**
 * Created by noxqs on 06.01.16..
 */
public class NewsFeedFragment extends BaseFragment implements NewsFeedView{

    @Inject
    NewsFeedPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_feed, container, false);

        DaggerNewsFeedComponent.builder()
                .newsFeedModule(new NewsFeedModule(this))
                .build()
                .inject(this);

        presenter.fetchFollowers(getActivity());

        return view;
    }

    @Override
    public void onFollowersFetched(FollowingResponse followingResponses) {
        Log.e("PENIS", followingResponses.getUserId());
    }

    @Override
    public void onFollowersError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNewsFeedFetched(NewsFeedResponse newsFeedResponse) {

    }

    @Override
    public void onNewsFeedError(String error) {

    }
}
