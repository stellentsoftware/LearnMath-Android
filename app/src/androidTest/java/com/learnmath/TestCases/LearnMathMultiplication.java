package com.learnmath.TestCases;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.learnmath.Activities.MainActivity;
import com.learnmath.Fragments.LearnMath;
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
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by stellent on 11/10/2017.
 */
@RunWith(AndroidJUnit4.class)
public class LearnMathMultiplication {
    //This will get the MainActivity
    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(
            MainActivity.class);
    LearnMath learnMath;
    Utils utils = new Utils();
    Context context = getInstrumentation().getTargetContext();
    SharedPreferences.Editor preferencesEditor;
    //This will be called before test start
    @Before
    public void init() {
        activityRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String testUsername = "mul";
                preferencesEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                preferencesEditor.putString("tag", testUsername);
                preferencesEditor.putString("level", "1");
                preferencesEditor.apply();
                learnMath = new LearnMath();
                activityRule.getActivity().getFragmentManager().beginTransaction().add(R.id.frag, learnMath, null).commit();
            }
        });
    }

    //Test for two digit result multiplication without incorrect value
    @Test
    public void multiplicationForTwoDigitCorrctValues() {
        changeValues("7", "6", "42");
        utils.keyBoardClick(6, 1);
        utils.keyBoardClick(7, 1);
        utils.keyBoardClick(4, 1);
        utils.keyBoardClick(2, 1);
        onView((utils.withIndex(withId(R.id.txt_result_first_digit_mul), 1))).check(matches(withText("4")));

    }
    //Test for  two digit result multiplication with incorrect value
    @Test
     public void multiplicationForTwoDigitIncorrctValues() {
         changeValues("5", "9", "45");
         utils.keyBoardClick(2, 1);
         utils.keyBoardClick(9,1);
         utils.keyBoardClick(4,1);
         utils.keyBoardClick(5,1);
         utils.keyBoardClick(8, 1);
         utils.keyBoardClick(4,1);
         utils.keyBoardClick(8,1);
         utils.keyBoardClick(2,1);
        utils.keyBoardClick(5,1);
        onView((utils.withIndex(withId(R.id.txt_result_first_digit_mul),1))).check(matches(withText("4")));

    }
    //Test for one digit result multiplication without incorrect value
    @Test
    public void multiplicationForOneDigitCorrctValues() {
        changeValues("3", "3", "9");
        utils.keyBoardClick(3, 1);
        utils.keyBoardClick(3, 1);
        utils.keyBoardClick(9, 1);
        onView((utils.withIndex(withId(R.id.txt_result_first_digit_mul),1))).check(matches(withText("9")));

    }
    //Test for one digit result multiplication with incorrect value
    @Test
    public void multiplicationForOneDigitIncorrctValues() {
        changeValues("4", "2", "8");
        utils.keyBoardClick(3, 1);
        utils.keyBoardClick(1, 1);
        utils.keyBoardClick(2, 1);
        utils.keyBoardClick(6, 1);
        utils.keyBoardClick(7, 1);
        utils.keyBoardClick(4, 1);
        utils.keyBoardClick(3, 1);
        utils.keyBoardClick(8, 1);
        onView((utils.withIndex(withId(R.id.txt_result_first_digit_mul),1))).check(matches(withText("8")));

    }


    //Test for learn math multiplication fail condition
    @Test
    public void multiplicationForFail() {
        changeValues("2", "3", "6");
        utils.keyBoardClick(3, 1);
        utils.keyBoardClick(2, 1);
        utils.keyBoardClick(9, 1);
        onView((utils.withIndex(withId(R.id.txt_result_first_digit_mul),1))).check(matches(withText("9")));

    }
    //Change the values of textviews
    public void changeValues(String first,String second,String result) {
        onView(utils.withIndex(withId(R.id.txt_rand_one_mul), 1)).perform(utils.setTextInTextView(first));
        onView(utils.withIndex(withId(R.id.txt_rand_two_mul), 1)).perform(utils.setTextInTextView(second));
        learnMath.finalMultiplication =result;
        if(learnMath.finalMultiplication.length() ==1){
            onView(utils.withIndex(withId(R.id.txt_result_second_digit_mul),1)).perform(utils.setVisibleTextView(false));
        }else{
            onView(utils.withIndex(withId(R.id.txt_result_second_digit_mul),1)).perform(utils.setVisibleTextView(true));

        }
    }

}
