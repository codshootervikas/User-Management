package com.example.usermanagement.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.usermanagement.ModelResponse.RegisterResponse;
import com.example.usermanagement.restService.RetrofitClient;
import com.example.usermanagement.databinding.ActivityMainBinding;
import com.example.usermanagement.viewModel.RegisterViewModel;

import java.util.Objects;

import kotlin.text.Regex;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private RegisterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new RegisterViewModel(this.getApplication());

        viewModel.getRegisterLiveData().observe(this, it -> {
            if (it.getMessege() != null) {
                Toast.makeText(this, it.getMessege(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }

        });


        // for login button
        binding.loginBtn.setOnClickListener(v -> {
            // goto login screen
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });


        // register button
        binding.registerBtn.setOnClickListener(v -> {
            String name = Objects.requireNonNull(binding.nameLayout.getEditText()).getText().toString().trim();
            String email = Objects.requireNonNull(binding.emailLayout.getEditText()).getText().toString().trim();
            String password = Objects.requireNonNull(binding.passwordLayout.getEditText()).getText().toString().trim();

            if (name.isEmpty())
                Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show();
            else if (name.length() < 3)
                Toast.makeText(this, "Name should be at least 3 characters long", Toast.LENGTH_SHORT).show();
            else if (email.isEmpty())
                Toast.makeText(this, "Please enter email id", Toast.LENGTH_SHORT).show();
            else if (!isEmailValid(email))
                Toast.makeText(this, "Please enter a valid email id", Toast.LENGTH_SHORT).show();
            else if (password.isEmpty())
                Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            else if (password.length() < 6)
                Toast.makeText(this, "Password should be at least 6 characters long", Toast.LENGTH_SHORT).show();
            else
                viewModel.getRegisterObservable(name, email, password);
        });


    }


    private Boolean isEmailValid(String email) {
        Regex emailRegex = new Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        return emailRegex.matches(email);
    }


}