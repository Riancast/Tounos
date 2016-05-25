package com.tounos.juego.tounos;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class TounosMenu extends Activity implements OnClickListener {

    static ToggleButton togg;
    MediaPlayer bgr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        bgr = MediaPlayer.create(this, R.raw.background);
        togg = (ToggleButton) findViewById(R.id.togg);
        final MediaPlayer start2= MediaPlayer.create(this, R.raw.start);
        togg.setOnClickListener(this);


        Button start;
        start = (Button) findViewById(R.id.btn_start);
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                MainActivity.tutorialmode = false;
                start2.start();
                Intent intent1 = new Intent(TounosMenu.this, MainActivity.class);
                Comunicador.setObjeto(TounosMenu.this);
                startActivity(intent1);
            }

        });

        Button exit = (Button) findViewById(R.id.btn_exit);
        exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                /*Intent intent2 = new Intent(Intent.ACTION_MAIN);
                intent2.addCategory(Intent.CATEGORY_HOME);
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent2);
                stopPlaying();*/
                finish();
                stopPlaying();
            }

        });

        Button option = (Button) findViewById(R.id.btn_options);
        option.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent3 = new Intent(TounosMenu.this, Opciones.class);
                startActivity(intent3);
            }

        });

        Button help = (Button) findViewById(R.id.btn_help);
        help.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent4 = new Intent(TounosMenu.this, Ayuda.class);
                startActivity(intent4);
            }

        });

    }

    static public void onClick2() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.togg:
                if (togg.isChecked()) {
                    bgr.start();
                    bgr.setLooping(true);
                } else
                    bgr.pause();
                break;
        }

    }

    private void stopPlaying() {
        if (bgr != null) {
            bgr.stop();
            bgr.release();
            bgr = null;
        }
    }
}
