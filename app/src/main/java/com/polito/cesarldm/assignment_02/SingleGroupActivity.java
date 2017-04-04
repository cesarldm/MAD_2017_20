package com.polito.cesarldm.assignment_02;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by CesarLdM on 3/4/17.
 */
public class SingleGroupActivity extends AppCompatActivity {
    //Icono de la lista de esta activity obtenido de www.icons8.com
    //ic8.link/15431
    ListView lv;
    EditText ed1;
    EditText ed2;
    TextView balance;
    double total;
    String name;
    ArrayList<Expenses> exp=new ArrayList<Expenses>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_group);
         lv=(ListView)findViewById(R.id.lv2);

        
        //Recuperamos los datos del grupo que enviamos a traves del intent desde GroupListActivity
        Intent myIntent = getIntent();
        name = myIntent.getStringExtra("Name");
        final double budget1 = myIntent.getDoubleExtra("Budget",0.00 );
        //Asignamos el presupuesto y el nombre de la actividad
        total=budget1;
        SingleGroupActivity.this.setTitle("Group "+name);

        //Definimos la accion a realizar cuando presionemos el FAB2
        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Recuperamos lo que ha escrito el usuario en los campos de expenses y cost
                ed1=(EditText)findViewById(R.id.etname);
                ed2=(EditText)findViewById(R.id.etcost);
                double temp= Double.parseDouble(ed2.getText().toString());
                //y creamos un objeto de la clase Expenses que se añade al arraylist
                Expenses e= new Expenses(ed1.getText().toString(), temp);
                exp.add(e);
                //inicializamos el adptador de la nueva lista
                ExpensesListAdapter adapter2=new ExpensesListAdapter(SingleGroupActivity.this,exp);
                lv.setAdapter(adapter2);
                //metodo que nos permite clcular cuanto dinero nos queda
                this.SetBalance(temp);




            }
            private void SetBalance (double temp) {
                total=total-temp;
                String t=Double.toString(total);
                balance=(TextView)findViewById(R.id.total);
                balance.setText("Total Blance "+t+"€");
                if(total<0) {
                    balance.setTextColor(ContextCompat.getColor(SingleGroupActivity.this, R.color.MoneyBad));
                }else{
                    balance.setTextColor(ContextCompat.getColor(SingleGroupActivity.this, R.color.MoneyGood));
                }
                balance.setTextSize(14);

            }


        });

    }


}
