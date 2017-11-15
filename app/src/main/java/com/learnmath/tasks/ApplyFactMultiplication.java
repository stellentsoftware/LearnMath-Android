package com.learnmath.tasks;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.TypedValue;
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
 * Created by stellent on 10/13/2017.
 */
public class ApplyFactMultiplication {
    FontChange mfont = new FontChange();
    public boolean sound_share = false,mulClear=true;
    int mlevel;
    ImageView img_panda;
    View view_two_mul;
    RelativeLayout rl_mul_final_result,rl_for_four_digits,rl_panda;
    TextView txt_pandatext,txt_number_bellow_three_mul,txt_number_bellow_four_mul,txt_number_up_four_mul,txt_borrow_four_mul,txt_borrow_three_mul,txt_number_up_three_mul,txt_borrow_two_mul,txt_number_up_two_mul,txt_borrow_one_mul,txt_number_up_one_mul,txt_number_bellow_two_mul,txt_number_bellow_one_mul,txt_result_one_mul_add,txt_borrow_six_mul_add
            ,txt_result_two_mul_add,txt_result_three_mul_add,txt_borrow_three_mul_add,txt_result_four_mul_add,txt_borrow_four_mul_add,txt_result_five_mul_add,txt_borrow_five_mul_add
            ,txt_bellow_two_mul_add,txt_bellow_three_mul_add,txt_bellow_four_mul_add,txt_bellow_five_mul_add,txt_bellow_six_mul_add,txt_final_result_one_mul,txt_final_result_two_mul
            ,txt_final_result_three_mul,txt_final_result_four_mul,txt_final_result_five_mul,txt_final_result_six_mul,txt_final_result_seven_mul,txt_bellow_one_mul_add,txt_bellow_seven_mul_add;
    private int mfirstRowRandomOneMul,mfirstRowRandomTwoMul,mfirstRowRandomThreeMul,mfirstRowRandomFourMul,msecondRowRandomOneMul,msecondRowRandomTwoMul;
    Context context;
    public ApplyFactMultiplication(Context context){
        this.context=context;
        Update();
    }
    //Calls this method when this class is called
    public void Update() {
        txt_borrow_four_mul = (TextView) ((Activity)context).findViewById(R.id.txt_borrow_four_mul);
        txt_borrow_three_mul = (TextView) ((Activity)context).findViewById(R.id.txt_borrow_three_mul);
        txt_borrow_two_mul = (TextView) ((Activity)context).findViewById(R.id.txt_borrow_two_mul);
        txt_borrow_one_mul = (TextView) ((Activity)context).findViewById(R.id.txt_borrow_one_mul);
        txt_number_up_one_mul = (TextView) ((Activity)context).findViewById(R.id.txt_number_up_one_mul);
        txt_number_up_two_mul = (TextView) ((Activity)context).findViewById(R.id.txt_number_up_two_mul);
        txt_number_up_three_mul = (TextView) ((Activity)context).findViewById(R.id.txt_number_up_three_mul);
        txt_number_up_four_mul = (TextView) ((Activity)context).findViewById(R.id.txt_number_up_four_mul);
        txt_number_bellow_one_mul = (TextView) ((Activity)context).findViewById(R.id.txt_number_bellow_one_mul);
        txt_number_bellow_two_mul = (TextView) ((Activity)context).findViewById(R.id.txt_number_bellow_two_mul);
        txt_number_bellow_three_mul = (TextView) ((Activity)context).findViewById(R.id.txt_number_bellow_three_mul);
        txt_number_bellow_four_mul = (TextView) ((Activity)context).findViewById(R.id.txt_number_bellow_four_mul);
        txt_result_five_mul_add = (TextView) ((Activity)context).findViewById(R.id.txt_result_five_mul_add);
        txt_result_four_mul_add = (TextView) ((Activity)context).findViewById(R.id.txt_result_four_mul_add);
        txt_result_three_mul_add = (TextView) ((Activity)context).findViewById(R.id.txt_result_three_mul_add);
        txt_result_two_mul_add = (TextView) ((Activity)context).findViewById(R.id.txt_result_two_mul_add);
        txt_result_one_mul_add = (TextView) ((Activity)context).findViewById(R.id.txt_result_one_mul_add);
        txt_borrow_three_mul_add = (TextView) ((Activity)context).findViewById(R.id.txt_borrow_three_mul_add);
        txt_borrow_four_mul_add = (TextView) ((Activity)context).findViewById(R.id.txt_borrow_four_mul_add);
        txt_borrow_five_mul_add = (TextView) ((Activity)context).findViewById(R.id.txt_borrow_five_mul_add);
        txt_borrow_six_mul_add = (TextView) ((Activity)context).findViewById(R.id.txt_borrow_six_mul_add);
        txt_bellow_seven_mul_add =(TextView) ((Activity)context).findViewById(R.id.txt_bellow_seven_mul_add);
        txt_bellow_one_mul_add = (TextView) ((Activity)context).findViewById(R.id.txt_bellow_one_mul_add);
        txt_bellow_two_mul_add = (TextView) ((Activity)context).findViewById(R.id.txt_bellow_two_mul_add);
        txt_bellow_three_mul_add = (TextView) ((Activity)context).findViewById(R.id.txt_bellow_three_mul_add);
        txt_bellow_four_mul_add = (TextView) ((Activity)context).findViewById(R.id.txt_bellow_four_mul_add);
        txt_bellow_five_mul_add = (TextView) ((Activity)context).findViewById(R.id.txt_bellow_five_mul_add);
        txt_bellow_six_mul_add = (TextView) ((Activity)context).findViewById(R.id.txt_bellow_six_mul_add);
        txt_final_result_one_mul = (TextView) ((Activity)context).findViewById(R.id.txt_final_result_one_mul);
        txt_final_result_two_mul = (TextView) ((Activity)context).findViewById(R.id.txt_final_result_two_mul);
        txt_final_result_three_mul = (TextView) ((Activity)context).findViewById(R.id.txt_final_result_three_mul);
        txt_final_result_four_mul = (TextView) ((Activity)context).findViewById(R.id.txt_final_result_four_mul);
        txt_final_result_five_mul = (TextView) ((Activity)context).findViewById(R.id.txt_final_result_five_mul);
        txt_final_result_six_mul = (TextView) ((Activity)context).findViewById(R.id.txt_final_result_six_mul);
        txt_final_result_seven_mul = (TextView) ((Activity)context).findViewById(R.id.txt_final_result_seven_mul);
        rl_for_four_digits = (RelativeLayout) ((Activity)context).findViewById(R.id.rl_for_four_digits);
        rl_mul_final_result = (RelativeLayout) ((Activity)context).findViewById(R.id.rl_mul_final_result);
        view_two_mul = (View) ((Activity)context).findViewById(R.id.view_two_mul);
        //for panda
        setFontStyle();
        txt_pandatext = (TextView) ((Activity)context).findViewById(R.id.txt_pandatext);
        img_panda = (ImageView) ((Activity)context).findViewById(R.id.img_panda);
        rl_panda =  (RelativeLayout) ((Activity)context).findViewById(R.id.rl_panda);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        mlevel = Integer.parseInt(prefs.getString("level", "1"));
        sound_share = prefs.getBoolean("sound", true);
   }
   //Setting font style for the text views
    private void setFontStyle() {
        mfont.fontChange(txt_borrow_four_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_borrow_three_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_borrow_two_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_borrow_one_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_number_up_one_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_number_up_two_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_number_up_three_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_number_up_four_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_number_bellow_one_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_number_bellow_two_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_number_bellow_three_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_number_bellow_four_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_result_five_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_result_four_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_result_three_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_result_two_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_result_one_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_borrow_three_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_borrow_four_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_borrow_five_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_borrow_six_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_bellow_seven_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_bellow_one_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_bellow_two_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_bellow_three_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_bellow_four_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_bellow_five_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_bellow_six_mul_add, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_final_result_one_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_final_result_two_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_final_result_three_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_final_result_four_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_final_result_five_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_final_result_six_mul, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_final_result_seven_mul, "fonts/textFont.ttf", ((Activity) context));

    }
    //generate random number for multiplication
    public void geanarateRandomApplyMul() {
        if(ApplyMath.fromFirst) {
            ApplyMath.fromFirst =false;
            ApplyMath.countForPanda =0;
        }else {
            ApplyMath.countForPanda++;
        }
        mulClear=true;
        //Calling the panda for displaying the image
        if (ApplyMath.countForPanda == 5) {
            displayingPanda();
        }
        //Empty the views before setting the value
        txt_number_up_one_mul.setText("");
        txt_number_up_two_mul.setText("");
        txt_number_up_three_mul.setText("");
        txt_number_up_four_mul.setText("");
        txt_number_bellow_two_mul.setText("");
        txt_number_bellow_one_mul.setText("");
        txt_borrow_one_mul.setText(" ");
        txt_borrow_two_mul.setText(" ");
        txt_borrow_three_mul.setText(" ");
        txt_borrow_four_mul.setText(" ");
        txt_borrow_three_mul_add.setText(" ");
        txt_borrow_four_mul_add.setText(" ");
        txt_borrow_five_mul_add.setText(" ");
        txt_borrow_six_mul_add.setText(" ");
        txt_result_one_mul_add.setText("");
        txt_result_two_mul_add.setText("");
        txt_result_three_mul_add.setText("");
        txt_result_four_mul_add.setText("");
        txt_result_five_mul_add.setText("");
        txt_bellow_two_mul_add.setText("");
        txt_bellow_three_mul_add.setText("");
        txt_bellow_four_mul_add.setText("");
        txt_bellow_five_mul_add.setText("");
        txt_bellow_six_mul_add.setText("");
        txt_final_result_one_mul.setText("");
        txt_final_result_two_mul.setText("");
        txt_final_result_three_mul.setText("");
        txt_final_result_four_mul.setText("");
        txt_final_result_five_mul.setText("");
        txt_final_result_six_mul.setText("");
        txt_final_result_seven_mul.setText("");

        switch(mlevel){

            case 4:
                //Generate random for level four
                mfirstRowRandomOneMul = genarateRandomrange(0, 9);
                mfirstRowRandomTwoMul = genarateRandomrange(0, 9);
                mfirstRowRandomThreeMul = genarateRandomrange(0, 9);
                mfirstRowRandomFourMul =genarateRandom();
                msecondRowRandomOneMul = genarateRandom();
                msecondRowRandomTwoMul = genarateRandomrange(0,9);
                //setting the random number
                txt_number_up_one_mul.setText(String.valueOf(mfirstRowRandomOneMul));
                txt_number_up_two_mul.setText(String.valueOf(mfirstRowRandomTwoMul));
                txt_number_up_three_mul.setText(String.valueOf(mfirstRowRandomThreeMul));
                txt_number_up_four_mul.setText(String.valueOf(mfirstRowRandomFourMul));
                txt_number_bellow_one_mul.setText(String.valueOf(msecondRowRandomOneMul));
                txt_number_bellow_two_mul.setText(String.valueOf(msecondRowRandomTwoMul));
                rl_mul_final_result.setVisibility(View.INVISIBLE);
                txt_bellow_one_mul_add.setVisibility(View.INVISIBLE);
                txt_bellow_seven_mul_add.setVisibility(View.INVISIBLE);
                view_two_mul.setVisibility(View.INVISIBLE);
                break;
            default:
                if(mlevel == 1 ){
                //Generate random for level one and two
                    mfirstRowRandomOneMul = genarateRandomrange(1, 6);
                    msecondRowRandomOneMul = genarateRandomrange(1,5);
                txt_number_up_one_mul.setText(String.valueOf(mfirstRowRandomOneMul));
                txt_number_bellow_one_mul.setText(String.valueOf(msecondRowRandomOneMul));

            }else if(mlevel == 2){

                    mfirstRowRandomOneMul =genarateRandom();
                    msecondRowRandomOneMul = genarateRandom();
                txt_number_up_one_mul.setText(String.valueOf(mfirstRowRandomOneMul));
                txt_number_bellow_one_mul.setText(String.valueOf(msecondRowRandomOneMul));
            }else if(mlevel == 3){
                //Generate random for level three
                    mfirstRowRandomOneMul = genarateRandomrange(0, 9);
                    mfirstRowRandomTwoMul = genarateRandomrange(0, 9);
                    mfirstRowRandomThreeMul = genarateRandom();
                    msecondRowRandomOneMul = genarateRandom();
                txt_number_up_one_mul.setText(String.valueOf(mfirstRowRandomOneMul));
                txt_number_up_two_mul.setText(String.valueOf(mfirstRowRandomTwoMul));
                txt_number_up_three_mul.setText(String.valueOf(mfirstRowRandomThreeMul));
                txt_number_bellow_one_mul.setText(String.valueOf(msecondRowRandomOneMul));
            }

                //Increase the size of the textviews
                txt_number_up_one_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_two_apply_facts));
                txt_number_up_two_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_two_apply_facts));
                txt_number_up_three_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_two_apply_facts));
                txt_number_up_four_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_two_apply_facts));
                txt_number_bellow_two_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_two_apply_facts));
                txt_number_bellow_one_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_two_apply_facts));
                txt_number_bellow_three_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_two_apply_facts));
                txt_number_bellow_four_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_two_apply_facts));
                txt_borrow_one_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_apply_facts));
                txt_borrow_two_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_apply_facts));
                txt_borrow_three_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_apply_facts));
                txt_borrow_four_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_apply_facts));
                txt_final_result_one_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_two_apply_facts));
                txt_final_result_two_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_two_apply_facts));
                txt_final_result_three_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_two_apply_facts));
                txt_final_result_four_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_two_apply_facts));
                txt_final_result_five_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_two_apply_facts));
                txt_final_result_six_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_two_apply_facts));
                txt_final_result_seven_mul.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        context.getResources().getDimension(R.dimen.text_size_two_apply_facts));
                txt_final_result_seven_mul.setVisibility(View.GONE);
                txt_final_result_six_mul.setVisibility(View.GONE);
                txt_number_bellow_four_mul.setVisibility(View.GONE);
                txt_number_bellow_three_mul.setVisibility(View.VISIBLE);
                rl_for_four_digits.setVisibility(View.GONE);
                break;
        }
    }

    //Functionality for multiplication
    public void functionalityforMul() {
        if(mulClear){
        String firstRowFirst_cal= String.valueOf(mfirstRowRandomOneMul * msecondRowRandomOneMul);
        //Checking conditions for multiplication
        if(mlevel!=4) {
            if (txt_final_result_one_mul.getText().toString().equals("")) {
                if (firstRowFirst_cal.length() == 2) {

                    if (mlevel == 1 || mlevel == 2) {
                        caliculationForTwoDigitSuccessResult(txt_final_result_two_mul, txt_final_result_one_mul, firstRowFirst_cal);

                    }  else {
                        caliculationForTwoDigitResult(txt_borrow_two_mul,txt_final_result_one_mul,firstRowFirst_cal);

                    }
                } else if (firstRowFirst_cal.length() == 1) {
                    if (ApplyMath.keyNum.equals(firstRowFirst_cal)) {
                        if (mlevel == 1 || mlevel ==2) {
                            caliculationForOneDigitSuccessResult(txt_final_result_one_mul, firstRowFirst_cal);

                            txt_final_result_one_mul.setText(firstRowFirst_cal);
                            mediaService(R.raw.sucess);
                            handlerForGenarateRandom();

                        }  else {
                            txt_final_result_one_mul.setText(firstRowFirst_cal);
                            mediaService(R.raw.yes);
                        }
                    } else {
                        //Media no
                        mediaService(R.raw.no);
                    }
                }
            } else if(txt_final_result_two_mul.getText().toString().equals("")) {
                int mborrow = 0;
                if (txt_borrow_two_mul.getText().toString().equals(" ")) {
                    mborrow = 0;
                } else {
                    mborrow = Integer.parseInt(txt_borrow_two_mul.getText().toString());
                }
                String firstRowSecond_cal = String.valueOf(msecondRowRandomOneMul * mfirstRowRandomTwoMul + mborrow);
                if (firstRowSecond_cal.length() == 2) {

                    if (mlevel == 2) {
                        caliculationForTwoDigitSuccessResult(txt_final_result_three_mul, txt_final_result_two_mul, firstRowSecond_cal);


                    }  else {
                        caliculationForTwoDigitResult(txt_borrow_three_mul,txt_final_result_two_mul,firstRowSecond_cal);
                    }
                } else if (firstRowSecond_cal.length() == 1) {
                    if (ApplyMath.keyNum.equals(firstRowSecond_cal)) {
                        if (mlevel == 2) {
                            caliculationForOneDigitSuccessResult(txt_final_result_three_mul, firstRowSecond_cal);
                                                }
                        else {
                            txt_final_result_two_mul.setText(firstRowSecond_cal);
                            mediaService(R.raw.yes);
                        }
                    } else {
                        //media no
                        mediaService(R.raw.no);
                    }
                }
            }else if(txt_final_result_three_mul.getText().toString().equals("")){
                int mborrow =0;
                if(txt_borrow_three_mul.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_three_mul.getText().toString());
                }
                String firstRowThird_cal=String.valueOf(mfirstRowRandomThreeMul*msecondRowRandomOneMul+mborrow);
                if (firstRowThird_cal.length() == 2) {

                    if(mlevel == 3){
                        caliculationForTwoDigitSuccessResult(txt_final_result_four_mul, txt_final_result_three_mul, firstRowThird_cal);


                    }else {
                        caliculationForTwoDigitResult(txt_borrow_four_mul,txt_final_result_three_mul,firstRowThird_cal);

                    }
                } else if (firstRowThird_cal.length() == 1) {
                    if (ApplyMath.keyNum.equals(firstRowThird_cal)) {
                        if(mlevel == 3){
                            caliculationForOneDigitSuccessResult(txt_final_result_three_mul, firstRowThird_cal);
                        }else {
                            txt_final_result_three_mul.setText(firstRowThird_cal);
                            mediaService(R.raw.yes);
                        }
                    } else {
                        //Media no
                        mediaService(R.raw.no);
                    }
                }
           }
        }else{
            if (txt_result_one_mul_add.getText().toString().equals("")) {
                if (firstRowFirst_cal.length() == 2) {
                    String firstChar = String.valueOf(firstRowFirst_cal.charAt(0));
                    String seconChar = String.valueOf(firstRowFirst_cal.charAt(1));
                    if (txt_borrow_two_mul.getText().toString().equals(" ") && ApplyMath.keyNum.equals(firstChar)) {
                        txt_borrow_two_mul.setText(firstChar);
                        mediaService(R.raw.yes);
                    } else if (!txt_borrow_two_mul.getText().toString().equals(" ")&& ApplyMath.keyNum.equals(seconChar)) {
                        txt_result_one_mul_add.setText(seconChar);
                        mediaService(R.raw.yes);
                    } else {
                        //Media no
                        mediaService(R.raw.no);
                    }
                } else if (firstRowFirst_cal.length() == 1) {
                    caliculationForOneDigitResult(txt_result_one_mul_add, firstRowFirst_cal);


                }
            }else if(txt_result_two_mul_add.getText().toString().equals("")) {
                int mborrow = 0;
                if (txt_borrow_two_mul.getText().toString().equals(" ")) {
                    mborrow = 0;
                } else {
                    mborrow = Integer.parseInt(txt_borrow_two_mul.getText().toString());
                }
                String firstRowSecond_cal = String.valueOf(msecondRowRandomOneMul * mfirstRowRandomTwoMul + mborrow);
                if (firstRowSecond_cal.length() == 2) {

                    caliculationForTwoDigitResult(txt_borrow_three_mul,txt_result_two_mul_add,firstRowSecond_cal);

                } else if (firstRowSecond_cal.length() == 1) {
                    caliculationForOneDigitResult(txt_result_two_mul_add, firstRowSecond_cal);

                }
            }else if(txt_result_three_mul_add.getText().toString().equals("")){
                int mborrow =0;
                if(txt_borrow_three_mul.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_three_mul.getText().toString());
                }
                String firstRowThird_cal=String.valueOf(mfirstRowRandomThreeMul*msecondRowRandomOneMul+mborrow);
                if (firstRowThird_cal.length() == 2) {

                    caliculationForTwoDigitResult(txt_borrow_four_mul,txt_result_three_mul_add,firstRowThird_cal);

                } else if (firstRowThird_cal.length() == 1) {
                    caliculationForOneDigitResult(txt_result_three_mul_add, firstRowThird_cal);

                }
            }else if(txt_result_four_mul_add.getText().toString().equals("")){
                int mborrow =0;
                if(txt_borrow_four_mul.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_four_mul.getText().toString());
                }
                String firstRowFourth_cal=String.valueOf(mfirstRowRandomFourMul*msecondRowRandomOneMul+mborrow);
                if (firstRowFourth_cal.length() == 2) {
                    String firstChar = String.valueOf(firstRowFourth_cal.charAt(0));
                    String seconChar = String.valueOf(firstRowFourth_cal.charAt(1));
                    if (txt_result_five_mul_add.getText().toString().equals("") && ApplyMath.keyNum.equals(firstChar)) {
                        txt_result_five_mul_add.setText(firstChar);
                        mediaService(R.raw.yes);
                    } else if (!txt_result_five_mul_add.getText().toString().equals("")&& ApplyMath.keyNum.equals(seconChar)) {
                        txt_result_four_mul_add.setText(seconChar);
                        mediaService(R.raw.yes);
                        txt_borrow_one_mul.setText(" ");
                        txt_borrow_two_mul.setText(" ");
                        txt_borrow_three_mul.setText(" ");
                        txt_borrow_four_mul.setText(" ");
                        txt_bellow_one_mul_add.setVisibility(View.VISIBLE);
                    } else {
                        //Media no
                        mediaService(R.raw.no);
                    }
                } else if (firstRowFourth_cal.length() == 1) {
                    if (ApplyMath.keyNum.equals(firstRowFourth_cal)) {
                        txt_result_four_mul_add.setText(firstRowFourth_cal);
                        mediaService(R.raw.yes);
                        txt_borrow_one_mul.setText(" ");
                        txt_borrow_two_mul.setText(" ");
                        txt_borrow_three_mul.setText(" ");
                        txt_borrow_four_mul.setText(" ");
                        txt_bellow_one_mul_add.setVisibility(View.VISIBLE);
                    } else {
                        //Media no
                        mediaService(R.raw.no);
                    }
                }
            }else if(txt_bellow_two_mul_add.getText().toString().equals("")){
                String secondRowFirst_cal=String.valueOf(mfirstRowRandomOneMul*msecondRowRandomTwoMul);
                if (secondRowFirst_cal.length() == 2) {
                  caliculationForTwoDigitResult(txt_borrow_two_mul,txt_bellow_two_mul_add,secondRowFirst_cal);

                } else if (secondRowFirst_cal.length() == 1) {
                    if (ApplyMath.keyNum.equals(secondRowFirst_cal)) {
                        txt_bellow_two_mul_add.setText(secondRowFirst_cal);
                        mediaService(R.raw.yes);
                    } else {
                        //Media no
                        mediaService(R.raw.no);
                    }
                }
            }else if(txt_bellow_three_mul_add.getText().toString().equals("")){
                int mborrow =0;
                if(txt_borrow_two_mul.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_two_mul.getText().toString());
                }
                String secondRowSecond_cal=String.valueOf(mfirstRowRandomTwoMul*msecondRowRandomTwoMul+mborrow);
                if (secondRowSecond_cal.length() == 2) {
                    caliculationForTwoDigitResult(txt_borrow_three_mul,txt_bellow_three_mul_add,secondRowSecond_cal);

                } else if (secondRowSecond_cal.length() == 1) {
                    caliculationForOneDigitResult(txt_bellow_three_mul_add, secondRowSecond_cal);

                }

            }else if(txt_bellow_four_mul_add.getText().toString().equals("")){
                int mborrow =0;
                if(txt_borrow_three_mul.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_three_mul.getText().toString());
                }
                String secondRowThird_cal=String.valueOf(mfirstRowRandomThreeMul*msecondRowRandomTwoMul+mborrow);
                if (secondRowThird_cal.length() == 2) {
                    caliculationForTwoDigitResult(txt_borrow_four_mul,txt_bellow_four_mul_add,secondRowThird_cal);

                } else if (secondRowThird_cal.length() == 1) {
                    caliculationForOneDigitResult(txt_bellow_four_mul_add, secondRowThird_cal);

                }
            }else if(txt_bellow_five_mul_add.getText().toString().equals("")){
                int mborrow =0;
                if(txt_borrow_four_mul.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_four_mul.getText().toString());
                }
                String secondRowFourth_cal=String.valueOf(mfirstRowRandomFourMul*msecondRowRandomTwoMul+mborrow);
                if (secondRowFourth_cal.length() == 2) {

                    String firstChar = String.valueOf(secondRowFourth_cal.charAt(0));
                    String seconChar = String.valueOf(secondRowFourth_cal.charAt(1));
                    if (txt_bellow_six_mul_add.getText().toString().equals("") && ApplyMath.keyNum.equals(firstChar)) {
                        mediaService(R.raw.yes);
                        txt_bellow_six_mul_add.setText(firstChar);
                    } else if (!txt_bellow_six_mul_add.getText().toString().equals("")&& ApplyMath.keyNum.equals(seconChar)) {
                        mediaService(R.raw.yes);
                        txt_bellow_five_mul_add.setText(seconChar);
                        txt_bellow_seven_mul_add.setVisibility(View.VISIBLE);
                        view_two_mul.setVisibility(View.VISIBLE);
                        rl_mul_final_result.setVisibility(View.VISIBLE);
                    } else {
                        //Media no
                        mediaService(R.raw.no);
                    }
                } else if (secondRowFourth_cal.length() == 1) {
                    if (ApplyMath.keyNum.equals(secondRowFourth_cal)) {
                        txt_bellow_five_mul_add.setText(secondRowFourth_cal);
                        txt_bellow_seven_mul_add.setVisibility(View.VISIBLE);
                        view_two_mul.setVisibility(View.VISIBLE);
                        rl_mul_final_result.setVisibility(View.VISIBLE);
                        mediaService(R.raw.yes);
                    } else {
                        //Media no
                        mediaService(R.raw.no);
                    }
                }
            }else if(txt_final_result_one_mul.getText().toString().equals("")){
                String finalResultMul_one = txt_result_one_mul_add.getText().toString();
                if(ApplyMath.keyNum.equals(finalResultMul_one)){
                    txt_final_result_one_mul.setText(finalResultMul_one);
                    mediaService(R.raw.yes);
                } else {
                    //Media no
                    mediaService(R.raw.no);
                }
            }else if(txt_final_result_two_mul.getText().toString().equals("")){
                int getFirstNumber =Integer.parseInt(txt_result_two_mul_add.getText().toString());
                int getSecondNumber = Integer.parseInt(txt_bellow_two_mul_add.getText().toString());
                String final_for_second_digit_mul = String.valueOf(getFirstNumber + getSecondNumber);
                if(final_for_second_digit_mul.length() == 2){
                    caliculationForTwoDigitResult(txt_borrow_three_mul_add,txt_final_result_two_mul,final_for_second_digit_mul);
                }else if(final_for_second_digit_mul.length() == 1){
                    caliculationForOneDigitResult(txt_final_result_two_mul, final_for_second_digit_mul);
                }
            }else if(txt_final_result_three_mul.getText().toString().equals("")){
                int getFirstNumber =Integer.parseInt(txt_result_three_mul_add.getText().toString());
                int getSecondNumber = Integer.parseInt(txt_bellow_three_mul_add.getText().toString());
                int mborrow =0;
                if(txt_borrow_three_mul_add.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_three_mul_add.getText().toString());
                }
                String final_for_third_digit_mul = String.valueOf(getFirstNumber + getSecondNumber+mborrow);
                if(final_for_third_digit_mul.length() == 2){
                    caliculationForTwoDigitResult(txt_borrow_four_mul_add,txt_final_result_three_mul,final_for_third_digit_mul);

                }else if(final_for_third_digit_mul.length() == 1){
                    caliculationForOneDigitResult(txt_final_result_three_mul, final_for_third_digit_mul);
                }
            }else if(txt_final_result_four_mul.getText().toString().equals("")){
                int getFirstNumber =Integer.parseInt(txt_result_four_mul_add.getText().toString());
                int getSecondNumber = Integer.parseInt(txt_bellow_four_mul_add.getText().toString());
                int mborrow =0;
                if(txt_borrow_four_mul_add.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_four_mul_add.getText().toString());
                }
                String final_for_fourth_digit_mul = String.valueOf(getFirstNumber + getSecondNumber+mborrow);
                if(final_for_fourth_digit_mul.length() == 2){
                    caliculationForTwoDigitResult(txt_borrow_five_mul_add,txt_final_result_four_mul,final_for_fourth_digit_mul);

                }else if(final_for_fourth_digit_mul.length() == 1){
                    caliculationForOneDigitResult(txt_final_result_four_mul, final_for_fourth_digit_mul);
                }
            }else if(txt_final_result_five_mul.getText().toString().equals("")){
                int getFirstNumber =0;
                if(txt_result_five_mul_add.getText().toString().equals("")){
                    getFirstNumber = 0;
                }else {
                    getFirstNumber = Integer.parseInt(txt_result_five_mul_add.getText().toString());
                }
                int getSecondNumber = Integer.parseInt(txt_bellow_five_mul_add.getText().toString());
                int mborrow =0;
                if(txt_borrow_five_mul_add.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_five_mul_add.getText().toString());
                }
                String final_for_fifth_digit_mul = String.valueOf(getFirstNumber + getSecondNumber+mborrow);
                if(final_for_fifth_digit_mul.length() == 2){
                    if(!txt_bellow_six_mul_add.getText().toString().equals("")) {
                        caliculationForTwoDigitResult(txt_borrow_six_mul_add,txt_final_result_five_mul,final_for_fifth_digit_mul);

                    }else{
                        caliculationForTwoDigitSuccessResult(txt_final_result_six_mul, txt_final_result_five_mul,final_for_fifth_digit_mul);


                    }
                }else if(final_for_fifth_digit_mul.length() == 1){
                    if(ApplyMath.keyNum.equals(final_for_fifth_digit_mul)){
                        if(!txt_bellow_six_mul_add.getText().toString().equals("")) {
                            txt_final_result_five_mul.setText(final_for_fifth_digit_mul);
                            mediaService(R.raw.yes);
                        }else {
                            txt_final_result_five_mul.setText(final_for_fifth_digit_mul);
                            mediaService(R.raw.sucess);
                            handlerForGenarateRandom();

                        }
                    }else{
                        mediaService(R.raw.no);
                    }
                }
            }else if(txt_final_result_six_mul.getText().toString().equals("")){
                int getSecondNumber =0;
                if(txt_bellow_six_mul_add.getText().toString().equals("")){
                    getSecondNumber = 0;
                }else {
                    getSecondNumber = Integer.parseInt(txt_bellow_six_mul_add.getText().toString());
                }
                int mborrow =0;
                if(txt_borrow_six_mul_add.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_six_mul_add.getText().toString());
                }
                String final_for_six_digit_mul = String.valueOf( getSecondNumber+mborrow);
                if(final_for_six_digit_mul.length() == 2){
                    caliculationForTwoDigitSuccessResult(txt_final_result_seven_mul, txt_final_result_six_mul, final_for_six_digit_mul);

                }else if(final_for_six_digit_mul.length() == 1){
                    if(ApplyMath.keyNum.equals(final_for_six_digit_mul)){
                        txt_final_result_six_mul.setText(final_for_six_digit_mul);
                        mediaService(R.raw.sucess);
                        handlerForGenarateRandom();
                    }else{
                        mediaService(R.raw.no);

                    }
                }else{
                    mediaService(R.raw.no);
                }
            }
        }
    }
    }
