package com.yourdeveloperhere.hindishayriapp2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;



import static android.content.ContentValues.TAG;


public class SecondActivity extends AppCompatActivity {

    ListView listView;
    String[] title;
    Animation ani;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);


        listView = findViewById(R.id.listview);
        title = getResources().getStringArray(R.array.title);
        Mainadapter adapter = new Mainadapter(SecondActivity.this, title);

        ani = AnimationUtils.loadAnimation(this, R.anim.animation1);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent secondIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                secondIntent.putExtra("title", title[i]);
                startActivity(secondIntent);

            }
        });

    }


}
