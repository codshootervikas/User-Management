package com.example.usermanagement.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.usermanagement.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText email,password;
    Button login;
    TextView registerlink;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.etemail);
        password=findViewById(R.id.etpassword);
        login=findViewById(R.id.loginBtn);
        registerlink=findViewById(R.id.registerlink);

        registerlink.setOnClickListener(this);
        login.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.loginBtn) {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        } else if (id == R.id.registerlink) {
            switchOnRegister();
        }
    }

    private void switchOnRegister() {

        Intent i=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(i);
    }
}