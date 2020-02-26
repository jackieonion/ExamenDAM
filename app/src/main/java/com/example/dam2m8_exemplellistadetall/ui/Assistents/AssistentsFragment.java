package com.example.dam2m8_exemplellistadetall.ui.Assistents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dam2m8_exemplellistadetall.Model.Assistent;
import com.example.dam2m8_exemplellistadetall.R;

import java.util.ArrayList;

public class AssistentsFragment extends Fragment {

    private AssistentsViewModel assistentsViewModel;

    private RecyclerView miRecycler;
    private ArrayList<Assistent> llistaAssistents;
    private AssistentsListAdapter miAdapter;

    private Button asistirButton;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        assistentsViewModel =
                ViewModelProviders.of(this).get(AssistentsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_llista, container, false);

        asistirButton = root.findViewById(R.id.asistirButton);

        asistirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Navigation.findNavController(v).navigate(R.id.nav_asistir, bundle);

            }
        });

        miRecycler = root.findViewById(R.id.llistatRecycler);
        miRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        miRecycler.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        llistaAssistents = assistentsViewModel.getLlistat().getValue();

        miAdapter = new AssistentsListAdapter(llistaAssistents);
        miRecycler.setAdapter(miAdapter);


        assistentsViewModel.getLlistat().observe(getViewLifecycleOwner(), new Observer<ArrayList<Assistent>>() {
            @Override
            public void onChanged(ArrayList<Assistent> esdeveniments) {
                llistaAssistents = esdeveniments;
                miAdapter.notifyDataSetChanged();
            }
        });

        return root;
    }
}