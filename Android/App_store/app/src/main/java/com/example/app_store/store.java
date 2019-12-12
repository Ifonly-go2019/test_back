package com.example.app_store;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;


public class store extends AppCompatActivity {
    final int[] imageIds=new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3};
    private AdapterViewFlipper flipper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        flipper = (AdapterViewFlipper) findViewById(R.id.flipper);
        BaseAdapter adapter =new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(store.this);
                imageView.setImageResource(imageIds[position]);
                //设置ImageView的缩放类型
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                //为ImageView设置布局参数
                imageView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };

        flipper.setAdapter(adapter);
        flipper.startFlipping();
    }




}
