package com.example.newsapp.cliente;

import com.example.newsapp.entidade.Noticia;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ClienteFreeNewsApi {
    private static final String LANG = "pt";
    private static final String APIKEY = "751fe79880msh0a5a9a34610bb69p1f4d8djsnace559623b71";
    private static final String URL = "https://free-news.p.rapidapi.com";
    private static OkHttpClient client = new OkHttpClient();

    public Noticia pesquisa(String texto) throws IOException, JSONException {
        String response = getNoticias(texto);
        JSONObject obj = new JSONObject(response);
        String title = obj.getString("title");
        String link = obj.getString("link");
        String date = obj.getString("published_date");
        Noticia noticia = new Noticia(title,link,date);
        return noticia;
    }

    private String getNoticias(String texto) throws IOException {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(URL)
                .addPathSegment("v1/search")
                .addQueryParameter("q",texto)
                .addQueryParameter("lang", LANG)
                .build();
        Request request = new  Request.Builder()
                .url(url)
                .addHeader("x-rapidapi-key", APIKEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            throw e;
        }
    }

}
