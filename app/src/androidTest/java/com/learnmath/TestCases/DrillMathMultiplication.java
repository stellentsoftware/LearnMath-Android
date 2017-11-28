package com.learnmath.TestCases;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.learnmath.Activities.MainActivity;
import com.learnmath.Fragments.Drill;
import com.learnmath.R;
import com.learnmath.Utils.Utils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by stellent on 11/20/2017.
 */
@RunWith(AndroidJUnit4.class)
public class DrillMathMultiplication {

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(
            MainActivity.class);
    SharedPreferences.Editor preferencesEditor;
    Drill drill;
    Context context = getInstrumentation().getTargetContext();
    Utils utils =new Utils();
    //It will call before start any test
    @Before
    public void init() {
        activityRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String testUsername = "mul";
                preferencesEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                preferencesEditor.putString("fluency_tag", testUsername);
                preferencesEditor.putString("level", "1");

                preferencesEditor.apply();
                drill = new Drill();
                activityRule.getActivity().getFragmentManager().beginTransaction().add(R.id.frag, drill, null).commit();
            }
        });
    }
    //Test for drill multiplication two digit result with correct value
    @Test
    public void drillmultiplicationTwoDigitForCorrectValues() {
        changeValues("5", "5");
        utils.keyBoardClick(2, 0);
        utils.keyBoardClick(5,0);
        onView((utils.withIndex(withId(R.id.textview_mul_result),0))).check(matches(withText("25")));


    }


    //Test for drill multiplication two digit result with wrong number
    @Test
    public void drillmultiplicationTwoDigitForIncorrectValues() {
        changeValues("7", "8");
        utils.keyBoardClick(1, 0);
        utils.keyBoardClick(3, 0);
        utils.keyBoardClick(5, 0);
        utils.keyBoardClick(7,0);
        utils.keyBoardClick(6, 0);
        onView((utils.withIndex(withId(R.id.textview_mul_result),0))).check(matches(withText("56")));



    }
    //Test for drill multiplication one digit result with incorrect value

    @Test
    public void drillmultiplicationOneDigitForIncorrectValues() {
        changeValues("2", "3");
        utils.keyBoardClick(1, 0);
        utils.keyBoardClick(3, 0);
        utils.keyBoardClick(7,0);
        utils.keyBoardClick(6, 0);
        onView((utils.withIndex(withId(R.id.textview_mul_result),0))).check(matches(withText("6")));

    }
    //Test for drill multiplication one digit result with correct value
    @Test
    public void drillmultiplicationOneDigitForCorrectValues() {
        changeValues("4", "2");
        utils.keyBoardClick(8, 0);
        onView((utils.withIndex(withId(R.id.textview_mul_result),0))).check(matches(withText("8")));

    }

    //Test for drill multiplication fail condition
    @Test
    public void drillmultiplicationForFail() {
        changeValues("2", "2");
        utils.keyBoardClick(4, 0);
        onView((utils.withIndex(withId(R.id.textview_mul_result),0))).check(matches(withText("8")));

    }
    //Change the values of textviews
    public void changeValues(String first,String second) {
        onView(utils.withIndex(withId(R.id.textview_mul_one), 0)).perform(utils.setTextInTextView(first));
        onView(utils.withIndex(withId(R.id.textview_mul_two), 0)).perform(utils.setTextInTextView(second));
        drill.fluencyMultiplication.mfirstRowRandomOneMul =Integer.parseInt(first);
        drill.fluencyMultiplication.msecondRowRandomOneMul = Integer.parseInt(second);
    }
}
