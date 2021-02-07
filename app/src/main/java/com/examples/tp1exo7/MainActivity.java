package com.examples.tp1exo7;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int DIALOG_ALERT = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b =(Button) findViewById (R.id.valider);
        b.setOnClickListener(new View . OnClickListener () {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ALERT);

            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id)
    {
        switch(id) {
            case DIALOG_ALERT :
                // Create out AlterDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Êtes vous sûr de vouloir confirmer ?");
                builder.setCancelable(true);
                builder.setPositiveButton("Confirmer", new OkOnClickListener ());
                builder.setNegativeButton("Annuler", new CancelOnClickListener ());
                AlertDialog dialog = builder . create ();
                dialog.show();
        }
        return super.onCreateDialog(id);
    }

    private final class CancelOnClickListener implements
            DialogInterface.OnClickListener
    {
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getApplicationContext(), "Annuler",
                    Toast.LENGTH_LONG).show();
        }
    }

    private final class OkOnClickListener implements
            DialogInterface.OnClickListener
    {
        public void onClick(DialogInterface dialog, int which) {
            EditText et =(EditText) findViewById (R.id.nom);
            String nom = String . valueOf (et.getText());
            String prenom = String . valueOf (((EditText) findViewById (R.id.prenom)).getText());
            String age = String . valueOf (((EditText) findViewById (R.id.age)).getText());
            String domaine = String . valueOf (((EditText) findViewById (R.id.domaine)).getText());
            String num = String . valueOf (((EditText) findViewById (R.id.num)).getText());


            Intent intent = new Intent(com.examples.tp1exo7.MainActivity.this, Activity1.class);
            Bundle extra = new Bundle();

            extra.putString("nom", nom);
            extra.putString("prenom", prenom);
            extra.putString("age", age);
            extra.putString("domaine", domaine);
            extra.putString("num", num);

            intent.putExtras(extra);
            startActivity(intent);
        }
    }
}