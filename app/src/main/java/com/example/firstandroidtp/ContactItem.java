package com.example.firstandroidtp;

public class ContactItem {
    private int id;
    private String nom;
    private String numero;

    public ContactItem(int id, String nom, String numero){
        this.id = id;
        this.nom = nom;
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }
}
