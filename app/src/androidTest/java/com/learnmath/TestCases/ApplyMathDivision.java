package com.learnmath.TestCases;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.learnmath.Activities.MainActivity;
import com.learnmath.Fragments.ApplyMath;
import com.learnmath.R;
import com.learnmath.Utils.Utils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by stellent on 11/17/2017.
 */
@RunWith(AndroidJUnit4.class)
public class ApplyMathDivision
{
    //Calling the MainActivity using rule
    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(
            MainActivity.class);
    ApplyMath applyMath;
    Context context = getInstrumentation().getTargetContext();
    Utils utils =new Utils();
    SharedPreferences.Editor preferencesEditor;
    //This will be called before the test started
    @Before
    public void init() {
        activityRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {


                String testUsername = "div";
                preferencesEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                preferencesEditor.putString("apply_tag", testUsername);
                preferencesEditor.putString("level", "1");
                preferencesEditor.apply();
                applyMath = new ApplyMath();
                activityRule.getActivity().getFragmentManager().beginTransaction().add(R.id.frag, applyMath, null).commit();
            }
        });
    }
    //For one Digit result with incorrect values
    @Test
    public void ApplymathdivisionForOneDigitIncorrect(){

        changeValues("6", " ", "3");
        keyClick(R.id.tv_btn_three);
        keyClick(R.id.tv_btn_zer0);
        keyClick(R.id.tv_btn_two);
        keyClick(R.id.tv_btn_three);
        keyClick(R.id.tv_btn_six);
        keyClick(R.id.tv_btn_six);
        keyClick(R.id.tv_btn_three);
        keyClick(R.id.tv_btn_six);
        keyClick(R.id.tv_btn_zer0);
        onView((utils.withIndex(withId(R.id.txt_third_first), 0))).check(matches(withText("0")));
    }

    //For one Digit result with correct values
    @Test
    public void ApplymathdivisionForOneDigitCorrect() {

        changeValues("8", " ", "2");
        keyClick(R.id.tv_btn_four);
        keyClick(R.id.tv_btn_eight);
        keyClick(R.id.tv_btn_zer0);
        onView((utils.withIndex(withId(R.id.txt_third_first), 0))).check(matches(withText("0")));


    }
    //For Two Digit result with correct values
    @Test
    public void ApplymathdivisionForTwoDigitCorrect(){

        changeValues("3", "6", "6");
        keyClick(R.id.tv_btn_zer0);
        keyClick(R.id.tv_btn_zer0);
        keyClick(R.id.tv_btn_three);
        keyClick(R.id.tv_btn_six);
        keyClick(R.id.tv_btn_six);
        keyClick(R.id.tv_btn_three);
        keyClick(R.id.tv_btn_six);
        keyClick(R.id.tv_btn_zer0);

        onView((utils.withIndex(withId(R.id.txt_fifth_second), 0))).check(matches(withText("0")));
    }
    //For two digit result with incorrect values
    @Test
    public void ApplymathDivisionForTwoDigitInCorrect() {

        changeValues("1", "6", "4");
        keyClick(R.id.tv_btn_zer0);
        keyClick(R.id.tv_btn_zer0);
        keyClick(R.id.tv_btn_three);
        keyClick(R.id.tv_btn_one);
        keyClick(R.id.tv_btn_three);
        keyClick(R.id.tv_btn_three);
        keyClick(R.id.tv_btn_six);
        keyClick(R.id.tv_btn_three);
        keyClick(R.id.tv_btn_four);
        keyClick(R.id.tv_btn_six);
        keyClick(R.id.tv_btn_one);
        keyClick(R.id.tv_btn_six);
        keyClick(R.id.tv_btn_six);
        keyClick(R.id.tv_btn_zer0);

        onView((utils.withIndex(withId(R.id.txt_fifth_second), 0))).check(matches(withText("0")));

    }
    //Test for division with remainder using correct values
    @Test
    public void ApplyMathDivisionForRemainder(){
        changeValues("1", "3", "3");
        keyClick(R.id.tv_btn_zer0);
        keyClick(R.id.tv_btn_zer0);
        keyClick(R.id.tv_btn_one);
        keyClick(R.id.tv_btn_three);
        keyClick(R.id.tv_btn_four);
        keyClick(R.id.tv_btn_one);
        keyClick(R.id.tv_btn_two);
        keyClick(R.id.tv_btn_rem);
        keyClick(R.id.tv_btn_one);
        onView((utils.withIndex(withId(R.id.txt_fifth_second), 0))).check(matches(withText("1")));

    }
    //Test for division with remainder using incorrect values
    @Test
    public void ApplyMathDivisionForIncorrectRemainder(){
        changeValues("2", "6", "5");
        keyClick(R.id.tv_btn_zer0);
        keyClick(R.id.tv_btn_zer0);
        keyClick(R.id.tv_btn_two);
        keyClick(R.id.tv_btn_two);
        keyClick(R.id.tv_btn_two);
        keyClick(R.id.tv_btn_two);
        keyClick(R.id.tv_btn_six);
        keyClick(R.id.tv_btn_six);
        keyClick(R.id.tv_btn_five);
        keyClick(R.id.tv_btn_one);
        keyClick(R.id.tv_btn_two);
        keyClick(R.id.tv_btn_five);
        keyClick(R.id.tv_btn_one);
        keyClick(R.id.tv_btn_one);
        keyClick(R.id.tv_btn_rem);
        keyClick(R.id.tv_btn_one);
        onView((utils.withIndex(withId(R.id.txt_fifth_second), 0))).check(matches(withText("1")));

    }

    //Test case for fail condition
    @Test
    public void ApplymathdivisionForFail() {

        changeValues("8", " ", "2");
        keyClick(R.id.tv_btn_four);
        keyClick(R.id.tv_btn_zer0);
        onView((utils.withIndex(withId(R.id.txt_third_first), 0))).check(matches(withText("6")));

    }
    //Change the values of textviews
    public void changeValues(String dividentOne,String dividentTwo,String divisor) {
        onView(utils.withIndex(withId(R.id.txt_divident_one),0)).perform(utils.setTextInTextView(dividentOne));
        onView(utils.withIndex(withId(R.id.txt_divident_two),0)).perform(utils.setTextInTextView(dividentTwo));
        onView(utils.withIndex(withId(R.id.txt_divisor_one), 0)).perform(utils.setTextInTextView(divisor));
        applyMath.applyFactDivision.mDigitOne=Integer.parseInt(dividentOne);
        if(!dividentTwo.equals(" ")) {
            applyMath.applyFactDivision.mDigitTwo = Integer.parseInt(dividentTwo);
            applyMath.applyFactDivision.sDigits = 2;
        }else {
            applyMath.applyFactDivision.sDigits = 1;
        }
        applyMath.applyFactDivision.mfirstRanNumDivisor = Integer.parseInt(divisor);
    }
    //Keyboard Onclicks
    public void keyClick(int textViewId){
        onView(utils.withIndex(withId(textViewId),0)).perform(click());

    }

}
