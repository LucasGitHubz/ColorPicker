package com.example.colorpicker;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FloatingButton extends FloatingActionButton {
    public FloatingButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        launch(context);
    }
    public FloatingButton(@NonNull Context context) {
        super(context);
        launch(context);
    }

    void launch(Context context) {
        final Activity activity = (Activity) context;

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
                Fragment prev = activity.getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    ft.remove(prev);
                }
                ft.addToBackStack(null);
                ColorControllerFragment instance = new ColorControllerFragment();
                instance.floatingActionButton = FloatingButton.this;
                DialogFragment dialogFragment = instance;
                dialogFragment.show(ft, "dialog");
            }
        });
    }
}
