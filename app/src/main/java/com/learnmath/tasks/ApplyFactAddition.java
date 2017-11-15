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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.learnmath.R;
import com.learnmath.fragments.ApplyMath;
import com.learnmath.utils.FontChange;

import java.util.Random;

/**
 * Created by mohan on 10/13/2017.
 */
public class ApplyFactAddition {
    Context context;
    int mranNumOne,mranNumTwo;
    public boolean msoundShare = false,madditionClear=true;
    ImageView img_panda;
    RelativeLayout rl_panda;
    FontChange mfont=new FontChange();
    private int mfirstRanNumAdd,msecondRanNumAdd,mthirdRanNumAdd,mfourthRanNumAdd,mfifthRanNumAdd,msixthRanNumAdd,mlevel;
    private TextView txt_result_five_add,txt_pandatext,txt_number_bellow_four_add,txt_number_bellow_three_add,txt_result_four_add,txt_result_three_add,txt_result_two_add,txt_result_one_add,txt_borrow_four_add,txt_borrow_three_add,txt_borrow_two_add,txt_borrow_one_add,txt_number_up_one_add,txt_number_up_two_add,txt_number_up_three_add,txt_number_up_four_add,txt_number_bellow_two_add,txt_number_bellow_one_add;
    public ApplyFactAddition(Context context){
        this.context=context;
        Update();
    }
    //calls this method when this class is called
    public void Update(){
        //getting the textviews
         txt_number_up_one_add = (TextView) ((Activity)context).findViewById(R.id.txt_number_up_one_add);
         txt_number_up_two_add = (TextView) ((Activity)context).findViewById(R.id.txt_number_up_two_add);
         txt_number_up_three_add = (TextView) ((Activity)context).findViewById(R.id.txt_number_up_three_add);
         txt_number_up_four_add = (TextView) ((Activity)context).findViewById(R.id.txt_number_up_four_add);
         txt_number_bellow_two_add = (TextView) ((Activity)context).findViewById(R.id.txt_number_bellow_two_add);
         txt_number_bellow_one_add = (TextView) ((Activity)context).findViewById(R.id.txt_number_bellow_one_add);
        txt_borrow_one_add = (TextView) ((Activity)context).findViewById(R.id.txt_borrow_one_add);
        txt_borrow_two_add = (TextView) ((Activity)context).findViewById(R.id.txt_borrow_two_add);
        txt_borrow_three_add = (TextView) ((Activity)context).findViewById(R.id.txt_borrow_three_add);
        txt_borrow_four_add = (TextView) ((Activity)context).findViewById(R.id.txt_borrow_four_add);
        txt_result_one_add = (TextView) ((Activity)context).findViewById(R.id.txt_result_one_add);
        txt_result_two_add = (TextView) ((Activity)context).findViewById(R.id.txt_result_two_add);
        txt_result_three_add = (TextView) ((Activity)context).findViewById(R.id.txt_result_three_add);
        txt_result_four_add = (TextView) ((Activity)context).findViewById(R.id.txt_result_four_add);
        txt_result_five_add= (TextView) ((Activity)context).findViewById(R.id.txt_result_five_add);
        txt_number_bellow_three_add = (TextView) ((Activity)context).findViewById(R.id.txt_number_bellow_three_add);
        txt_number_bellow_four_add = (TextView) ((Activity)context).findViewById(R.id.txt_number_bellow_four_add);
        txt_pandatext= (TextView) ((Activity)context).findViewById(R.id.txt_pandatext);
        //Setting font style for the textview
        setFontStyle();
        //for panda
        img_panda = (ImageView) ((Activity)context).findViewById(R.id.img_panda);
        rl_panda =  (RelativeLayout) ((Activity)context).findViewById(R.id.rl_panda);
        //getting values from shared preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        mlevel = Integer.parseInt(prefs.getString("level", "1"));
        msoundShare = prefs.getBoolean("sound", true);
    }

    private void setFontStyle() {
        mfont.fontChange(txt_number_up_one_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_number_up_two_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_number_up_three_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_number_up_four_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_number_bellow_two_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_number_bellow_one_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_borrow_one_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_borrow_two_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_borrow_three_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_borrow_four_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_result_one_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_result_two_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_result_three_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_result_four_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_result_five_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_number_bellow_three_add,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_number_bellow_four_add,"fonts/textFont.ttf",((Activity)context));

    }

