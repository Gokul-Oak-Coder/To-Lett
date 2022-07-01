package com.example.tolett;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

public class RentalActivity extends AppCompatActivity {
    //for google sign In
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView signOut,person;
    ImageButton pg,house,rental;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental);

        signOut = findViewById(R.id.sign_out);
        person = findViewById(R.id.person1);

        pg=findViewById(R.id.pg);
        house=findViewById(R.id.house);
        rental=findViewById(R.id.rental);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
// Build a GoogleSignInClient with the options specified by gso.
        gsc = GoogleSignIn.getClient(this, gso);


        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            Uri personPhoto = acct.getPhotoUrl();

            Picasso.get().load(acct.getPhotoUrl()).placeholder(R.drawable.person1).into(person);

        }
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

        pg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RentalActivity.this,PgActivity.class);
                startActivity(intent);
            }
        });
        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RentalActivity.this,HouseActivity.class);
                startActivity(intent);
            }
        });
        rental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RentalActivity.this,RentalRoomActivity.class);
                startActivity(intent);
            }
        });
    }
    void signOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete( Task<Void> task) {
                finish();
                startActivity(new Intent(RentalActivity.this,LoginActivity.class));
            }
        });
    }

    }


