package com.example.lap3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SecActivity extends AppCompatActivity {

    private EditText height,weight;
    private float h = 170,w = 70;
    private Button btnResult;
    private Button HSub,HAdd,WSub,WAdd;
    private TextView textResult,TextDicler;
    private int currentProgress = 0;
    private ProgressBar progress;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        btnResult = findViewById(R.id.btnResult);
        textResult = findViewById(R.id.textResult);
        progress = findViewById(R.id.progress);
        TextDicler = findViewById(R.id.TextDicler);
        HSub = findViewById(R.id.HSub);
        HAdd = findViewById(R.id.HAdd);
        WSub = findViewById(R.id.WSub);
        WAdd = findViewById(R.id.WAdd);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h = Float.parseFloat(height.getText().toString());
                w = Float.parseFloat(weight.getText().toString());
                float BMI = (w / h / h  ) * 10000;
                textResult.setText(String.format("%.2f",BMI));

                currentProgress = (int)BMI;
                progress.setProgress(currentProgress);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    progress.setMin(15);
                }
                progress.setMax(30);

                if (BMI <18.5){
                    //must add word of the meaning(Under Weight)
                    TextDicler.setText("Under Weight");
                    TextDicler.setTextColor(Color.BLUE);
                    progress.setProgressBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                    progress.getProgressDrawable().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
                }
                else if (BMI >= 18.5 && BMI < 25) {
                    //Normal
                    TextDicler.setText("Normal");
                    TextDicler.setTextColor(Color.GREEN);
                    progress.setProgressBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    progress.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);

                }
                else if (BMI >= 25 && BMI < 30){
                    //over Weight
                    TextDicler.setText("Over Weight");
                    TextDicler.setTextColor(Color.YELLOW);
                    progress.setProgressBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
                    progress.getProgressDrawable().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
                }
                else if (BMI >= 30){
                    //obese
                    TextDicler.setText("Obese");
                    TextDicler.setTextColor(Color.RED);
                    progress.setProgressBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    progress.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
                }

            }
        });

        HSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h--;
                height.setText(Float.toString(h));

            }
        });

        HAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h++;
                height.setText(Float.toString(h));

            }
        });

        WSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w--;
                weight.setText(Float.toString(w));

            }
        });

        WAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w++;
                weight.setText(Float.toString(w));

            }
        });
    }
}