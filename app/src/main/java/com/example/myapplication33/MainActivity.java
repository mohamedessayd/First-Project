package com.example.myapplication33;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button , create;
    private int TimeOfSubmit;
    EditText email , password;
    TextView view;
    CountDownTimer countDownTimer;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        email = findViewById(R.id.EmailAddress);
        password = findViewById(R.id.Password);
        create = findViewById(R.id.button2);
        this.TimeOfSubmit = 0;

        Compte compte = new Compte();
        compte.createNewCompte("mohamed" , "1234");
        compte.createNewCompte("mostafa" , "1234");
        compte.createNewCompte("ikhlas" , "1234");
        compte.createNewCompte("choughi" , "1234");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean find = false;
                String a = String.valueOf(email.getText());
                String b = String.valueOf(password.getText());
                for(int i = 0 ; i < DataBase.myComptes.size() ; i++){
                    if(DataBase.myComptes.get(i).isValidCompte(a , b)){
                        find = true;
                        break;
                    }
                }

                if(find){
                    TimeOfSubmit = 0;
                   Intent intent = new Intent(MainActivity.this , MainActivity2.class);
                  startActivity(intent);
                }else{
                    TimeOfSubmit++;
                }

                if(TimeOfSubmit == 5){
                    button.setTextColor(Color.RED);
                    button.setText("after chwy seconde");
                    button.setEnabled(false);
                    startCountdown();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            button.setEnabled(true);
                            button.setTextColor(Color.RED);
                            button.setText("login");

                        }
                    }, 4000);
                }
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Create_new_compte.class);
                startActivity(intent);
            }
        });
    }

    private void startCountdown() {
        // Specify the total countdown time (in milliseconds) and the interval between ticks
        countDownTimer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Update the UI with the remaining time
                button.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                // Update UI when the countdown finishe
                // Perform any action you want here, such as enabling a button
            }
        }.start(); // Start the countdown timer
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cancel the countdown timer to avoid memory leaks
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

}