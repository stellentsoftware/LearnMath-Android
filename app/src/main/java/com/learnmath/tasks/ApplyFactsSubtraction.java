package com.learnmath.Tasks;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.learnmath.R;
import com.learnmath.Fragments.ApplyMath;
import com.learnmath.Utils.FontChange;
import com.learnmath.Utils.Util;

import java.util.Random;

public class ApplyFactsSubtraction {
    public int mfirstRanNumSub, msecondRanNumSub, mthirdRanNumSub, mfourthRanNumSub, mfifthRanNumSub, msixthRanNumSub;
    public  boolean regroup = false, regroupFour = false;
      Util util=new Util();
    private RelativeLayout rl_panda;
    public TextView tv_regroup, txt_number_bellow_three_sub, txt_number_bellow_four_sub, txt_pandatext, txt_number_up_four_sub, txt_number_up_three_sub, txt_number_up_two_sub, txt_number_up_one_sub, txt_number_bellow_two_sub, txt_number_bellow_one_sub, txt_borrow_four_sub, txt_borrow_three_sub, txt_borrow_two_sub, txt_borrow_one_sub, txt_result_four_sub, txt_result_three_sub, txt_result_two_sub, txt_result_one_sub;
    public TextView  txt_regroup_lable_three, txt_regroup_lable_two, txt_regroup_lable_one;
    public int funCase = 0;
    ImageView img_panda;
    public Context context;
    FontChange mfont = new FontChange();

