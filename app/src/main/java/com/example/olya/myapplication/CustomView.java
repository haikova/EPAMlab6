package com.example.olya.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;


public class CustomView extends View {

    Paint painter;
    private Matrix matrix;
    private Path path;

    private int customColor = Color.GREEN;
    private int customColorEyes;
    private int customColorMouth;

    private boolean currentMouth = false;

    private final GestureDetector gestureDetector;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        painter = new Paint();
        matrix = new Matrix();
        path = new Path();

        matrix.reset();
        matrix.setRotate(180, 100, 200);

        gestureDetector = new GestureDetector(context, new MyGestureListener());

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
        customColor = attributes.getColor(R.styleable.CustomView_customColor, customColor);
        customColorEyes = attributes.getColor(R.styleable.CustomView_customColorEyes, customColor);
        customColorMouth = attributes.getColor(R.styleable.CustomView_customColorMouth, customColor);

        attributes.recycle();
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            currentMouth = !currentMouth;
            invalidate();
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        gestureDetector.onTouchEvent(event);
        return true;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        painter.setColor(customColorEyes);
        painter.setStrokeWidth(7);
        painter.setStyle(Paint.Style.FILL);

        canvas.drawCircle(50, 100, 25, painter);
        canvas.drawCircle(150, 100, 25, painter);

        painter.setColor(customColorMouth);
        painter.setStyle(Paint.Style.STROKE);

        path.reset();
        path.addArc(25, 175, 175, 275 , 180, 180);

        if (currentMouth){
            path.transform(matrix);
        }
        canvas.drawPath(path, painter);
    }

    @Override
    public Parcelable onSaveInstanceState(){
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putBoolean("currentMouth", currentMouth);
        Log.d("onSaveInstanceState", "+++");
        return bundle;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state){
        if (state instanceof Bundle){
            Bundle bundle = (Bundle) state;
            currentMouth = bundle.getBoolean("currentMouth");
            state = bundle.getParcelable("superState");
            Log.d("onRestoreInstanceState", "+++");
        }
        super.onRestoreInstanceState(state);
    }

}
