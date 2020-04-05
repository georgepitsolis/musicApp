package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_song_activity);

        ImageView songImage = (ImageView) findViewById(R.id.single_cover);
        TextView songTitle = (TextView) findViewById(R.id.song_title);
        songTitle.setSelected(true);
        TextView songArtist = (TextView) findViewById(R.id.song_artist);
        songArtist.setSelected(true);

        Intent intent = getIntent();
        final ArrayList<Song> song = intent.getParcelableArrayListExtra("song");
        final int position = intent.getIntExtra("position", 0);

        Song current = song.get(position);
        songImage.setImageResource(current.getmImageAlbum());
        songTitle.setText(current.getmTitle());
        songArtist.setText(current.getmArtist());
        final ImageView playPause = (ImageView) findViewById(R.id.play_or_pause_song);

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playPause.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.ic_play_circle_outline_black_24dp).getConstantState()){
                    playPause.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
                }
                else playPause.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
            }
        });

        final ImageView addToFavorite = (ImageView) findViewById(R.id.add_to_favorite);

        addToFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addToFavorite.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.ic_favorite_border_black_24dp).getConstantState()){
                    addToFavorite.setImageResource(R.drawable.ic_favorite_black_24dp);
                    Toast.makeText(SongActivity.this, "Added to favorites", Toast.LENGTH_SHORT).show();
                }
                else {
                    addToFavorite.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    Toast.makeText(SongActivity.this, "Removed from favorites", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final ImageView nextSong = (ImageView) findViewById(R.id.next_song);

        nextSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( position == (song.size() - 1)){
                    finish();
                    Intent reIntent = getIntent();
                    reIntent.putExtra("position", 0);
                    reIntent.putParcelableArrayListExtra("song", (ArrayList<? extends Parcelable>) song);
                    startActivity(reIntent);
                }
                else {
                    finish();
                    Intent reIntent = getIntent();
                    reIntent.putExtra("position", position + 1);
                    reIntent.putParcelableArrayListExtra("song", (ArrayList<? extends Parcelable>) song);
                    startActivity(reIntent);
                }
            }
        });

        final ImageView previousSong = (ImageView) findViewById(R.id.previous_song);

        previousSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( position == 0 ){
                    finish();
                    Intent reIntent = getIntent();
                    reIntent.putExtra("position", song.size() - 1);
                    reIntent.putParcelableArrayListExtra("song", (ArrayList<? extends Parcelable>) song);
                    startActivity(reIntent);
                }
                else {
                    finish();
                    Intent reIntent = getIntent();
                    reIntent.putExtra("position", position - 1);
                    reIntent.putParcelableArrayListExtra("song", (ArrayList<? extends Parcelable>) song);
                    startActivity(reIntent);
                }
            }
        });

    }
}
