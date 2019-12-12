package com.example.test6;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CourseListAdapter extends BaseAdapter {

	static public class Course{
		String course_name;
		String course_no;
		int course_credit;
		String course_remark;
		
	}
	ArrayList<Course> courselist = new ArrayList<Course>();
	Context context;
	
	public CourseListAdapter(Context _context) {
		context = _context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return courselist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if(convertView == null)
		{
			convertView = LayoutInflater.from(context).inflate(R.layout.list_item_layout, null);
		}
		TextView tv1 = (TextView)convertView.findViewById(R.id.textView1);
		TextView tv2 = (TextView)convertView.findViewById(R.id.textView2);
		TextView tv3 = (TextView)convertView.findViewById(R.id.textView3);
		TextView tv4 = (TextView)convertView.findViewById(R.id.textView4);
		Course course = courselist.get(position);
		tv1.setText(course.course_name);
		tv2.setText(course.course_no);
		tv3.setText(""+course.course_credit);
		tv4.setText(course.course_remark);
		
		return convertView;
	}

	public void addCourse(Course cr)
	{
		courselist.add(cr);
	}
	public void clear()
	{
		courselist.clear();
	}
}
