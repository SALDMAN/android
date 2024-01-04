package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class DrawOnView extends View {
    Paint myPaint;
    Bitmap bmp;

    public DrawOnView(Context context){
        super(context);
        bmp= BitmapFactory.decodeResource(getResources(),R.drawable.nar);
        myPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int h,w;
        h=bmp.getHeight();
        w = bmp.getWidth();
        Rect r = new Rect(270,600,270+w/2,600+h/2);
        canvas.drawBitmap(bmp,null,r,myPaint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Path path = new Path();
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                return true;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(x, y);
                    break;
                    case MotionEvent.ACTION_UP:
                        path.lineTo(x, y);
                        break;
        default:
            return false;
        }       invalidate();
        return true;
    }

}
