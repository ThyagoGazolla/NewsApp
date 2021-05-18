package com.example.newsapp.entidade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"_id","_score","author","authors","clean_url","country","is_opinion",
        "language","link","media","published_date","published_date_precision","rank","rights",
        "summary","title","topic","twitter_account"})

public class Noticia {

    @JsonProperty("title")
    private String title;
    @JsonProperty("link")
    private String link;
    @JsonProperty("published_date")
    private String date;

    public Noticia (String title, String link, String date){
        this.title = title;
        this.link = link;
        this.date = date;
    }

    public String getTitle(){ return title; }

    public String getDate() { return date; }

    public String getLink() { return link; }
}
