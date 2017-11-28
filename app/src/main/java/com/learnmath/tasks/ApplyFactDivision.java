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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.learnmath.R;
import com.learnmath.Fragments.ApplyMath;
import com.learnmath.Utils.FontChange;
import com.learnmath.Utils.Util;

import java.util.Random;

/**
 * Created by stellent on 10/16/2017.
 */
public class ApplyFactDivision {
    Context context;
    public boolean msoundShare = false,mdivClear=true;
    int mlevel;
    View view_one,view_two,view_three,view_four;
    Util util=new Util();
    TextView txt_pandatext,txt_quot_one,txt_quot_two,txt_quot_three,txt_quot_four,txt_quot_five,txt_quot_six,txt_divisor_two,txt_divisor_one,txt_divident_one,txt_divident_two,txt_divident_three,txt_divident_four
            ,txt_first_row_minus,txt_first_row_first_number,txt_third_first,txt_third_second,txt_fourth_minus,txt_fourth_first,txt_fourth_second,txt_fifth_first,txt_fifth_second,txt_fifth_third,txt_sixth_minus,txt_sixth_first,txt_sixth_second
            ,txt_sixth_third,txt_seventh_first,txt_seventh_second,txt_seventh_third,txt_eigth_minus,txt_eigth_first,txt_eigth_second,txt_eigth_third,txt_ninth_first,txt_ninth_second;
    public int mfirstRanNumDivisor,mranNumDivident,mDigitOne=0,mDigitTwo=0,mDigitThree=0,mDigitFour=0;
    ImageView img_arrow_one,img_arrow_two,img_arrow_three,img_up_arrow,img_panda;
    RelativeLayout rl_panda;
    public static int sDigits = 0;
    private boolean mremainder = false;
    FontChange mfont = new FontChange();

