package com.arindam.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.arindam.service.CalculateService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.arindam.calculator.HISTORY";


    String buffer ="";

    List<String> history = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v){

        Button button ;
        String message =null;


        if (v != null) {
            final int id = v.getId();

            switch (id) {
                case R.id.button0:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    display(message);
                    break;
                case R.id.button1:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    display(message);
                    break;
                case R.id.button2:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    display(message);
                    break;
                case R.id.button3:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    display(message);
                    break;
                case R.id.button4:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    display(message);
                    break;
                case R.id.button5:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    display(message);
                    break;
                case R.id.button6:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    display(message);
                    break;
                case R.id.button7:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    display(message);
                    break;
                case R.id.button8:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    display(message);
                    break;
                case R.id.button9:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    display(message);
                    break;
                case R.id.buttonL:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    message=" "+message+" ";
                    display(message);
                    break;
                case R.id.buttonR:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    message=" "+message+" ";
                    display(message);
                    break;
                case R.id.buttonPlus:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    message=" "+message+" ";
                    display(message);
                    break;
                case R.id.buttonMinus:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    message=" "+message+" ";
                    display(message);
                    break;
                case R.id.buttonMulti:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    message=" "+message+" ";
                    display(message);
                    break;
                case R.id.buttonDiv:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    message=" "+message+" ";
                    display(message);
                    break;
                case R.id.buttonPoint:
                    button = (Button) findViewById(id);
                    message = button.getText().toString();
                    display(message);
                    break;

            }
        }

    }


    private void display(String temp){
        buffer=buffer+temp;
        TextView cal_text = (TextView)findViewById(R.id.textView);
        cal_text.setText(buffer);

    }


    public void evaluate (View view_text){
        TextView cal_text = (TextView)findViewById(R.id.textView);
          if(buffer.isEmpty()){
              cal_text.setText("Please give some inputs");
          }
        else {
              try{

                  //Calling the Calculate Service

                  CalculateService cs = new CalculateService();
                  BigDecimal result ;

                  result=cs.execute(buffer.trim());

                  if(history.size()==20){


                          history.remove(0);
                          history.add(buffer+"="+result);
                  }
                  else {
                      history.add(buffer+"="+result);
                  }

                  cal_text.setText("Result : "+result);

                  buffer="";



              }
              catch (Exception e){
                  cal_text.setText("Wrong Input");
              }

          }

    }

    public void history (View view_history){

        /*Intent intent = new Intent(this, DisplayHistoryActivity.class);
       // intent.putStringArrayListExtra(EXTRA_MESSAGE, (ArrayList<String>) history);
        intent.putExtra(EXTRA_MESSAGE,"Arindam");
        startActivity(intent);*/

        Intent i = new Intent(this,DisplayHistoryActivity.class);
        i.putExtra("key", (ArrayList<String>)history);
        startActivity(i);
    }

    public void clear (View view_text){
        TextView cal_text = (TextView)findViewById(R.id.textView);

            buffer="";

            cal_text.setText(buffer);

    }



}
