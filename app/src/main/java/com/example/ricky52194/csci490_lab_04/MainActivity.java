package com.example.ricky52194.csci490_lab_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView view= findViewById(R.id.webview);

        myAsyncTask task = new myAsyncTask(view);
        task.execute("https://jsonplaceholder.typicode.com/users");

    }

}
