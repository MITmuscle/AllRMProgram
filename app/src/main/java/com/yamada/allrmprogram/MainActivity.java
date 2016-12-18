package com.yamada.allrmprogram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //TextView押下時の挙動チェック
    public void RM1_OnClick(View view){
        Log.d("MAIN","RM1");
    }

    public void RM2_OnClick(View view){
        Log.d("MAIN","RM2");
    }

    public void RM3_OnClick(View view){
        Log.d("MAIN","RM3");
    }

    public void RM5_OnClick(View view){
        Log.d("MAIN","RM5");
    }

    public void RM7_OnClick(View view){
        Log.d("MAIN","RM7");
    }

    public void RM8_OnClick(View view){
        Log.d("MAIN","RM8");
    }

    public void RM10_OnClick(View view){
        Log.d("MAIN","RM10");
    }

    public void RM12_OnClick(View view){
        Log.d("MAIN","RM12");
    }

    public void RM15_OnClick(View view){
        Log.d("MAIN","RM15");
    }

    public void RM20_OnClick(View view){
        Log.d("MAIN","RM20");
    }

}
