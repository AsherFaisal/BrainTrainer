package com.example.asher.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    CountDownTimer timer = new CountDownTimer(30000, 1000){
        public void onTick(long m){
            TextView timerView =(TextView)findViewById(R.id.timerView);
            timerView.setText(String.valueOf(m/1000)+ "s");
        }
        public void onFinish(){

        }
    };

    Button goButton;
    TextView result;
    TextView scoreView;

    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locateAns, score, numOfQuestions;


    public void chooseAns(View view){
        if(Integer.toString(locateAns).equals(view.getTag().toString())){
            result.setText("Correct!");
        }else
            result.setText("Wrong");

        numOfQuestions++;
        scoreView.setText(Integer.toString(score)+ "/" + Integer.toString(numOfQuestions));
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView question = findViewById(R.id.questionView);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);


        Random rand = new Random();

        // Correct sum
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        int sum = a + b;


        question.setText(Integer.toString(a)+ " + " + Integer.toString(b));

        locateAns = rand.nextInt(4);

        for (int i =0; i<4; i++){
            if (i==locateAns){
                answers.add(a+b);
            } else {
                int wrongAns = rand.nextInt(41);

                while (wrongAns == a+b){
                    wrongAns = rand.nextInt(41);
                }
                answers.add(wrongAns);
            }
        }

        button1.setText(Integer.toString(answers.get(0)));
        button2.setText(Integer.toString(answers.get(1)));
        button3.setText(Integer.toString(answers.get(2)));
        button4.setText(Integer.toString(answers.get(3)));
        result = findViewById(R.id.resultView);
        scoreView = findViewById(R.id.pointsView);

    }
}
