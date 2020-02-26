package com.example.dam2m8_exemplellistadetall.ui.detall;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.dam2m8_exemplellistadetall.Model.Esdeveniment;
import com.example.dam2m8_exemplellistadetall.R;
import com.example.dam2m8_exemplellistadetall.ui.llista.LlistaViewModel;

public class DetallFragment extends Fragment {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private DetallViewModel detallViewModel;

    private TextView title, data, lloc, organitzador, sala, preu, aforament, descripcio;

    private ImageButton missatge, asistentes, editar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        detallViewModel =
                ViewModelProviders.of(this).get(DetallViewModel.class);
        View root = inflater.inflate(R.layout.fragment_event_detail, container, false);

        title = root.findViewById(R.id.nombreDetailTextView);
        data = root.findViewById(R.id.fechaDetailTextView);
        lloc = root.findViewById(R.id.lugarDetailTextView);
        organitzador = root.findViewById(R.id.organizadorTextView);
        sala = root.findViewById(R.id.salaTextView);
        preu = root.findViewById(R.id.precioTextView);
        aforament = root.findViewById(R.id.aforoTextView);
        descripcio = root.findViewById(R.id.descripcionTextView);

        //missatge
        asistentes = root.findViewById(R.id.asistentesImageButton);


        asistentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Navigation.findNavController(v).navigate(R.id.nav_asistents, bundle);
            }
        });

        //Aqui recullo la info d'esdeveniment que m'ha passat el fragment anterior i la pinto en pantalla
        Esdeveniment esdeveniment = (Esdeveniment) getArguments().getSerializable("DETALL");
        actualitzar_pantalla(esdeveniment);

        //Una versió alternativa seria agafar nomes la posició i fer una crida al ViewModel
        //per a que em passes el detall d'aquesta posició.
        detallViewModel.getDetallUsuari(getArguments().getInt("POSICIO"));
        detallViewModel.getUsuari().observe(this, new Observer<Esdeveniment>() {
            @Override
            public void onChanged(Esdeveniment esdeveniment) {
                //Aqui actualitzaria la pantalla
                Log.i("DETALLVIEWMODEL ", esdeveniment.getTitle());
            }
        });

        //Una altra versió alternativa és que aquest dos fragments comparteixin el mateix ViewModel
        LlistaViewModel llistaViewModel = ViewModelProviders.of(this).get(LlistaViewModel.class);
        llistaViewModel.getDetallUsuari(getArguments().getInt("POSICIO"));
        llistaViewModel.getUsuari().observe(this, new Observer<Esdeveniment>() {
            @Override
            public void onChanged(Esdeveniment esdeveniment) {
                //Aqui actualitzaria la pantalla
                Log.i("SHAREDVIEWMODEL ", esdeveniment.getData());
            }
        });



        return root;
    }

    private void actualitzar_pantalla(Esdeveniment esdeveniment) {

        title.setText(esdeveniment.getTitle());
        data.setText("DATA: "+ esdeveniment.getData());
        organitzador.setText("ORGANITZADOR: "+ esdeveniment.getOrganitzador());
        preu.setText("PREU: "+ esdeveniment.getPreu());
        aforament.setText("AFORAMENT: "+ esdeveniment.getAforament());
        descripcio.setText("DESCRIPCIO: "+ esdeveniment.getDescripcio());
        lloc.setText("LLOC: "+ esdeveniment.getLloc());
        sala.setText("SALA: "+ esdeveniment.getSala());
    }
}