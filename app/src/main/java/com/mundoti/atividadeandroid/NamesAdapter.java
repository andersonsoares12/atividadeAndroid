package com.mundoti.atividadeandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.ViewHolder> {

    private ArrayList<String> namesList;

    public NamesAdapter(ArrayList<String> namesList) {
        this.namesList = namesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = namesList.get(position);
        holder.textViewName.setText(name);
    }

    @Override
    public int getItemCount() {
        return namesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
        }
    }
}
