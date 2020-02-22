package com.rrdev.tablayout.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List <Fragment> IstFrgment = new ArrayList<>();
    private final List <String> IstTitles = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return IstFrgment.get(position);
    }

    @Override
    public int getCount() {
        return IstTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return IstTitles.get(position);
    }

    public void AddFragment (Fragment fragment,String title){
        IstFrgment.add(fragment);
        IstTitles.add(title);
    }

}
