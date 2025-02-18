package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuestionActivity extends AppCompatActivity {
String questions[]={
        "Who is the father of C language?",
        "Which of the following is not a valid C variable name?",
        "All keywords in C are in ___________",
        "Which of the following is true for variable names in C?",
        "Which is valid C expression?"
};
String answer[]={
        "Dennis Ritchie",
        "int $main;",
        "LowerCase letters",
        "Variable names cannot start with a digit",
        "int my_num = 100000;"
};
String opt[]={
        "Steve Jobs","James Gosling","Dennis Ritchie","Rasmus Lerdorf",
        "int $main;","int number;","float rate;","int variable_count;",
        " LowerCase letters","UpperCase letters","CamelCase letters","None of the mentioned",
        "They can contain alphanumeric characters as well as special characters"," It is not an error to declare a variable to be one of the keywords(like goto, static)","Variable names cannot start with a digit","Variable can be of any length",
        "int my_num = 100000;","int my_num = 100,000;","int my num = 1000;"," int $my_num = 10000;"
};

int flag=0;

public static int marks=0,correct=0,wrong=0;



TextView tv;
Button submitbutton,quitbutton;
RadioGroup radio_g;
RadioButton rb1,rb2,rb3,rb4;
private TextView questionnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        final TextView score=(TextView)findViewById(R.id.textview4);
        TextView textview =(TextView)findViewById(R.id.DispName);
        Intent intent=new Intent();

        questionnumber=findViewById(R.id.DispName);
        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView)findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answergrp);
        rb1=(RadioButton)findViewById(R.id.radiobutton1);
        rb2=(RadioButton)findViewById(R.id.radiobutton2);
        rb3=(RadioButton)findViewById(R.id.radiobutton3);
        rb4=(RadioButton)findViewById(R.id.radiobutton4);


        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_g.getCheckedRadioButtonId()==-1){
                    Toast.makeText(QuestionActivity.this, "Please Select One Option", Toast.LENGTH_SHORT).show();
                return;
                }
                RadioButton uans=(RadioButton)findViewById(radio_g.getCheckedRadioButtonId());
                String ansText=uans.getText().toString();

                if(ansText.equals((answer[flag]))){
                    correct++;
                    Toast.makeText(QuestionActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else{
                    wrong++;
                    Toast.makeText(QuestionActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                }
                flag++;
                if(score!=null){
                    score.setText(""+correct);

                    if(flag<questions.length){
                        tv.setText(questions[flag]);
                        rb1.setText(opt[flag*4]);
                        rb2.setText(opt[flag*4+1]);
                        rb3.setText(opt[flag*4+2]);
                        rb4.setText(opt[flag*4+3]);
                        questionnumber.setText(flag+"/"+questions.length+"Question");
                    }
                    else{
                        marks=correct;
                        Intent in=new Intent(QuestionActivity.this,ResultActivity.class);
                        startActivity(in);
                    }

                    radio_g.clearCheck();
                }
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent1);
            }
        });







    }
}