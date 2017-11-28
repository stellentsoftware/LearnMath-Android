package com.learnmath.Utils;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;
import android.widget.TextView;


import com.learnmath.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by STELLENT on 11/17/2017.
 */

public class Utils {
    //For setting the text view ids
    public  Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }

    //Set the text to the textviews
    public ViewAction setTextInTextView(final String value){
        return new ViewAction() {
            @SuppressWarnings("unchecked")
            @Override
            public void perform(UiController uiController, View view) {
                ((TextView) view).setText(value);
            }

            @Override
            public Matcher<View> getConstraints() {
                return allOf(isDisplayed(), isAssignableFrom(TextView.class));
            }

            @Override
            public String getDescription() {
                return "replace text";
            }
        };
    }
    //Set visibility to the textviews
    public ViewAction setVisibleTextView(final boolean value){
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public void perform(UiController uiController, View view) {
                view.setVisibility(value ? View.VISIBLE : View.INVISIBLE);
            }

            @Override
            public String getDescription() {
                return "Show / Hide View";
            }
        };
    }

    //perform keyboard clicks
    public void keyBoardClick(int a,int value){
        int id;
        switch(a){
            case 0:
                id= R.id.img_btn_zero;
                onView(withIndex(withId(id),value)).perform(click());
                break;
            case 1:
                id= R.id.img_btn_one;
                onView(withIndex(withId(id),value)).perform(click());
                break;
            case 2:
                id=R.id.img_btn_two;
                onView(withIndex(withId(id),value)).perform(click());
                break;
            case 3:
                id= R.id.img_btn_three;
                onView(withIndex(withId(id),value)).perform(click());
                break;
            case 4:
                id=R.id.img_btn_four;
                onView(withIndex(withId(id),value)).perform(click());
                break;
            case 5:
                id=R.id.img_btn_five;
                onView(withIndex(withId(id),value)).perform(click());
                break;
            case 6:
                id=R.id.img_btn_six;
                onView(withIndex(withId(id),value)).perform(click());
                break;
            case 7:
                id=R.id.img_btn_seven;
                onView(withIndex(withId(id),value)).perform(click());
                break;
            case 8:
                id=R.id.img_btn_eight;
                onView(withIndex(withId(id),value)).perform(click());
                break;
            case 9:
                id=R.id.img_btn_nine;
                onView(withIndex(withId(id),value)).perform(click());
                break;
        }
    }
}
