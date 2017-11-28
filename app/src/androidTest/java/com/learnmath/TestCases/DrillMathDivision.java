package com.learnmath.TestCases;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.test.rule.ActivityTestRule;


import com.learnmath.Activities.MainActivity;
import com.learnmath.Fragments.Drill;
import com.learnmath.R;
import com.learnmath.Utils.Utils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Stellentsoft on 11/20/2017.
 */
public class DrillMathDivision {


    SharedPreferences.Editor preferencesEditor;
    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(
            MainActivity.class);
    Drill drill;
    Context context = getInstrumentation().getTargetContext();
    Utils utils =new Utils();
    // It will call before any test start
    @Before
    public void init() {
        activityRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String testUsername = "div";
                preferencesEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                preferencesEditor.putString("fluency_tag", testUsername);
                preferencesEditor.putString("level", "1");
                preferencesEditor.apply();
                drill = new Drill();
                activityRule.getActivity().getFragmentManager().beginTransaction().add(R.id.frag, drill, null).commit();
            }
        });
    }
    //Test case for drill division with one digit result with correct value
    @Test
    public void drillDivisionOneDigitForCorrect(){
        changeValues("9", "81");
        utils.keyBoardClick(9, 0);
        onView((utils.withIndex(withId(R.id.textview_div_result), 0))).check(matches(withText("9")));

    }
    //Test case for drill division with one digit result with incorrect value
    @Test
    public void drillDivisionOneDigitForInCorrect(){

        changeValues("7", "49");
        utils.keyBoardClick(9, 0);
        utils.keyBoardClick(1, 0);
        utils.keyBoardClick(7, 0);
        onView((utils.withIndex(withId(R.id.textview_div_result),0))).check(matches(withText("7")));

    }
    //Test case for drill division with two digit result without enter any wrong number
    @Test
    public void DrillDivisionOneDigitForIncorrect(){
        changeValues("8", "96");
        utils.keyBoardClick(8, 0);
        utils.keyBoardClick(1, 0);
        utils.keyBoardClick(0, 0);
        utils.keyBoardClick(2, 0);
        onView((utils.withIndex(withId(R.id.textview_div_result),0))).check(matches(withText("12")));

    }
    //Test case for drill division with one digit result with incorrect value
    @Test
    public void DrillDivisionOneDigitForCorrect(){
        changeValues("4", "48");
        utils.keyBoardClick(8, 0);
        utils.keyBoardClick(1, 0);
        utils.keyBoardClick(0, 0);
        utils.keyBoardClick(2, 0);
        utils.keyBoardClick(8, 0);
        onView((utils.withIndex(withId(R.id.textview_div_result),0))).check(matches(withText("12")));

    }

    //Test case for Fail
    @Test
    public void DrillDivisionForFail(){
        changeValues("2", "18");
        utils.keyBoardClick(8, 0);
        utils.keyBoardClick(1, 0);
        utils.keyBoardClick(0, 0);
        utils.keyBoardClick(2, 0);
        onView((utils.withIndex(withId(R.id.textview_div_result),0))).check(matches(withText("8")));

    }

    //Change the values of textviews
    public void changeValues(String first,String second) {
        onView(utils.withIndex(withId(R.id.textview_div_one),0)).perform(utils.setTextInTextView(first));
        onView(utils.withIndex(withId(R.id.textview_div_two),0)).perform(utils.setTextInTextView(second));

        drill.fluencyDivision.mdivDown = Integer.parseInt(first);
        drill.fluencyDivision.mdivUp =Integer.parseInt(second);
    }
}
