package com.alro2025.mascotas30.presentador;

import android.content.Context;

import com.alro2025.mascotas30.fragments.IRVFragment;
import com.alro2025.mascotas30.fragments.RVFragment;
import com.alro2025.mascotas30.pojo.ConstructorMascotas;
import com.alro2025.mascotas30.pojo.ContactoMascota;

import java.util.ArrayList;

/**
 * Created by angel on 5/03/2017.
 */

public class RVFPresenter implements IRVFPresenter {

    private IRVFragment irvfragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<ContactoMascota> contactos;


    public RVFPresenter (IRVFragment irvfragment, Context context){
        this.irvfragment = irvfragment;
        this.context = context;
        obtenerMascotas();
    }


    @Override
    public void obtenerMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        contactos = constructorMascotas.obtenerMascotas();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        irvfragment.inicializaAdaptadorRV(irvfragment.crearAdaptador(contactos));
        irvfragment.generarLinearLayoutVertical();
    }
}
