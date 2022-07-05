package com.lucasgithubz.colorpicker;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FloatingButton extends FloatingActionButton {
  // purple 500
  private int _defaultColor = Color.rgb(156, 39, 176);

  public FloatingButton(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    launch(context);
  }

  public FloatingButton(@NonNull Context context) {
    super(context);
    launch(context);
  }

  public int getColor() {
    return getBackgroundTintList().getDefaultColor();
  }

  public void setColor(int color) {
    setBackgroundTintList(ColorStateList.valueOf(color));
  }

  public void resetColor() {
    setColor(_defaultColor);
  }

  void launch(Context context) {
    final Activity activity = (Activity) context;
    resetColor();
    this.setOnClickListener(
        new OnClickListener() {
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
