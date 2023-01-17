package com.example.lap3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void call1st(View V) {
        //define an intent where you want to go
        // use Intent(From,to) like we are sending a post
        Intent i = new Intent(this, FirstActivity.class);
        //start the given action to intent
        startActivity(i);
        //finish this activity
        //move me to the second Activity and kill the priviuos
        //to save battery
        finish();
    }

    public void call2nd(View V) {
        //define an intent where you want to go
        // use Intent(From,to) like we are sending a post

        //the intent is the thing that countect the page withe each others
        Intent i = new Intent(this, SecActivity.class);
        //start the given action to intent
        startActivity(i);
        //finish this activity
        finish();
    }
}