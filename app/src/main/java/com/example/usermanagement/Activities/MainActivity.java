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

import com.example.usermanagement.ModelResponse.RegisterResponse;
import com.example.usermanagement.R;
import com.example.usermanagement.RetrofitClient;
import com.example.usermanagement.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // for login button
        binding.loginBtn.setOnClickListener(v -> {
            // goto login screen
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });


        // register button
        binding.registerBtn.setOnClickListener(v -> {
            if (binding.nameLayout.getEditText().getText().toString().isEmpty())
                Toast.makeText(this, "please enter name", Toast.LENGTH_SHORT).show();
            else if (binding.emailLayout.getEditText().getText().toString().isEmpty())
                Toast.makeText(this, "please enter email id ", Toast.LENGTH_SHORT).show();
            else if (binding.passwordLayout.getEditText().getText().toString().isEmpty())
                Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            else
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });

        Call<RegisterResponse> call= RetrofitClient
                .getInstance()
                .getApi()
                .register(binding.registerBtn);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                RegisterResponse registerResponse=response.body();
                if (response.isSuccessful()){

                    Toast.makeText(MainActivity.this, registerResponse.getMessege(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, registerResponse.getMessege(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable throwable) {

                Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }

  }



