package com.example.lap3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class FirstActivity extends AppCompatActivity {

    private TextView txtRslt;
    private Button btnAdd, btnSub, btnMul, btnDiv, btnClear, btnAns;
    private Button one, tow, three, four, five, six, seven, eight, nine, zero;
    private String exp = "";
    private  boolean Symbol = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //the addition code
        txtRslt = (TextView) findViewById(R.id.txtResult);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnClear = (Button) findViewById(R.id.btnClear);
        //my work
        btnAns = (Button) findViewById(R.id.btnAns);
        zero = (Button) findViewById(R.id.btnNum0);
        one = (Button) findViewById(R.id.btnNum1);
        tow = (Button) findViewById(R.id.btnNum2);
        three = (Button) findViewById(R.id.btnNum3);
        four = (Button) findViewById(R.id.btnNum4);
        five = (Button) findViewById(R.id.btnNum5);
        six = (Button) findViewById(R.id.btnNum6);
        seven = (Button) findViewById(R.id.btnNum7);
        eight = (Button) findViewById(R.id.btnNum8);
        nine = (Button) findViewById(R.id.btnNum9);


        //numbers button Listener
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp += "0";
                txtRslt.setText(exp);
                Symbol = true;
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp += "1";
                txtRslt.setText(exp);
                Symbol = true;
            }
        });
        tow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp += "2";
                txtRslt.setText(exp);
                Symbol = true;
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp += "3";
                txtRslt.setText(exp);
                Symbol = true;
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp += "4";
                txtRslt.setText(exp);
                Symbol = true;
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp += "5";
                txtRslt.setText(exp);
                Symbol = true;
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp += "6";
                txtRslt.setText(exp);
                Symbol = true;
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp += "7";
                txtRslt.setText(exp);
                Symbol = true;
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp += "8";
                txtRslt.setText(exp);
                Symbol = true;
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp += "9";
                txtRslt.setText(exp);
                Symbol = true;
            }
        });

        //using Listener
        //add
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //op1 = Float.parseFloat(editText1.getText().toString());
                //op2 = Float.parseFloat(editText2.getText().toString());
                //op3 = op1 + op2;
                //txtRslt.setText(Float.toString(op3));

                if(Symbol == true){
                    exp += "+";
                    txtRslt.setText(exp);
                    Symbol = false;
                }
                else{
                    Toast.makeText(getApplicationContext(),"expect a number",Toast.LENGTH_LONG).show();
                }

            }
        });

        //sub
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Symbol == true){
                    exp += "-";
                    txtRslt.setText(exp);
                    Symbol = false;
                }
                else{
                    Toast.makeText(getApplicationContext(),"expect a number",Toast.LENGTH_LONG).show();
                }
            }
        });

        //multi
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Symbol == true){
                    exp += "×";
                    txtRslt.setText(exp);
                    Symbol = false;
                }
                else{
                    Toast.makeText(getApplicationContext(),"expect a number",Toast.LENGTH_LONG).show();
                }
            }
        });

        //div
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Symbol == true){
                    exp += "÷";
                    txtRslt.setText(exp);
                    Symbol = false;
                }
                else{
                    Toast.makeText(getApplicationContext(),"expect a number",Toast.LENGTH_LONG).show();
                }
            }
        });

        //clear
        //Reset your input and output field for getting new inputs.
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp = "";
                txtRslt.setText(exp);
                Symbol = false;
            }
        });

        //answer button
        btnAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //string ans
                int result = evaluate(exp);

                txtRslt.setText(Float.toString(result));
                exp = Integer.toString(result);
            }

            //evaluation reference GeeksOfGeeks website
            public int evaluate(String expression) {
                char[] tokens = expression.toCharArray();

                // Stack for numbers: 'values'
                Stack<Integer> values = new Stack<Integer>();

                // Stack for Operators: 'ops'
                Stack<Character> ops = new Stack<Character>();

                for (int i = 0; i < tokens.length; i++) {

                    if (tokens[i] == ' ')
                        continue;


                    if (tokens[i] >= '0' &&
                            tokens[i] <= '9') {
                        StringBuffer sbuf = new StringBuffer();

                        while (i < tokens.length &&
                                tokens[i] >= '0' &&
                                tokens[i] <= '9')
                            sbuf.append(tokens[i++]);
                        values.push(Integer.parseInt(sbuf.toString()));
                        i--;
                    } else if (tokens[i] == '(')
                        ops.push(tokens[i]);


                    else if (tokens[i] == ')') {
                        while (ops.peek() != '(')
                            values.push(applyOp(ops.pop(),
                                    values.pop(),
                                    values.pop()));
                        ops.pop();
                    }

                    // Current token is an operator.
                    else if (tokens[i] == '+' ||
                            tokens[i] == '-' ||
                            tokens[i] == '×' ||
                            tokens[i] == '÷') {

                        while (!ops.empty() &&
                                hasPrecedence(tokens[i],
                                        ops.peek()))
                            values.push(applyOp(ops.pop(),
                                    values.pop(),
                                    values.pop()));

                        // Push current token to 'ops'.
                        ops.push(tokens[i]);
                    }
                }


                while (!ops.empty())
                    values.push(applyOp(ops.pop(),
                            values.pop(),
                            values.pop()));


                return values.pop();
            }


            public boolean hasPrecedence(
                    char op1, char op2) {
                if (op2 == '(' || op2 == ')')
                    return false;
                if ((op1 == '×' || op1 == '÷') &&
                        (op2 == '+' || op2 == '-'))
                    return false;
                else
                    return true;
            }

            public int applyOp(char op,
                               int b, int a) {
                switch (op) {
                    case '+':
                        return a + b;
                    case '-':
                        return a - b;
                    case '×':
                        return a * b;
                    case '÷':
                        if (b == 0)
                            Toast.makeText(getApplicationContext(),"Cannot divide by zero",Toast.LENGTH_LONG).show();
                        else
                        return a / b;
                }
                return 0;
            }

        });


    }
}

