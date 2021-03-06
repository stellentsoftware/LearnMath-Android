package com.learnmath.Tasks;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.learnmath.R;
import com.learnmath.Fragments.Drill;
import com.learnmath.Utils.FontChange;
import com.learnmath.Utils.Util;

import java.util.Random;

public class DrillSubtraction {
    public  int mfirstRanNumSub,mfifthRanNumSub;
    public boolean msoundShare = false;
    String mtextCount;
    SharedPreferences prefs;
    public static TextView textview_sub_result;
    ImageView img_bomb;
    RelativeLayout rl_bomb;
    private TextView textview_sub_one,textview_plus,textview_sub_two,txt_equal_to;
    public Context context;
    FontChange mfont = new FontChange();
    Util util = new Util();


    //Constructor to get views
    public DrillSubtraction(Context context) {
        this.context = context;
        textview_sub_one = (TextView) ((Activity)context).findViewById(R.id.textview_sub_one);
        textview_plus = (TextView) ((Activity)context).findViewById(R.id.textview_plus);
        textview_sub_two = (TextView) ((Activity)context).findViewById(R.id.textview_sub_two);
        txt_equal_to = (TextView) ((Activity)context).findViewById(R.id.txt_equal_to);
        textview_sub_result = (TextView) ((Activity)context).findViewById(R.id.textview_sub_result);
        //Setting font style for the textviews
        setTypeFace();
        img_bomb= (ImageView) ((Activity)context).findViewById(R.id.img_bomb);
        rl_bomb = (RelativeLayout) ((Activity)context).findViewById(R.id.rl_bomb);
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        msoundShare = prefs.getBoolean("sound", true);
        mtextCount = prefs.getString("numberOfQuestions", "0");
    }

    //Setting font style for the textviews
    private void setTypeFace() {
        mfont.fontChange(textview_sub_one,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(textview_sub_two,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(textview_sub_result,"fonts/textFont.ttf",((Activity)context));
    }

    //For generating random numbers for perform subtraction
    public void RandomMethodForSubtraction() {
        //empty the views before setting the value
        textview_sub_result.setText("");
        Random r1 = new Random();
        mfifthRanNumSub = r1.nextInt(9 - 1 + 1) + 1;
        mfirstRanNumSub = r1.nextInt(9 - mfifthRanNumSub + 1) + mfifthRanNumSub;
        //setting the random number
        textview_sub_one.setText(String.valueOf(mfirstRanNumSub));
        textview_plus.setVisibility(View.VISIBLE);
        textview_sub_two.setText(String.valueOf(mfifthRanNumSub));
        txt_equal_to.setVisibility(View.VISIBLE);
    }
    //Functionality for substraction
    public void functionalityforSub() {
        onedigitsSub();
    }
    //Subtraction functionality level1
    public void onedigitsSub() {
        if (textview_sub_result.getText().toString().equals("")) {
            if (Drill.keyNum.equals(String.valueOf(Integer.parseInt(textview_sub_one.getText().toString()) - Integer.parseInt(textview_sub_two.getText().toString())))) {
                textview_sub_result.setText(Drill.keyNum);
                util.mediaService(((Activity) context), R.raw.sucess, msoundShare);


                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //For increasing count and generate random number after click on write answer
                        DrillAddition.textInt++;
                        Drill.textview_count.setText(DrillAddition.textInt + "/" + mtextCount);
                        RandomMethodForSubtraction();

                    }
                }, 1000);

            } else {
                util.mediaService(((Activity) context), R.raw.no, msoundShare);

            }
        }
    }
}