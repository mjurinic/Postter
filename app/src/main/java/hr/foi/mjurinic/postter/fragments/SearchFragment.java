package hr.foi.mjurinic.postter.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.dagger.components.DaggerSearchComponent;
import hr.foi.mjurinic.postter.dagger.modules.SearchModule;
import hr.foi.mjurinic.postter.models.User;
import hr.foi.mjurinic.postter.mvp.presenters.SearchPresenter;
import hr.foi.mjurinic.postter.mvp.views.SearchView;

/**
 * Created by noxqs on 06.01.16..
 */
public class SearchFragment extends BaseFragment implements SearchView {

    @Bind(R.id.et_search_name)
    EditText etSearch;

    @Bind(R.id.tv_search_not_found)
    TextView tvNotFound;

    @Inject
    SearchPresenter searchPresenter;

    private User user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        ButterKnife.bind(this, view);

        DaggerSearchComponent.builder()
                .searchModule(new SearchModule(this))
                .build()
                .inject(this);

        return view;
    }

    @OnClick(R.id.btn_search_name)
    public void onSearchClick() {
        searchPresenter.searchUser(etSearch.getText().toString());
    }

    @Override
    public void onSearchSuccess(User user) {
        tvNotFound.setVisibility(View.INVISIBLE);
        this.user = user;

        Log.d("DEBUG", "Nasel sam ga... " + user.getName());

        // inflate that shit

        /*@OnClick(R.id.iv_search_item_follow)
        public void onFollowClick() {
            searchPresenter.followUser(user.getName());
        }*/
    }

    @Override
    public void onSearchFailure() {
        tvNotFound.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFollowSuccess() {
        Toast.makeText(getActivity(), "You are now following " + user.getName(), Toast.LENGTH_SHORT).show();
    }
}
