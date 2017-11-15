package com.learnmath.fragments;


import android.app.Dialog;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.learnmath.R;
import com.learnmath.activities.LaunchActivity;
import com.learnmath.utils.FontChange;

import java.util.Random;

/**
 * Created by mohan on 9/29/2017.
 */
public class LearnMath extends Fragment implements View.OnTouchListener {
    private ImageView img_change;
    FontChange mfont = new FontChange();
    RelativeLayout main_layout, rl_panda;
    RelativeLayout rl_addition, rl_division, rl_minus, ll_cal;
    LinearLayout ll_multiplication, ll_cal_zero;
    //textviews for addition
    TextView txt_rand_one_add, txt_rand_two_add, txt_first_num_add, txt_second_num_add, txt_result_first_digit, txt_result_second_digit, txt_result_fisrt_demo, txt_result_second_demo;
    //textviews for multiplications
    TextView txt_rand_one_mul, txt_rand_two_mul, txt_result_fisrt_demo_mul, txt_result_second_demo_mul, txt_first_num_mul, txt_second_num_mul, txt_result_first_digit_mul, txt_result_second_digit_mul, txt_pandatext;
    private String tag;
    //imageviews
    ImageView img_info, img_btn_one, img_btn_two, img_btn_three, img_btn_four, img_btn_five, img_btn_six, img_btn_seven, img_btn_eight, img_btn_nine, img_btn_zero, img_arrow, img_arrow_mul, img_panda, img_home, img_settings;
    // textviews for substraction
    private TextView txt_rand_one_sub, txt_rand_two_sub, txt_total_sub, txt_sub_one, txt_sub_two, txt_sub_three, txt_sub_four, txt_sub_five, txt_sub_six;
    //boolean and integers for both substractions and divisions
    int mtotalSub, muserSubTwo, muserSubFive, muserSubBaseInt;
    private boolean muserSubSame;
    private boolean muserSubBaseBoolen, muserSubBaseBoolenFour;
    private boolean muserSubBoolen = true, muserSubBoolenFour = true;
    long systemTime = 0;
    // textviews for division
    TextView txt_learn_header, txt_rand_one_div, txt_rand_two_div, txt_total_div, txt_div_one, txt_div_two, txt_div_three, txt_div_four, txt_div_five, txt_div_six;
    int firstRanNum, secondRanNum;
    String finalAddition, finalMultiplication;
    //count variable for displaying panda
    int countForPanda = 0;
    //static variable for displaying panda
    public static String forPanda = "first";
    //sounds mediaplayer
    MediaPlayer mp;
    String keyNum = "";
    //for swiping left,right,top,bottom
    private int mMinDistance = 100;
    private float downX, downY, upX, upY;
    public static final int CLICK_ACTION_THRESHOLD = 200;
    private boolean sound_share = false;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if (view == null) {
            view = inflater.inflate(R.layout.learn_facts, container, false);
            //main Layout
            img_change = (ImageView) view.findViewById(R.id.img_change);
            rl_addition = (RelativeLayout) view.findViewById(R.id.rl_addition);
            rl_division = (RelativeLayout) view.findViewById(R.id.rl_division);
            rl_minus = (RelativeLayout) view.findViewById(R.id.rl_minus);
            ll_multiplication = (LinearLayout) view.findViewById(R.id.ll_multiplication);
            main_layout = (RelativeLayout) view.findViewById(R.id.main_layout);
            ll_cal = (RelativeLayout) view.findViewById(R.id.ll_cal);
            ll_cal_zero = (LinearLayout) view.findViewById(R.id.ll_cal_zero);
            img_info = (ImageView) view.findViewById(R.id.img_info);
            //for panda
            txt_pandatext = (TextView) view.findViewById(R.id.txt_pandatext);
            img_panda = (ImageView) view.findViewById(R.id.img_panda);
            rl_panda = (RelativeLayout) view.findViewById(R.id.rl_panda);
            //tab btntons
            img_home = (ImageView) view.findViewById(R.id.img_home);
            img_settings = (ImageView) view.findViewById(R.id.img_settings);
            //addition views
            txt_learn_header = (TextView) view.findViewById(R.id.tv_learn_header);
            txt_rand_one_add = (TextView) view.findViewById(R.id.txt_rand_one_add);
            txt_rand_two_add = (TextView) view.findViewById(R.id.txt_rand_two_add);
            txt_first_num_add = (TextView) view.findViewById(R.id.txt_first_num_add);
            txt_second_num_add = (TextView) view.findViewById(R.id.txt_second_num_add);
            txt_result_first_digit = (TextView) view.findViewById(R.id.txt_result_first_digit);
            txt_result_second_digit = (TextView) view.findViewById(R.id.txt_result_second_digit);
            img_arrow = (ImageView) view.findViewById(R.id.img_arrow);
            txt_result_fisrt_demo = (TextView) view.findViewById(R.id.txt_result_fisrt_demo);
            txt_result_second_demo = (TextView) view.findViewById(R.id.txt_result_second_demo);
            //multiplication views
            txt_rand_one_mul = (TextView) view.findViewById(R.id.txt_rand_one_mul);
            txt_rand_two_mul = (TextView) view.findViewById(R.id.txt_rand_two_mul);
            txt_first_num_mul = (TextView) view.findViewById(R.id.txt_first_num_mul);
            txt_second_num_mul = (TextView) view.findViewById(R.id.txt_second_num_mul);
            txt_result_first_digit_mul = (TextView) view.findViewById(R.id.txt_result_first_digit_mul);
            txt_result_second_digit_mul = (TextView) view.findViewById(R.id.txt_result_second_digit_mul);
            txt_result_fisrt_demo_mul = (TextView) view.findViewById(R.id.txt_result_fisrt_demo_mul);
            txt_result_second_demo_mul = (TextView) view.findViewById(R.id.txt_result_second_demo_mul);
            img_arrow_mul = (ImageView) view.findViewById(R.id.img_arrow_mul);
            //sub
            txt_rand_one_sub = (TextView) view.findViewById(R.id.txt_rand_one_sub);
            txt_rand_two_sub = (TextView) view.findViewById(R.id.txt_rand_two_sub);
            txt_total_sub = (TextView) view.findViewById(R.id.txt_total_sub);
            txt_sub_one = (TextView) view.findViewById(R.id.txt_sub_one);
            txt_sub_two = (TextView) view.findViewById(R.id.txt_sub_two);
            txt_sub_three = (TextView) view.findViewById(R.id.txt_sub_three);
            txt_sub_four = (TextView) view.findViewById(R.id.txt_sub_four);
            txt_sub_five = (TextView) view.findViewById(R.id.txt_sub_five);
            txt_sub_six = (TextView) view.findViewById(R.id.txt_sub_six);
            //div
            txt_rand_one_div = (TextView) view.findViewById(R.id.txt_rand_one_div);
            txt_rand_two_div = (TextView) view.findViewById(R.id.txt_rand_two_div);
            txt_total_div = (TextView) view.findViewById(R.id.txt_total_div);
            txt_div_one = (TextView) view.findViewById(R.id.txt_div_one);
            txt_div_two = (TextView) view.findViewById(R.id.txt_div_two);
            txt_div_three = (TextView) view.findViewById(R.id.txt_div_three);
            txt_div_four = (TextView) view.findViewById(R.id.txt_div_four);
            txt_div_five = (TextView) view.findViewById(R.id.txt_div_five);
            txt_div_six = (TextView) view.findViewById(R.id.txt_div_six);
            // keyboard views
            img_btn_one = (ImageView) view.findViewById(R.id.img_btn_one);
            img_btn_two = (ImageView) view.findViewById(R.id.img_btn_two);
            img_btn_three = (ImageView) view.findViewById(R.id.img_btn_three);
            img_btn_four = (ImageView) view.findViewById(R.id.img_btn_four);
            img_btn_five = (ImageView) view.findViewById(R.id.img_btn_five);
            img_btn_six = (ImageView) view.findViewById(R.id.img_btn_six);
            img_btn_seven = (ImageView) view.findViewById(R.id.img_btn_seven);
            img_btn_eight = (ImageView) view.findViewById(R.id.img_btn_eight);
            img_btn_nine = (ImageView) view.findViewById(R.id.img_btn_nine);
            img_btn_zero = (ImageView) view.findViewById(R.id.img_btn_zero);
            //font for textview
            setFontStyle();
            //onclicks for keyboard
            img_btn_one.setOnTouchListener(this);
            img_btn_two.setOnTouchListener(this);
            img_btn_three.setOnTouchListener(this);
            img_btn_four.setOnTouchListener(this);
            img_btn_five.setOnTouchListener(this);
            img_btn_six.setOnTouchListener(this);
            img_btn_seven.setOnTouchListener(this);
            img_btn_eight.setOnTouchListener(this);
            img_btn_nine.setOnTouchListener(this);
            img_btn_zero.setOnTouchListener(this);
            img_home.setOnTouchListener(this);
            img_settings.setOnTouchListener(this);
            rl_addition.setOnTouchListener(this);
            rl_division.setOnTouchListener(this);
            rl_minus.setOnTouchListener(this);
            ll_multiplication.setOnTouchListener(this);
            rl_panda.setOnTouchListener(this);
            img_info.setOnTouchListener(this);
            ll_cal.setOnTouchListener(this);
            ll_cal_zero.setOnTouchListener(this);

            //setting gone if panda is visible
            main_layout.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    if (img_panda.getVisibility() == View.VISIBLE) {
                        img_panda.setVisibility(View.GONE);
                        txt_pandatext.setVisibility(View.GONE);
                    }
                    return true;
                }
            });

            //panda on touch
            rl_panda.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    if (rl_panda.getVisibility() == View.VISIBLE) {
                        rl_panda.setVisibility(View.GONE);
                    }
                    return true;
                }
            });

            //getting the shared preference values
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
            tag = prefs.getString("tag", "");
            sound_share = prefs.getBoolean("sound", true);
            if (LaunchActivity.fromLaunch) {
                LaunchActivity.fromLaunch = false;
                //change operation coming from launch only
                changeOperation();
            } else {
                //change operation coming from other than launch
                changeOperationSwipe();
            }


        }

        return view;
    }

    //setting the font style for the textviews
    private void setFontStyle() {
        mfont.fontChange(txt_learn_header, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_rand_one_add, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_rand_two_add, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_first_num_add, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_second_num_add, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_result_first_digit, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_result_second_digit, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_result_fisrt_demo, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_result_second_demo, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_rand_one_mul, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_rand_two_mul, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_first_num_mul, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_second_num_mul, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_result_first_digit_mul, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_result_second_digit_mul, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_result_fisrt_demo_mul, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_result_second_demo_mul, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_rand_one_sub, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_rand_two_sub, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_total_sub, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_sub_one, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_sub_two, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_sub_three, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_sub_four, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_sub_five, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_sub_six, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_rand_one_div, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_rand_two_div, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_total_div, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_div_one, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_div_two, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_div_three, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_div_four, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_div_five, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_div_six, "fonts/textFont.ttf", getActivity());
    }

    //genarate Random Number for Add
    private void genarateRandomAdd() {
        //calling the panda for displaying the image
        if (countForPanda == 5) {
            displayingPanda();
        }
        countForPanda++;
        //genarate random numbers
        firstRanNum = genarateRandom();
        secondRanNum = genarateRandom();
        finalAddition = String.valueOf(firstRanNum + secondRanNum);
        //setting visibility for the two digits
        if (finalAddition.length() == 2) {
            txt_result_second_digit.setVisibility(View.VISIBLE);
        } else {
            txt_result_second_digit.setVisibility(View.INVISIBLE);
        }
        //empty the views before setting the value
        txt_first_num_add.setText("");
        txt_second_num_add.setText("");
        txt_result_first_digit.setText("");
        txt_result_second_digit.setText("");
        txt_result_fisrt_demo.setText("");
        txt_result_second_demo.setText("");
        img_arrow.setVisibility(View.GONE);
        //setting the random number
        txt_rand_one_add.setText(String.valueOf(firstRanNum));
        txt_rand_two_add.setText(String.valueOf(secondRanNum));
    }

    //genarating Random Number for multiplication
    private void genarateRandomMul() {
        //calling the panda for displaying the image
        if (countForPanda == 5) {
            displayingPanda();
        }
        countForPanda++;
        //genarate random numbers
        firstRanNum = genarateRandom();
        secondRanNum = genarateRandom();
        finalMultiplication = String.valueOf(firstRanNum * secondRanNum);
        //setting visibility for two digits
        if (finalMultiplication.length() == 2) {
            txt_result_second_digit_mul.setVisibility(View.VISIBLE);
        } else {
            txt_result_second_digit_mul.setVisibility(View.INVISIBLE);
        }
        //empty the views before value set
        txt_first_num_mul.setText("");
        txt_second_num_mul.setText("");
        txt_result_first_digit_mul.setText("");
        txt_result_second_digit_mul.setText("");
        txt_result_fisrt_demo_mul.setText("");
        txt_result_second_demo_mul.setText("");
        img_arrow_mul.setVisibility(View.GONE);
        //setting the random number
        txt_rand_one_mul.setText(String.valueOf(firstRanNum));
        txt_rand_two_mul.setText(String.valueOf(secondRanNum));
    }

    //genarate random numbers for substraction
    private void generateRandomSub() {
        //calling the panda for displaying the image
        if (countForPanda == 5) {
            displayingPanda();
        }
        countForPanda++;
        firstRanNum = genarateRandom();
        secondRanNum = genarateRandom();
        mtotalSub = firstRanNum + secondRanNum;
        //for same random numbers
        if (firstRanNum == secondRanNum) {
            muserSubSame = true;
        } else {
            muserSubSame = false;
        }
        //for two digit result
        if (String.valueOf(mtotalSub).length() > 1) {
            muserSubBaseBoolen = true;
            muserSubBaseBoolenFour = true;
            muserSubBoolen = true;
            muserSubBoolenFour = true;

        } else {
            muserSubBaseBoolen = false;
            muserSubBaseBoolenFour = false;
            muserSubBoolen = false;
            muserSubBoolenFour = false;
        }
        //setting the random values to the views
        txt_rand_one_sub.setText(String.valueOf(firstRanNum));
        txt_rand_two_sub.setText(String.valueOf(secondRanNum));
        txt_total_sub.setText(String.valueOf(mtotalSub));
        //empty the views before value is change
        txt_sub_one.setText("");
        txt_sub_two.setText("");
        txt_sub_three.setText("");
        txt_sub_four.setText("");
        txt_sub_five.setText("");
        txt_sub_six.setText("");
    }

    //genarate random numbers for division
    private void generateRandomDiv() {
        if (countForPanda == 5) {
            //calling the panda for displaying the image
            displayingPanda();
        }
        countForPanda++;
        firstRanNum = genarateRandom();
        secondRanNum = genarateRandom();
        mtotalSub = firstRanNum * secondRanNum;
        //for same random numbers
        if (firstRanNum == secondRanNum) {
            muserSubSame = true;
        } else {
            muserSubSame = false;
        }
        //for two digit result
        if (String.valueOf(mtotalSub).length() > 1) {
            muserSubBaseBoolen = true;
            muserSubBaseBoolenFour = true;
            muserSubBoolen = true;
            muserSubBoolenFour = true;

        } else {
            muserSubBaseBoolen = false;
            muserSubBaseBoolenFour = false;
            muserSubBoolen = false;
            muserSubBoolenFour = false;
        }
        //setting the random numbers for views
        txt_rand_one_div.setText(String.valueOf(firstRanNum));
        txt_rand_two_div.setText(String.valueOf(secondRanNum));
        txt_total_div.setText(String.valueOf(mtotalSub));
        //empty the views before changing value
        txt_div_one.setText("");
        txt_div_two.setText("");
        txt_div_three.setText("");
        txt_div_four.setText("");
        txt_div_five.setText("");
        txt_div_six.setText("");
    }

    //genarating Random Number
    public int genarateRandom() {
        int min = 1;
        int max = 9;
        Random r = new Random();
        int ranNum = r.nextInt(max - min + 1) + min;
        return ranNum;
    }

    //changing the operation based on the selection
    private void changeOperation() {
        //for intial sound
        mediaService(R.raw.sucess);
        countForPanda = 0;
        forPanda = "first";
        switch (tag) {
            case "add":
                img_change.setImageResource(R.drawable.plus);
                img_change.setTag("add");
                tag = "add";
                timerDelayRemoveView(img_change);
                rl_addition.setVisibility(View.VISIBLE);
                rl_minus.setVisibility(View.GONE);
                rl_division.setVisibility(View.GONE);
                ll_multiplication.setVisibility(View.GONE);
                genarateRandomAdd();
                break;
            case "sub":
                img_change.setImageResource(R.drawable.minus);
                img_change.setTag("sub");
                tag = "sub";
                timerDelayRemoveView(img_change);
                rl_addition.setVisibility(View.GONE);
                rl_minus.setVisibility(View.VISIBLE);
                rl_division.setVisibility(View.GONE);
                ll_multiplication.setVisibility(View.GONE);
                generateRandomSub();
                break;
            case "mul":
                img_change.setImageResource(R.drawable.cross);
                img_change.setTag("mul");
                tag = "mul";
                timerDelayRemoveView(img_change);
                rl_addition.setVisibility(View.GONE);
                rl_minus.setVisibility(View.GONE);
                rl_division.setVisibility(View.GONE);
                ll_multiplication.setVisibility(View.VISIBLE);
                genarateRandomMul();
                break;
            case "div":
                img_change.setImageResource(R.drawable.division);
                img_change.setTag("div");
                tag = "div";
                timerDelayRemoveView(img_change);
                rl_addition.setVisibility(View.GONE);
                rl_minus.setVisibility(View.GONE);
                rl_division.setVisibility(View.VISIBLE);
                ll_multiplication.setVisibility(View.GONE);
                generateRandomDiv();
                break;
        }
    }

    //changing the operation while siping the screen
    private void changeOperationSwipe() {
        countForPanda = 0;
        forPanda = "first";
        if (tag.equals("add")) {
            img_change.setTag("add");
            rl_addition.setVisibility(View.VISIBLE);
            rl_minus.setVisibility(View.GONE);
            rl_division.setVisibility(View.GONE);
            ll_multiplication.setVisibility(View.GONE);
            genarateRandomAdd();
        } else if (tag.equals("sub")) {
            img_change.setTag("sub");
            rl_addition.setVisibility(View.GONE);
            rl_minus.setVisibility(View.VISIBLE);
            rl_division.setVisibility(View.GONE);
            ll_multiplication.setVisibility(View.GONE);
            generateRandomSub();
        } else if (tag.equals("mul")) {
            img_change.setTag("mul");
            rl_addition.setVisibility(View.GONE);
            rl_minus.setVisibility(View.GONE);
            rl_division.setVisibility(View.GONE);
            ll_multiplication.setVisibility(View.VISIBLE);
            genarateRandomMul();
        } else if (tag.equals("div")) {
            img_change.setTag("div");
            rl_addition.setVisibility(View.GONE);
            rl_minus.setVisibility(View.GONE);
            rl_division.setVisibility(View.VISIBLE);
            ll_multiplication.setVisibility(View.GONE);
            generateRandomDiv();
        }
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {
            // Check vertical and horizontal touches
            case MotionEvent.ACTION_DOWN: {
                downX = motionEvent.getX();
                downY = motionEvent.getY();
                return true;
            }
            case MotionEvent.ACTION_UP: {
                upX = motionEvent.getX();
                upY = motionEvent.getY();
                float endX = motionEvent.getX();
                float endY = motionEvent.getY();

                if (isAClick(downX, endX, downY, endY)) {
                    onClick(view);
                } else {
                    float deltaX = downX - upX;
                    float deltaY = downY - upY;
                    //HORIZONTAL SCROLL
                    if (Math.abs(deltaX) > Math.abs(deltaY)) {
                        mediaService(R.raw.swoosh);
                        if (Math.abs(deltaX) > mMinDistance) {
                            // left or right
                            if (deltaX < 0) {
                                //swipe left
                                Settings settings = new Settings();
                                getFragmentManager().beginTransaction()
                                        .setCustomAnimations(
                                                R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                                                R.animator.card_flip_right_in, R.animator.card_flip_right_out)
                                        .replace(R.id.frag, settings)
                                        .addToBackStack(null)
                                        .commit();
                                return true;
                            }
                            if (deltaX > 0) {
                                ApplyMath applyfacts = new ApplyMath();
                                getFragmentManager().beginTransaction()
                                        .setCustomAnimations(
                                                R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                                                R.animator.card_flip_right_in, R.animator.card_flip_right_out)
                                        .replace(R.id.frag, applyfacts)
                                        .addToBackStack(null)
                                        .commit();
                                return true;
                            }
                        } else {
                            return false;
                        }
                    }
                    //VERTICAL SCROLL
                    else {
                        if (Math.abs(deltaY) > mMinDistance) {
                            // top or down
                            if (deltaY < 0) {

                                countForPanda = 0;
                                forPanda = "first";
                                //for change operator sound
                                mediaService(R.raw.change);
                                if ("add".equals(img_change.getTag())) {
                                    img_change.setImageResource(R.drawable.division);
                                    img_change.setTag("div");
                                    tag = "div";
                                    timerDelayRemoveView(img_change);
                                    rl_addition.setVisibility(View.GONE);
                                    rl_minus.setVisibility(View.GONE);
                                    rl_division.setVisibility(View.VISIBLE);
                                    ll_multiplication.setVisibility(View.GONE);
                                    generateRandomDiv();
                                    saveSelectedOperation(tag);
                                } else if ("sub".equals(img_change.getTag())) {
                                    img_change.setImageResource(R.drawable.plus);
                                    img_change.setTag("add");
                                    tag = "add";
                                    timerDelayRemoveView(img_change);
                                    rl_addition.setVisibility(View.VISIBLE);
                                    rl_minus.setVisibility(View.GONE);
                                    rl_division.setVisibility(View.GONE);
                                    ll_multiplication.setVisibility(View.GONE);
                                    genarateRandomAdd();
                                    saveSelectedOperation(tag);
                                } else if ("mul".equals(img_change.getTag())) {
                                    img_change.setImageResource(R.drawable.minus);
                                    img_change.setTag("sub");
                                    tag = "sub";
                                    timerDelayRemoveView(img_change);
                                    rl_addition.setVisibility(View.GONE);
                                    rl_minus.setVisibility(View.VISIBLE);
                                    rl_division.setVisibility(View.GONE);
                                    ll_multiplication.setVisibility(View.GONE);
                                    generateRandomSub();
                                    saveSelectedOperation(tag);
                                } else if ("div".equals(img_change.getTag())) {
                                    img_change.setImageResource(R.drawable.cross);
                                    img_change.setTag("mul");
                                    tag = "mul";
                                    timerDelayRemoveView(img_change);
                                    rl_addition.setVisibility(View.GONE);
                                    rl_minus.setVisibility(View.GONE);
                                    rl_division.setVisibility(View.GONE);
                                    ll_multiplication.setVisibility(View.VISIBLE);
                                    genarateRandomMul();
                                    saveSelectedOperation(tag);
                                }
                                return true;
                            }
                            if (deltaY > 0) {
                                countForPanda = 0;
                                forPanda = "first";
                                //for change operator sound
                                mediaService(R.raw.change);
                                // swipe up
                                if ("add".equals(img_change.getTag())) {
                                    img_change.setImageResource(R.drawable.minus);
                                    img_change.setTag("sub");
                                    tag = "sub";
                                    timerDelayRemoveView(img_change);
                                    rl_addition.setVisibility(View.GONE);
                                    rl_minus.setVisibility(View.VISIBLE);
                                    rl_division.setVisibility(View.GONE);
                                    ll_multiplication.setVisibility(View.GONE);
                                    generateRandomSub();
                                    saveSelectedOperation(tag);
                                } else if ("sub".equals(img_change.getTag())) {
                                    img_change.setImageResource(R.drawable.cross);
                                    img_change.setTag("mul");
                                    tag = "mul";
                                    timerDelayRemoveView(img_change);
                                    rl_addition.setVisibility(View.GONE);
                                    rl_minus.setVisibility(View.GONE);
                                    rl_division.setVisibility(View.GONE);
                                    ll_multiplication.setVisibility(View.VISIBLE);
                                    genarateRandomMul();
                                    saveSelectedOperation(tag);
                                } else if ("mul".equals(img_change.getTag())) {
                                    img_change.setImageResource(R.drawable.division);
                                    img_change.setTag("div");
                                    tag = "div";
                                    timerDelayRemoveView(img_change);
                                    rl_addition.setVisibility(View.GONE);
                                    rl_minus.setVisibility(View.GONE);
                                    rl_division.setVisibility(View.VISIBLE);
                                    ll_multiplication.setVisibility(View.GONE);
                                    generateRandomDiv();
                                    saveSelectedOperation(tag);
                                } else if ("div".equals(img_change.getTag())) {
                                    img_change.setImageResource(R.drawable.plus);
                                    img_change.setTag("add");
                                    tag = "add";
                                    timerDelayRemoveView(img_change);
                                    rl_addition.setVisibility(View.VISIBLE);
                                    rl_minus.setVisibility(View.GONE);
                                    rl_division.setVisibility(View.GONE);
                                    ll_multiplication.setVisibility(View.GONE);
                                    genarateRandomAdd();
                                    saveSelectedOperation(tag);
                                }
                                return true;
                            }
                        } else {
                            //not long enough swipe...
                            return false;
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    //performing onclick for views
    public void onClick(View v) {
        //onclicks for views
        switch (v.getId()) {
            case R.id.img_btn_zero:
                keyNum = "0";
                break;
            case R.id.img_btn_one:
                keyNum = "1";
                break;
            case R.id.img_btn_two:
                keyNum = "2";
                break;
            case R.id.img_btn_three:
                keyNum = "3";
                break;
            case R.id.img_btn_four:
                keyNum = "4";
                break;
            case R.id.img_btn_five:
                keyNum = "5";
                break;
            case R.id.img_btn_six:
                keyNum = "6";
                break;
            case R.id.img_btn_seven:
                keyNum = "7";
                break;
            case R.id.img_btn_eight:
                keyNum = "8";
                break;
            case R.id.img_btn_nine:
                keyNum = "9";
                break;
            case R.id.img_home:
                //home onclick
                keyNum = "";
                getActivity().finish();
                break;
            case R.id.img_settings:
                //settings onclick
                keyNum = "";
                Settings settings = new Settings();
                getFragmentManager().beginTransaction()
                        .replace(R.id.frag, settings)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.img_info:
                showDialogInfo();

                break;
            default:
                keyNum = "";
                break;
        }
        if (!keyNum.equals("")) {
            if (tag.equals("add")) {
                //setting the values for addition
                img_arrow.setVisibility(View.GONE);
                functionalityAdd();
            } else if (tag.equals("mul")) {
                //setting the values for multiplication
                img_arrow_mul.setVisibility(View.GONE);
                functionalityMul();
            } else if (tag.equals("sub")) {
                functionalitySub(keyNum);
            } else if (tag.equals("div")) {
                functionalityDiv(keyNum);
            }
        }
    }

    //save the selected operation
    public void saveSelectedOperation(String tag) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("tag", tag);
        editor.commit();
    }

    //addition Functionality
    private void functionalityAdd() {
        if (txt_first_num_add.getText().toString().equals("")) {
            //checking the enter number with second random number
            if (keyNum.equals(txt_rand_two_add.getText().toString())) {
                txt_first_num_add.setText(keyNum);
                //media yes
                mediaService(R.raw.yes);
            } else {
                img_arrow.setVisibility(View.VISIBLE);
                img_arrow.setImageResource(R.drawable.down_left);
                //media no
                mediaService(R.raw.no);
            }
        } else if (txt_second_num_add.getText().toString().equals("")) {
            //checking the enter number with first random number
            if (keyNum.equals(txt_rand_one_add.getText().toString())) {
                txt_second_num_add.setText(keyNum);
                //media yes
                mediaService(R.raw.yes);
            } else {
                img_arrow.setVisibility(View.VISIBLE);
                img_arrow.setImageResource(R.drawable.downright);
                //media no
                mediaService(R.raw.no);
            }
        } else if (txt_result_first_digit.getText().toString().equals("")) {
            //check the length of the fianl result and set the value
            if (finalAddition.length() <= 1 && keyNum.equals(finalAddition)) {
                //media sucess
                mediaService(R.raw.sucess);
                txt_result_first_digit.setText(keyNum);
                txt_result_fisrt_demo.setText(keyNum);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        genarateRandomAdd();
                    }
                }, 1000);
            } else if (finalAddition.length() == 2) {
                //check the length of the fianl result and set the second digit
                String firstChar = String.valueOf(finalAddition.charAt(0));
                if (keyNum.equals(firstChar)) {
                    //media yes
                    mediaService(R.raw.yes);
                    txt_result_first_digit.setText(keyNum);
                    txt_result_fisrt_demo.setText(keyNum);
                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            } else {
                //media no
                mediaService(R.raw.no);
            }
        } else if (finalAddition.length() > 1) {
            if (txt_result_second_digit.getText().toString().equals("")) {
                String secondChar = String.valueOf(finalAddition.charAt(1));
                if (keyNum.equals(secondChar)) {
                    txt_result_second_digit.setText(keyNum);
                    txt_result_second_demo.setText(keyNum);
                    //media sucess
                    mediaService(R.raw.sucess);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            genarateRandomAdd();
                        }
                    }, 1000);
                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            } else {
                //media no
                mediaService(R.raw.no);
            }
        } else {
            //media no
            mediaService(R.raw.no);
        }
    }

    //Multiplication Functionality
    private void functionalityMul() {
        if (txt_first_num_mul.getText().toString().equals("")) {
            if (keyNum.equals(txt_rand_two_mul.getText().toString())) {
                //media yes
                mediaService(R.raw.yes);
                txt_first_num_mul.setText(keyNum);
            } else {
                //media no
                mediaService(R.raw.no);
                img_arrow_mul.setVisibility(View.VISIBLE);
                img_arrow_mul.setImageResource(R.drawable.down_left);
            }
        } else if (txt_second_num_mul.getText().toString().equals("")) {
            if (keyNum.equals(txt_rand_one_mul.getText().toString())) {
                txt_second_num_mul.setText(keyNum);
                //media yes
                mediaService(R.raw.yes);
            } else {
                img_arrow_mul.setVisibility(View.VISIBLE);
                img_arrow_mul.setImageResource(R.drawable.downright);
                //media no
                mediaService(R.raw.no);
            }
        } else if (txt_result_first_digit_mul.getText().toString().equals("")) {
            if (finalMultiplication.length() <= 1 && keyNum.equals(finalMultiplication)) {
                txt_result_first_digit_mul.setText(keyNum);
                txt_result_fisrt_demo_mul.setText(keyNum);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        genarateRandomMul();
                    }
                }, 1000);
                //media success
                mediaService(R.raw.sucess);
            } else if (finalMultiplication.length() == 2) {
                String firstChar = String.valueOf(finalMultiplication.charAt(0));
                if (keyNum.equals(firstChar)) {
                    txt_result_first_digit_mul.setText(keyNum);
                    txt_result_fisrt_demo_mul.setText(keyNum);
                    //media yes
                    mediaService(R.raw.yes);
                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            } else {
                //media no
                mediaService(R.raw.no);
            }
        } else if (finalMultiplication.length() > 1) {
            if (txt_result_second_digit_mul.getText().toString().equals("")) {
                String secondChar = String.valueOf(finalMultiplication.charAt(1));
                if (keyNum.equals(secondChar)) {
                    txt_result_second_digit_mul.setText(keyNum);
                    txt_result_second_demo_mul.setText(keyNum);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            genarateRandomMul();
                        }
                    }, 1000);
                    //media success
                    mediaService(R.raw.sucess);
                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            } else {
                //media no
                mediaService(R.raw.no);
            }
        } else {
            //media no
            mediaService(R.raw.no);
        }
    }

    //division functionality
    private void functionalityDiv(String keyNum) {
        int user_number = Integer.parseInt(keyNum);
        //conditions for box one
        if (muserSubBaseBoolen || txt_div_one.getText().toString().equals("")) {
            //if box one requires two digits
            if (muserSubBaseBoolen) {
                //for first digit
                if (muserSubBoolen && Integer.parseInt(String.valueOf(String.valueOf(mtotalSub).charAt(0))) == user_number) {
                    txt_div_one.setText(String.valueOf(user_number));
                    muserSubBaseInt = user_number;
                    muserSubBoolen = false;
                    //media yes
                    mediaService(R.raw.yes);
                    //for second digit
                } else if (!muserSubBoolen && Integer.parseInt(String.valueOf(String.valueOf(mtotalSub).charAt(1))) == user_number) {
                    String a = String.valueOf(muserSubBaseInt) + String.valueOf(user_number);
                    txt_div_one.setText(a);
                    muserSubBaseBoolen = false;
                    //media yes
                    mediaService(R.raw.yes);
                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            }
            //  if box one contains single digit
            else {
                if (mtotalSub == user_number) {
                    txt_div_one.setText(String.valueOf(user_number));
                    //media yes
                    mediaService(R.raw.yes);
                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            }
        }
        //conditon for second box
        else if (txt_div_two.getText().toString().equals("")) {
            if (firstRanNum == user_number || secondRanNum == user_number) {
                txt_div_two.setText(String.valueOf(user_number));
                muserSubTwo = user_number;
                //media yes
                mediaService(R.raw.yes);
            } else {
                //media no
                mediaService(R.raw.no);
            }
        }
        //conditon for third box
        else if (txt_div_three.getText().toString().equals("")) {
            //result condition on third box
            if (user_number == (mtotalSub / muserSubTwo)) {
                txt_div_three.setText(String.valueOf(user_number));
                //media sucess
                mediaService(R.raw.sucess);
            } else {
                //media no
                mediaService(R.raw.no);
            }

        }
        //condition for fourth box
        else if (muserSubBaseBoolenFour || txt_div_four.getText().toString().equals("")) {
            //if it contains two digits
            if (muserSubBaseBoolenFour) {
                //for 1st digit
                if (muserSubBoolenFour && Integer.parseInt(String.valueOf(String.valueOf(mtotalSub).charAt(0))) == user_number) {
                    txt_div_four.setText(String.valueOf(user_number));
                    muserSubBaseInt = user_number;
                    muserSubBoolenFour = false;
                    //media yes
                    mediaService(R.raw.yes);
                    //for 2nd digit
                } else if (!muserSubBoolenFour && Integer.parseInt(String.valueOf(String.valueOf(mtotalSub).charAt(1))) == user_number) {
                    String a = String.valueOf(muserSubBaseInt) + String.valueOf(user_number);
                    txt_div_four.setText(a);
                    muserSubBaseBoolenFour = false;
                    //media yes
                    mediaService(R.raw.yes);
                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            }
            //if it contains single digit
            else {
                if (mtotalSub == user_number) {
                    txt_div_four.setText(String.valueOf(user_number));
                    //media yes
                    mediaService(R.raw.yes);
                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            }
        }
        //condition for fifth box
        else if (txt_div_five.getText().toString().equals("")) {
//if box 2 and box five should have same number or not
            if (muserSubSame ? muserSubTwo == user_number : muserSubTwo != user_number && (user_number == firstRanNum || user_number == secondRanNum)) {
                txt_div_five.setText(String.valueOf(user_number));
                muserSubFive = user_number;
                //media yes
                mediaService(R.raw.yes);
            } else {
                //media no
                mediaService(R.raw.no);
            }
        }
        //condition for final box
        else if (txt_div_six.getText().toString().equals("")) {

            if (user_number == (mtotalSub / muserSubFive)) {
                txt_div_six.setText(String.valueOf(user_number));
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        generateRandomDiv();
                    }
                }, 1000);
                //media sucess
                mediaService(R.raw.sucess);
            } else {
                //media no
                mediaService(R.raw.no);
            }
        } else {
            //media no
            mediaService(R.raw.no);
        }
    }

    // substraction functionality
    private void functionalitySub(String keynum) {
        int user_number = Integer.parseInt(keynum);
        //condition for first box
        if (muserSubBaseBoolen || txt_sub_one.getText().toString().equals("")) {
            //condition if total result is two digits
            if (muserSubBaseBoolen) {
                //condition if total result is two digits  and for first number
                if (muserSubBoolen && Integer.parseInt(String.valueOf(String.valueOf(mtotalSub).charAt(0))) == user_number) {
                    txt_sub_one.setText(String.valueOf(user_number));
                    muserSubBaseInt = user_number;
                    muserSubBoolen = false;
                    //media yes
                    mediaService(R.raw.yes);
                }
                //condition if total result is two digits  and for second number
                else if (!muserSubBoolen && Integer.parseInt(String.valueOf(String.valueOf(mtotalSub).charAt(1))) == user_number) {
                    String a = String.valueOf(muserSubBaseInt) + String.valueOf(user_number);
                    txt_sub_one.setText(a);
                    muserSubBaseBoolen = false;
                    //media yes
                    mediaService(R.raw.yes);
                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            }
            //condition if total result is single digits
            else {
                //checks weather user entry and result matches
                if (mtotalSub == user_number) {
                    txt_sub_one.setText(String.valueOf(user_number));
                    //media yes
                    mediaService(R.raw.yes);
                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            }
        }
        //condition for second box any of random number
        else if (txt_sub_two.getText().toString().equals("")) {
            //any of random number
            if (firstRanNum == user_number || secondRanNum == user_number) {
                txt_sub_two.setText(String.valueOf(user_number));
                muserSubTwo = user_number;
                //media yes
                mediaService(R.raw.yes);
            } else {
                //media no
                mediaService(R.raw.no);
            }
        }
        //condition for third box
        else if (txt_sub_three.getText().toString().equals("")) {
            //result of one and two
            if (user_number == (mtotalSub - muserSubTwo)) {
                txt_sub_three.setText(String.valueOf(user_number));
                //media sucess
                mediaService(R.raw.sucess);
            } else {
                //media no
                mediaService(R.raw.no);
            }
        }
        //condition for fourth box
        else if (muserSubBaseBoolenFour || txt_sub_four.getText().toString().equals("")) {
//if it contains two digits
            if (muserSubBaseBoolenFour) {
// condition for first digit
                if (muserSubBoolenFour && Integer.parseInt(String.valueOf(String.valueOf(mtotalSub).charAt(0))) == user_number) {
                    txt_sub_four.setText(String.valueOf(user_number));
                    muserSubBaseInt = user_number;
                    muserSubBoolenFour = false;
                    //media yes
                    mediaService(R.raw.yes);
                }
                //condition for second digit
                else if (!muserSubBoolenFour && Integer.parseInt(String.valueOf(String.valueOf(mtotalSub).charAt(1))) == user_number) {
                    String a = String.valueOf(muserSubBaseInt) + String.valueOf(user_number);
                    txt_sub_four.setText(a);
                    muserSubBaseBoolenFour = false;
                    //media yes
                    mediaService(R.raw.yes);
                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            }
            //if it contains single digits
            else {
                if (mtotalSub == user_number) {
                    txt_sub_four.setText(String.valueOf(user_number));
                    //media yes
                    mediaService(R.raw.yes);
                } else {
                    //media no
                    mediaService(R.raw.no);
                }
            }
        }
        //condition for fifth box
        else if (txt_sub_five.getText().toString().equals("")) {
//it checks whether 5th box and 2nd box should have same numbers or not
            if (muserSubSame ? muserSubTwo == user_number : muserSubTwo != user_number && (user_number == firstRanNum || user_number == secondRanNum)) {
                txt_sub_five.setText(String.valueOf(user_number));
                muserSubFive = user_number;
                //media yes
                mediaService(R.raw.yes);
            } else {
                //media no
                mediaService(R.raw.no);
            }
        }
        //condition for sixth box
        else if (txt_sub_six.getText().toString().equals("")) {
            //condition for result
            if (user_number == (mtotalSub - muserSubFive)) {
                txt_sub_six.setText(String.valueOf(user_number));

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        generateRandomSub();
                    }
                }, 1000);
                //media sucess
                mediaService(R.raw.sucess);
            } else {
                //media no
                mediaService(R.raw.no);
            }
        } else {
            //media no
            mediaService(R.raw.no);
        }
    }

    // setting the time for displaying the operation image
    public void timerDelayRemoveView(final ImageView v) {
        v.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                v.setVisibility(View.GONE);
            }
        }, 500);
    }

    //displaying panda after every successful 5 times
    public void displayingPanda() {
        if (forPanda.equals("first")) {
            countForPanda = 0;
            forPanda = "second";
            rl_panda.setVisibility(View.VISIBLE);
            GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(img_panda);
            Glide.with(getActivity()).load(R.drawable.panda_one).into(imageViewTarget);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    if (rl_panda.getVisibility() == View.VISIBLE) {
                        rl_panda.setVisibility(View.GONE);
                    }
                }
            }, 6000);
        } else if (forPanda.equals("second")) {
            countForPanda = 0;
            forPanda = "third";
            rl_panda.setVisibility(View.VISIBLE);
            GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(img_panda);
            Glide.with(getActivity()).load(R.drawable.panda_two).into(imageViewTarget);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    if (rl_panda.getVisibility() == View.VISIBLE) {
                        rl_panda.setVisibility(View.GONE);
                    }
                }
            }, 6000);
        } else if (forPanda.equals("third")) {
            countForPanda = 0;
            forPanda = "first";
            rl_panda.setVisibility(View.VISIBLE);
            GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(img_panda);
            Glide.with(getActivity()).load(R.drawable.panda_three).into(imageViewTarget);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    if (rl_panda.getVisibility() == View.VISIBLE) {
                        rl_panda.setVisibility(View.GONE);
                    }
                }
            }, 6000);
        }
    }

    //For playing the sounds
    public void mediaService(int raw) {
        if (sound_share) {
            final MediaPlayer mp = MediaPlayer.create(getActivity(), raw);
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
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // for finding the onclick
    private boolean isAClick(float startX, float endX, float startY, float endY) {
        float differenceX = Math.abs(startX - endX);
        float differenceY = Math.abs(startY - endY);
        return !(differenceX > CLICK_ACTION_THRESHOLD /* =5 */ || differenceY > CLICK_ACTION_THRESHOLD);
    }

    //Dialog for info
    private void showDialogInfo() {
        final Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.info_dialog);
        TextView tv_head = (TextView) dialog.findViewById(R.id.tv_head);
        TextView tv_body = (TextView) dialog.findViewById(R.id.tv_body);
        TextView txt_info_header = (TextView) dialog.findViewById(R.id.txt_info_head);
        mfont.fontChange(tv_head, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(tv_body, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_info_header, "fonts/textFont.ttf", getActivity());


        tv_head.setText(getResources().getString(R.string.info_learn_head));
        tv_body.setText(getResources().getString(R.string.learn_facts_info));
        RelativeLayout rl_dissmiss = (RelativeLayout) dialog.findViewById(R.id.rl_dissmiss);
        rl_dissmiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        ImageView img_dissmiss = (ImageView) dialog.findViewById(R.id.img_close_info);
        img_dissmiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
