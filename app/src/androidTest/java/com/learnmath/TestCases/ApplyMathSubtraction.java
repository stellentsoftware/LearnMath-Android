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
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class ApplyMathSubtraction {
    Utils utils = new Utils();
    Context context = getInstrumentation().getTargetContext();
    ApplyMath apply;
    //Initializing the MainActivity where the fragment is present.
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class); //activity not launched immediately
    private SharedPreferences.Editor preferencesEditor;

    //Initializing the fragment ApplyMath with subtraction tag
    @Before
    public void init() {
        activityActivityTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                preferencesEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                String testUsername = "sub";
                preferencesEditor.putString("apply_tag", testUsername);
                preferencesEditor.putString("level", "1");
                preferencesEditor.apply();
                apply = new ApplyMath();
                activityActivityTestRule.getActivity().getFragmentManager().beginTransaction().add(R.id.frag, apply, null).commit();
            }
        });
    }

    //Test case with direct result
    @Test
    public void testCaseOne() {
        changeValues("7", "6");
        utils.keyBoardClick(1, 0);
        onView((utils.withIndex(withId(R.id.txt_result_one_sub), 0))).check(matches(withText("1")));
    }

    //Test case with some wrong clicks and  then result
    @Test
    public void testCaseTwo() {
        changeValues("9", "1");
        //Wrong clicks
        utils.keyBoardClick(2, 0);
        utils.keyBoardClick(3, 0);
        utils.keyBoardClick(2, 0);
        utils.keyBoardClick(3, 0);
        utils.keyBoardClick(5, 0);

        //Right click
        utils.keyBoardClick(8, 0);
        onView((utils.withIndex(withId(R.id.txt_result_one_sub), 0))).check(matches(withText("8")));
    }
    //Test for fail conditions
    @Test
    public void testCaseForFail() {
        changeValues("5", "7");
        utils.keyBoardClick(1, 0);
        onView((utils.withIndex(withId(R.id.txt_result_one_sub), 0))).check(matches(withText("1")));
    }

    //Functionality to set our custom random values
    public void changeValues(String minuend, String subtrahend) {

        onView(withId(R.id.txt_number_up_one_sub)).perform(utils.setTextInTextView(minuend));
        onView(withId(R.id.txt_number_bellow_one_sub)).perform(utils.setTextInTextView(subtrahend));
        apply.applyFactsSubstraction.mfirstRanNumSub = Integer.parseInt(minuend);
        apply.applyFactsSubstraction.mfifthRanNumSub = Integer.parseInt(subtrahend);


    }


}
