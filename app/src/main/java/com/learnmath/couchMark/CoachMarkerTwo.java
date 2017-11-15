package com.learnmath.couchMark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.learnmath.R;
import com.learnmath.activities.LaunchActivity;

/**
 * Created by stellent on 10/20/2017.
 */
public class CoachMarkerTwo extends android.support.v4.app.Fragment implements View.OnClickListener {

    View view;
    RelativeLayout rl_couch_two_top, rl_couch_two_bottom, rl_couch_two_exit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = (ViewGroup) inflater
                .inflate(R.layout.coach_mark_two, container, false);
        rl_couch_two_top = (RelativeLayout) view.findViewById(R.id.rl_couch_two_top);
        rl_couch_two_bottom = (RelativeLayout) view.findViewById(R.id.rl_couch_two_bottom);
        rl_couch_two_exit = (RelativeLayout) view.findViewById(R.id.rl_couch_two_exit);
        rl_couch_two_bottom.setOnClickListener(this);
        rl_couch_two_top.setOnClickListener(this);
        rl_couch_two_exit.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        //Onclicks for coach marks
        if (view.equals(rl_couch_two_bottom)) {
            LaunchActivity.mPager.setCurrentItem(2, true);
        } else if (view.equals(rl_couch_two_top)) {
            LaunchActivity.mPager.setCurrentItem(2, true);
        } else if (view.equals(rl_couch_two_exit)) {
            LaunchActivity.rl_pager.setVisibility(View.GONE);
            ((LaunchActivity) getActivity()).showDialogInfo();
            LaunchActivity.fromFirstLaunch++;
        }
    }
}

