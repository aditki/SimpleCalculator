package com.example.aditya.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;




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


        for(int i = 0; i < operation.length; i++){
            operation[i] = 0;

        }
    }




            public void onClickZero(View v) {

                if(flag == false || negative == true){

                    result.setText(result.getText() + "0");
                }
                else{
                    result.setText("0");
                    flag = false;
                }
            }

            public void onClickOne(View v) {

                if(flag == false || negative == true){

                    result.setText(result.getText() + "1");
                }
                else{
                    result.setText("1");
                    flag = false;
                }

            }

            public void onClickTwo(View v) {

                if(flag == false || negative == true){

                    result.setText(result.getText() + "2");
                }
                else{
                    result.setText("2");
                    flag = false;
                }

            }
            public void onClickThree(View v) {
                if(flag == false || negative == true){

                    result.setText(result.getText() + "3");
                }
                else{
                    result.setText("3");
                    flag = false;
                }

            }

            public void onClickFour(View v) {
                if(flag == false || negative == true){

                    result.setText(result.getText() + "4");
                }
                else{
                    result.setText("4");
                    flag = false;
                }

            }

            public void onClickFive(View v) {
                Toast.makeText(this, negative.toString(), Toast.LENGTH_SHORT).show();
                if(flag == false || negative == true){

                    result.setText(result.getText() + "5");
                }
                else{
                    result.setText("5");
                    flag = false;
                }

            }
            public void onClickSix(View v) {
                if(flag == false || negative == true){

                    result.setText(result.getText() + "6");
                }
                else{
                    result.setText("6");
                    flag = false;
                }

            }

            public void onClickSeven(View v) {
                if(flag == false || negative == true){

                    result.setText(result.getText() + "7");
                }
                else{
                    result.setText("7");
                    flag = false;
                }

            }

            public void onClickEight(View v) {
                if(flag == false || negative == true){

                    result.setText(result.getText() + "8");
                }
                else{
                    result.setText("8");
                    flag = false;
                }

            }
            public void onClickNine(View v) {
                Toast.makeText(this, negative.toString(), Toast.LENGTH_SHORT).show();
                if(flag == false || negative == true){

                    result.setText(result.getText() + "9");
                }
                else{
                    result.setText("9");
                    flag = false;
                }

            }

            public void onClickPoint(View v) {
                if(result.getText().toString().contains(".")){
                result.setText(result.getText() + "");
                }
                else{
                    result.setText(result.getText() + ".");
                }

            }

            public void onClickEquals(View v) {
                input2 = Double.parseDouble(result.getText().toString());
                double resultValue = computeCalculation(input1, input2);
                result.setText(String.valueOf(resultValue));
                negative = false;
                for (int i = 0; i < operation.length; i++){
                    operation[i] = 0;

                }

            }
            public void onClickDivide(View v) {
                input1 = Double.parseDouble(result.getText().toString());
                flag = true;
                negative = false;
                operation[0] = 1;

            }

            public void onClickMultiply(View v) {
                input1 = Double.parseDouble(result.getText().toString());
                flag = true;
                negative = false;
                operation[1] = 1;

            }

            public void onClickAdd(View v) {
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
                result.setText("");

            }




            private double computeCalculation(Double input1, Double input2) {
                double resultValue = 0;
                if(operation[0] == 1){
                    if (input2 !=0){
                    resultValue =  input1 / input2;
                    }
                    else{
                        Toast.makeText(this, "Cannot Divide by zero", Toast.LENGTH_SHORT).show();
                        result.setText("");
                    }
                }
                else if (operation[1] == 1){
                    resultValue = input1 * input2;
                }
                else if(operation[2] == 1){
                    resultValue = input1 - input2;

                }
                else if (operation[3] == 1){
                    resultValue = input1 + input2;
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
