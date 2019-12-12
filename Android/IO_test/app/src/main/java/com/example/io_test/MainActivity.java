package com.example.io_test;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        try {
            FileOutputStream fos= openFileOutput("abc.txt",MODE_PRIVATE);
            fos.write(new String("android TEST \0").getBytes());


            FileInputStream fis =openFileInput("abc.txt");
            byte[] buf = new byte[1024];
            fis.read(buf);
            String txt =new String(buf);
            Log.i("info",txt);

        } catch (FileNotFoundException e) {
            Log.i("error","I/O操作失败");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        //sql
        String path =getFilesDir().getPath();
        path+="user.db";
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase (path,null);
        db.execSQL("create table User_info(id inteager,name varchar(64),grade inteager)");
        db.execSQL("insert into User_info  values(1,'info_1',100)");
        db.execSQL("insert into User_info  values(1,'info_2',200)");
        Cursor sr= db.query("User_info",null,null,null,null,null,"grade");

        if(sr.moveToFirst()){
            do {
                String name = sr.getString(1);
                int grade = sr.getInt(2);

            }while(sr.moveToNext());
        }




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


}
