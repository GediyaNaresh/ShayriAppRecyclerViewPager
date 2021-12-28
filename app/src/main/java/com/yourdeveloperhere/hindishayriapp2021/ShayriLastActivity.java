package com.yourdeveloperhere.hindishayriapp2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ShayriLastActivity extends AppCompatActivity {

    int pos;
    String[] shayri;
    int[] imageArray;
    TextView textView;
    ImageView imageView;
    Button next, previous, share, copy;
    AlertDialog.Builder builder;
    Animation animation;
    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_last_view_);
        animation = AnimationUtils.loadAnimation(this, R.anim.animation2);
        textView = findViewById(R.id.shayri_last_view);
        builder = new AlertDialog.Builder(this);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        share = findViewById(R.id.share);
        copy = findViewById(R.id.copy);
        imageView = findViewById(R.id.imagview);
        viewPager2 = findViewById(R.id.viewpager1);


        pos = getIntent().getIntExtra("position", 0);
        shayri = getIntent().getStringArrayExtra("shayri");
        // imageArray = getIntent().getIntArrayExtra("images");

//        textView.setText("" + shayri[pos]);
//        textView.setAnimation(animation);
        //  imageView.setImageResource(imageArray[pos]);

        //ViewPager...
        viewPagerAdapter = new ViewPagerAdapter(shayri);


        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);

        //    viewPager2.getChildAt(pos).setOverScrollMode(View.OVER_SCROLL_ALWAYS);

        viewPager2.setAdapter(viewPagerAdapter);

        viewPager2.setCurrentItem(pos,true);




        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(2));

        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float v = 1 - Math.abs(position);
                page.setScaleY(0.8f + v * 0.2f);

            }
        });

        viewPager2.setPageTransformer(transformer);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = viewPager2.getCurrentItem();
                pos--;
                try {
//                    textView.setAnimation(animation);
//       textView.setText("" + shayri[pos]);
//                    imageView.setImageResource(imageArray[pos]);
                    viewPager2.setCurrentItem(pos, true);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = viewPager2.getCurrentItem();
                pos++;
                try {
//                    textView.setAnimation(animation);
//                    textView.setText("" + shayri[pos]);
                    // imageView.setImageResource(imageArray[pos]);

                    viewPager2.setCurrentItem(pos, true);

                } catch (Exception e) {
                }
            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss = textView.getText().toString();
                ClipboardManager clipbord = (ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("test", ss);
                clipbord.setPrimaryClip(clip);
                showtoast();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss = textView.getText().toString();
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage = "\n" + ss + "\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n" + "download this ";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch (Exception e) {

                }

            }
        });


    }

    void showtoast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast));
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

}
