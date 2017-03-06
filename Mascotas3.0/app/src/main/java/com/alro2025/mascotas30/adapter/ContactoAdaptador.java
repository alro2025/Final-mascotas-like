package com.alro2025.mascotas30.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.alro2025.mascotas30.R;
import com.alro2025.mascotas30.pojo.ConstructorMascotas;
import com.alro2025.mascotas30.pojo.ContactoMascota;

import java.util.ArrayList;

/**
 * Created by angel on 5/03/2017.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<ContactoMascota> contactoMascotas;


    Activity activity;


    public ContactoAdaptador(ArrayList<ContactoMascota> contactoMascotas, Activity activity){
        this.contactoMascotas = contactoMascotas;
        this.activity = activity;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cvmascota, parent, false);
        return new ContactoViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder, int position) {
        final ContactoMascota contactoMascota = contactoMascotas.get(position);

        contactoViewHolder.imgFoto.setImageResource(contactoMascota.getFoto());
        contactoViewHolder.tvNombreCV.setText(contactoMascota.getNombre());
        contactoViewHolder.tvNumeroLikeCV.setText(Integer.toString(contactoMascota.getNumlikes()));

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(contactoMascota);
                contactoViewHolder.tvNumeroLikeCV.setText (String.valueOf(constructorMascotas.obtenerLikesContacto(contactoMascota)));
             }
        });

    }


    @Override
    public int getItemCount() {
        return contactoMascotas.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageButton btnLike;
        private TextView tvNumeroLikeCV;
        private ImageView imgLike;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvNumeroLikeCV = (TextView) itemView.findViewById(R.id.tvNumeroLikeCV);
            imgLike = (ImageView) itemView.findViewById(R.id.imgLike);

        }
    }
}


