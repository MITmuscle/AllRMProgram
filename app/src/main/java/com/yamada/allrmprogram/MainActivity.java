package com.yamada.allrmprogram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            //spinner選択時の処理
            public void onItemSelected(AdapterView parent,View view,int position,long id){
                //repsの回数を取得(String型)　
                Spinner spinner = (Spinner) parent;
                String s_reps = (String) spinner.getSelectedItem();
                //Stringからintに変換
                int reps = Integer.parseInt(s_reps);

                //記入したkgの値を取得　
                EditText edit_weight = (EditText)findViewById(R.id.editText);
                String s_weight = edit_weight.getText().toString();

                if(s_weight.length()!=0){
                    int i_weight = Integer.valueOf(s_weight);
                    //1RMの計算(挙上重量 / 33.3 * 挙上回数 + 挙上重量)
                    double ex_rm = i_weight / 33.3 * reps + i_weight;
                    //int型（整数値）に変換
                    int ex_i_rm = (int)ex_rm;
                    //表示のために文字列に変換
                    String s_rm = String.valueOf(ex_i_rm);
                    //確認
                    Log.d("MAIN","計算した1RM = "+s_rm);

                    TextView text = (TextView)findViewById(R.id.rm1);
                    text.setText(s_rm);
                }else{
                    //重量未入力時の処理
                    toast("挙上重量を入力してください");
                }

            }
            //spinner未選択時の処理
            public void onNothingSelected(AdapterView parent){
                Log.d("MAIN","NOitem");
            }
        });


    }


    public void reps_OnClick(View view){

        Log.d("MAIN","reps");
    }

    //TextView押下時の挙動チェック
    public void RM1_OnClick(View view){
        Log.d("MAIN","RM1");
        EditText edit = (EditText)findViewById(R.id.editText);
        if(edit.length()!=0) {

            Log.d("MAIN","if");
        }
        else{
            Log.d("MAIN","else");
        }
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

    public void toast(String message){
        Toast toast = Toast.makeText(this,message,Toast.LENGTH_SHORT);
        toast.show();
    }

}
