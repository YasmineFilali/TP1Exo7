package com.examples.tp1exo7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String nom = bundle.getString("nom");
        String prenom = bundle.getString("prenom");
        String age = bundle.getString("age");
        String domaine = bundle.getString("domaine");
        String num = bundle.getString("num");

        setContentView(R.layout.activity1);

        TextView tv1 = (TextView)findViewById(R.id.nom);
        tv1.setText(nom);
        TextView tv2 = (TextView)findViewById(R.id.prenom);
        tv2.setText(prenom);
        TextView tv3 = (TextView)findViewById(R.id.age);
        tv3.setText(age);
        TextView tv4 = (TextView)findViewById(R.id.domaine);
        tv4.setText(domaine);
        TextView tv5 = (TextView)findViewById(R.id.num);
        tv5.setText(num);

        Button b1 = (Button) findViewById(R.id.buttunOK);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.examples.tp1exo7.Activity1.this, com.examples.tp1exo7.Activity2.class);
                startActivity(intent);
            }
        });

        Button b2 = (Button) findViewById(R.id.buttunRet);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.examples.tp1exo7.Activity1.this.finish();
            }
        });

    }
}

