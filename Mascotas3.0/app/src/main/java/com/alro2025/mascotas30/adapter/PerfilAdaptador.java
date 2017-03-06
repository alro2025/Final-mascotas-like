package com.alro2025.mascotas30.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.alro2025.mascotas30.R;
import com.alro2025.mascotas30.pojo.ContactoMascota;

import java.util.ArrayList;

/**
 * Created by angel on 5/03/2017.
 */

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {

    ArrayList<ContactoMascota> contactoMascotas;
    private Activity activity;
    private Context context;

    public PerfilAdaptador(ArrayList<ContactoMascota> contactoMascotas, Activity activity){
        this.contactoMascotas = contactoMascotas;
        this.activity = activity;
        this.context = activity.getApplicationContext();
    }


    @Override
    public PerfilAdaptador.PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cvperfil, parent, false);
        return new PerfilViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(final PerfilViewHolder perfilViewHolder, int position) {
        final ContactoMascota contactoMascota = contactoMascotas.get(position);


        perfilViewHolder.imgFoto2.setImageResource(contactoMascota.getFoto());
        perfilViewHolder.tvNombreCV2.setText(contactoMascota.getNombre());
        perfilViewHolder.tvNumeroLikeCV2.setText(String.valueOf(contactoMascota.getNumlikes()));

    }

    @Override
    public int getItemCount() {
        return contactoMascotas.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto2;
        private TextView tvNombreCV2;
        private ImageButton btnLike2;
        private TextView tvNumeroLikeCV2;
        private ImageView imgLike2;

        public PerfilViewHolder(View itemView) {
            super(itemView);
            imgFoto2 = (ImageView) itemView.findViewById(R.id.imgFoto2);
            tvNombreCV2 = (TextView) itemView.findViewById(R.id.tvNombreCV2);
            btnLike2 = (ImageButton) itemView.findViewById(R.id.btnLike2);
            tvNumeroLikeCV2 = (TextView) itemView.findViewById(R.id.tvNumeroLikeCV2);
            imgLike2 = (ImageView) itemView.findViewById(R.id.imgLike2);
        }
    }
}
