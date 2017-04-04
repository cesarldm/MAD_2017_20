package com.polito.cesarldm.assignment_02;
/**
 * Created by CesarLdM on 3/4/17.
 */
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.acl.*;
import java.util.ArrayList;

public class GroupListActivity extends AppCompatActivity {
    /*Declaramos los elementos que muestra nuestra pantalla GRUPOS
    -Floating Action Button,Listview
    y los elementos donde guardamos los objetos de la clase Grupo y el array de ints para los iconos
    */
    FloatingActionButton fab;
    ListView lv;
    ArrayList<Group> groups=new ArrayList<Group>();
    //Los iconos son png descargados de internet y guardados en la carpeta "drawable"
    //pag:www.icons8.com
    int[] img={R.drawable.conf,R.drawable.party, R.drawable.wed, R.drawable.time};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);
        this.TemporalFillList();
        //Inicializamos el FAB, la LISTVIEW y el CUSTOMADAPTER(objeto de la clase GroupListAdapter
        fab=(FloatingActionButton) findViewById(R.id.fab1);
        lv=(ListView)findViewById(R.id.lv1);
        GroupListAdapter adapter=new GroupListAdapter(this,groups,img);
        //Enlazamos el objeto LISTVIEW con el ADAPTER
        lv.setAdapter(adapter);
        //configuramos los items de la lista y el fab para que esten atentos a toques del usuario
        lv.setOnItemClickListener(new Itemlist());
        fab.setOnClickListener(new FabClick());


    }
    //Por ahora rellenamos la lista de grupos estáticamente(tendremos que hacerlo dinamicamente
    private void TemporalFillList() {
        Group g1 = new Group("Flatmates",500,1);
        Group g2 = new Group("Party",80,2);
        Group g3 = new Group("Ana's wedding",2000,3);
        Group g4 = new Group("MAD Project",5,4);

        groups.add(g1);
        groups.add(g2);
        groups.add(g3);
        groups.add(g4);


    }
    //Clase interna para definir que hacen los items de la lista la ser tocados
     class Itemlist implements AdapterView.OnItemClickListener {
        @Override
         public void onItemClick(AdapterView<?> parent,View view,int position,long id){
            ViewGroup vg=(ViewGroup) view;
            //obtenemos el nombre y el presupuesto del grupo seleccionado
            String a=groups.get(position).getName();
            double b=groups.get(position).getBudget();
            Toast.makeText(GroupListActivity.this,a +" "+ String.valueOf(b),Toast.LENGTH_SHORT).show();
            //Inicializamo una actividad pasandole como datos el nombre del grupo y el presupuesto
            //para utilizarlos en la siguiente actividad
            Intent myIntent = new Intent(GroupListActivity.this, SingleGroupActivity.class);
            myIntent.putExtra("Name",a);
            myIntent.putExtra("Budget",b);
            startActivity(myIntent);


        }

    }

//AQUI  INSERTAR NUEVO GRUPOS EN LA LISTA CON EL FAB (AUN NO FUNCIONA)
    private class FabClick implements AdapterView.OnClickListener {
        @Override
        public void onClick(View v) {
            Group gnew=new Group("Nuevo grupo",0,5);
            groups.add(gnew);
            Toast.makeText(GroupListActivity.this,gnew.getName(),Toast.LENGTH_SHORT).show();
        }
    }
}
