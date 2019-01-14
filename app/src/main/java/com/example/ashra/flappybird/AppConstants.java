package com.example.ashra.flappybird;

/**
 * Created by ashra on 1/13/2019.
 */
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstants {

    static BitmapBank bitmapBank; //bitmap object reference
    static GameEngine gameEngine;//GameEngine object reference
    static int SCREEN_WIDTH,SCREEN_HEIGHT;

public static void initialization(Context context){


setScreenSize(context);
    bitmapBank = new BitmapBank(context.getResources());
    gameEngine = new GameEngine();
}

public static BitmapBank getBitmapBank(){
    return bitmapBank;
}


    public static GameEngine getGameEngine() {
        return gameEngine;
    }

    private static void setScreenSize(Context context){

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        AppConstants.SCREEN_WIDTH = width;
        AppConstants.SCREEN_HEIGHT = height;



}

}
