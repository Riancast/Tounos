package com.tounos.juego.tounos;

import java.util.Random;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.os.Handler;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends Activity {
    public static int s = 3;
    public static int l = 1;
    public static boolean tutorialmode = false;
    int tutorialcount = 0;
    Random generator = new Random();
    int count = 0;
    int currentlevel= l-1;
    int inputcount = 0;
    int highscore = 0;
    boolean firstdelay = true;
    int [] correctInput = new int[500];
    int lifes = 3;
    int rojo;
    int verde;
    int azul;
    int amarillo;
    int purpura;
    int naranja;
    int fallo;
    SoundPool soun;
    ToggleButton musica;
    TounosMenu tounosMenu;
    View view;
    ImageView corazon1;
    ImageView corazon2;
    ImageView corazon3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_tounos2);
        soun = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        rojo = soun.load(this,R.raw.rojo,0);
        verde = soun.load(this,R.raw.verde,0);
        azul = soun.load(this, R.raw.azul, 0);
        amarillo = soun.load(this, R.raw.amarillo, 0);
        naranja = soun.load(this, R.raw.naranja, 0);
        purpura = soun.load(this, R.raw.purpura, 0);
        fallo = soun.load(this, R.raw.fallo, 0);

        corazon1 = (ImageView)findViewById(R.id.corazon1);
        corazon2 = (ImageView)findViewById(R.id.corazon2);
        corazon3 = (ImageView)findViewById(R.id.corazon3);

        tounosMenu = (TounosMenu)Comunicador.getObjeto();

        musica = (ToggleButton)findViewById(R.id.musica);
        musica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                tounosMenu.togg.performClick();
            }
        });


        if(tounosMenu.togg.isChecked()){
           musica.setChecked(true);
        }


        if (tutorialmode){
            l = 1;
            currentlevel = 0;
            correctInput[0] = 1;
            correctInput[1] = 3;
            correctInput[2] = 1;
            correctInput[3] = 4;
            Toast.makeText(getApplicationContext(), "Pulsa el botón que parpadea.",
                    Toast.LENGTH_LONG).show();
        }

        Button atras = (Button)findViewById(R.id.atras);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });

        TounosSays(view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_activity_tounos, menu);
        return true;
    }


    public void lightupred(){
        ((Button) findViewById(R.id.Red)).setPressed(true);
        soun.play(rojo, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.Red)).setPressed(false);
            }
        }, 1400 / s);
    }

    public void lightupyellow(){
        ((Button) findViewById(R.id.Yellow)).setPressed(true);
        soun.play(amarillo, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.Yellow)).setPressed(false);
            }
        }, 1400 / s);
    }

    public void lightupgreen(){
        ((Button) findViewById(R.id.Green)).setPressed(true);
        soun.play(verde, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.Green)).setPressed(false);
            }
        }, 1400/s);
    }

    public void lightupblue(){
        ((Button) findViewById(R.id.Blue)).setPressed(true);
        soun.play(azul, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable(){
            public void run(){
                ((Button) findViewById(R.id.Blue)).setPressed(false);
            }
        }, 1400/s);
    }

    private void lightuporange() {
        ((Button) findViewById(R.id.Orange)).setPressed(true);
        soun.play(naranja, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.Orange)).setPressed(false);
            }
        }, 1400 / s);
    }

    private void lightuppurple() {
        ((Button) findViewById(R.id.Purple)).setPressed(true);
        soun.play(purpura, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.Purple)).setPressed(false);
            }
        }, 1400 / s);
    }

   /* public void lightupboton7(){
        ((Button) findViewById(R.id.boton7)).setPressed(true);
        soun.play(rojo, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.boton7)).setPressed(false);
            }
        }, 1400 / s);
    }

    public void lightupboton8(){
        ((Button) findViewById(R.id.boton8)).setPressed(true);
        soun.play(amarillo, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.boton8)).setPressed(false);
            }
        }, 1400 / s);
    }

    public void lightupboton9(){
        ((Button) findViewById(R.id.boton9)).setPressed(true);
        soun.play(verde, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.boton9)).setPressed(false);
            }
        }, 1400/s);
    }

    public void lightupboton10(){
        ((Button) findViewById(R.id.boton10)).setPressed(true);
        soun.play(azul, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable(){
            public void run(){
                ((Button) findViewById(R.id.boton10)).setPressed(false);
            }
        }, 1400/s);
    }

    private void lightupboton11() {
        ((Button) findViewById(R.id.boton11)).setPressed(true);
        soun.play(naranja, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.boton11)).setPressed(false);
            }
        }, 1400 / s);
    }

    private void lightupboton12() {
        ((Button) findViewById(R.id.boton12)).setPressed(true);
        soun.play(purpura, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable(){
            public void run(){
                ((Button) findViewById(R.id.boton12)).setPressed(false);
            }
        }, 1400/s);
    }
    public void lightupboton13(){
        ((Button) findViewById(R.id.boton13)).setPressed(true);
        soun.play(rojo, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.boton13)).setPressed(false);
            }
        }, 1400 / s);
    }

    public void lightupboton14(){
        ((Button) findViewById(R.id.boton14)).setPressed(true);
        soun.play(amarillo, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.boton14)).setPressed(false);
            }
        }, 1400 / s);
    }

    public void lightupboton15(){
        ((Button) findViewById(R.id.boton15)).setPressed(true);
        soun.play(verde, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.boton15)).setPressed(false);
            }
        }, 1400/s);
    }

    public void lightupboton16(){
        ((Button) findViewById(R.id.boton16)).setPressed(true);
        soun.play(azul, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable(){
            public void run(){
                ((Button) findViewById(R.id.boton16)).setPressed(false);
            }
        }, 1400/s);
    }

    private void lightupboton17() {
        ((Button) findViewById(R.id.boton17)).setPressed(true);
        soun.play(naranja, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.boton17)).setPressed(false);
            }
        }, 1400 / s);
    }

    private void lightupboton18() {
        ((Button) findViewById(R.id.boton18)).setPressed(true);
        soun.play(purpura, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable(){
            public void run(){
                ((Button) findViewById(R.id.boton18)).setPressed(false);
            }
        }, 1400/s);
    }

    public void lightupboton19(){
        ((Button) findViewById(R.id.boton19)).setPressed(true);
        soun.play(rojo, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.boton19)).setPressed(false);
            }
        }, 1400 / s);
    }

    public void lightupboton20(){
        ((Button) findViewById(R.id.Yellow)).setPressed(true);
        soun.play(amarillo, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.boton20)).setPressed(false);
            }
        }, 1400 / s);
    }

    public void lightupboton21(){
        ((Button) findViewById(R.id.boton21)).setPressed(true);
        soun.play(verde, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.boton21)).setPressed(false);
            }
        }, 1400/s);
    }

    public void lightupboton22(){
        ((Button) findViewById(R.id.boton22)).setPressed(true);
        soun.play(azul, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable(){
            public void run(){
                ((Button) findViewById(R.id.boton22)).setPressed(false);
            }
        }, 1400/s);
    }

    private void lightupboton23() {
        ((Button) findViewById(R.id.boton23)).setPressed(true);
        soun.play(naranja, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                ((Button) findViewById(R.id.boton23)).setPressed(false);
            }
        }, 1400 / s);
    }

    private void lightupboton24() {
        ((Button) findViewById(R.id.boton24)).setPressed(true);
        soun.play(purpura, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable(){
            public void run(){
                ((Button) findViewById(R.id.boton24)).setPressed(false);
            }
        }, 1400/s);
    }
     private void lightupboton25() {
        ((Button) findViewById(R.id.boton25)).setPressed(true);
        soun.play(purpura, 1, 1, 1, 0, 1);
        Handler h = new Handler();
        h.postDelayed(new Runnable(){
            public void run(){
                ((Button) findViewById(R.id.boton25)).setPressed(false);
            }
        }, 1400/s);
    }*/




    public void allthelights(){
        new CountDownTimer( (((1400/s)+1000/s)*(currentlevel+2)), ((1400/s)+1000/s) ){
            public void onTick(long millis){
                if (firstdelay){
                    firstdelay = false;
                }
                else if(correctInput[count] == 1){
                    lightupred();
                    count++;
                }
                else if(correctInput[count] == 2) {
                    lightupgreen();
                    count++;
                }
                else if(correctInput[count] == 3) {
                    lightupblue();
                    count++;
                }
                else if(correctInput[count] == 4) {
                    lightupyellow();
                    count++;
                }
                else if(correctInput[count] == 5) {
                    lightuporange();
                    count++;
                }
                else if(correctInput[count] == 6) {
                    lightuppurple();
                    count++;
                }
                /*else if(correctInput[count] == 7){
                    lightupboton7();
                    count++;
                }
                else if(correctInput[count] == 8) {
                    lightupboton8();
                    count++;
                }
                else if(correctInput[count] == 9) {
                    lightupboton9();
                    count++;
                }
                else if(correctInput[count] == 10) {
                    lightupboton10();
                    count++;
                }
                else if(correctInput[count] == 11) {
                    lightupboton11();
                    count++;
                }
                else if(correctInput[count] == 12) {
                    lightupboton12();
                    count++;
                }
                else if(correctInput[count] == 13){
                    lightupboton13();
                    count++;
                }
                else if(correctInput[count] == 14) {
                    lightupboton14();
                    count++;
                }
                else if(correctInput[count] == 15) {
                    lightupboton15();
                    count++;
                }
                else if(correctInput[count] == 16) {
                    lightupboton16();
                    count++;
                }
                else if(correctInput[count] == 17) {
                    lightupboton17();
                    count++;
                }
                else if(correctInput[count] == 18) {
                    lightupboton18();
                    count++;
                }
                else if(correctInput[count] == 19){
                    lightupboton19();
                    count++;
                }
                else if(correctInput[count] == 20) {
                    lightupboton20();
                    count++;
                }
                else if(correctInput[count] == 21) {
                    lightupboton21();
                    count++;
                }
                else if(correctInput[count] == 22) {
                    lightupboton22();
                    count++;
                }
                else if(correctInput[count] == 23) {
                    lightupboton23();
                    count++;
                }
                else if(correctInput[count] == 24) {
                    lightupboton24();
                    count++;
                }
                else if(correctInput[count] == 25) {
                    lightupboton25();
                    count++;
                }*/
            }

            public void onFinish(){
                count = 0;
                inputcount = 0;
                firstdelay = true;
                ((Button) findViewById(R.id.Red)).setEnabled(true);
                ((Button) findViewById(R.id.Yellow)).setEnabled(true);
                ((Button) findViewById(R.id.Green)).setEnabled(true);
                ((Button) findViewById(R.id.Blue)).setEnabled(true);
                ((Button) findViewById(R.id.Orange)).setEnabled(true);
                ((Button) findViewById(R.id.Purple)).setEnabled(true);
                /*((Button) findViewById(R.id.boton7)).setEnabled(true);
                ((Button) findViewById(R.id.boton8)).setEnabled(true);
                ((Button) findViewById(R.id.boton9)).setEnabled(true);
                ((Button) findViewById(R.id.boton10)).setEnabled(true);
                ((Button) findViewById(R.id.boton11)).setEnabled(true);
                ((Button) findViewById(R.id.boton12)).setEnabled(true);
                ((Button) findViewById(R.id.boton13)).setEnabled(true);
                ((Button) findViewById(R.id.boton14)).setEnabled(true);
                ((Button) findViewById(R.id.boton15)).setEnabled(true);
                ((Button) findViewById(R.id.boton16)).setEnabled(true);
                ((Button) findViewById(R.id.boton17)).setEnabled(true);
                ((Button) findViewById(R.id.boton18)).setEnabled(true);
                ((Button) findViewById(R.id.boton19)).setEnabled(true);
                ((Button) findViewById(R.id.boton20)).setEnabled(true);
                ((Button) findViewById(R.id.boton21)).setEnabled(true);
                ((Button) findViewById(R.id.boton22)).setEnabled(true);
                ((Button) findViewById(R.id.boton23)).setEnabled(true);
                ((Button) findViewById(R.id.boton24)).setEnabled(true);
                ((Button) findViewById(R.id.boton25)).setEnabled(true);*/


                /*TextView info = (TextView) findViewById(R.id.info);
                info.setText("Tu turno");*/
            }
        }.start();
    }



    public void levelup(){
        if (!tutorialmode){
            correctInput[currentlevel] = generator.nextInt(6) +1;
        }
        currentlevel++;
        count = 0;
        /*TextView info = (TextView) findViewById(R.id.info);
        info.setText("Turno de Tounos");*/
        ((Button) findViewById(R.id.Red)).setEnabled(false);
        ((Button) findViewById(R.id.Yellow)).setEnabled(false);
        ((Button) findViewById(R.id.Green)).setEnabled(false);
        ((Button) findViewById(R.id.Blue)).setEnabled(false);
        ((Button) findViewById(R.id.Orange)).setEnabled(false);
        ((Button) findViewById(R.id.Purple)).setEnabled(false);
        /*((Button) findViewById(R.id.boton7)).setEnabled(false);
                ((Button) findViewById(R.id.boton8)).setEnabled(false);
                ((Button) findViewById(R.id.boton9)).setEnabled(false);
                ((Button) findViewById(R.id.boton10)).setEnabled(false);
                ((Button) findViewById(R.id.boton11)).setEnabled(false);
                ((Button) findViewById(R.id.boton12)).setEnabled(false);
                ((Button) findViewById(R.id.boton13)).setEnabled(false);
                ((Button) findViewById(R.id.boton14)).setEnabled(false);
                ((Button) findViewById(R.id.boton15)).setEnabled(false);
                ((Button) findViewById(R.id.boton16)).setEnabled(false);
                ((Button) findViewById(R.id.boton17)).setEnabled(false);
                ((Button) findViewById(R.id.boton18)).setEnabled(false);
                ((Button) findViewById(R.id.boton19)).setEnabled(false);
                ((Button) findViewById(R.id.boton20)).setEnabled(false);
                ((Button) findViewById(R.id.boton21)).setEnabled(false);
                ((Button) findViewById(R.id.boton22)).setEnabled(false);
                ((Button) findViewById(R.id.boton23)).setEnabled(false);
                ((Button) findViewById(R.id.boton24)).setEnabled(false);
                ((Button) findViewById(R.id.boton25)).setEnabled(false);*/
        allthelights();
        highscore++;
        TextView scorebox = (TextView) findViewById(R.id.Scorebox);
        scorebox.setText("Puntuación: " + (highscore-1));
    }

    public void gameover(){

        lifes = 3;
        tutorialmode = false;
        inputcount = 0;
        for (int i =0; i<currentlevel;i++){
            correctInput[i] = 0;
        }
        currentlevel = l-1;
        if(tutorialmode){

        }else
        Dialogo();

        highscore = 0;

        ((Button) findViewById(R.id.Red)).setEnabled(false);
        ((Button) findViewById(R.id.Yellow)).setEnabled(false);
        ((Button) findViewById(R.id.Green)).setEnabled(false);
        ((Button) findViewById(R.id.Blue)).setEnabled(false);
        ((Button) findViewById(R.id.Orange)).setEnabled(false);
        ((Button) findViewById(R.id.Purple)).setEnabled(false);
        /*((Button) findViewById(R.id.boton7)).setEnabled(false);
                ((Button) findViewById(R.id.boton8)).setEnabled(false);
                ((Button) findViewById(R.id.boton9)).setEnabled(false);
                ((Button) findViewById(R.id.boton10)).setEnabled(false);
                ((Button) findViewById(R.id.boton11)).setEnabled(false);
                ((Button) findViewById(R.id.boton12)).setEnabled(false);
                ((Button) findViewById(R.id.boton13)).setEnabled(false);
                ((Button) findViewById(R.id.boton14)).setEnabled(false);
                ((Button) findViewById(R.id.boton15)).setEnabled(false);
                ((Button) findViewById(R.id.boton16)).setEnabled(false);
                ((Button) findViewById(R.id.boton17)).setEnabled(false);
                ((Button) findViewById(R.id.boton18)).setEnabled(false);
                ((Button) findViewById(R.id.boton19)).setEnabled(false);
                ((Button) findViewById(R.id.boton20)).setEnabled(false);
                ((Button) findViewById(R.id.boton21)).setEnabled(false);
                ((Button) findViewById(R.id.boton22)).setEnabled(false);
                ((Button) findViewById(R.id.boton23)).setEnabled(false);
                ((Button) findViewById(R.id.boton24)).setEnabled(false);
                ((Button) findViewById(R.id.boton25)).setEnabled(false);*/


        TextView scorebox = (TextView) findViewById(R.id.Scorebox);
        scorebox.setText("");
    }

    public void Dialogo(){
        final AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        LayoutInflater inflater= this.getLayoutInflater();
        view = inflater.inflate(R.layout.dialogo, null, true);
        dialogo1.setPositiveButton("Jugar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id2) {
                        TounosSays(view);
                    }
                }
        );
        dialogo1.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        finish();
                    }
                }
        );
        TextView textView = (TextView)view.findViewById(R.id.puntuacion_final);
        textView.setText("Tu puntuacion ha sido: " + (highscore - 1));
        dialogo1.setView(view);
        dialogo1.show();

    }

    public void TounosSays(View view){

        final MediaPlayer die= MediaPlayer.create(this, R.raw.die);
        corazon1.setVisibility(View.VISIBLE);
        corazon2.setVisibility(View.VISIBLE);
        corazon3.setVisibility(View.VISIBLE);


        for (int i=0; i< l-1; i++){
            correctInput[i] = generator.nextInt(6) +1;
        }

        levelup();


        Button red = ((Button) findViewById(R.id.Red));
        Button blue = ((Button) findViewById(R.id.Blue));
        Button green = ((Button) findViewById(R.id.Green));
        Button yellow = ((Button) findViewById(R.id.Yellow));
        Button orange = ((Button) findViewById(R.id.Orange));
        Button purple = ((Button) findViewById(R.id.Purple));


        red.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                if (1 == correctInput[inputcount]){
                    inputcount++;
                    soun.play(rojo, 1, 1, 1, 0, 1);
                    if (inputcount == currentlevel){
                        if (tutorialmode && tutorialcount == 0){
                            Toast.makeText(getApplicationContext(), "¡Buen trabajo! Tounos añadirá otro botón a la secuencia.",
                                    Toast.LENGTH_LONG).show();
                            tutorialcount++;
                        }
                        if (tutorialmode && tutorialcount == 2){
                            Toast.makeText(getApplicationContext(), "¡Le vas pillando el truco!",
                                    Toast.LENGTH_LONG).show();
                        }
                        levelup();
                    }
                }
                else {
                    if (tutorialmode){
                        Toast.makeText(getApplicationContext(), "Este no es el botón correcto, inténtalo de nuevo.",
                                Toast.LENGTH_LONG).show();
                    } else {
                        if(lifes>1){
                            soun.play(fallo,1,1,1,0,1);
                           lifes--;
                            if(lifes==2){
                                corazon3.setVisibility(View.INVISIBLE);
                            }else{
                                corazon2.setVisibility(View.INVISIBLE);
                            }
                        }else {
                            die.start();
                            corazon1.setVisibility(View.INVISIBLE);
                            gameover();
                        }
                    }
                }
            }
        });

        purple.setOnClickListener(new OnClickListener(){
            public void onClick(View v){

                if (6 == correctInput[inputcount]){
                    inputcount++;
                    soun.play(purpura, 1, 1, 1, 0, 1);
                    if (inputcount == currentlevel){
                        if (tutorialmode){
                            Toast.makeText(getApplicationContext(), "¡Buen trabajo!",
                                    Toast.LENGTH_LONG).show();
                            tutorialcount++;
                        }
                        levelup();
                    }
                }
                else {
                    if (tutorialmode){
                        Toast.makeText(getApplicationContext(), "Este no es el botón correcto, inténtalo de nuevo.",
                                Toast.LENGTH_LONG).show();
                    } else {
                        if(lifes>1){
                            soun.play(fallo,1,1,1,0,1);
                            lifes--;
                            if(lifes==2){
                                corazon3.setVisibility(View.INVISIBLE);
                            }else{
                                corazon2.setVisibility(View.INVISIBLE);
                            }
                        }else {
                            gameover();
                            corazon1.setVisibility(View.INVISIBLE);
                            die.start();
                        }
                    }
                }
            }
        });

        orange.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                if (5 == correctInput[inputcount]) {
                    inputcount++;
                    soun.play(naranja, 1, 1, 1, 0, 1);
                    if (inputcount == currentlevel) {
                        if (tutorialmode) {
                            Toast.makeText(getApplicationContext(), "¡Buen trabajo!",
                                    Toast.LENGTH_LONG).show();
                            tutorialcount++;
                        }
                        levelup();
                    }
                } else {
                    if (tutorialmode) {
                        Toast.makeText(getApplicationContext(), "Este no es el botón correcto, inténtalo de nuevo.",
                                Toast.LENGTH_LONG).show();
                    } else {
                        if(lifes>1){
                            soun.play(fallo,1,1,1,0,1);
                            lifes--;
                            if(lifes==2){
                                corazon3.setVisibility(View.INVISIBLE);
                            }else{
                                corazon2.setVisibility(View.INVISIBLE);
                            }
                        }else {
                            gameover();
                            corazon1.setVisibility(View.INVISIBLE);

                            die.start();
                        }
                    }
                }
            }
        });

        blue.setOnClickListener(new OnClickListener(){
            public void onClick(View v){

                if (3 == correctInput[inputcount]){
                    inputcount++;
                    soun.play(azul, 1, 1, 1, 0, 1);
                    if (inputcount == currentlevel){
                        if (tutorialmode){
                            Toast.makeText(getApplicationContext(), "¡Buen trabajo!",
                                    Toast.LENGTH_LONG).show();
                            tutorialcount++;
                        }
                        levelup();
                    }
                }
                else {
                    if (tutorialmode){
                        Toast.makeText(getApplicationContext(), "Este no es el botón correcto, inténtalo de nuevo.",
                                Toast.LENGTH_LONG).show();
                    } else {
                        if(lifes>1){
                            soun.play(fallo,1,1,1,0,1);
                            lifes--;
                            if(lifes==2){
                                corazon3.setVisibility(View.INVISIBLE);
                            }else{
                                corazon2.setVisibility(View.INVISIBLE);
                            }
                        }else {
                            gameover();
                            corazon1.setVisibility(View.INVISIBLE);
                            die.start();
                        }
                    }
                }
            }
        });

        yellow.setOnClickListener(new OnClickListener(){
            public void onClick(View v){

                if (4 == correctInput[inputcount]){
                    inputcount++;
                    soun.play(amarillo, 1, 1, 1, 0, 1);
                    if (inputcount == currentlevel){
                        if (tutorialmode){
                            Toast.makeText(getApplicationContext(), "¡Enhorabuena! ¡Has completado el tutorial!.",
                                    Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            levelup();
                        }
                    }
                }
                else {
                    if (tutorialmode){
                        Toast.makeText(getApplicationContext(), "Este no es el botón correcto, inténtalo de nuevo.",
                                Toast.LENGTH_LONG).show();
                    } else {
                        if(lifes>1){
                            soun.play(fallo,1,1,1,0,1);
                            lifes--;
                            if(lifes==2){
                                corazon3.setVisibility(View.INVISIBLE);
                            }else{
                                corazon2.setVisibility(View.INVISIBLE);
                            }
                        }else {
                            gameover();
                            corazon1.setVisibility(View.INVISIBLE);
                            die.start();
                        }
                    }
                }
            }
        });

        green.setOnClickListener(new OnClickListener(){
            public void onClick(View v){

                if (tutorialmode){
                    Toast.makeText(getApplicationContext(), "Haz lo que Tounos ha indicado. Inténtalo de nuevo.",
                            Toast.LENGTH_LONG).show();
                } else {

                    if (2 == correctInput[inputcount]){
                        inputcount++;
                        soun.play(verde, 1, 1, 1, 0, 1);
                        if (inputcount == currentlevel){
                            levelup();
                        }
                    }
                    else {
                        if(lifes>1){
                            soun.play(fallo,1,1,1,0,1);
                            lifes--;
                            if(lifes==2){
                                corazon3.setVisibility(View.INVISIBLE);
                            }else{
                                corazon2.setVisibility(View.INVISIBLE);
                            }
                        }else {
                            gameover();
                            corazon1.setVisibility(View.INVISIBLE);
                            die.start();
                        }
                    }
                }
            }
        });



    }
}