    public ApplyFactDivision(Context context){
        this.context=context;
        Update();
    }
    //Calls this method when this class is called
    public void Update(){
        //Getting division textviews
        txt_quot_one = (TextView) ((Activity)context).findViewById(R.id.txt_quot_one);
        txt_quot_two = (TextView) ((Activity)context).findViewById(R.id.txt_quot_two);
        txt_quot_three = (TextView) ((Activity)context).findViewById(R.id.txt_quot_three);
        txt_quot_four = (TextView) ((Activity)context).findViewById(R.id.txt_quot_four);
        txt_quot_five = (TextView) ((Activity)context).findViewById(R.id.txt_quot_five);
        txt_quot_six = (TextView) ((Activity)context).findViewById(R.id.txt_quot_six);
        txt_divisor_two = (TextView) ((Activity)context).findViewById(R.id.txt_divisor_two);
        txt_divisor_one = (TextView) ((Activity)context).findViewById(R.id.txt_divisor_one);
        txt_divident_one = (TextView) ((Activity)context).findViewById(R.id.txt_divident_one);
        txt_divident_two = (TextView) ((Activity)context).findViewById(R.id.txt_divident_two);
        txt_divident_three = (TextView) ((Activity)context).findViewById(R.id.txt_divident_three);
        txt_divident_four = (TextView) ((Activity)context).findViewById(R.id.txt_divident_four);
        txt_first_row_minus = (TextView) ((Activity)context).findViewById(R.id.txt_first_row_minus);
        txt_first_row_first_number = (TextView) ((Activity)context).findViewById(R.id.txt_first_row_first_number);
        txt_third_first = (TextView) ((Activity)context).findViewById(R.id.txt_third_first);
        txt_third_second = (TextView) ((Activity)context).findViewById(R.id.txt_third_second);
        txt_fourth_minus = (TextView) ((Activity)context).findViewById(R.id.txt_fourth_minus);
        txt_fourth_first = (TextView) ((Activity)context).findViewById(R.id.txt_fourth_first);
        txt_fourth_second = (TextView) ((Activity)context).findViewById(R.id.txt_fourth_second);
        txt_fifth_first = (TextView) ((Activity)context).findViewById(R.id.txt_fifth_first);
        txt_fifth_second = (TextView) ((Activity)context).findViewById(R.id.txt_fifth_second);
        txt_fifth_third = (TextView) ((Activity)context).findViewById(R.id.txt_fifth_third);
        txt_sixth_minus = (TextView) ((Activity)context).findViewById(R.id.txt_sixth_minus);
        txt_sixth_first = (TextView) ((Activity)context).findViewById(R.id.txt_sixth_first);
        txt_sixth_second = (TextView) ((Activity)context).findViewById(R.id.txt_sixth_second);
        txt_sixth_third = (TextView) ((Activity)context).findViewById(R.id.txt_sixth_third);
        txt_seventh_first = (TextView) ((Activity)context).findViewById(R.id.txt_seventh_first);
        txt_seventh_second = (TextView) ((Activity)context).findViewById(R.id.txt_seventh_second);
        txt_seventh_third = (TextView) ((Activity)context).findViewById(R.id.txt_seventh_third);
        txt_eigth_minus = (TextView) ((Activity)context).findViewById(R.id.txt_eigth_minus);
        txt_eigth_first = (TextView) ((Activity)context).findViewById(R.id.txt_eigth_first);
        txt_eigth_second = (TextView) ((Activity)context).findViewById(R.id.txt_eigth_second);
        txt_eigth_third = (TextView) ((Activity)context).findViewById(R.id.txt_eigth_third);
        txt_ninth_first = (TextView) ((Activity)context).findViewById(R.id.txt_ninth_first);
        txt_ninth_second = (TextView) ((Activity)context).findViewById(R.id.txt_ninth_second);

        //Setting the font style for the textviews
        setTypeFace();
        view_one = (View) ((Activity)context).findViewById(R.id.view_one);
        view_two = (View) ((Activity)context).findViewById(R.id.view_two);
        view_three = (View) ((Activity)context).findViewById(R.id.view_three);
        view_four = (View) ((Activity)context).findViewById(R.id.view_four);
        img_arrow_one =(ImageView) ((Activity)context).findViewById(R.id.img_arrow_one);
        img_arrow_two =(ImageView) ((Activity)context).findViewById(R.id.img_arrow_two);
        img_arrow_three =(ImageView) ((Activity)context).findViewById(R.id.img_arrow_three);
        img_up_arrow=(ImageView) ((Activity)context).findViewById(R.id.img_up_arrow);
        //For panda
        img_panda = (ImageView) ((Activity)context).findViewById(R.id.img_panda);
        rl_panda =  (RelativeLayout) ((Activity)context).findViewById(R.id.rl_panda);
        txt_pandatext = (TextView) ((Activity)context).findViewById(R.id.txt_pandatext);
        //Getting the values from shared preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        mlevel = Integer.parseInt(prefs.getString("level", "1"));
        msoundShare = prefs.getBoolean("sound", true);
    }
    //Setting the font style for the textviews
    private void setTypeFace() {
        mfont.fontChange(txt_quot_one,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_quot_two,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_quot_three,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_quot_four,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_quot_five,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_quot_six,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_divisor_two,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_divisor_one,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_divident_one,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_divident_two,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_divident_three,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_divident_four,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_first_row_minus,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_first_row_first_number,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_third_first,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_third_second,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_fourth_minus,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_fourth_first,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_fourth_second,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_fifth_first,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_fifth_second,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_fifth_third,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_sixth_minus,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_sixth_first,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_sixth_second,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_sixth_third,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_seventh_first,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_seventh_second,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_seventh_third,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_eigth_minus,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_eigth_first,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_eigth_second,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_eigth_third,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_ninth_first,"fonts/textFont.ttf",((Activity)context));
        mfont.fontChange(txt_ninth_second,"fonts/textFont.ttf",((Activity)context));
    }

