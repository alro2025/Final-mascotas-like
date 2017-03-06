package com.alro2025.mascotas30;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.alro2025.mascotas30.adapter.ContactoAdaptador;
import com.alro2025.mascotas30.fragments.IRVFragment;
import com.alro2025.mascotas30.pojo.ContactoMascota;
import com.alro2025.mascotas30.presentador.IRVFPresenterRanking;
import com.alro2025.mascotas30.presentador.RVFPresenterRanking;

import java.util.ArrayList;

import static com.alro2025.mascotas30.R.id.rvContactos;

public class ranking extends AppCompatActivity implements IRVFragment {


    private RecyclerView listaContactos;
    private IRVFPresenterRanking irvfPresenterRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);



        listaContactos = (RecyclerView) findViewById(rvContactos);
        irvfPresenterRanking = new RVFPresenterRanking(this, getBaseContext());

    }






   /* public void inicializaListaContactos() {

        contactos = new ArrayList<ContactoMascota>();
        contactos.add(new ContactoMascota(R.drawable.burro, "BURRO", 5));
        contactos.add(new ContactoMascota(R.drawable.frank_mib, "FRANK", 7));
        contactos.add(new ContactoMascota(R.drawable.garfield, "GARFIELD", 6));
        contactos.add(new ContactoMascota(R.drawable.perry, "PERRY", 8));
        contactos.add(new ContactoMascota(R.drawable.salem, "SALEM", 10));

    }*/


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

    }



    @Override
    public void inicializaAdaptadorRV(ContactoAdaptador contactoAdaptador) {
        listaContactos.setAdapter(contactoAdaptador);

    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<ContactoMascota> contactoMascotas) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactoMascotas, this);
        return adaptador;
    }
}
