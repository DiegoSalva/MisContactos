package com.example.diegosalva.miscontactos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by DIEGO SALVA on 25/05/2016.
 */
public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos=contactos;
        this.activity=activity;

    }



    @Override //Inflar el layout y lo pasará al viewholder para que el obtenga los view
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override //Asocia cada elemento de la lista con cada view
    public void onBindViewHolder(ContactoViewHolder holder, int position) {
        final Contacto contacto= contactos.get(position);
        holder.ivFotoCV.setImageResource(contacto.getFoto());
        holder.tvNombreCV.setText(contacto.getNombre());
        holder.tvTelefonoCV.setText(contacto.getTelefono());
        holder.tvEmailCV.setText(contacto.getEmail());

        holder.bLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a "+ contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.ivFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(activity, DetalleContacto.class);
                //intent.putExtra("foto", contacto.getFoto());
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });

    }

    @Override //Devuelve la cantidad de elementos
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFotoCV;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private TextView tvEmailCV;
        private ImageButton bLike;


        public ContactoViewHolder(View itemView) {
            super(itemView);

            ivFotoCV = (ImageView) itemView.findViewById(R.id.ivFotoCV);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            tvEmailCV = (TextView) itemView.findViewById(R.id.tvEmailCV);
            bLike= (ImageButton) itemView.findViewById(R.id.bLike);

        }
    }
}
