package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.newsapp.cliente.ClienteFreeNewsApi;

import org.json.JSONException;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/*Nova activity que recebe a mensagem e lança a API*/
public class DisplaySearchActivity extends AppCompatActivity {

    private ClienteFreeNewsApi api;

    private TextView title;
    private TextView date;
    private TextView link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_search);

        title = findViewById(R.id.title);
        date = findViewById(R.id.date);
        link = findViewById(R.id.link);

        try {
            lancaAPI();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void lancaAPI() throws IOException, JSONException {

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.SEARCH_MESSAGE);

        api.pesquisa(message);
    }
}