package com.example.adapter;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Animal> datas = new ArrayList<>();
    private AnimalAdapter animalAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initialData();
        listView = findViewById(R.id.LV);
        animalAdapter = new AnimalAdapter(this, datas);
        listView.setAdapter(animalAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, datas.get(position).getAnimal(), Toast.LENGTH_SHORT).show();
                Animal animal = (Animal) animalAdapter.getItem(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.mipmap.ic_launcher_round);
                builder.setTitle("标题栏");
                Log.i("key",animal.getAnimal());
                builder.setMessage(animal.getAnimal()+"的详细信息");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "点击了确定", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消",null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }

    private void initialData() {
        for (int i = 0; i < 5; i++) {
            datas.add(new Animal("适配器" + i+"号", R.drawable.ic_launcher_background));
        }
    }


}



