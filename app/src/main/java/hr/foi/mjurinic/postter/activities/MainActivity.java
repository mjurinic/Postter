package hr.foi.mjurinic.postter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.adapters.ViewPagerAdapter;
import hr.foi.mjurinic.postter.fragments.MyPostsFragment;
import hr.foi.mjurinic.postter.fragments.NewsFeedFragment;
import hr.foi.mjurinic.postter.fragments.SearchFragment;

public class MainActivity extends BaseActivity implements TabLayout.OnTabSelectedListener{

    @Bind(R.id.main_tab_layout)
    TabLayout mainTabLayout;

    @Bind(R.id.main_view_pager)
    ViewPager mainViewPager;

    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initTabs();
        initFragmentList();

        final PagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        mainViewPager.setAdapter(adapter);
        mainViewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainTabLayout));
        mainTabLayout.setOnTabSelectedListener(this);
    }

    private void initFragmentList() {
        fragments = new ArrayList<>();

        fragments.add(new MyPostsFragment());
        fragments.add(new NewsFeedFragment());
        fragments.add(new SearchFragment());
    }

    private void initTabs() {
        mainTabLayout.addTab(mainTabLayout.newTab().setText("My Posts"));
        mainTabLayout.addTab(mainTabLayout.newTab().setText("Feed"));
        mainTabLayout.addTab(mainTabLayout.newTab().setText("Search"));
//        mainTabLayout.addTab(mainTabLayout.newTab().setText("Trending"));
    }

    @OnClick(R.id.btn_compose)
    public void onComposeButtonClicked() {
        startActivity(new Intent(getApplicationContext(), ComposeActivity.class));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mainViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}

