package com.alro2025.mascotas30.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alro2025.mascotas30.R;
import com.alro2025.mascotas30.adapter.ContactoAdaptador;
import com.alro2025.mascotas30.pojo.ContactoMascota;
import com.alro2025.mascotas30.presentador.IRVFPresenter;
import com.alro2025.mascotas30.presentador.RVFPresenter;

import java.util.ArrayList;

import static com.alro2025.mascotas30.R.id.rvContactos;

/**
 * Created by angel on 5/03/2017.
 */

public class RVFragment extends Fragment implements IRVFragment{

    ArrayList<ContactoMascota> contactoMascotas;
    private RecyclerView listaContactos;
    private IRVFPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rv, container, false);

        listaContactos = (RecyclerView) v.findViewById(rvContactos);
        presenter = new RVFPresenter(this, getContext());


        return  v;
    }


    /*public void inicializaListaContactos(){
        contactos = new ArrayList<ContactoMascota>();
        contactos.add(new ContactoMascota(R.drawable.burro, "BURRO", 0));
        contactos.add(new ContactoMascota(R.drawable.dino, "DINO", 0));
        contactos.add(new ContactoMascota(R.drawable.frank_mib, "FRANK", 0));
        contactos.add(new ContactoMascota(R.drawable.garfield, "GARFIELD", 0));
        contactos.add(new ContactoMascota(R.drawable.perry, "PERRY", 0));
        contactos.add(new ContactoMascota(R.drawable.pluto, "PLUTO", 0));
        contactos.add(new ContactoMascota(R.drawable.salem, "SALEM", 0));
        contactos.add(new ContactoMascota(R.drawable.scooby_doo, "SCOOBY-DOO", 0));


    }*/


    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);

    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<ContactoMascota> contactoMascotas) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactoMascotas, this.getActivity());
        return adaptador;
    }

    @Override
    public void inicializaAdaptadorRV(ContactoAdaptador adaptador) {
        listaContactos.setAdapter(adaptador);

    }

}

