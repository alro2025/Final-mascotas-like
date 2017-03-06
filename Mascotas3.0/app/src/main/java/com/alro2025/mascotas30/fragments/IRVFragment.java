package com.alro2025.mascotas30.fragments;

import com.alro2025.mascotas30.adapter.ContactoAdaptador;
import com.alro2025.mascotas30.pojo.ContactoMascota;

import java.util.ArrayList;

/**
 * Created by angel on 5/03/2017.
 */

public interface IRVFragment {

    public void generarLinearLayoutVertical();

    public ContactoAdaptador crearAdaptador (ArrayList<ContactoMascota> mascotas);

    public void inicializaAdaptadorRV (ContactoAdaptador contactoAdaptador);




}
