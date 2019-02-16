package com.example.mypc.Shee;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by my pc on 18-Mar-18.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images={R.drawable.slide1,R.drawable.slide2,R.drawable.slide3,R.drawable.slide4,R.drawable.slide5,R.drawable.slide6,R.drawable.slide7,R.drawable.slide8,R.drawable.slide9,R.drawable.slide10};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.custom_layout,null);
        ImageView imageView=(ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);

        ViewPager vp=(ViewPager) container;
        vp.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp=(ViewPager) container;
        View view= (View) object;
        vp.removeView(view);
    }
}

