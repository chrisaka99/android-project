package com.example.firstandroidtp;

public class ContactItem {
    private String nom;
    private int numero;

    public ContactItem(String nom, int numero){
        this.nom = nom;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }
}
