package com.example.colorpicker;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FloatingButton extends FloatingActionButton {
    public FloatingButton(@NonNull Context context) {
        super(context);
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
                DialogFragment dialogFragment = new ColorControllerFragment();
                dialogFragment.show(ft, "dialog");
            }
        });
    }
}
