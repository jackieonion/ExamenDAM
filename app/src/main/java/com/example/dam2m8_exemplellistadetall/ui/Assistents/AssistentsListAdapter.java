package com.example.dam2m8_exemplellistadetall.ui.Assistents;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dam2m8_exemplellistadetall.Model.Assistent;
import com.example.dam2m8_exemplellistadetall.R;

import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AssistentsListAdapter extends RecyclerView.Adapter<AssistentsListAdapter.ItemListViewHolder> {

    private static ArrayList<Assistent> llistaAssistents;

    static class ItemListViewHolder extends RecyclerView.ViewHolder {

        TextView nom, email;

        ItemListViewHolder(View v) {
            super(v);
            this.nom = v.getRootView().findViewById(R.id.firstText);
            this.email = v.getRootView().findViewById(R.id.secondText);

        }
    }

    public AssistentsListAdapter(ArrayList<Assistent> llistaAssistents) {
        this.llistaAssistents = llistaAssistents;
    }

    @NonNull
    @Override
    public ItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutInflater = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ItemListViewHolder(layoutInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListViewHolder holder, int position) {
        if(llistaAssistents != null) {
            holder.nom.setText(llistaAssistents.get(position).getNom());
            holder.email.setText(llistaAssistents.get(position).getEmail());
        }
    }

    @Override
    public int getItemCount() {
        if(llistaAssistents != null) {
            return llistaAssistents.size();
        }
        return 0;
    }
}