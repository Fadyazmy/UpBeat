package com.example.fadyazmy.myapplication;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import android.widget.RelativeLayout;

import com.google.android.youtube.player.YouTubeIntents;
import com.google.android.youtube.player.YouTubePlayer;

import java.sql.Statement;
import java.text.DecimalFormat;

import static com.example.fadyazmy.myapplication.R.layout.activity_main;
import static com.example.fadyazmy.myapplication.populate.*;

public class MainActivity extends ActionBarActivity {


    //testing git with this change
    int count = 0;
    double avgbeat ;
    long startTime;
    String selectedSong;
    String selectedSongLink;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        double avgbeat = (double)0.000;


    }


    public void reset(View v) {

        this.count = 0;
        this.avgbeat = 0;
        selectedSong = "";
        TextView selectedSongButton = (TextView) findViewById(R.id.button4);
        selectedSongButton.setText("Thank you for playing");

        TextView bpmButton = (TextView) findViewById(R.id.button);
        bpmButton.setText("Thank you for playing");

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void buttonOnClick(View v) {

        if (count == 0)
        {
            startTime = System.currentTimeMillis();
        }

        if (count ==5)
        {
            avgbeat = ((double)(360000.0000)/(System.currentTimeMillis()-startTime));
        }
        count++;
//        double roundOff = Math.round(avgbeat * 100.0) / 100.0;
        DecimalFormat df = new DecimalFormat("000.00");
//        // ((Button) v).setText(df.format(avgbeat));

        String message = String.format("Your beats per minute is %s.", df.format(avgbeat));
        ((TextView) v).setText(message);


        if (count == 6)
        {
           //selectedSong = compareBpm.compareBpm(songarray, avgbeat);
            //These 2 lines are evil but we were pinched for time
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            //more evilness mysql voodoo
            try {
                Class.forName("com.mysql.jdbc.Driver");
            }
            catch(Exception e) {
                e.printStackTrace();
            }

            try (
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://us-cdbr-azure-east-b.cloudapp.net:3306/as_1aa2fe1b60c72f8", "b388138f4497a9", "ade1becb");
                    Statement stmt = conn.createStatement();
            ) {
                String strSelect = "SELECT *, abs(bpm - " + avgbeat + ") AS DIFFERENCE FROM MUSIC ORDER BY DIFFERENCE LIMIT 1";
                ResultSet rset = stmt.executeQuery(strSelect);
                while(rset.next()) {   // Move the cursor to the next row
                    selectedSongLink = rset.getString("ytvid");
                    selectedSong = rset.getString("name");

                    //Log.i("test0 " + selectedSong, selectedSongLink);
                }


            } catch(SQLException ex) {
                ex.printStackTrace();
            }
            // close


            TextView mainLayout = (TextView) findViewById(R.id.button4);
            mainLayout.setText( selectedSong);

            count ++;
        } }



    public void nameOfSong(View v)
    {
        String message = String.format("Playing " + selectedSong);
        ((TextView) v).setText(message);
            Intent intent = YouTubeIntents.createPlayVideoIntentWithOptions(this, selectedSongLink , true, false);
            startActivity(intent);


        }



        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;

        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }


    public void clickFunc(View view){
        {
            Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
        }}


    }







