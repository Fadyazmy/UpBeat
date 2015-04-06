package com.example.fadyazmy.myapplication;

/**
 * Created by fadyazmy on 3/28/15.
 */
public class compareBpm {


    //int x = 0;
    //int y= 0;
    //String totalAnswer;
   // double difference;
    //double prevDiff;





    public  static String compareBpm(Song[] songArray, double avgbeat)
    {
        double difference;
        double prevDiff = 0;
        String totalAnswer ="";

        prevDiff = 999999.0;
        for ( int x = 0; x < songArray.length; ++x )
        {

            difference = songArray[x].getbpm() - avgbeat;
            difference = Math.abs(difference);

            if (prevDiff > difference)
            {
                //Just in case we find duplicates then better songs
                totalAnswer = null;
                totalAnswer = songArray[x].getname();
                prevDiff = difference;
            }
            if (prevDiff==difference) {
                totalAnswer=  songArray[x].getname();
            }
        }

        return totalAnswer;
    }


}
