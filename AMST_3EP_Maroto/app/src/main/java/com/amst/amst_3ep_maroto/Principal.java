package com.amst.amst_3ep_maroto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Principal extends AppCompatActivity {
    Button btn_id;
    DatabaseReference db_reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Intent intent = getIntent();
        iniciarBaseDeDatos();
//        leerTweets();

    }

    public void cerrarSesion(View view){
        FirebaseAuth.getInstance().signOut();
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("msg", "cerrarSesion");
        startActivity(intent);
    }

    public void iniciarBaseDeDatos(){
        ArrayList<String> paises = new ArrayList<String>();
        ArrayList<String> totalCasos = new ArrayList<String>();


//        db_reference = FirebaseDatabase.getInstance().getReference().child("0");
        db_reference = FirebaseDatabase.getInstance().getReference().child("0");
        for(int i=0; i<=98;i++) {
            db_reference.child("Country").child("Region").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        System.out.println(snapshot.getValue());
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    System.out.println(error.toException());
                }
            });
        }


        System.out.println(paises);
        System.out.println(totalCasos);
    }







}