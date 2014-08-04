package com.xeeshi78.expandabletextview;

import com.xeeshi78.expandabletextview.view.ExpandableTextView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expandable_text_view);
		
		String txt = getResources().getString(R.string.big_text);
		
		ExpandableTextView txtView = (ExpandableTextView) findViewById(R.id.txt_view);
		txtView.setMaximumLines(2);
		txtView.setText(txt);
		
		TextView txt_with_img = (TextView) findViewById(R.id.txt_with_img);
		txt_with_img.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, TextViewWithImage.class);
				startActivity(i);
			}
		});
		
	}
}
