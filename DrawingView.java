package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
 public class DrawingView extends View {

     private ArrayList<Shape> shapes;
     private Shape shape;
     private Paint paint, bgPaint;

     public DrawingView(Context context) {
         super(context);
         //init shapes arrayList:
         shapes = new ArrayList<>();
         //init paint:
         paint = new Paint();
         //set paint default color, style & strokeWidth here!
         //init bg color:
         bgPaint = new Paint();
         bgPaint.setColor(Color.WHITE);
     }

     public boolean onTouchEvent(MotionEvent motionEvent) {
         //find the thouch coordinates:
         float x = motionEvent.getX();
         float y = motionEvent.getY();
         //add new shape in the above coordinates:
         shape = new Shape(x, y);
         shapes.add(shape);
         //invalidate to show changes:
         invalidate();
         return true;
     }
 }
