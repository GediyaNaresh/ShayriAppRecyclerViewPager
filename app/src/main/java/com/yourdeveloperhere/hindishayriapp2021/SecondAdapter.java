package com.yourdeveloperhere.hindishayriapp2021;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondAdapter extends BaseAdapter {

    ThirdActivity third_page;
    String[] str;
    int[] imageArray;
    Animation animation;

    public SecondAdapter(ThirdActivity third_page, String[] str) {
        this.third_page=third_page;
        this.str=str;

    }
    public SecondAdapter(ThirdActivity third_page, int[] str) {
        this.third_page=third_page;
        this.imageArray=str;

    }

    @Override
    public int getCount() {
        return str.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        view= LayoutInflater.from(third_page).inflate(R.layout.shayri_view,viewGroup,false);
        animation=AnimationUtils.loadAnimation(third_page,R.anim.animation1);
        TextView textView;
        ImageView imageView;
        textView=view.findViewById(R.id.last_view);
//        imageView = view.findViewById(R.id.image1);

       // imageView.setImageResource(imageArray[i]);

        textView.setText(str[i]);
        textView.setAnimation(animation);

        return view;
    }
}
