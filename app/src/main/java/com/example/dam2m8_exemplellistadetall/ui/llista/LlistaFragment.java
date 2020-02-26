package com.example.dam2m8_exemplellistadetall.ui.llista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dam2m8_exemplellistadetall.Model.Esdeveniment;
import com.example.dam2m8_exemplellistadetall.R;

import java.util.ArrayList;

public class LlistaFragment extends Fragment {

    private LlistaViewModel llistaViewModel;

    private RecyclerView miRecycler;
    private ArrayList<Esdeveniment> llistaEsdeveniments;
    private EsdevenimentsListAdapter miAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        llistaViewModel =
                ViewModelProviders.of(this).get(LlistaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_llista, container, false);

        miRecycler = root.findViewById(R.id.llistatRecycler);
        miRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        miRecycler.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        llistaEsdeveniments = llistaViewModel.getLlistat().getValue();

        miAdapter = new EsdevenimentsListAdapter(llistaEsdeveniments);
        miRecycler.setAdapter(miAdapter);


        llistaViewModel.getLlistat().observe(getViewLifecycleOwner(), new Observer<ArrayList<Esdeveniment>>() {
            @Override
            public void onChanged(ArrayList<Esdeveniment> esdeveniments) {
                llistaEsdeveniments = esdeveniments;
                miAdapter.notifyDataSetChanged();
            }
        });

        return root;
    }
}