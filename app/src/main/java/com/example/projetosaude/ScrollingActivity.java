package com.example.projetosaude;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class ScrollingActivity extends AppCompatActivity {

    public String telefoneUbs = "8332116712";
    public String enderecoUbs = "Rua Mascarenhas De Morais, Mandacaru, João Pessoa";

    public String telefoneUpa = "8332149287";
    public String enderecoUpa = "Av. Gov. Flávio Ribeiro Coutinho, 70 - Oceania, João Pessoa";

    public String telefoneHosp = "8332165700";
    public String enderecoHosp = "R. Orestes Lisboa, SN - Pedro Gondim, João Pessoa - PB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
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

    public void telefonarUbs(View view) {
        if (ActivityCompat.checkSelfPermission(ScrollingActivity.this, Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(ScrollingActivity.this,
                new String[]{Manifest.permission.CALL_PHONE}, 123);
        } else {
            Intent intentLigar = new Intent(Intent.ACTION_CALL);
            intentLigar.setData(Uri.parse("tel:" + telefoneUbs));
            startActivity(intentLigar);
        }
    }

    public void mapaUbs(View view) {
        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q=" +  enderecoUbs));
        startActivity(intentMapa);
    }

    public void telefonarUpa(View view) {
        if (ActivityCompat.checkSelfPermission(ScrollingActivity.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ScrollingActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE}, 123);
        } else {
            Intent intentLigar = new Intent(Intent.ACTION_CALL);
            intentLigar.setData(Uri.parse("tel:" + telefoneUpa));
            startActivity(intentLigar);
        }
    }

    public void mapaUpa(View view) {
        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q=" +  enderecoUpa));
        startActivity(intentMapa);
    }

    public void telefonarHosp(View view) {
        if (ActivityCompat.checkSelfPermission(ScrollingActivity.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ScrollingActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE}, 123);
        } else {
            Intent intentLigar = new Intent(Intent.ACTION_CALL);
            intentLigar.setData(Uri.parse("tel:" + telefoneHosp));
            startActivity(intentLigar);
        }
    }

    public void mapaHosp(View view) {
        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q=" +  enderecoHosp));
        startActivity(intentMapa);
    }


}
