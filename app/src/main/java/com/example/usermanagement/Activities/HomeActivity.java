package com.example.usermanagement.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.example.usermanagement.R;
import com.example.usermanagement.databinding.ActivityHomeBinding;
import com.example.usermanagement.adapter.homePagerAdapter;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        homePagerAdapter pagerAdapter = new homePagerAdapter(this);
        binding.viewPager.setAdapter(pagerAdapter);

        binding.bottomNav.setOnItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.dashboard)
                binding.viewPager.setCurrentItem(0, false);
            else if (menuItem.getItemId() == R.id.user)
                binding.viewPager.setCurrentItem(1, false);
            else if (menuItem.getItemId() == R.id.profile)
                binding.viewPager.setCurrentItem(2, false);
            return true;
        });


        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.bottomNav.getMenu().getItem(position).setChecked(true);
            }
        });


    }


}