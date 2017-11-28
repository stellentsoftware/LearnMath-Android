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
public class LearnMathSubtraction {
    Utils utils = new Utils();
    private SharedPreferences.Editor preferencesEditor;
    Context context = getInstrumentation().getTargetContext();
    LearnMath learnMath;
    //Initializing the MainActivity where the fragment is present.
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class); //activity not launched immediately

    //Initializing the fragment LearnMath with subtraction tag
    @Before
    public void init() {
        activityActivityTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                preferencesEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
                String testUsername = "sub";
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
        changeValues("7","7","14",true,true,true,true,true);
        utils.keyBoardClick(1,1);
        utils.keyBoardClick(4,1);
        onView((utils.withIndex(withId(R.id.txt_sub_one),1))).check(matches(withText("14")));
        utils.keyBoardClick(7,1);
        onView((utils.withIndex(withId(R.id.txt_sub_two),1))).check(matches(withText("7")));
        utils.keyBoardClick(7,1);
        onView((utils.withIndex(withId(R.id.txt_sub_three),1))).check(matches(withText("7")));
        utils.keyBoardClick(1,1);
        utils.keyBoardClick(4,1);
        onView((utils.withIndex(withId(R.id.txt_sub_four),1))).check(matches(withText("14")));
        utils.keyBoardClick(7,1);
        onView((utils.withIndex(withId(R.id.txt_sub_five),1))).check(matches(withText("7")));
        utils.keyBoardClick(7,1);
        onView((utils.withIndex(withId(R.id.txt_sub_six),1))).check(matches(withText("7")));
    }
    //Different random numbers and two decimals result
    @Test
    public void testCasetwo() {
        changeValues("9","7","16",false,true,true,true,true);
        utils.keyBoardClick(1,1);
        utils.keyBoardClick(6,1);
        onView((utils.withIndex(withId(R.id.txt_sub_one),1))).check(matches(withText("16")));
        utils.keyBoardClick(7,1);
        onView((utils.withIndex(withId(R.id.txt_sub_two),1))).check(matches(withText("7")));
        utils.keyBoardClick(9,1);
        onView((utils.withIndex(withId(R.id.txt_sub_three),1))).check(matches(withText("9")));
        utils.keyBoardClick(1,1);
        utils.keyBoardClick(6,1);
        onView((utils.withIndex(withId(R.id.txt_sub_four),1))).check(matches(withText("16")));
        utils.keyBoardClick(9,1);
        onView((utils.withIndex(withId(R.id.txt_sub_five),1))).check(matches(withText("9")));
        utils.keyBoardClick(7,1);
        onView((utils.withIndex(withId(R.id.txt_sub_six),1))).check(matches(withText("7")));
    }

    //Different random numbers and one digit result
    @Test
    public void testCaseThree() {
        changeValues("1", "7", "8", false, false, false, false, false);
        utils.keyBoardClick(8, 1);
        //Checks weather result is entered or not if it is not the correct value test case will be failed
        onView((utils.withIndex(withId(R.id.txt_sub_one),1))).check(matches(withText("8")));
        utils.keyBoardClick(7, 1);
        onView((utils.withIndex(withId(R.id.txt_sub_two),1))).check(matches(withText("7")));
        utils.keyBoardClick(1, 1);
        onView((utils.withIndex(withId(R.id.txt_sub_three),1))).check(matches(withText("1")));
        utils.keyBoardClick(8,1);
        onView((utils.withIndex(withId(R.id.txt_sub_four),1))).check(matches(withText("8")));
        utils.keyBoardClick(1,1);
        onView((utils.withIndex(withId(R.id.txt_sub_five),1))).check(matches(withText("1")));
        utils.keyBoardClick(7,1);
        onView((utils.withIndex(withId(R.id.txt_sub_six),1))).check(matches(withText("7")));
    }

    //Same random numbers and one digit result with some wrong key entries
    @Test
    public void testCaseFour() {
        changeValues("4","4","8",true,false,false,false,false);
        utils.keyBoardClick(1,1);
        utils.keyBoardClick(2,1);
        utils.keyBoardClick(8,1);
        onView((utils.withIndex(withId(R.id.txt_sub_one),1))).check(matches(withText("8")));
        utils.keyBoardClick(1,1);
        utils.keyBoardClick(2,1);
        utils.keyBoardClick(4,1);
        onView((utils.withIndex(withId(R.id.txt_sub_two),1))).check(matches(withText("4")));
        utils.keyBoardClick(1,1);
        utils.keyBoardClick(2,1);
        utils.keyBoardClick(3,1);
        utils.keyBoardClick(4,1);
        onView((utils.withIndex(withId(R.id.txt_sub_three),1))).check(matches(withText("4")));
        utils.keyBoardClick(1,1);
        utils.keyBoardClick(2,1);
        utils.keyBoardClick(8,1);
        onView((utils.withIndex(withId(R.id.txt_sub_four),1))).check(matches(withText("8")));
        utils.keyBoardClick(1,1);
        utils.keyBoardClick(2,1);
        utils.keyBoardClick(4,1);
        onView((utils.withIndex(withId(R.id.txt_sub_five),1))).check(matches(withText("4")));
        utils.keyBoardClick(1,1);
        utils.keyBoardClick(2,1);
        utils.keyBoardClick(3,1);
        utils.keyBoardClick(4,1);
        onView((utils.withIndex(withId(R.id.txt_sub_six),1))).check(matches(withText("4")));

    }

    //Same random numbers For Fail
    @Test
    public void testCaseFail() {
        changeValues("8","8","16",true,true,true,true,true);
        utils.keyBoardClick(1,1);
        utils.keyBoardClick(6,1);
        onView((utils.withIndex(withId(R.id.txt_sub_one),1))).check(matches(withText("16")));
        utils.keyBoardClick(8,1);
        onView((utils.withIndex(withId(R.id.txt_sub_two),1))).check(matches(withText("8")));
        utils.keyBoardClick(8,1);
        onView((utils.withIndex(withId(R.id.txt_sub_three),1))).check(matches(withText("7")));
        utils.keyBoardClick(1,1);
        utils.keyBoardClick(6,1);
        onView((utils.withIndex(withId(R.id.txt_sub_four),1))).check(matches(withText("14")));
        utils.keyBoardClick(7,1);
        onView((utils.withIndex(withId(R.id.txt_sub_five),1))).check(matches(withText("7")));
        utils.keyBoardClick(7,1);
        onView((utils.withIndex(withId(R.id.txt_sub_six),1))).check(matches(withText("7")));
    }
//Functionality to set our custom random values
    public void changeValues(String first, String second,String total,boolean userSubSame,boolean userSubBaseBoolen,boolean userSubBaseBoolenFour,boolean userSubBoolen,boolean userSubBoolenFour) {

        onView(utils.withIndex(withId(R.id.txt_rand_one_sub), 1)).perform(utils.setTextInTextView(first));
        onView(utils.withIndex(withId(R.id.txt_rand_two_sub), 1)).perform(utils.setTextInTextView(second));
        onView(utils.withIndex(withId(R.id.txt_total_sub), 1)).perform(utils.setTextInTextView(total));

        learnMath.firstRanNumSub = Integer.parseInt(first);
        learnMath.secondRanNumSub = Integer.parseInt(second);
        learnMath.mtotalSub = Integer.parseInt(total);;
        learnMath.muserSubSame = userSubSame;
        learnMath.muserSubBaseBoolen = userSubBaseBoolen;
        learnMath.muserSubBaseBoolenFour = userSubBaseBoolenFour;
        learnMath.muserSubBoolen = userSubBoolen;
        learnMath.muserSubBoolenFour = userSubBoolenFour;

    }



}
