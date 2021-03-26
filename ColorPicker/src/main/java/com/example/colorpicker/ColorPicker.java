package com.example.colorpicker;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ColorPicker extends AppCompatActivity {
    public void launch(View viewLauncher, FloatingActionButton floatingActionButton) {
        viewLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentLauncher(floatingActionButton);
            }
        });
    }
    void fragmentLauncher(FloatingActionButton floatingActionButton) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        ColorControllerFragment test = new ColorControllerFragment();
        test.floatingActionButton = floatingActionButton;
        DialogFragment dialogFragment = test;
        dialogFragment.show(ft, "dialog");
    }
}
