package com.example.aditya.homework1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;




public class MainActivity extends AppCompatActivity {
    Double input1 = 0.0;
    Double input2 = 0.0;
    Boolean flag = false;
    Boolean negative = false;
    TextView result;
    Button zero, one, two, three, four, five, six, seven, eight, nine, point, equals, divided, multiplied, plus, minus, clear;
    int[] operation = new int[4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.txtInput);
        zero = (Button) findViewById(R.id.btnZero);
        one = (Button) findViewById(R.id.btnOne);
        two = (Button) findViewById(R.id.btnTwo);
        three = (Button) findViewById(R.id.btnThree);
        four = (Button) findViewById(R.id.btnFour);
        five = (Button) findViewById(R.id.btnFive);
        six = (Button) findViewById(R.id.btnSix);
        seven = (Button) findViewById(R.id.btnSeven);
        eight = (Button) findViewById(R.id.btnEight);
        nine = (Button) findViewById(R.id.btnNine);
        point = (Button) findViewById(R.id.btnDecimal);
        equals = (Button) findViewById(R.id.btnEquals);
        divided= (Button) findViewById(R.id.btnDivide);
        multiplied = (Button) findViewById(R.id.btnMultiply);
        plus = (Button) findViewById(R.id.btnAdd);
        minus = (Button) findViewById(R.id.btnSubtract);
        clear = (Button) findViewById(R.id.btnClear);

        result.setText("0");
        for(int i = 0; i < operation.length; i++){
            operation[i] = 0;

        }
    }
            public void onClickNumber(int number){
                String resultValue = result.getText().toString();

                if(resultValue.equals("Error")){
                    resultValue = "0";
                }
                if(flag == false || negative == true){
                    result.setText(resultValue + Integer.toString(number));
                }
                else{
                    result.setText(Integer.toString(number));
                    flag = false;
                }

            }



            public void onClickZero(View v) {
                onClickNumber(0);
            }

            public void onClickOne(View v) {
                onClickNumber(1);
            }

            public void onClickTwo(View v) {
                onClickNumber(2);
            }

            public void onClickThree(View v) {
                onClickNumber(3);
            }

            public void onClickFour(View v) {
                onClickNumber(4);
            }

            public void onClickFive(View v) {
                onClickNumber(5);
            }

            public void onClickSix(View v) {
                onClickNumber(6);
            }

            public void onClickSeven(View v) {
                onClickNumber(7);
            }

            public void onClickEight(View v) {
                onClickNumber(8);
            }

            public void onClickNine(View v) { onClickNumber(9); }

            public void onClickPoint(View v) {
                if(result.getText().toString().contains(".")){
                result.setText(result.getText() + "");
                }
                else{
                    result.setText(result.getText() + ".");
                }

            }

            public void onClickEquals(View v) {

                double resultValue = 0;
                try {
                    input2 = Double.parseDouble(result.getText().toString());
                    resultValue = computeCalculation(input1, input2);
                    int index = Double.toString(resultValue).indexOf(".");


                    if (resultValue % 1 != 0) {
                        if (Double.toString(resultValue).length() < 16) {
                            settingText(resultValue);
                        } else if (index > 14) {
                            result.setText("Error");
                        } else {
                            BigDecimal bd = new BigDecimal(resultValue);
                            bd = bd.setScale(14 - index, RoundingMode.HALF_UP);
                            result.setText(bd.stripTrailingZeros().toString());
                        }
                    } else {

                        if (Double.toString(resultValue).length() < 15) {
                            settingText(resultValue);
                        } else {
                            Log.w("value", "in error");
                            result.setText("Error");
                        }
                    }
                    negative = false;
                    for (int i = 0; i < operation.length; i++) {
                        operation[i] = 0;

                    }
                }
                catch (Exception e){
                    Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    input1 = 0.0;
                    input2 = 0.0;
                    flag = false;
                    for (int i = 0; i < operation.length; i++){
                        operation[i] = 0;

                    }
                    result.setText("");

                }

            }

            public void settingText(double resultValue){
                if (resultValue % 1 == 0){
                    result.setText(String.valueOf((int)resultValue));
                }
                else{
                    result.setText(String.valueOf(resultValue));
                }

            }
            public void onClickDivide(View v) {
                clearArray();
                input1 = Double.parseDouble(result.getText().toString());
                flag = true;
                negative = false;
                operation[0] = 1;

            }

            public void onClickMultiply(View v) {
                clearArray();
                input1 = Double.parseDouble(result.getText().toString());
                flag = true;
                negative = false;
                operation[1] = 1;

            }

            public void onClickAdd(View v) {
                clearArray();
                input1 = Double.parseDouble(result.getText().toString());
                flag = true;
                negative = false;
                operation[3] = 1;

            }
            public void onClickSubtract(View v) {
                if(result.getText().toString().isEmpty() || contains(operation, 1)){
                    result.setText("-");
                    negative = true;
                }

                else{
                    input1 = Double.parseDouble(result.getText().toString());
                    flag = true;
                    negative = false;
                    operation[2] = 1;
                }

            }

            public void onClickClear(View v) {
                input1 = 0.0;
                input2 = 0.0;
                flag = false;
                for (int i = 0; i < operation.length; i++){
                    operation[i] = 0;

                }
                result.setText("0");

            }

            public void clearArray(){
                for (int i = 0; i < operation.length; i++){
                    operation[i] = 0;

                }
            }




            private double computeCalculation(Double input1, Double input2) {
                double resultValue = 0;
                try {
                    if (operation[0] == 1) {
                        if (input2 != 0) {
                            resultValue = input1 / input2;

                        } else {
                            Toast.makeText(this, "Cannot Divide by zero", Toast.LENGTH_SHORT).show();
                            result.setText("");
                        }

                    } else if (operation[1] == 1) {
                        resultValue = input1 * input2;
                    } else if (operation[2] == 1) {
                        resultValue = input1 - input2;

                    } else if (operation[3] == 1) {
                        resultValue = input1 + input2;

                    }


                }
                catch (Exception e){
                    Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
                return resultValue;
            }



            public static boolean contains(final int[] array, final int v) {

                boolean result = false;

                for(int i : array){
                if(i == v){
                    result = true;
                    break;
                    }
                }

            return result;
            }




}
