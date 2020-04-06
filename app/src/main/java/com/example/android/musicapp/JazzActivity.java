package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class JazzActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Song> jazzSong = new ArrayList<Song>();

        jazzSong.add(new Song("Koral", "Go Go Penguin", R.drawable.koral));
        jazzSong.add(new Song("Dawn At The Souk", "Mr. Kafer", R.drawable.dawn_at_the_souk));
        jazzSong.add(new Song("Moth", "Cassowary", R.drawable.moth));
        jazzSong.add(new Song("Blues Ideology", "Irreversible Entanglements", R.drawable.blues_ideology));
        jazzSong.add(new Song("Bayne Lay Yihedal", "Hailu Mergia", R.drawable.bayne_lay_yihedal));
        jazzSong.add(new Song("Storyline", "Dominic J Marshall", R.drawable.storyline));
        jazzSong.add(new Song("Carry Me Home", "KOKOROKO", R.drawable.carry_me_home));
        jazzSong.add(new Song("NDUGU", "Lettuce", R.drawable.ndugu));
        jazzSong.add(new Song("Go To Shanghai", "Atrisma", R.drawable.go_to_shanghai));
        jazzSong.add(new Song("Les Berceaux", "Jean - Louis Martinier, Kevin Seddiki", R.drawable.les_berceaux));

        SongAdapter songAdapter = new SongAdapter(this, jazzSong);

        ListView jazzListView = (ListView) findViewById(R.id.list);
        jazzListView.setAdapter(songAdapter);

        jazzListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent jazzIntent = new Intent(JazzActivity.this, SongActivity.class);
                jazzIntent.putExtra("position", position);
                jazzIntent.putExtra("parent_activity", "jazz");
                jazzIntent.putParcelableArrayListExtra("song", (ArrayList<? extends Parcelable>) jazzSong);
                startActivity(jazzIntent);
            }
        });
    }
}