// Calculation for one digit number
    private void caliculationForOneDigitResult(TextView txtOneDigitView, String finalResult) {
        if (ApplyMath.keyNum.equals(finalResult)) {
            txtOneDigitView.setText(finalResult);
            mediaService(R.raw.yes);
        } else {
            //media no
            mediaService(R.raw.no);
        }
    }
// Calculation for one digit number after mlevel complete
    private void caliculationForOneDigitSuccessResult(TextView txtOneDigitView, String finalResult) {
        txtOneDigitView.setText(finalResult);
        mediaService(R.raw.sucess);
        handlerForGenarateRandom();
    }
// Calculation for two digit number after
    private void caliculationForTwoDigitResult(TextView txtfirstView, TextView txtSecondView, String fianlString) {
        String firstChar = String.valueOf(fianlString.charAt(0));
        String seconChar = String.valueOf(fianlString.charAt(1));
        if (txtfirstView.getText().toString().equals(" ") && ApplyMath.keyNum.equals(firstChar)) {
            txtfirstView.setText(firstChar);
            mediaService(R.raw.yes);
        } else if (!txtfirstView.getText().toString().equals(" ")&& ApplyMath.keyNum.equals(seconChar)) {
            txtSecondView.setText(seconChar);
            mediaService(R.raw.yes);
        } else {
            //Media no
            mediaService(R.raw.no);
        }

    }
