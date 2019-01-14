package com.example.ashra.flappybird;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

import java.util.concurrent.Delayed;

/**
 * Created by ashra on 1/13/2019.
 */

public class GameThread extends Thread {

    SurfaceHolder surfaceHolder; //surfaceHolder object referance
    boolean isRunning;//Flag to detect whether the thread is running
    long startTime,loopTime;//Loop start time and loop duration
    long DELAY =33;//Delay in milliseconds between screen refreance


    public GameThread(SurfaceHolder surfaceHolder ){

        this.surfaceHolder = surfaceHolder;
        isRunning = true;
    }

    @Override
    public void run() {
        //Looping untill the boolean is false

        while (isRunning) {
            long startTime = SystemClock.uptimeMillis();
            //locking the canvas

            Canvas canvas = surfaceHolder.lockCanvas(null);

            if (canvas != null) synchronized (surfaceHolder) {


                AppConstants.getGameEngine().updateAndDrawBackgroundImage(canvas);

                //unlocking the  canvas

                surfaceHolder.unlockCanvasAndPost(canvas);
            }

            //loop time

            loopTime = SystemClock.uptimeMillis() - startTime;
            //Pausing here to make sure we update the right amount per Second

            if (loopTime < DELAY) {

                try {
                    Thread.sleep(DELAY - loopTime);
                } catch (InterruptedException e) {

                    Log.e("Interrapted", "Interrupted whille sleeping");
                }
            }


        }
    }

        //Return whether the thread is running

        public boolean isRunning(){

            return isRunning;
    }

    public void setIsRunning(boolean state){

        isRunning = state;
        }
}



