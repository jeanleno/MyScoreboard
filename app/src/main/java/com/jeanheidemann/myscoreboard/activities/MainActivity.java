package com.jeanheidemann.myscoreboard.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.jeanheidemann.myscoreboard.R;
import com.jeanheidemann.myscoreboard.dao.ModalitySettingsDAO;
import com.jeanheidemann.myscoreboard.entity.ModalitySettings;
import com.jeanheidemann.myscoreboard.enums.Order;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnFootball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.btnFootball = (Button) findViewById(R.id.btnFootball);
        this.btnFootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Teste", Toast.LENGTH_SHORT).show();

                ModalitySettingsDAO dao = new ModalitySettingsDAO();
                ModalitySettings settings = new ModalitySettings();

                settings.setInitialPoints(1);
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(1);
                settings.setListPossiblePoints(list);
                settings.setName("Futebol");
                settings.setMaxTeams(2);
                settings.setOrder(Order.ASC);

                try {
                    dao.saveModalitySettings(settings, MainActivity.this);
                    Toast.makeText(MainActivity.this, "Modalidade salva com sucesso!!!: " + MainActivity.this.getFilesDir().toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Erro ao salvar: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
                }

                try {
                    FileInputStream in = openFileInput("Modality_Futebol.xml");
                    InputStreamReader inputStreamReader = new InputStreamReader(in);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        sb.append(line);
                    }
                    Toast.makeText(MainActivity.this, "XML: " + sb.toString(), Toast.LENGTH_LONG).show();
                } catch(Exception ex) {
                    Toast.makeText(MainActivity.this, "Erro ao recuperar: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
