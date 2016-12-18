package com.yamada.allrmprogram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static int send_weight = 0;
    static int send_reps = 0;

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
                    //MAX重量）＝（使用重量）×｛１＋（Reps／33.3）｝
                    double rm1 = 0;
                    rm1 = i_weight * (reps + 33.3) / 33.3;

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

        final Button button = (Button)findViewById(R.id.re_button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(view == button){
                    Intent intent = new Intent(MainActivity.this,SubActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    //TextView押下時の挙動チェック
    public void RM1_OnClick(View view){
        EditText edit = (EditText)findViewById(R.id.editText);
        if(edit.length()!=0) {
            TextView rm_1 = (TextView)findViewById(R.id.rm1_text);
            String s_rm_1 = rm_1.getText().toString();
            int i_rm_1 = Integer.parseInt(s_rm_1);

            Intent intent = new Intent(MainActivity.this,SubActivity.class);
            intent.putExtra("weight", i_rm_1);
            intent.putExtra("reps", 1);

            startActivity(intent);
        }
        else{
            toast("重量を入力してください");
        }
    }

    public void RM2_OnClick(View view){
        EditText edit = (EditText)findViewById(R.id.editText);
        if(edit.length()!=0) {
            TextView rm_2 = (TextView)findViewById(R.id.rm2_text);
            String s_rm_2 = rm_2.getText().toString();
            int i_rm_2 = Integer.parseInt(s_rm_2);

            Intent intent = new Intent(MainActivity.this,SubActivity.class);
            intent.putExtra("weight", i_rm_2);
            intent.putExtra("reps", 2);
            startActivity(intent);
        }
        else{
            toast("重量を入力してください");
        }
    }

    public void RM3_OnClick(View view){
        EditText edit = (EditText)findViewById(R.id.editText);
        if(edit.length()!=0) {
            TextView rm_3 = (TextView)findViewById(R.id.rm3_text);
            String s_rm_3 = rm_3.getText().toString();
            int i_rm_3 = Integer.parseInt(s_rm_3);

            Intent intent = new Intent(MainActivity.this,SubActivity.class);
            intent.putExtra("weight", i_rm_3);
            intent.putExtra("reps", 3);
            startActivity(intent);
        }
        else{
            toast("重量を入力してください");
        }
    }

    public void RM5_OnClick(View view){
        EditText edit = (EditText)findViewById(R.id.editText);
        if(edit.length()!=0) {
            TextView rm_5 = (TextView)findViewById(R.id.rm5_text);
            String s_rm_5 = rm_5.getText().toString();
            int i_rm_5 = Integer.parseInt(s_rm_5);

            Intent intent = new Intent(MainActivity.this,SubActivity.class);
            intent.putExtra("weight", i_rm_5);
            intent.putExtra("reps", 5);
            startActivity(intent);
        }
        else{
            toast("重量を入力してください");
        }
    }

    public void RM7_OnClick(View view){
        EditText edit = (EditText)findViewById(R.id.editText);
        if(edit.length()!=0) {
            TextView rm_7 = (TextView)findViewById(R.id.rm7_text);
            String s_rm_7 = rm_7.getText().toString();
            int i_rm_7 = Integer.parseInt(s_rm_7);

            Intent intent = new Intent(MainActivity.this,SubActivity.class);
            intent.putExtra("weight", i_rm_7);
            intent.putExtra("reps", 7);
            startActivity(intent);
        }
        else{
            toast("重量を入力してください");
        }
    }

    public void RM8_OnClick(View view){
        EditText edit = (EditText)findViewById(R.id.editText);
        if(edit.length()!=0) {
            TextView rm_8 = (TextView)findViewById(R.id.rm8_text);
            String s_rm_8 = rm_8.getText().toString();
            int i_rm_8 = Integer.parseInt(s_rm_8);

            Intent intent = new Intent(MainActivity.this,SubActivity.class);
            intent.putExtra("weight", i_rm_8);
            intent.putExtra("reps", 8);
            startActivity(intent);
        }
        else{
            toast("重量を入力してください");
        }
    }

    public void RM10_OnClick(View view){
        EditText edit = (EditText)findViewById(R.id.editText);
        if(edit.length()!=0) {
            TextView rm_10 = (TextView)findViewById(R.id.rm10_text);
            String s_rm_10 = rm_10.getText().toString();
            int i_rm_10 = Integer.parseInt(s_rm_10);

            Intent intent = new Intent(MainActivity.this,SubActivity.class);
            intent.putExtra("weight", i_rm_10);
            intent.putExtra("reps", 10);
            startActivity(intent);
        }
        else{
            toast("重量を入力してください");
        }
    }

    public void RM12_OnClick(View view){
        EditText edit = (EditText)findViewById(R.id.editText);
        if(edit.length()!=0) {
            TextView rm_12 = (TextView)findViewById(R.id.rm12_text);
            String s_rm_12 = rm_12.getText().toString();
            int i_rm_12 = Integer.parseInt(s_rm_12);

            Intent intent = new Intent(MainActivity.this,SubActivity.class);
            intent.putExtra("weight", i_rm_12);
            intent.putExtra("reps", 12);
            startActivity(intent);
        }
        else{
            toast("重量を入力してください");
        }
    }

    public void RM15_OnClick(View view){
        EditText edit = (EditText)findViewById(R.id.editText);
        if(edit.length()!=0) {
            TextView rm_15 = (TextView)findViewById(R.id.rm15_text);
            String s_rm_15 = rm_15.getText().toString();
            int i_rm_15 = Integer.parseInt(s_rm_15);

            Intent intent = new Intent(MainActivity.this,SubActivity.class);
            intent.putExtra("weight", i_rm_15);
            intent.putExtra("reps", 15);
            startActivity(intent);
        }
        else{
            toast("重量を入力してください");
        }
    }

    public void RM20_OnClick(View view){
        EditText edit = (EditText)findViewById(R.id.editText);
        if(edit.length()!=0) {
            TextView rm_20 = (TextView)findViewById(R.id.rm20_text);
            String s_rm_20 = rm_20.getText().toString();
            int i_rm_20 = Integer.parseInt(s_rm_20);

            Intent intent = new Intent(MainActivity.this,SubActivity.class);
            intent.putExtra("weight", i_rm_20);
            intent.putExtra("reps", 20);
            startActivity(intent);
        }
        else{
            toast("重量を入力してください");
        }
    }

    public void toast(String message){
        Toast toast = Toast.makeText(this,message,Toast.LENGTH_SHORT);
        toast.show();
    }

}
