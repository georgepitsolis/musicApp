package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PopActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Song> popSong = new ArrayList<Song>();

        popSong.add(new Song("Don't Start Now", "Dua Lipa", R.drawable.dont_start_now));
        popSong.add(new Song("Know Your Worth", "Khalid, Disclosure", R.drawable.know_your_worth));
        popSong.add(new Song("Before You Go", "Lewis Capaldi", R.drawable.before_you_go));
        popSong.add(new Song("Physical", "Dua Lipa", R.drawable.physical));
        popSong.add(new Song("Say So", "Doja Cat", R.drawable.say_so));
        popSong.add(new Song("Like It Is", "Kygo, Zara Larsson, Tyga", R.drawable.like_it_is));
        popSong.add(new Song("Roses - Imanbek Remix", "SAINt JHN, Imanbek", R.drawable.roses));
        popSong.add(new Song("Find My Way", "DaBaby", R.drawable.find_my_way));
        popSong.add(new Song("I Love Me", "Demi Lovato", R.drawable.i_love_me));
        popSong.add(new Song("Intentions", "Justin Bieber, Quavo", R.drawable.intentions));

        SongAdapter songAdapter = new SongAdapter(this, popSong);

        ListView popListView = (ListView) findViewById(R.id.list);
        popListView.setAdapter(songAdapter);

        popListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Intent popIntent = new Intent(PopActivity.this, SongActivity.class);

                popIntent.putExtra("position", position);
                popIntent.putExtra("parent_activity", "pop");
                popIntent.putParcelableArrayListExtra("song", (ArrayList<? extends Parcelable>) popSong);
                startActivity(popIntent);
            }
        });

    }

}
