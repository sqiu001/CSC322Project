package com.example.csc322project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.slide1,R.drawable.slide2,R.drawable.slide3};
    private String [] title = {"Top Project 1" , "Top Project 2", "Top Project 3"};

    public ViewPagerAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView project_title = view.findViewById(R.id.topproject_name);
        imageView.setImageResource(images[position]);
        project_title.setText(title[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}
