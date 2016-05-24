package com.example.diegosalva.miscontactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<Contacto> ();

        contactos.add(new Contacto("Diego Salvá", "974978745", "diegosalvam@gmail.com"));
        contactos.add(new Contacto("Joel Viera", "990386354", "jodacalle@gmail.com"));
        contactos.add(new Contacto("Edmir Salvá", "982367354", "diego_628s@gmail.com"));
        contactos.add(new Contacto("Giuliana Grimaldi", "992014725", "gugigirlm@gmail.com"));
        contactos.add(new Contacto("Juan Perez", "987654321", "juanperez@gmail.com"));
        contactos.add(new Contacto("Zulaikah Miranda", "950821125", "zulamirblas@gmail.com"));
        contactos.add(new Contacto("Jahaira Liñan", "956847114", "jahairalm@gmail.com"));
        contactos.add(new Contacto("Sigrid Bazan", "922245778", "sigrid_bazan@gmail.com"));

        ArrayList<String> nombreContacto = new ArrayList<>();
        for (Contacto contacto: contactos) {
            nombreContacto.add(contacto.getNombre());
            
        }

        ListView lvContactos= (ListView) findViewById(R.id.lvContactos);
        lvContactos.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, nombreContacto));

        lvContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());

                startActivity(intent);
                finish();
            }
        });

    }
}
