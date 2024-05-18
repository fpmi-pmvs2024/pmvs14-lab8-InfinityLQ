package com.example.taskflagquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    SharedPreferences rePref;
    Button button1,button2,button3,button4;
    ImageView iv_flag;
    TextView textViewFeedback,textViewGuesses;
    int guesses;
    List<CountryItem> list;
    Random r;
    int turn =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rePref= getSharedPreferences("user_resultEveryone",MODE_PRIVATE);
        r=new Random();
        textViewFeedback = findViewById(R.id.textViewFeedback);
        textViewGuesses = findViewById(R.id.textViewGuesses);

        iv_flag=(ImageView) findViewById(R.id.iv_flag);
        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        button4=(Button) findViewById(R.id.button4);

        list = new ArrayList<>();

        for(int i = 0; i < new Database().answers.length; i++){
           list.add(new CountryItem(new Database().answers[i], new Database().flags[i]));
        }

        Collections.shuffle(list);
         newQuestion(turn);
        button1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                   if(button1.getText().toString().equalsIgnoreCase(list.get(turn -1).getName())){
                       textViewFeedback.setText("Correct");
                       textViewFeedback.setTextColor(Color.GREEN);
                       Toast.makeText(MainActivity.this,"Correct!",Toast.LENGTH_SHORT).show();

                       if(turn<list.size()){
                           turn++;
                           newQuestion(turn);
                       }else {
                           Toast.makeText(MainActivity.this,"You finished the game!",Toast.LENGTH_SHORT).show();
                       }
                   }else {
                       textViewFeedback.setText("Error");
                       textViewFeedback.setTextColor(Color.RED);
                       Animation shake = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
                       textViewFeedback.startAnimation(shake);
                       Toast.makeText(MainActivity.this,"Error!",Toast.LENGTH_SHORT).show();
                       //Toast.makeText(MainActivity.this,"You lost the game!",Toast.LENGTH_SHORT).show();
                       //finish();
                   }
                   guesses++;
                textViewGuesses.setText("Guesses: " + guesses);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(button2.getText().toString().equalsIgnoreCase(list.get(turn -1).getName())){
                    textViewFeedback.setText("Correct");
                    textViewFeedback.setTextColor(Color.GREEN);
                    Toast.makeText(MainActivity.this,"Correct!",Toast.LENGTH_SHORT).show();

                    if(turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }else {
                        Toast.makeText(MainActivity.this,"You finished the game!",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    textViewFeedback.setText("Error");
                    textViewFeedback.setTextColor(Color.RED);
                    Animation shake = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
                    textViewFeedback.startAnimation(shake);
                    Toast.makeText(MainActivity.this,"Error!",Toast.LENGTH_SHORT).show();
                    //Toast.makeText(MainActivity.this,"You lost the game!",Toast.LENGTH_SHORT).show();
                    //finish();
                }
                guesses++;
                textViewGuesses.setText("Guesses:" + guesses);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(button3.getText().toString().equalsIgnoreCase(list.get(turn -1).getName())){
                    textViewFeedback.setText("Correct");
                    textViewFeedback.setTextColor(Color.GREEN);
                    Toast.makeText(MainActivity.this,"Correct!",Toast.LENGTH_SHORT).show();

                    if(turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }else {
                        Toast.makeText(MainActivity.this,"You finished the game!",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    textViewFeedback.setText("Error");
                    textViewFeedback.setTextColor(Color.RED);
                    Animation shake = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
                    textViewFeedback.startAnimation(shake);
                    Toast.makeText(MainActivity.this,"Error!",Toast.LENGTH_SHORT).show();
                    //Toast.makeText(MainActivity.this,"You lost the game!",Toast.LENGTH_SHORT).show();
                    //finish();
                }
                guesses++;
                textViewGuesses.setText("Guesses:" + guesses);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(button4.getText().toString().equalsIgnoreCase(list.get(turn -1).getName())){
                    textViewFeedback.setText("Correct");
                    textViewFeedback.setTextColor(Color.GREEN);
                    Toast.makeText(MainActivity.this,"Correct!",Toast.LENGTH_SHORT).show();

                    if(turn<list.size()){
                        turn++;
                        newQuestion(turn);
                    }else {
                        Toast.makeText(MainActivity.this,"You finished the game!",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    textViewFeedback.setText("Error");
                    textViewFeedback.setTextColor(Color.RED);
                    Animation shake = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
                    textViewFeedback.startAnimation(shake);
                    Toast.makeText(MainActivity.this,"Error!",Toast.LENGTH_SHORT).show();
                    //Toast.makeText(MainActivity.this,"You lost the game!",Toast.LENGTH_SHORT).show();
                    //finish();
                }
                guesses++;
                textViewGuesses.setText("Guesses:" + guesses);
            }
        });
    }
     private  void newQuestion(int number){
     iv_flag.setImageResource(list.get(number -1 ).getImage());
     int correct_answer =r.nextInt(4)+1;
     int firstButton = number-1;
     int secondButton;
     int thirdButton;
     int forthButton;


     switch (correct_answer){
         case 1:
             button1.setText(list.get(firstButton).getName());
             do{
                 secondButton=r.nextInt(list.size());
             }while (secondButton==firstButton);
             do{
                 thirdButton=r.nextInt(list.size());
             }while (thirdButton==firstButton || thirdButton==secondButton);
             do{
                 forthButton=r.nextInt(list.size());
             }while (forthButton==firstButton || forthButton==secondButton || forthButton==thirdButton);

             button2.setText(list.get(secondButton).getName());
             button3.setText(list.get(thirdButton).getName());
             button4.setText(list.get(forthButton).getName());
             break;
         case 2:
             button2.setText(list.get(firstButton).getName());
             do{
                 secondButton  =r.nextInt(list.size());
             }while (secondButton ==  firstButton);
             do{
                 thirdButton=r.nextInt(list.size());
             }while (thirdButton==firstButton || thirdButton==secondButton);
             do{
                 forthButton=r.nextInt(list.size());
             }while (forthButton==firstButton || forthButton==secondButton || forthButton==thirdButton);

             button1.setText(list.get(secondButton).getName());
             button3.setText(list.get(thirdButton).getName());
             button4.setText(list.get(forthButton).getName());
             break;
         case 3:
             button3.setText(list.get(firstButton).getName());
             do{
                 secondButton=r.nextInt(list.size());
             }while (secondButton==firstButton);
             do{
                 thirdButton=r.nextInt(list.size());
             }while (thirdButton==firstButton || thirdButton==secondButton);
             do{
                 forthButton=r.nextInt(list.size());
             }while (forthButton==firstButton || forthButton==secondButton || forthButton==thirdButton);

             button2.setText(list.get(secondButton).getName());
             button1.setText(list.get(thirdButton).getName());
             button4.setText(list.get(forthButton).getName());
             break;
         case 4:
             button4.setText(list.get(firstButton).getName());
             do{
                 secondButton=r.nextInt(list.size());
             }while (secondButton==firstButton);
             do{
                 thirdButton=r.nextInt(list.size());
             }while (thirdButton==firstButton || thirdButton==secondButton);
             do{
                 forthButton=r.nextInt(list.size());
             }while (forthButton==firstButton || forthButton==secondButton || forthButton==thirdButton);

             button2.setText(list.get(secondButton).getName());
             button3.setText(list.get(thirdButton).getName());
             button1.setText(list.get(forthButton).getName());
             break;
     }
    }

}