package com.example.dam2m8_exemplellistadetall.ui.llista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dam2m8_exemplellistadetall.Model.Esdeveniment;
import com.example.dam2m8_exemplellistadetall.R;

import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class EsdevenimentsListAdapter extends RecyclerView.Adapter<EsdevenimentsListAdapter.ItemListViewHolder> {

    private static ArrayList<Esdeveniment> llistaEsdeveniments;

    static class ItemListViewHolder extends RecyclerView.ViewHolder {

        TextView title, data, lloc;

        ItemListViewHolder(View v) {
            super(v);
            this.title = v.getRootView().findViewById(R.id.firstText);
            this.data = v.getRootView().findViewById(R.id.secondText);
            this.lloc = v.getRootView().findViewById(R.id.thirdText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Genero un bundle on afegiré l'usuari on han fet click
                    Bundle bundle = new Bundle();
                    bundle.putInt("POSICIO", getAdapterPosition());
                    //Utilitzo getAdapterPosition per coneixer quin element haig de mostrar
                    bundle.putSerializable("DETALL",llistaEsdeveniments.get(getAdapterPosition()));
                    //Utilitzo Navigation per canviar pantalla, encara que també serveir FragmentManager
                    Navigation.findNavController(view).navigate(R.id.nav_detall, bundle);
                }
            });

        }
    }

    public EsdevenimentsListAdapter(ArrayList<Esdeveniment> llistaEsdeveniments) {
        this.llistaEsdeveniments = llistaEsdeveniments;
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
        if(llistaEsdeveniments != null) {
            holder.title.setText(llistaEsdeveniments.get(position).getTitle());
            holder.data.setText(llistaEsdeveniments.get(position).getData());
            holder.lloc.setText(llistaEsdeveniments.get(position).getLloc());
        }
    }

    @Override
    public int getItemCount() {
        if(llistaEsdeveniments != null) {
            return llistaEsdeveniments.size();
        }
        return 0;
    }
}