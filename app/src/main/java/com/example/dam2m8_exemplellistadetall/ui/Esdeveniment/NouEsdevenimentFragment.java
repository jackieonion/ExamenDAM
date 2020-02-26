package com.example.dam2m8_exemplellistadetall.ui.Esdeveniment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.dam2m8_exemplellistadetall.Model.Esdeveniment;
import com.example.dam2m8_exemplellistadetall.R;

public class NouEsdevenimentFragment extends Fragment {

    private NouEsdevenimentViewModel nouEsdevenimentViewModel;

    private EditText nom, data, lloc, organitzador, aforament, preu, descripcio, sala;
    private Button cancelar, aceptar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        nouEsdevenimentViewModel =
                ViewModelProviders.of(this).get(NouEsdevenimentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_event_edit, container, false);

        nom = root.findViewById(R.id.nombreDetailEditText);
        data = root.findViewById(R.id.fechaDetailEditText);
        lloc = root.findViewById(R.id.lugarDetailEditText);
        organitzador = root.findViewById(R.id.organizadorEditText);
        aforament = root.findViewById(R.id.aforoEditText);
        preu = root.findViewById(R.id.precioEditText);
        descripcio = root.findViewById(R.id.descripcionEditText);
        sala = root.findViewById(R.id.salaEditText);

        cancelar = root.findViewById(R.id.cancelarButton);
        aceptar = root.findViewById(R.id.confirmarButton);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nouEsdevenimentViewModel.aceptarAsistir(new Esdeveniment(data.getText().toString(), lloc.getText().toString(), organitzador.getText().toString(), sala.getText().toString(), preu.getText().toString(), aforament.getText().toString(), descripcio.getText().toString(), nom.getText().toString()));
            }
        });

        return root;
    }
}