package com.kavurivinay.lab01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button myButton;
    TextView myText;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter = 0;
        myButton = findViewById(R.id.button);
        myText = findViewById(R.id.textView);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                counter++;
                myText.setText("" + counter);
            }
        });
    }
    public void doAction(View v)
    {

    }
}
