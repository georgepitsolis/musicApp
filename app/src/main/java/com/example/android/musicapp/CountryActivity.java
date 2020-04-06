package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CountryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Song> countrySong = new ArrayList<Song>();

        countrySong.add(new Song("Ruin That For Me", "Avenue Beat", R.drawable.ruin_that_for_me));
        countrySong.add(new Song("State I'm In", "Filmore", R.drawable.state_im_in));
        countrySong.add(new Song("Big, Big Plans", "Chris Lace", R.drawable.big_plans));
        countrySong.add(new Song("Classin'You", "Morgan Waffen", R.drawable.classin_you));
        countrySong.add(new Song("Half Of My Hometown (feat. Kenny Chesney)", "Kelsea Ballerini, Kenny Chesney", R.drawable.half_of_my_hometown));
        countrySong.add(new Song("Giving You Up", "Kameron Moulowe", R.drawable.giving_you_up));
        countrySong.add(new Song("This Is Us", "Jimmie Allen, Noah Cyrus", R.drawable.this_is_us));
        countrySong.add(new Song("Momma's House", "Dustin Lynch", R.drawable.mommas_house));
        countrySong.add(new Song("After A Few", "Trawis Denning", R.drawable.after_a_few));
        countrySong.add(new Song("One Man Band", "Old Dominion", R.drawable.one_man_band));

        SongAdapter songAdapter = new SongAdapter(this, countrySong);

        ListView countryListView = (ListView) findViewById(R.id.list);
        countryListView.setAdapter(songAdapter);

        countryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent countryIntent = new Intent(CountryActivity.this, SongActivity.class);
                countryIntent.putExtra("position", position);
                countryIntent.putExtra("parent_activity", "country");
                countryIntent.putParcelableArrayListExtra("song", (ArrayList<? extends Parcelable>) countrySong);
                startActivity(countryIntent);
            }
        });
    }
}
