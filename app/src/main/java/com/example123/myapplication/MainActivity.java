package com.example123.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyCustomViews myCustomViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCustomViews = findViewById(R.id.mcv);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.one:{
                myCustomViews.customPaddingUp(30);
                break;
            }
            case R.id.two:{
                myCustomViews.swapColor();
                break;
            }
            case R.id.three:{
                myCustomViews.customPaddingDown(30);
            }
        }
    }
}
