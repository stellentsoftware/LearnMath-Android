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
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class LearnMathAddition {
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
                String testUsername = "add";
                preferencesEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                preferencesEditor.putString("tag", testUsername);
                preferencesEditor.putString("level", "1");
                preferencesEditor.apply();
                learnMath = new LearnMath();
                activityRule.getActivity().getFragmentManager().beginTransaction().add(R.id.frag, learnMath, null).commit();
            }
        });
    }
    //Test for Learn Math Addition for two digit with incorrect values
    @Test
    public void testAddForTwoDigitIncorrctValues() throws InterruptedException{

        changeValues(5,9,"14");
        utils.keyBoardClick(0, 1);
        utils.keyBoardClick(9, 1);
        utils.keyBoardClick(0, 1);
        utils.keyBoardClick(5, 1);
        utils.keyBoardClick(0, 1);
        utils.keyBoardClick(1,1);
        utils.keyBoardClick(0, 1);
        utils.keyBoardClick(4,1);
        onView((utils.withIndex(withId(R.id.txt_result_first_digit), 1))).check(matches(withText("1")));
    }

    //Test for LearnMath Addition for two digit with correct value
    @Test
    public void testAddForTwoDigitCorrectValues() {
        changeValues(5, 5, "10");
        utils.keyBoardClick(5, 1);
        utils.keyBoardClick(5, 1);
        utils.keyBoardClick(1, 1);
        utils.keyBoardClick(0, 1);
        onView((utils.withIndex(withId(R.id.txt_result_first_digit),1))).check(matches(withText("1")));
    }
    //Test for LearnMath Addition for one digit with correct value
    @Test
    public void testAddForOneDigitCorrectValues() {
        changeValues(5, 4, "9");
        utils.keyBoardClick(4, 1);
        utils.keyBoardClick(5, 1);
        utils.keyBoardClick(9, 1);

        onView((utils.withIndex(withId(R.id.txt_result_first_digit),1))).check(matches(withText("9")));
    }
    //Test for LearnMath Addition for one digit with incorrect value
    @Test
    public void testAddForOneDigitInCorrectValues() {
        changeValues(1, 2, "4");
        utils.keyBoardClick(5, 1);
        utils.keyBoardClick(5, 1);
        utils.keyBoardClick(2, 1);
        utils.keyBoardClick(5, 1);
        utils.keyBoardClick(5, 1);
        utils.keyBoardClick(1, 1);
        utils.keyBoardClick(5, 1);
        utils.keyBoardClick(5, 1);
        utils.keyBoardClick(4, 1);
        onView((utils.withIndex(withId(R.id.txt_result_first_digit),1))).check(matches(withText("4")));
    }
    //Test for LearnMath Addition for fail condition
    @Test
    public void testAddForFail() {
        changeValues(9, 4, "5");
        utils.keyBoardClick(4, 1);

        utils.keyBoardClick(9, 1);

        onView((utils.withIndex(withId(R.id.txt_result_first_digit),1))).check(matches(withText("1")));
    }

    //Change the values of textviews
    public void changeValues(int first,int second,String result){
        onView(utils.withIndex(withId(R.id.txt_rand_one_add),1)).check(matches(isDisplayed()));
        onView(utils.withIndex(withId(R.id.txt_rand_one_add),1)).perform(utils.setTextInTextView(String.valueOf(first)));
        onView(utils.withIndex(withId(R.id.txt_rand_two_add),1)).perform(utils.setTextInTextView(String.valueOf(second)));
        learnMath.firstRanNum =first;
        learnMath.secondRanNum = second;
        learnMath.finalAddition =result;
        if(learnMath.finalAddition.length() ==1){
            onView(utils.withIndex(withId(R.id.txt_result_second_digit),1)).perform(utils.setVisibleTextView(false));
        }else{
            onView(utils.withIndex(withId(R.id.txt_result_second_digit),1)).perform(utils.setVisibleTextView(true));

        }
    }

}

