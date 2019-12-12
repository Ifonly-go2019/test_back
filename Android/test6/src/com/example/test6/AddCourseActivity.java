package com.example.test6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AddCourseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_course);
	}

	public void onSubmit(View v){
		Intent it = new Intent();
		EditText et1 = (EditText)findViewById(R.id.et_keyword);
		EditText et2 = (EditText)findViewById(R.id.editText2);
		EditText et3 = (EditText)findViewById(R.id.editText3);
		EditText et4 = (EditText)findViewById(R.id.editText4);
		it.putExtra("course_name", et1.getText().toString());
		it.putExtra("course_no", et2.getText().toString());
		it.putExtra("course_credit", et3.getText().toString());
		it.putExtra("course_remark", et4.getText().toString());
		setResult(1,it);
		
		finish();
	}
	public void onCancel(View v){
		setResult(2,null);
		
		finish();
	}
}
