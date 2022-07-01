package com.example.tolett;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class PgActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    PgAdapter pgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pg);

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        pgAdapter=new PgAdapter(this,getMyList());
      mRecyclerView.setAdapter(pgAdapter);

    }

    private ArrayList<pg_listing>getMyList(){
        ArrayList<pg_listing> pg_listings=new ArrayList<>();

        pg_listing pg=new pg_listing();
        pg.setTitle("Kumar PG");
        pg.setDescription("Good conditioned one,neat and clean one");
        pg.setImage(R.drawable.pg_1);
        pg.setRating(4.5f);
        pg_listings.add(pg);

        pg=new pg_listing();
        pg.setTitle("Gk's PG");
        pg.setDescription("Good conditioned one,neat and clean one");
        pg.setImage(R.drawable.pg_2);
        pg.setRating(3.1f);
        pg_listings.add(pg);

       pg=new pg_listing();
        pg.setTitle("Arun PG");
        pg.setDescription("Good conditioned one,neat and clean one");
        pg.setImage(R.drawable.pg_3);
        pg.setRating(5f);
        pg_listings.add(pg);

        pg=new pg_listing();
        pg.setTitle("vel PG");
        pg.setDescription("Good conditioned one,neat and clean one");
        pg.setImage(R.drawable.pg_4);
        pg.setRating(4.1f);
        pg_listings.add(pg);

         pg=new pg_listing();
        pg.setTitle("elite PG");
        pg.setDescription("Good conditioned one,neat and clean one");
        pg.setImage(R.drawable.pg_5);
        pg.setRating(4.2f);
        pg_listings.add(pg);

         pg=new pg_listing();
        pg.setTitle("global PG");
        pg.setDescription("Good conditioned one,neat and clean one");
        pg.setImage(R.drawable.pg_6);
        pg.setRating(3.3f);
        pg_listings.add(pg);

         pg=new pg_listing();
        pg.setTitle("sugu PG");
        pg.setDescription("Good conditioned one,neat and clean one");
        pg.setImage(R.drawable.pg_8);
        pg.setRating(3.5f);
        pg_listings.add(pg);

        return pg_listings;
    }
}