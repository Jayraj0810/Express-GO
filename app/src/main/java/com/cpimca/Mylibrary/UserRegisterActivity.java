package com.cpimca.Mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserRegisterActivity extends AppCompatActivity {

    EditText etsignupEmail, etsignupPassword,etfirstname,etlastname,etmobile;
    Button registr;
    FirebaseDatabase database;
    TextView login;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        etsignupEmail = findViewById(R.id.edtemail);
        etsignupPassword = findViewById(R.id.edtpass);
        etfirstname = findViewById(R.id.edFirstname);
        etlastname = findViewById(R.id.edLastname);
        etmobile =  findViewById(R.id.edMobile);
        registr = findViewById(R.id.btnSubmit);
        login = findViewById(R.id.rtlogin);

        registr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String firstname = etfirstname.getText().toString();
                String lastname = etlastname.getText().toString();
                String mobile = etmobile.getText().toString();
                String email = etsignupEmail.getText().toString();
                String password = etsignupPassword.getText().toString();

                UserModel userModel = new UserModel(firstname,lastname,mobile,email,password);
                reference.child(firstname).setValue(userModel);

                Toast.makeText(UserRegisterActivity.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserRegisterActivity.this,UserActivity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserRegisterActivity.this, UserActivity.class));
            }
        });
    }
}