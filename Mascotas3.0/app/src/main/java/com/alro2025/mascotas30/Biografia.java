package com.alro2025.mascotas30;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class Biografia extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView nombre, descripcion;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biografia);

        toolbar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        nombre = (TextView) findViewById(R.id.tvNombreBio);
        descripcion = (TextView) findViewById(R.id.tvDescripcion);
        foto = (ImageView) findViewById(R.id.civFoto);


        //botón de subir
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        //cambiamos el título de appbar
        ab.setTitle("Biografía");
    }
}

