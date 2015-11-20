package com.example.mplayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class VisualizerView extends View {

	 private byte[] mBytes;
	 private float[] mPoints;
	 private Rect mRect = new Rect();
	 private Paint mForePaint = new Paint();
	
	// GestureDetector gestureDetector;
	 private  Context context;
	public VisualizerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		// gestureDetector = new GestureDetector(context, new GestureListener());
	      this.context=context;
		 init();
	}
	 public VisualizerView(Context context) {
		  super(context);
	      init();
		 }

	 public VisualizerView(Context context, AttributeSet attrs, int defStyleAttr) {
		  super(context, attrs, defStyleAttr);
		  init();
		 }
      private void init(){
    	  
    	  mBytes = null;
    	  mForePaint.setStrokeWidth(1f);
    	  mForePaint.setAntiAlias(true);
    	  mForePaint.setColor(Color.rgb(0, 128, 255));
      }
      public void updateVisualizer(byte[] bytes) {
    	  mBytes = bytes;
    	  invalidate();
    	 }
      
      protected void onDraw(Canvas canvas) {
    	  super.onDraw(canvas);
    	  if (mBytes == null) {
    	   return;
    	  }
    	  if (mPoints == null || mPoints.length < mBytes.length * 4) {
    	   mPoints = new float[mBytes.length * 4];
    	  }
    	  mRect.set(0, 0, getWidth(), getHeight());
    	  for (int i = 0; i < mBytes.length - 1; i++) {
    	   mPoints[i * 4] = mRect.width() * i / (mBytes.length - 1);
    	   mPoints[i * 4 + 1] = mRect.height() / 2
    	     + ((byte) (mBytes[i] + 128)) * (mRect.height() / 2) / 128;
    	   mPoints[i * 4 + 2] = mRect.width() * (i + 1) / (mBytes.length - 1);
    	   mPoints[i * 4 + 3] = mRect.height() / 2
    	     + ((byte) (mBytes[i + 1] + 128)) * (mRect.height() / 2)
    	     / 128;
    	  }
    	  canvas.drawColor(Color.WHITE);
    	  canvas.drawLines(mPoints, mForePaint);
    	 }
      
     
     
    

}
