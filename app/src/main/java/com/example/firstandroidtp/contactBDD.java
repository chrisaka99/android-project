package com.example.firstandroidtp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class contactBDD {
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "db";
    private static String TABLE_CONTACT = "contact";
    private static final String COL_ID = "id";
    private static final int NUM_COL_ID = 0;

    private static final String COL_NOM = "nom ";
    private static final int NUM_COL_NOM = 1;
    private static final String COL_NUMERO = "contact";
    private static final int NUM_COL_NUMERO = 2;
    private SQLiteDatabase bdd;
    private database maBaseSQLite;
    public contactBDD(Context context){
//On crée la BDD et sa table
        maBaseSQLite = new database(context, NOM_BDD, null, VERSION_BDD);
    }
    public void open(){
//on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }
    public void close(){
//on ferme l'accès à la BDD
        bdd.close();
    }
    public SQLiteDatabase getBDD(){
        return bdd;
    }
    public long insertContact(contact Contact){
        ContentValues values = new ContentValues();
        values.put(COL_NOM, Contact.getNom());
        values.put(COL_NUMERO,Contact.getNumero());
        return bdd.insert(TABLE_CONTACT, "2", values);
    }
    public int updateContact(int id, contact Contact){
        ContentValues values = new ContentValues();
        values.put(COL_NOM, Contact.getNom());
        values.put(COL_NUMERO,Contact.getNumero());
        return bdd.update(TABLE_CONTACT, values, COL_ID + " = " +id, null);
    }
    public int removeContactWithID(int id){
//Suppression d'un livre de la BDD grâce à l'ID
        return bdd.delete(TABLE_CONTACT, COL_ID + " = " +id, null);
    }
    public contact getContactWithNom(){
        Cursor c = bdd.query(TABLE_CONTACT, new String[] {COL_ID, COL_NOM, COL_NUMERO},null,null,null,null,null);

        return cursorToContact(c);
    }
private contact cursorToContact(Cursor c){
            if (c.getCount() == 0)
                return null;
            c.moveToFirst();
            contact Contact = new contact();
            Contact.setId(c.getInt(NUM_COL_ID));
            Contact.setNom(c.getString(NUM_COL_NOM));
            Contact.setNumero(c.getInt(NUM_COL_NUMERO));
            c.close();
            return Contact;
        }
}
