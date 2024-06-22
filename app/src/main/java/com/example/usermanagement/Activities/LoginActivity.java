package com.example.usermanagement.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.Toast;

import com.example.usermanagement.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    String registerHereText = "<span> Not register | <font color='#0342FF'><b>Create your Account</b></font> </span>";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.registerHereBtn.setText(Html.fromHtml(registerHereText));


        // login button
        binding.loginBtn.setOnClickListener(v -> {
            if (binding.emailLayout.getEditText().getText().toString().isEmpty())
                Toast.makeText(this, "please enter email id", Toast.LENGTH_SHORT).show();
            else if (binding.passwordLayout.getEditText().getText().toString().isEmpty())
                Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            else
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
        });

        binding.registerHereBtn.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        });


    }


}