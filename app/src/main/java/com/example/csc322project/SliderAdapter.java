package com.example.csc322project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.w3c.dom.Text;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context=context;
    }

    public int[] slide_images={
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.slide1,
        R.drawable.slide2,
        R.drawable.slide3
    };

    public String[] slide_headings={
            "Project 1",
            "Project 2",
            "Project 3",
            "Project 4",
            "Project 5",
            "Project 6",
            "Project 7"
    };

    public String[] slide_descs={
            "Lorem ipsum dolor sit amet, no nam ubique everti cotidieque, in ullamcorper disputationi mel",
            "Lorem ipsum dolor sit amet, no nam ubique everti cotidieque, in ullamcorper disputationi mel",
            "Lorem ipsum dolor sit amet, no nam ubique everti cotidieque, in ullamcorper disputationi mel",
            "Lorem ipsum dolor sit amet, no nam ubique everti cotidieque, in ullamcorper disputationi mel",
            "Lorem ipsum dolor sit amet, no nam ubique everti cotidieque, in ullamcorper disputationi mel",
            "Lorem ipsum dolor sit amet, no nam ubique everti cotidieque, in ullamcorper disputationi mel",
            "Lorem ipsum dolor sit amet, no nam ubique everti cotidieque, in ullamcorper disputationi mel"
    };
    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.projects_layout, null);
        ImageView slideImageView = (ImageView) view.findViewById(R.id.project_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.project_name);
        TextView slideDescription = (TextView) view.findViewById(R.id.project_body);
        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((RelativeLayout)object);
    }
}
