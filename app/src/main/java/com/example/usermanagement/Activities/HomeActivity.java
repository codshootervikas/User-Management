package com.example.usermanagement.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import com.example.usermanagement.NavFragments.DashboardFragment;
import com.example.usermanagement.NavFragments.ProfileFragment;
import com.example.usermanagement.NavFragments.UserFragment;
import com.example.usermanagement.R;
import com.example.usermanagement.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

   private ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().add(R.id.relativelayout,new DashboardFragment()).commit();
        binding.bottomNav.setOnItemSelectedListener(menuItem -> {
            Fragment fragment=null;
            if (menuItem.getItemId() == R.id.dashboard)
                fragment = new DashboardFragment();
             else if (menuItem.getItemId() == R.id.user)
                fragment = new UserFragment();
             else if (menuItem.getItemId() == R.id.profile)
                fragment = new ProfileFragment();

            if (fragment!=null)
                loadFragment(fragment);

            return true;
        });
    }

    void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.relativelayout,fragment).commit();
    }
}