package com.cpimca.Mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class UserActivity extends AppCompatActivity {

    EditText loginEmail, loginPassword;
    TextView forgetpswd, signup;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        loginEmail = findViewById(R.id.etemail);
        loginPassword = findViewById(R.id.etpassword);
        loginButton = findViewById(R.id.btnlogin);
        forgetpswd = findViewById(R.id.forgot_password);
        signup = findViewById(R.id.txtsignup);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatePassword()) {

                } else {
                    checkUser();
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, UserRegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public Boolean validateUsername() {
        String val = loginEmail.getText().toString();
        if (val.isEmpty()) {
            loginEmail.setError("Email cannot be empty");
            return false;
        } else {
            loginEmail.setError(null);
            return true;
        }
    }

    public Boolean validatePassword() {
        String val = loginPassword.getText().toString();
        if (val.isEmpty()) {
            loginPassword.setError("Password cannot be empty");
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }
    }

    public void checkUser() {
        String userloginemail = loginEmail.getText().toString().trim();
        String userloginpassword = loginPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("Email").equalTo(userloginemail);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {
                    loginEmail.setError(null);
                    String passwordFromDB = snapshot.child(userloginemail).child("password").getValue(String.class);

                    if (!Objects.equals(passwordFromDB, userloginpassword)) {
                        loginEmail.setError(null);
                        Intent intent = new Intent(UserActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else if () {
                        loginPassword.setError("Invalid Credentials");
                        loginPassword.requestFocus();
                    }else {
                        loginEmail.setError("User does not exits");
                    }
                }
            });
        }
    }