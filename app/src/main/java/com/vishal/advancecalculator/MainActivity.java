package com.vishal.advancecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Calculator fragment1Action;
    TipCalculator fragment2Action;
    BmiCalculator fragment3Action;
    Spinner spinner;
    List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=findViewById(R.id.spinner);
        fragment1Action=new Calculator();
        fragment2Action=new TipCalculator();
        fragment3Action=new BmiCalculator();
        names=new ArrayList<>();
        names.add("Calculator");
        names.add("Tip Calculator");
        names.add("Bmi Calculator");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(MainActivity.this,R.layout.item,names);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        selectFragment(fragment1Action);
                        break;
                    case 1:
                        selectFragment(fragment2Action);
                        break;
                    case 2:
                        selectFragment(fragment3Action);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void selectFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}