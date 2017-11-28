package com.learnmath.Fragments;


import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import com.learnmath.Activities.MainActivity;
import com.learnmath.Tasks.DrillAddition;
import com.learnmath.Tasks.DrillDivision;
import com.learnmath.Tasks.DrillMutliplication;
import com.learnmath.Tasks.DrillSubtraction;
import com.learnmath.Utils.FontChange;
import com.learnmath.Utils.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.content.Context.VIBRATOR_SERVICE;

/**
 * Created by stellent on 10/4/2017.
 */
public class Drill extends Fragment implements View.OnTouchListener, ConfettoGenerator {

    RelativeLayout rl_fluency_add, ll_cal, rl_fluency_sub, rl_fluency_mul, rl_fluency_division, rl_nav;
    ImageView img_change, img_help;
    Bitmap mFinalBitmap;
    ImageView img_btn_one, img_btn_two, img_btn_three, img_btn_four, img_btn_five, img_btn_six, img_btn_seven, img_btn_eight, img_btn_nine, img_btn_zero, img_home, img_settings;
    public static TextView textview_count, textview_time, txt_drill_head;
    String mfluencyTag = "add", mtextTime;
    public String textCount;
    public  boolean msoundShare = false;
    public static String keyNum = "";
    public DrillAddition fluencyAddition;
    public DrillSubtraction fluencySubstraction;
    public DrillMutliplication fluencyMultiplication;
    ImageView img_explore;
    private int mMinDistance = 100, i, j;
    RelativeLayout rl_explore;
    private float downX, downY, upX, upY;
    public final int CLICK_ACTION_THRESHOLD = 200;
    public static boolean ButtonClicked = false;
    public static CountDownTimer waitTimer;
    ProgressBar progressBar;
    String mtimeLeftNew;
    int msecond;
    int mtextInteger, mtextIntegerShared;
    public boolean sharedTimeCount = false, timeNotNullFluency = false, fluencyInstance = false;
    public DrillDivision fluencyDivision;
    protected ViewGroup containerNew;
    private int msize, msizeSpiral;
    private int mvelocitySlow, mvelocityNormal;
    List<Bitmap> bitmaps;
    SharedPreferences prefs;
    Resources res;
    private final List<ConfettiManager> activeConfettiManagers = new ArrayList<>();
    private boolean mbackground;
    View view;
    FontChange mfont = new FontChange();
    Util util = new Util();


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
            // Keyboard views
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

            //Setting font style to the textviews
            setFontStyle();

            img_home = (ImageView) view.findViewById(R.id.img_home);
            img_settings = (ImageView) view.findViewById(R.id.img_settings);
            img_explore = (ImageView) view.findViewById(R.id.img_explore);
            img_settings.setVisibility(View.VISIBLE);

            //Onclicks for keyboard
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
            containerNew = (ViewGroup) view.findViewById(R.id.confetti_container);
            res = getResources();
            msizeSpiral = res.getDimensionPixelSize(R.dimen.image_size_spiral);
            msize = res.getDimensionPixelSize(R.dimen.image_size);
            mvelocitySlow = res.getDimensionPixelOffset(R.dimen.default_velocity_slow);
            mvelocityNormal = res.getDimensionPixelOffset(R.dimen.default_velocity_normal);


