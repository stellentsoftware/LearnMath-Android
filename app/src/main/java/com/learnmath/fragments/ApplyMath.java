package com.learnmath.Fragments;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.learnmath.R;
import com.learnmath.Tasks.ApplyFactAddition;
import com.learnmath.Tasks.ApplyFactDivision;
import com.learnmath.Tasks.ApplyFactMultiplication;
import com.learnmath.Tasks.ApplyFactsSubtraction;
import com.learnmath.Tasks.DrillAddition;
import com.learnmath.Utils.FontChange;
import com.learnmath.Utils.Util;

/**
 * Created by stellent on 10/4/2017.
 */
public class ApplyMath extends Fragment implements View.OnTouchListener {
    FontChange mfont = new FontChange();
    Util util = new Util();
    RelativeLayout rl_facts_main, rl_apply_sub, rl_apply_add, rl_apply_mul, rl_panda, ll_cal, rl_apply_division;
    LinearLayout ll_keyboard;
    ImageView img_change;
    public static boolean apply_facts_timer = false;
    //For swiping left,right,top,bottom
    private int minDistance = 100;
    private float downX, downY, upX, upY;
    ImageView img_info, img_btn_one, img_btn_two, img_btn_three, img_btn_four, img_btn_five, img_btn_six, img_btn_seven, img_btn_eight, img_btn_nine, img_btn_zero, img_home, img_settings;
    TextView tv_apply_header, tv_btn_one, tv_btn_two, tv_btn_three, tv_btn_four, tv_btn_five, tv_btn_six, tv_btn_seven, tv_btn_eight, tv_btn_nine, tv_btn_zer0, tv_btn_rem;
    public final int CLICK_ACTION_THRESHOLD = 200;
    String applyTag;
    TextView txt_pandatext, tv_regroup;
    ImageView img_panda;
    public static int levelChange = 1;
    public static int level = 1;
    //Count variable for displaying panda
    public static int countForPanda = 0;
    //Static variable for displaying panda
    public static String forPandaApply = "first";
    public String keyNum = "";
    public static boolean soundShare = false;
    public ApplyFactAddition applyAdition;
    public ApplyFactMultiplication applyMultiplication;
    public ApplyFactsSubtraction applyFactsSubstraction;
    public ApplyFactDivision applyFactDivision;
    public static boolean timerNotNullApplyfacts = false, fromFirst = false, applyInstance = false;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.apply_facts, container, false);
            applyInstance = false;
            rl_facts_main = (RelativeLayout) view.findViewById(R.id.rl_facts_main);
            rl_apply_add = (RelativeLayout) view.findViewById(R.id.rl_apply_add);
            rl_apply_sub = (RelativeLayout) view.findViewById(R.id.rl_apply_sub);
            img_change = (ImageView) view.findViewById(R.id.img_change);
            rl_apply_mul = (RelativeLayout) view.findViewById(R.id.rl_apply_mul);
            ll_cal = (RelativeLayout) view.findViewById(R.id.ll_cal);
            rl_apply_division = (RelativeLayout) view.findViewById(R.id.rl_apply_division);
            ll_keyboard = (LinearLayout) view.findViewById(R.id.ll_keyboard);
            img_info = (ImageView) view.findViewById(R.id.img_info);
            tv_regroup = (TextView) view.findViewById(R.id.tv_regroup);
            tv_apply_header = (TextView) view.findViewById(R.id.tv_apply_header);
            //For panda
            txt_pandatext = (TextView) view.findViewById(R.id.txt_pandatext);
            img_panda = (ImageView) view.findViewById(R.id.img_panda);
            rl_panda = (RelativeLayout) view.findViewById(R.id.rl_panda);
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
            tv_btn_one = (TextView) view.findViewById(R.id.tv_btn_one);
            tv_btn_two = (TextView) view.findViewById(R.id.tv_btn_two);
            tv_btn_three = (TextView) view.findViewById(R.id.tv_btn_three);
            tv_btn_four = (TextView) view.findViewById(R.id.tv_btn_four);
            tv_btn_five = (TextView) view.findViewById(R.id.tv_btn_five);
            tv_btn_six = (TextView) view.findViewById(R.id.tv_btn_six);
            tv_btn_seven = (TextView) view.findViewById(R.id.tv_btn_seven);
            tv_btn_eight = (TextView) view.findViewById(R.id.tv_btn_eight);
            tv_btn_nine = (TextView) view.findViewById(R.id.tv_btn_nine);
            tv_btn_zer0 = (TextView) view.findViewById(R.id.tv_btn_zer0);
            tv_btn_rem = (TextView) view.findViewById(R.id.tv_btn_rem);
            img_home = (ImageView) view.findViewById(R.id.img_home);
            img_settings = (ImageView) view.findViewById(R.id.img_settings);
            //Setting font style for the textviews
            setFontStyle();
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
            rl_apply_add.setOnTouchListener(this);
            rl_apply_mul.setOnTouchListener(this);
            rl_apply_sub.setOnTouchListener(this);
            ll_cal.setOnTouchListener(this);
            rl_panda.setOnTouchListener(this);
            tv_regroup.setOnTouchListener(this);
            rl_apply_division.setOnTouchListener(this);
            img_info.setOnTouchListener(this);
            tv_btn_one.setOnTouchListener(this);
            tv_btn_two.setOnTouchListener(this);
            tv_btn_three.setOnTouchListener(this);
            tv_btn_four.setOnTouchListener(this);
            tv_btn_five.setOnTouchListener(this);
            tv_btn_six.setOnTouchListener(this);
            tv_btn_seven.setOnTouchListener(this);
            tv_btn_eight.setOnTouchListener(this);
            tv_btn_nine.setOnTouchListener(this);
            tv_btn_zer0.setOnTouchListener(this);
            tv_btn_rem.setOnTouchListener(this);
            //Getting  values from shared preference
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
            level = Integer.parseInt(prefs.getString("level", "1"));
            applyTag = prefs.getString("apply_tag", "add");
            countForPanda = 0;
            apply_facts_timer = true;
            soundShare = prefs.getBoolean("sound", true);
            //Level change for substraction
            levelChange = level;
            //setting gone if panda is visible
            rl_facts_main.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    if (rl_panda.getVisibility() == View.VISIBLE) {
                        rl_panda.setVisibility(View.GONE);
                        txt_pandatext.setVisibility(View.GONE);
                    }
                    return true;
                }
            });

            //Panda on touch
            rl_panda.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    if (rl_panda.getVisibility() == View.VISIBLE) {
                        rl_panda.setVisibility(View.GONE);
                        txt_pandatext.setVisibility(View.GONE);
                    }
                    return true;
                }
            });

            rl_apply_sub.setVisibility(View.GONE);
            rl_apply_add.setVisibility(View.VISIBLE);
        } else {

            applyInstance = true;
        }
        return view;
    }

    //Setting font style for the textview
    private void setFontStyle() {
        mfont.fontChange(tv_btn_one, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(tv_btn_two, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(tv_btn_three, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(tv_btn_four, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(tv_btn_five, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(tv_btn_six, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(tv_btn_seven, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(tv_btn_eight, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(tv_regroup, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(tv_btn_zer0, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(tv_apply_header, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(tv_btn_rem, "fonts/textFont.ttf", getActivity());

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        if (!applyInstance) {
            applyAdition = new ApplyFactAddition(getActivity());
            applyMultiplication = new ApplyFactMultiplication(getActivity());
            applyFactsSubstraction = new ApplyFactsSubtraction(getActivity());
            applyFactDivision = new ApplyFactDivision(getActivity());
            fromFirst = true;
            //Calling the addition,multiplication,division and substraction views for generate random number
            switch (applyTag) {
                case "add":
                    img_change.setTag("add");
                    rl_apply_add.setVisibility(View.VISIBLE);
                    rl_apply_sub.setVisibility(View.GONE);
                    rl_apply_mul.setVisibility(View.GONE);
                    rl_apply_division.setVisibility(View.GONE);
                    applyAdition.geanarateRandomApplyAdd();
                    break;
                case "mul":
                    img_change.setTag("mul");
                    rl_apply_add.setVisibility(View.GONE);
                    rl_apply_sub.setVisibility(View.GONE);
                    rl_apply_mul.setVisibility(View.VISIBLE);
                    rl_apply_division.setVisibility(View.GONE);
                    applyMultiplication.geanarateRandomApplyMul();
                    break;
                case "sub":
                    img_change.setTag("sub");
                    rl_apply_add.setVisibility(View.GONE);
                    rl_apply_sub.setVisibility(View.VISIBLE);
                    rl_apply_mul.setVisibility(View.GONE);
                    rl_apply_division.setVisibility(View.GONE);
                    applyFactsSubstraction.generateRandomApplySub();
                    break;
                case "div":
                    img_change.setTag("div");
                    rl_apply_division.setVisibility(View.VISIBLE);
                    ll_cal.setVisibility(View.GONE);
                    ll_keyboard.setVisibility(View.GONE);
                    applyFactDivision.geanarateRandomApplyDiv();
                    break;
            }
        }
        super.onViewCreated(view, savedInstanceState);
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
                        util.mediaService(getActivity(),R.raw.swoosh,soundShare);
                        if (Math.abs(deltaX) > minDistance) {
                            // Left or right
                            if (deltaX < 0) {
                                countForPanda = 0;
                                forPandaApply = "first";
                                //Swipe left
                                LearnMath learnFacts = new LearnMath();
                                getFragmentManager().beginTransaction()
                                        .setCustomAnimations(
                                                R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                                                R.animator.card_flip_right_in, R.animator.card_flip_right_out)
                                        .replace(R.id.frag, learnFacts)
                                        .addToBackStack(null)
                                        .commit();
                                return true;
                            }
                            if (deltaX > 0) {
                                countForPanda = 0;
                                forPandaApply = "first";
                                if (Drill.waitTimer != null) {
                                    timerNotNullApplyfacts = true;
                                    DrillAddition.textInt = 0;
                                    Drill.waitTimer.cancel();
                                }
                                Drill fluency = new Drill();

                                getFragmentManager().beginTransaction()
                                        .setCustomAnimations(
                                                R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                                                R.animator.card_flip_right_in, R.animator.card_flip_right_out)
                                        .replace(R.id.frag, fluency)
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
                        if (Math.abs(deltaY) > minDistance) {
                            // Top or down
                            if (deltaY < 0) {
                                countForPanda = 0;
                                fromFirst = true;
                                forPandaApply = "first";
                                //For change operator sound
                                util.mediaService(getActivity(),R.raw.change,soundShare);
                                switch (img_change.getTag().toString()) {
                                    case "add":
                                        img_change.setImageResource(R.drawable.division);
                                        img_change.setTag("div");
                                        applyTag = "div";
                                        timerDelayRemoveView(img_change);
                                        rl_apply_add.setVisibility(View.GONE);
                                        rl_apply_sub.setVisibility(View.GONE);
                                        rl_apply_mul.setVisibility(View.GONE);
                                        rl_apply_division.setVisibility(View.VISIBLE);
                                        ll_cal.setVisibility(View.GONE);
                                        ll_keyboard.setVisibility(View.GONE);
                                        applyFactDivision.geanarateRandomApplyDiv();
                                        saveSelectedOperation(applyTag);
                                        break;


                                    case "sub":
                                        img_change.setImageResource(R.drawable.plus);
                                        img_change.setTag("add");
                                        applyTag = "add";
                                        timerDelayRemoveView(img_change);
                                        rl_apply_add.setVisibility(View.VISIBLE);
                                        rl_apply_sub.setVisibility(View.GONE);
                                        rl_apply_mul.setVisibility(View.GONE);
                                        rl_apply_division.setVisibility(View.GONE);
                                        ll_cal.setVisibility(View.VISIBLE);
                                        ll_keyboard.setVisibility(View.VISIBLE);
                                        applyAdition.geanarateRandomApplyAdd();
                                        saveSelectedOperation(applyTag);
                                        break;
                                    case "mul":
                                        img_change.setImageResource(R.drawable.minus);
                                        img_change.setTag("sub");
                                        applyTag = "sub";
                                        timerDelayRemoveView(img_change);
                                        rl_apply_add.setVisibility(View.GONE);
                                        rl_apply_sub.setVisibility(View.VISIBLE);
                                        rl_apply_mul.setVisibility(View.GONE);
                                        rl_apply_division.setVisibility(View.GONE);
                                        ll_cal.setVisibility(View.VISIBLE);
                                        ll_keyboard.setVisibility(View.VISIBLE);
                                        saveSelectedOperation(applyTag);
                                        applyFactsSubstraction.generateRandomApplySub();
                                        break;
                                    case "div":
                                        img_change.setImageResource(R.drawable.cross);
                                        img_change.setTag("mul");
                                        applyTag = "mul";
                                        timerDelayRemoveView(img_change);
                                        rl_apply_add.setVisibility(View.GONE);
                                        rl_apply_sub.setVisibility(View.GONE);
                                        rl_apply_mul.setVisibility(View.VISIBLE);
                                        rl_apply_division.setVisibility(View.GONE);
                                        ll_cal.setVisibility(View.VISIBLE);
                                        ll_keyboard.setVisibility(View.VISIBLE);
                                        applyMultiplication.geanarateRandomApplyMul();
                                        saveSelectedOperation(applyTag);
                                        break;

                                }

                                //Save the selected operation
                                return true;
                            }
                            if (deltaY > 0) {
                                countForPanda = 0;
                                fromFirst = true;
                                forPandaApply = "first";
                                util.mediaService(getActivity(),R.raw.change,soundShare);
                                // Swipe up
                                switch (img_change.getTag().toString()) {
                                    case "add":
                                        img_change.setImageResource(R.drawable.minus);
                                        img_change.setTag("sub");
                                        applyTag = "sub";
                                        timerDelayRemoveView(img_change);
                                        rl_apply_add.setVisibility(View.GONE);
                                        rl_apply_mul.setVisibility(View.GONE);
                                        rl_apply_sub.setVisibility(View.VISIBLE);
                                        rl_apply_division.setVisibility(View.GONE);
                                        ll_cal.setVisibility(View.VISIBLE);
                                        ll_keyboard.setVisibility(View.VISIBLE);
                                        applyFactsSubstraction.generateRandomApplySub();
                                        saveSelectedOperation(applyTag);
                                        break;
                                    case "sub":
                                        img_change.setImageResource(R.drawable.cross);
                                        img_change.setTag("mul");
                                        applyTag = "mul";
                                        timerDelayRemoveView(img_change);
                                        rl_apply_add.setVisibility(View.GONE);
                                        rl_apply_mul.setVisibility(View.VISIBLE);
                                        rl_apply_sub.setVisibility(View.GONE);
                                        rl_apply_division.setVisibility(View.GONE);
                                        ll_cal.setVisibility(View.VISIBLE);
                                        ll_keyboard.setVisibility(View.VISIBLE);
                                        applyMultiplication.geanarateRandomApplyMul();
                                        saveSelectedOperation(applyTag);
                                        break;
                                    case "mul":
                                        img_change.setImageResource(R.drawable.division);
                                        img_change.setTag("div");
                                        applyTag = "div";
                                        timerDelayRemoveView(img_change);
                                        rl_apply_add.setVisibility(View.GONE);
                                        rl_apply_sub.setVisibility(View.GONE);
                                        rl_apply_mul.setVisibility(View.GONE);
                                        rl_apply_division.setVisibility(View.VISIBLE);
                                        ll_cal.setVisibility(View.GONE);
                                        ll_keyboard.setVisibility(View.GONE);
                                        saveSelectedOperation(applyTag);
                                        applyFactDivision.geanarateRandomApplyDiv();
                                        break;
                                    case "div":
                                        img_change.setImageResource(R.drawable.plus);
                                        img_change.setTag("add");
                                        applyTag = "add";
                                        timerDelayRemoveView(img_change);
                                        rl_apply_add.setVisibility(View.VISIBLE);
                                        rl_apply_mul.setVisibility(View.GONE);
                                        rl_apply_sub.setVisibility(View.GONE);
                                        rl_apply_division.setVisibility(View.GONE);
                                        ll_cal.setVisibility(View.VISIBLE);
                                        ll_keyboard.setVisibility(View.VISIBLE);
                                        applyAdition.geanarateRandomApplyAdd();
                                        saveSelectedOperation(applyTag);
                                        break;

                                }
                                return true;
                            }
                        } else {
                            //Not long enough swipe...
                            return false;
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    //Performing onclick for the views
    public void onClick(View v) {
        //Onclicks for views
        switch (v.getId()) {
            case R.id.img_btn_zero:
            case R.id.tv_btn_zer0:
                keyNum = "0";
                break;
            case R.id.img_btn_one:
            case R.id.tv_btn_one:
                keyNum = "1";
                break;
            case R.id.img_btn_two:
            case R.id.tv_btn_two:
                keyNum = "2";
                break;
            case R.id.img_btn_three:
            case R.id.tv_btn_three:
                keyNum = "3";
                break;
            case R.id.img_btn_four:
            case R.id.tv_btn_four:
                keyNum = "4";
                break;
            case R.id.img_btn_five:
            case R.id.tv_btn_five:
                keyNum = "5";
                break;
            case R.id.img_btn_six:
            case R.id.tv_btn_six:
                keyNum = "6";
                break;
            case R.id.img_btn_seven:
            case R.id.tv_btn_seven:
                keyNum = "7";
                break;
            case R.id.img_btn_eight:
            case R.id.tv_btn_eight:
                keyNum = "8";
                break;
            case R.id.img_btn_nine:
            case R.id.tv_btn_nine:
                keyNum = "9";
                break;
            case R.id.tv_btn_rem:
                keyNum = "r";
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
                util.showDialogInfo(getActivity(), mfont, getResources().getString(R.string.info_apply_head), getResources().getString(R.string.apply_facts_info));
                break;
            case R.id.tv_regroup:
                keyNum = tv_regroup.getText().toString();
                break;
            default:
                keyNum = "";
                break;
        }

        if (!keyNum.equals("")) {
            switch (applyTag) {
                case "add":
                    //addition functioanlity
                    applyAdition.functionalityforAdd(keyNum);
                    break;
                case "sub":
                    //substraction functionality
                    applyFactsSubstraction.functionalityforSub(keyNum);
                    break;
                case "mul":
                    //multiplication functionality
                    applyMultiplication.functionalityforMul(keyNum);
                    break;
                case "div":
                    //division functionality
                    applyFactDivision.functionalityforDiv(keyNum);
                    break;
            }
        }
    }

    // Setting the time for displaying the operation image
    public void timerDelayRemoveView(final ImageView v) {
        v.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                v.setVisibility(View.GONE);
            }
        }, 500);
    }

    //Save the selected operation
    public void saveSelectedOperation(String applyTag) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("apply_tag", applyTag);
        editor.commit();
    }
    // For finding the onclick
    private boolean isAClick(float startX, float endX, float startY, float endY) {
        float differenceX = Math.abs(startX - endX);
        float differenceY = Math.abs(startY - endY);
        return !(differenceX > CLICK_ACTION_THRESHOLD/* =5 */ || differenceY > CLICK_ACTION_THRESHOLD);
    }
}
