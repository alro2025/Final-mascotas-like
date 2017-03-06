package com.alro2025.mascotas30.presentador;

import android.content.Context;

import com.alro2025.mascotas30.fragments.IRVFragment;
import com.alro2025.mascotas30.pojo.ConstructorMascotas;
import com.alro2025.mascotas30.pojo.ContactoMascota;

import java.util.ArrayList;

/**
 * Created by angel on 5/03/2017.
 */

public class RVFPresenterRanking implements IRVFPresenterRanking {

    private IRVFragment irvFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<ContactoMascota> contactoMascotas;

    public RVFPresenterRanking(IRVFragment irvFragment, Context context){
      this.irvFragment = irvFragment;
        this.context = context;
        obtenerMascotas();
    }

    private void obtenerMascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        contactoMascotas = constructorMascotas.obtenerMascotaFav();
        mostrarMascotasRV();
    }

    private void mostrarMascotasRV() {
        irvFragment.inicializaAdaptadorRV(irvFragment.crearAdaptador(contactoMascotas));
        irvFragment.generarLinearLayoutVertical();
    }
}
