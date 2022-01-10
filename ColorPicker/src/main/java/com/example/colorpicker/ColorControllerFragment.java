package com.example.colorpicker;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.colorpicker.FloatingButton;

public class ColorControllerFragment extends DialogFragment {
    public FloatingButton _floatingActionButton;
    private int _color = -1111111;
    private ImageView _rgbWheel;
    private Button _confirmColorButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.color_picker_fragment, container, false);
        configureLayout(v);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }

    void configureLayout(View v) {
        _rgbWheel = v.findViewById(R.id.rgbWheel);
        _confirmColorButton = v.findViewById(R.id.confirmColorBtn);

        _rgbWheel.setDrawingCacheEnabled(true);
        _rgbWheel.buildDrawingCache(true);
        _rgbWheel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Bitmap bitmap;
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                    bitmap = _rgbWheel.getDrawingCache();

                    int pixel = bitmap.getPixel((int)event.getX(), (int)event.getY());

                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);

                    _color = Color.rgb(r, g ,b);
                    _confirmColorButton.setBackgroundColor(color);
                }
                return true;
            }
        });

        _confirmColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _floatingActionButton.setColor(color);
                dismiss();
            }
        });
    }
}
