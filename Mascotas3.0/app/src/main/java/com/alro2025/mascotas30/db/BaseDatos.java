package com.alro2025.mascotas30.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.alro2025.mascotas30.pojo.ContactoMascota;

import java.util.ArrayList;

/**
 * Created by angel on 5/03/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;



    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascotas = "CREATE TABLE " +
                ConstantesBaseDatos.TABLE_MASCOTA+"("
                +ConstantesBaseDatos.TABLE_MASCOTA_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +ConstantesBaseDatos.TABLE_MASCOTA_FOTO+" INTEGER, "
                +ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE+" TEXT"+
                ")";

        String queryCrearTablaLikesMascotas = "CREATE TABLE " +
                ConstantesBaseDatos.TABLE_MASCOTA_LIKES+" ("
                +ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID +" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA+" INTEGER ,"
                +ConstantesBaseDatos.TABLE_MASCOTA_LIKES_NUMERO+" INTEGER ,"
                +"FOREIGN KEY ("+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA+") REFERENCES "+ConstantesBaseDatos.TABLE_MASCOTA+"("+ConstantesBaseDatos.TABLE_MASCOTA_ID+")"
                +")";

        String queryCrearTablaMascotasFav = "CREATE TABLE " +
                ConstantesBaseDatos.TABLE_MASCOTA_FAVORITOS+" ("
                +ConstantesBaseDatos.TABLE_MASCOTA_ID +" INTEGER PRIMARY KEY ,"
                +ConstantesBaseDatos.TABLE_MASCOTA_FOTO+" INTEGER ,"
                +ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE+" TEXT "+
                ")";


        db.execSQL(queryCrearTablaMascotas);
        db.execSQL(queryCrearTablaLikesMascotas);
        db.execSQL(queryCrearTablaMascotasFav);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDatos.TABLE_MASCOTA_LIKES);
        db.execSQL("DROP TABLE IF EXIST "+ConstantesBaseDatos.TABLE_MASCOTA_FAVORITOS);
        onCreate(db);
    }

    public ArrayList<ContactoMascota> obtenerTodasLasMascotas(){
        ArrayList<ContactoMascota> contactoMascotas = new ArrayList<>();

        String queryMascotas = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(queryMascotas, null);

        while (registros.moveToNext()){
            ContactoMascota mascotaActual = new ContactoMascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setFoto(registros.getInt(1));
            mascotaActual.setNombre(registros.getString(2));

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID + ") " +
                                " FROM " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES +
                                " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else{
                mascotaActual.setLikes(0);
            }
            contactoMascotas.add(mascotaActual);
        }
        db.close();
        return contactoMascotas;
    }

    public void insertarTablaMascotas (ContentValues contentValues, String table){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(table, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota (ContactoMascota contactoMascota){
        int likes = 0;

        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_NUMERO + ")" +
                        " FROM " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES +
                        " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + "=" + contactoMascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;

    }

    public ArrayList<ContactoMascota> obtenerTodasLasMascotasFav(){
        ArrayList<ContactoMascota> contactoMascotas = new ArrayList<>();

        String queryMascotas = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA_FAVORITOS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(queryMascotas, null);

        while (registros.moveToNext()){
            ContactoMascota mascotaActual = new ContactoMascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setFoto(registros.getInt(1));
            mascotaActual.setNombre(registros.getString(2));

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_NUMERO + ") as likes " +
                                " FROM " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES +
                                " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + "=" + mascotaActual.getId();
            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setNumlikes(registrosLikes.getInt(0));
            }else{
                mascotaActual.setNumlikes(0);
            }
            contactoMascotas.add(mascotaActual);
        }
        db.close();
        return contactoMascotas;
    }

    public ArrayList<ContactoMascota> queryMascotasFav(){
        ArrayList<ContactoMascota> contactoMascotas = new ArrayList<>();

        String queryMascotas = "" +
                "SELECT masc.* FROM "+ConstantesBaseDatos.TABLE_MASCOTA+" masc INNER JOIN\n" +
                "(SELECT SUM(numero_likes) as suma,id_mascota FROM "+ConstantesBaseDatos.TABLE_MASCOTA_LIKES+
                " GROUP BY "+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA+
                " ORDER BY suma DESC LIMIT 5) as top5 ON top5."+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA+" = masc."+ConstantesBaseDatos.TABLE_MASCOTA_ID+"";
        System.out.print(queryMascotas);

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + ConstantesBaseDatos.TABLE_MASCOTA_FAVORITOS);
        Cursor registros = db.rawQuery(queryMascotas, null);

        while (registros.moveToNext()){
            ContactoMascota mascotaActual = new ContactoMascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setFoto(registros.getInt(1));
            mascotaActual.setNombre(registros.getString(2));

            contactoMascotas.add(mascotaActual);
        }
        db.close();
        return contactoMascotas;
    }
}
