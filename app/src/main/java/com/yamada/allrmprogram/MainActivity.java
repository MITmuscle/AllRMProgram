package com.yamada.allrmprogram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
                    //1RMの計算(挙上重量 / 40 * 挙上回数 + 挙上重量)
                    //double rm1 = i_weight / 40 * reps + i_weight;
                    //MAX重量）＝（使用重量）×｛１＋（Reps／４０）｝
                    double rm1 = 0;
                    rm1 = i_weight * (reps + 33.3) / 33.3;
                    //toast(String.valueOf(reps));

                    //int型（整数値）に変換
                    double d_rm1 = Math.floor(rm1);
                    int i_rm1 = (int)d_rm1;

                    //表示のために文字列に変換
                    String s_rm1 = String.valueOf(i_rm1);
                    Log.d("MAIN",s_rm1);

                    double[] x = new double[21];
                    String[] s_x = new String[21];
                    int[] i_x = new int[21];

                    //それぞれのRMを計算
                    //100kg=Xkg÷40×3回+Xkg
                    for(int i=0;i<=20;i++) {
                        x[i] = (33.3 * rm1) / (i+1 + 33.3);
                        i_x[i] = (int)x[i];
                        s_x[i] = String.valueOf(i_x[i]);
                    }

                    //それぞれのRMを表示
                    TextView text1 = (TextView)findViewById(R.id.rm1_text);
                    TextView text2 = (TextView)findViewById(R.id.rm2_text);
                    TextView text3 = (TextView)findViewById(R.id.rm3_text);
                    TextView text5 = (TextView)findViewById(R.id.rm5_text);
                    TextView text7 = (TextView)findViewById(R.id.rm7_text);
                    TextView text8 = (TextView)findViewById(R.id.rm8_text);
                    TextView text10 = (TextView)findViewById(R.id.rm10_text);
                    TextView text12 = (TextView)findViewById(R.id.rm12_text);
                    TextView text15 = (TextView)findViewById(R.id.rm15_text);
                    TextView text20 = (TextView)findViewById(R.id.rm20_text);

                    text1.setText(s_x[1-1]);
                    text2.setText(s_x[2-1]);
                    text3.setText(s_x[3-1]);
                    text5.setText(s_x[5-1]);
                    text7.setText(s_x[7-1]);
                    text8.setText(s_x[8-1]);
                    text10.setText(s_x[10-1]);
                    text12.setText(s_x[12-1]);
                    text15.setText(s_x[15-1]);
                    text20.setText(s_x[20-1]);

                   /* switch(s_reps){
                        case "1":text1.setText(s_weight);break;
                        case "2":text2.setText(s_weight);break;
                        case "3":text3.setText(s_weight);break;
                        case "5":text5.setText(s_weight);break;
                        case "7":text7.setText(s_weight);break;
                        case "8":text8.setText(s_weight);break;
                        case "10":text10.setText(s_weight);break;
                        case "12":text12.setText(s_weight);break;
                        case "15":text15.setText(s_weight);break;
                        case "20":text20.setText(s_weight);break;
                    }*/
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
            TextView rm_1 = (TextView)findViewById(R.id.rm1_text);
            String s_rm_1 = rm_1.getText().toString();

            Log.d("MAIN",s_rm_1);
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
