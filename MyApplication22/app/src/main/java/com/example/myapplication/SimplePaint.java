package com.example.projeto_5_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class SimplePaint extends View {
    Paint mPaint;
    Path mPath;

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPath = new Path();

        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPatch(mPath,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float ly,lx;
        lx = event.getX();
        ly = event.getY();
        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:
                mPath.moveTo(lx,ly);
                mPath.lineTo(lx,ly);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(lx,ly);
                break;
            case MotionEvent.ACTION_UP:
                mPath.lineTo(lx,ly);
                break;
            default:
                break;


        }
        return true;
    }
}
