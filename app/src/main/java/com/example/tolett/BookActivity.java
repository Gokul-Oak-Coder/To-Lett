package com.example.tolett;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class BookActivity extends AppCompatActivity {

    TextView mTitle,mDesc;
    ImageView mImage;
    RatingBar mRate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        ActionBar actionBar = getSupportActionBar();

        mTitle =findViewById(R.id.title);
        mDesc=findViewById(R.id.description);
        mImage=findViewById(R.id.imageView);


        Intent intent= getIntent();

        String mTitle1=intent.getStringExtra("iTitle");
        String mDescription=intent.getStringExtra("iDes");

        byte[] mBytes=getIntent().getByteArrayExtra("iImage");
        Bitmap bitmap= BitmapFactory.decodeByteArray(mBytes,0,mBytes.length);

        actionBar.setTitle(mTitle1);

        mTitle.setText(mTitle1);
        mDesc.setText(mDescription);
      //  mRate.setRating(mRating);
        mImage.setImageBitmap(bitmap);


    }
}