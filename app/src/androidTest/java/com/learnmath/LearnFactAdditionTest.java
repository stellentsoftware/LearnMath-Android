package com.learnmath;

import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.learnmath.activities.MainActivity;
import com.learnmath.fragments.LearnMath;

import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by mohan on 10/27/2017.
 */


@RunWith(AndroidJUnit4.class)
public class LearnFactAdditionTest extends ActivityInstrumentationTestCase2<MainActivity>{

private LearnMath booksFragment;

public LearnFactAdditionTest(){
        super(MainActivity.class);
        }

@Override
protected void setUp()throws Exception{
        super.setUp();

        booksFragment=new LearnMath();
        getActivity().getFragmentManager().beginTransaction().add(R.id.frag,booksFragment,null).commit();

    getInstrumentation().waitForIdleSync();
        }

    @Test
public void test_Should_Set_Title_TextView_Text(){
        TextView titleTextView=(TextView)booksFragment.getView().findViewById(R.id.txt_first_num_add);

    assertTrue("some title here", (titleTextView.getText().equals("")));
        }


}

