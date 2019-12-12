package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AnimalAdapter extends BaseAdapter {
    private Context context;
    private List<Animal> datas;

    public AnimalAdapter(Context context,List<Animal> datas)
    {
        this.context = context;
        this.datas = datas;
    }


    // 子项个数
    @Override
    public int getCount() {
        return datas.size();
    }
    // 返回子项对象
    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    // 返回子项下标
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 创建 ViewHolder 类
    class ViewHolder {
        ImageView animalImage;
        TextView animalName;
    }
    // 返回子项视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Animal animal = (Animal) getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.item_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.animalImage = view.findViewById(R.id.img);
            viewHolder.animalName = view.findViewById(R.id.tv);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.animalName.setText(animal.getAnimal());
        viewHolder.animalImage.setImageResource(animal.getImgId());
        return view;
    }
}


