package com.learnmath.utils;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by STELLENT on 11/13/2017.
 */

public class FontChange {
    public void fontChange(TextView view, String font, Activity activity){
        Typeface custom_font = Typeface.createFromAsset(activity.getAssets(), font);
        view.setTypeface(custom_font);
    }
}
