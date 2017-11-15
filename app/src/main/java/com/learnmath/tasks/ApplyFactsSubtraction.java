package com.learnmath.tasks;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.learnmath.R;
import com.learnmath.fragments.ApplyMath;
import com.learnmath.utils.FontChange;

import java.util.Random;

public class ApplyFactsSubtraction {
    public int firstRanNum_sub, secondRanNum_sub, thirdRanNum_sub, fourthRanNum_sub, fifthRanNum_sub, sixthRanNum_sub;

    private RelativeLayout rl_panda;
    public TextView tv_regroup, txt_number_bellow_three_sub, txt_number_bellow_four_sub, txt_pandatext, txt_number_up_four_sub, txt_number_up_three_sub, txt_number_up_two_sub, txt_number_up_one_sub, txt_number_bellow_two_sub, txt_number_bellow_one_sub, txt_borrow_four_sub, txt_borrow_three_sub, txt_borrow_two_sub, txt_borrow_one_sub, txt_result_four_sub, txt_result_three_sub, txt_result_two_sub, txt_result_one_sub;
    public TextView txt_regroup_lable_four, txt_regroup_lable_three, txt_regroup_lable_two, txt_regroup_lable_one;
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
        ApplyMath.regroup = false;
        ApplyMath.regroup_four = false;
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
        switch (ApplyMath.level_change) {
            //Level one random generator
            case 1:
                txt_number_bellow_four_sub.setVisibility(View.GONE);
                txt_number_bellow_three_sub.setVisibility(View.VISIBLE);
                Random r1 = new Random();
                fifthRanNum_sub = r1.nextInt(9 - 1 + 1) + 1;
                firstRanNum_sub = r1.nextInt(9 - fifthRanNum_sub + 1) + fifthRanNum_sub;
                //Setting the random number
                txt_number_up_one_sub.setText(String.valueOf(firstRanNum_sub));
                txt_number_bellow_one_sub.setText(String.valueOf(fifthRanNum_sub));
                break;
            //Level two random generator
            case 2:
                //Top row
                txt_number_bellow_four_sub.setVisibility(View.GONE);
                txt_number_bellow_three_sub.setVisibility(View.VISIBLE);
                Random r2 = new Random();
                fifthRanNum_sub = r2.nextInt(9 - 1 + 1) + 1;
                firstRanNum_sub = r2.nextInt(9 - fifthRanNum_sub + 1) + fifthRanNum_sub;
                secondRanNum_sub = r2.nextInt(9 - 1 + 1) + 1;
                //Setting the random number
                txt_number_up_one_sub.setText(String.valueOf(firstRanNum_sub));
                txt_number_up_two_sub.setText(String.valueOf(secondRanNum_sub));
                txt_number_bellow_one_sub.setText(String.valueOf(fifthRanNum_sub));
                break;
            //Level three random generator
            case 3:
                //Top row
                txt_number_bellow_four_sub.setVisibility(View.VISIBLE);
                txt_number_bellow_three_sub.setVisibility(View.GONE);
                //Empty the views before setting the value
                firstRanNum_sub = genarateRandom(0, 9);
                secondRanNum_sub = genarateRandom(0, 9);
                thirdRanNum_sub = genarateRandom(1, 9);
                //Bottom row
                fifthRanNum_sub = genarateRandom(0, 9);
                sixthRanNum_sub = genarateRandom(1, 9);
                //For switch case in third level functionality
                if (firstRanNum_sub >= fifthRanNum_sub && secondRanNum_sub >= sixthRanNum_sub) {
                    funCase = 1;
                } else if (firstRanNum_sub < fifthRanNum_sub && secondRanNum_sub >= sixthRanNum_sub) {
                    funCase = 2;
                } else if (firstRanNum_sub >= fifthRanNum_sub && secondRanNum_sub < sixthRanNum_sub) {
                    funCase = 3;
                } else if (firstRanNum_sub < fifthRanNum_sub && secondRanNum_sub < sixthRanNum_sub) {
                    funCase = 4;
                }
                //Setting the random number
                txt_number_up_one_sub.setText(String.valueOf(firstRanNum_sub));
                txt_number_up_two_sub.setText(String.valueOf(secondRanNum_sub));
                txt_number_up_three_sub.setText(String.valueOf(thirdRanNum_sub));
                txt_number_bellow_one_sub.setText(String.valueOf(fifthRanNum_sub));
                txt_number_bellow_two_sub.setText(String.valueOf(sixthRanNum_sub));
                break;
            //Level four random generator
            case 4:
                //Top row
                txt_number_bellow_four_sub.setVisibility(View.VISIBLE);
                txt_number_bellow_three_sub.setVisibility(View.GONE);
                firstRanNum_sub = genarateRandom(0, 9);
                secondRanNum_sub = genarateRandom(0, 9);
                thirdRanNum_sub = genarateRandom(0, 9);
                fourthRanNum_sub = genarateRandom(1, 9);
                //Bottom row
                fifthRanNum_sub = genarateRandom(0, 9);
                sixthRanNum_sub = genarateRandom(1, 9);
                //Setting the random number
                txt_number_up_one_sub.setText(String.valueOf(firstRanNum_sub));
                txt_number_up_two_sub.setText(String.valueOf(secondRanNum_sub));
                txt_number_up_three_sub.setText(String.valueOf(thirdRanNum_sub));
                txt_number_up_four_sub.setText(String.valueOf(fourthRanNum_sub));
                txt_number_bellow_one_sub.setText(String.valueOf(fifthRanNum_sub));
                txt_number_bellow_two_sub.setText(String.valueOf(sixthRanNum_sub));
                //For switch case in fourth level functionality
                if (firstRanNum_sub >= fifthRanNum_sub && secondRanNum_sub >= sixthRanNum_sub) {
                    funCase = 1;
                } else if (firstRanNum_sub < fifthRanNum_sub && secondRanNum_sub >= sixthRanNum_sub) {
                    funCase = 2;
                } else if (firstRanNum_sub >= fifthRanNum_sub && secondRanNum_sub < sixthRanNum_sub) {
                    funCase = 3;
                } else if (firstRanNum_sub < fifthRanNum_sub && secondRanNum_sub < sixthRanNum_sub) {
                    funCase = 4;
                }
                break;
        }
    }

    //Functionality for subtraction
    public void functionalityforSub(String keyNum) {
        switch (ApplyMath.level_change) {
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
            if (keyNum.equals(String.valueOf(firstRanNum_sub - fifthRanNum_sub))) {
                txt_result_one_sub.setText(keyNum);
                mediaService(R.raw.sucess);
                handlerForGenarateRandom();
            } else {
                mediaService(R.raw.no);
            }
        }
    }

    //Subtraction functionality level2
    public void twodigitsSub(String keyNum) {
        if (txt_result_one_sub.getText().toString().equals("")) {
            if (keyNum.equals(String.valueOf(firstRanNum_sub - fifthRanNum_sub))) {
                txt_result_one_sub.setText(keyNum);
                mediaService(R.raw.yes);
            } else {
                mediaService(R.raw.no);
            }
        } else if (txt_result_two_sub.getText().toString().equals("")) {

            if (keyNum.equals(String.valueOf(secondRanNum_sub))) {
                txt_result_two_sub.setText(keyNum);
                mediaService(R.raw.sucess);
                handlerForGenarateRandom();
            } else {
                mediaService(R.raw.no);
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
                    if (keyNum.equals(String.valueOf(firstRanNum_sub - fifthRanNum_sub))) {
                        txt_result_one_sub.setText(keyNum);
                        mediaService(R.raw.yes);
                    } else {
                        mediaService(R.raw.no);
                    }
                } else if (txt_result_two_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(secondRanNum_sub - sixthRanNum_sub))) {
                        txt_result_two_sub.setText(keyNum);
                        mediaService(R.raw.yes);
                    } else {
                        mediaService(R.raw.no);
                    }
                } else if (txt_result_three_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(thirdRanNum_sub))) {
                        txt_result_three_sub.setText(keyNum);
                        mediaService(R.raw.sucess);
                        handlerForGenarateRandom();
                    } else {
                        mediaService(R.raw.no);
                    }
                } else {
                    mediaService(R.raw.no);
                }
                break;
            //Case 2 if minuend digit 0  less than subtrahend digit 0 and digit 1 and digit one are greater than subtrahend digit 1
            case 2:
                if (txt_result_one_sub.getText().toString().equals("")) {
                    if (keyNum.equals("Regroup") && !ApplyMath.regroup) {
                        ApplyMath.regroup = true;
                        txt_regroup_lable_one.setVisibility(View.VISIBLE);
                        mediaService(R.raw.yes);
                    } else if (ApplyMath.regroup) {
                        if (txt_borrow_two_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(secondRanNum_sub - 1))) {
                                txt_borrow_two_sub.setText(keyNum);
                                mediaService(R.raw.yes);
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else if (txt_borrow_one_sub.getText().toString().equals("")) {
                            if (keyNum.equals("1")) {
                                mediaService(R.raw.yes);
                                txt_borrow_one_sub.setText(keyNum);
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else if (txt_borrow_one_sub.getText().toString().equals("1")) {
                            if (keyNum.equals(String.valueOf(firstRanNum_sub))) {
                                String a = "1" + keyNum;
                                txt_borrow_one_sub.setText(a);
                                mediaService(R.raw.yes);
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else if (txt_result_one_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_one_sub.getText().toString()) - fifthRanNum_sub))) {
                                txt_result_one_sub.setText(keyNum);
                                mediaService(R.raw.yes);
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else {
                        mediaService(R.raw.no);
                    }
                } else if (txt_result_two_sub.getText().toString().equals("")) {

                    if (txt_borrow_two_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(secondRanNum_sub - sixthRanNum_sub))) {
                            txt_result_two_sub.setText(keyNum);
                            mediaService(R.raw.yes);
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else if (Integer.parseInt(txt_borrow_two_sub.getText().toString()) >= sixthRanNum_sub) {
                        if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - sixthRanNum_sub))) {
                            txt_result_two_sub.setText(keyNum);
                            if (txt_borrow_three_sub.getText().toString().equals("0")) {
                                mediaService(R.raw.sucess);
                                handlerForGenarateRandom();
                            } else {
                                mediaService(R.raw.yes);
                            }
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else if (Integer.parseInt(txt_borrow_two_sub.getText().toString()) < sixthRanNum_sub) {
                        if (ApplyMath.regroup) {
                            if (keyNum.equals("Regroup") && ApplyMath.regroup) {
                                ApplyMath.regroup = false;
                                txt_regroup_lable_two.setVisibility(View.VISIBLE);
                                mediaService(R.raw.yes);
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else {
                            if (txt_borrow_three_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(thirdRanNum_sub - 1))) {
                                    txt_borrow_three_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (!ApplyMath.regroup) {
                                if (keyNum.equals("1")) {
                                    String a = keyNum + txt_borrow_two_sub.getText().toString();
                                    txt_borrow_two_sub.setText(a);
                                    ApplyMath.regroup = true;
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (ApplyMath.regroup) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - sixthRanNum_sub))) {
                                    txt_result_two_sub.setText(keyNum);
                                    if (txt_borrow_three_sub.getText().toString().equals("0")) {
                                        mediaService(R.raw.sucess);
                                        handlerForGenarateRandom();
                                    } else {
                                        mediaService(R.raw.yes);
                                    }
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else {
                                mediaService(R.raw.no);
                            }
                        }
                    } else {
                        mediaService(R.raw.no);
                    }
                } else if (txt_result_three_sub.getText().toString().equals("")) {
                    if (txt_borrow_three_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(thirdRanNum_sub))) {
                            txt_result_three_sub.setText(keyNum);
                            mediaService(R.raw.sucess);
                            handlerForGenarateRandom();
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else {
                        if (keyNum.equals(String.valueOf(txt_borrow_three_sub.getText().toString())) && !txt_borrow_three_sub.getText().toString().equals("0")) {
                            txt_result_three_sub.setText(keyNum);
                            mediaService(R.raw.sucess);
                            handlerForGenarateRandom();
                        } else {
                            mediaService(R.raw.no);
                        }
                    }
                } else {
                    mediaService(R.raw.no);
                }
                break;
            //Case 3 if minuend digit 0 greater than subtrahend digit 0 and digit 1 and digit one are less than subtrahend digit 1
            case 3:
                if (txt_result_one_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(firstRanNum_sub - fifthRanNum_sub))) {
                        txt_result_one_sub.setText(keyNum);
                        mediaService(R.raw.yes);
                    } else {
                        mediaService(R.raw.no);
                    }
                } else if (txt_result_two_sub.getText().toString().equals("")) {
                    if (keyNum.equals("Regroup") && !ApplyMath.regroup) {
                        ApplyMath.regroup = true;
                        txt_regroup_lable_one.setVisibility(View.VISIBLE);
                        txt_regroup_lable_two.setVisibility(View.VISIBLE);
                        mediaService(R.raw.yes);
                    } else if (ApplyMath.regroup) {
                        if (txt_borrow_three_sub.getText().toString().trim().equals("")) {
                            if (keyNum.equals(String.valueOf(thirdRanNum_sub - 1))) {
                                txt_borrow_three_sub.setText(keyNum);
                                mediaService(R.raw.yes);
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else if (txt_borrow_two_sub.getText().toString().trim().equals("")) {
                            if (keyNum.equals("1")) {
                                txt_borrow_two_sub.setText(keyNum);
                                mediaService(R.raw.yes);
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else if (txt_borrow_two_sub.getText().toString().trim().equals("1")) {
                            if (keyNum.equals(String.valueOf(secondRanNum_sub))) {
                                String a = "1" + keyNum;
                                txt_borrow_two_sub.setText(a);
                                mediaService(R.raw.yes);
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else if (txt_result_two_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - sixthRanNum_sub))) {
                                txt_result_two_sub.setText(keyNum);
                                if (txt_borrow_three_sub.getText().toString().equals("0")) {
                                    mediaService(R.raw.sucess);
                                    handlerForGenarateRandom();
                                } else {
                                    mediaService(R.raw.yes);
                                }
                            } else {
                                mediaService(R.raw.no);
                            }
                        }
                    } else {
                        mediaService(R.raw.no);
                    }
                } else if (txt_result_three_sub.getText().toString().equals("")) {

                    if (txt_borrow_three_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(thirdRanNum_sub))) {
                            txt_result_three_sub.setText(keyNum);
                            mediaService(R.raw.sucess);
                            handlerForGenarateRandom();
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else {
                        if (keyNum.equals(String.valueOf(txt_borrow_three_sub.getText().toString())) && !txt_borrow_three_sub.getText().toString().equals("0")) {
                            txt_result_three_sub.setText(keyNum);
                            mediaService(R.raw.sucess);
                            handlerForGenarateRandom();
                        } else {
                            mediaService(R.raw.no);
                        }
                    }
                } else {
                    mediaService(R.raw.no);
                }
                break;
            //Case 4 if minuend digit 0 less than subtrahend digit 0 and minuend digit 1 and digit one are less than subtrahend digit 1
            case 4:
                
                if (secondRanNum_sub == 0) {
                    if (txt_result_one_sub.getText().toString().equals("")) {
                        if (keyNum.equals("Regroup") && !ApplyMath.regroup) {
                            ApplyMath.regroup = true;
                            txt_regroup_lable_one.setVisibility(View.VISIBLE);
                            txt_regroup_lable_two.setVisibility(View.VISIBLE);
                            mediaService(R.raw.yes);
                        } else if (ApplyMath.regroup) {

                            if (txt_borrow_three_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(thirdRanNum_sub - 1))) {
                                    txt_borrow_three_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_two_sub.getText().toString().equals("")) {
                                if (keyNum.equals("9")) {
                                    txt_borrow_two_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals("1")) {
                                    txt_borrow_one_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("1")) {
                                if (keyNum.equals(String.valueOf(firstRanNum_sub))) {
                                    String a = "1" + keyNum;
                                    txt_borrow_one_sub.setText(a);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_result_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_one_sub.getText().toString()) - fifthRanNum_sub))) {
                                    txt_result_one_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else if (txt_result_two_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - sixthRanNum_sub))) {
                            txt_result_two_sub.setText(keyNum);
                            if (txt_borrow_three_sub.getText().toString().equals("0")) {
                                mediaService(R.raw.sucess);
                                handlerForGenarateRandom();
                            } else {
                                mediaService(R.raw.yes);
                            }
                        } else {
                            mediaService(R.raw.no);
                        }

                    } else if (txt_result_three_sub.getText().toString().equals("")) {

                        if (keyNum.equals(txt_borrow_three_sub.getText().toString()) && !txt_borrow_three_sub.getText().toString().equals("0")) {
                            txt_result_three_sub.setText(keyNum);
                            mediaService(R.raw.sucess);
                            handlerForGenarateRandom();
                        } else {
                            mediaService(R.raw.no);
                        }
                    }
                } else {
                    if (txt_result_one_sub.getText().toString().equals("")) {
                        if (keyNum.equals("Regroup") && !ApplyMath.regroup) {
                            ApplyMath.regroup = true;
                            txt_regroup_lable_one.setVisibility(View.VISIBLE);
                            mediaService(R.raw.yes);
                        } else if (ApplyMath.regroup) {
                            if (txt_borrow_two_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(secondRanNum_sub - 1))) {
                                    txt_borrow_two_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals("1")) {
                                    txt_borrow_one_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("1")) {
                                if (keyNum.equals(String.valueOf(firstRanNum_sub))) {
                                    String a = "1" + keyNum;
                                    txt_borrow_one_sub.setText(a);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_result_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_one_sub.getText().toString()) - fifthRanNum_sub))) {
                                    txt_result_one_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else if (txt_result_two_sub.getText().toString().equals("")) {
                        if (!ApplyMath.regroup_four) {
                            if (keyNum.equals("Regroup") && ApplyMath.regroup) {
                                ApplyMath.regroup = false;
                                ApplyMath.regroup_four = true;
                                txt_regroup_lable_two.setVisibility(View.VISIBLE);
                                mediaService(R.raw.yes);
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else if (ApplyMath.regroup_four) {
                            if (txt_borrow_three_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(thirdRanNum_sub - 1))) {
                                    txt_borrow_three_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (!ApplyMath.regroup) {
                                if (keyNum.equals("1")) {
                                    String a = keyNum + txt_borrow_two_sub.getText().toString();
                                    txt_borrow_two_sub.setText(a);
                                    ApplyMath.regroup = true;
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (ApplyMath.regroup) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - sixthRanNum_sub))) {
                                    txt_result_two_sub.setText(keyNum);
                                    if (txt_borrow_three_sub.getText().toString().equals("0")) {
                                        mediaService(R.raw.sucess);
                                        handlerForGenarateRandom();
                                    } else {
                                        mediaService(R.raw.yes);
                                    }
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else if (txt_result_three_sub.getText().toString().equals("")) {
                        if (txt_borrow_three_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(thirdRanNum_sub))) {
                                txt_result_three_sub.setText(keyNum);
                                mediaService(R.raw.sucess);
                                handlerForGenarateRandom();
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else {
                            if (keyNum.equals(String.valueOf(txt_borrow_three_sub.getText().toString())) && !txt_borrow_three_sub.getText().toString().equals("0")) {
                                mediaService(R.raw.sucess);
                                txt_result_three_sub.setText(keyNum);
                                handlerForGenarateRandom();
                            } else {
                                mediaService(R.raw.no);
                            }
                        }
                    } else {
                        mediaService(R.raw.no);
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
                    if (keyNum.equals(String.valueOf(firstRanNum_sub - fifthRanNum_sub))) {
                        txt_result_one_sub.setText(keyNum);
                        mediaService(R.raw.yes);
                    } else {
                        mediaService(R.raw.no);
                    }
                } else if (txt_result_two_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(secondRanNum_sub - sixthRanNum_sub))) {
                        txt_result_two_sub.setText(keyNum);
                        mediaService(R.raw.yes);
                    } else {
                        mediaService(R.raw.no);
                    }
                } else if (txt_result_three_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(thirdRanNum_sub))) {
                        txt_result_three_sub.setText(keyNum);
                        mediaService(R.raw.yes);
                    } else {
                        mediaService(R.raw.no);
                    }
                } else if (txt_result_four_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(fourthRanNum_sub))) {
                        txt_result_four_sub.setText(keyNum);
                        mediaService(R.raw.sucess);
                        handlerForGenarateRandom();
                    } else {
                        mediaService(R.raw.no);
                    }
                } else {
                    mediaService(R.raw.no);
                }
                break;
            //Case 2 if minuend digit 0  less than subtrahend digit 0 and digit 1 and digit one are greater than subtrahend digit 1
            case 2:
                if (txt_result_one_sub.getText().toString().equals("")) {
                    if (keyNum.equals("Regroup") && !ApplyMath.regroup) {
                        ApplyMath.regroup = true;
                        txt_regroup_lable_one.setVisibility(View.VISIBLE);
                        mediaService(R.raw.yes);
                    } else if (ApplyMath.regroup) {
                        if (txt_borrow_two_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(secondRanNum_sub - 1))) {
                                txt_borrow_two_sub.setText(keyNum);
                                mediaService(R.raw.yes);
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else if (txt_borrow_one_sub.getText().toString().equals("")) {
                            if (keyNum.equals("1")) {
                                txt_borrow_one_sub.setText(keyNum);
                                mediaService(R.raw.yes);
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else if (txt_borrow_one_sub.getText().toString().equals("1")) {
                            if (keyNum.equals(String.valueOf(firstRanNum_sub))) {
                                String a = "1" + keyNum;
                                txt_borrow_one_sub.setText(a);
                                mediaService(R.raw.yes);
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else if (txt_result_one_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_one_sub.getText().toString()) - fifthRanNum_sub))) {
                                txt_result_one_sub.setText(keyNum);
                                mediaService(R.raw.yes);
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else {
                        mediaService(R.raw.no);
                    }
                } else if (txt_result_two_sub.getText().toString().equals("")) {

                    if (txt_borrow_two_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(secondRanNum_sub - sixthRanNum_sub))) {
                            txt_result_two_sub.setText(keyNum);
                            mediaService(R.raw.yes);
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else if (Integer.parseInt(txt_borrow_two_sub.getText().toString()) >= sixthRanNum_sub) {
                        if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - sixthRanNum_sub))) {
                            txt_result_two_sub.setText(keyNum);
                            mediaService(R.raw.yes);
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else if (Integer.parseInt(txt_borrow_two_sub.getText().toString()) < sixthRanNum_sub) {
                        if (ApplyMath.regroup) {
                            if (keyNum.equals("Regroup") && ApplyMath.regroup) {
                                if (txt_number_up_three_sub.getText().toString().equals("0")) {
                                    ApplyMath.regroup = false;
                                    txt_regroup_lable_two.setVisibility(View.VISIBLE);
                                    txt_regroup_lable_three.setVisibility(View.VISIBLE);
                                    mediaService(R.raw.yes);
                                } else {
                                    ApplyMath.regroup = false;
                                    txt_regroup_lable_two.setVisibility(View.VISIBLE);
                                    mediaService(R.raw.yes);
                                }
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else {
                            if (txt_number_up_three_sub.getText().toString().equals("0")) {
                                if (txt_borrow_four_sub.getText().toString().equals("")) {
                                    if (keyNum.equals(String.valueOf(fourthRanNum_sub - 1))) {
                                        txt_borrow_four_sub.setText(keyNum);
                                        mediaService(R.raw.yes);
                                    } else {
                                        mediaService(R.raw.no);
                                    }
                                } else if (txt_borrow_three_sub.getText().toString().equals("")) {
                                    if (keyNum.equals("9")) {
                                        txt_borrow_three_sub.setText(keyNum);
                                        mediaService(R.raw.yes);
                                    } else {
                                        mediaService(R.raw.no);
                                    }
                                } else if (!ApplyMath.regroup) {
                                    if (keyNum.equals("1")) {
                                        String a = keyNum + String.valueOf(txt_borrow_two_sub.getText().toString());
                                        txt_borrow_two_sub.setText(a);
                                        ApplyMath.regroup = true;
                                        mediaService(R.raw.yes);
                                    } else {
                                        mediaService(R.raw.no);
                                    }
                                } else if (ApplyMath.regroup) {

                                    if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - sixthRanNum_sub))) {
                                        txt_result_two_sub.setText(keyNum);
                                        mediaService(R.raw.yes);
                                    } else {
                                        mediaService(R.raw.no);
                                    }
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else {
                                if (txt_borrow_three_sub.getText().toString().equals("")) {
                                    if (keyNum.equals(String.valueOf(thirdRanNum_sub - 1))) {
                                        txt_borrow_three_sub.setText(keyNum);
                                        mediaService(R.raw.yes);
                                    } else {
                                        mediaService(R.raw.no);
                                    }
                                } else if (!ApplyMath.regroup) {
                                    if (keyNum.equals("1")) {
                                        String a = keyNum + txt_borrow_two_sub.getText().toString();
                                        txt_borrow_two_sub.setText(a);
                                        ApplyMath.regroup = true;
                                        mediaService(R.raw.yes);
                                    } else {
                                        mediaService(R.raw.no);
                                    }
                                } else if (ApplyMath.regroup) {
                                    if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - sixthRanNum_sub))) {
                                        txt_result_two_sub.setText(keyNum);
                                        mediaService(R.raw.yes);
                                    } else {
                                        mediaService(R.raw.no);
                                    }
                                } else {
                                    mediaService(R.raw.no);
                                }
                            }
                        }
                    } else {
                        mediaService(R.raw.no);
                    }
                } else if (txt_result_three_sub.getText().toString().equals("")) {
                    if (txt_borrow_three_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(thirdRanNum_sub))) {
                            txt_result_three_sub.setText(keyNum);
                            mediaService(R.raw.yes);
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else {
                        if (keyNum.equals(String.valueOf(txt_borrow_three_sub.getText().toString()))) {
                            txt_result_three_sub.setText(keyNum);
                            if (txt_borrow_four_sub.getText().toString().equals("0")) {
                                mediaService(R.raw.sucess);
                                handlerForGenarateRandom();

                            } else {
                                mediaService(R.raw.yes);
                            }
                        } else {
                            mediaService(R.raw.no);
                        }
                    }
                } else if (txt_result_four_sub.getText().toString().equals("") && !txt_borrow_four_sub.getText().toString().equals("0")) {

                    if (txt_borrow_four_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(fourthRanNum_sub))) {
                            txt_result_four_sub.setText(keyNum);
                            mediaService(R.raw.sucess);
                            handlerForGenarateRandom();
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else {
                        if (keyNum.equals(String.valueOf(txt_borrow_four_sub.getText().toString()))) {
                            txt_result_four_sub.setText(keyNum);
                            mediaService(R.raw.sucess);
                            handlerForGenarateRandom();
                        } else {
                            mediaService(R.raw.no);
                        }
                    }
                } else {
                    mediaService(R.raw.no);
                }
                break;
            //Case 3 if minuend digit 0 greater than subtrahend digit 0 and digit 1 and digit one are less than subtrahend digit 1
            case 3:
                if (txt_result_one_sub.getText().toString().equals("")) {
                    if (keyNum.equals(String.valueOf(firstRanNum_sub - fifthRanNum_sub))) {
                        txt_result_one_sub.setText(keyNum);
                        mediaService(R.raw.yes);
                    } else {
                        mediaService(R.raw.no);
                    }
                } else if (txt_result_two_sub.getText().toString().equals("")) {
                    if (keyNum.equals("Regroup") && !ApplyMath.regroup) {
                        if (txt_number_up_three_sub.getText().toString().equals("0")) {
                            ApplyMath.regroup = true;
                            txt_regroup_lable_one.setVisibility(View.VISIBLE);
                            txt_regroup_lable_two.setVisibility(View.VISIBLE);
                            txt_regroup_lable_three.setVisibility(View.VISIBLE);
                            mediaService(R.raw.yes);
                        } else {
                            ApplyMath.regroup = true;
                            txt_regroup_lable_one.setVisibility(View.VISIBLE);
                            txt_regroup_lable_two.setVisibility(View.VISIBLE);
                            mediaService(R.raw.yes);
                        }
                    } else if (ApplyMath.regroup) {
                        if (txt_number_up_three_sub.getText().toString().equals("0")) {
                            if (txt_borrow_four_sub.getText().toString().trim().equals("")) {
                                if (keyNum.equals(String.valueOf(fourthRanNum_sub - 1))) {
                                    txt_borrow_four_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_three_sub.getText().toString().trim().equals("")) {
                                if (keyNum.equals("9")) {
                                    txt_borrow_three_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_two_sub.getText().toString().trim().equals("")) {
                                if (keyNum.equals("1")) {
                                    txt_borrow_two_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_two_sub.getText().toString().trim().equals("1")) {
                                if (keyNum.equals(String.valueOf(secondRanNum_sub))) {
                                    String a = "1" + keyNum;
                                    txt_borrow_two_sub.setText(a);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_result_two_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - sixthRanNum_sub))) {
                                    txt_result_two_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else {
                                mediaService(R.raw.no);
                            }

                        } else {
                            if (txt_borrow_three_sub.getText().toString().trim().equals("")) {
                                if (keyNum.equals(String.valueOf(thirdRanNum_sub - 1))) {
                                    txt_borrow_three_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_two_sub.getText().toString().trim().equals("")) {
                                if (keyNum.equals("1")) {
                                    txt_borrow_two_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_two_sub.getText().toString().trim().equals("1")) {
                                if (keyNum.equals(String.valueOf(secondRanNum_sub))) {
                                    String a = "1" + keyNum;
                                    txt_borrow_two_sub.setText(a);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_result_two_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - sixthRanNum_sub))) {
                                    txt_result_two_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            }
                        }
                    } else {
                        mediaService(R.raw.no);
                    }
                } else if (txt_result_three_sub.getText().toString().equals("")) {
                    if (txt_borrow_three_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(thirdRanNum_sub))) {
                            txt_result_three_sub.setText(keyNum);
                            mediaService(R.raw.yes);
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else {
                        if (keyNum.equals(String.valueOf(txt_borrow_three_sub.getText().toString()))) {

                            txt_result_three_sub.setText(keyNum);
                            if (txt_borrow_four_sub.getText().toString().equals("0")) {
                                mediaService(R.raw.sucess);
                                handlerForGenarateRandom();
                            } else {
                                mediaService(R.raw.yes);
                            }
                        } else {
                            mediaService(R.raw.no);
                        }
                    }
                } else if (txt_result_four_sub.getText().toString().equals("") && !txt_borrow_four_sub.getText().toString().equals("0")) {

                    if (txt_borrow_four_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(fourthRanNum_sub))) {
                            txt_result_four_sub.setText(keyNum);
                            mediaService(R.raw.sucess);
                            handlerForGenarateRandom();
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else {
                        if (keyNum.equals(String.valueOf(txt_borrow_four_sub.getText().toString()))) {
                            txt_result_four_sub.setText(keyNum);
                            mediaService(R.raw.sucess);
                            handlerForGenarateRandom();
                        } else {
                            mediaService(R.raw.no);
                        }
                    }
                } else {
                    mediaService(R.raw.no);
                }
                break;
            //Case 4 if minuend digit 0 less than subtrahend digit 0 and minuend digit 1 and digit one are less than subtrahend digit 1
            case 4:
                if (secondRanNum_sub == 0 && thirdRanNum_sub == 0) {
                    if (txt_result_one_sub.getText().toString().equals("")) {
                        if (keyNum.equals("Regroup") && !ApplyMath.regroup) {
                            ApplyMath.regroup = true;
                            txt_regroup_lable_one.setVisibility(View.VISIBLE);
                            txt_regroup_lable_two.setVisibility(View.VISIBLE);
                            txt_regroup_lable_three.setVisibility(View.VISIBLE);
                            mediaService(R.raw.yes);
                        } else if (ApplyMath.regroup) {
                            if (txt_borrow_four_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(fourthRanNum_sub - 1))) {
                                    txt_borrow_four_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_three_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf("9"))) {
                                    txt_borrow_three_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_two_sub.getText().toString().equals("")) {
                                if (keyNum.equals("9")) {
                                    txt_borrow_two_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals("1")) {
                                    txt_borrow_one_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("1")) {
                                if (keyNum.equals(String.valueOf(firstRanNum_sub))) {
                                    String a = "1" + keyNum;
                                    txt_borrow_one_sub.setText(a);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_result_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_one_sub.getText().toString()) - fifthRanNum_sub))) {
                                    txt_result_one_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else {
                                mediaService(R.raw.no);

                            }
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else if (txt_result_two_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - sixthRanNum_sub))) {
                            txt_result_two_sub.setText(keyNum);
                            mediaService(R.raw.yes);
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else if (txt_result_three_sub.getText().toString().equals("")) {
                        if (keyNum.equals(txt_borrow_three_sub.getText().toString())) {

                            txt_result_three_sub.setText(keyNum);
                            mediaService(R.raw.yes);
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else if (txt_result_four_sub.getText().toString().equals("")) {
                        if (keyNum.equals(txt_borrow_four_sub.getText().toString())) {
                            txt_result_four_sub.setText(keyNum);
                            mediaService(R.raw.sucess);
                            handlerForGenarateRandom();
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else {
                        mediaService(R.raw.no);
                    }
                }
                //Case 2
                else if (secondRanNum_sub == 0) {
                    if (txt_result_one_sub.getText().toString().equals("")) {
                        if (keyNum.equals("Regroup") && !ApplyMath.regroup) {
                            ApplyMath.regroup = true;
                            txt_regroup_lable_one.setVisibility(View.VISIBLE);
                            txt_regroup_lable_two.setVisibility(View.VISIBLE);
                            mediaService(R.raw.yes);
                        } else if (ApplyMath.regroup) {
                            if (txt_borrow_three_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(thirdRanNum_sub - 1))) {
                                    txt_borrow_three_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_two_sub.getText().toString().equals("")) {
                                if (keyNum.equals("9")) {
                                    txt_borrow_two_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals("1")) {
                                    txt_borrow_one_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("1")) {
                                if (keyNum.equals(String.valueOf(firstRanNum_sub))) {
                                    String a = "1" + keyNum;
                                    txt_borrow_one_sub.setText(a);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_result_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_one_sub.getText().toString()) - fifthRanNum_sub))) {
                                    txt_result_one_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else if (txt_result_two_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - sixthRanNum_sub))) {
                            txt_result_two_sub.setText(keyNum);
                            mediaService(R.raw.yes);
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else if (txt_result_three_sub.getText().toString().equals("")) {
                        if (keyNum.equals(txt_borrow_three_sub.getText().toString())) {
                            txt_result_three_sub.setText(keyNum);
                            mediaService(R.raw.yes);
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else if (txt_result_four_sub.getText().toString().equals("")) {
                        if (keyNum.equals(String.valueOf(fourthRanNum_sub))) {
                            txt_result_four_sub.setText(keyNum);
                            mediaService(R.raw.sucess);
                            handlerForGenarateRandom();
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else {
                        mediaService(R.raw.no);
                    }
                }
                //   Case 3
                else {
                    if (txt_result_one_sub.getText().toString().equals("")) {
                        if (keyNum.equals("Regroup") && !ApplyMath.regroup) {
                            ApplyMath.regroup = true;
                            txt_regroup_lable_one.setVisibility(View.VISIBLE);
                            mediaService(R.raw.yes);
                        } else if (ApplyMath.regroup) {
                            if (txt_borrow_two_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(secondRanNum_sub - 1))) {
                                    txt_borrow_two_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals("1")) {
                                    txt_borrow_one_sub.setText(keyNum);
                                    mediaService(R.raw.yes);

                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_borrow_one_sub.getText().toString().equals("1")) {
                                if (keyNum.equals(String.valueOf(firstRanNum_sub))) {
                                    String a = "1" + keyNum;
                                    txt_borrow_one_sub.setText(a);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else if (txt_result_one_sub.getText().toString().equals("")) {
                                if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_one_sub.getText().toString()) - fifthRanNum_sub))) {
                                    txt_result_one_sub.setText(keyNum);
                                    mediaService(R.raw.yes);
                                } else {
                                    mediaService(R.raw.no);
                                }
                            }
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else if (txt_result_two_sub.getText().toString().equals("")) {
                        if (!ApplyMath.regroup_four) {
                            if (keyNum.equals("Regroup") && ApplyMath.regroup) {
                                if (txt_number_up_three_sub.getText().toString().equals("0")) {
                                    ApplyMath.regroup = false;
                                    ApplyMath.regroup_four = true;
                                    txt_regroup_lable_two.setVisibility(View.VISIBLE);
                                    txt_regroup_lable_three.setVisibility(View.VISIBLE);
                                    mediaService(R.raw.yes);
                                } else {
                                    ApplyMath.regroup = false;
                                    ApplyMath.regroup_four = true;
                                    txt_regroup_lable_two.setVisibility(View.VISIBLE);
                                    mediaService(R.raw.yes);
                                }
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else if (ApplyMath.regroup_four) {

                            if (txt_number_up_three_sub.getText().toString().equals("0")) {
                                if (txt_borrow_four_sub.getText().toString().equals("")) {
                                    if (keyNum.equals(String.valueOf(fourthRanNum_sub - 1))) {
                                        txt_borrow_four_sub.setText(keyNum);
                                        mediaService(R.raw.yes);
                                    } else {
                                        mediaService(R.raw.no);
                                    }
                                } else if (txt_borrow_three_sub.getText().toString().equals("")) {
                                    if (keyNum.equals("9")) {
                                        txt_borrow_three_sub.setText(keyNum);
                                        mediaService(R.raw.yes);
                                    } else {
                                        mediaService(R.raw.no);
                                    }
                                } else if (!ApplyMath.regroup) {
                                    if (keyNum.equals("1")) {
                                        String a = keyNum + String.valueOf(txt_borrow_two_sub.getText().toString());
                                        txt_borrow_two_sub.setText(a);
                                        ApplyMath.regroup = true;
                                        mediaService(R.raw.yes);
                                    } else {
                                        mediaService(R.raw.no);
                                    }
                                } else if (ApplyMath.regroup) {
                                    if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - sixthRanNum_sub))) {
                                        txt_result_two_sub.setText(keyNum);
                                        mediaService(R.raw.yes);
                                    } else {
                                        mediaService(R.raw.no);
                                    }
                                } else {
                                    mediaService(R.raw.no);
                                }
                            } else {
                                if (txt_borrow_three_sub.getText().toString().equals("")) {
                                    if (keyNum.equals(String.valueOf(thirdRanNum_sub - 1))) {
                                        txt_borrow_three_sub.setText(keyNum);
                                        mediaService(R.raw.yes);
                                    } else {
                                        mediaService(R.raw.no);
                                    }
                                } else if (!ApplyMath.regroup) {
                                    if (keyNum.equals("1")) {
                                        String a = keyNum + txt_borrow_two_sub.getText().toString();
                                        txt_borrow_two_sub.setText(a);
                                        ApplyMath.regroup = true;
                                        mediaService(R.raw.yes);
                                    } else {
                                        mediaService(R.raw.no);
                                    }
                                } else if (ApplyMath.regroup) {
                                    if (keyNum.equals(String.valueOf(Integer.parseInt(txt_borrow_two_sub.getText().toString()) - sixthRanNum_sub))) {
                                        txt_result_two_sub.setText(keyNum);
                                        mediaService(R.raw.yes);
                                    } else {
                                        mediaService(R.raw.no);
                                    }
                                } else {
                                    mediaService(R.raw.no);
                                }
                            }
                        } else {
                            mediaService(R.raw.no);
                        }
                    } else if (txt_result_three_sub.getText().toString().equals("")) {
                        if (txt_borrow_three_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(thirdRanNum_sub))) {
                                txt_result_three_sub.setText(keyNum);
                                mediaService(R.raw.yes);
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else {
                            if (keyNum.equals(String.valueOf(txt_borrow_three_sub.getText().toString()))) {
                                txt_result_three_sub.setText(keyNum);
                                if (txt_borrow_four_sub.getText().toString().equals("0")) {
                                    mediaService(R.raw.sucess);
                                    handlerForGenarateRandom();
                                } else {
                                    mediaService(R.raw.yes);
                                }
                            } else {
                                mediaService(R.raw.no);
                            }
                        }
                    } else if (txt_result_four_sub.getText().toString().equals("") && !txt_borrow_four_sub.getText().toString().equals("0")) {

                        if (txt_borrow_four_sub.getText().toString().equals("")) {
                            if (keyNum.equals(String.valueOf(fourthRanNum_sub))) {
                                txt_result_four_sub.setText(keyNum);
                                mediaService(R.raw.sucess);
                                handlerForGenarateRandom();
                            } else {
                                mediaService(R.raw.no);
                            }
                        } else {
                            if (keyNum.equals(String.valueOf(txt_borrow_four_sub.getText().toString()))) {
                                txt_result_four_sub.setText(keyNum);
                                mediaService(R.raw.sucess);
                                handlerForGenarateRandom();
                            } else {
                                mediaService(R.raw.no);
                            }
                        }
                    } else {
                        mediaService(R.raw.no);
                    }
                }
                break;
        }
    }

    //Sounds for click media service
    public void mediaService(int raw) {
        if (ApplyMath.sound_share) {
            final MediaPlayer mp = MediaPlayer.create(context, raw);
            try {
                if (mp.isPlaying()) {
                } else {
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp1) {
                            if (mp == mp1) {
                                mp.start();
                            }
                        }
                    });
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();

                        }

                        ;
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Functionality for displaying panda
    public void displayingPanda() {
        if (ApplyMath.forPanda_apply.equals("first")) {
            ApplyMath.forPanda_apply = "second";
            visiblePanda(R.drawable.panda_one);
        } else if (ApplyMath.forPanda_apply.equals("second")) {
            ApplyMath.forPanda_apply = "third";
            visiblePanda(R.drawable.panda_two);
        } else if (ApplyMath.forPanda_apply.equals("third")) {
            ApplyMath.forPanda_apply = "first";
            visiblePanda(R.drawable.panda_three);
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