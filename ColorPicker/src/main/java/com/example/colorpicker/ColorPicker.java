package com.example.colorpicker;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

public class ColorPicker {
    public static void fetch(View view1, View view2) {
        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Bitmap bitmap;
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                    bitmap = view1.getDrawingCache();

                    int pixel = bitmap.getPixel((int)event.getX(), (int)event.getY());

                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);

                    Integer color = Color.rgb(r, g ,b);
                    view2.setBackgroundColor(color);
                }
                return true;
            }
        });
    }
}
