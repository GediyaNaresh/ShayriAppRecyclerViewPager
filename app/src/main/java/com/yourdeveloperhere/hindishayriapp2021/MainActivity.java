package com.yourdeveloperhere.hindishayriapp2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


import static android.content.ContentValues.TAG;


public class MainActivity extends AppCompatActivity {

    Button start, exit, rate;
    AlertDialog.Builder builder;
    Animation ani;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ani = AnimationUtils.loadAnimation(this, R.anim.animation3);



        start = findViewById(R.id.start);
        rate = findViewById(R.id.rate);
        exit = findViewById(R.id.exits);
        builder = new AlertDialog.Builder(this);





        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent start = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(start);

            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert();
            }
        });


    }

    void alert() {

        builder.setCancelable(false);
        builder.setTitle("Exit");
        builder.setMessage("Are You Really want to exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                builder.setCancelable(true);
            }
        });

        builder.show();
    }

    @Override
    public void onBackPressed() {
        alert();
    }

}
