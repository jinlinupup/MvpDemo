package com.jinlin.mvpdemo.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.jinlin.mvpdemo.R;
import com.jinlin.mvpdemo.base.adapter.ViewPagerAdapter;
import com.jinlin.mvpdemo.ui.fragment.FragmentFrou;
import com.jinlin.mvpdemo.ui.fragment.FragmentOne;
import com.jinlin.mvpdemo.ui.fragment.FragmentThree;
import com.jinlin.mvpdemo.ui.fragment.FragmentTwo;
import com.jinlin.mvpdemo.util.BottomNavigationViewHelper;
import com.jinlin.mvpdemo.util.custom.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private NavigationView nav_view;
    private DrawerLayout drawer_layout;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private MenuItem menuItem;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //状态栏透明
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
//            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
//        }
        initView();
    }

    @SuppressLint("ResourceAsColor")
    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_activity_main);
        toolbar.setTitle("云中有个小卖部");
        drawer_layout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.app_name, R.string.app_name);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();
        nav_view = findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(this);
        View headView = nav_view.inflateHeaderView(R.layout.nav_header_main);

        CircleImageView head_iv = headView.findViewById(R.id.civHead);

        head_iv.setOnClickListener(v -> Log.i("TAGMAIN", "OPEN THE HEAD"));

        viewPager = findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        //默认 >3 的选中效果会影响ViewPager的滑动切换时的效果，故利用反射去掉
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.item_news:
                            toolbar.setTitle(R.string.title_new);
                            viewPager.setCurrentItem(0);
                            break;
                        case R.id.item_lib:
                            toolbar.setTitle(R.string.title_lib);
                            viewPager.setCurrentItem(1);
                            break;
                        case R.id.item_find:
                            toolbar.setTitle(R.string.title_find);
                            viewPager.setCurrentItem(2);
                            break;
                        case R.id.item_more:
                            toolbar.setTitle(R.string.title_more);
                            viewPager.setCurrentItem(3);
                            break;
                    }
                    return true;
                });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());

        adapter.addFragment(FragmentOne.newInstance());
        adapter.addFragment(FragmentTwo.newInstance());
        adapter.addFragment(FragmentThree.newInstance());
        adapter.addFragment(FragmentFrou.newInstance());
        viewPager.setAdapter(adapter);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_switch_night_mode:
                drawer_layout.closeDrawers();
                return false;

            case R.id.nav_setting:

                drawer_layout.closeDrawers();
                return false;

            case R.id.nav_share:

                drawer_layout.closeDrawers();
                return false;
        }
        return false;
    }


}
