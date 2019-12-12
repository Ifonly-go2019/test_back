package com.example.app_store;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt;
    String name;
    String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bt=(Button) findViewById(R.id.bt_login);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit_name=(EditText)findViewById(R.id.edit_name);
                EditText edit_pwd=(EditText)findViewById(R.id.edit_pwd);
                Log.i("name&pwd",edit_name.getText().toString()+" "+edit_pwd.getText().toString());
                boolean ck= check(edit_name,edit_pwd);
                if(ck ==true){
                    Intent intent=new Intent(MainActivity.this,store.class);
                   startActivity(intent);
                }else { }
            }
        });


    }


public  boolean check(EditText name, EditText pwd){
        String test_name="jager";
        String test_pwd="123";
        if(test_name.equals(name.getText().toString())&&test_pwd.equals(pwd.getText().toString())){
            Toast toast= Toast.makeText(this,name.getText().toString()+"登录成功",Toast.LENGTH_LONG);
            toast.show();
            return true;
        }else {
            Toast toast= Toast.makeText(this,name.getText().toString()+"登录失败",Toast.LENGTH_LONG);
            toast.show();
            return  false;
        }
}

}
