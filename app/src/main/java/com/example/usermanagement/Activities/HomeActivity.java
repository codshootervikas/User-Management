package com.example.usermanagement.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.usermanagement.NavFragments.DashboardFragment;
import com.example.usermanagement.NavFragments.ProfileFragment;
import com.example.usermanagement.NavFragments.UserFragment;
import com.example.usermanagement.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView=findViewById(R.id.bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new DashboardFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {

        Fragment fragment=null;

        int itemId = menuitem.getItemId();
        if (itemId == R.id.dashboard) {
            fragment = new DashboardFragment();
        } else if (itemId == R.id.user) {
            fragment = new UserFragment();
        } else if (itemId == R.id.profile) {
            fragment = new ProfileFragment();
        }

        if (fragment!=null){
            loadFragment(fragment);
        }
        return true;
    }

    void loadFragment(Fragment fragment){

        //to attech fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.relativelayout,fragment).commit();
    }
}