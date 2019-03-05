package com.example.postname;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt = findViewById(R.id.edt1);
        btn = findViewById(R.id.btn1);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                JSONObject jsn = new JSONObject();
                try{
                    jsn.put("Nombre",edt.getText().toString());
                }catch (JSONException e){
                    e.printStackTrace();
                }

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://nuevo.rnrsiilge-org.mx/nombre", jsn, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(MainActivity.this, "Nombre" + response.toString(), Toast.LENGTH_SHORT).show();
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
                );
                VolleySingleton.getInstance(MainActivity.this).getRequestQueue().add(jsonObjectRequest);
            }
        });
    }
}
