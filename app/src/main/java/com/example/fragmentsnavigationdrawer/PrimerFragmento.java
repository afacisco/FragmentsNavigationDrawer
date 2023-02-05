package com.example.fragmentsnavigationdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/*
Autor: Juan Francisco Sánchez González
Fecha: 04/02/2023
Clase: Clase (Lógica) que inflará la vista del 1º fragmento (fragment de inicio)
*/

public class PrimerFragmento extends Fragment {

    public PrimerFragmento() {
        // Requiere constructor público vacío
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.primer_fragmento, container, false);
    }
}
