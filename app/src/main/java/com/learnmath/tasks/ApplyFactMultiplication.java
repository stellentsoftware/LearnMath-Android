package com.learnmath.Tasks;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.learnmath.R;
import com.learnmath.Fragments.ApplyMath;
import com.learnmath.Utils.FontChange;
import com.learnmath.Utils.Util;

import java.util.Random;

/**
 * Created by stellent on 10/13/2017.
 */
public class ApplyFactMultiplication {
    FontChange mfont = new FontChange();
    Util util=new Util();
    public boolean msoundShare = false,mulClear=true;
    public int mlevel;
    ImageView img_panda;
    View view_two_mul;
    RelativeLayout rl_mul_final_result,rl_for_four_digits,rl_panda;
    TextView txt_pandatext,txt_number_bellow_three_mul,txt_number_bellow_four_mul,txt_number_up_four_mul,txt_borrow_four_mul,txt_borrow_three_mul,txt_number_up_three_mul,txt_borrow_two_mul,txt_number_up_two_mul,txt_borrow_one_mul,txt_number_up_one_mul,txt_number_bellow_two_mul,txt_number_bellow_one_mul,txt_result_one_mul_add,txt_borrow_six_mul_add
            ,txt_result_two_mul_add,txt_result_three_mul_add,txt_borrow_three_mul_add,txt_result_four_mul_add,txt_borrow_four_mul_add,txt_result_five_mul_add,txt_borrow_five_mul_add
            ,txt_bellow_two_mul_add,txt_bellow_three_mul_add,txt_bellow_four_mul_add,txt_bellow_five_mul_add,txt_bellow_six_mul_add,txt_final_result_one_mul,txt_final_result_two_mul
            ,txt_final_result_three_mul,txt_final_result_four_mul,txt_final_result_five_mul,txt_final_result_six_mul,txt_final_result_seven_mul,txt_bellow_one_mul_add,txt_bellow_seven_mul_add;
    public int mfirstRowRandomOneMul,mfirstRowRandomTwoMul,mfirstRowRandomThreeMul,mfirstRowRandomFourMul,msecondRowRandomOneMul,msecondRowRandomTwoMul;
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
        msoundShare = prefs.getBoolean("sound", true);
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
    public void functionalityforMul(String keyNum) {
        Log.e("random values"+mfirstRowRandomOneMul+msecondRowRandomOneMul,"res");
        if(mulClear){
        String mfirstRowFirstCal= String.valueOf(mfirstRowRandomOneMul * msecondRowRandomOneMul);
            Log.e("random values"+mfirstRowRandomOneMul+msecondRowRandomOneMul,"res"+mfirstRowFirstCal);
        //Checking conditions for multiplication
        if(mlevel!=4) {
            if (txt_final_result_one_mul.getText().toString().equals("")) {
                if (mfirstRowFirstCal.length() == 2) {

                    if (mlevel == 1 || mlevel == 2) {
                        caliculationForTwoDigitSuccessResult(txt_final_result_two_mul, txt_final_result_one_mul, mfirstRowFirstCal,keyNum);

                    }  else {
                        caliculationForTwoDigitResult(txt_borrow_two_mul,txt_final_result_one_mul,mfirstRowFirstCal,keyNum);

                    }
                } else if (mfirstRowFirstCal.length() == 1) {
                    if (keyNum.equals(mfirstRowFirstCal)) {
                        if (mlevel == 1 || mlevel ==2) {
                            caliculationForOneDigitSuccessResult(txt_final_result_one_mul, mfirstRowFirstCal);

                            txt_final_result_one_mul.setText(mfirstRowFirstCal);
                           util.mediaService(((Activity) context),R.raw.sucess,msoundShare);
                            handlerForGenarateRandom();

                        }  else {
                            txt_final_result_one_mul.setText(mfirstRowFirstCal);
                           util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                        }
                    } else {
                       util.mediaService(((Activity) context),R.raw.no,msoundShare);
                    }
                }
            } else if(txt_final_result_two_mul.getText().toString().equals("")) {
                int mborrow = 0;
                if (txt_borrow_two_mul.getText().toString().equals(" ")) {
                    mborrow = 0;
                } else {
                    mborrow = Integer.parseInt(txt_borrow_two_mul.getText().toString());
                }
                String mfirstRowSecondCal = String.valueOf(msecondRowRandomOneMul * mfirstRowRandomTwoMul + mborrow);
                if (mfirstRowSecondCal.length() == 2) {

                    if (mlevel == 2) {
                        caliculationForTwoDigitSuccessResult(txt_final_result_three_mul, txt_final_result_two_mul, mfirstRowSecondCal,keyNum);


                    }  else {
                        caliculationForTwoDigitResult(txt_borrow_three_mul,txt_final_result_two_mul,mfirstRowSecondCal,keyNum);
                    }
                } else if (mfirstRowSecondCal.length() == 1) {
                    if (keyNum.equals(mfirstRowSecondCal)) {
                        if (mlevel == 2) {
                            caliculationForOneDigitSuccessResult(txt_final_result_three_mul, mfirstRowSecondCal);
                                                }
                        else {
                            txt_final_result_two_mul.setText(mfirstRowSecondCal);
                           util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                        }
                    } else {
                       util.mediaService(((Activity) context),R.raw.no,msoundShare);
                    }
                }
            }else if(txt_final_result_three_mul.getText().toString().equals("")){
                int mborrow =0;
                if(txt_borrow_three_mul.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_three_mul.getText().toString());
                }
                String mfirstRowThirdCal=String.valueOf(mfirstRowRandomThreeMul*msecondRowRandomOneMul+mborrow);
                if (mfirstRowThirdCal.length() == 2) {

                    if(mlevel == 3){
                        caliculationForTwoDigitSuccessResult(txt_final_result_four_mul, txt_final_result_three_mul, mfirstRowThirdCal,keyNum);


                    }else {
                        caliculationForTwoDigitResult(txt_borrow_four_mul,txt_final_result_three_mul,mfirstRowThirdCal,keyNum);

                    }
                } else if (mfirstRowThirdCal.length() == 1) {
                    if (keyNum.equals(mfirstRowThirdCal)) {
                        if(mlevel == 3){
                            caliculationForOneDigitSuccessResult(txt_final_result_three_mul, mfirstRowThirdCal);
                        }else {
                            txt_final_result_three_mul.setText(mfirstRowThirdCal);
                           util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                        }
                    } else {
                       util.mediaService(((Activity) context),R.raw.no,msoundShare);
                    }
                }
           }
        }else{
            if (txt_result_one_mul_add.getText().toString().equals("")) {
                if (mfirstRowFirstCal.length() == 2) {
                    String firstChar = String.valueOf(mfirstRowFirstCal.charAt(0));
                    String seconChar = String.valueOf(mfirstRowFirstCal.charAt(1));
                    if (txt_borrow_two_mul.getText().toString().equals(" ") && keyNum.equals(firstChar)) {
                        txt_borrow_two_mul.setText(firstChar);
                       util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                    } else if (!txt_borrow_two_mul.getText().toString().equals(" ")&& keyNum.equals(seconChar)) {
                        txt_result_one_mul_add.setText(seconChar);
                       util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                    } else {
                       util.mediaService(((Activity) context),R.raw.no,msoundShare);
                    }
                } else if (mfirstRowFirstCal.length() == 1) {
                    caliculationForOneDigitResult(txt_result_one_mul_add, mfirstRowFirstCal,keyNum);


                }
            }else if(txt_result_two_mul_add.getText().toString().equals("")) {
                int mborrow = 0;
                if (txt_borrow_two_mul.getText().toString().equals(" ")) {
                    mborrow = 0;
                } else {
                    mborrow = Integer.parseInt(txt_borrow_two_mul.getText().toString());
                }
                String mfirstRowSecondCal = String.valueOf(msecondRowRandomOneMul * mfirstRowRandomTwoMul + mborrow);
                if (mfirstRowSecondCal.length() == 2) {

                    caliculationForTwoDigitResult(txt_borrow_three_mul,txt_result_two_mul_add,mfirstRowSecondCal,keyNum);

                } else if (mfirstRowSecondCal.length() == 1) {
                    caliculationForOneDigitResult(txt_result_two_mul_add, mfirstRowSecondCal,keyNum);

                }
            }else if(txt_result_three_mul_add.getText().toString().equals("")){
                int mborrow =0;
                if(txt_borrow_three_mul.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_three_mul.getText().toString());
                }
                String mfirstRowThirdCal=String.valueOf(mfirstRowRandomThreeMul*msecondRowRandomOneMul+mborrow);
                if (mfirstRowThirdCal.length() == 2) {

                    caliculationForTwoDigitResult(txt_borrow_four_mul,txt_result_three_mul_add,mfirstRowThirdCal,keyNum);

                } else if (mfirstRowThirdCal.length() == 1) {
                    caliculationForOneDigitResult(txt_result_three_mul_add, mfirstRowThirdCal,keyNum);

                }
            }else if(txt_result_four_mul_add.getText().toString().equals("")){
                int mborrow =0;
                if(txt_borrow_four_mul.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_four_mul.getText().toString());
                }
                String mfirstRowFourthCal=String.valueOf(mfirstRowRandomFourMul*msecondRowRandomOneMul+mborrow);
                if (mfirstRowFourthCal.length() == 2) {
                    String firstChar = String.valueOf(mfirstRowFourthCal.charAt(0));
                    String seconChar = String.valueOf(mfirstRowFourthCal.charAt(1));
                    if (txt_result_five_mul_add.getText().toString().equals("") && keyNum.equals(firstChar)) {
                        txt_result_five_mul_add.setText(firstChar);
                       util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                    } else if (!txt_result_five_mul_add.getText().toString().equals("")&& keyNum.equals(seconChar)) {
                        txt_result_four_mul_add.setText(seconChar);
                       util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                        txt_borrow_one_mul.setText(" ");
                        txt_borrow_two_mul.setText(" ");
                        txt_borrow_three_mul.setText(" ");
                        txt_borrow_four_mul.setText(" ");
                        txt_bellow_one_mul_add.setVisibility(View.VISIBLE);
                    } else {
                       util.mediaService(((Activity) context),R.raw.no,msoundShare);
                    }
                } else if (mfirstRowFourthCal.length() == 1) {
                    if (keyNum.equals(mfirstRowFourthCal)) {
                        txt_result_four_mul_add.setText(mfirstRowFourthCal);
                       util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                        txt_borrow_one_mul.setText(" ");
                        txt_borrow_two_mul.setText(" ");
                        txt_borrow_three_mul.setText(" ");
                        txt_borrow_four_mul.setText(" ");
                        txt_bellow_one_mul_add.setVisibility(View.VISIBLE);
                    } else {
                       util.mediaService(((Activity) context),R.raw.no,msoundShare);
                    }
                }
            }else if(txt_bellow_two_mul_add.getText().toString().equals("")){
                String msecondRowFirstCal=String.valueOf(mfirstRowRandomOneMul*msecondRowRandomTwoMul);
                if (msecondRowFirstCal.length() == 2) {
                  caliculationForTwoDigitResult(txt_borrow_two_mul,txt_bellow_two_mul_add,msecondRowFirstCal,keyNum);

                } else if (msecondRowFirstCal.length() == 1) {
                    if (keyNum.equals(msecondRowFirstCal)) {
                        txt_bellow_two_mul_add.setText(msecondRowFirstCal);
                       util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                    } else {
                       util.mediaService(((Activity) context),R.raw.no,msoundShare);
                    }
                }
            }else if(txt_bellow_three_mul_add.getText().toString().equals("")){
                int mborrow =0;
                if(txt_borrow_two_mul.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_two_mul.getText().toString());
                }
                String msecondRowSecondCal=String.valueOf(mfirstRowRandomTwoMul*msecondRowRandomTwoMul+mborrow);
                if (msecondRowSecondCal.length() == 2) {
                    caliculationForTwoDigitResult(txt_borrow_three_mul,txt_bellow_three_mul_add,msecondRowSecondCal,keyNum);

                } else if (msecondRowSecondCal.length() == 1) {
                    caliculationForOneDigitResult(txt_bellow_three_mul_add, msecondRowSecondCal,keyNum);

                }

            }else if(txt_bellow_four_mul_add.getText().toString().equals("")){
                int mborrow =0;
                if(txt_borrow_three_mul.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_three_mul.getText().toString());
                }
                String msecondRowThirdCal=String.valueOf(mfirstRowRandomThreeMul*msecondRowRandomTwoMul+mborrow);
                if (msecondRowThirdCal.length() == 2) {
                    caliculationForTwoDigitResult(txt_borrow_four_mul,txt_bellow_four_mul_add,msecondRowThirdCal,keyNum);

                } else if (msecondRowThirdCal.length() == 1) {
                    caliculationForOneDigitResult(txt_bellow_four_mul_add, msecondRowThirdCal,keyNum);

                }
            }else if(txt_bellow_five_mul_add.getText().toString().equals("")){
                int mborrow =0;
                if(txt_borrow_four_mul.getText().toString().equals(" ")){
                    mborrow = 0;
                }else {
                    mborrow = Integer.parseInt(txt_borrow_four_mul.getText().toString());
                }
                String msecondRowFourthCal=String.valueOf(mfirstRowRandomFourMul*msecondRowRandomTwoMul+mborrow);
                if (msecondRowFourthCal.length() == 2) {

                    String firstChar = String.valueOf(msecondRowFourthCal.charAt(0));
                    String seconChar = String.valueOf(msecondRowFourthCal.charAt(1));
                    if (txt_bellow_six_mul_add.getText().toString().equals("") && keyNum.equals(firstChar)) {
                       util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                        txt_bellow_six_mul_add.setText(firstChar);
                    } else if (!txt_bellow_six_mul_add.getText().toString().equals("")&& keyNum.equals(seconChar)) {
                       util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                        txt_bellow_five_mul_add.setText(seconChar);
                        txt_bellow_seven_mul_add.setVisibility(View.VISIBLE);
                        view_two_mul.setVisibility(View.VISIBLE);
                        rl_mul_final_result.setVisibility(View.VISIBLE);
                    } else {
                       util.mediaService(((Activity) context),R.raw.no,msoundShare);
                    }
                } else if (msecondRowFourthCal.length() == 1) {
                    if (keyNum.equals(msecondRowFourthCal)) {
                        txt_bellow_five_mul_add.setText(msecondRowFourthCal);
                        txt_bellow_seven_mul_add.setVisibility(View.VISIBLE);
                        view_two_mul.setVisibility(View.VISIBLE);
                        rl_mul_final_result.setVisibility(View.VISIBLE);
                       util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                    } else {
                       util.mediaService(((Activity) context),R.raw.no,msoundShare);
                    }
                }
            }else if(txt_final_result_one_mul.getText().toString().equals("")){
                String mfinalResultMulOne = txt_result_one_mul_add.getText().toString();
                if(keyNum.equals(mfinalResultMulOne)){
                    txt_final_result_one_mul.setText(mfinalResultMulOne);
                   util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                } else {
                   util.mediaService(((Activity) context),R.raw.no,msoundShare);
                }
            }else if(txt_final_result_two_mul.getText().toString().equals("")){
                int getFirstNumber =Integer.parseInt(txt_result_two_mul_add.getText().toString());
                int getSecondNumber = Integer.parseInt(txt_bellow_two_mul_add.getText().toString());
                String mfinalForSecondDigitMul = String.valueOf(getFirstNumber + getSecondNumber);
                if(mfinalForSecondDigitMul.length() == 2){
                    caliculationForTwoDigitResult(txt_borrow_three_mul_add,txt_final_result_two_mul,mfinalForSecondDigitMul,keyNum);
                }else if(mfinalForSecondDigitMul.length() == 1){
                    caliculationForOneDigitResult(txt_final_result_two_mul, mfinalForSecondDigitMul,keyNum);
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
                String mfinalForThirdDigitMul = String.valueOf(getFirstNumber + getSecondNumber+mborrow);
                if(mfinalForThirdDigitMul.length() == 2){
                    caliculationForTwoDigitResult(txt_borrow_four_mul_add,txt_final_result_three_mul,mfinalForThirdDigitMul,keyNum);

                }else if(mfinalForThirdDigitMul.length() == 1){
                    caliculationForOneDigitResult(txt_final_result_three_mul, mfinalForThirdDigitMul,keyNum);
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
                String mfinalForFourthDigitMul = String.valueOf(getFirstNumber + getSecondNumber+mborrow);
                if(mfinalForFourthDigitMul.length() == 2){
                    caliculationForTwoDigitResult(txt_borrow_five_mul_add,txt_final_result_four_mul,mfinalForFourthDigitMul,keyNum);

                }else if(mfinalForFourthDigitMul.length() == 1){
                    caliculationForOneDigitResult(txt_final_result_four_mul, mfinalForFourthDigitMul,keyNum);
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
                String mfinalForFifthDigitMul = String.valueOf(getFirstNumber + getSecondNumber+mborrow);
                if(mfinalForFifthDigitMul.length() == 2){
                    if(!txt_bellow_six_mul_add.getText().toString().equals("")) {
                        caliculationForTwoDigitResult(txt_borrow_six_mul_add,txt_final_result_five_mul,mfinalForFifthDigitMul,keyNum);

                    }else{
                        caliculationForTwoDigitSuccessResult(txt_final_result_six_mul, txt_final_result_five_mul,mfinalForFifthDigitMul,keyNum);


                    }
                }else if(mfinalForFifthDigitMul.length() == 1){
                    if(keyNum.equals(mfinalForFifthDigitMul)){
                        if(!txt_bellow_six_mul_add.getText().toString().equals("")) {
                            txt_final_result_five_mul.setText(mfinalForFifthDigitMul);
                           util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                        }else {
                            txt_final_result_five_mul.setText(mfinalForFifthDigitMul);
                           util.mediaService(((Activity) context),R.raw.sucess,msoundShare);
                            handlerForGenarateRandom();

                        }
                    }else{
                       util.mediaService(((Activity) context),R.raw.no,msoundShare);
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
                String mfinalForSixDigitMul = String.valueOf( getSecondNumber+mborrow);
                if(mfinalForSixDigitMul.length() == 2){
                    caliculationForTwoDigitSuccessResult(txt_final_result_seven_mul, txt_final_result_six_mul, mfinalForSixDigitMul,keyNum);

                }else if(mfinalForSixDigitMul.length() == 1){
                    if(keyNum.equals(mfinalForSixDigitMul)){
                        txt_final_result_six_mul.setText(mfinalForSixDigitMul);
                       util.mediaService(((Activity) context),R.raw.sucess,msoundShare);
                        handlerForGenarateRandom();
                    }else{
                       util.mediaService(((Activity) context),R.raw.no,msoundShare);

                    }
                }else{
                   util.mediaService(((Activity) context),R.raw.no,msoundShare);
                }
            }
        }
    }
    }
// Calculation for one digit number
    private void caliculationForOneDigitResult(TextView txtOneDigitView, String finalResult,String keyNum) {
        if (keyNum.equals(finalResult)) {
            txtOneDigitView.setText(finalResult);
           util.mediaService(((Activity) context),R.raw.yes,msoundShare);
        } else {
           util.mediaService(((Activity) context),R.raw.no,msoundShare);
        }
    }
// Calculation for one digit number after mlevel complete
    private void caliculationForOneDigitSuccessResult(TextView txtOneDigitView, String finalResult) {
        txtOneDigitView.setText(finalResult);
       util.mediaService(((Activity) context),R.raw.sucess,msoundShare);
        handlerForGenarateRandom();
    }
// Calculation for two digit number after
    private void caliculationForTwoDigitResult(TextView txtfirstView, TextView txtSecondView, String fianlString,String keyNum) {
        String firstChar = String.valueOf(fianlString.charAt(0));
        String seconChar = String.valueOf(fianlString.charAt(1));
        if (txtfirstView.getText().toString().equals(" ") && keyNum.equals(firstChar)) {
            txtfirstView.setText(firstChar);
           util.mediaService(((Activity) context),R.raw.yes,msoundShare);
        } else if (!txtfirstView.getText().toString().equals(" ")&& keyNum.equals(seconChar)) {
            txtSecondView.setText(seconChar);
           util.mediaService(((Activity) context),R.raw.yes,msoundShare);
        } else {
           util.mediaService(((Activity) context),R.raw.no,msoundShare);
        }

    }
// Calculation for two digit number after level complete
    private void caliculationForTwoDigitSuccessResult(TextView txtFirstView, TextView txtSecondView,String fianlString,String keyNum) {
        String firstChar = String.valueOf(fianlString.charAt(0));
        String seconChar = String.valueOf(fianlString.charAt(1));
        if (txtFirstView.getText().toString().equals("") && keyNum.equals(firstChar)) {
            txtFirstView.setText(firstChar);
           util.mediaService(((Activity) context),R.raw.yes,msoundShare);
        } else if (!txtFirstView.getText().toString().equals("")&& keyNum.equals(seconChar)) {
            txtSecondView.setText(seconChar);
           util.mediaService(((Activity) context),R.raw.sucess,msoundShare);
            handlerForGenarateRandom();

        } else {
           util.mediaService(((Activity) context),R.raw.no,msoundShare);
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
    //Functionality for displaying panda
    public void displayingPanda () {
        switch (ApplyMath.forPandaApply){
            case "first":
                ApplyMath.forPandaApply = "second";
                visiblePanda(R.drawable.panda_one);
                break;
            case "second":
                ApplyMath.forPandaApply = "third";
                visiblePanda(R.drawable.panda_two);
                break;
            case "third":
                ApplyMath.forPandaApply = "first";
                visiblePanda(R.drawable.panda_three);
                break;
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
