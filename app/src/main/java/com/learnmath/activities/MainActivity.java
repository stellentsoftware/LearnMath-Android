package com.learnmath.Activities;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.learnmath.R;
import com.learnmath.Fragments.LearnMath;
import com.learnmath.Fragments.Settings;

/**
 * Created by stellentsoft on 10/4/2017.
 */
public class MainActivity extends Activity {
    FrameLayout frag;
    RelativeLayout rl_black;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        frag = (FrameLayout) findViewById(R.id.frag);
        rl_black = (RelativeLayout) findViewById(R.id.rl_black);

        //Moving to learn facts activity
        LearnMath learnFacts = new LearnMath();
        rl_black.setVisibility(View.VISIBLE);
        getFragmentManager().beginTransaction()

                .replace(R.id.frag, learnFacts)
                .addToBackStack(null)
                .commit();

        //For changing status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.launch_app_bar));
        }
    }

    @Override
    public void onBackPressed() {
        boolean handled = false;
        Fragment fragment = getFragmentManager().findFragmentById(R.id.frag);
        if (fragment instanceof Settings) {
            //Back press from setting screen
            Settings settingFragment = (Settings) fragment;
            handled = settingFragment.backButton();
        }
        if (!handled) {
            rl_black.setVisibility(View.GONE);
            finish();
        }
    }
}
