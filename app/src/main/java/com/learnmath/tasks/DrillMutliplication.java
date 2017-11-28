package com.learnmath.Tasks;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
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

public class DrillMutliplication {

    public static TextView textview_mul_result;
    public  int mfirstRowRandomOneMul, msecondRowRandomOneMul;
    public boolean msoundShare = false;
    public Context context;
    String mtextCount;
    ImageView img_bomb;
    RelativeLayout rl_bomb;
    String mfirstCharMul,mseconCharMul;
    TextView textview_mul_one,textview_mutli,textview_mul_two,txt_equal_to;
    private boolean sound=true;
    FontChange mfont = new FontChange();
    Util util = new Util();

    public DrillMutliplication(Context context){
        this.context=context;
        Update();
    }
    //Calls this method when this class is called
    public void Update() {
        textview_mul_one = (TextView) ((Activity)context).findViewById(R.id.textview_mul_one);
        textview_mutli = (TextView) ((Activity)context).findViewById(R.id.textview_mutli);
        textview_mul_two = (TextView) ((Activity)context).findViewById(R.id.textview_mul_two);
        txt_equal_to = (TextView) ((Activity)context).findViewById(R.id.txt_equal_to);
        textview_mul_result = (TextView) ((Activity)context).findViewById(R.id.textview_mul_result);
        img_bomb= (ImageView) ((Activity)context).findViewById(R.id.img_bomb);
        rl_bomb = (RelativeLayout) ((Activity)context).findViewById(R.id.rl_bomb);

        //Setting font style for the textviews
        setFontStyle();


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        msoundShare = prefs.getBoolean("sound", true);
        mtextCount = prefs.getString("numberOfQuestions", "0");
    }

    //Setting font style for the textviews
    private void setFontStyle() {
        mfont.fontChange(textview_mul_one,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(textview_mul_two,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(textview_mul_result,"fonts/textFont.ttf",((Activity)context));
    }

    //Method for generating random numbers and setting the 2 random numbers to textviews
    public void RandomMethodForMultplication() {
        textview_mul_result.setText("");
        mfirstRowRandomOneMul =genarateRandom();
        msecondRowRandomOneMul = genarateRandom();
        textview_mul_one.setText(String.valueOf(mfirstRowRandomOneMul));
        textview_mul_two.setText(String.valueOf(msecondRowRandomOneMul));
    }
    //Multiplication functionality
    public void functionalityforMulFluency() {
        String mfirstRowFirstCal = String.valueOf(Integer.parseInt(textview_mul_one.getText().toString()) * Integer.parseInt(textview_mul_two.getText().toString()));        //checking conditions for multiplication
        if (textview_mul_result.getText().toString().equals("")) {
            if (mfirstRowFirstCal.length() == 2) {
                mfirstCharMul = String.valueOf(mfirstRowFirstCal.charAt(0));
                mseconCharMul = String.valueOf(mfirstRowFirstCal.charAt(1));
                if (textview_mul_result.getText().toString().equals("") && Drill.keyNum.equals(mfirstCharMul)) {
                    textview_mul_result.setText(mfirstCharMul);
                    util.mediaService(((Activity) context), R.raw.yes, msoundShare);
                } else {
                    util.mediaService(((Activity) context),R.raw.no,msoundShare);
                }
            } else if (textview_mul_result.getText().toString().equals("") && mfirstRowFirstCal.length() == 1) {

                if (Drill.keyNum.equals(mfirstRowFirstCal)) {

                    textview_mul_result.setText(mfirstRowFirstCal);

                    //For audible sound only first time
                    if (sound) {
                        sound = false;
                        util.mediaService(((Activity) context), R.raw.sucess,msoundShare);
                    }


                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //For increasing count and generate random number after click on write answer
                            DrillAddition.textInt++;
                            Drill.textview_count.setText(DrillAddition.textInt + "/" + mtextCount);
                            sound = true;
                            RandomMethodForMultplication();

                        }
                    }, 1000);

                    util.mediaService(((Activity) context),R.raw.yes,msoundShare);

                } else {
                    util.mediaService(((Activity) context),R.raw.no,msoundShare);
                }
            }
        } else if (!textview_mul_result.getText().toString().equals("")) {


            if (mfirstRowFirstCal.length() == 1) {
                //No sound here
            } else {
                if (Drill.keyNum.equals(mseconCharMul)) {

                    textview_mul_result.setText(mfirstRowFirstCal);
                    //For audible sound only first time
                    if (textview_mul_result.getText().toString().length() == 2) {
                        if (sound) {
                            sound = false;
                            util.mediaService(((Activity) context), R.raw.sucess,msoundShare);
                        }
                    }

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (textview_mul_result.getText().toString().length() == 2) {
                                //For increasing count and generate random number after click on write answer
                                DrillAddition.textInt++;
                                Drill.textview_count.setText(DrillAddition.textInt + "/" + mtextCount);
                                sound=true;
                                RandomMethodForMultplication();
                            }
                        }
                    }, 1000);
                } else {
                    util.mediaService(((Activity) context),R.raw.no,msoundShare);
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
