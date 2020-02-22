package com.rrdev.tablayout.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.rrdev.tablayout.R;
import com.rrdev.tablayout.adapter.ViewPagerAdapter;
import com.rrdev.tablayout.fragment.FragmentOne;
import com.rrdev.tablayout.fragment.FragmentThree;
import com.rrdev.tablayout.fragment.FragmentTwo;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter( getSupportFragmentManager());

        adapter.AddFragment(new FragmentOne(),"One");
        adapter.AddFragment(new FragmentTwo(),"Two");
        adapter.AddFragment(new FragmentThree(),"Three");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_tab);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_tab);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_tab);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }
}
