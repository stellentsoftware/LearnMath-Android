package com.learnmath.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.learnmath.R;

import com.learnmath.CouchMark.CouchMarkerFour;
import com.learnmath.CouchMark.CouchMarkerOne;
import com.learnmath.CouchMark.CouchMarkerThree;
import com.learnmath.CouchMark.CouchMarkerTwo;
import com.learnmath.Fragments.Drill;
import com.learnmath.Utils.FontChange;

public class LaunchActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img_rotate;
    public static RelativeLayout rel_body, rl_pager;
    TextView btn_plus, btn_division, btn_minus, btn_mult;
    String tagValue;
    ScreenSlidePagerAdapter mPagerAdapter;
    public static ViewPager mPager;
    public static boolean fromLaunch = false;
    public static int fromFirstLaunch;
    FontChange mfont = new FontChange();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Getting values from shared preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        fromFirstLaunch = prefs.getInt("fromFirstLaunch", 0);
        //Setting full screen when coach mark apears
        if (fromFirstLaunch == 0) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        }
        if (Drill.waitTimer != null) {
            Drill.waitTimer.cancel();
        }
        setContentView(R.layout.activity_launching);

        rl_pager = (RelativeLayout) findViewById(R.id.rl_pager);
        mPager = (ViewPager) findViewById(R.id.pager);
        btn_plus = (TextView) findViewById(R.id.btn_plus);
        btn_minus = (TextView) findViewById(R.id.btn_minus);
        btn_mult = (TextView) findViewById(R.id.btn_mult);
        btn_division = (TextView) findViewById(R.id.btn_division);
        rel_body = (RelativeLayout) findViewById(R.id.rel_body);
        //Getting the shared preference values
        fromFirstLaunch = prefs.getInt("fromFirstLaunch", 0);
        if (fromFirstLaunch == 0) {
            rl_pager.setVisibility(View.VISIBLE);
            mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
            mPager.setAdapter(mPagerAdapter);
        } else {
            rl_pager.setVisibility(View.GONE);
        }
        //Viewpager fore coachmarks
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub

                if (arg0 == 0) {
                }

                if (arg0 == 1) {
                }

                if (arg0 == 2) {

                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub
            }
        });
        // Onclicks for operations
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_mult.setOnClickListener(this);
        btn_division.setOnClickListener(this);
        rel_body.setOnClickListener(this);
        //For changing status bar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.launch_app_bar));
        }

    }

    @Override
    public void onClick(View view) {
        //Onclicks for buttons
        if (view.equals(btn_plus)) {
            tagValue = "add";
            moveToLearnFacts();
        } else if (view.equals(btn_minus)) {
            tagValue = "sub";
            moveToLearnFacts();
        } else if (view.equals(btn_mult)) {
            tagValue = "mul";
            moveToLearnFacts();
        } else if (view.equals(btn_division)) {
            tagValue = "div";
            moveToLearnFacts();
        } else if (view.equals(rel_body)) {
            tagValue = "add";
            moveToLearnFacts();
        }
    }
    //Moving to learnFacts screen

    public void moveToLearnFacts() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("tag", tagValue);
        editor.putString("apply_tag", "add");
        editor.putString("fluency_tag", "add");
        editor.commit();

        fromLaunch = true;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int index) {
            //For displaying coach marks
            switch (index) {
                case 0:
                    return new CouchMarkerOne();
                case 1:
                    return new CouchMarkerTwo();
                case 2:
                    return new CouchMarkerThree();
                case 3:
                    return new CouchMarkerFour();
            }
            return null;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }


        @Override
        public int getCount() {
            return 4;
        }
    }

    //Info dialog
    public void showDialogInfo() {

        final Dialog dialog = new Dialog(this, R.style.DialogTheme);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.info_dialog);
        TextView tv_head = (TextView) dialog.findViewById(R.id.tv_head);
        TextView tv_body = (TextView) dialog.findViewById(R.id.tv_body);
        TextView txt_info_head = (TextView) dialog.findViewById(R.id.txt_info_head);

        //Setting font style for the textviews
        mfont.fontChange(txt_info_head, "fonts/textFont.ttf", LaunchActivity.this);
        mfont.fontChange(tv_head, "fonts/textFont.ttf", LaunchActivity.this);
        mfont.fontChange(tv_body, "fonts/textFont.ttf", LaunchActivity.this);
        tv_head.setText(getResources().getString(R.string.info_learn_head));
        tv_body.setText(getResources().getString(R.string.learn_facts_info));

        RelativeLayout rl_dissmiss = (RelativeLayout) dialog.findViewById(R.id.rl_dissmiss);
        rl_dissmiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        ImageView img_dissmiss = (ImageView) dialog.findViewById(R.id.img_close_info);
        img_dissmiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                fromFirstLaunch++;
            }
        });

        fromFirstLaunch++;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("fromFirstLaunch", fromFirstLaunch);
        editor.commit();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        dialog.show();
    }
}
