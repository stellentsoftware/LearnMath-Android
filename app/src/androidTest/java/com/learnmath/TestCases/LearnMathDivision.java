
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
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class LearnMathDivision {
    Utils utils = new Utils();
    private SharedPreferences.Editor preferencesEditor;
    Context context = getInstrumentation().getTargetContext();
    LearnMath learnMath;
    //Initializing the MainActivity where the fragment is present.
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class); //activity not launched immediately

    //Initializing the fragment LearnMath with division tag
    @Before
    public void init() {
        activityActivityTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                preferencesEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                String testUsername = "div";
                preferencesEditor.putString("tag", testUsername);
                preferencesEditor.apply();
                learnMath = new LearnMath();
                activityActivityTestRule.getActivity().getFragmentManager().beginTransaction().add(R.id.frag, learnMath, null).commit();
            }
        });
    }

    //Same random numbers and two digit result
    @Test
    public void testCaseOne() {
        changeValues("7", "7", "49", true, true, true, true, true);
        utils.keyBoardClick(4, 1);
        utils.keyBoardClick(9, 1);
        utils.keyBoardClick(7, 1);
        utils.keyBoardClick(7, 1);
        utils.keyBoardClick(4, 1);
        utils.keyBoardClick(9, 1);
        utils.keyBoardClick(7, 1);
        utils.keyBoardClick(7, 1);
        onView((utils.withIndex(withId(R.id.txt_div_six), 1))).check(matches(withText("7")));
    }

    //Different random numbers and two digit result
    @Test
    public void testCasetwo() {
        changeValues("9", "7", "63", false, true, true, true, true);
        utils.keyBoardClick(6, 1);
        utils.keyBoardClick(3, 1);
        utils.keyBoardClick(7, 1);
        utils.keyBoardClick(9, 1);
        utils.keyBoardClick(6, 1);
        utils.keyBoardClick(3, 1);
        utils.keyBoardClick(9, 1);
        utils.keyBoardClick(7, 1);
        onView((utils.withIndex(withId(R.id.txt_div_six), 1))).check(matches(withText("7")));
    }

    //Different random numbers and one digit result
    @Test
    public void testCaseThree() {
        changeValues("1", "7", "7", false, false, false, false, false);
        utils.keyBoardClick(7, 1);
        utils.keyBoardClick(7, 1);
        utils.keyBoardClick(1, 1);
        utils.keyBoardClick(7, 1);
        utils.keyBoardClick(1, 1);
        utils.keyBoardClick(7, 1);
        onView((utils.withIndex(withId(R.id.txt_div_six), 1))).check(matches(withText("7")));
    }

    //Same random numbers and one digit result with some wrong key entries
    @Test
    public void testCaseFour() {
        changeValues("2", "2", "4", true, false, false, false, false);
        utils.keyBoardClick(1, 1);
        utils.keyBoardClick(2, 1);
        utils.keyBoardClick(4, 1);
        utils.keyBoardClick(1, 1);
        utils.keyBoardClick(4, 1);
        utils.keyBoardClick(2, 1);
        utils.keyBoardClick(1, 1);
        utils.keyBoardClick(5, 1);
        utils.keyBoardClick(3, 1);
        utils.keyBoardClick(2, 1);
        utils.keyBoardClick(1, 1);
        utils.keyBoardClick(2, 1);
        utils.keyBoardClick(4, 1);
        utils.keyBoardClick(1, 1);
        utils.keyBoardClick(3, 1);
        utils.keyBoardClick(2, 1);
        utils.keyBoardClick(1, 1);
        utils.keyBoardClick(1, 1);
        utils.keyBoardClick(3, 1);
        utils.keyBoardClick(2, 1);
        onView((utils.withIndex(withId(R.id.txt_div_six), 1))).check(matches(withText("2")));

    }

    //Different random numbers for fail condition
    @Test
    public void testCaseForFail() {
        changeValues("1", "6", "6", false, false, false, false, false);
        utils.keyBoardClick(7, 1);
        utils.keyBoardClick(7, 1);
        utils.keyBoardClick(1, 1);
        utils.keyBoardClick(1, 1);
        utils.keyBoardClick(7, 1);
        onView((utils.withIndex(withId(R.id.txt_div_six), 1))).check(matches(withText("5")));
    }
    //Functionality to set our custom random values
    public void changeValues(String first, String second, String total, boolean userDivSame, boolean userDivBaseBoolen, boolean userDivBaseBoolenFour, boolean userDivBoolen, boolean userDivBoolenFour) {

        onView(utils.withIndex(withId(R.id.txt_rand_one_div), 1)).perform(utils.setTextInTextView(first));
        onView(utils.withIndex(withId(R.id.txt_rand_two_div), 1)).perform(utils.setTextInTextView(second));
        onView(utils.withIndex(withId(R.id.txt_total_div), 1)).perform(utils.setTextInTextView(total));

        learnMath.firstRanNumDiv = Integer.parseInt(first);
        learnMath.secondRanNumDiv = Integer.parseInt(second);
        learnMath.mtotalDiv = Integer.parseInt(total);
        learnMath.muserDivSame = userDivSame;
        learnMath.muserDivBaseBoolen = userDivBaseBoolen;
        learnMath.muserDivBaseBoolenFour = userDivBaseBoolenFour;
        learnMath.muserDivBoolen = userDivBoolen;
        learnMath.muserDivBoolenFour = userDivBoolenFour;

    }


}
