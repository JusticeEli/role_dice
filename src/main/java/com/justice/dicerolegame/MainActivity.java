package com.justice.dicerolegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    private Handler handler;

    private volatile boolean run = true;
    private boolean firstClick = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        initWidgets();
        setOnClickListeners();
    }

    private void setOnClickListeners() {


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!firstClick){
                    return;
                }

                while (firstClick) {
                          int i = 0;
                            textView.setText("" + i++);

                            Random random = new Random();
                            switch (random.nextInt(6) + 1) {
                                case 1:
                                    imageView.setImageResource(R.mipmap.dice1);
                                    break;
                                case 2:
                                    imageView.setImageResource(R.mipmap.dice2);
                                    break;
                                case 3:
                                    imageView.setImageResource(R.mipmap.dice3);
                                    break;
                                case 4:
                                    imageView.setImageResource(R.mipmap.dice4);
                                    break;
                                case 5:
                                    imageView.setImageResource(R.mipmap.dice5);
                                    break;
                                case 6:
                                    imageView.setImageResource(R.mipmap.dice6);
                                    break;


                            }


                        }

            }
        });

        /**
         * imageView.setOnClickListener(new View.OnClickListener() {
         *             @Override
         *             public void onClick(View v) {
         *                 HelperThread helperThread = new HelperThread();
         *
         *                 if (firstClick) {
         *                     firstClick = false;
         *                     helperThread.start();
         *
         *
         *                 }else {
         *                     run=false;
         *                     helperThread.quit();
         *                 }
         *
         *             }
         *         });
          */



    }

    private void initWidgets() {
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);
    }

    class HelperThread extends HandlerThread {
        public HelperThread() {
            super("helper", 0);
        }

        @Override
        protected void onLooperPrepared() {
             while (run) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int i = 0;
                        textView.setText("" + i++);

                        Random random = new Random();
                        switch (random.nextInt(6) + 1) {
                            case 1:
                                imageView.setImageResource(R.mipmap.dice1);
                                break;
                            case 2:
                                imageView.setImageResource(R.mipmap.dice2);
                                break;
                            case 3:
                                imageView.setImageResource(R.mipmap.dice3);
                                break;
                            case 4:
                                imageView.setImageResource(R.mipmap.dice4);
                                break;
                            case 5:
                                imageView.setImageResource(R.mipmap.dice5);
                                break;
                            case 6:
                                imageView.setImageResource(R.mipmap.dice6);
                                break;


                        }


                    }
                });

            }
        }
    }

}
