package com.example.recyclerviewwithonclicklistner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    int[] flag = {
            R.drawable.afgan_flag,R.drawable.bangladesh_flag,R.drawable.bhuta_flag,R.drawable.chinaflag_here,
            R.drawable.germany_flag,R.drawable.india_flag,R.drawable.meyanmar_flag,R.drawable.nepal_flag,R.drawable.pakflag_flag,
            R.drawable.russia_flag,R.drawable.afgan_flag,R.drawable.bangladesh_flag,R.drawable.bhuta_flag,R.drawable.chinaflag_here,
            R.drawable.germany_flag,R.drawable.india_flag,R.drawable.meyanmar_flag,R.drawable.nepal_flag,R.drawable.pakflag_flag,
            R.drawable.russia_flag,R.drawable.afgan_flag,R.drawable.bangladesh_flag,R.drawable.bhuta_flag,R.drawable.chinaflag_here,
            R.drawable.germany_flag,R.drawable.india_flag,R.drawable.meyanmar_flag,R.drawable.nepal_flag,R.drawable.pakflag_flag,
            R.drawable.russia_flag,R.drawable.afgan_flag,R.drawable.bangladesh_flag,R.drawable.bhuta_flag,R.drawable.chinaflag_here,
            R.drawable.germany_flag,R.drawable.india_flag,R.drawable.meyanmar_flag,R.drawable.nepal_flag,R.drawable.pakflag_flag,
            R.drawable.russia_flag
    };
    String [] country_name;
    String [] description;
    MyAdapterForRecycleView myAdapterForRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycle_view_id);

        country_name = getResources().getStringArray(R.array.country_name);
        description = getResources().getStringArray(R.array.country_description);

        myAdapterForRecycleView = new MyAdapterForRecycleView(this,country_name,description,flag);
        recyclerView.setAdapter(myAdapterForRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapterForRecycleView.setOnItemClickListner(new MyAdapterForRecycleView.ClickListner() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(getApplicationContext(),"OnItemClick "+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int position, View view) {
                Toast.makeText(getApplicationContext(),"OnLongClick "+position,Toast.LENGTH_SHORT).show();
            }
        });


    }
}