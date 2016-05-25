package com.tounos.juego.tounos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ayuda extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayuda);


        Button ok2 = (Button) findViewById(R.id.ok2);
        ok2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }

        });


        Button tut = (Button) findViewById(R.id.tutorial);
        tut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                MainActivity.tutorialmode = true;
                Intent intent1 = new Intent(Ayuda.this, MainActivity.class);
                startActivity(intent1);
            }

        });
    }
}
