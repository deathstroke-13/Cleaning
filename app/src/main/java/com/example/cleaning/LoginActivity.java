package com.example.cleaning;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView (R.id.btn_signup) Button btnSignup;
    @BindView (R.id.btn_login) Button btnLogin;
    @BindView (R.id.btn_forgetPassword) Button btnForgetPassword;
    @BindView (R.id.et_username_login) TextInputLayout etUsername;
    @BindView (R.id.et_password_login) TextInputLayout etPassword;
    @BindView (R.id.sideText) TextView sideText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login);
        Objects.requireNonNull (getSupportActionBar ()).hide ();
        ButterKnife.bind (this);

        btnSignup.setOnClickListener (view -> {
            Intent intent = new Intent (LoginActivity.this, SignUpActivity.class);
            Pair[] pairs = new Pair[3];
            pairs[0] = new Pair <View, String>(etUsername,"trans_username");
            pairs[1] = new Pair <View, String>(etPassword,"trans_password");
            pairs[2] = new Pair <View, String>(btnSignup,"trans_button");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation (LoginActivity.this,pairs);
            startActivity (intent,options.toBundle ());
        });

        btnLogin.setOnClickListener (view -> {
            Intent intentLogin = new Intent (LoginActivity.this, MainActivity.class);
            startActivity (intentLogin);
            finish ();
        });

        btnForgetPassword.setOnClickListener (view -> {
            Intent intentForgot = new Intent(LoginActivity.this, ForgotPasswordActivity.class);

            Pair[] pairs = new Pair[2];
            pairs[0] = new Pair <View, String>(etUsername,"trans_username");
            pairs[1] = new Pair <View, String>(sideText,"trans_slogan");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation (LoginActivity.this,pairs);
            startActivity (intentForgot,options.toBundle ());
        });
    }
}