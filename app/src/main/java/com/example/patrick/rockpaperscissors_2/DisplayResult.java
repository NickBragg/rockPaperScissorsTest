package com.example.patrick.rockpaperscissors_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class DisplayResult extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        Intent intent = getIntent();
        ImageView imageViewComputer = (ImageView)findViewById(R.id.displayImage);
        ImageView imageViewUser = (ImageView) findViewById(R.id.displayUserImage);

        String message = "";
        String userSelection = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Random random = new Random();
        int randomNum = random.nextInt(30) + 1;

        if(randomNum <= 10)//0 computer chose rock
        {
            imageViewComputer.setImageResource(R.drawable.rock);
            if(userSelection.equals("rock")) {
                message = "It's a tie!";
                imageViewUser.setImageResource(R.drawable.rock);
            }
            else if (userSelection.equals("scissors")) {
                message = "Computer wins";
                imageViewUser.setImageResource(R.drawable.scissors);
            }
            else {
                message = "You win.";
                imageViewUser.setImageResource(R.drawable.paper);
            }
        }
        else if(randomNum <= 20)//computer chose paper
        {
            imageViewComputer.setImageResource(R.drawable.paper);
            if(userSelection.equals("rock")) {
                message = "You lose!";
                imageViewUser.setImageResource(R.drawable.rock);
            }
            else if (userSelection.equals("scissors")) {
                message = "You win!";
                imageViewUser.setImageResource(R.drawable.scissors);
            }
            else {
                message = "It's a tie.";
                imageViewUser.setImageResource(R.drawable.paper);
            }
        }
        else if (randomNum <= 30)
        {
            imageViewComputer.setImageResource(R.drawable.scissors);
            if(userSelection.equals("rock")){
                message = "You win!";
                imageViewUser.setImageResource(R.drawable.rock);
            }
            else if (userSelection.equals("scissors")) {
                message = "It's a tie.";
                imageViewUser.setImageResource(R.drawable.scissors);
            }
            else{
                message = "You lose!";
                imageViewUser.setImageResource(R.drawable.paper);
            }
        }

        TextView textView = (TextView)findViewById(R.id.messageText);
        textView.setText(message);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
