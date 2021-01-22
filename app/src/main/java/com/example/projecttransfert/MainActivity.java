package com.example.projecttransfert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ActionBar;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

private LinearLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.myLayout =  (LinearLayout) findViewById(R.id.myDynamicLayout);

        ImageView image = new ImageView(this);
        ViewGroup.LayoutParams params = new ActionBar.LayoutParams(100, 100);
        image.setLayoutParams(params);
        image.setBackgroundResource(R.drawable.logo);
        myLayout.addView(image);
    }
@Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item:
                Toast.makeText(this, "Item selected" , Toast.LENGTH_LONG).show();
                return true;

            case R.id.accueil:
                Toast.makeText(this, "Accueil selected" , Toast.LENGTH_LONG).show();
                return true;

            case R.id.envoi:
                //Toast.makeText(this, "Envoi selected" , Toast.LENGTH_LONG).show();
                Intent intent= new Intent(MainActivity.this,EnvoiActivity.class);
                startActivity(intent);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}