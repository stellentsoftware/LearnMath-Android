package com.learnmath.Utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.learnmath.R;

/**
 * Created by STELLENT on 10/25/2017.
 */
//used for changing image bitmap color
public class Util {

    //For confetti aniation image bit map color change

    public static Bitmap changeImageColor(Bitmap sourceBitmap, int color) {
        Bitmap resultBitmap = Bitmap.createBitmap(sourceBitmap, 0, 0, sourceBitmap.getWidth() - 1, sourceBitmap.getHeight() - 1);
        Paint p = new Paint();
        ColorFilter filter = new LightingColorFilter(color, 1);
        p.setColorFilter(filter);

        Canvas canvas = new Canvas(resultBitmap);
        canvas.drawBitmap(resultBitmap, 0, 0, p);
        return resultBitmap;
    }

    public static Drawable covertBitmapToDrawable(Context context, Bitmap bitmap) {
        Drawable d = new BitmapDrawable(context.getResources(), bitmap);
        return d;
    }
    public static Bitmap convertDrawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }
    //Show dialog info for all phrases
    public void showDialogInfo(Activity activity, FontChange mfont, String mMathHead, String mMathInfo) {
        final Dialog dialog = new Dialog(activity, R.style.DialogTheme);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.info_dialog);
        TextView tv_head = (TextView) dialog.findViewById(R.id.tv_head);
        TextView tv_body = (TextView) dialog.findViewById(R.id.tv_body);
        TextView txt_info_header = (TextView) dialog.findViewById(R.id.txt_info_head);
        mfont.fontChange(tv_body, "fonts/textFont.ttf", activity);
        mfont.fontChange(tv_head, "fonts/textFont.ttf", activity);
        mfont.fontChange(txt_info_header, "fonts/textFont.ttf", activity);

        tv_head.setText(mMathHead);
        tv_body.setText(mMathInfo);

        RelativeLayout rl_dissmiss = (RelativeLayout) dialog.findViewById(R.id.rl_dissmiss);
        rl_dissmiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        ImageView img_dissmiss = (ImageView) dialog.findViewById(R.id.img_close_info);
        img_dissmiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
    //For media service playing the sounds
    public void mediaService(Activity activity,int raw,boolean sound) {
        if (sound) {
            final MediaPlayer mp = MediaPlayer.create(activity, raw);
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
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}