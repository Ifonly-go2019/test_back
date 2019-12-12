package com.example.logindemo;

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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button bt;
    RadioGroup  radioGroup;
    RadioButton rb;
    RadioButton radioMan;
    RadioButton radioWonan;
    String sex="";
    CheckBox checkBox1, checkBox2, checkBox3;

    List<CheckBox> checkBoxList = new ArrayList<CheckBox>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bt=this.findViewById(R.id.button);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });





        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name="";
                String pwd="";
                String msg="";
                String sex="";
                int count=0;
                checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
                checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
                checkBox3 = (CheckBox) findViewById(R.id.checkBox3);



                EditText editText1 =(EditText)findViewById(R.id.editTextname);
                EditText editText2 =(EditText)findViewById(R.id.editTextpwd);
                RadioGroup ra=(RadioGroup)findViewById(R.id.radioGroup3);
                count =ra.getChildCount();
//                String count1=Integer.toString(count);
//                Log.i("count",count1);
                for(int i=0;i<count;i++){
                    RadioButton rb = (RadioButton)ra.getChildAt(i);
                    if(rb.isChecked()){
                        sex=rb.getText().toString();
                        break;
                    }
                    else {
                        sex="空";
                    }
                }

                checkBoxList.add(checkBox1);
                checkBoxList.add(checkBox2);
                checkBoxList.add(checkBox3);
                StringBuffer sb = new StringBuffer();
                //遍历集合中的checkBox,判断是否选择，获取选中的文本
                for (CheckBox checkbox : checkBoxList) {
                    if (checkbox.isChecked()){
                        sb.append(checkbox.getText().toString() + " ");
                    }
                }
                if (sb!=null && "".equals(sb.toString())){
                    Toast.makeText(getApplicationContext(), "请至少选择一个", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_SHORT).show();
                }

                int length=sb.length();
                pwd=editText2.getText().toString();
                name = editText1.getText().toString();
                msg="用户名:"+name+" 密码："+pwd+" 性别："+sex+" 兴趣爱好:"+sb;
                sb.setLength(0);
                checkBoxList.clear();
                Log.i("key",msg);



            }
        });





    }











}
