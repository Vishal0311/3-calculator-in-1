package com.vishal.advancecalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


public class Calculator extends Fragment {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAdd,btnSub,btnMul,btnDiv,btnEqual,btnClear,btnDot;

    EditText ans;
    float valueOne,valueTwo;
    boolean add,sub,mul,div;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_calculator, container, false);

        btn0=(Button)view.findViewById(R.id.btn0);
        btn1=(Button)view.findViewById(R.id.btn1);
        btn2=(Button)view.findViewById(R.id.btn2);
        btn3=(Button)view.findViewById(R.id.btn3);
        btn4=(Button)view.findViewById(R.id.btn4);
        btn5=(Button)view.findViewById(R.id.btn5);
        btn6=(Button)view.findViewById(R.id.btn6);
        btn7=(Button)view.findViewById(R.id.btn7);
        btn8=(Button)view.findViewById(R.id.btn8);
        btn9=(Button)view.findViewById(R.id.btn9);
        btnAdd=(Button)view.findViewById(R.id.btnAdd);
        btnSub=(Button)view.findViewById(R.id.btnSub);
        btnMul=(Button)view.findViewById(R.id.btnMul);
        btnDiv=(Button)view.findViewById(R.id.btnDiv);
        btnEqual=(Button)view.findViewById(R.id.btnEqual);
        btnClear=(Button)view.findViewById(R.id.btnClear);
        btnDot=(Button)view.findViewById(R.id.btnDot);
        ans=(EditText)view.findViewById(R.id.ans);

        btn0.setOnClickListener(v -> ans.setText(ans.getText()+"0"));
        btn1.setOnClickListener(v -> ans.setText(ans.getText()+"1"));
        btn2.setOnClickListener(v -> ans.setText(ans.getText()+"2"));
        btn3.setOnClickListener(v -> ans.setText(ans.getText()+"3"));
        btn4.setOnClickListener(v -> ans.setText(ans.getText()+"4"));
        btn5.setOnClickListener(v -> ans.setText(ans.getText()+"5"));
        btn6.setOnClickListener(v -> ans.setText(ans.getText()+"6"));
        btn7.setOnClickListener(v -> ans.setText(ans.getText()+"7"));
        btn8.setOnClickListener(v -> ans.setText(ans.getText()+"8"));
        btn9.setOnClickListener(v -> ans.setText(ans.getText()+"9"));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans==null){
                    ans.setText("");
                }else{
                    valueOne=Float.parseFloat(ans.getText()+"");
                    add=true;
                    ans.setText(null);
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne=Float.parseFloat(ans.getText()+"");
                sub=true;
                ans.setText(null);
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne=Float.parseFloat(ans.getText()+"");
                mul=true;
                ans.setText(null);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne=Float.parseFloat(ans.getText()+"");
                div=true;
                ans.setText(null);
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueTwo=Float.parseFloat(ans.getText()+"");
                if(add){
                    ans.setText(valueOne+valueTwo+"");
                    add=false;
                }
                if(sub){
                    ans.setText(valueOne-valueTwo+"");
                    sub=false;
                }
                if(mul){
                    ans.setText(valueOne*valueTwo+"");
                    mul=false;
                }
                if(div){
                    ans.setText(valueOne/valueTwo+"");
                    div=false;
                }

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText("");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText(ans.getText()+".");
            }
        });
        return view;
    }
}