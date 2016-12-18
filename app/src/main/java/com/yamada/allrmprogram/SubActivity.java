package com.yamada.allrmprogram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by yamada-PC on 2016/12/18.
 */

public class SubActivity extends Activity {

    int weight = 0;
    int reps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        weight = intent.getIntExtra("weight",0);
        reps = intent.getIntExtra("reps",0);

        String s_weight = String.valueOf(weight);
        String s_reps = String.valueOf(reps);

        TextView check_weight = (TextView)findViewById(R.id.check_weight);
        TextView check_reps = (TextView)findViewById(R.id.check_reps);

        check_weight.setText(s_weight);
        check_reps.setText(s_reps);

        Button button = (Button)findViewById(R.id.back_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
