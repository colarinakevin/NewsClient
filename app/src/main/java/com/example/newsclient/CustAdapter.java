package com.example.newsclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsclient.Models.NewsHLs;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustAdapter extends RecyclerView.Adapter<CustViewHolder>{
    private Context context;
    private List<NewsHLs> headlines;
    private SelList listener;

    public CustAdapter(Context context, List<NewsHLs> headlines, SelList listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustViewHolder(LayoutInflater.from(context).inflate(R.layout.headlines_itemslist, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustViewHolder holder, int position) {

        holder.text_title.setText(headlines.get(position).getTitle());
        holder.text_source.setText(headlines.get(position).getSource().getName());

        if (headlines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headlinenews);

        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnNewsClicked(headlines.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
