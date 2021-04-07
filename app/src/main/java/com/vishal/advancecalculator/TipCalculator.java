package com.vishal.advancecalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class TipCalculator extends Fragment {

    TextView showTip;
    EditText costOfService;
    RadioGroup radioGroup;
    Button calc;
    Switch toggle;
    float tip=0;
    int ctr=0;
    double ftip;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tip_calculator, container, false);



        costOfService=view.findViewById(R.id.cost_of_service);

        radioGroup=view.findViewById(R.id.tip_options);
        calc=view.findViewById(R.id.calculate_button);
        toggle = (Switch) view.findViewById(R.id.round_up_switch);
        showTip=view.findViewById(R.id.showTip);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ctr=1;
                } else {
                    ctr=0;
                }
            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=costOfService.getText().toString();
                float val=Float.parseFloat(s);

                int radioId=radioGroup.getCheckedRadioButtonId();
                switch(radioId){
                    case R.id.option_twenty_percent:
                        tip=val*20/100;
                        break;
                    case R.id.option_eighteen_percent:
                        tip=val*18/100;
                        break;
                    case R.id.option_fifteen_percent:
                        tip=val*15/100;
                        break;
                }
                if(ctr==1){
                    ftip=(int)tip+1;
                    showTip.setText(String.valueOf(ftip));
                }else{
                    showTip.setText(String.valueOf(tip));
                }



            }
        });







        return view;
    }
}