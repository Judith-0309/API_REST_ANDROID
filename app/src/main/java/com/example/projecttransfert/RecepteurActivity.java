package com.example.projecttransfert;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;



public class RecepteurActivity extends AppCompatActivity {


    //====================DECLARATION DES VARIABLE=======================
    private Button btnSubmit;
    private TextView txtInfo;
    //private TextView myPopup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepteur);



        //===================  GESTION DES EVENEMENTS =========================

        btnSubmit=findViewById(R.id.btnSubmit);
        txtInfo=findViewById(R.id.txtInfo);
       // btnSubmit.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
                //AlertDialog.Builder myPopup = new AlertDialog.Builder(activity);
                //myPopup.setMessage("Envoi effectué ");
           // }
        //});
        btnSubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String URL="http://10.42.0.1:8080/api/envois";
               RequestQueue requestQueue= Volley.newRequestQueue(RecepteurActivity.this);

               JsonObjectRequest objectRequest=new JsonObjectRequest(
                       Request.Method.POST,
                       URL,
                       null,
                       new Response.Listener<JSONObject>() {
                           @Override
                           public void onResponse(JSONObject response) {


                              // Log.e("Rest Response" ,response.toString());
                               txtInfo.setText(response.toString());
                           }
                       },
                       new Response.ErrorListener() {
                           @Override
                           public void onErrorResponse(VolleyError error) {
                              // Log.e("Rest Response" ,error.toString());
                               txtInfo.setText(error.toString());


                           }
                       }
               );
               requestQueue.add(objectRequest);

                //Intent intent = new Intent(RecepteurActivity.this, MainActivity.class);
                //startActivity(intent);
               //AlertDialog.Builder myPopup = new AlertDialog.Builder(activity);
               //myPopup.setMessage("Envoi effectué ");

           }
        });
    }

    }