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

    public DrillMutliplication(Context context){
        this.context=context;
        Update();
    }
    //calls this method when this class is called
    public void Update() {
        textview_mul_one = (TextView) ((Activity)context).findViewById(R.id.textview_mul_one);
        textview_mutli = (TextView) ((Activity)context).findViewById(R.id.textview_mutli);
        textview_mul_two = (TextView) ((Activity)context).findViewById(R.id.textview_mul_two);
        txt_equal_to = (TextView) ((Activity)context).findViewById(R.id.txt_equal_to);
        textview_mul_result = (TextView) ((Activity)context).findViewById(R.id.textview_mul_result);
        img_bomb= (ImageView) ((Activity)context).findViewById(R.id.img_bomb);
        rl_bomb = (RelativeLayout) ((Activity)context).findViewById(R.id.rl_bomb);

        //setting font style for the textviews
        setFontStyle();


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        msoundShare = prefs.getBoolean("sound", true);
        mtextCount = prefs.getString("numberOfQuestions", "0");
    }

    //setting font style for the textviews
    private void setFontStyle() {
        mfont.fontChange(textview_mul_one,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(textview_mul_two,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(textview_mul_result,"fonts/textFont.ttf",((Activity)context));
    }

    //method for generating random numbers and setting the 2 random numbers to textviews
    public void RandomMethodForMultplication() {
        textview_mul_result.setText("");
        mfirstRowRandomOneMul =genarateRandom();
        msecondRowRandomOneMul = genarateRandom();
        textview_mul_one.setText(String.valueOf(mfirstRowRandomOneMul));
        textview_mul_two.setText(String.valueOf(msecondRowRandomOneMul));
    }
    //Multiplication functionality
    public void functionalityforMulFluency() {
        String firstRowFirst_cal = String.valueOf(Integer.parseInt(textview_mul_one.getText().toString()) * Integer.parseInt(textview_mul_two.getText().toString()));        //checking conditions for multiplication
        if (textview_mul_result.getText().toString().equals("")) {
            if (firstRowFirst_cal.length() == 2) {
                mfirstCharMul = String.valueOf(firstRowFirst_cal.charAt(0));
                mseconCharMul = String.valueOf(firstRowFirst_cal.charAt(1));
                if (textview_mul_result.getText().toString().equals("") && Drill.keyNum.equals(mfirstCharMul)) {
                    textview_mul_result.setText(mfirstCharMul);
                    mediaService(R.raw.yes);
                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            } else if (textview_mul_result.getText().toString().equals("") && firstRowFirst_cal.length() == 1) {

                if (Drill.keyNum.equals(firstRowFirst_cal)) {

                    textview_mul_result.setText(firstRowFirst_cal);

                    //for audible sound only first time
                    if (sound) {
                        sound = false;
                        mediaService(R.raw.sucess);
                    }


                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //for increasing count and generate random number after click on write answer
                            DrillAddition.text_int++;
                            Drill.textview_count.setText(DrillAddition.text_int + "/" + mtextCount);
                            sound = true;
                            RandomMethodForMultplication();

                        }
                    }, 1000);

                    mediaService(R.raw.yes);

                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            }
        } else if (!textview_mul_result.getText().toString().equals("")) {


            if (firstRowFirst_cal.length() == 1) {
                //no sound here
            } else {
                if (Drill.keyNum.equals(mseconCharMul)) {

                    textview_mul_result.setText(firstRowFirst_cal);
                    //for audible sound only first time
                    if (textview_mul_result.getText().toString().length() == 2) {
                        if (sound) {
                            sound = false;
                            mediaService(R.raw.sucess);
                        }
                    }

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (textview_mul_result.getText().toString().length() == 2) {
                                //for increasing count and generate random number after click on write answer
                                DrillAddition.text_int++;
                                Drill.textview_count.setText(DrillAddition.text_int + "/" + mtextCount);
                                sound=true;
                                RandomMethodForMultplication();
                            }
                        }
                    }, 1000);
                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            }
        }
    }
    //genarating Random Number
    public int genarateRandom() {
        int min = 1;
        int max = 9;
        Random r = new Random();
        int ranOne = r.nextInt(max - min + 1) + min;
        return ranOne;
    }

    //for playing the sounds
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