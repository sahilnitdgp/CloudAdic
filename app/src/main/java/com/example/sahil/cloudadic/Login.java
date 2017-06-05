package com.example.sahil.cloudadic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class Login extends AppCompatActivity {

    LoginButton loginButton;
    CallbackManager callbackManager;
    TextView txtstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        initializeControls();

        loginWithFB();

    }

    private  void initializeControls()
    {
        txtstatus= (TextView)findViewById(R.id.status);
        loginButton = (LoginButton)findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();
    }

    private void loginWithFB()
    {
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Intent intent= new Intent(Login.this,MainActivity.class);
                startActivity(intent);

            }

            @Override
            public void onCancel() {
                txtstatus.setText("Login Canceled");

            }

            @Override
            public void onError(FacebookException error) {
               txtstatus.setText("Login Error !!"+error.getMessage());
            }
        });
    }


    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
