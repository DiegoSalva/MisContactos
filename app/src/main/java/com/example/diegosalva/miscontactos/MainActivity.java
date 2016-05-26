package com.example.diegosalva.miscontactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listacontactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar =(Toolbar) findViewById(R.id.miActionbar);
        setSupportActionBar(miActionBar);

        listacontactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listacontactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        }

        /*
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
        */

/*Método creado para inicializar el adaptador en el ejemplo inicial (sin el Toast)
    public void inicializarAdaptador() {
        ContactoAdaptador adaptador = new ContactoAdaptador (contactos);
        listacontactos.setAdapter(adaptador);*/

    public ContactoAdaptador adaptador;
    private void inicializarAdaptador() {
        adaptador = new ContactoAdaptador (contactos, this);
        listacontactos.setAdapter(adaptador);

    }

    public void inicializarListaContactos() {

        contactos = new ArrayList<Contacto> ();

        contactos.add(new Contacto(R.drawable.cleveland, "Diego Salvá", "974978745", "diegosalvam@gmail.com"));
        contactos.add(new Contacto(R.drawable.bart, "Joel Viera", "990386354", "jodacalle@gmail.com"));
        contactos.add(new Contacto(R.drawable.stan_smith, "Edmir Salvá", "982367354", "diego_628s@gmail.com"));
        contactos.add(new Contacto(R.drawable.louise_belcher, "Giuliana Grimaldi", "992014725", "gugigirlm@gmail.com"));
        contactos.add(new Contacto(R.drawable.groundskeeper_willie, "Juan Perez", "987654321", "juanperez@gmail.com"));
        contactos.add(new Contacto(R.drawable.consuela, "Zulaikah Miranda", "950821125", "zulamirblas@gmail.com"));
        contactos.add(new Contacto(R.drawable.tina_render, "Jahaira Liñan", "956847114", "jahairalm@gmail.com"));
        contactos.add(new Contacto(R.drawable.roger, "Sigrid Bazan", "922245778", "sigrid_bazan@gmail.com"));

        //Este método ya no lo necesitamos, porque lo usábamos para colocar los datos de nuestro arreglo en el listview
        /*ArrayList<String> nombreContacto = new ArrayList<>();
        for (Contacto contacto: contactos) {
            nombreContacto.add(contacto.getNombre());*/

        }
    }


