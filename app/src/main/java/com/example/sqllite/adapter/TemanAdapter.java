package com.example.sqllite.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqllite.R;
import com.example.sqllite.database.Teman;

import java.util.ArrayList;

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.TemanViewHolder> {
    private ArrayList<Teman> listData;

    public TemanAdapter(ArrayList<Teman> listData) {
        this.listData = listData;
    }

    @Override
    public TemanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_teman, parent, false);
        return new TemanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemanViewHolder holder, int position) {
        String nm, tlp;

        nm = listData.get(position).getNama();
        tlp = listData.get(position).getTelepon();

        holder.NamaTxt.setTextColor(Color.BLUE);
        holder.NamaTxt.setTextSize(20);
        holder.NamaTxt.setText(nm);
        holder.TeleponTxt.setText(tlp);
    }

    @Override
    public int getItemCount() {
        return (listData != null) ? listData.size() : 0;
    }

    public class TemanViewHolder extends RecyclerView.ViewHolder {
        private CardView Cardku;
        private TextView NamaTxt, TeleponTxt;
        public TemanViewHolder (View view) {
            super(view);
            Cardku = (CardView) view.findViewById(R.id.kartuku);
            NamaTxt = (TextView) view.findViewById(R.id.textNama);
            TeleponTxt = (TextView) view.findViewById(R.id.textTelepon);
        }
    }
}
