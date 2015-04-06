package com.example.fadyazmy.myapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by fadyazmy on 3/28/15.
 */
public class MusicManager {

    /**
     * Created by fadyazmy on 3/28/15.
     */
    public ArrayList<localsonginfo> songList = new ArrayList<localsonginfo>();

    public void getmusiclibrary(Context context)
    {
        ContentResolver musicResolver = context.getContentResolver();
        Uri musicUri = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
        Cursor musicCursor = musicResolver.query(musicUri,null,null,null,null);

        if(musicCursor!=null && musicCursor.moveToFirst())
        {
            int titleColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int idColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media._ID);
            int artistColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            int dataColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.DATA);

            do
            {
                long thisId = musicCursor.getLong(idColumn);
                String thisTitle = musicCursor.getString(titleColumn);
                String thisArtist = musicCursor.getString(artistColumn);
                String thislocation = musicCursor.getString(dataColumn);
                songList.add(new localsonginfo(thisId,thisTitle,thisArtist,thislocation));
            }while(musicCursor.moveToNext());
        }
        for (int i = 0; i < songList.size(); i++)
        {
            localsonginfo a = songList.get(i);
            System.out.println(a.getFilelocation());
            System.out.println(a.getTitle());
        }
    }
}

