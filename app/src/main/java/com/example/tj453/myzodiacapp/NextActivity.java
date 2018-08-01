package com.example.tj453.myzodiacapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class NextActivity extends AppCompatActivity {

   // Button back1;
    private Button compat1;
    private Button enemy1;
    private TextView displayenemy;
    private TextView showcompat;
    String attribute = "";
    String compatibility = "";
    String animalEnemy ="";
    private TextView attribTxtView;
    private  String compatString;
    ImageView zodiacView;
    private Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);



        ActionBar actionBar =getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        zodiacView =(ImageView) findViewById(R.id.zodiacImView);



        Button zdWebsite = (Button)findViewById(R.id.moreInfoBtn);
        zdWebsite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String zodiac = "https://www.chinahighlights.com/travelguide/chinese-zodiac/ ";
                Uri webaddress = Uri.parse(zodiac);

                Intent gotoZodiac = new Intent(Intent.ACTION_VIEW, webaddress);
                if (gotoZodiac.resolveActivity(getPackageManager()) != null) {
                    startActivity(gotoZodiac);
                }

            }
        });

        enemy1 = (Button) findViewById(R.id.enemyBtn);
        enemy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displayenemy = (TextView) findViewById(R.id.enemyTxtView);
                if (getIntent().hasExtra("ShowEnemy")) {
                    animalEnemy = getIntent().getExtras () .getString("ShowEnemy");
                    displayenemy.setText(animalEnemy);
                }

            }
        });

        compat1 = (Button) findViewById(R.id.compatBtn);
        compat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showcompat = (TextView) findViewById(R.id.compatTxtView);
                if (getIntent().hasExtra("Compatibility")) {
                    compatibility = getIntent().getExtras () .getString("Compatibility");
                    showcompat.setText(compatibility);
                }



            }
        });


        attribTxtView = (TextView) findViewById(R.id.attributesTxtView);

        if (getIntent().hasExtra("Value")) {
            attribute = getIntent().getExtras().getString("Value");
            attribTxtView.setText(attribute);
        }


        /*back1 = (Button) findViewById(R.id.backBtn);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent goBack = new Intent(NextActivity.this, MainActivity.class);
                startActivity(goBack);
            }
        });*/

    }

    public void onImageClick(View v){
         toast.makeText(this,"Image was Clicked", Toast.LENGTH_SHORT).show();
    }


    public void shareText(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String shareBodyText = "your shearing message goes here";
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject/Title");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);

        startActivity(Intent.createChooser(intent, "Choose sharing method"));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.share, menu);

        return true;
    }

    // Menu icons are inflated just as they were with actionbar
    /*@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.share, menu);

        //menu.removeItem(R.id.menu_add_run);

    }*/


    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.share:


                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);

                sharingIntent.setType("text/plain");

                String shareBodyText = "Check it out. Your message goes here";

                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject here");

                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);

                startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));

                return true;


            default:

                return super.onOptionsItemSelected(item);

        }

    }



}

