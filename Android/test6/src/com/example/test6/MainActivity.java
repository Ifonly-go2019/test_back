package com.example.test6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {

	SQLiteDatabase db;
	ListView lv;
	CourseListAdapter adapter;
	EditText et_keyword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String dbPath = getFilesDir().getPath() + "/StudentSystem.db";
        db = SQLiteDatabase.openOrCreateDatabase(dbPath, null);
        String sqlCommand = "Create table if not exists Course(_id Integer,course_no varchar,course_name Integer,credit Integer,remark varchar)";
        db.execSQL(sqlCommand);
        lv = (ListView)findViewById(R.id.listView1);
        et_keyword = (EditText)findViewById(R.id.et_keyword);
        adapter = new CourseListAdapter(this);
        lv.setAdapter(adapter);
       
    }
    public void onAdd(View v){
    	Intent it = new Intent(this,AddCourseActivity.class);
    	startActivityForResult(it, 0);
    }
    public void onQuery(View v){
    	adapter.clear();
    	String keyWord =et_keyword.getText().toString(); 
    	String selection =  "course_name=?"; 
    	String[] selectionArg = new String[] {keyWord};
    	
    	if(keyWord .isEmpty())
    	{
    		
    		selection = null;
    		selectionArg = null;
    		
    	}
    	Cursor cursor = db.query(true,"Course",new String[]{"*"},selection,selectionArg,null,null,null,null,null);
    	
    	if(cursor != null && cursor.moveToFirst())
    	{
    		do{
    			CourseListAdapter.Course course = new CourseListAdapter.Course();
    			course.course_name = cursor.getString(1);
    			course.course_no = cursor.getString(2);
    			course.course_credit = cursor.getInt(3);
    			course.course_remark = cursor.getString(4);
    			adapter.addCourse(course);
    			
    			
    		}while(cursor.moveToNext());
    			
    	}
    	cursor.close();
    	adapter.notifyDataSetChanged();
    	
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
    	if(resultCode == 1){
    		ContentValues values = new ContentValues();
    		
    		
    		values.put("course_name",data.getStringExtra("course_name"));
      		values.put("course_no",data.getStringExtra("course_no"));
    		values.put("credit", data.getStringExtra("course_credit"));
    		values.put("remark",data.getStringExtra("course_remark"));
    		db.insert("Course",null,values);
    		
    		Toast.makeText(this, "Ìí¼Ó³É¹¦!", Toast.LENGTH_SHORT).show();
    	}else if(resultCode == 2)
    	{
    		
    	}
    }
}
