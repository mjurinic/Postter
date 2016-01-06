package hr.foi.mjurinic.postter.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.adapters.ViewPagerAdapter;
import hr.foi.mjurinic.postter.fragments.NewsFeedFragment;
import hr.foi.mjurinic.postter.fragments.PersonalMessagesFragment;
import hr.foi.mjurinic.postter.fragments.TrendingFragment;

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

        fragments.add(new NewsFeedFragment());
        fragments.add(new PersonalMessagesFragment());
        fragments.add(new TrendingFragment());
    }

    private void initTabs() {
        mainTabLayout.addTab(mainTabLayout.newTab().setText("NewsFeed"));
        mainTabLayout.addTab(mainTabLayout.newTab().setText("Personal Messages"));
        mainTabLayout.addTab(mainTabLayout.newTab().setText("Trending"));
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

