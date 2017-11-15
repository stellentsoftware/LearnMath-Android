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
public class CoachMarkerFour extends android.support.v4.app.Fragment implements View.OnClickListener {

    View view;
    RelativeLayout couch_mark_four_left, couch_mark_four_right, couch_mark_four_exit;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = (ViewGroup) inflater
                .inflate(R.layout.coach_mark_four, container, false);

        couch_mark_four_left = (RelativeLayout) view.findViewById(R.id.couch_mark_four_left);
        couch_mark_four_right = (RelativeLayout) view.findViewById(R.id.couch_mark_four_right);
        couch_mark_four_exit = (RelativeLayout) view.findViewById(R.id.couch_mark_four_exit);
        couch_mark_four_exit.setOnClickListener(this);
        couch_mark_four_left.setOnClickListener(this);
        couch_mark_four_right.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        //onclicks for coach marks
        if (v.equals(couch_mark_four_exit)) {
            LaunchActivity.rl_pager.setVisibility(View.GONE);
            ((LaunchActivity) getActivity()).showDialogInfo();
            LaunchActivity.fromFirstLaunch++;
        } else if (v.equals(couch_mark_four_left)) {
            LaunchActivity.rl_pager.setVisibility(View.GONE);
            ((LaunchActivity) getActivity()).showDialogInfo();
            LaunchActivity.fromFirstLaunch++;
        } else if (v.equals(couch_mark_four_right)) {
            LaunchActivity.rl_pager.setVisibility(View.GONE);
            ((LaunchActivity) getActivity()).showDialogInfo();
            LaunchActivity.fromFirstLaunch++;
        }
    }
}
