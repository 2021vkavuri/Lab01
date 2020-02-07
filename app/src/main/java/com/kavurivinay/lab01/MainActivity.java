package com.kavurivinay.lab01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button myButton;
    Button myButton2;
    TextView myText;
    int counter;
    boolean doLoop = false;
    final Handler h = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 0;
        myButton = findViewById(R.id.button);
        myButton2 = findViewById(R.id.button2);
        myText = findViewById(R.id.textView);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Log.i("app","Increment Counter");
                counter++;
                myText.setText("" + counter);
            }
        });
    }
    public void doAction(View v)
    {
        final int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        final int height = Resources.getSystem().getDisplayMetrics().heightPixels - 200;
        doLoop = !doLoop;
        if(doLoop)
        {
            counter = 0;
            myText.setText("" + counter);
            myButton.setClickable(true);
            Log.i("app","Start of Game");
        }
        else{
            myButton.setClickable(false);
            Log.i("app","End of Game");
        }
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                myButton2.setX((float) Math.random() * (width - myButton2.getWidth()));
                myButton2.setY((float) Math.random() * (height - myButton2.getHeight()));

                myButton.setX((float) Math.random() * (width - myButton.getWidth()));
                myButton.setY((float) Math.random() * (height - myButton.getHeight()));
                if(doLoop)
                {
                    h.postDelayed(this, 600);
                }
                else{
                    h.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.i("app", "Waiting 1 Second");
                        }
                    }, 1000);
                }
            }
        }, 600);
    }
}
