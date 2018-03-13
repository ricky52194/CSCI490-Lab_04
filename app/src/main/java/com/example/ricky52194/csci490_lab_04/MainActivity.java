package com.example.ricky52194.csci490_lab_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeURLConnection("https://jsonplaceholder.typicode.com/users");
    }

    public String makeURLConnection(String s)  {

        URL url = null;
        try {
            url = new URL(s);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        URLConnection connection = null;
        try {
            connection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader((connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader in = new BufferedReader(isr);
        String line = null;
        try {
            line = in.readLine();
            while (in.readLine() != null) {
                Log.i("Contents", line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }
}
