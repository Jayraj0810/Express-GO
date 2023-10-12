package com.example.operator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class show_jobcard extends AppCompatActivity {
    //  TextView jobno,dob, cname, mobileno, carregino, year, mileage, carmake, carmodel, engineno, requirement;
    //  DatabaseReference ref;
    HelperAdapter helperAdapter;
    RecyclerView recyclerViewSecond;
    private Object dataSnapshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_jobcard);

        recyclerViewSecond = findViewById(R.id.recycleViewSecond);


//        ref = FirebaseDatabase.getInstance().getReference().child("JobCards");
//
//        String key = getIntent().getStringExtra("key");
//
//        ref.child(key).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Object object  = dataSnapshot.child("ID").getValue();
//                String name = dataSnapshot.child("Name").getValue().toString();
//
//                jobno.setText(""+object);
//                cname.setText(name);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

//        jobno = findViewById(R.id.sjobno);
//        dob = findViewById(R.id.sdob);
//        cname = findViewById(R.id.scname);
//        mobileno = findViewById(R.id.smobileno);
//        carregino = findViewById(R.id.scarregino);
//        year = findViewById(R.id.syear);
//        mileage = findViewById(R.id.smileage);
//        carmake = findViewById(R.id.scarmake);
//        carmodel = findViewById(R.id.scarmodel);
//        engineno = findViewById(R.id.sengineno);
//        requirement = findViewById(R.id.srequirement);


    }
}