    //Generate random number for division
    public void geanarateRandomApplyDiv() {
        mremainder=false;
        //Increase the count of panda
        if(ApplyMath.fromFirst) {
            ApplyMath.fromFirst =false;
            ApplyMath.countForPanda =0;
        }else {
            ApplyMath.countForPanda++;
        }
        mdivClear=true;
        //Calling the panda for displaying the image
        if (ApplyMath.countForPanda == 5) {
            displayingPanda();
        }
        //Empty the values before setting data
        view_one.setVisibility(View.GONE);
        view_two.setVisibility(View.GONE);
        view_three.setVisibility(View.GONE);
        view_four.setVisibility(View.GONE);
        txt_divisor_one.setText(" ");
        txt_divisor_two.setText(" ");
        txt_quot_one.setText(" ");
        txt_quot_two.setText(" ");
        txt_quot_three.setText(" ");
        txt_quot_four.setText(" ");
        txt_quot_five.setText(" ");
        txt_quot_six.setText(" ");
        txt_first_row_minus.setVisibility(View.INVISIBLE);
        txt_first_row_first_number.setText(" ");
        txt_third_first.setText(" ");
        txt_third_second.setText(" ");
        txt_fourth_minus.setVisibility(View.INVISIBLE);
        txt_fourth_first.setText(" ");
        txt_fourth_second.setText(" ");
        txt_fifth_first.setText(" ");
        txt_fifth_second.setText(" ");
        txt_fifth_third.setText(" ");
        txt_sixth_first.setText(" ");
        txt_sixth_minus.setVisibility(View.INVISIBLE);
        txt_sixth_second.setText(" ");
        txt_sixth_third.setText(" ");
        txt_seventh_first.setText(" ");
        txt_seventh_second.setText(" ");
        txt_seventh_third.setText(" ");
        txt_eigth_minus.setVisibility(View.INVISIBLE);
        txt_eigth_first.setText(" ");
        txt_eigth_second.setText(" ");
        txt_eigth_third.setText(" ");
        txt_ninth_first.setText(" ");
        txt_ninth_second.setText(" ");
        txt_divident_one.setText("");
        txt_divident_two.setText("");
        txt_divident_three.setText("");
        txt_divident_four.setText("");
        //Generate random numbers for levels
      switch (mlevel)
      {
          case 1:
              int mfirstRan = genarateRandom(1, 9);
              int msecondRan = genarateRandom(1, 9);
              mfirstRanNumDivisor =mfirstRan;
              mranNumDivident = mfirstRan*msecondRan;
              break;
          case 2:
              mfirstRanNumDivisor = genarateRandom(1, 9);
              mranNumDivident = genarateRandom(1, 99);
              break;
          case 3:
              mfirstRanNumDivisor = genarateRandom(1, 9);
              mranNumDivident = genarateRandom(1, 999);
              break;
          case 4:
              mfirstRanNumDivisor = genarateRandom(1, 9);
              mranNumDivident = genarateRandom(1, 9999);
              break;
      }
        txt_divisor_one.setText(String.valueOf(mfirstRanNumDivisor));
        if (mranNumDivident >= 10 && mranNumDivident < 100) {
            sDigits = 2;
            mDigitTwo = mranNumDivident % 10;
            mDigitOne = mranNumDivident / 10 % 10;
            txt_divident_one.setText(String.valueOf(mDigitOne));
            txt_divident_two.setText(String.valueOf(mDigitTwo));
        } else if (mranNumDivident >= 100 && mranNumDivident < 1000) {
            sDigits = 3;
            mDigitThree = mranNumDivident % 10;
            mDigitTwo = mranNumDivident / 10 % 10;
            mDigitOne = mranNumDivident / 100 % 10;
            txt_divident_one.setText(String.valueOf(mDigitOne));
            txt_divident_two.setText(String.valueOf(mDigitTwo));
            txt_divident_three.setText(String.valueOf(mDigitThree));
        } else if (mranNumDivident >= 1000){
            sDigits = 4;
            mDigitFour = mranNumDivident % 10;
            mDigitThree = mranNumDivident / 10 % 10;
            mDigitTwo = mranNumDivident / 100 % 10;
            mDigitOne = mranNumDivident /1000 % 10;
            txt_divident_one.setText(String.valueOf(mDigitOne));
            txt_divident_two.setText(String.valueOf(mDigitTwo));
            txt_divident_three.setText(String.valueOf(mDigitThree));
            txt_divident_four.setText(String.valueOf(mDigitFour));
        }else{
            sDigits = 1;
            mDigitOne = mranNumDivident;
            txt_divident_one.setText(String.valueOf(mDigitOne));
        }
    }

