package com.learnmath.TestCases;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.test.rule.ActivityTestRule;

import com.learnmath.Activities.MainActivity;
import com.learnmath.Fragments.ApplyMath;
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
 * Created by stellent on 11/17/2017.
 */
public class ApplyMathMultipplication {
    //Getting the MainActivity using rule
    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(
            MainActivity.class);
    ApplyMath applyMath;
    Context context = getInstrumentation().getTargetContext();
    Utils utils = new Utils();
    SharedPreferences.Editor preferencesEditor;

    //It will be called before test start
    @Before
    public void init() {
        activityRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String testUsername = "mul";
                preferencesEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                preferencesEditor.putString("apply_tag", testUsername);
                preferencesEditor.putString("level", "1");
                preferencesEditor.apply();
                applyMath = new ApplyMath();
                activityRule.getActivity().getFragmentManager().beginTransaction().add(R.id.frag, applyMath, null).commit();
            }
        });
    }

    //Test for apply math multiplication with correct value
    @Test
    public void ApplyMathMultiplicationForCorrect() {
        changeValues("9", "9");
        utils.keyBoardClick(8, 0);
        utils.keyBoardClick(1, 0);
        onView((utils.withIndex(withId(R.id.txt_final_result_one_mul), 0))).check(matches(withText("1")));

    }

    //Test for apply math multiplication with incorrect value
    @Test
    public void ApplyMathMultiplicationForINCorrect() {
        changeValues("8", "6");
        utils.keyBoardClick(0, 0);
        utils.keyBoardClick(4, 0);
        utils.keyBoardClick(0, 0);
        utils.keyBoardClick(0, 0);
        utils.keyBoardClick(8, 0);
        onView((utils.withIndex(withId(R.id.txt_final_result_one_mul), 0))).check(matches(withText("8")));
    }

    //Test for fail conditions
    @Test
    public void ApplyMathMultiplicationForFail() {
        changeValues("4", "6");
        utils.keyBoardClick(0, 0);
        utils.keyBoardClick(0, 0);
        utils.keyBoardClick(0, 0);
        utils.keyBoardClick(8, 0);
        onView((utils.withIndex(withId(R.id.txt_final_result_one_mul), 0))).check(matches(withText("5")));
    }

    //Change the values of textviews
    public void changeValues(String first, String second) {

        onView(utils.withIndex(withId(R.id.txt_number_up_one_mul), 0)).perform(utils.setTextInTextView(first));
        onView(utils.withIndex(withId(R.id.txt_number_bellow_one_mul), 0)).perform(utils.setTextInTextView(second));
        applyMath.applyMultiplication.mfirstRowRandomOneMul = Integer.parseInt(first);
        applyMath.applyMultiplication.msecondRowRandomOneMul = Integer.parseInt(second);
    }

}
