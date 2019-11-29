package com.example.firstandroidtp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactItemAdapter extends BaseAdapter {
    private Context context;
    private List<ContactItem> contactItemList;
    private LayoutInflater inflater;

    public ContactItemAdapter(Context context, List<ContactItem> contactItemList){
        this.context = context;
        this.contactItemList = contactItemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return contactItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.adapter_item, null);

        //recuperer des infos d'un contact
        ContactItem item = (ContactItem) getItem(position);
        String nom_item = item.getNom();
        int num_item = item.getNumero();

        //Set nom contact
        TextView nameItem = convertView.findViewById(R.id.nom_contact);
        nameItem.setText(nom_item);

        //Set num Contact
        TextView numItem = convertView.findViewById(R.id.num_contact);
        numItem.setText(String.valueOf(num_item));

        return convertView;
    }
}
