package com.learnmath.tasks;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
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

public class DrillAddition {

    String mfirstChar, mseconChar,mfirstColumnResult;
    Context context;
    public boolean msoundshare = false,msound=true;
    String mtextCount;
    public static int text_int;
    public static TextView textview_add_result;
    ImageView img_bomb;
    RelativeLayout rl_bomb;
    private int firstRanNum_add,fifthRanNum_add;
    private TextView textview_add_one,textview_plus,textview_add_two,txt_equal_to;
    FontChange mfont = new FontChange();

    public DrillAddition(Context context){
        this.context=context;
        Update();
    }
    //calls this method when this class is called
    public void Update(){
        textview_add_one = (TextView) ((Activity)context).findViewById(R.id.textview_add_one);
        textview_plus = (TextView) ((Activity)context).findViewById(R.id.textview_plus);
        textview_add_two = (TextView) ((Activity)context).findViewById(R.id.textview_add_two);
        txt_equal_to = (TextView) ((Activity)context).findViewById(R.id.txt_equal_to);
        textview_add_result = (TextView) ((Activity)context).findViewById(R.id.textview_add_result);
        img_bomb= (ImageView) ((Activity)context).findViewById(R.id.img_bomb);
        rl_bomb = (RelativeLayout) ((Activity)context).findViewById(R.id.rl_bomb);
        //set font style for the textview
        setFontStyle();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        msoundshare = prefs.getBoolean("sound", true);
        mtextCount = prefs.getString("numberOfQuestions", "0");
    }

    //setting font style for the textviews
    private void setFontStyle() {
        mfont.fontChange(textview_add_one,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(textview_add_two,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(textview_add_result,"fonts/textFont.ttf",((Activity)context));
    }

    //method for generating random numbers and setting the 2 random numbers to textviews
    public void RandomMethodForAddition() {
        textview_add_result.setText("");
        firstRanNum_add = genarateRandom();
        fifthRanNum_add= genarateRandom();
        textview_add_one.setText(String.valueOf(firstRanNum_add));
        textview_plus.setVisibility(View.VISIBLE);
        textview_add_two.setText(String.valueOf(fifthRanNum_add));
        txt_equal_to.setVisibility(View.VISIBLE);
    }

    //addition functionality
    public void functionalityforAdd() {
        //condition for first click
        if (textview_add_result.getText().toString().equals("")) {
            mfirstColumnResult = String.valueOf(Integer.parseInt(textview_add_one.getText().toString()) + Integer.parseInt(textview_add_two.getText().toString()));
            //if addition result length is equal to 2
            if (mfirstColumnResult.length() == 2) {
                //split that result into two variables
                mfirstChar = String.valueOf(mfirstColumnResult.charAt(0));
                mseconChar = String.valueOf(mfirstColumnResult.charAt(1));
                if (textview_add_result.getText().toString().equals("") && Drill.keyNum.equals(mfirstChar)) {
                    textview_add_result.setText(mfirstChar);
                    //media yes
                    mediaService(R.raw.yes);
                } else {
                    //media no
                    mediaService(R.raw.no);
                }

            } else if (textview_add_result.getText().toString().equals("") && mfirstColumnResult.length() == 1) {
                if (Drill.keyNum.equals(mfirstColumnResult)) {
                    textview_add_result.setText(mfirstColumnResult);
                    final Handler handler = new Handler();
                    if (msound) {
                        msound = false;
                        mediaService(R.raw.sucess);
                    }

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //for increasing count and generate random number after click on write answer
                            text_int++;
                            Drill.textview_count.setText(text_int + "/" + mtextCount);
                            msound=true;
                            RandomMethodForAddition();
                        }
                    }, 1000);

                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            }
        } else if (!textview_add_result.getText().toString().equals("")) {
            if (mfirstColumnResult.length() == 1) {
                //no sound here
            } else {
                if (Drill.keyNum.equals(mseconChar)) {
                    textview_add_result.setText(mfirstChar + mseconChar);
                    final Handler handler = new Handler();
                    //for audible sound only first time
                    if (textview_add_result.getText().toString().length() == 2) {
                        if (msound) {
                            msound = false;
                            mediaService(R.raw.sucess);
                        }
                    }

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (textview_add_result.getText().toString().length() == 2) {
                                //for increasing count and generate random number after click on write answer
                                text_int++;
                                Drill.textview_count.setText(text_int + "/" + mtextCount);
                                msound = true;
                                RandomMethodForAddition();
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
        if(msoundshare) {
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
