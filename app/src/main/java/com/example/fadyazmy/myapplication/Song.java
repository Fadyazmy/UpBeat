package com.example.fadyazmy.myapplication;

/**
 * Created by fadyazmy on 3/28/15.
 */
public class Song {

        String name;
        double bpm;
         String link;
        public Song(String nam, double beat, String LINK)
        {
            name = nam;
            bpm = beat;
            link = LINK;
        }
        public String getname()
        {
            return name;
        }
        public double getbpm()
        {
            return bpm;
        }
        public String getlink(){ return link;}
   }



