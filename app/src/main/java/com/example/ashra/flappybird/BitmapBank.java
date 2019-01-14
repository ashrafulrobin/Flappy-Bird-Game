package com.example.ashra.flappybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by ashra on 1/13/2019.
 */

public class BitmapBank {

    Bitmap background;

    public BitmapBank(Resources res) {

        background = BitmapFactory.decodeResource(res,R.mipmap.flappy2);
        background = scaleImage(background);
    }

    //Return background bitmap

    public Bitmap getBackground(){

       return background;
    }

    //Return background width
    public int getBackgroundWidth(){

        return background.getWidth();
    }

    //Return background height
    public int getBackgroundHeight(){

        return background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){

        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();


        int backgroundScaledWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;

        return Bitmap.createScaledBitmap(bitmap,backgroundScaledWidth,AppConstants.SCREEN_HEIGHT,false);
    }

}
