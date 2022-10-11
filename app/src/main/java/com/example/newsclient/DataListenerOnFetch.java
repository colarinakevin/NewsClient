package com.example.newsclient;

import com.example.newsclient.Models.NewsHLs;

import java.util.List;

public interface DataListenerOnFetch<NewsApiResponse>{
    void onFetchData(List<NewsHLs> list, String message);
    void onError(String message);
}
