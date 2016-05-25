package com.tounos.juego.tounos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;


public class Opciones extends Activity implements OnItemSelectedListener{
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opciones_tounos);

        Button back = (Button) findViewById(R.id.ok);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }

        });

        spinner = (Spinner) findViewById(R.id.lvlspinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.InitialLevels, R.layout.spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        int selection = spinner.getSelectedItemPosition();
        switch (selection){
            case 0:
                MainActivity.l = 1;
                break;
            case 1:
                MainActivity.l = 2;
                break;
            case 2:
                MainActivity.l = 3;
                break;
            case 3:
                MainActivity.l = 4;
                break;
            case 4:
                MainActivity.l = 5;
                break;
            case 5:
                MainActivity.l = 6;
                break;
            case 6:
                MainActivity.l = 7;
                break;
            case 7:
                MainActivity.l = 8;
                break;
            case 8:
                MainActivity.l = 9;
                break;
            case 9:
                MainActivity.l = 10;
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }







    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.fast:
                if (checked){
                    MainActivity.s = 4;
                    break;
                }
            case R.id.medium:
                if (checked){
                    MainActivity.s = 3;
                    break;
                }
            case R.id.slow:
                if (checked){
                    MainActivity.s = 2;
                    break;
                }
        }
    }





}
