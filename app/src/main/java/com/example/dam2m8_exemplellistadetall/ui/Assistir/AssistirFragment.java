package com.example.dam2m8_exemplellistadetall.ui.Assistir;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.dam2m8_exemplellistadetall.R;

public class AssistirFragment extends Fragment {

    private AssistirViewModel assistirViewModel;

    private EditText nom, cognom, email, edat, telefon;
    private Button cancelar, aceptar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        assistirViewModel = new AssistirViewModel(getActivity().getApplication());
        View root = inflater.inflate(R.layout.fragment_asistir, container, false);

        nom = root.findViewById(R.id.nomAssistentEditText);
        cognom = root.findViewById(R.id.cognomAssistentEditText);
        email = root.findViewById(R.id.emailAssistentEditText);
        edat = root.findViewById(R.id.edatAssistentEditText);
        telefon = root.findViewById(R.id.telefonAssistentEditText);

        cancelar = root.findViewById(R.id.button);
        aceptar = root.findViewById(R.id.button2);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assistirViewModel.aceptarAsistir(nom.getText().toString(), cognom.getText().toString(), email.getText().toString(), edat.getText().toString(), telefon.getText().toString(), "esdeveniment");
            }
        });

        return root;
    }
}