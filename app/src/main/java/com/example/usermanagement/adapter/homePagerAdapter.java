package com.example.usermanagement.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.usermanagement.NavFragments.DashboardFragment;
import com.example.usermanagement.NavFragments.ProfileFragment;
import com.example.usermanagement.NavFragments.UserFragment;

public class homePagerAdapter extends FragmentStateAdapter {

    public homePagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new DashboardFragment();
            case 1:
                return new ProfileFragment();
            case 2:
                return new UserFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
