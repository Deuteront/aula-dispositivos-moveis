package com.example.projeto_5_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class SimplePaint extends View {
    List<Draw> drawList;
    Paint currentPaint;
    Path currentPath;
    ColorDrawable currentColor;
    DrawEnum currentDrawn;
    Boolean finish= false;
    float initX;
    float initY;


    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        drawList = new ArrayList<>();
        currentColor= new ColorDrawable();
        currentColor.setColor(Color.RED);
        currentDrawn = DrawEnum.LINHA;
        iniciarPaintPath();
        currentPaint.setColor(currentColor.getColor());
    }

    private void iniciarPaintPath(){
        currentPaint = new Paint();
        currentPath = new Path();

        currentPaint.setStrokeWidth(20);
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setColor(currentColor.getColor());

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(Draw draw : drawList){
            switch (draw.getDrawEnum()){
                case CIRCULO:
                    canvas.drawCircle(draw.getInitX(),draw.getInitY(),draw.getRadius()/2, draw.getPaint());
                    break;
                case LINHA:
                    canvas.drawPath(draw.getPath(),draw.getPaint());
                    break;
                case QUADRADO:
                    canvas.drawRect(draw.getRect(),draw.getPaint());
                    break;
            }
        }
        canvas.drawPath(currentPath, currentPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float ly,lx;
        finish = false;
        lx = event.getX();
        ly = event.getY();
        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:
                initX = lx;
                initY = ly;
                currentPath.moveTo(lx,ly);
                currentPath.lineTo(lx,ly);
                break;
            case MotionEvent.ACTION_MOVE:
                currentPath.lineTo(lx,ly);
                break;
            case MotionEvent.ACTION_UP:
                currentPath.lineTo(lx,ly);
                finish = true;
                Draw draw = new Draw(currentDrawn,currentPaint,currentPath,
                        (float) Math.sqrt(Math.pow(lx - initX, 2) + Math.pow(ly - initY, 2)),
                        initX,
                        lx,
                        initY,
                        ly,
                        new Rect((int)initX,(int)ly,(int)lx,(int)initY));
                drawList.add(draw);
                iniciarPaintPath();
                break;
            default:
                break;

        }
        invalidate();
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setColor(Color color){
        currentPaint.setColor(color.toArgb());
        currentColor.setColor(color.toArgb());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setGeometricForm(String geometricForm){
        switch (geometricForm){
            case "LINHA":
                currentDrawn = DrawEnum.LINHA;
                break;
            case "CIRCULO":
                currentDrawn = DrawEnum.CIRCULO;
                break;
            case "QUADRADO":
                currentDrawn = DrawEnum.QUADRADO;
                break;
            default:
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void undoAll(){
        drawList = new ArrayList<>();
        invalidate();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void undo(){
        if(drawList.size()>0){
            drawList.remove(drawList.size()-1);
        }
        invalidate();
    }
}