    //genarate random number for addition
    public void geanarateRandomApplyAdd() {
        //increase the success count
        if(ApplyMath.fromFirst) {
            ApplyMath.fromFirst =false;
            ApplyMath.countForPanda =0;
        }else {
            ApplyMath.countForPanda++;
        }
        madditionClear=true;
        //calling the panda for displaying the image
        if (ApplyMath.countForPanda == 5) {
            displayingPanda();
        }
        //empty the views before setting the value
        txt_number_up_one_add.setText("");
        txt_number_up_two_add.setText("");
        txt_number_up_three_add.setText("");
        txt_number_up_four_add.setText("");
        txt_number_bellow_two_add.setText("");
        txt_number_bellow_one_add.setText("");
        txt_borrow_one_add.setText(" ");
        txt_borrow_two_add.setText(" ");
        txt_borrow_three_add.setText(" ");
        txt_borrow_four_add.setText(" ");
        txt_result_one_add.setText("");
        txt_result_two_add.setText("");
        txt_result_three_add.setText("");
        txt_result_four_add.setText("");
        txt_result_five_add.setText("");

        //genarate random number based on levels
        switch(mlevel){
            case 1:
                genarateRandomLow();
                mfirstRanNumAdd = mranNumOne;
                mfifthRanNumAdd = mranNumTwo;
                txt_number_bellow_three_add.setVisibility(View.VISIBLE);
                txt_number_bellow_four_add.setVisibility(View.GONE);
                txt_number_up_one_add.setText(String.valueOf(mfirstRanNumAdd));
                txt_number_bellow_one_add.setText(String.valueOf(mfifthRanNumAdd));
                break;
            case 2:
                mfirstRanNumAdd = genarateRandom();
                mfifthRanNumAdd = genarateRandom();
                txt_number_up_one_add.setText(String.valueOf(mfirstRanNumAdd));
                txt_number_bellow_one_add.setText(String.valueOf(mfifthRanNumAdd));
                txt_number_bellow_three_add.setVisibility(View.VISIBLE);
                txt_number_bellow_four_add.setVisibility(View.GONE);
                break;
            case 3:
                txt_number_bellow_three_add.setVisibility(View.INVISIBLE);
                txt_number_bellow_four_add.setVisibility(View.VISIBLE);
                mfirstRanNumAdd = genarateRandomrange(0, 9);
                msecondRanNumAdd = genarateRandomrange(0, 9);
                mthirdRanNumAdd = genarateRandom();
                mfifthRanNumAdd = genarateRandomrange(0, 9);
                msixthRanNumAdd = genarateRandom();
                txt_number_up_one_add.setText(String.valueOf(mfirstRanNumAdd));
                txt_number_up_two_add.setText(String.valueOf(msecondRanNumAdd));
                txt_number_up_three_add.setText(String.valueOf(mthirdRanNumAdd));
                txt_number_bellow_one_add.setText(String.valueOf(mfifthRanNumAdd));
                txt_number_bellow_two_add.setText(String.valueOf(msixthRanNumAdd));
                break;
            case 4:
                txt_number_bellow_three_add.setVisibility(View.INVISIBLE);
                txt_number_bellow_four_add.setVisibility(View.VISIBLE);
                txt_number_bellow_three_add.setVisibility(View.INVISIBLE);
                txt_number_bellow_four_add.setVisibility(View.VISIBLE);
                mfirstRanNumAdd = genarateRandomrange(0, 9);
                msecondRanNumAdd = genarateRandomrange(0, 9);
                mthirdRanNumAdd = genarateRandomrange(0, 9);
                mfourthRanNumAdd=genarateRandom();
                mfifthRanNumAdd = genarateRandomrange(0, 9);
                msixthRanNumAdd = genarateRandom();
                //setting the random number
                txt_number_up_one_add.setText(String.valueOf(mfirstRanNumAdd));
                txt_number_up_two_add.setText(String.valueOf(msecondRanNumAdd));
                txt_number_up_three_add.setText(String.valueOf(mthirdRanNumAdd));
                txt_number_up_four_add.setText(String.valueOf(mfourthRanNumAdd));
                txt_number_bellow_one_add.setText(String.valueOf(mfifthRanNumAdd));
                txt_number_bellow_two_add.setText(String.valueOf(msixthRanNumAdd));
                break;
        }
    }
    //functionality for addition
    public void functionalityforAdd(int mlevel) {
        if(madditionClear) {
            if (txt_result_one_add.getText().toString().equals("")) {
                String first_column_result = String.valueOf(mfirstRanNumAdd + mfifthRanNumAdd);
                if (first_column_result.length() == 2) {
                    if (mlevel == 1 || mlevel == 2) {
                        caliculationForTwoDigitMulSuccess(txt_result_two_add,txt_result_one_add,first_column_result);

                    } else {
                        caliculationForTwoDigitMulResult(txt_borrow_two_add, txt_result_one_add, first_column_result);
                    }
                } else if (first_column_result.length() == 1) {

                    if (ApplyMath.keyNum.equals(first_column_result)) {
                        if (mlevel == 1 || mlevel == 2) {
                            caliculationOneDigitMulSucceess(txt_result_one_add, first_column_result);

                        } else {
                            caliculationOneDigitMulResult(txt_result_one_add, first_column_result);
                        }
                    } else {
                        //media no
                        mediaService(R.raw.no);
                    }
                }
            } else if (txt_result_two_add.getText().toString().equals("")) {
                int mborrow = 0;
                if (txt_borrow_two_add.getText().toString().equals(" ")) {
                    mborrow = 0;
                } else {
                    mborrow = Integer.parseInt(txt_borrow_two_add.getText().toString());
                }
                String second_column_result = String.valueOf(msecondRanNumAdd + msixthRanNumAdd + mborrow);
                if (second_column_result.length() == 2) {
                    if (mlevel == 2) {
                        caliculationForTwoDigitMulSuccess(txt_result_three_add,txt_result_two_add,second_column_result);
                    } else {
                        caliculationForTwoDigitMulResult(txt_borrow_three_add, txt_result_two_add, second_column_result);
                    }
                } else if (second_column_result.length() == 1) {
                    if (ApplyMath.keyNum.equals(second_column_result)) {
                        if (mlevel == 2) {
                            caliculationOneDigitMulSucceess(txt_result_two_add, second_column_result);
                        } else {
                            caliculationOneDigitMulResult(txt_result_two_add, second_column_result);
                        }
                    } else {
                        //media no
                        mediaService(R.raw.no);
                    }
                }
            } else if (txt_result_three_add.getText().toString().equals("")) {
                int mborrow = 0;
                if (txt_borrow_three_add.getText().toString().equals(" ")) {
                    mborrow = 0;
                } else {
                    mborrow = Integer.parseInt(txt_borrow_three_add.getText().toString());
                }
                String third_column_result = String.valueOf(mthirdRanNumAdd + mborrow);
                if (third_column_result.length() == 2) {
                    if (mlevel == 3) {
                        caliculationForTwoDigitMulSuccess(txt_result_four_add,txt_result_three_add,third_column_result);
                    } else {
                        caliculationForTwoDigitMulResult(txt_borrow_four_add, txt_result_three_add, third_column_result);
                    }
                } else if (third_column_result.length() == 1) {
                    if (ApplyMath.keyNum.equals(third_column_result)) {
                        if (mlevel == 3) {
                            caliculationOneDigitMulSucceess(txt_result_three_add, third_column_result);
                        } else {
                            caliculationOneDigitMulResult(txt_result_three_add,third_column_result);
                        }
                    } else {
                        //media no
                        mediaService(R.raw.no);
                    }
                }
            } else if (txt_result_four_add.getText().toString().equals("")) {
                int mborrow = 0;
                if (txt_borrow_four_add.getText().toString().equals(" ")) {
                    mborrow = 0;
                } else {
                    mborrow = Integer.parseInt(txt_borrow_four_add.getText().toString());
                }
                String fourth_column_result = String.valueOf(mfourthRanNumAdd + mborrow);
                if (fourth_column_result.length() == 2) {
                    if (mlevel == 4) {
                        caliculationForTwoDigitMulSuccess(txt_result_five_add,txt_result_four_add,fourth_column_result);
                    }
                } else if (fourth_column_result.length() == 1) {

                    if (ApplyMath.keyNum.equals(fourth_column_result)) {
                        caliculationOneDigitMulSucceess(txt_result_four_add, fourth_column_result);
                    } else {
                        //media no
                        mediaService(R.raw.no);
                    }
                }
            }
        }
    }
    //caliculation for one digit number
    private void caliculationOneDigitMulResult(TextView txtFirstView, String finalResult) {
        txtFirstView.setText(finalResult);
        mediaService(R.raw.yes);
    }
    //caliculation for One digit number when level complet
    private void caliculationOneDigitMulSucceess(TextView txtFirstView, String finalResult) {
        txtFirstView.setText(finalResult);
        mediaService(R.raw.sucess);
        handlerForGenarateRandom();
    }
    //caliculation for two digit number
    private void caliculationForTwoDigitMulResult(TextView txtFirstView, TextView txtSecondView, String finalResult) {
        String firstChar = String.valueOf(finalResult.charAt(0));
        String seconChar = String.valueOf(finalResult.charAt(1));
        if (txtFirstView.getText().toString().equals(" ") && ApplyMath.keyNum.equals(firstChar)) {
            txtFirstView.setText(firstChar);
            mediaService(R.raw.yes);
        } else if (!txtFirstView.getText().toString().equals(" ") && ApplyMath.keyNum.equals(seconChar)) {
            txtSecondView.setText(seconChar);
            mediaService(R.raw.yes);
        } else {
            //media no
            mediaService(R.raw.no);
        }
    }
    //caliculation for two digit number when level complet
    private void caliculationForTwoDigitMulSuccess(TextView txtFirstView, TextView txtSecondView, String finalResult) {
        String firstChar = String.valueOf(finalResult.charAt(0));
        String seconChar = String.valueOf(finalResult.charAt(1));
        if (txtFirstView.getText().toString().equals("") && ApplyMath.keyNum.equals(firstChar)) {
            txtFirstView.setText(firstChar);
            mediaService(R.raw.yes);
        } else if (!txtFirstView.getText().toString().equals("") && ApplyMath.keyNum.equals(seconChar)) {
            txtSecondView.setText(seconChar);
            mediaService(R.raw.sucess);
            handlerForGenarateRandom();
        } else {
            //media no
            mediaService(R.raw.no);
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
    //genarating Random Number bitween range
    public int genarateRandomrange(int min,int max) {
        Random r = new Random();
        int ranOne = r.nextInt(max - min + 1) + min;
        return ranOne;
    }
    //genarating Random Number
    public int genarateRandomLow() {
        int min = 1;
        int max = 7;
        Random r = new Random();
        mranNumOne = r.nextInt(max - min + 1) + min;
        mranNumTwo =  r.nextInt(max - mranNumOne + 1) + mranNumOne;
        return mranNumOne;
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

    //for displaying the panda after every 5 successfull answers
    public void displayingPanda () {

        if (ApplyMath.forPanda_apply.equals("first")) {
            ApplyMath.forPanda_apply = "second";
            visiblePanda(R.drawable.panda_one);
        } else if (ApplyMath.forPanda_apply.equals("second")) {
            ApplyMath.forPanda_apply = "third";
            visiblePanda(R.drawable.panda_two);
        } else if (ApplyMath.forPanda_apply.equals("third")) {
            ApplyMath.forPanda_apply = "first";
            visiblePanda(R.drawable.panda_three);

        }
    }

    //set visibility gone after after panda displaying
    public void refreshTheItems(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if (rl_panda.getVisibility() == View.VISIBLE) {
                    rl_panda.setVisibility(View.GONE);
                    txt_pandatext.setVisibility(View.GONE);
                }
            }
        }, 6000);
    }

    //genarate random number after success
    public void handlerForGenarateRandom(){
        madditionClear=false;
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                geanarateRandomApplyAdd();
            }
        }, 1000);
    }
    //visibility for the panda image
    public void visiblePanda(int imgPanda){
        ApplyMath.countForPanda = 0;
        rl_panda.setVisibility(View.VISIBLE);
        txt_pandatext.setVisibility(View.VISIBLE);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(img_panda);
        Glide.with(context).load(imgPanda).into(imageViewTarget);
        refreshTheItems();
    }


}
