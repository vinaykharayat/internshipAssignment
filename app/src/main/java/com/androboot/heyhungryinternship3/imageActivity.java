package com.androboot.heyhungryinternship3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class imageActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private imageAdaptor mAdaptor;

    private DatabaseReference mDataref;
    private List<upload> mUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUpload= new ArrayList<>();
        mDataref = FirebaseDatabase.getInstance().getReference("uploads");
        //To get data from Firebase
        mDataref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapShot: dataSnapshot.getChildren()){
                    upload upload = postSnapShot.getValue(upload.class);
                    mUpload.add(upload);
                }
                mAdaptor=new imageAdaptor(imageActivity.this,mUpload);
                mRecyclerView.setAdapter(mAdaptor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(imageActivity.this, databaseError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
