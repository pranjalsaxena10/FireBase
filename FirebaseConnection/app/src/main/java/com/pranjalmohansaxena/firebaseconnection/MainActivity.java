package com.pranjalmohansaxena.firebaseconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Data");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Wrapper,CardViewHolder> firebaseRecyclerAdapter
                =new FirebaseRecyclerAdapter<Wrapper,CardViewHolder>(
                        Wrapper.class,
                        R.layout.tuple,
                        CardViewHolder.class,
                        databaseReference
        )
        {
            @Override
            protected void populateViewHolder(CardViewHolder viewHolder, Wrapper model, int position) {
                viewHolder.settingInformation(getApplicationContext(),model.getDesc(),model.getTitle(),model.getValue());
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
