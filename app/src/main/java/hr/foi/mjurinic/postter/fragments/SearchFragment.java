package hr.foi.mjurinic.postter.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
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

    @Bind(R.id.search_card_included)
    LinearLayout userCard;

    @Bind(R.id.search_profile_full_name)
    TextView profileFullName;

    @Bind(R.id.search_profile_username)
    TextView profileUsername;

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

    @OnClick(R.id.iv_search_item_follow)
    public void onFollowClick() {
        searchPresenter.followUser(user.getName());
    }

    @Override
    public void onSearchSuccess(User user) {
        tvNotFound.setVisibility(View.INVISIBLE);
        userCard.setVisibility(View.VISIBLE);
        this.user = user;

        profileFullName.setText(user.getFirstName() + " " + user.getLastName());
        profileUsername.setText(user.getName());
    }

    @Override
    public void onSearchFailure() {
        tvNotFound.setVisibility(View.VISIBLE);
        userCard.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onFollowSuccess() {
        Toast.makeText(getActivity(), "You are now following " + user.getName(), Toast.LENGTH_SHORT).show();
        userCard.setVisibility(View.INVISIBLE);
        etSearch.setText("");
    }
}
