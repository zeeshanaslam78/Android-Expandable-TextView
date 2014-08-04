/**
 * 
 */
package com.xeeshi78.expandabletextview.view;

import java.lang.ref.WeakReference;

import com.xeeshi78.expandabletextview.R;


import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * @author Zeeshan Aslam
 * July 29, 2014
 */
public class ExpandableTextView extends TextView {

	private int maxLines = 1;
    private CharSequence originalText;
    private BufferType bufferType;
    private boolean trim = true;
    private Context _context;
    
    private WeakReference<ImageView> imgReference=null;
    
    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this._context= context;
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                trim = !trim;
                setText();
                requestFocusFromTouch();
            }
        });
    }
    
    public ExpandableTextView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		this._context= context;
	}

    private void setText() {
    	super.setText(getDisplayableText(), bufferType);
    }
    
    @Override
    public void setText(CharSequence text, BufferType type) {
        originalText = text;
        bufferType = type;
        setText();
    }

    private CharSequence getDisplayableText() {
    	if(trim)
    	{
    		if(null!=imgReference)
        	{
        		ImageView im = imgReference.get();
        		im.setImageDrawable(_context.getResources().getDrawable(R.drawable.down));
        	}
    		
    		setEllipsize(TruncateAt.END);
    		setMaxLines(getMaximumLines());
    	}
    	else
    	{
    		if(null!=imgReference)
        	{
        		ImageView im = imgReference.get();
        		im.setImageDrawable(_context.getResources().getDrawable(R.drawable.up));
        	}
    		
    		setEllipsize(null);
    		setMaxLines(Integer.MAX_VALUE);
    	}   
    	return originalText;
    }
    
    public CharSequence getOriginalText() {
        return originalText;
    }
    
    public void setMaximumLines(int maxLines) {
    	this.maxLines = maxLines;
    	setMaxLines(maxLines);
    }
    
    public int getMaximumLines() {
        return maxLines;
    }

	public WeakReference<ImageView> getImgReference() {
		return imgReference;
	}
    
	public void setImgReference(ImageView img)
	{
		if(null!=img)
        	this.imgReference = new WeakReference<ImageView>(img);
        else
        	this.imgReference = null;
	}
    
}
