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

/**
 * Created by Stellent Soft on 10/16/2017.
 */

public class DrillAddition {

    String mfirstChar, mseconChar,mfirstColumnResult;
    Context context;
    public boolean msoundshare = false,msound=true;
    String mtextCount;
    public static int textInt;
    public static TextView textview_add_result;
    ImageView img_bomb;
    RelativeLayout rl_bomb;
    public int mfirstRanNumAdd,mfifthRanNumAdd;
    private TextView textview_add_one,textview_plus,textview_add_two,txt_equal_to;
    FontChange mfont = new FontChange();
    Util util =new Util();

    public DrillAddition(Context context){
        this.context=context;
        Update();
    }
    //Calls this method when this class is called
    public void Update(){
        textview_add_one = (TextView) ((Activity)context).findViewById(R.id.textview_add_one);
        textview_plus = (TextView) ((Activity)context).findViewById(R.id.textview_plus);
        textview_add_two = (TextView) ((Activity)context).findViewById(R.id.textview_add_two);
        txt_equal_to = (TextView) ((Activity)context).findViewById(R.id.txt_equal_to);
        textview_add_result = (TextView) ((Activity)context).findViewById(R.id.textview_add_result);
        img_bomb= (ImageView) ((Activity)context).findViewById(R.id.img_bomb);
        rl_bomb = (RelativeLayout) ((Activity)context).findViewById(R.id.rl_bomb);
        //Set font style for the textview
        setFontStyle();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        msoundshare = prefs.getBoolean("sound", true);
        mtextCount = prefs.getString("numberOfQuestions", "0");
    }

    //Setting font style for the textviews
    private void setFontStyle() {
        mfont.fontChange(textview_add_one,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(textview_add_two,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(textview_add_result,"fonts/textFont.ttf",((Activity)context));
    }

    //Method for generating random numbers and setting the 2 random numbers to textviews
    public void RandomMethodForAddition() {
        textview_add_result.setText("");
        mfirstRanNumAdd = genarateRandom();
        mfifthRanNumAdd= genarateRandom();
        textview_add_one.setText(String.valueOf(mfirstRanNumAdd));
        textview_plus.setVisibility(View.VISIBLE);
        textview_add_two.setText(String.valueOf(mfifthRanNumAdd));
        txt_equal_to.setVisibility(View.VISIBLE);
    }

    //Addition functionality
    public void functionalityforAdd() {
        //Condition for first click
        if (textview_add_result.getText().toString().equals("")) {
            mfirstColumnResult = String.valueOf(Integer.parseInt(textview_add_one.getText().toString()) + Integer.parseInt(textview_add_two.getText().toString()));
            //If addition result length is equal to 2
            if (mfirstColumnResult.length() == 2) {
                //Split that result into two variables
                mfirstChar = String.valueOf(mfirstColumnResult.charAt(0));
                mseconChar = String.valueOf(mfirstColumnResult.charAt(1));
                if (textview_add_result.getText().toString().equals("") && Drill.keyNum.equals(mfirstChar)) {
                    textview_add_result.setText(mfirstChar);
                     util.mediaService(((Activity) context), R.raw.yes, msoundshare);
                } else {
                     util.mediaService(((Activity) context),R.raw.no,msoundshare);
                }

            } else if (textview_add_result.getText().toString().equals("") && mfirstColumnResult.length() == 1) {
                if (Drill.keyNum.equals(mfirstColumnResult)) {
                    textview_add_result.setText(mfirstColumnResult);
                    final Handler handler = new Handler();
                    if (msound) {
                        msound = false;
                         util.mediaService(((Activity) context), R.raw.sucess,msoundshare);
                    }

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //For increasing count and generate random number after click on write answer
                            textInt++;
                            Drill.textview_count.setText(textInt + "/" + mtextCount);
                            msound=true;
                            RandomMethodForAddition();
                        }
                    }, 1000);

                } else {
                     util.mediaService(((Activity) context),R.raw.no,msoundshare);
                }
            }
        } else if (!textview_add_result.getText().toString().equals("")) {
            if (mfirstColumnResult.length() == 1) {
                //No sound here
            } else {
                if (Drill.keyNum.equals(mseconChar)) {
                    textview_add_result.setText(mfirstChar + mseconChar);
                    final Handler handler = new Handler();
                    //For audible sound only first time
                    if (textview_add_result.getText().toString().length() == 2) {
                        if (msound) {
                            msound = false;
                             util.mediaService(((Activity) context), R.raw.sucess,msoundshare);
                        }
                    }

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (textview_add_result.getText().toString().length() == 2) {
                                //For increasing count and generate random number after click on write answer
                                textInt++;
                                Drill.textview_count.setText(textInt + "/" + mtextCount);
                                msound = true;
                                RandomMethodForAddition();
                            }
                        }
                    }, 1000);

                } else {
                     util.mediaService(((Activity) context),R.raw.no,msoundshare);
                }
            }
        }
    }

    //Generating Random Number
    public int genarateRandom() {
        int min = 1;
        int max = 9;
        Random r = new Random();
        int ranOne = r.nextInt(max - min + 1) + min;
        return ranOne;
    }

}
