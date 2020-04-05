package com.example.android.musicapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {

    private String mTitle;
    private String mArtist;
    private int mImageAlbum;

    public Song(String Title, String Artist, int ImageAlbum) {
        this.mTitle = Title;
        this.mArtist = Artist;
        this.mImageAlbum = ImageAlbum;
    }

    protected Song(Parcel in) {
        mTitle = in.readString();
        mArtist = in.readString();
        mImageAlbum = in.readInt();
    }


    public String getmTitle() {
        return mTitle;
    }

    public String getmArtist() {
        return mArtist;
    }

    public int getmImageAlbum() {
        return mImageAlbum;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mArtist);
        dest.writeInt(mImageAlbum);
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

}
