package com.example.usermanagement.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.usermanagement.R;
import com.example.usermanagement.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);



        binding.loginBtn.setOnClickListener(v -> {

        });
        binding.registerBtn.setOnClickListener(v -> {

            if (binding.emailLayout.getEditText().getText().toString().isEmpty()){
                Toast.makeText(this, "please enter email id ", Toast.LENGTH_SHORT).show();
            } else if (binding.passwordLayout.getEditText().getText().toString().isEmpty()) {
                Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            } else if (binding.passwordLayout.getEditText().getText().toString().isEmpty()) {
                Toast.makeText(this, "please enter name", Toast.LENGTH_SHORT).show();
            }
            else
                switchOnLogin();
        });

    }







    private void switchOnLogin() {

        Intent i=new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
    }
}