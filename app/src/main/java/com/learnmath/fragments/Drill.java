package com.learnmath.fragments;


import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jinatonic.confetti.ConfettiManager;
import com.github.jinatonic.confetti.ConfettiSource;
import com.github.jinatonic.confetti.ConfettoGenerator;
import com.github.jinatonic.confetti.confetto.BitmapConfetto;
import com.github.jinatonic.confetti.confetto.Confetto;
import com.learnmath.R;
import com.learnmath.activities.MainActivity;
import com.learnmath.tasks.DrillAddition;
import com.learnmath.tasks.DrillMutliplication;
import com.learnmath.tasks.DrillDivision;
import com.learnmath.tasks.DrillSubstraction;
import com.learnmath.utils.FontChange;
import com.learnmath.utils.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.content.Context.VIBRATOR_SERVICE;

/**
 * Created by mohan on 10/4/2017.
 */
public class Drill extends Fragment implements View.OnTouchListener, ConfettoGenerator {

    RelativeLayout rl_fluency_add, ll_cal, rl_fluency_sub, rl_fluency_mul, rl_fluency_division, rl_nav;
    ImageView img_change, img_help;
    Bitmap mFinalBitmap;
    ImageView img_btn_one, img_btn_two, img_btn_three, img_btn_four, img_btn_five, img_btn_six, img_btn_seven, img_btn_eight, img_btn_nine, img_btn_zero, img_home, img_settings;
    public static TextView textview_count, textview_time, txt_drill_head;
    String mfluencyTag = "add", mtextTime;
    public static String text_count;
    public static boolean sound_share = false;
    public static String keyNum = "";
    DrillAddition fluency_addition;
    DrillSubstraction fluency_substraction;
    DrillMutliplication fluency_multi;
    ImageView img_explore;
    private int mMinDistance = 100, i, j;
    RelativeLayout rl_explore;
    private float downX, downY, upX, upY;
    private int CLICK_ACTION_THRESHOLD = 200;
    public static boolean ButtonClicked = false;
    public static CountDownTimer waitTimer;
    ProgressBar progressBar;
    String mtimeLeftNew;
    int msecond;
    int mtextInteger, mtextIntegerShared;
    public static boolean shared_time_count = false, time_not_null_fluency = false, fluencyInstance = false;
    DrillDivision fluency_division;
    protected ViewGroup container_new;
    private int msize, msizeSpiral;
    private int mvelocitySlow, mvelocityNormal;
    List<Bitmap> bitmaps;
    SharedPreferences prefs;
    Resources res;
    private final List<ConfettiManager> activeConfettiManagers = new ArrayList<>();
    private boolean mbackground;
    View view;
    FontChange mfont = new FontChange();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fluency, container, false);
            fluencyInstance = false;
            rl_fluency_add = (RelativeLayout) view.findViewById(R.id.rl_fluency_add);
            img_change = (ImageView) view.findViewById(R.id.img_change);
            ll_cal = (RelativeLayout) view.findViewById(R.id.ll_cal);
            rl_fluency_sub = (RelativeLayout) view.findViewById(R.id.rl_fluency_sub);
            rl_fluency_mul = (RelativeLayout) view.findViewById(R.id.rl_fluency_mul);
            rl_fluency_division = (RelativeLayout) view.findViewById(R.id.rl_fluency_division);
            rl_explore = (RelativeLayout) view.findViewById(R.id.rl_explore);
            progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
            rl_nav = (RelativeLayout) view.findViewById(R.id.rl_nav);
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
            img_help = (ImageView) view.findViewById(R.id.img_help);
            textview_count = (TextView) view.findViewById(R.id.textview_count);
            textview_time = (TextView) view.findViewById(R.id.textview_time);
            txt_drill_head = (TextView) view.findViewById(R.id.txt_drill_head);

            //setting font style to the textviews
            setFontStyle();

            //tab btntons
            img_home = (ImageView) view.findViewById(R.id.img_home);
            img_settings = (ImageView) view.findViewById(R.id.img_settings);
            img_explore = (ImageView) view.findViewById(R.id.img_explore);
            img_settings.setVisibility(View.VISIBLE);

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
            rl_fluency_add.setOnTouchListener(this);
            ll_cal.setOnTouchListener(this);
            img_help.setOnTouchListener(this);
            rl_nav.setOnTouchListener(this);
            container_new = (ViewGroup) view.findViewById(R.id.confetti_container);
            res = getResources();
            msizeSpiral = res.getDimensionPixelSize(R.dimen.image_size_spiral);
            msize = res.getDimensionPixelSize(R.dimen.image_size);
            mvelocitySlow = res.getDimensionPixelOffset(R.dimen.default_velocity_slow);
            mvelocityNormal = res.getDimensionPixelOffset(R.dimen.default_velocity_normal);


            //getting  values from shared preference
            prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
            if (Settings.count_time) {
                //condition for came from settings screen(click on apply)
                Settings.count_time = false;
                text_count = prefs.getString("numberOfQuestions", "0");
                mtextTime = prefs.getString("drill_time", "60");
                textview_count.setText("0" + "/" + text_count);
                textview_time.setText(mtextTime);
                mtextInteger = Integer.parseInt(text_count);
            } else {
                //condition for came from other than settings
                //normal swipe
                mtimeLeftNew = prefs.getString("time_left", "");
                //click on setting but close the settings screen without changing any fields
                if (Settings.img_close_boolean) {
                    //conditions for setting time and count
                    shared_time_count = true;
                    Settings.img_close_boolean = false;
                    textview_count.setText(String.valueOf(DrillAddition.text_int) + "/" + prefs.getString("numberOfQuestions", "0"));
                    if (mtimeLeftNew.equals("1")) {
                        textview_time.setText(prefs.getString("drill_time", "60"));
                    } else if (textview_time.getText().toString().equals("0")) {
                        textview_time.setText("0");
                    } else {
                        String time_before_settings = prefs.getString("text_view_time_before_clickon_settings", "");
                        if (waitTimer != null) {
                            if (textview_time.getText().toString().equals("0")) {
                                textview_time.setText("0");
                            } else {
                                if (textview_time.getText().toString().equals("60") && (time_before_settings.equals(prefs.getString("drill_time", "60")))) {
                                    textview_time.setText(prefs.getString("drill_time", "60"));
                                } else {
                                    if (ApplyMath.apply_facts_timer) {
                                        ApplyMath.apply_facts_timer = false;
                                        textview_time.setText(prefs.getString("drill_time", "60"));
                                    } else {
                                        textview_time.setText(mtimeLeftNew);
                                    }
                                }
                            }
                        } else {
                            textview_time.setText(prefs.getString("drill_time", "60"));
                        }
                    }
                } else {
                    //normal swipe
                    mtextIntegerShared = Integer.parseInt(prefs.getString("numberOfQuestions", "0"));
                    textview_count.setText("0" + "/" + mtextIntegerShared);
                    textview_time.setText(prefs.getString("drill_time", "60"));
                }
            }
            mfluencyTag = prefs.getString("fluency_tag", "");
            sound_share = prefs.getBoolean("sound", true);

            //when click on back button timer cancel
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        if (waitTimer != null) {
                            waitTimer.cancel();
                        }
                        getActivity().finish();
                        return true;
                    } else {
                        return false;
                    }
                }
            });
        } else {
            img_settings.setVisibility(View.VISIBLE);
            fluencyInstance = true;
        }
        return view;
    }

    //setting font style to the textviews
    private void setFontStyle() {
        mfont.fontChange(txt_drill_head, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(textview_time, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(textview_count, "fonts/textFont.ttf", getActivity());
    }

    public List<Bitmap> generateConfettiBitmaps() {

        final List<Bitmap> bitmaps = new ArrayList<>();
        bitmaps.add(Bitmap.createScaledBitmap(generateRandomColor(R.drawable.sa),
                msize, msize, false));
        bitmaps.add(Bitmap.createScaledBitmap(generateRandomColor(R.drawable.sb),
                msize, msize, false));
        bitmaps.add(Bitmap.createScaledBitmap(generateRandomColor(R.drawable.sc),
                msize, msize, false));
        bitmaps.add(Bitmap.createScaledBitmap(generateRandomColor(R.drawable.sd),
                msize, msize, false));
        bitmaps.add(Bitmap.createScaledBitmap(generateRandomColor(R.drawable.se),
                msize, msize, false));
        bitmaps.add(Bitmap.createScaledBitmap(generateRandomColor(R.drawable.sf),
                msizeSpiral, msizeSpiral, false));
        bitmaps.add(Bitmap.createScaledBitmap(generateRandomColor(R.drawable.sg),
                msize, msize, false));
        bitmaps.add(Bitmap.createScaledBitmap(generateRandomColor(R.drawable.sh),
                msize, msize, false));
        return bitmaps;
    }

    public Bitmap generateRandomColor(int name) {
        int[] androidColors = getResources().getIntArray(R.array.androidcolors);
        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
        Drawable sourceDrawable = ContextCompat.getDrawable(getActivity(), name);
        //Convert drawable in to bitmap
        Bitmap sourceBitmap = Util.convertDrawableToBitmap(sourceDrawable);
        //Pass the bitmap and color code to change the icon color dynamically.
        mFinalBitmap = Util.changeImageColor(sourceBitmap, randomAndroidColor);
        return mFinalBitmap;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        if (!fluencyInstance) {

            fluency_addition = new DrillAddition(getActivity());
            fluency_substraction = new DrillSubstraction(getActivity());
            fluency_multi = new DrillMutliplication(getActivity());
            fluency_division = new DrillDivision(getActivity());

            switch (mfluencyTag) {
                case "add":
                    img_change.setTag("add");
                    rl_fluency_add.setVisibility(View.VISIBLE);
                    rl_fluency_sub.setVisibility(View.GONE);
                    rl_fluency_mul.setVisibility(View.GONE);
                    rl_fluency_division.setVisibility(View.GONE);
                    fluency_addition.RandomMethodForAddition();
                    break;
                case "sub":
                    img_change.setTag("sub");
                    rl_fluency_sub.setVisibility(View.VISIBLE);
                    rl_fluency_add.setVisibility(View.GONE);
                    rl_fluency_mul.setVisibility(View.GONE);
                    rl_fluency_division.setVisibility(View.GONE);
                    fluency_substraction.RandomMethodForSubtraction();
                    break;
                case "mul":
                    img_change.setTag("mul");
                    rl_fluency_sub.setVisibility(View.GONE);
                    rl_fluency_add.setVisibility(View.GONE);
                    rl_fluency_mul.setVisibility(View.VISIBLE);
                    rl_fluency_division.setVisibility(View.GONE);
                    fluency_multi.RandomMethodForMultplication();
                    break;
                case "div":
                    img_change.setTag("div");
                    rl_fluency_sub.setVisibility(View.GONE);
                    rl_fluency_add.setVisibility(View.GONE);
                    rl_fluency_mul.setVisibility(View.GONE);
                    rl_fluency_division.setVisibility(View.VISIBLE);
                    fluency_division.RandomMethodForDivision();
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
                        mediaService(R.raw.swoosh);
                        if (Math.abs(deltaX) > mMinDistance) {
                            // left or right
                            if (deltaX < 0) {
                                if (waitTimer != null) {
                                    time_not_null_fluency = true;
                                    waitTimer.cancel();
                                    DrillAddition.text_int = 0;
                                    Drill.textview_time.setText(prefs.getString("drill_time", "60"));
                                }
                                //swipe left
                                ApplyMath applymath = new ApplyMath();
                                getFragmentManager().beginTransaction()
                                        .setCustomAnimations(
                                                R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                                                R.animator.card_flip_right_in, R.animator.card_flip_right_out)
                                        .replace(R.id.frag, applymath)
                                        .addToBackStack(null)
                                        .commit();
                                return true;
                            }
                            if (deltaX > 0) {
                                if (waitTimer != null) {
                                    time_not_null_fluency = true;
                                    waitTimer.cancel();
                                    DrillAddition.text_int = 0;
                                    Drill.textview_time.setText(prefs.getString("drill_time", "60"));
                                }
                                LearnMath learn_facts = new LearnMath();
                                getFragmentManager().beginTransaction()
                                        .setCustomAnimations(
                                                R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                                                R.animator.card_flip_right_in, R.animator.card_flip_right_out)
                                        .replace(R.id.frag, learn_facts)
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
                                //for change operator sound
                                mediaService(R.raw.change);
                                switch (img_change.getTag().toString()) {
                                    case "add":
                                        img_change.setImageResource(R.drawable.division);
                                        img_change.setTag("div");
                                        mfluencyTag = "div";
                                        timerDelayRemoveView(img_change);
                                        rl_fluency_add.setVisibility(View.GONE);
                                        rl_fluency_sub.setVisibility(View.GONE);
                                        rl_fluency_mul.setVisibility(View.GONE);
                                        rl_fluency_division.setVisibility(View.VISIBLE);
                                        fluency_division.RandomMethodForDivision();
                                        saveSelectedOperation(mfluencyTag);
                                        break;
                                    case "sub":
                                        img_change.setImageResource(R.drawable.plus);
                                        img_change.setTag("add");
                                        mfluencyTag = "add";
                                        timerDelayRemoveView(img_change);
                                        rl_fluency_add.setVisibility(View.VISIBLE);
                                        rl_fluency_sub.setVisibility(View.GONE);
                                        rl_fluency_mul.setVisibility(View.GONE);
                                        rl_fluency_division.setVisibility(View.GONE);
                                        fluency_addition.RandomMethodForAddition();
                                        saveSelectedOperation(mfluencyTag);
                                        break;
                                    case "mul":
                                        img_change.setImageResource(R.drawable.minus);
                                        img_change.setTag("sub");
                                        mfluencyTag = "sub";
                                        timerDelayRemoveView(img_change);
                                        rl_fluency_sub.setVisibility(View.VISIBLE);
                                        rl_fluency_add.setVisibility(View.GONE);
                                        rl_fluency_mul.setVisibility(View.GONE);
                                        rl_fluency_division.setVisibility(View.GONE);
                                        fluency_substraction.RandomMethodForSubtraction();
                                        saveSelectedOperation(mfluencyTag);
                                        break;
                                    case "div":
                                        img_change.setImageResource(R.drawable.cross);
                                        img_change.setTag("mul");
                                        mfluencyTag = "mul";
                                        timerDelayRemoveView(img_change);
                                        rl_fluency_add.setVisibility(View.GONE);
                                        rl_fluency_sub.setVisibility(View.GONE);
                                        rl_fluency_mul.setVisibility(View.VISIBLE);
                                        rl_fluency_division.setVisibility(View.GONE);
                                        fluency_multi.RandomMethodForMultplication();
                                        saveSelectedOperation(mfluencyTag);
                                        break;

                                }

                                return true;
                            }
                            if (deltaY > 0) {
                                mediaService(R.raw.change);
                                // swipe up
                                switch (img_change.getTag().toString()) {
                                    case "add":
                                        img_change.setImageResource(R.drawable.minus);
                                        img_change.setTag("sub");
                                        mfluencyTag = "sub";
                                        timerDelayRemoveView(img_change);
                                        rl_fluency_sub.setVisibility(View.VISIBLE);
                                        rl_fluency_add.setVisibility(View.GONE);
                                        rl_fluency_mul.setVisibility(View.GONE);
                                        rl_fluency_division.setVisibility(View.GONE);
                                        fluency_substraction.RandomMethodForSubtraction();
                                        saveSelectedOperation(mfluencyTag);
                                        break;
                                    case "sub":
                                        img_change.setImageResource(R.drawable.cross);
                                        img_change.setTag("mul");
                                        mfluencyTag = "mul";
                                        timerDelayRemoveView(img_change);
                                        rl_fluency_add.setVisibility(View.GONE);
                                        rl_fluency_sub.setVisibility(View.GONE);
                                        rl_fluency_mul.setVisibility(View.VISIBLE);
                                        rl_fluency_division.setVisibility(View.GONE);
                                        saveSelectedOperation(mfluencyTag);
                                        break;
                                    case "mul":
                                        img_change.setImageResource(R.drawable.division);
                                        img_change.setTag("div");
                                        mfluencyTag = "div";
                                        timerDelayRemoveView(img_change);
                                        rl_fluency_add.setVisibility(View.GONE);
                                        rl_fluency_sub.setVisibility(View.GONE);
                                        rl_fluency_mul.setVisibility(View.GONE);
                                        rl_fluency_division.setVisibility(View.VISIBLE);
                                        fluency_division.RandomMethodForDivision();
                                        saveSelectedOperation(mfluencyTag);
                                        break;
                                    case "div":
                                        img_change.setImageResource(R.drawable.plus);
                                        img_change.setTag("add");
                                        mfluencyTag = "add";
                                        timerDelayRemoveView(img_change);
                                        rl_fluency_add.setVisibility(View.VISIBLE);
                                        rl_fluency_sub.setVisibility(View.GONE);
                                        rl_fluency_mul.setVisibility(View.GONE);
                                        rl_fluency_division.setVisibility(View.GONE);
                                        fluency_addition.RandomMethodForAddition();
                                        saveSelectedOperation(mfluencyTag);
                                        break;
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

    public void onClick(View v) {
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
            case R.id.img_help:
                //help onclick
                keyNum = "";
                showDialogInfo();
                break;

            case R.id.img_settings:
                //settings onclick
                ApplyMath.apply_facts_timer = false;
                img_settings.setVisibility(View.INVISIBLE);
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("text_view_time_before_clickon_settings", textview_time.getText().toString());
                editor.commit();
                keyNum = "";
                Settings settings = new Settings();
                getFragmentManager().beginTransaction()
                        .replace(R.id.frag, settings)
                        .addToBackStack(MainActivity.class.getName())
                        .commit();
                break;
            default:
                keyNum = "";
                break;

        }

        if (!keyNum.equals("")) {
            switch (mfluencyTag) {
                case "add":
                    //addition functioanlity
                    fluency_addition.functionalityforAdd();
                    break;
                case "sub":
                    //subtraction functionality
                    fluency_substraction.functionalityforSub();
                    break;
                case "mul":
                    //multiplication functionality
                    fluency_multi.functionalityforMulFluency();
                    break;
                case "div":
                    //divison functionality
                    fluency_division.functionalityforDivFluency();
                    break;
            }
        }
        if (keyNum.equals("0") || keyNum.equals("1") || keyNum.equals("2") || keyNum.equals("3") || keyNum.equals("4") ||
                keyNum.equals("5") || keyNum.equals("6") || keyNum.equals("7") || keyNum.equals("8") || keyNum.equals("9")) {

            //show partcles when time and questions count is 0
            if (textview_time.getText().toString().equals("0") && prefs.getString("numberOfQuestions", "0").equals("0")) {

                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(100);
                //for click on number that number is displayed in result textview
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        particles();
                        handler.removeCallbacksAndMessages(null);
                    }
                }, 700);
            }
            //show bomb when time is 0 and questions count is not 0

            else if (!textview_count.getText().toString().equals("0/0") && textview_time.getText().toString().equals("0")) {

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        blast();
                        progressBar.setVisibility(View.VISIBLE);
                        progressBar.setProgress(100);
                        handler.removeCallbacksAndMessages(null);
                    }
                }, 500);

            }
            //for showing timer
            else {
                //normal swipe or came from settings
                if (Settings.timer) {
                    Settings.timer = false;
                    showingTimerFlowersBombNormal();
                } else if (shared_time_count) {
                    if (textview_time.getText().toString().equals(prefs.getString("drill_time", "60"))) {
                        if (waitTimer != null) {
                            if (j != 0) {
                                waitTimer.cancel();
                                j = 0;
                            }
                            msecond = (Integer.parseInt(prefs.getString("drill_time", "60"))) * 1000;
                            waitTimer = new CountDownTimer(msecond, 1000) {

                                public void onTick(long millisUntilFinished) {
                                    tickNormal(millisUntilFinished);

                                }

                                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                                public void onFinish() {

                                    finishNormal();

                                }
                            }.start();
                        } else if (prefs.getString("drill_time", "60").equals("60")) {
                            showingTimerFlowersBombNormal();
                        }
                    }
                }
                //time_not_null_fluency-> is true when we swipe to learnfacts

                //timer_not_null_applyfacts-> if timer is running,then stop it when we swipe to applyfacts
                else if (time_not_null_fluency || ApplyMath.timer_not_null_applyfacts) {
                    time_not_null_fluency = false;
                    ApplyMath.timer_not_null_applyfacts = false;
                    if (waitTimer != null) {
                        if (j != 0) {
                            waitTimer.cancel();
                            j = 0;
                        }
                        msecond = (Integer.parseInt(prefs.getString("drill_time", "60"))) * 1000;
                        waitTimer = new CountDownTimer(msecond, 1000) {

                            public void onTick(long millisUntilFinished) {
                                tickNormal(millisUntilFinished);

                            }

                            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                            public void onFinish() {

                                finishNormal();

                            }
                        }.start();
                    }
                } else {
                    //condition for initial timer
                    showingTimerFlowersBombNormal();
                }
            }
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

    //save the selected operation
    public void saveSelectedOperation(String fluency_tag) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("fluency_tag", fluency_tag);
        editor.commit();
    }

    //for playing the sounds
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
        return !(differenceX > CLICK_ACTION_THRESHOLD/* =5 */ || differenceY > CLICK_ACTION_THRESHOLD);
    }

    //for displaying  initial timer
    public void showingTimerFlowersBombNormal() {
        if (!ButtonClicked) {
            ButtonClicked = true;
            if (j != 0) {
                waitTimer.cancel();
                j = 0;
            }
            msecond = (Integer.parseInt(textview_time.getText().toString())) * 1000;
            waitTimer = new CountDownTimer(msecond, 1000) {
                public void onTick(long millisUntilFinished) {
                    tickNormal(millisUntilFinished);
                }

                @RequiresApi(api = Build.VERSION_CODES.M)
                public void onFinish() {
                    finishNormal();

                }
            }.start();
        }
    }

    //ontick method normal
    private void tickNormal(long millisUntilFinished) {
        textview_time.setText("" + millisUntilFinished / 1000);
        j++;
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress((int) j * 100 / (msecond / 1000));
        try {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("time_left", textview_time.getText().toString());
            editor.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //finish method normal
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void finishNormal() {
        j++;
        progressBar.setProgress(0);
        progressBar.setProgress(View.INVISIBLE);
        if (textview_time.getText().toString().equals("1")) {
            ButtonClicked = false;
            if (mfluencyTag.equals("add") || mfluencyTag.equals("sub") || mfluencyTag.equals("mul") || mfluencyTag.equals("div")) {
                if (DrillAddition.text_int >= Integer.parseInt(prefs.getString("numberOfQuestions", "0"))) {
                    particles();
                } else {
                    blast();
                }
            }
        }
        clearParticlesOrBombNormal();
    }

    //for showing particles
    private void particles() {
        if (img_settings.getVisibility() == View.INVISIBLE || mbackground) {

        } else {
            bitmaps = generateConfettiBitmaps();
            mediaService(R.raw.small_crowd_cheering_and_clapping);
            activeConfettiManagers.add(getConfettiManager().setNumInitialCount(0)
                    .setEmissionDuration(3000)
                    .setEmissionRate(70)
                    .setVelocityY(1000)
                    .setTouchEnabled(false)
                    .animate());

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ClearMethod();
                    handler.removeCallbacksAndMessages(null);
                }
            }, 1000);

        }
    }

    //for showing bomb
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void blast() {
        if (img_settings.getVisibility() == View.INVISIBLE || mbackground) {

        } else {

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (Build.VERSION.SDK_INT >= 26) {
                            ((Vibrator) getActivity().getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(150, 10));
                        } else {
                            ((Vibrator) getActivity().getSystemService(VIBRATOR_SERVICE)).vibrate(150);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    progressBar.setProgress(0);
                    progressBar.setVisibility(View.INVISIBLE);
                    img_explore.setAlpha(1.0f);
                    img_explore.setVisibility(View.VISIBLE);
                    img_explore.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.explore));
                    rl_explore.setBackgroundColor(Color.TRANSPARENT);
                    rl_explore.setVisibility(View.VISIBLE);
                    mediaService(R.raw.explore);
                }
            }, 600);
            handler.postDelayed(new
                                        Runnable() {
                                            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                                            @Override
                                            public void run() {
                                                img_explore.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.cloud));
                                                Animation fadeOut = new AlphaAnimation(1, 0);
                                                fadeOut.setInterpolator(new AccelerateInterpolator());
                                                fadeOut.setDuration(1000);
                                                fadeOut.setAnimationListener(new Animation.AnimationListener() {
                                                    public void onAnimationEnd(Animation animation) {
                                                    }

                                                    public void onAnimationRepeat(Animation animation) {
                                                    }

                                                    public void onAnimationStart(Animation animation) {
                                                        rl_explore.setBackgroundColor(Color.TRANSPARENT);
                                                    }
                                                });
                                                img_explore.startAnimation(fadeOut);
                                            }
                                        }
                    , 1200);
            handler.postDelayed(new
                                        Runnable() {
                                            @Override
                                            public void run() {
                                                img_explore.setAlpha(0.3f);
                                                img_explore.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.explore));
                                                Animation fadeOut = new AlphaAnimation(1, 0);
                                                fadeOut.setInterpolator(new AccelerateInterpolator());
                                                fadeOut.setDuration(400);
                                                fadeOut.setAnimationListener(new Animation.AnimationListener() {
                                                    public void onAnimationEnd(Animation animation) {
                                                        img_explore.setVisibility(View.GONE);
                                                        rl_explore.setVisibility(View.GONE);
                                                    }

                                                    public void onAnimationRepeat(Animation animation) {
                                                    }

                                                    public void onAnimationStart(Animation animation) {
                                                    }
                                                });
                                                img_explore.startAnimation(fadeOut);
                                                clearParticlesOrBombNormal();
                                            }
                                        }
                    , 1400);

        }

    }

    //for initializing confitti animation
    private ConfettiManager getConfettiManager() {
        final ConfettiSource source = new ConfettiSource(0, -msize, container_new.getWidth(), -msize);
        return new ConfettiManager(getActivity(), this, source, container_new)
                .setVelocityX(0, mvelocitySlow)
                .setVelocityY(mvelocityNormal, mvelocitySlow)
                .setRotationalVelocity(180, 90)
                .setTouchEnabled(true);
    }

    @Override
    public Confetto generateConfetto(Random random) {
        int numBitmaps = bitmaps.size();
        return new BitmapConfetto(bitmaps.get(random.nextInt(numBitmaps)));
    }

    //generate random number
    public void randomMethod() {
        if (mfluencyTag.equals("add")) {
            //addition functioanlity
            fluency_addition.RandomMethodForAddition();
        } else if (mfluencyTag.equals("sub")) {
            //subtraction functionality
            fluency_substraction.RandomMethodForSubtraction();
        } else if (mfluencyTag.equals("mul")) {
            //multiplication functionality
            fluency_multi.RandomMethodForMultplication();
        } else if (mfluencyTag.equals("div")) {
            //divison functionality
            fluency_division.RandomMethodForDivision();
        }
    }

    //clear all the values after showing bomb or partcles(clear count,time)
    //from settings
    public void clearParticlesOrBombNormal() {
        randomMethod();
        clearForResult();
        DrillAddition.text_int = 0;
        textview_count.setText("0" + "/" + prefs.getString("numberOfQuestions", "0"));
        textview_time.setText(prefs.getString("drill_time", "60"));
        progressBar.setVisibility(View.INVISIBLE);
        progressBar.setProgress(0);
    }

    //clear method when the count and time is set to zero
    //clear all the values after showing bomb or partcles(clear count,time)
    public void ClearMethod() {


        DrillAddition.text_int = 0;
        textview_count.setText("0" + "/" + prefs.getString("numberOfQuestions", "0"));
        textview_time.setText(prefs.getString("drill_time", "60"));
        clearForResult();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
                progressBar.setProgress(100);
                DrillAddition.text_int = 0;
                textview_count.setText("0" + "/" + prefs.getString("numberOfQuestions", "0"));
                textview_time.setText(prefs.getString("drill_time", "60"));
                /*//for generating random numbers
                if(DrillAddition.correct_answer!=1){
                    randomMethod();
                }else {
                }*/
                handler.removeCallbacksAndMessages(null);
            }
        }, 2000);

    }


    //clearing the result when bomb or particle displayed
    public void clearForResult() {
        DrillAddition.textview_add_result.setText("");
        DrillSubstraction.textview_sub_result.setText("");
        DrillMutliplication.textview_mul_result.setText("");
        DrillDivision.textview_div_result.setText("");
    }

    //dialog for click on info button in tab bar
    private void showDialogInfo() {
        final Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.info_dialog);
        TextView txt_info_head = (TextView) dialog.findViewById(R.id.txt_info_head);
        TextView tv_head = (TextView) dialog.findViewById(R.id.tv_head);
        TextView tv_body = (TextView) dialog.findViewById(R.id.tv_body);
        //setting font style for the textviews
        mfont.fontChange(txt_info_head, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(tv_head, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(tv_body, "fonts/textFont.ttf", getActivity());


        tv_head.setText(getResources().getString(R.string.info_fluency_head));
        tv_body.setText(getResources().getString(R.string.fluency_info));
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

    //for showing blast or particles when it is foreground
    //condition for foreground
    public void onStart() {
        super.onStart();
        mbackground = false;
    }

    //for not showing blast or particles when it is mbackground
    //condition for mbackground
    public void onStop() {
        super.onStop();
        mbackground = true;
    }
}
