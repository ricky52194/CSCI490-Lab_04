package com.example.ricky52194.csci490_lab_04;

import android.os.AsyncTask;
import android.widget.TextView;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ricky52194 on 3/13/18.
 */

public class myAsyncTask extends AsyncTask<String, Void, String> {

    private TextView textview;


    public myAsyncTask(TextView textView) {
        this.textview = textView;
    }

    @Override
    protected String doInBackground (String... String){
        URL url = null;
        try {
            url = new URL(String[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection connection = null;
        try {
            connection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader((connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line = null;


        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int i = 0;
        while(i < 20){
            try {
                line += bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }

        return line;
    }

    @Override
    protected void onPostExecute(String string) {
        super.onPostExecute(string);
        Log.i("JSON", string);
        textview.setText(string.substring(10, 23));
    }


}
