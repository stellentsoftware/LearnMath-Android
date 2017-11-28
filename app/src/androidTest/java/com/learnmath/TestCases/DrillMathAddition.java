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


@RunWith(AndroidJUnit4.class)
public class DrillMathAddition {
    Utils utils = new Utils();
    Context context = getInstrumentation().getTargetContext();
    Drill drill;
    //Initializing the fragment LearnMath with division tag
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class); //activity not launched immediately
    private SharedPreferences.Editor preferencesEditor;

    //Initializing the fragment Drill with addition tag
    @Before
    public void init() {
        activityActivityTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                preferencesEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                String testUsername = "add";
                preferencesEditor.putString("fluency_tag", testUsername);
                preferencesEditor.apply();
                drill = new Drill();
                activityActivityTestRule.getActivity().getFragmentManager().beginTransaction().add(R.id.frag, drill, null).commit();
            }
        });


    }

    //Test case with two digit result
    @Test
    public void testCaseOne() {
        changeValues("7", "7");
        utils.keyBoardClick(4, 0);
        utils.keyBoardClick(9, 0);
        utils.keyBoardClick(7, 0);
        utils.keyBoardClick(7, 0);
        utils.keyBoardClick(1, 0);
        utils.keyBoardClick(4, 0);
        onView((utils.withIndex(withId(R.id.textview_add_result), 0))).check(matches(withText("14")));
    }

    //Test case with one digit result
    @Test
    public void testCaseTwo() {
        changeValues("1", "6");
        utils.keyBoardClick(2, 0);
        utils.keyBoardClick(1, 0);
        utils.keyBoardClick(0, 0);
        utils.keyBoardClick(6, 0);
        utils.keyBoardClick(6, 0);
        utils.keyBoardClick(5, 0);
        utils.keyBoardClick(5, 0);
        utils.keyBoardClick(5, 0);
        utils.keyBoardClick(7, 0);
        onView((utils.withIndex(withId(R.id.textview_add_result), 0))).check(matches(withText("7")));
    }

    //Test case for fail condition
    @Test
    public void testCaseForFail() {
        changeValues("6", "7");
        utils.keyBoardClick(4, 0);
        utils.keyBoardClick(9, 0);
        utils.keyBoardClick(7, 0);
        utils.keyBoardClick(1, 0);
        utils.keyBoardClick(4, 0);
        onView((utils.withIndex(withId(R.id.textview_add_result), 0))).check(matches(withText("1")));
    }

    //Functionality to set our custom random values
    public void changeValues(String first, String second) {

        onView(utils.withIndex(withId(R.id.textview_add_one), 0)).perform(utils.setTextInTextView(first));
        onView(utils.withIndex(withId(R.id.textview_add_two), 0)).perform(utils.setTextInTextView(second));
        drill.fluencyAddition.mfifthRanNumAdd = Integer.parseInt(first);
        drill.fluencyAddition.mfifthRanNumAdd = Integer.parseInt(second);

    }
}
