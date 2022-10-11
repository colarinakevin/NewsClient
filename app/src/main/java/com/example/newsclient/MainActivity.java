package com.example.newsclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.newsclient.Models.NewsAPIResp;
import com.example.newsclient.Models.NewsHLs;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelList {
    RecyclerView recyclerView;
    CustAdapter adapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Fetching News Articles..");
        dialog.show();

        ReqManager manager = new ReqManager(this);
        manager.getNewsHeadlines(listener, "general", null);
    }

    private final DataListenerOnFetch<NewsAPIResp> listener = new DataListenerOnFetch<NewsAPIResp>() {
        @Override
        public void onFetchData(List<NewsHLs> list, String message) {
            showNews(list);
            dialog.dismiss();
        }

        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<NewsHLs> list) {
         recyclerView = findViewById(R.id.recycler_main);
         recyclerView.setHasFixedSize(true);
         recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
         adapter = new CustAdapter(this, list, this);
         recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnNewsClicked(NewsHLs headlines) {
        startActivity(new Intent(MainActivity.this, NewsDetailsAct.class)
                .putExtra("data", headlines));

    }
}