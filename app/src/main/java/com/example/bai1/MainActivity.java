package com.example.bai1;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    Button btnShow;
    RadioButton btnchn,btnle,btncp;
    RadioGroup rg;
    EditText songuyen;
    TextView tv;
    ArrayList<String> dayso;
    ArrayAdapter adapter;
    ListView lv;
    Context context;
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        dayso = new ArrayList<>();
        connectView();
    }

    private void connectView() {
        rg= findViewById(R.id.grop);
        btnShow = findViewById(R.id.btnshow);
        btnchn = findViewById(R.id.radioButton);
        btnle = findViewById(R.id.radioButton2);
        btncp = findViewById(R.id.radioButton3);
        songuyen = findViewById(R.id.editTextText);
        tv = findViewById(R.id.textView);
        lv= findViewById(R.id.dmm);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                onRadioButtonClicked(checkedId);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,dayso);
                lv.setAdapter(adapter);
            }
        });
    }

    private void onRadioButtonClicked(int checkedId) {
        if(checkedId == R.id.radioButton)duyetsochn();
        else if(checkedId == R.id.radioButton2)duyetsole();
        else if(checkedId == R.id.radioButton3)duyetsocp();
    }

    private void duyetsocp() {
        String x = songuyen.getText().toString();
        kiemtrasonguyen(x);
        dayso.clear();
        for(int i = 0; i*i <= number; i++){
                dayso.add(i*i + "");
        }
    }

    private void duyetsole() {
        dayso.clear();
        String x = songuyen.getText().toString();
        kiemtrasonguyen(x);
        for(int i = 0; i < number; i++){
            if(i % 2 != 0){
                dayso.add(i + "");
            }
        }
    }

    private void duyetsochn() {
        dayso.clear();
        String x = songuyen.getText().toString();
        kiemtrasonguyen(x);
        for(int i = 0; i < number; i++){
            if(i % 2 == 0){
                dayso.add(i + "");
            }
        }
    }

    private void kiemtrasonguyen(String x) {
        String pattern = "^\\d+$";
        if (x.matches(pattern)) {
            number = Integer.parseInt(x);

        }else{
            tv.setText("Khong hop le, so nguyen co mak????" );
        }
    }


}