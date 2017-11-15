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
public class CoachMarkerOne extends android.support.v4.app.Fragment {

    View view;
    RelativeLayout rl_couch_one, rl_couch_one_exit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = (ViewGroup) inflater
                .inflate(R.layout.coach_mark_one, container, false);
        rl_couch_one = (RelativeLayout) view.findViewById(R.id.rl_couch_one);
        rl_couch_one_exit = (RelativeLayout) view.findViewById(R.id.rl_couch_one_exit);
        rl_couch_one_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LaunchActivity.rl_pager.setVisibility(View.GONE);
                LaunchActivity.fromFirstLaunch++;
                ((LaunchActivity) getActivity()).showDialogInfo();
            }
        });
        rl_couch_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LaunchActivity.mPager.setCurrentItem(1, true);
            }
        });
        return view;
    }
}
