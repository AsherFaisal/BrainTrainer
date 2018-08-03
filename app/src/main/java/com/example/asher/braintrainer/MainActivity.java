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

    TextView result, scoreView, question;
    Button button1, button2, button3, button4, play;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locateAns, score, numOfQuestions;

    public void playAgain(){
        score =0;
        numOfQuestions=0;

        CountDownTimer timer = new CountDownTimer(30000, 1000){
            public void onTick(long m){
                TextView timerView =(TextView)findViewById(R.id.timerView);
                timerView.setText(String.valueOf(m/1000)+ "s");
            }
            public void onFinish(){
                play.setVisibility(View.VISIBLE);
                result.setText("Times UP!");
            }
        };

        timer.start();


    }

    public void chooseAns(View view){
        if(Integer.toString(locateAns).equals(view.getTag().toString())){
            result.setText("Correct!");
            nextQuestion();
            score++;
        }else {
            result.setText("Incorrect");
            nextQuestion();
        }
        numOfQuestions++;
        scoreView.setText(Integer.toString(score)+ "/" + Integer.toString(numOfQuestions));
    }

    public void nextQuestion (){
        Random rand = new Random();

        // Correct sum
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);


        question.setText(Integer.toString(a)+ " + " + Integer.toString(b));

        locateAns = rand.nextInt(4);
        answers.clear();

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
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = findViewById(R.id.questionView);
        result = findViewById(R.id.resultView);
        scoreView = findViewById(R.id.pointsView);
        play = findViewById(R.id.play);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        nextQuestion();

        playAgain();


    }
}
