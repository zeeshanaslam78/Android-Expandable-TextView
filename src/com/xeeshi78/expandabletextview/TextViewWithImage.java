package com.xeeshi78.expandabletextview;

import com.xeeshi78.expandabletextview.view.ExpandableTextView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class TextViewWithImage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.expandable_text_view_with_image_change);
		
		String txt = getResources().getString(R.string.big_text);
		
		ImageView img = (ImageView) findViewById(R.id.img);
		
		ExpandableTextView txtView = (ExpandableTextView) findViewById(R.id.txt_view);
		txtView.setMaximumLines(3);
		
		txtView.setImgReference(img);
		txtView.setText(txt);
		
	}
}
