package com.example.projecttransfert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class EnvoiActivity extends AppCompatActivity {
//===================  DECLARATION DES VARIABLE =========================
   private Button btnSuiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envoi);

//===================  GESTION DES EVENEMENTS =========================
        btnSuiv=findViewById(R.id.btnSuiv);
        btnSuiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EnvoiActivity.HttpReqTask().execute();

                Intent intent = new Intent(EnvoiActivity.this, EmetteurActivity.class);
                startActivity(intent);

            }
        });


    }
    private class HttpReqTask extends AsyncTask<Void, Void, Envoi[]> {

        @Override
        protected Envoi[] doInBackground(Void... params) {

            try {
                String apiUrl = "";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Envoi[ ] envois = restTemplate.getForObject(apiUrl, Envoi[].class);

                return envois;

            } catch (Exception ex){
                Log.e("",ex.getMessage());

            }
            return null;
        }
        protected void  onPostExecute(Envoi[] envois){
            super.onPostExecute(envois  );


            for(Envoi ev: envois){
                Log.i("Envoi: ", "envoi effectué");
                Log.i("envoi_id: ", String.valueOf(ev.getId()));
                Log.i("envoi_montant: ",String.valueOf(ev.getMontant()));
                Log.i("emetteur_date: ",String.valueOf(ev.getDateenvoi()));




            }
        }

}
}