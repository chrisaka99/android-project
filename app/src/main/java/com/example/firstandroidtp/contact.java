package com.example.firstandroidtp;

public class contact {
    private int id;
    private String nom;
    private int numero;
    public contact(){}
    public contact(String nom, int numero){
        this.nom = nom;
        this.numero = numero;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String toString(){
        return "ID : "+id+"\nNom : "+nom+"\nNumero : "+numero;
    }
}

