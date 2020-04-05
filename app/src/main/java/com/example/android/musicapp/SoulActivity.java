package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SoulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        final ArrayList<Song> soulSong = new ArrayList<Song>();

        soulSong.add(new Song("Late Night", "Lucky Daye", R.drawable.late_night));
        soulSong.add(new Song("Voodoo", "Patrick Paige II", R.drawable.voodoo));
        soulSong.add(new Song("No Bus", "Iophiile, Col3trane, Amber Mark", R.drawable.no_bus));
        soulSong.add(new Song("Square 1", "Mahalia", R.drawable.square_1));
        soulSong.add(new Song("Blank Marquee", "Yuna, G-Easy", R.drawable.blank_marquee));
        soulSong.add(new Song("Hurry", "Teyana Taylor, Kanye West", R.drawable.hurry));
        soulSong.add(new Song("Slowly", "ODIE", R.drawable.slowly));
        soulSong.add(new Song("Lies", "Terrace Martin", R.drawable.lies));
        soulSong.add(new Song("Talk Is Cheap", "JMSN", R.drawable.talk_is_cheap));
        soulSong.add(new Song("Pink Youth", "Yuna, Little Simz", R.drawable.pink_youth));

        SongAdapter songAdapter = new SongAdapter(this, soulSong);

        ListView soulListView = (ListView) findViewById(R.id.list);
        soulListView.setAdapter(songAdapter);

        soulListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent soulIntent = new Intent(SoulActivity.this, SongActivity.class);
                soulIntent.putExtra("position", position);
                soulIntent.putParcelableArrayListExtra("song", (ArrayList<? extends Parcelable>) soulSong);
                startActivity(soulIntent);
            }
        });
    }
}

//