    //Constructor to get views
    public ApplyFactsSubtraction(Context context) {
        this.context = context;
        //Text view subtraction
        txt_number_up_one_sub = (TextView) ((Activity) context).findViewById(R.id.txt_number_up_one_sub);
        txt_number_up_two_sub = (TextView) ((Activity) context).findViewById(R.id.txt_number_up_two_sub);
        txt_number_up_three_sub = (TextView) ((Activity) context).findViewById(R.id.txt_number_up_three_sub);
        txt_number_up_four_sub = (TextView) ((Activity) context).findViewById(R.id.txt_number_up_four_sub);
        txt_number_bellow_one_sub = (TextView) ((Activity) context).findViewById(R.id.txt_number_bellow_one_sub);
        txt_number_bellow_two_sub = (TextView) ((Activity) context).findViewById(R.id.txt_number_bellow_two_sub);
        txt_number_bellow_three_sub = (TextView) ((Activity) context).findViewById(R.id.txt_number_bellow_three_sub);
        txt_number_bellow_four_sub = (TextView) ((Activity) context).findViewById(R.id.txt_number_bellow_four_sub);
        txt_borrow_one_sub = (TextView) ((Activity) context).findViewById(R.id.txt_borrow_one_sub);
        txt_borrow_two_sub = (TextView) ((Activity) context).findViewById(R.id.txt_borrow_two_sub);
        txt_borrow_three_sub = (TextView) ((Activity) context).findViewById(R.id.txt_borrow_three_sub);
        txt_borrow_four_sub = (TextView) ((Activity) context).findViewById(R.id.txt_borrow_four_sub);
        txt_result_four_sub = (TextView) ((Activity) context).findViewById(R.id.txt_result_four_sub);
        txt_result_three_sub = (TextView) ((Activity) context).findViewById(R.id.txt_result_three_sub);
        txt_result_two_sub = (TextView) ((Activity) context).findViewById(R.id.txt_result_two_sub);
        txt_result_one_sub = (TextView) ((Activity) context).findViewById(R.id.txt_result_one_sub);
        tv_regroup = (TextView) ((Activity) context).findViewById(R.id.tv_regroup);
        txt_regroup_lable_three = (TextView) ((Activity) context).findViewById(R.id.txt_regroup_lable_three);
        txt_regroup_lable_two = (TextView) ((Activity) context).findViewById(R.id.txt_regroup_lable_two);
        txt_regroup_lable_one = (TextView) ((Activity) context).findViewById(R.id.txt_regroup_lable_one);
        //For panda
        txt_pandatext = (TextView) ((Activity) context).findViewById(R.id.txt_pandatext);
        img_panda = (ImageView) ((Activity) context).findViewById(R.id.img_panda);
        rl_panda = (RelativeLayout) ((Activity) context).findViewById(R.id.rl_panda);
        //Setting the font style for the textviews
        setFontStyle();

    }
    //Setting the font style for the textviews
    private void setFontStyle() {
        mfont.fontChange(txt_number_up_one_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_number_up_two_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_number_up_three_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_number_up_four_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_number_bellow_one_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_number_bellow_two_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_number_bellow_three_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_number_bellow_four_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_borrow_one_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_borrow_two_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_borrow_three_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_borrow_four_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_result_four_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_result_three_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_result_two_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_result_one_sub, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(tv_regroup, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_regroup_lable_three, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_regroup_lable_two, "fonts/textFont.ttf", ((Activity) context));
        mfont.fontChange(txt_regroup_lable_one, "fonts/textFont.ttf", ((Activity) context));

    }

    //For generating random number for all fields
    public void generateRandomApplySub() {
        if (ApplyMath.fromFirst) {
            ApplyMath.fromFirst = false;
            ApplyMath.countForPanda = 0;
        } else {
            ApplyMath.countForPanda++;
        }
        //Calling the panda for displaying the image
        if (ApplyMath.countForPanda == 5) {
            displayingPanda();
        }
        regroup = false;
        regroupFour = false;
        //Empty the views before setting the value
        txt_number_up_one_sub.setText("");
        txt_number_up_two_sub.setText("");
        txt_number_up_three_sub.setText("");
        txt_number_up_four_sub.setText("");
        txt_number_bellow_two_sub.setText("");
        txt_number_bellow_one_sub.setText("");
        txt_borrow_one_sub.setText("");
        txt_borrow_two_sub.setText("");
        txt_borrow_three_sub.setText("");
        txt_borrow_four_sub.setText("");
        txt_result_one_sub.setText("");
        txt_result_two_sub.setText("");
        txt_result_three_sub.setText("");
        txt_result_four_sub.setText("");
        txt_regroup_lable_three.setVisibility(View.GONE);
        txt_regroup_lable_two.setVisibility(View.GONE);
        txt_regroup_lable_one.setVisibility(View.GONE);
        //Switch for levels
        switch (ApplyMath.levelChange) {
            //Level one random generator
            case 1:
                txt_number_bellow_four_sub.setVisibility(View.GONE);
                txt_number_bellow_three_sub.setVisibility(View.VISIBLE);
                Random r1 = new Random();
                mfifthRanNumSub = r1.nextInt(9 - 1 + 1) + 1;
                mfirstRanNumSub = r1.nextInt(9 - mfifthRanNumSub + 1) + mfifthRanNumSub;
                //Setting the random number
                txt_number_up_one_sub.setText(String.valueOf(mfirstRanNumSub));
                txt_number_bellow_one_sub.setText(String.valueOf(mfifthRanNumSub));
                break;
            //Level two random generator
            case 2:
                //Top row
                txt_number_bellow_four_sub.setVisibility(View.GONE);
                txt_number_bellow_three_sub.setVisibility(View.VISIBLE);
                Random r2 = new Random();
                mfifthRanNumSub = r2.nextInt(9 - 1 + 1) + 1;
                mfirstRanNumSub = r2.nextInt(9 - mfifthRanNumSub + 1) + mfifthRanNumSub;
                msecondRanNumSub = r2.nextInt(9 - 1 + 1) + 1;
                //Setting the random number
                txt_number_up_one_sub.setText(String.valueOf(mfirstRanNumSub));
                txt_number_up_two_sub.setText(String.valueOf(msecondRanNumSub));
                txt_number_bellow_one_sub.setText(String.valueOf(mfifthRanNumSub));
                break;
            //Level three random generator
            case 3:
                //Top row
                txt_number_bellow_four_sub.setVisibility(View.VISIBLE);
                txt_number_bellow_three_sub.setVisibility(View.GONE);
                //Empty the views before setting the value
                mfirstRanNumSub = genarateRandom(0, 9);
                msecondRanNumSub = genarateRandom(0, 9);
                mthirdRanNumSub = genarateRandom(1, 9);
                //Bottom row
                mfifthRanNumSub = genarateRandom(0, 9);
                msixthRanNumSub = genarateRandom(1, 9);
                //For switch case in third level functionality
                if (mfirstRanNumSub >= mfifthRanNumSub && msecondRanNumSub >= msixthRanNumSub) {
                    funCase = 1;
                } else if (mfirstRanNumSub < mfifthRanNumSub && msecondRanNumSub >= msixthRanNumSub) {
                    funCase = 2;
                } else if (mfirstRanNumSub >= mfifthRanNumSub && msecondRanNumSub < msixthRanNumSub) {
                    funCase = 3;
                } else if (mfirstRanNumSub < mfifthRanNumSub && msecondRanNumSub < msixthRanNumSub) {
                    funCase = 4;
                }
                //Setting the random number
                txt_number_up_one_sub.setText(String.valueOf(mfirstRanNumSub));
                txt_number_up_two_sub.setText(String.valueOf(msecondRanNumSub));
                txt_number_up_three_sub.setText(String.valueOf(mthirdRanNumSub));
                txt_number_bellow_one_sub.setText(String.valueOf(mfifthRanNumSub));
                txt_number_bellow_two_sub.setText(String.valueOf(msixthRanNumSub));
                break;
            //Level four random generator
            case 4:
                //Top row
                txt_number_bellow_four_sub.setVisibility(View.VISIBLE);
                txt_number_bellow_three_sub.setVisibility(View.GONE);
                mfirstRanNumSub = genarateRandom(0, 9);
                msecondRanNumSub = genarateRandom(0, 9);
                mthirdRanNumSub = genarateRandom(0, 9);
                mfourthRanNumSub = genarateRandom(1, 9);
                //Bottom row
                mfifthRanNumSub = genarateRandom(0, 9);
                msixthRanNumSub = genarateRandom(1, 9);
                //Setting the random number
                txt_number_up_one_sub.setText(String.valueOf(mfirstRanNumSub));
                txt_number_up_two_sub.setText(String.valueOf(msecondRanNumSub));
                txt_number_up_three_sub.setText(String.valueOf(mthirdRanNumSub));
                txt_number_up_four_sub.setText(String.valueOf(mfourthRanNumSub));
                txt_number_bellow_one_sub.setText(String.valueOf(mfifthRanNumSub));
                txt_number_bellow_two_sub.setText(String.valueOf(msixthRanNumSub));
                //For switch case in fourth level functionality
                if (mfirstRanNumSub >= mfifthRanNumSub && msecondRanNumSub >= msixthRanNumSub) {
                    funCase = 1;
                } else if (mfirstRanNumSub < mfifthRanNumSub && msecondRanNumSub >= msixthRanNumSub) {
                    funCase = 2;
                } else if (mfirstRanNumSub >= mfifthRanNumSub && msecondRanNumSub < msixthRanNumSub) {
                    funCase = 3;
                } else if (mfirstRanNumSub < mfifthRanNumSub && msecondRanNumSub < msixthRanNumSub) {
                    funCase = 4;
                }
                break;
        }
    }

    //Functionality for subtraction
    public void functionalityforSub(String keyNum) {
        switch (ApplyMath.levelChange) {
            case 1:
                onedigitsSub(keyNum);
                break;
            case 2:
                twodigitsSub(keyNum);
                break;
            case 3:
                threedigitsSub(keyNum);
                break;
            case 4:
                fourdigitsSub(keyNum);
                break;
        }
    }

    //Generate random numbers between points
    public int genarateRandom(int min, int max) {
        Random r = new Random();
        int ranNum = r.nextInt(max - min + 1) + min;
        return ranNum;
    }

    //Subtraction functionality level1
    public void onedigitsSub(String keyNum) {
        if (txt_result_one_sub.getText().toString().equals("")) {
            if (keyNum.equals(String.valueOf(mfirstRanNumSub - mfifthRanNumSub))) {
                txt_result_one_sub.setText(keyNum);
                util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                handlerForGenarateRandom();
            } else {
                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
            }
        }
    }

    //Subtraction functionality level2
    public void twodigitsSub(String keyNum) {
        if (txt_result_one_sub.getText().toString().equals("")) {
            if (keyNum.equals(String.valueOf(mfirstRanNumSub - mfifthRanNumSub))) {
                txt_result_one_sub.setText(keyNum);
                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
            } else {
                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
            }
        } else if (txt_result_two_sub.getText().toString().equals("")) {

            if (keyNum.equals(String.valueOf(msecondRanNumSub))) {
                txt_result_two_sub.setText(keyNum);
                util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                handlerForGenarateRandom();
            } else {
                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
            }

        }
    }

    //Subtraction functionality level 3
    public void threedigitsSub(String keyNum) {
        //        case 1
        switch (funCase) {
            //Case1: if minuend digit 0  and digit 1 and digit one are greater than subtrahend
            case 1:
                if (txt_result_one_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(mfirstRanNumSub - mfifthRanNumSub))) {
                        txt_result_one_sub.setText(keyNum);
                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                } else if (txt_result_two_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(msecondRanNumSub - msixthRanNumSub))) {
                        txt_result_two_sub.setText(keyNum);
                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                } else if (txt_result_three_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(mthirdRanNumSub))) {
                        txt_result_three_sub.setText(keyNum);
                        util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                        handlerForGenarateRandom();
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                } else {
                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                }
                break;
            //Case 2 if minuend digit 0  less than subtrahend digit 0 and digit 1 and digit one are greater than subtrahend digit 1
            case 2:
                if (txt_result_one_sub.getText().toString().equals("")) {
                    if (keyNum.equals("Regroup") && !regroup) {
                        regroup = true;
                        txt_regroup_lable_one.setVisibility(View.VISIBLE);
                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                    } else if (regroup) {
                        if (txt_borrow_two_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(msecondRanNumSub - 1))) {
                                txt_borrow_two_sub.setText(keyNum);
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else if (txt_borrow_one_sub.getText().toString().equals("")) {
                            if (keyNum.equals("1")) {
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                txt_borrow_one_sub.setText(keyNum);
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else if (txt_borrow_one_sub.getText().toString().equals("1")) {
                            if (keyNum.equals(String.valueOf(mfirstRanNumSub))) {
                                String concat = "1" + keyNum;
                                txt_borrow_one_sub.setText(concat);
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else if (txt_result_one_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_one_sub.getText().toString()) - mfifthRanNumSub))) {
                                txt_result_one_sub.setText(keyNum);
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                } else if (txt_result_two_sub.getText().toString().equals("")) {

                    if (txt_borrow_two_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(msecondRanNumSub - msixthRanNumSub))) {
                            txt_result_two_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else if (Integer.parseInt(txt_borrow_two_sub.getText().toString()) >= msixthRanNumSub) {
                        if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - msixthRanNumSub))) {
                            txt_result_two_sub.setText(keyNum);
                            if (txt_borrow_three_sub.getText().toString().equals("0")) {
                                util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                                handlerForGenarateRandom();
                            } else {
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else if (Integer.parseInt(txt_borrow_two_sub.getText().toString()) < msixthRanNumSub) {
                        if (regroup) {
                            if (keyNum.equals("Regroup") && regroup) {
                                regroup = false;
                                txt_regroup_lable_two.setVisibility(View.VISIBLE);
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else {
                            if (txt_borrow_three_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(mthirdRanNumSub - 1))) {
                                    txt_borrow_three_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (!regroup) {
                                if (keyNum.equals("1")) {
                                    String concat = keyNum + txt_borrow_two_sub.getText().toString();
                                    txt_borrow_two_sub.setText(concat);
                                    regroup = true;
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (regroup) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - msixthRanNumSub))) {
                                    txt_result_two_sub.setText(keyNum);
                                    if (txt_borrow_three_sub.getText().toString().equals("0")) {
                                        util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                                        handlerForGenarateRandom();
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    }
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        }
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                } else if (txt_result_three_sub.getText().toString().equals("")) {
                    if (txt_borrow_three_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(mthirdRanNumSub))) {
                            txt_result_three_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                            handlerForGenarateRandom();
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else {
                        if (keyNum.equals(String.valueOf(txt_borrow_three_sub.getText().toString())) && !txt_borrow_three_sub.getText().toString().equals("0")) {
                            txt_result_three_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                            handlerForGenarateRandom();
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    }
                } else {
                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                }
                break;
            //Case 3 if minuend digit 0 greater than subtrahend digit 0 and digit 1 and digit one are less than subtrahend digit 1
            case 3:
                if (txt_result_one_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(mfirstRanNumSub - mfifthRanNumSub))) {
                        txt_result_one_sub.setText(keyNum);
                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                } else if (txt_result_two_sub.getText().toString().equals("")) {
                    if (keyNum.equals("Regroup") && !regroup) {
                        regroup = true;
                        txt_regroup_lable_one.setVisibility(View.VISIBLE);
                        txt_regroup_lable_two.setVisibility(View.VISIBLE);
                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                    } else if (regroup) {
                        if (txt_borrow_three_sub.getText().toString().trim().equals("")) {
                            if (keyNum.equals(String.valueOf(mthirdRanNumSub - 1))) {
                                txt_borrow_three_sub.setText(keyNum);
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else if (txt_borrow_two_sub.getText().toString().trim().equals("")) {
                            if (keyNum.equals("1")) {
                                txt_borrow_two_sub.setText(keyNum);
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else if (txt_borrow_two_sub.getText().toString().trim().equals("1")) {
                            if (keyNum.equals(String.valueOf(msecondRanNumSub))) {
                                String concat = "1" + keyNum;
                                txt_borrow_two_sub.setText(concat);
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else if (txt_result_two_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - msixthRanNumSub))) {
                                txt_result_two_sub.setText(keyNum);
                                if (txt_borrow_three_sub.getText().toString().equals("0")) {
                                    util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                                    handlerForGenarateRandom();
                                } else {
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                }
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        }
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                } else if (txt_result_three_sub.getText().toString().equals("")) {

                    if (txt_borrow_three_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(mthirdRanNumSub))) {
                            txt_result_three_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                            handlerForGenarateRandom();
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else {
                        if (keyNum.equals(String.valueOf(txt_borrow_three_sub.getText().toString())) && !txt_borrow_three_sub.getText().toString().equals("0")) {
                            txt_result_three_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                            handlerForGenarateRandom();
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    }
                } else {
                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                }
                break;
            //Case 4 if minuend digit 0 less than subtrahend digit 0 and minuend digit 1 and digit one are less than subtrahend digit 1
            case 4:
                
                if (msecondRanNumSub == 0) {
                    if (txt_result_one_sub.getText().toString().equals("")) {
                        if (keyNum.equals("Regroup") && !regroup) {
                            regroup = true;
                            txt_regroup_lable_one.setVisibility(View.VISIBLE);
                            txt_regroup_lable_two.setVisibility(View.VISIBLE);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        } else if (regroup) {

                            if (txt_borrow_three_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(mthirdRanNumSub - 1))) {
                                    txt_borrow_three_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_two_sub.getText().toString().equals("")) {
                                if (keyNum.equals("9")) {
                                    txt_borrow_two_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals("1")) {
                                    txt_borrow_one_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("1")) {
                                if (keyNum.equals(String.valueOf(mfirstRanNumSub))) {
                                    String concat = "1" + keyNum;
                                    txt_borrow_one_sub.setText(concat);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_result_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_one_sub.getText().toString()) - mfifthRanNumSub))) {
                                    txt_result_one_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else if (txt_result_two_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - msixthRanNumSub))) {
                            txt_result_two_sub.setText(keyNum);
                            if (txt_borrow_three_sub.getText().toString().equals("0")) {
                                util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                                handlerForGenarateRandom();
                            } else {
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }

                    } else if (txt_result_three_sub.getText().toString().equals("")) {

                        if (keyNum.equals(txt_borrow_three_sub.getText().toString()) && !txt_borrow_three_sub.getText().toString().equals("0")) {
                            txt_result_three_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                            handlerForGenarateRandom();
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    }
                } else {
                    if (txt_result_one_sub.getText().toString().equals("")) {
                        if (keyNum.equals("Regroup") && !regroup) {
                            regroup = true;
                            txt_regroup_lable_one.setVisibility(View.VISIBLE);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        } else if (regroup) {
                            if (txt_borrow_two_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(msecondRanNumSub - 1))) {
                                    txt_borrow_two_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals("1")) {
                                    txt_borrow_one_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("1")) {
                                if (keyNum.equals(String.valueOf(mfirstRanNumSub))) {
                                    String concat = "1" + keyNum;
                                    txt_borrow_one_sub.setText(concat);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_result_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_one_sub.getText().toString()) - mfifthRanNumSub))) {
                                    txt_result_one_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else if (txt_result_two_sub.getText().toString().equals("")) {
                        if (!regroupFour) {
                            if (keyNum.equals("Regroup") && regroup) {
                                regroup = false;
                                regroupFour = true;
                                txt_regroup_lable_two.setVisibility(View.VISIBLE);
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else if (regroupFour) {
                            if (txt_borrow_three_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(mthirdRanNumSub - 1))) {
                                    txt_borrow_three_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (!regroup) {
                                if (keyNum.equals("1")) {
                                    String concat = keyNum + txt_borrow_two_sub.getText().toString();
                                    txt_borrow_two_sub.setText(concat);
                                    regroup = true;
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (regroup) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - msixthRanNumSub))) {
                                    txt_result_two_sub.setText(keyNum);
                                    if (txt_borrow_three_sub.getText().toString().equals("0")) {
                                        util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                                        handlerForGenarateRandom();
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    }
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else if (txt_result_three_sub.getText().toString().equals("")) {
                        if (txt_borrow_three_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(mthirdRanNumSub))) {
                                txt_result_three_sub.setText(keyNum);
                                util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                                handlerForGenarateRandom();
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else {
                            if (keyNum.equals(String.valueOf(txt_borrow_three_sub.getText().toString())) && !txt_borrow_three_sub.getText().toString().equals("0")) {
                                util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                                txt_result_three_sub.setText(keyNum);
                                handlerForGenarateRandom();
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        }
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                }
                break;
        }
    }

    //Subtraction functionality level 4
    public void fourdigitsSub(String keyNum) {
        switch (funCase) {
            //Case1: if minuend digit 0  and digit 1 and digit one are greater than subtrahend
            case 1:
                if (txt_result_one_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(mfirstRanNumSub - mfifthRanNumSub))) {
                        txt_result_one_sub.setText(keyNum);
                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                } else if (txt_result_two_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(msecondRanNumSub - msixthRanNumSub))) {
                        txt_result_two_sub.setText(keyNum);
                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                } else if (txt_result_three_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(mthirdRanNumSub))) {
                        txt_result_three_sub.setText(keyNum);
                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                } else if (txt_result_four_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(mfourthRanNumSub))) {
                        txt_result_four_sub.setText(keyNum);
                        util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                        handlerForGenarateRandom();
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                } else {
                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                }
                break;
            //Case 2 if minuend digit 0  less than subtrahend digit 0 and digit 1 and digit one are greater than subtrahend digit 1
            case 2:
                if (txt_result_one_sub.getText().toString().equals("")) {
                    if (keyNum.equals("Regroup") && !regroup) {
                        regroup = true;
                        txt_regroup_lable_one.setVisibility(View.VISIBLE);
                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                    } else if (regroup) {
                        if (txt_borrow_two_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(msecondRanNumSub - 1))) {
                                txt_borrow_two_sub.setText(keyNum);
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else if (txt_borrow_one_sub.getText().toString().equals("")) {
                            if (keyNum.equals("1")) {
                                txt_borrow_one_sub.setText(keyNum);
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else if (txt_borrow_one_sub.getText().toString().equals("1")) {
                            if (keyNum.equals(String.valueOf(mfirstRanNumSub))) {
                                String concat = "1" + keyNum;
                                txt_borrow_one_sub.setText(concat);
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else if (txt_result_one_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_one_sub.getText().toString()) - mfifthRanNumSub))) {
                                txt_result_one_sub.setText(keyNum);
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                } else if (txt_result_two_sub.getText().toString().equals("")) {

                    if (txt_borrow_two_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(msecondRanNumSub - msixthRanNumSub))) {
                            txt_result_two_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else if (Integer.parseInt(txt_borrow_two_sub.getText().toString()) >= msixthRanNumSub) {
                        if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - msixthRanNumSub))) {
                            txt_result_two_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else if (Integer.parseInt(txt_borrow_two_sub.getText().toString()) < msixthRanNumSub) {
                        if (regroup) {
                            if (keyNum.equals("Regroup") && regroup) {
                                if (txt_number_up_three_sub.getText().toString().equals("0")) {
                                    regroup = false;
                                    txt_regroup_lable_two.setVisibility(View.VISIBLE);
                                    txt_regroup_lable_three.setVisibility(View.VISIBLE);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    regroup = false;
                                    txt_regroup_lable_two.setVisibility(View.VISIBLE);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                }
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else {
                            if (txt_number_up_three_sub.getText().toString().equals("0")) {
                                if (txt_borrow_four_sub.getText().toString().equals("")) {
                                    if (keyNum.equals(String.valueOf(mfourthRanNumSub - 1))) {
                                        txt_borrow_four_sub.setText(keyNum);
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                    }
                                } else if (txt_borrow_three_sub.getText().toString().equals("")) {
                                    if (keyNum.equals("9")) {
                                        txt_borrow_three_sub.setText(keyNum);
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                    }
                                } else if (!regroup) {
                                    if (keyNum.equals("1")) {
                                        String concat = keyNum + String.valueOf(txt_borrow_two_sub.getText().toString());
                                        txt_borrow_two_sub.setText(concat);
                                        regroup = true;
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                    }
                                } else if (regroup) {

                                    if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - msixthRanNumSub))) {
                                        txt_result_two_sub.setText(keyNum);
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                    }
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else {
                                if (txt_borrow_three_sub.getText().toString().equals("")) {
                                    if (keyNum.equals(String.valueOf(mthirdRanNumSub - 1))) {
                                        txt_borrow_three_sub.setText(keyNum);
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                    }
                                } else if (!regroup) {
                                    if (keyNum.equals("1")) {
                                        String concat = keyNum + txt_borrow_two_sub.getText().toString();
                                        txt_borrow_two_sub.setText(concat);
                                        regroup = true;
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                    }
                                } else if (regroup) {
                                    if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - msixthRanNumSub))) {
                                        txt_result_two_sub.setText(keyNum);
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                    }
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            }
                        }
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                } else if (txt_result_three_sub.getText().toString().equals("")) {
                    if (txt_borrow_three_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(mthirdRanNumSub))) {
                            txt_result_three_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else {
                        if (keyNum.equals(String.valueOf(txt_borrow_three_sub.getText().toString()))) {
                            txt_result_three_sub.setText(keyNum);
                            if (txt_borrow_four_sub.getText().toString().equals("0")) {
                                util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                                handlerForGenarateRandom();

                            } else {
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    }
                } else if (txt_result_four_sub.getText().toString().equals("") && !txt_borrow_four_sub.getText().toString().equals("0")) {

                    if (txt_borrow_four_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(mfourthRanNumSub))) {
                            txt_result_four_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                            handlerForGenarateRandom();
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else {
                        if (keyNum.equals(String.valueOf(txt_borrow_four_sub.getText().toString()))) {
                            txt_result_four_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                            handlerForGenarateRandom();
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    }
                } else {
                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                }
                break;
            //Case 3 if minuend digit 0 greater than subtrahend digit 0 and digit 1 and digit one are less than subtrahend digit 1
            case 3:
                if (txt_result_one_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(mfirstRanNumSub - mfifthRanNumSub))) {
                        txt_result_one_sub.setText(keyNum);
                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                } else if (txt_result_two_sub.getText().toString().equals("")) {
                    if (keyNum.equals("Regroup") && !regroup) {
                        if (txt_number_up_three_sub.getText().toString().equals("0")) {
                            regroup = true;
                            txt_regroup_lable_one.setVisibility(View.VISIBLE);
                            txt_regroup_lable_two.setVisibility(View.VISIBLE);
                            txt_regroup_lable_three.setVisibility(View.VISIBLE);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        } else {
                            regroup = true;
                            txt_regroup_lable_one.setVisibility(View.VISIBLE);
                            txt_regroup_lable_two.setVisibility(View.VISIBLE);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        }
                    } else if (regroup) {
                        if (txt_number_up_three_sub.getText().toString().equals("0")) {
                            if (txt_borrow_four_sub.getText().toString().trim().equals("")) {
                                if (keyNum.equals(String.valueOf(mfourthRanNumSub - 1))) {
                                    txt_borrow_four_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_three_sub.getText().toString().trim().equals("")) {
                                if (keyNum.equals("9")) {
                                    txt_borrow_three_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_two_sub.getText().toString().trim().equals("")) {
                                if (keyNum.equals("1")) {
                                    txt_borrow_two_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_two_sub.getText().toString().trim().equals("1")) {
                                if (keyNum.equals(String.valueOf(msecondRanNumSub))) {
                                    String concat = "1" + keyNum;
                                    txt_borrow_two_sub.setText(concat);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_result_two_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - msixthRanNumSub))) {
                                    txt_result_two_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }

                        } else {
                            if (txt_borrow_three_sub.getText().toString().trim().equals("")) {
                                if (keyNum.equals(String.valueOf(mthirdRanNumSub - 1))) {
                                    txt_borrow_three_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_two_sub.getText().toString().trim().equals("")) {
                                if (keyNum.equals("1")) {
                                    txt_borrow_two_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_two_sub.getText().toString().trim().equals("1")) {
                                if (keyNum.equals(String.valueOf(msecondRanNumSub))) {
                                    String concat = "1" + keyNum;
                                    txt_borrow_two_sub.setText(concat);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_result_two_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - msixthRanNumSub))) {
                                    txt_result_two_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            }
                        }
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                } else if (txt_result_three_sub.getText().toString().equals("")) {
                    if (txt_borrow_three_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(mthirdRanNumSub))) {
                            txt_result_three_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else {
                        if (keyNum.equals(String.valueOf(txt_borrow_three_sub.getText().toString()))) {

                            txt_result_three_sub.setText(keyNum);
                            if (txt_borrow_four_sub.getText().toString().equals("0")) {
                                util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                                handlerForGenarateRandom();
                            } else {
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    }
                } else if (txt_result_four_sub.getText().toString().equals("") && !txt_borrow_four_sub.getText().toString().equals("0")) {

                    if (txt_borrow_four_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(mfourthRanNumSub))) {
                            txt_result_four_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                            handlerForGenarateRandom();
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else {
                        if (keyNum.equals(String.valueOf(txt_borrow_four_sub.getText().toString()))) {
                            txt_result_four_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                            handlerForGenarateRandom();
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    }
                } else {
                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                }
                break;
            //Case 4 if minuend digit 0 less than subtrahend digit 0 and minuend digit 1 and digit one are less than subtrahend digit 1
            case 4:
                if (msecondRanNumSub == 0 && mthirdRanNumSub == 0) {
                    if (txt_result_one_sub.getText().toString().equals("")) {
                        if (keyNum.equals("Regroup") && !regroup) {
                            regroup = true;
                            txt_regroup_lable_one.setVisibility(View.VISIBLE);
                            txt_regroup_lable_two.setVisibility(View.VISIBLE);
                            txt_regroup_lable_three.setVisibility(View.VISIBLE);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        } else if (regroup) {
                            if (txt_borrow_four_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(mfourthRanNumSub - 1))) {
                                    txt_borrow_four_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_three_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf("9"))) {
                                    txt_borrow_three_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_two_sub.getText().toString().equals("")) {
                                if (keyNum.equals("9")) {
                                    txt_borrow_two_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals("1")) {
                                    txt_borrow_one_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("1")) {
                                if (keyNum.equals(String.valueOf(mfirstRanNumSub))) {
                                    String concat = "1" + keyNum;
                                    txt_borrow_one_sub.setText(concat);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_result_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_one_sub.getText().toString()) - mfifthRanNumSub))) {
                                    txt_result_one_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);

                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else if (txt_result_two_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - msixthRanNumSub))) {
                            txt_result_two_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else if (txt_result_three_sub.getText().toString().equals("")) {
                        if (keyNum.equals(txt_borrow_three_sub.getText().toString())) {

                            txt_result_three_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else if (txt_result_four_sub.getText().toString().equals("")) {
                        if (keyNum.equals(txt_borrow_four_sub.getText().toString())) {
                            txt_result_four_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                            handlerForGenarateRandom();
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                }
                //Case 2
                else if (msecondRanNumSub == 0) {
                    if (txt_result_one_sub.getText().toString().equals("")) {
                        if (keyNum.equals("Regroup") && !regroup) {
                            regroup = true;
                            txt_regroup_lable_one.setVisibility(View.VISIBLE);
                            txt_regroup_lable_two.setVisibility(View.VISIBLE);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        } else if (regroup) {
                            if (txt_borrow_three_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(mthirdRanNumSub - 1))) {
                                    txt_borrow_three_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_two_sub.getText().toString().equals("")) {
                                if (keyNum.equals("9")) {
                                    txt_borrow_two_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals("1")) {
                                    txt_borrow_one_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("1")) {
                                if (keyNum.equals(String.valueOf(mfirstRanNumSub))) {
                                    String concat = "1" + keyNum;
                                    txt_borrow_one_sub.setText(concat);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_result_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_one_sub.getText().toString()) - mfifthRanNumSub))) {
                                    txt_result_one_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else if (txt_result_two_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - msixthRanNumSub))) {
                            txt_result_two_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else if (txt_result_three_sub.getText().toString().equals("")) {
                        if (keyNum.equals(txt_borrow_three_sub.getText().toString())) {
                            txt_result_three_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else if (txt_result_four_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(mfourthRanNumSub))) {
                            txt_result_four_sub.setText(keyNum);
                            util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                            handlerForGenarateRandom();
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                }
                //   Case 3
                else {
                    if (txt_result_one_sub.getText().toString().equals("")) {
                        if (keyNum.equals("Regroup") && !regroup) {
                            regroup = true;
                            txt_regroup_lable_one.setVisibility(View.VISIBLE);
                            util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                        } else if (regroup) {
                            if (txt_borrow_two_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(msecondRanNumSub - 1))) {
                                    txt_borrow_two_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals("1")) {
                                    txt_borrow_one_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);

                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("1")) {
                                if (keyNum.equals(String.valueOf(mfirstRanNumSub))) {
                                    String concat = "1" + keyNum;
                                    txt_borrow_one_sub.setText(concat);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else if (txt_result_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_one_sub.getText().toString()) - mfifthRanNumSub))) {
                                    txt_result_one_sub.setText(keyNum);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else if (txt_result_two_sub.getText().toString().equals("")) {
                        if (!regroupFour) {
                            if (keyNum.equals("Regroup") && regroup) {
                                if (txt_number_up_three_sub.getText().toString().equals("0")) {
                                    regroup = false;
                                    regroupFour = true;
                                    txt_regroup_lable_two.setVisibility(View.VISIBLE);
                                    txt_regroup_lable_three.setVisibility(View.VISIBLE);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                } else {
                                    regroup = false;
                                    regroupFour = true;
                                    txt_regroup_lable_two.setVisibility(View.VISIBLE);
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                }
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else if (regroupFour) {

                            if (txt_number_up_three_sub.getText().toString().equals("0")) {
                                if (txt_borrow_four_sub.getText().toString().equals("")) {
                                    if (keyNum.equals(String.valueOf(mfourthRanNumSub - 1))) {
                                        txt_borrow_four_sub.setText(keyNum);
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                    }
                                } else if (txt_borrow_three_sub.getText().toString().equals("")) {
                                    if (keyNum.equals("9")) {
                                        txt_borrow_three_sub.setText(keyNum);
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                    }
                                } else if (!regroup) {
                                    if (keyNum.equals("1")) {
                                        String concat = keyNum + String.valueOf(txt_borrow_two_sub.getText().toString());
                                        txt_borrow_two_sub.setText(concat);
                                        regroup = true;
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                    }
                                } else if (regroup) {
                                    if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - msixthRanNumSub))) {
                                        txt_result_two_sub.setText(keyNum);
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                    }
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            } else {
                                if (txt_borrow_three_sub.getText().toString().equals("")) {
                                    if (keyNum.equals(String.valueOf(mthirdRanNumSub - 1))) {
                                        txt_borrow_three_sub.setText(keyNum);
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                    }
                                } else if (!regroup) {
                                    if (keyNum.equals("1")) {
                                        String concat = keyNum + txt_borrow_two_sub.getText().toString();
                                        txt_borrow_two_sub.setText(concat);
                                        regroup = true;
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                    }
                                } else if (regroup) {
                                    if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - msixthRanNumSub))) {
                                        txt_result_two_sub.setText(keyNum);
                                        util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                    } else {
                                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                    }
                                } else {
                                    util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                                }
                            }
                        } else {
                            util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                        }
                    } else if (txt_result_three_sub.getText().toString().equals("")) {
                        if (txt_borrow_three_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(mthirdRanNumSub))) {
                                txt_result_three_sub.setText(keyNum);
                                util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else {
                            if (keyNum.equals(String.valueOf(txt_borrow_three_sub.getText().toString()))) {
                                txt_result_three_sub.setText(keyNum);
                                if (txt_borrow_four_sub.getText().toString().equals("0")) {
                                    util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                                    handlerForGenarateRandom();
                                } else {
                                    util.mediaService(((Activity) context),R.raw.yes,ApplyMath.soundShare);
                                }
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        }
                    } else if (txt_result_four_sub.getText().toString().equals("") && !txt_borrow_four_sub.getText().toString().equals("0")) {

                        if (txt_borrow_four_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(mfourthRanNumSub))) {
                                txt_result_four_sub.setText(keyNum);
                                util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                                handlerForGenarateRandom();
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        } else {
                            if (keyNum.equals(String.valueOf(txt_borrow_four_sub.getText().toString()))) {
                                txt_result_four_sub.setText(keyNum);
                                util.mediaService(((Activity) context),R.raw.sucess,ApplyMath.soundShare);
                                handlerForGenarateRandom();
                            } else {
                                util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                            }
                        }
                    } else {
                        util.mediaService(((Activity) context),R.raw.no,ApplyMath.soundShare);
                    }
                }
                break;
        }
    }
    //Functionality for displaying panda
    public void displayingPanda() {
        switch (ApplyMath.forPandaApply){
            case "first":
                ApplyMath.forPandaApply = "second";
                visiblePanda(R.drawable.panda_one);
                break;
            case "second":
                ApplyMath.forPandaApply = "third";
                visiblePanda(R.drawable.panda_two);
                break;
            case "third":
                ApplyMath.forPandaApply = "first";
                visiblePanda(R.drawable.panda_three);
                break;
        }
    }

    // Set visibility gone after after panda displaying
    public void handlerForPanda() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if (rl_panda.getVisibility() == View.VISIBLE) {
                    rl_panda.setVisibility(View.GONE);
                    txt_pandatext.setVisibility(View.GONE);
                }
            }
        }, 6000);
    }

    //Generate random number after success
    public void handlerForGenarateRandom() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                generateRandomApplySub();

            }
        }, 1000);
    }

    //Visibility for the panda image
    public void visiblePanda(int imgPanda) {
        ApplyMath.countForPanda = 0;
        rl_panda.setVisibility(View.VISIBLE);
        txt_pandatext.setVisibility(View.VISIBLE);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(img_panda);
        Glide.with(context).load(imgPanda).into(imageViewTarget);
        handlerForPanda();
    }
}