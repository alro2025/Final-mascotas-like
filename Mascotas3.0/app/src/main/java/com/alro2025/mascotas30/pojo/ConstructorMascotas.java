package com.alro2025.mascotas30.pojo;

import android.content.ContentValues;
import android.content.Context;

import com.alro2025.mascotas30.Contacto;
import com.alro2025.mascotas30.R;
import com.alro2025.mascotas30.db.BaseDatos;
import com.alro2025.mascotas30.db.ConstantesBaseDatos;

import java.util.ArrayList;

/**
 * Created by angel on 5/03/2017.
 */

public class ConstructorMascotas {

    private Context context;
   private BaseDatos db;
    private static final int LIKE = 1;

    public ConstructorMascotas (Context context){
        this.context = context;
        this.db = new BaseDatos(context);
    }

    public ArrayList<ContactoMascota> obtenerMascotas(){
        insertarMascotas(db);
        return db.obtenerTodasLasMascotas();

    }

    public ArrayList<ContactoMascota> obtenerMascotaFav(){
        insertarMascotasFav(db);
        return db.obtenerTodasLasMascotasFav();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.burro);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "BURRO");

        db.insertarTablaMascotas(contentValues, ConstantesBaseDatos.TABLE_MASCOTA );

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.dino);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "DINO");

        db.insertarTablaMascotas(contentValues, ConstantesBaseDatos.TABLE_MASCOTA );

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.frank_mib);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "FRANK");

        db.insertarTablaMascotas(contentValues, ConstantesBaseDatos.TABLE_MASCOTA );

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.garfield);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "GARFIELD");

        db.insertarTablaMascotas(contentValues, ConstantesBaseDatos.TABLE_MASCOTA );

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perry);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "PERRY");

        db.insertarTablaMascotas(contentValues, ConstantesBaseDatos.TABLE_MASCOTA );

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.pluto);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "PLUTO");

        db.insertarTablaMascotas(contentValues, ConstantesBaseDatos.TABLE_MASCOTA );

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.salem);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "SALEM");

        db.insertarTablaMascotas(contentValues, ConstantesBaseDatos.TABLE_MASCOTA );

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.scooby_doo);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "SCOOBY-DOO");

        db.insertarTablaMascotas(contentValues, ConstantesBaseDatos.TABLE_MASCOTA );

    }

    public void darLikeMascota (ContactoMascota contactoMascota){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA, contactoMascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_LIKES_NUMERO, LIKE );
        db.insertarTablaMascotas(contentValues, ConstantesBaseDatos.TABLE_MASCOTA_LIKES);
    }

    public int obtenerLikesContacto(ContactoMascota contactoMascota){
        return db.obtenerLikesMascota(contactoMascota);
    }

    public void insertarMascotasFav(BaseDatos db){
        ArrayList<ContactoMascota> favoritas = db.queryMascotasFav();
        for (ContactoMascota favorito : favoritas){
            ContentValues contentValues = new ContentValues();

            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_ID, favorito.getId());
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, favorito.getFoto());
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, favorito.getNombre());
            db.insertarTablaMascotas(contentValues, ConstantesBaseDatos.TABLE_MASCOTA_FAVORITOS);
        }
    }
}
