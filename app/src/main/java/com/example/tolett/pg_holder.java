package com.example.tolett;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;

public class pg_holder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView mImageView;
    TextView mTitle,mDes;
    RatingBar mRating;
    ItemClickListener itemClickListener;

     pg_holder(@NonNull View itemView) {
        super(itemView);

        this.mImageView=itemView.findViewById(R.id.pg_image);
        this.mTitle=itemView.findViewById(R.id.pg_title);
        this.mDes=itemView.findViewById(R.id.pg_description);
        this.mRating=itemView.findViewById(R.id.pg_rating);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

         this.itemClickListener.OnItemCLickListener(v,getLayoutPosition());
    }
    public void setItemClickListener(ItemClickListener ic) {

         this.itemClickListener = ic;
    }
}