            //Getting  values from shared preference
            prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
            if (Settings.countTime) {
                //Condition for came from settings screen(click on apply)
                Settings.countTime = false;
                textCount = prefs.getString("numberOfQuestions", "0");
                mtextTime = prefs.getString("drill_time", "60");
                textview_count.setText("0" + "/" + textCount);
                textview_time.setText(mtextTime);
                mtextInteger = Integer.parseInt(textCount);
            } else {
                //Condition for came from other than settings
                //Normal swipe
                mtimeLeftNew = prefs.getString("time_left", "");
                //Click on setting but close the settings screen without changing any fields
                if (Settings.imgCloseBoolean) {
                    //Conditions for setting time and count
                    sharedTimeCount = true;
                    Settings.imgCloseBoolean = false;
                    textview_count.setText(String.valueOf(DrillAddition.textInt) + "/" + prefs.getString("numberOfQuestions", "0"));
                    if (mtimeLeftNew.equals("1")) {
                        textview_time.setText(prefs.getString("drill_time", "60"));
                    } else if (textview_time.getText().toString().equals("0")) {
                        textview_time.setText("0");
                    } else {
                        String timeBeforeSettings = prefs.getString("text_view_time_before_clickon_settings", "");
                        if (waitTimer != null) {
                            if (textview_time.getText().toString().equals("0")) {
                                textview_time.setText("0");
                            } else {
                                if (textview_time.getText().toString().equals("60") && (timeBeforeSettings.equals(prefs.getString("drill_time", "60")))) {
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
                    //Normal swipe
                    mtextIntegerShared = Integer.parseInt(prefs.getString("numberOfQuestions", "0"));
                    textview_count.setText("0" + "/" + mtextIntegerShared);
                    textview_time.setText(prefs.getString("drill_time", "60"));
                }
            }
            mfluencyTag = prefs.getString("fluency_tag", "");
            msoundShare = prefs.getBoolean("sound", true);

            //When click on back button timer cancel
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

    //Setting font style to the textviews
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

            fluencyAddition = new DrillAddition(getActivity());
            fluencySubstraction = new DrillSubtraction(getActivity());
            fluencyMultiplication = new DrillMutliplication(getActivity());
            fluencyDivision = new DrillDivision(getActivity());

            switch (mfluencyTag) {
                case "add":
                    img_change.setTag("add");
                    rl_fluency_add.setVisibility(View.VISIBLE);
                    rl_fluency_sub.setVisibility(View.GONE);
                    rl_fluency_mul.setVisibility(View.GONE);
                    rl_fluency_division.setVisibility(View.GONE);
                    fluencyAddition.RandomMethodForAddition();
                    break;
                case "sub":
                    img_change.setTag("sub");
                    rl_fluency_add.setVisibility(View.GONE);
                    rl_fluency_sub.setVisibility(View.VISIBLE);
                    rl_fluency_mul.setVisibility(View.GONE);
                    rl_fluency_division.setVisibility(View.GONE);
                    fluencySubstraction.RandomMethodForSubtraction();
                    break;
                case "mul":
                    img_change.setTag("mul");
                    rl_fluency_add.setVisibility(View.GONE);
                    rl_fluency_sub.setVisibility(View.GONE);
                    rl_fluency_mul.setVisibility(View.VISIBLE);
                    rl_fluency_division.setVisibility(View.GONE);
                    fluencyMultiplication.RandomMethodForMultplication();
                    break;
                case "div":
                    img_change.setTag("div");
                    rl_fluency_add.setVisibility(View.GONE);
                    rl_fluency_sub.setVisibility(View.GONE);
                    rl_fluency_mul.setVisibility(View.GONE);
                    rl_fluency_division.setVisibility(View.VISIBLE);
                    fluencyDivision.RandomMethodForDivision();
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
                        util.mediaService(getActivity(), R.raw.swoosh, msoundShare);
                        if (Math.abs(deltaX) > mMinDistance) {
                            // Left or right
                            if (deltaX < 0) {
                                if (waitTimer != null) {
                                    timeNotNullFluency = true;
                                    waitTimer.cancel();
                                    DrillAddition.textInt = 0;
                                    Drill.textview_time.setText(prefs.getString("drill_time", "60"));
                                }
                                //Swipe left
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
                                    timeNotNullFluency = true;
                                    waitTimer.cancel();
                                    DrillAddition.textInt = 0;
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
                            // Top or down
                            if (deltaY < 0) {
                                //For change operator sound
                                util.mediaService(getActivity(),R.raw.change, msoundShare);
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
                                        fluencyDivision.RandomMethodForDivision();
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
                                        fluencyAddition.RandomMethodForAddition();
                                        saveSelectedOperation(mfluencyTag);
                                        break;
                                    case "mul":
                                        img_change.setImageResource(R.drawable.minus);
                                        img_change.setTag("sub");
                                        mfluencyTag = "sub";
                                        timerDelayRemoveView(img_change);
                                        rl_fluency_add.setVisibility(View.GONE);
                                        rl_fluency_sub.setVisibility(View.VISIBLE);
                                        rl_fluency_mul.setVisibility(View.GONE);
                                        rl_fluency_division.setVisibility(View.GONE);
                                        fluencySubstraction.RandomMethodForSubtraction();
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
                                        fluencyMultiplication.RandomMethodForMultplication();
                                        saveSelectedOperation(mfluencyTag);
                                        break;

                                }

                                return true;
                            }
                            if (deltaY > 0) {
                                util.mediaService(getActivity(),R.raw.change, msoundShare);
                                // Swipe up
                                switch (img_change.getTag().toString()) {
                                    case "add":
                                        img_change.setImageResource(R.drawable.minus);
                                        img_change.setTag("sub");
                                        mfluencyTag = "sub";
                                        timerDelayRemoveView(img_change);
                                        rl_fluency_add.setVisibility(View.GONE);
                                        rl_fluency_sub.setVisibility(View.VISIBLE);
                                        rl_fluency_mul.setVisibility(View.GONE);
                                        rl_fluency_division.setVisibility(View.GONE);
                                        fluencySubstraction.RandomMethodForSubtraction();
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
                                        fluencyDivision.RandomMethodForDivision();
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
                                        fluencyAddition.RandomMethodForAddition();
                                        saveSelectedOperation(mfluencyTag);
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
                //Home onclick
                keyNum = "";
                getActivity().finish();
                break;
            case R.id.img_help:
                //Help onclick
                keyNum = "";
                util.showDialogInfo(getActivity(), mfont, getResources().getString(R.string.info_fluency_head), getResources().getString(R.string.fluency_info));
                break;

            case R.id.img_settings:
                //Settings onclick
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
                    //Addition functioanlity
                    fluencyAddition.functionalityforAdd();
                    break;
                case "sub":
                    //Subtraction functionality
                    fluencySubstraction.functionalityforSub();
                    break;
                case "mul":
                    //Multiplication functionality
                    fluencyMultiplication.functionalityforMulFluency();
                    break;
                case "div":
                    //Divison functionality
                    fluencyDivision.functionalityforDivFluency();
                    break;
            }
        }
        if (keyNum.equals("0") || keyNum.equals("1") || keyNum.equals("2") || keyNum.equals("3") || keyNum.equals("4") ||
                keyNum.equals("5") || keyNum.equals("6") || keyNum.equals("7") || keyNum.equals("8") || keyNum.equals("9")) {

            //Show partcles when time and questions count is 0
            if (textview_time.getText().toString().equals("0") && prefs.getString("numberOfQuestions", "0").equals("0")) {

                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(100);
                //For click on number that number is displayed in result textview
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        particles();
                        handler.removeCallbacksAndMessages(null);
                    }
                }, 700);
            }
            //Show bomb when time is 0 and questions count is not 0

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
            //For showing timer
            else {
                //Normal swipe or came from settings
                if (Settings.timer) {
                    Settings.timer = false;
                    showingTimerFlowersBombNormal();
                } else if (sharedTimeCount) {
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
                //timeNotNullFluency-> is true when we swipe to learnfacts

                //Timer_not_null_applyfacts-> if timer is running,then stop it when we swipe to applyfacts
                else if (timeNotNullFluency || ApplyMath.timerNotNullApplyfacts) {
                    timeNotNullFluency = false;
                    ApplyMath.timerNotNullApplyfacts = false;
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
                    //Condition for initial timer
                    showingTimerFlowersBombNormal();
                }
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
    public void saveSelectedOperation(String fluencyTag) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("fluency_tag", fluencyTag);
        editor.commit();
    }


    // For finding the onclick
    private boolean isAClick(float startX, float endX, float startY, float endY) {
        float differenceX = Math.abs(startX - endX);
        float differenceY = Math.abs(startY - endY);
        return !(differenceX > CLICK_ACTION_THRESHOLD/* =5 */ || differenceY > CLICK_ACTION_THRESHOLD);
    }

    //For displaying  initial timer
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

    //Ontick method normal
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

    //Finish method normal
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void finishNormal() {
        j++;
        progressBar.setProgress(0);
        progressBar.setProgress(View.INVISIBLE);
        if (textview_time.getText().toString().equals("1")) {
            ButtonClicked = false;
            if (mfluencyTag.equals("add") || mfluencyTag.equals("sub") || mfluencyTag.equals("mul") || mfluencyTag.equals("div")) {
                if (DrillAddition.textInt >= Integer.parseInt(prefs.getString("numberOfQuestions", "0"))) {
                    particles();
                } else {
                    blast();
                }
            }
        }
        clearParticlesOrBombNormal();
    }

    //For showing particles
    private void particles() {
        if (img_settings.getVisibility() == View.INVISIBLE || mbackground) {

        } else {
            bitmaps = generateConfettiBitmaps();
            util.mediaService(getActivity(), R.raw.small_crowd_cheering_and_clapping, msoundShare);
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

    //For showing bomb
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
                    util.mediaService(getActivity(), R.raw.explore, msoundShare);
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

    //For initializing confitti animation
    private ConfettiManager getConfettiManager() {
        final ConfettiSource source = new ConfettiSource(0, -msize, containerNew.getWidth(), -msize);
        return new ConfettiManager(getActivity(), this, source, containerNew)
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

    //Generate random number
    public void randomMethod() {
        if (mfluencyTag.equals("add")) {
            //Addition functioanlity
            fluencyAddition.RandomMethodForAddition();
        } else if (mfluencyTag.equals("sub")) {
            //Subtraction functionality
            fluencySubstraction.RandomMethodForSubtraction();
        } else if (mfluencyTag.equals("mul")) {
            //Multiplication functionality
            fluencyMultiplication.RandomMethodForMultplication();
        } else if (mfluencyTag.equals("div")) {
            //Divison functionality
            fluencyDivision.RandomMethodForDivision();
        }
    }

    //Cclear all the values after showing bomb or partcles(clear count,time)
    //From settings
    public void clearParticlesOrBombNormal() {
        randomMethod();
        clearForResult();
        DrillAddition.textInt = 0;
        textview_count.setText("0" + "/" + prefs.getString("numberOfQuestions", "0"));
        textview_time.setText(prefs.getString("drill_time", "60"));
        progressBar.setVisibility(View.INVISIBLE);
        progressBar.setProgress(0);
    }

    //Clear method when the count and time is set to zero
    //Clear all the values after showing bomb or partcles(clear count,time)
    public void ClearMethod() {


        DrillAddition.textInt = 0;
        textview_count.setText("0" + "/" + prefs.getString("numberOfQuestions", "0"));
        textview_time.setText(prefs.getString("drill_time", "60"));
        clearForResult();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
                progressBar.setProgress(100);
                DrillAddition.textInt = 0;
                textview_count.setText("0" + "/" + prefs.getString("numberOfQuestions", "0"));
                textview_time.setText(prefs.getString("drill_time", "60"));
                handler.removeCallbacksAndMessages(null);
            }
        }, 2000);

    }
    //Clearing the result when bomb or particle displayed
    public void clearForResult() {
        DrillAddition.textview_add_result.setText("");
        DrillSubtraction.textview_sub_result.setText("");
        DrillMutliplication.textview_mul_result.setText("");
        DrillDivision.textview_div_result.setText("");
    }
    //For showing blast or particles when it is foreground
    //Condition for foreground
    public void onStart() {
        super.onStart();
        mbackground = false;
    }

    //For not showing blast or particles when it is mbackground
    //Condition for mbackground
    public void onStop() {
        super.onStop();
        mbackground = true;
    }
}
