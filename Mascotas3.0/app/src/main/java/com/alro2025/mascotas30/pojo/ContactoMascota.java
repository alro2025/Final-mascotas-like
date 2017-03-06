package com.alro2025.mascotas30.pojo;

/**
 * Created by angel on 5/03/2017.
 */

public class ContactoMascota {

    private int foto;
    private String nombre;
    private int numlikes ;
    private int id;
    private int likes = 0;

    public ContactoMascota(){

    }



    public ContactoMascota(int foto, String nombre, int numlikes){
        this.foto = foto;
        this.nombre = nombre;
        this.numlikes = numlikes;

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getNumlikes() {
        return numlikes;
    }

    public void setNumlikes(int numlikes) {
        this.numlikes = numlikes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}


