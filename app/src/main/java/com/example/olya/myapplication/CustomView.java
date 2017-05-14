package com.example.olya.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class CustomView extends View {

    Paint p;
    private int customColor = Color.GREEN;
    private int customRatio = 10;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        p = new Paint();

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
        customColor = attributes.getColor(R.styleable.CustomView_customColor, customColor);
        customRatio = attributes.getDimensionPixelSize(R.styleable.CustomView_customRatio, customRatio);

        attributes.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        p.setColor(customColor);
        p.setStrokeWidth(customRatio);
        canvas.drawCircle(10 * customRatio, 20 * customRatio, 5 * customRatio, p);
        canvas.drawCircle(30 * customRatio, 20 * customRatio, 5 * customRatio, p);
        p.setStyle(Paint.Style.STROKE);
        canvas.drawArc(5 * customRatio, 35 * customRatio, 35 * customRatio, 55 * customRatio, 180, 180, false, p);
    }
}
