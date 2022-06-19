package com.example.projeto_5_paint;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;


public class Draw {
    private final DrawEnum drawEnum;
    private final Path path;
    private final Paint paint;
    private final Float radius;
    private final Rect rect;
    private final Float initX;
    private final Float finalX;
    private final Float initY;
    private final Float finalY;

    public Draw(DrawEnum drawEnum, Paint paint, Path path, float radius,Float initX,Float finalX,Float initY,Float finalY, Rect rect) {
        this.drawEnum = drawEnum;
        this.paint = paint;
        this.path = path;
        this.radius = radius;
        this.rect = rect;
        this.initX = initX;
        this.finalX = finalX;
        this.initY = initY;
        this.finalY = finalY;
    }

    public DrawEnum getDrawEnum() {
        return drawEnum;
    }

    public Paint getPaint() {
        return paint;
    }

    public Path getPath() {
        return path;
    }


    public Float getRadius() {
        return radius;
    }

    public Float getInitX() {
        return initX;
    }

    public Float getFinalX() {
        return finalX;
    }

    public Float getInitY() {
        return initY;
    }

    public Float getFinalY() {
        return finalY;
    }

    public Rect getRect() {
        return rect;
    }
}
