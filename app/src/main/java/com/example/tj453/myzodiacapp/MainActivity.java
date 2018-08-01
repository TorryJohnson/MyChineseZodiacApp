package com.example.tj453.myzodiacapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    String take = "";
    String compatibility = "";
    String animalEnemy = "";
    private Button show;
    private Button next;
    private TextView title;

    String[] animal = {"Monkey", "Rooster", "Dog", "Pig", "Rat", "Ox",
            "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Sheep"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        input = (EditText) findViewById(R.id.editText12);
        title = (TextView) findViewById(R.id.Textview1);
        next = (Button) findViewById(R.id.shiftBtn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(input.getText().toString().trim())) {
                    input.setError("Field can't be Empty");
                } else {

                    take = input.getText().toString();
                    int num = Integer.parseInt(take);
                    if (num < 1000 || num > 9999) {

                        title.setTextColor(Color.RED);
                        title.setText("Invalid Year!!");
                    } else {
                        String att = "";
                        getAnimal();
                        att = getAttributes();
                        String compat = getCompatibility();
                        String enemy = getenemy();


                        Intent nextPage = new Intent(MainActivity.this, NextActivity.class);
                        nextPage.putExtra("Value", att);
                        nextPage.putExtra("Compatibility", compat);
                        nextPage.putExtra("ShowEnemy", enemy);
                        startActivity(nextPage);
                    }

                }
            }
        });

        show = (Button) findViewById(R.id.Gobutton);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(input.getText().toString().trim())) {
                    input.setError("Field can't be Empty");
                } else {

                    take = input.getText().toString();
                    int num = Integer.parseInt(take);
                    if (num < 1000 || num > 9999) {
                        title.setTextColor(Color.RED);
                        title.setText("Invalid Year!!");
                    } else {
                        title.setTextColor(Color.WHITE);
                        getAnimal();

                    }
                }
            }
        });

    }

    public void getAnimal() {


        if (TextUtils.isEmpty(input.getText().toString().trim())) {
            input.setError("Field can't be Empty");
        } else {
            take = input.getText().toString();
            int num = Integer.parseInt(take);

            if (num < 1000 || num > 9999) {
                title.setTextColor(Color.RED);
                title.setText("Invalid Year!!");
            } else {
                int a = num % 12;


                for (int i = 0; i < 12; i++) {
                    if (i == a)

                        title.setText(animal[i]);
                }
            }
        }


    }

    public String getAttributes() {

        int num = Integer.parseInt(take);
        String attribute = "";

        if (num < 1000 || num > 9999) {
            title.setTextColor(Color.RED);
            title.setText("Invalid Year!!");
        } else {
            switch (num % 12) {
                case 0:
                    attribute = "Witty, intelligent, ambitious, and adventurous";
                    break;
                case 1:
                    attribute = "Observant, hardworking, resourceful, courageous, and talented";
                    break;
                case 2:
                    attribute = "Loyal, honest, amiable, kind, cautious, and prudent";
                    break;
                case 3:
                    attribute = "Diligent, compassionate, generous, easy-going, and gentle";
                    break;
                case 4:
                    attribute = "Quick-witted, resourceful, and versatile";
                    break;
                case 5:
                    attribute = "Decisive, honest, dependable, and hardworking";
                    break;
                case 6:
                    attribute = "Brave, competitive, unpredictable, and self-confident";
                    break;
                case 7:
                    attribute = "Gentle, quiet, elegant, and alert; quick, skillful, kind, and patient";
                    break;
                case 8:
                    attribute = "Confident, intelligent, ambitious, persevering, and hardworking";
                    break;
                case 9:
                    attribute = "Intelligent, courageous, confident, insightful, and communicative";
                    break;
                case 10:
                    attribute = "Animated, kind, straightforward, active, and energetic";
                    break;
                case 11:
                    attribute = "Gentle, shy, stable, sympathetic, and amicable ";
                    break;
            }
        }
        return attribute;


    }

    public String getCompatibility() {
        int num = Integer.parseInt(take);

        int c = num % 12;

        String[] compat = {"Rat or Dragon", "Ox, Dragon or Snake", "Tiger, Rabbit",
                "Goat or Rabbit", "Dragon, Rabbit or Ox", "Rat, Snake or Rooster",
                "Horse or Dog", "Goat, Dog, Rat, or Pig", "Rat, Monkey or Rooster",
                "Ox or Rooster", "Tiger, Goat or Dog", "Rabbit, Horse or Pig"};

        for (int i = 0; i < 12; i++) {
            if (i == c)

                compatibility = compat[i];

        }

        return compatibility;

    }


    public String getenemy() {

        int num = Integer.parseInt(take);
        num += 6;
        int e = num % 12;

        String[] enemy = {"Monkey", "Rooster", "Dog", "Pig", "Rat", "Ox",
                "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Sheep"};

        for (int i = 0; i < 12; i++) {
            if (i == e)

                animalEnemy = enemy[i];


        }
        return animalEnemy;
    }

}