    //Generate random number
    public int genarateRandom(int min,int max) {
        Random r = new Random();
        int ranOne = r.nextInt(max - min + 1) + min;
        return ranOne;
    }
    //Functionality for division
    public void functionalityforDiv(String keyNum) {
        if (mdivClear) {
            //Setting the values to the views when click on keyboard
            if (txt_first_row_first_number.getText().toString().equals(" ")) {
                int mfirstQuotient, mfirstResult;
                if (mDigitOne < mfirstRanNumDivisor) {
                    mfirstQuotient = 0;
                    mfirstResult = 0;
                } else {
                    mfirstQuotient = mDigitOne / mfirstRanNumDivisor;
                    mfirstResult = mfirstRanNumDivisor * mfirstQuotient;
                }
                if (txt_quot_one.getText().toString().equals(" ") && keyNum.equals(String.valueOf(mfirstQuotient))) {
                    txt_quot_one.setText(String.valueOf(mfirstQuotient));
                    util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                } else if (!txt_quot_one.getText().toString().equals(" ") && keyNum.equals(String.valueOf(mfirstResult))) {
                    txt_first_row_first_number.setText(String.valueOf(mfirstResult));
                    view_one.setVisibility(View.VISIBLE);
                    txt_first_row_minus.setVisibility(View.VISIBLE);
                    util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                } else {
                    util.mediaService(((Activity) context),R.raw.no,msoundShare);
                }
            } else if (txt_third_first.getText().toString().equals(" ")) {
                int mfirstNumber = mDigitOne;
                int msecondNumber = Integer.parseInt(txt_first_row_first_number.getText().toString());
                int mresult = mfirstNumber - msecondNumber;
                if (keyNum.equals(String.valueOf(mresult))) {
                    txt_third_first.setText(String.valueOf(mresult));
                    if (sDigits == 1) {
                        if (mresult == 0) {
                            util.mediaService(((Activity) context),R.raw.sucess,msoundShare);
                            handlerForGenarateRandom();

                        } else {
                            util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                        }
                    } else {
                        util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                    }
                } else {
                    util.mediaService(((Activity) context),R.raw.no,msoundShare);
                }
            } else if (txt_third_second.getText().toString().equals(" ")) {

                if (sDigits > 1) {
                    if (keyNum.equals(String.valueOf(mDigitTwo))) {
                        img_arrow_one.setVisibility(View.INVISIBLE);
                        txt_third_second.setText(String.valueOf(mDigitTwo));
                        util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                    } else {
                        img_arrow_one.setVisibility(View.VISIBLE);
                        util.mediaService(((Activity) context),R.raw.no,msoundShare);
                    }
                } else {
                    if (txt_third_first.getText().toString() == "0") {

                    } else {
                        if (mremainder == false) {
                            if (keyNum.equals("r")) {
                                mremainder = true;
                                img_up_arrow.setVisibility(View.INVISIBLE);
                                txt_quot_two.setText("r.");
                                util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                            } else {
                                img_up_arrow.setVisibility(View.VISIBLE);
                                util.mediaService(((Activity) context),R.raw.no,msoundShare);
                            }
                        } else {
                            String remainingValue = txt_third_first.getText().toString();
                            if (keyNum.equals(remainingValue)) {
                                txt_quot_three.setText(remainingValue);
                                util.mediaService(((Activity) context),R.raw.sucess,msoundShare);
                                handlerForGenarateRandom();

                            } else {
                                util.mediaService(((Activity) context),R.raw.no,msoundShare);
                            }
                        }
                    }
                }
            } else if (txt_fourth_second.getText().toString().equals(" ")) {

                int msecondQuotient, msecondResult, mfinalNumberTwo = 0;
                if (txt_third_first.getText().toString().equals("0")) {
                    mfinalNumberTwo = Integer.parseInt(txt_third_second.getText().toString());
                } else {
                    mfinalNumberTwo = Integer.parseInt(txt_third_first.getText().toString() + txt_third_second.getText().toString());
                }
                if (mfinalNumberTwo < mfirstRanNumDivisor) {
                    msecondQuotient = 0;
                    msecondResult = 0;
                } else {
                    msecondQuotient = mfinalNumberTwo / mfirstRanNumDivisor;
                    msecondResult = mfirstRanNumDivisor * msecondQuotient;
                }
                caliculationForTheDivision(txt_quot_two, txt_fourth_second,txt_fourth_first,keyNum,  view_two, txt_fourth_minus,msecondQuotient, msecondResult);

            } else if (txt_fifth_third.getText().toString().equals(" ")) {
                int msecondNumberTwo;
                int mfirstNumber = Integer.parseInt(txt_third_second.getText().toString());
                int msecondNumber = Integer.parseInt(txt_fourth_second.getText().toString());
                int mfirstNumberTwo = Integer.parseInt(txt_third_first.getText().toString());
                if (txt_fourth_first.getText().toString().equals(" ")) {
                    msecondNumberTwo = 0;
                } else {
                    msecondNumberTwo = Integer.parseInt(txt_fourth_first.getText().toString());
                }
                int mfirstResultSub;
                if (mfirstNumber < msecondNumber) {
                    int firstNUmberNew = mfirstNumber + 10;
                    mfirstResultSub = firstNUmberNew - msecondNumber;
                    mfirstNumberTwo = mfirstNumberTwo - 1;

                } else {
                    mfirstResultSub = mfirstNumber - msecondNumber;
                }
                int msecondResultSub = mfirstNumberTwo - msecondNumberTwo;
                if (txt_fifth_second.getText().toString().equals(" ") & keyNum.equals(String.valueOf(mfirstResultSub))) {
                    txt_fifth_second.setText(String.valueOf(mfirstResultSub));
                    if (sDigits == 2) {
                        if (mfirstResultSub == 0) {
                            util.mediaService(((Activity) context),R.raw.sucess,msoundShare);
                            handlerForGenarateRandom();

                        } else {
                            util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                        }
                    } else {
                        util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                    }
                } else if (!txt_fifth_second.getText().toString().equals(" ") && msecondResultSub != 0 && keyNum.equals(String.valueOf(msecondResultSub))) {
                    txt_fifth_second.setText(String.valueOf(msecondResultSub));
                    util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                } else {
                    int sum = mfirstResultSub + msecondResultSub;
                    if (sum > mfirstRanNumDivisor) {
                        txt_fifth_third.setText("");
                    } else {
                        if (!txt_fifth_second.getText().toString().equals(" ")) {
                            if (sDigits > 2) {
                                if (keyNum.equals(String.valueOf(mDigitThree))) {
                                    txt_fifth_third.setText(String.valueOf(mDigitThree));
                                    util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                                    img_arrow_two.setVisibility(View.INVISIBLE);
                                } else {
                                    img_arrow_two.setVisibility(View.VISIBLE);
                                    util.mediaService(((Activity) context),R.raw.no,msoundShare);
                                }
                            } else {
                                if (txt_fifth_second.getText().toString() == "0") {

                                } else {
                                    if (mremainder == false) {
                                        if (keyNum.equals("r")) {
                                            mremainder = true;
                                            img_up_arrow.setVisibility(View.INVISIBLE);
                                            txt_quot_three.setText("r.");
                                            util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                                        } else {
                                            img_up_arrow.setVisibility(View.VISIBLE);
                                            util.mediaService(((Activity) context),R.raw.no,msoundShare);
                                        }
                                    } else {
                                        String remainingValue = txt_fifth_second.getText().toString();
                                        if (keyNum.equals(remainingValue)) {
                                            util.mediaService(((Activity) context),R.raw.sucess,msoundShare);
                                            txt_quot_four.setText(remainingValue);
                                            handlerForGenarateRandom();

                                        } else {
                                            util.mediaService(((Activity) context),R.raw.no,msoundShare);
                                        }
                                    }
                                }
                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,msoundShare);
                        }
                    }
                }
            } else if (txt_sixth_third.getText().toString().equals(" ")) {

                int mthirdQuotient = 0, mthirdResult = 0, mfinalNumberThree = 0;

                if (txt_fifth_second.getText().toString().equals("0")) {

                    mfinalNumberThree = Integer.parseInt(txt_fifth_third.getText().toString());
                } else {
                    mfinalNumberThree = Integer.parseInt(txt_fifth_second.getText().toString() + txt_fifth_third.getText().toString());
                }
                if (mfinalNumberThree >= mfirstRanNumDivisor) {
                    mthirdQuotient = mfinalNumberThree / mfirstRanNumDivisor;
                    mthirdResult = mfirstRanNumDivisor * mthirdQuotient;
                }
                caliculationForTheDivision(txt_quot_three, txt_sixth_third,txt_sixth_second,keyNum,  view_three, txt_sixth_minus,mthirdQuotient, mthirdResult);

            } else if (txt_seventh_third.getText().toString().equals(" ")) {
                int msecondNumberThree;
                int mfirstNumber = Integer.parseInt(txt_fifth_third.getText().toString());
                int msecondNumber = Integer.parseInt(txt_sixth_third.getText().toString());
                int mfirstNumberThree = Integer.parseInt(txt_fifth_second.getText().toString());
                if (txt_sixth_second.getText().toString().equals(" ")) {
                    msecondNumberThree = 0;
                } else {
                    msecondNumberThree = Integer.parseInt(txt_sixth_second.getText().toString());
                }
                int mfirstResultSub;
                if (mfirstNumber < msecondNumber) {
                    int firstNUmberNew = mfirstNumber + 10;

                    mfirstResultSub = firstNUmberNew - msecondNumber;
                    mfirstNumberThree = mfirstNumberThree - 1;
                } else {
                    mfirstResultSub = mfirstNumber - msecondNumber;
                }
                int msecondResultSub = mfirstNumberThree - msecondNumberThree;
                if (txt_seventh_second.getText().toString().equals(" ") & keyNum.equals(String.valueOf(mfirstResultSub))) {
                    txt_seventh_second.setText(String.valueOf(mfirstResultSub));
                    if (sDigits == 3) {
                        util.mediaService(((Activity) context),R.raw.sucess,msoundShare);
                        if (mfirstResultSub == 0) {
                            handlerForGenarateRandom();
                        }
                    } else {
                        util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                    }
                } else if (!txt_seventh_second.getText().toString().equals(" ") && msecondResultSub != 0 && keyNum.equals(String.valueOf(msecondResultSub))) {
                    txt_seventh_third.setText(String.valueOf(msecondResultSub));
                    util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                } else {
                    int msum = mfirstResultSub + msecondResultSub;
                    if (msum > mfirstRanNumDivisor) {
                        txt_seventh_third.setText("");
                    } else {
                        if (!txt_seventh_second.getText().toString().equals(" ")) {
                            if (sDigits > 3) {
                                if (keyNum.equals(String.valueOf(mDigitFour))) {
                                    txt_seventh_third.setText(String.valueOf(mDigitFour));
                                    util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                                    img_arrow_three.setVisibility(View.INVISIBLE);
                                } else {
                                    img_arrow_three.setVisibility(View.VISIBLE);
                                    util.mediaService(((Activity) context),R.raw.no,msoundShare);
                                }
                            } else {

                                if (txt_seventh_second.getText().toString() == "0") {

                                } else {
                                    if (mremainder == false) {
                                        if (keyNum.equals("r")) {
                                            mremainder = true;
                                            img_up_arrow.setVisibility(View.INVISIBLE);
                                            util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                                            txt_quot_four.setText("r.");
                                        } else {
                                            img_up_arrow.setVisibility(View.VISIBLE);
                                            util.mediaService(((Activity) context),R.raw.no,msoundShare);
                                        }
                                    } else {
                                        String remainingValue = txt_seventh_second.getText().toString();
                                        if (keyNum.equals(remainingValue)) {
                                            txt_quot_five.setText(remainingValue);
                                            util.mediaService(((Activity) context),R.raw.sucess,msoundShare);
                                            handlerForGenarateRandom();
                                        } else {
                                            util.mediaService(((Activity) context),R.raw.no,msoundShare);
                                        }
                                    }
                                }
                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,msoundShare);
                        }
                    }
                }
            } else if (txt_eigth_third.getText().toString().equals(" ")) {
                int mfourthQuotient = 0, mfourthResult = 0, mfinalNumberFour = 0;
                if (txt_seventh_second.getText().toString().equals("0")) {
                    mfinalNumberFour = Integer.parseInt(txt_seventh_third.getText().toString());
                } else {
                    mfinalNumberFour = Integer.parseInt(txt_seventh_second.getText().toString() + txt_seventh_third.getText().toString());
                }
                if (mfinalNumberFour >= mfirstRanNumDivisor) {
                    mfourthQuotient = mfinalNumberFour / mfirstRanNumDivisor;
                    mfourthResult = mfirstRanNumDivisor * mfourthQuotient;
                }
                caliculationForTheDivision(txt_quot_four, txt_eigth_third,txt_eigth_second,keyNum,  view_four, txt_eigth_minus,mfourthQuotient, mfourthResult);

            } else if (txt_ninth_second.getText().toString().equals(" ")) {
                int msecondNumberFour;
                int mfirstNumber = Integer.parseInt(txt_seventh_third.getText().toString());
                int msecondNumber = Integer.parseInt(txt_eigth_third.getText().toString());
                int mfirstNumberThree = Integer.parseInt(txt_seventh_second.getText().toString());
                if (txt_eigth_second.getText().toString().equals(" ")) {
                    msecondNumberFour = 0;
                } else {
                    msecondNumberFour = Integer.parseInt(txt_eigth_second.getText().toString());
                }
                int mfirstResultSub;
                if (mfirstNumber < msecondNumber) {
                    int firstNUmberNew = mfirstNumber + 10;
                    mfirstResultSub = firstNUmberNew - msecondNumber;
                    mfirstNumberThree = mfirstNumberThree - 1;
                } else {
                    mfirstResultSub = mfirstNumber - msecondNumber;
                }
                int msecondResultSub = mfirstNumberThree - msecondNumberFour;
                if (txt_ninth_first.getText().toString().equals(" ") & keyNum.equals(String.valueOf(mfirstResultSub))) {
                    if (msecondResultSub == 0) {
                        txt_ninth_second.setText(String.valueOf(mfirstResultSub));
                        if (sDigits == 4) {
                            if (mfirstResultSub == 0) {
                                util.mediaService(((Activity) context),R.raw.sucess,msoundShare);
                                handlerForGenarateRandom();

                            } else {
                                util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                        }
                    } else {
                        txt_ninth_first.setText(String.valueOf(mfirstResultSub));
                        util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                    }
                } else if (!txt_ninth_first.getText().toString().equals(" ") && msecondResultSub != 0 && keyNum.equals(String.valueOf(msecondResultSub))) {
                    txt_ninth_second.setText(String.valueOf(msecondResultSub));
                    util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                } else {
                    util.mediaService(((Activity) context),R.raw.no,msoundShare);
                }

            } else if (!txt_ninth_second.getText().toString().equals(" ")) {
                if (txt_ninth_second.getText().toString() == "0") {

                } else {
                    if (mremainder == false) {
                        if (keyNum.equals("r")) {
                            mremainder = true;
                            img_up_arrow.setVisibility(View.INVISIBLE);
                            txt_quot_five.setText("r.");
                            util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                        } else {
                            img_up_arrow.setVisibility(View.VISIBLE);
                            util.mediaService(((Activity) context),R.raw.no,msoundShare);
                        }
                    } else {
                        String remainderValue = txt_ninth_second.getText().toString();
                        if (keyNum.equals(remainderValue)) {
                            txt_quot_six.setText(remainderValue);
                            util.mediaService(((Activity) context),R.raw.sucess,msoundShare);
                            handlerForGenarateRandom();
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,msoundShare);
                        }
                    }
                }
            }
        }
    }

