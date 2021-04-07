package com.vishal.advancecalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class BmiCalculator extends Fragment {

    EditText ages,heights,weights;
    TextView res;
    Button calc;
    RadioButton male,female;
    int gen=0;  // 1 for male && 0 for female
    String ans="";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_bmi_calculator, container, false);

        ages=view.findViewById(R.id.editTextAge);
        heights=view.findViewById(R.id.editTextHeight);
        weights=view.findViewById(R.id.editTextWeight);
        calc=view.findViewById(R.id.calc);
        res=view.findViewById(R.id.result);
        male=view.findViewById(R.id.male);
        female=view.findViewById(R.id.female);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float height=Float.parseFloat(heights.getText().toString());
                float weight=Float.parseFloat(weights.getText().toString());

                float bmi=weight/(height*height);

                if(bmi<16){
                    ans="Severe Thinness";
                }else if(bmi>=16&&bmi<=17){
                    ans="Moderate Thinness";
                }else if(bmi>17&&bmi<=18.5){
                    ans="Mild Thinness";
                }else if(bmi>18.5&&bmi<25){
                    ans="fit and fine";
                }else if(bmi>=25&&bmi<30){
                    ans="Overweight";
                }else if(bmi>=30&&bmi<=35){
                    ans="Obese Class I";
                }else if(bmi>35&&bmi<=40){
                    ans="Obese Class II";
                }
                else
                    ans="Obese Class III";

                res.setText("Your BMI is "+bmi+"\nYou are "+ans);
            }
        });


        return view;
    }
    public void onRadioButtonClicked(View v){
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        switch (v.getId()) {
            case R.id.male:
                // set female button to unchecked
                gen=1;
                female.setChecked(!checked);
                break;
            case R.id.female:
                // set Male button to unchecked
                gen=0;
                male.setChecked(!checked);
                break;
        }
    }
}