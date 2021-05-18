package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String SEARCH_MESSAGE = "com.example.newsapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplaySearchActivity.class);
        EditText txtSearch = (EditText) findViewById(R.id.txtSearch);
        String message = txtSearch.getText().toString();
        intent.putExtra(SEARCH_MESSAGE, message);
        startActivity(intent);
    }
}