    //Calculation for the quotient
    private void caliculationForTheDivision(TextView txtQuotatoion, TextView txtRowValueSecond, TextView txtRowValueFirst, String keyNum, View view, TextView txtMinus, int msecondQuotient, int msecondResult) {
        if (txtQuotatoion.getText().toString().equals(" ") && keyNum.equals(String.valueOf(msecondQuotient))) {
            txtQuotatoion.setText(String.valueOf(msecondQuotient));
            util.mediaService(((Activity) context),R.raw.yes,msoundShare);
        } else if (!txtQuotatoion.getText().toString().equals(" ")) {
            if (String.valueOf(msecondResult).length() == 1 && keyNum.equals(String.valueOf(msecondResult))) {
                if (keyNum.equals(String.valueOf(msecondResult))) {
                    txtRowValueSecond.setText(String.valueOf(msecondResult));
                    util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                    txtMinus.setVisibility(View.VISIBLE);
                    view.setVisibility(View.VISIBLE);
                } else {
                    util.mediaService(((Activity) context),R.raw.no,msoundShare);
                }
            } else if (String.valueOf(msecondResult).length() == 2) {
                String firstChar = String.valueOf(String.valueOf(msecondResult).charAt(0));
                String seconChar = String.valueOf(String.valueOf(msecondResult).charAt(1));
                if (txtRowValueFirst.getText().toString().equals(" ") && keyNum.equals(firstChar)) {
                    txtMinus.setVisibility(View.VISIBLE);
                    txtRowValueFirst.setText(firstChar);
                    util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                } else if (!txtRowValueFirst.getText().toString().equals(" ") && keyNum.equals(seconChar)) {
                    txtRowValueSecond.setText(String.valueOf(seconChar));
                    util.mediaService(((Activity) context),R.raw.yes,msoundShare);
                    view.setVisibility(View.VISIBLE);
                } else {
                    util.mediaService(((Activity) context),R.raw.no,msoundShare);
                }
            } else {
                util.mediaService(((Activity) context),R.raw.no,msoundShare);
            }
        } else {
            util.mediaService(((Activity) context),R.raw.no,msoundShare);
        }
    }

    //For displaying the panda
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
    //Visibility for the panda image
    private void visiblePanda(int imgPanda) {
        ApplyMath.countForPanda = 0;
        rl_panda.setVisibility(View.VISIBLE);
        txt_pandatext.setVisibility(View.VISIBLE);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(img_panda);
        Glide.with(context).load(imgPanda).into(imageViewTarget);
        handlerForPanda();
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
        mdivClear=false;
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                geanarateRandomApplyDiv();
            }
        }, 1000);
    }

}
