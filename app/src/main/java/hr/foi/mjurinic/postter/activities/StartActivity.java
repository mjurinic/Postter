package hr.foi.mjurinic.postter.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import hr.foi.mjurinic.postter.R;
import hr.foi.mjurinic.postter.adapters.ViewPagerAdapter;
import hr.foi.mjurinic.postter.fragments.LoginFragment;
import hr.foi.mjurinic.postter.fragments.RegisterFragment;

public class StartActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {

    @Bind(R.id.start_view_pager)
    ViewPager viewPager;

    @Bind(R.id.start_tab_layout)
    TabLayout tabLayout;

    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ButterKnife.bind(this);

        initTabs();
        initFragmentList();

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(this);
    }

    private void initTabs() {
        tabLayout.addTab(tabLayout.newTab().setText(R.string.login));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.register));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private void initFragmentList() {
        fragments = new ArrayList<>();

        fragments.add(new LoginFragment());
        fragments.add(new RegisterFragment());
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
