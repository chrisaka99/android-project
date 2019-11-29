package com.example.firstandroidtp;

public class ContactItem {
    private String nom;
    private String numero;

    public ContactItem(String nom, String numero){
        this.nom = nom;
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }
}
