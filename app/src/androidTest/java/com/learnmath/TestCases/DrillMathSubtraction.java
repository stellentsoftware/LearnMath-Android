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
public class DrillMathSubtraction {
    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(
            MainActivity.class);
    SharedPreferences.Editor preferencesEditor;
    Drill drill;
    Context context = getInstrumentation().getTargetContext();
    Utils utils =new Utils();

    //It will execute before start the test
    @Before
    public void init() {
        activityRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String testUsername = "sub";
                preferencesEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                preferencesEditor.putString("fluency_tag", testUsername);
                preferencesEditor.putString("level", "1");
                preferencesEditor.apply();
                drill = new Drill();
                activityRule.getActivity().getFragmentManager().beginTransaction().add(R.id.frag, drill, null).commit();
            }
        });
    }
    //Test for drill subtraction with correct value
    @Test
    public void drillSubtractionDigitForCorrectValues() {
        changeValues("4", "2");
        utils.keyBoardClick(1, 0);
        utils.keyBoardClick(2, 0);
        onView((utils.withIndex(withId(R.id.textview_sub_result), 0))).check(matches(withText("2")));
    }
    //Test for drill subtraction  with incorrect value
    @Test
    public void drillSubtractionDigitForIncorrectValues() {
        changeValues("6", "5");
        utils.keyBoardClick(2, 0);
        utils.keyBoardClick(2, 0);
        utils.keyBoardClick(2, 0);
        utils.keyBoardClick(2, 0);
        utils.keyBoardClick(1, 0);
        onView((utils.withIndex(withId(R.id.textview_sub_result), 0))).check(matches(withText("1")));

    }


    //Test for drill subtraction fail condition
    @Test
    public void drillSubtractionForFail() {
        changeValues("6", "2");
        utils.keyBoardClick(1, 0);
        utils.keyBoardClick(2, 0);
        onView((utils.withIndex(withId(R.id.textview_sub_result), 0))).check(matches(withText("2")));
    }

    //Change the values of textviews
    public void changeValues(String first,String second) {
        onView(utils.withIndex(withId(R.id.textview_sub_one), 0)).perform(utils.setTextInTextView(first));
        onView(utils.withIndex(withId(R.id.textview_sub_two), 0)).perform(utils.setTextInTextView(second));
        drill.fluencySubstraction.mfirstRanNumSub = Integer.parseInt(first);
        drill.fluencySubstraction.mfifthRanNumSub =Integer.parseInt(second);
    }

}