// Calculation for two digit number after level complete
    private void caliculationForTwoDigitSuccessResult(TextView txtFirstView, TextView txtSecondView,String fianlString) {
        String firstChar = String.valueOf(fianlString.charAt(0));
        String seconChar = String.valueOf(fianlString.charAt(1));
        if (txtFirstView.getText().toString().equals("") && ApplyMath.keyNum.equals(firstChar)) {
            txtFirstView.setText(firstChar);
            mediaService(R.raw.yes);
        } else if (!txtFirstView.getText().toString().equals("")&& ApplyMath.keyNum.equals(seconChar)) {
            txtSecondView.setText(seconChar);
            mediaService(R.raw.sucess);
            handlerForGenarateRandom();

        } else {
            //media no
            mediaService(R.raw.no);
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
    //Generate random number between range
    public int genarateRandomrange(int min,int max) {

        Random r = new Random();
        int ranOne = r.nextInt(max - min + 1) + min;
        return ranOne;
    }


    //For playing the sounds
    public void mediaService(int raw) {

        if(sound_share) {
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

    //Functionality for displaying panda
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

// Set visibility gone after after panda displaying

    public void handlerForPanda(){
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
    //Generate random number after success
    public void handlerForGenarateRandom(){
        mulClear=false;
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                geanarateRandomApplyMul();
            }
        }, 1000);
    }
    //Setting visibility for the panda
    public void visiblePanda(int imgPanda){
        ApplyMath.countForPanda = 0;
        rl_panda.setVisibility(View.VISIBLE);
        txt_pandatext.setVisibility(View.VISIBLE);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(img_panda);
        Glide.with(context).load(imgPanda).into(imageViewTarget);
        handlerForPanda();
    }
}
