package com.example.fadyazmy.myapplication;

/**
 * Created by fadyazmy on 3/28/15.
 */
public class populate{



    public static Song[] populate() {
        Song[] songarray = new Song[10];
        songarray[0] = new Song("Beyonce: Hips Don't Lie", 50, "DUT5rEU6pqM");
        songarray[1] = new Song("Akon: Lonely", 52,  "6EEW-9NDM5k");
        songarray[2] = new Song("RKelly: Same Girl", 55, "NFnKgIptbq0");
        songarray[3] = new Song("Frozen: Let it go ", 60, "L0MK7qz13bU");
        songarray[4] = new Song("Arcade Fire: Rebellion", 130, "MQvZ4N1RfS8");
        songarray[5] = new Song("Bon Jovi: Living on a Prayer", 150, "lDK9QqIzhwk");
        songarray[6] = new Song("Beyonce: Halo", 188, "bnVUHWCynig");
        songarray[7] = new Song("Shakira: Loca", 200, "KewfYKJy8YU");
        songarray[8] = new Song("Enrique Eglesias: Dirty Dancer", 220, "vHJAUuicC0Q");
        songarray[9] = new Song("Maroon 5: Sugar", 250, "09R8_2nJtjg");
        return songarray;
    }

    public static String getSongLink(String songName)
    {
        Song[]  songarray  = populate.populate();
        String requested = "";
        boolean found = true;
        int x = 0;
        while(found)
        {
            for ( x = 0; x< songarray.length; x++)
            {
                if (songarray[x].getname() == songName) {
                    requested = songarray[x].getlink();
                    found = false;
                }
            }
        }
        return requested;
    }

}
