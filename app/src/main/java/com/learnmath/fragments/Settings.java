package com.learnmath.Fragments;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.learnmath.R;
import com.learnmath.Utils.FontChange;

/**
 * Created by stellent on 10/5/2017.
 */
public class Settings extends Fragment implements View.OnClickListener {
    RelativeLayout rl_apply;
    Switch switchSound;
    SeekBar customSeekBarDrill, customSeekBar_questions;
    public static TextView txt_seek_bar_questions, txt_seek_bar_drill;
    TextView txt_apply, txt_numbers_use_three, txt_numbers_use_five, txt_numbers_use_nine, txt_settings_head, txt_sound, txt_drill_timer, txt_category, txt_numbers_use, txt_math_level, txt_number_of_questions;
    ImageView img_close, img_level_one, img_level_two, img_level_three, img_level_four, img_operation_plus, img_operation_minus, img_operation_mult, img_operation_div;
    public  String numberOfQuestionsShare, numberOfQuestions = "0", mdrillTime = "60";
    String mMathLevel = "1", mselectedNumbers = "3", moperation, mlevelFromShare, mselectedNumbersShare, moperationShare, mdrillTimeShare;
    boolean msound = true, msoundShare = false,changingCount = false, inSettings = false;
    public static boolean countTime = false, timer = false,  imgCloseBoolean = false;
    FontChange mfont = new FontChange();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings, container, false);
        rl_apply = (RelativeLayout) view.findViewById(R.id.rl_apply);
        customSeekBarDrill = (SeekBar) view.findViewById(R.id.customSeekBar_drill);
        txt_seek_bar_drill = (TextView) view.findViewById(R.id.txt_seek_bar_drill);
        img_close = (ImageView) view.findViewById(R.id.img_close);
        switchSound = (Switch) view.findViewById(R.id.switch_sound);
        customSeekBar_questions = (SeekBar) view.findViewById(R.id.customSeekBar_questions);
        txt_seek_bar_questions = (TextView) view.findViewById(R.id.txt_seek_bar_questions);
        txt_settings_head = (TextView) view.findViewById(R.id.txt_settings_head);
        txt_category = (TextView) view.findViewById(R.id.txt_category);
        txt_drill_timer = (TextView) view.findViewById(R.id.txt_drill_timer);
        txt_numbers_use = (TextView) view.findViewById(R.id.txt_numbers_use);
        txt_number_of_questions = (TextView) view.findViewById(R.id.txt_number_of_questions);
        txt_math_level = (TextView) view.findViewById(R.id.txt_math_level);
        txt_sound = (TextView) view.findViewById(R.id.txt_sound);
        txt_numbers_use_three = (TextView) view.findViewById(R.id.txt_numbers_use_three);
        txt_numbers_use_five = (TextView) view.findViewById(R.id.txt_numbers_use_five);
        txt_numbers_use_nine = (TextView) view.findViewById(R.id.txt_numbers_use_nine);
        img_level_one = (ImageView) view.findViewById(R.id.img_level_one);
        img_level_two = (ImageView) view.findViewById(R.id.img_level_two);
        img_level_three = (ImageView) view.findViewById(R.id.img_level_three);
        img_level_four = (ImageView) view.findViewById(R.id.img_level_four);
        img_operation_plus = (ImageView) view.findViewById(R.id.img_operation_plus);
        img_operation_minus = (ImageView) view.findViewById(R.id.img_operation_minus);
        img_operation_mult = (ImageView) view.findViewById(R.id.img_operation_mult);
        img_operation_div = (ImageView) view.findViewById(R.id.img_operation_div);
        txt_apply = (TextView) view.findViewById(R.id.txt_apply);

        //Setting font style for the text views
        setFontStyle();

        //Setting onclicks
        img_level_one.setOnClickListener(this);
        img_level_two.setOnClickListener(this);
        img_level_three.setOnClickListener(this);
        img_level_four.setOnClickListener(this);
        txt_numbers_use_three.setOnClickListener(this);
        txt_numbers_use_five.setOnClickListener(this);
        txt_numbers_use_nine.setOnClickListener(this);
        img_operation_plus.setOnClickListener(this);
        img_operation_minus.setOnClickListener(this);
        img_operation_mult.setOnClickListener(this);
        img_operation_div.setOnClickListener(this);
        rl_apply.setOnClickListener(this);
        img_close.setOnClickListener(this);

        inSettings = true;
        //getting the  values from shared preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mlevelFromShare = prefs.getString("level", "");
        mselectedNumbersShare = prefs.getString("selected_numbers", "");
        moperationShare = prefs.getString("operation", "");
        mdrillTimeShare = prefs.getString("drill_time", "");
        numberOfQuestionsShare = prefs.getString("numberOfQuestions", "");
        msoundShare = prefs.getBoolean("sound", true);
        if (mdrillTimeShare.equals("") && numberOfQuestionsShare.equals("")) {
            txt_seek_bar_drill.setText(mdrillTime);
            txt_seek_bar_questions.setText("0");
        } else {
            txt_seek_bar_drill.setText(mdrillTimeShare);
            txt_seek_bar_questions.setText(numberOfQuestionsShare);
        }

        //Setting the lavel status of settings getting from the shared preference
        if (mlevelFromShare.equals("")) {
            mMathLevel = "1";
            img_level_one.setImageResource(R.drawable.level_one_selected);
            img_level_two.setImageResource(R.drawable.level_two);
            img_level_three.setImageResource(R.drawable.level_three);
            img_level_four.setImageResource(R.drawable.level_four);
        } else {
            mMathLevel = mlevelFromShare;
            switch (mlevelFromShare) {
                case "1":
                    img_level_one.setImageResource(R.drawable.level_one_selected);
                    img_level_two.setImageResource(R.drawable.level_two);
                    img_level_three.setImageResource(R.drawable.level_three);
                    img_level_four.setImageResource(R.drawable.level_four);
                    break;
                case "2":
                    img_level_one.setImageResource(R.drawable.level_one);
                    img_level_two.setImageResource(R.drawable.level_two_selected);
                    img_level_three.setImageResource(R.drawable.level_three);
                    img_level_four.setImageResource(R.drawable.level_four);
                    break;
                case "3":
                    img_level_one.setImageResource(R.drawable.level_one);
                    img_level_two.setImageResource(R.drawable.level_two);
                    img_level_three.setImageResource(R.drawable.level_three_selected);
                    img_level_four.setImageResource(R.drawable.level_four);
                    break;
                case "4":
                    img_level_one.setImageResource(R.drawable.level_one);
                    img_level_two.setImageResource(R.drawable.level_two);
                    img_level_three.setImageResource(R.drawable.level_three);
                    img_level_four.setImageResource(R.drawable.level_four_selected);
                    break;
            }
        }

        //Setting the selected numbers status of settings getting from the shared preference
        if (mselectedNumbersShare.equals("")) {
            mselectedNumbers = "3";
        } else {
            mselectedNumbers = mselectedNumbersShare;
            switch (mselectedNumbers) {
                case "3":
                    txt_numbers_use_three.setBackgroundResource(R.drawable.rectangle_on);
                    txt_numbers_use_five.setBackgroundResource(R.drawable.rectangle_off);
                    txt_numbers_use_nine.setBackgroundResource(R.drawable.rectangle_off);
                    txt_numbers_use_three.setTextColor(getResources().getColor(R.color.white_color));
                    txt_numbers_use_five.setTextColor(getResources().getColor(R.color.circle_color));
                    txt_numbers_use_nine.setTextColor(getResources().getColor(R.color.circle_color));
                    break;
                case "5":
                    txt_numbers_use_three.setBackgroundResource(R.drawable.rectangle_off);
                    txt_numbers_use_five.setBackgroundResource(R.drawable.rectangle_on);
                    txt_numbers_use_nine.setBackgroundResource(R.drawable.rectangle_off);
                    txt_numbers_use_three.setTextColor(getResources().getColor(R.color.circle_color));
                    txt_numbers_use_five.setTextColor(getResources().getColor(R.color.white_color));
                    txt_numbers_use_nine.setTextColor(getResources().getColor(R.color.circle_color));
                    break;
                case "9":
                    txt_numbers_use_three.setBackgroundResource(R.drawable.rectangle_off);
                    txt_numbers_use_five.setBackgroundResource(R.drawable.rectangle_off);
                    txt_numbers_use_nine.setBackgroundResource(R.drawable.rectangle_on);
                    txt_numbers_use_three.setTextColor(getResources().getColor(R.color.circle_color));
                    txt_numbers_use_five.setTextColor(getResources().getColor(R.color.circle_color));
                    txt_numbers_use_nine.setTextColor(getResources().getColor(R.color.white_color));
                    break;
            }

        }

        //Setting the operation status of settings getting from the shared preference
        if (moperationShare.equals("")) {
            moperation = "add";
        } else {
            moperation = moperationShare;
            switch (moperation) {
                case "add":
                    img_operation_plus.setImageResource(R.drawable.plus_selected);
                    img_operation_minus.setImageResource(R.drawable.minus_off);
                    img_operation_mult.setImageResource(R.drawable.multiplication_off);
                    img_operation_div.setImageResource(R.drawable.division_off);
                    break;
                case "sub":
                    img_operation_plus.setImageResource(R.drawable.plus_off);
                    img_operation_minus.setImageResource(R.drawable.minus_selected);
                    img_operation_mult.setImageResource(R.drawable.multiplication_off);
                    img_operation_div.setImageResource(R.drawable.division_off);
                    break;
                case "mul":
                    img_operation_plus.setImageResource(R.drawable.plus_off);
                    img_operation_minus.setImageResource(R.drawable.minus_off);
                    img_operation_mult.setImageResource(R.drawable.multiplication_selected);
                    img_operation_div.setImageResource(R.drawable.division_off);
                    break;
                case "div":
                    img_operation_plus.setImageResource(R.drawable.plus_off);
                    img_operation_minus.setImageResource(R.drawable.minus_off);
                    img_operation_mult.setImageResource(R.drawable.multiplication_off);
                    img_operation_div.setImageResource(R.drawable.division_selected);
                    break;
            }
        }
        //Setting the drill time status of settings getting from the shared preference

        if (mdrillTimeShare.equals("")) {
            mdrillTime = "60";
            customSeekBarDrill.setProgress(60);
            txt_seek_bar_drill.setText(prefs.getString("drill_time", "60"));
        } else {
            mdrillTime = mdrillTimeShare;
            customSeekBarDrill.setProgress(Integer.parseInt(mdrillTime));
        }
        //Setting the number of questions status of settings getting from the shared preference
        if (numberOfQuestionsShare.equals("")) {
            customSeekBar_questions.setProgress(0);
        } else {
            numberOfQuestions = numberOfQuestionsShare;
            customSeekBar_questions.setProgress(Integer.parseInt(numberOfQuestions));
        }
        //Setting the sound status of settings getting from the shared preference
        msound = msoundShare;
        switchSound.setChecked(msound); //false default
        //Change the msound status
        switchSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                msound = isChecked;
            }
        });

        // Perform seek bar change listener event used for getting the drill value
        customSeekBarDrill.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txt_seek_bar_drill.setText(String.valueOf(progress));
                mdrillTime = String.valueOf(progress);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        // Perform seek bar change listener event used for getting the number of questions value
        customSeekBar_questions.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txt_seek_bar_questions.setText(String.valueOf(progress));
                numberOfQuestions = String.valueOf(progress);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        return view;
    }

    //Setting font style for the text views
    private void setFontStyle() {

        mfont.fontChange(txt_settings_head, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_sound, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_math_level, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_numbers_use, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_drill_timer, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_category, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_seek_bar_drill, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_seek_bar_questions, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_apply, "fonts/textFont.ttf", getActivity());
        mfont.fontChange(txt_number_of_questions, "fonts/textFont.ttf", getActivity());

    }

    //Performing onclick for views
    @Override
    public void onClick(View view) {
        //Performing on click for  buttons
        switch (view.getId()) {
            case R.id.img_close:
                imgCloseBoolean = true;
                inSettings = false;
                getFragmentManager().popBackStack();
                break;
            case R.id.img_level_one:
                img_level_one.setImageResource(R.drawable.level_one_selected);
                img_level_two.setImageResource(R.drawable.level_two);
                img_level_three.setImageResource(R.drawable.level_three);
                img_level_four.setImageResource(R.drawable.level_four);
                mMathLevel = "1";
                break;
            case R.id.img_level_two:
                img_level_one.setImageResource(R.drawable.level_one);
                img_level_two.setImageResource(R.drawable.level_two_selected);
                img_level_three.setImageResource(R.drawable.level_three);
                img_level_four.setImageResource(R.drawable.level_four);
                mMathLevel = "2";
                break;
            case R.id.img_level_three:
                img_level_one.setImageResource(R.drawable.level_one);
                img_level_two.setImageResource(R.drawable.level_two);
                img_level_three.setImageResource(R.drawable.level_three_selected);
                img_level_four.setImageResource(R.drawable.level_four);
                mMathLevel = "3";
                break;
            case R.id.img_level_four:
                img_level_one.setImageResource(R.drawable.level_one);
                img_level_two.setImageResource(R.drawable.level_two);
                img_level_three.setImageResource(R.drawable.level_three);
                img_level_four.setImageResource(R.drawable.level_four_selected);
                mMathLevel = "4";
                break;
            case R.id.txt_numbers_use_three:
                txt_numbers_use_three.setBackgroundResource(R.drawable.rectangle_on);
                txt_numbers_use_five.setBackgroundResource(R.drawable.rectangle_off);
                txt_numbers_use_nine.setBackgroundResource(R.drawable.rectangle_off);
                txt_numbers_use_three.setTextColor(getResources().getColor(R.color.white_color));
                txt_numbers_use_five.setTextColor(getResources().getColor(R.color.circle_color));
                txt_numbers_use_nine.setTextColor(getResources().getColor(R.color.circle_color));
                mselectedNumbers = "3";
                break;
            case R.id.txt_numbers_use_five:
                txt_numbers_use_three.setBackgroundResource(R.drawable.rectangle_off);
                txt_numbers_use_five.setBackgroundResource(R.drawable.rectangle_on);
                txt_numbers_use_nine.setBackgroundResource(R.drawable.rectangle_off);
                txt_numbers_use_three.setTextColor(getResources().getColor(R.color.circle_color));
                txt_numbers_use_five.setTextColor(getResources().getColor(R.color.white_color));
                txt_numbers_use_nine.setTextColor(getResources().getColor(R.color.circle_color));
                mselectedNumbers = "5";
                break;
            case R.id.txt_numbers_use_nine:

                txt_numbers_use_three.setBackgroundResource(R.drawable.rectangle_off);
                txt_numbers_use_five.setBackgroundResource(R.drawable.rectangle_off);
                txt_numbers_use_nine.setBackgroundResource(R.drawable.rectangle_on);
                txt_numbers_use_three.setTextColor(getResources().getColor(R.color.circle_color));
                txt_numbers_use_five.setTextColor(getResources().getColor(R.color.circle_color));
                txt_numbers_use_nine.setTextColor(getResources().getColor(R.color.white_color));
                mselectedNumbers = "9";
                break;
            case R.id.img_operation_plus:
                img_operation_plus.setImageResource(R.drawable.plus_selected);
                img_operation_minus.setImageResource(R.drawable.minus_off);
                img_operation_mult.setImageResource(R.drawable.multiplication_off);
                img_operation_div.setImageResource(R.drawable.division_off);
                moperation = "add";
                break;
            case R.id.img_operation_minus:
                img_operation_plus.setImageResource(R.drawable.plus_off);
                img_operation_minus.setImageResource(R.drawable.minus_selected);
                img_operation_mult.setImageResource(R.drawable.multiplication_off);
                img_operation_div.setImageResource(R.drawable.division_off);
                moperation = "sub";
                break;
            case R.id.img_operation_mult:
                img_operation_plus.setImageResource(R.drawable.plus_off);
                img_operation_minus.setImageResource(R.drawable.minus_off);
                img_operation_mult.setImageResource(R.drawable.multiplication_selected);
                img_operation_div.setImageResource(R.drawable.division_off);
                moperation = "mul";
                break;
            case R.id.img_operation_div:
                img_operation_plus.setImageResource(R.drawable.plus_off);
                img_operation_minus.setImageResource(R.drawable.minus_off);
                img_operation_mult.setImageResource(R.drawable.multiplication_off);
                img_operation_div.setImageResource(R.drawable.division_selected);
                moperation = "div";
                break;
            case R.id.rl_apply:
                countTime = true;
                timer = true;
                changingCount = true;
                if (Drill.waitTimer != null) {
                    Drill.waitTimer.cancel();
                }
                //Save values in shared preference
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("level", mMathLevel);
                editor.putString("selected_numbers", mselectedNumbers);
                editor.putString("operation", moperation);
                editor.putString("apply_tag", moperation);
                editor.putString("tag", moperation);
                editor.putString("fluency_tag", moperation);
                editor.putString("drill_time", mdrillTime);
                editor.putString("numberOfQuestions", numberOfQuestions);
                editor.putBoolean("sound", msound);
                editor.commit();
                inSettings = false;
                LearnMath learn = new LearnMath();
                getActivity().getFragmentManager().beginTransaction().replace(R.id.frag, learn).commit();
                break;
        }

    }

    //Handle device back button
    public boolean backButton() {
        inSettings = false;
        getFragmentManager().popBackStack();
        if (Drill.waitTimer != null) {
            Drill.waitTimer.cancel();
        }
        return true;
    }
}
