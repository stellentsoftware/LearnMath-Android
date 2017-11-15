package com.learnmath.tasks;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.learnmath.R;
import com.learnmath.fragments.Drill;
import com.learnmath.utils.FontChange;

import java.util.Random;

/**
 * Created by Stellent Soft on 10/17/2017.
 */

public class DrillDivision {

    public int mdivDown, mdivUp;
    public boolean msoundShare = false,msound=true;
    String mtextCount;
    ImageView img_bomb;
    RelativeLayout rl_bomb;
    int mrandomNumber;
    String mfirstCharDiv,mseconCharDiv;
    public static TextView textview_div_result;
    FontChange mfont = new FontChange();
    int rand;
    TextView textview_div_one,textview_mutli,textview_div_two,txt_equal_to;
    public Context context;
    public DrillDivision(Context context){
        this.context=context;
        Update();
    }
    //Calls this method when this class is called
    public void Update() {
        textview_div_one = (TextView) ((Activity)context).findViewById(R.id.textview_div_one);
        textview_mutli = (TextView) ((Activity)context).findViewById(R.id.textview_mutli);
        textview_div_two = (TextView) ((Activity)context).findViewById(R.id.textview_div_two);
        txt_equal_to = (TextView) ((Activity)context).findViewById(R.id.txt_equal_to);
        textview_div_result = (TextView) ((Activity)context).findViewById(R.id.textview_div_result);
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

        mfont.fontChange(textview_div_one,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(textview_div_two,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(textview_div_result,"fonts/textFont.ttf",((Activity)context));
    }

    //Method for generating random numbers and setting the 2 random numbers to textviews
    public void RandomMethodForDivision() {
        textview_div_result.setText("");
        mdivDown=generateRandForDown();
        textview_div_one.setText(String.valueOf(mdivDown));
    }

    //Code for division functinality
    public void functionalityforDivFluency() {
        String firstRowFirst_cal = String.valueOf(mdivUp / mdivDown);
        if (textview_div_result.getText().toString().equals("")) {
            if (firstRowFirst_cal.length() == 2) {
                mfirstCharDiv = String.valueOf(firstRowFirst_cal.charAt(0));
                mseconCharDiv = String.valueOf(firstRowFirst_cal.charAt(1));
                if (textview_div_result.getText().toString().equals("") && Drill.keyNum.equals(mfirstCharDiv)) {
                    textview_div_result.setText(mfirstCharDiv);
                    //Media yes
                    mediaService(R.raw.yes);

                } else {
                    //Media no
                    mediaService(R.raw.no);
                }

            } else if (textview_div_result.getText().toString().equals("") && firstRowFirst_cal.length() == 1) {
                if (Drill.keyNum.equals(firstRowFirst_cal)) {
                    textview_div_result.setText(firstRowFirst_cal);
                    //Media success
                    if (msound) {
                        msound = false;
                        mediaService(R.raw.sucess);
                    }

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //For increasing count and generate random number after click on write answer
                            DrillAddition.text_int++;
                            Drill.textview_count.setText(DrillAddition.text_int + "/" + mtextCount);
                            msound=true;
                            RandomMethodForDivision();
                        }
                    }, 1000);
                } else {
                    //Media no
                    mediaService(R.raw.no);
                }
            }
        } else if (!textview_div_result.getText().toString().equals("")) {
            if (firstRowFirst_cal.length()==1) {
                //No sound here
            } else {
                if (Drill.keyNum.equals(mseconCharDiv)) {
                    textview_div_result.setText(firstRowFirst_cal);
                    //For audible sound only first time
                    if (textview_div_result.getText().toString().length() == 2) {
                        if (msound) {
                            msound = false;
                            //Media success
                            mediaService(R.raw.sucess);
                        }
                    }

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (textview_div_result.getText().toString().length() == 2) {
                                //For increasing count and generate random number after click on write answer
                                DrillAddition.text_int++;
                                Drill.textview_count.setText(DrillAddition.text_int + "/" + mtextCount);
                                msound=true;
                                RandomMethodForDivision();
                            }
                        }
                    }, 1000);
                }else{
                    //Media no
                    mediaService(R.raw.no);
                }
            }
        }
    }

    //Generate two random numbers
    public int generateRandForDown(){
        int min = 1;
        int max = 10;
        Random r = new Random();
        mrandomNumber = r.nextInt(max - min + 1) + min;
        mdivUp = genarateRandom();
        textview_div_two.setText(String.valueOf(mdivUp));
        return mrandomNumber;
    }
    //Generating Random Number
    public int genarateRandom() {
        Random r = new Random();
        int Low = 1;
        int High = 99;
        int randomNumber_high = r.nextInt(High-Low+1)+Low;
        int ranTwo =  r.nextInt(High - randomNumber_high + 1) + randomNumber_high;

        //Condition for perfect division
        if(mrandomNumber<=ranTwo) {
            if (ranTwo % mrandomNumber == 0) {
                rand = ranTwo;
            }
            else{
                rand = genarateRandom();
            }
        }
        return rand;
    }


    //For playing the sounds
    public void mediaService(int raw) {
        if(msoundShare) {
            final MediaPlayer mp = MediaPlayer.create(context, raw);
            try {
                if (mp.isPlaying()) {
                } else {
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp1) {
                            if (mp == mp1) {
                                mp.start();
                            }
                        }
                    });
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();
                        }

                        ;
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
