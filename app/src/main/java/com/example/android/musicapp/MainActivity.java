package com.example.android.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView pop = (ImageView) findViewById(R.id.pop_image_view);
        ImageView country = (ImageView) findViewById(R.id.country_image_view);
        ImageView soul = (ImageView) findViewById(R.id.soul_image_view);
        ImageView jazz = (ImageView) findViewById(R.id.jazz_image_view);

        /**
         *  Go to Pop Activity after the click on Image View
         */
        pop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pop Music", Toast.LENGTH_SHORT).show();
                Intent popIntent = new Intent(MainActivity.this, PopActivity.class);
                startActivity(popIntent);
            }
        });

        /**
         *  Go to Country Activity after the click on Image View
         */
        country.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Country Music", Toast.LENGTH_SHORT).show();
                Intent countryIntent = new Intent(MainActivity.this, CountryActivity.class);
                startActivity(countryIntent);
            }
        });

        /**
         *  Go to Soul Activity after the click on Image View
         */
        soul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Soul Music", Toast.LENGTH_SHORT).show();
                Intent soulIntent = new Intent(MainActivity.this, SoulActivity.class);
                startActivity(soulIntent);
            }
        });

        /**
         *  Go to Jazz Activity after the click on Image View
         */
        jazz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Jazz Music", Toast.LENGTH_SHORT).show();
                Intent jazzIntent = new Intent(MainActivity.this, JazzActivity.class);
                startActivity(jazzIntent);
            }
        });
    }
}
