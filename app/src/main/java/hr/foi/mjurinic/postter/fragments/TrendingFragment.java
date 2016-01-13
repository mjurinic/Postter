package hr.foi.mjurinic.postter.fragments;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.adapters.MyPostsAdapter;
import hr.foi.mjurinic.postter.adapters.TrendingAdapter;
import hr.foi.mjurinic.postter.dagger.components.DaggerTrendingComponent;
import hr.foi.mjurinic.postter.dagger.modules.TrendingModule;
import hr.foi.mjurinic.postter.models.Trending;
import hr.foi.mjurinic.postter.mvp.presenters.TrendingPresenter;
import hr.foi.mjurinic.postter.mvp.views.TrendingView;

/**
 * Created by mjurinic on 13.01.16..
 */
public class TrendingFragment extends BaseFragment implements TrendingView {

    @Inject
    TrendingPresenter presenter;

    @Bind(R.id.trending_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Bind(R.id.trending_recycler_view)
    RecyclerView recyclerView;

    private TrendingAdapter adapter;
    private boolean isRefreshed = false;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trending, container, false);

        ButterKnife.bind(this, view);

        DaggerTrendingComponent.builder()
                .trendingModule(new TrendingModule(this))
                .build()
                .inject(this);

        init();

        this.showProgress();
        presenter.getTrends();

        return view;
    }

    void init() {
        layoutManager = new GridLayoutManager(getActivity(), 2);

        swipeRefreshLayout.setColorSchemeColors(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefreshed = true;
                presenter.getTrends();
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initAdapter(ArrayList<Trending> trends) {
        adapter = new TrendingAdapter(trends);
        recyclerView.setAdapter(adapter);
    }

    private void refreshAdapter(ArrayList<Trending> trends) {
        if (adapter != null) {
            isRefreshed = false;

            adapter.refresh(trends);

            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onSuccess(ArrayList<Trending> trends) {
        this.hideProgress();

        if (isRefreshed) {
            refreshAdapter(trends);
        } else {
            initAdapter(trends);
        }
    }
}
