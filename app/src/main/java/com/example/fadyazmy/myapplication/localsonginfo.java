package com.example.fadyazmy.myapplication;

/**
 * Created by fadyazmy on 3/28/15.
 */
    public class localsonginfo {

        private long id;
        private String title;
        private String artist;
        private String location;

        public localsonginfo(long songID, String songtitle, String songartist, String filelocation)
        {
            id = songID;
            title = songtitle;
            artist = songartist;
            location = filelocation;
        }

        public long getID()
        {
            return id;
        }

        public String getTitle()
        {
            return title;
        }

        public String getArtist()
        {
            return artist;
        }

        public String getFilelocation() { return location;}
    }
