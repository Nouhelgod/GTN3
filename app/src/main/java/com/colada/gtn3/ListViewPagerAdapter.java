package com.colada.gtn3;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.colada.gtn3.fragments.PlaceholderFragment;
import com.colada.gtn3.fragments.SaveExpFragment;

public class ListViewPagerAdapter extends FragmentStateAdapter {


    public ListViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new SaveExpFragment();
            case 1:
                return new PlaceholderFragment();
            default:
                return new SaveExpFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
