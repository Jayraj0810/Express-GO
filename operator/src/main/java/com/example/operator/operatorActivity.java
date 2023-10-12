package com.example.operator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class operatorActivity extends AppCompatActivity {
    Button createjobcard,viewjobcard;
    TextView demo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator);

        createjobcard = findViewById(R.id.card);
        viewjobcard = findViewById(R.id.viewjobcard);
        createjobcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(operatorActivity.this, job_card.class);
                startActivity(intent);
            }
        });
        viewjobcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(operatorActivity.this, jobcardlist.class);
                startActivity(intent);
            }
        });

    }
}