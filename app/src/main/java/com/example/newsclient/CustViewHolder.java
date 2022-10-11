package com.example.newsclient;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustViewHolder extends RecyclerView.ViewHolder{
    TextView text_title, text_source;
    ImageView img_headlinenews;
    CardView cardView;
    public CustViewHolder(@NonNull View itemView) {
        super(itemView);

        text_title = itemView.findViewById(R.id.text_title);
        text_source = itemView.findViewById(R.id.text_source);
        img_headlinenews = itemView.findViewById(R.id.img_hlimage);
        cardView = itemView.findViewById(R.id.main_container);
    }
}
