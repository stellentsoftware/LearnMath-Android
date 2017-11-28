package com.learnmath.CouchMark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.learnmath.R;
import com.learnmath.Activities.LaunchActivity;

/**
 * Created by stellent on 10/20/2017.
 */
public class CouchMarkerThree extends android.support.v4.app.Fragment implements View.OnClickListener {

    View view;
    RelativeLayout rl_couch_three_left, rl_couch_three_right, rl_couch_three_exit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = (ViewGroup) inflater
                .inflate(R.layout.coach_mark_three, container, false);
        rl_couch_three_left = (RelativeLayout) view.findViewById(R.id.rl_couch_three_left);
        rl_couch_three_right = (RelativeLayout) view.findViewById(R.id.rl_couch_three_right);
        rl_couch_three_exit = (RelativeLayout) view.findViewById(R.id.rl_couch_three_exit);
        rl_couch_three_exit.setOnClickListener(this);
        rl_couch_three_left.setOnClickListener(this);
        rl_couch_three_right.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        //Onclicks for coach marks
        if (v.equals(rl_couch_three_left)) {
            LaunchActivity.mPager.setCurrentItem(1, true);
        } else if (v.equals(rl_couch_three_right)) {
            LaunchActivity.mPager.setCurrentItem(3, true);
        } else if (v.equals(rl_couch_three_exit)) {
            LaunchActivity.rl_pager.setVisibility(View.GONE);
            ((LaunchActivity) getActivity()).showDialogInfo();
            LaunchActivity.fromFirstLaunch++;
        }
    }
}
