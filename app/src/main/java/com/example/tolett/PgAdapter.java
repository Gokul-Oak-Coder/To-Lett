package com.example.tolett;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class PgAdapter extends RecyclerView.Adapter<pg_holder> {

    Context c;
    ArrayList<pg_listing>pg_listings;

    public PgAdapter(Context c, ArrayList<pg_listing> pg_listings) {
        this.c = c;
        this.pg_listings = pg_listings;
    }

    @NonNull
    @Override
    public pg_holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pg_lists,null);
        return new pg_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull pg_holder holder, int i) {

        holder.mTitle.setText(pg_listings.get(i).getTitle());
        holder.mDes.setText(pg_listings.get(i).getDescription());
        holder.mImageView.setImageResource(pg_listings.get(i).getImage());
        holder.mRating.setRating(pg_listings.get(i).getRating());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnItemCLickListener(View v, int position) {
                String gTitle = pg_listings.get(position).getTitle();
                String gDes = pg_listings.get(position).getDescription();
                float gRating=pg_listings.get(position).getRating();
                BitmapDrawable bitmapDrawable= (BitmapDrawable)holder.mImageView.getDrawable();

                Bitmap bitmap= bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream=new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);

                byte[] bytes = stream.toByteArray();
                Intent intent = new Intent(c,BookActivity.class);
                intent.putExtra("iTitle",gTitle);
                intent.putExtra("iDes",gDes);
                intent.putExtra("iRating",gRating);
                intent.putExtra("iImage",bytes);
                c.startActivity(intent);

            }
        });

      /*  holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnItemCLickListener(View v, int position) {
                if(pg_listings.get(position).getTitle().equals(" Kumar PG")){
                }
                if(pg_listings.get(position).getTitle().equals(" Gk's PG")){
                }
                if(pg_listings.get(position).getTitle().equals(" Arun PG")){
                }
                if(pg_listings.get(position).getTitle().equals(" vel PG")){
                }
                if(pg_listings.get(position).getTitle().equals(" elite PG")){
                }
                if(pg_listings.get(position).getTitle().equals(" global PG")){
                }
                if(pg_listings.get(position).getTitle().equals(" sugu PG")){
                }
            }
        });
        */

    }
    @Override
    public int getItemCount() {
        return pg_listings.size();
    }
}
