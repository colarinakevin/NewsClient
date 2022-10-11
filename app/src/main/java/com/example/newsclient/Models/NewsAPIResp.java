package com.example.newsclient.Models;

import java.io.Serializable;
import java.util.List;

public class NewsAPIResp implements Serializable {
    String status;
    int totalResults;
    List<NewsHLs> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsHLs> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsHLs> articles) {
        this.articles = articles;
    }
}
