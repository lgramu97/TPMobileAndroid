package com.example.tpfinalmoviles.Model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.tpfinalmoviles.GenerarBCS;
import com.example.tpfinalmoviles.R;
import com.example.tpfinalmoviles.Utils.ConfigOkHttp;
import com.example.tpfinalmoviles.Utils.ConfigServer;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    private TextView mTextViewResult;
    private  OkHttpClient client; //= new OkHttpClient();
    private Button botonTest;
    public ConfigOkHttp config;
    private CardView idAgregarVaca, idAgregarRodeo, idAgregarAlertaVaca, idAgregarAlertaRodeo
                    ,idConsultarVaca, idConsultarRodeo, idGenerarBCS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idAgregarVaca = (CardView) findViewById(R.id.idAgregarVaca);
        idAgregarRodeo = (CardView) findViewById(R.id.idAgregarRodeo);
        idAgregarAlertaRodeo = (CardView) findViewById(R.id.idAgregarAlertaRodeo);
        idAgregarAlertaVaca = (CardView) findViewById(R.id.idAgregarAlertaVaca);
        idConsultarVaca = (CardView) findViewById(R.id.idConsultarVaca);
        idConsultarRodeo = (CardView) findViewById(R.id.idConsultarRodeo);
        idGenerarBCS = (CardView) findViewById(R.id.idGenerarBCS);

        idAgregarVaca.setOnClickListener(this);
        idAgregarRodeo.setOnClickListener(this);
        idAgregarAlertaRodeo.setOnClickListener(this);
        idAgregarAlertaVaca.setOnClickListener(this);
        idConsultarVaca.setOnClickListener(this);
        idConsultarRodeo.setOnClickListener(this);
        idGenerarBCS.setOnClickListener(this);

        String url = getSharedPreferences(ConfigServer.URL_DETAILS,MODE_PRIVATE).getString("url","");
        System.out.println("Y va el tercero" + url);
       /* botonTest = (Button) findViewById(R.id.idButtonTest);
        final String url =  "http://10.0.2.2:8080/api/cow/1/";
        botonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client = new OkHttpClient();
                config = new ConfigOkHttp(client);
                System.out.println("primer");
                Callback c = new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("error2");
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    String mMessage = response.body().string();
                                    System.out.println("a " + mMessage);
                                } catch (IOException e) {
                                    System.out.println("error");
                                }
                            }
                        });
                    }
                };
                config.get(url,c);
                System.out.println("fin");
            }

        });
        System.out.println("fin2");
        */

        // HACER ESTO https://www.youtube.com/watch?v=d6CfaWW7G5Q JE
        /*
        Button loadApi = (Button) findViewById(R.id.loadApi);
        Button postReq = (Button) findViewById(R.id.postReq);
        final ConfigOkHttp config = new ConfigOkHttp(new OkHttpClient());
        final String url = "https://10.0.2.2:8080/api/herd/1";
        //config.POST(url,postdata);

        loadApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String url = "https://10.0.2.2:8080/api/herd/1";

                Request request = new Request.Builder()
                        .url(url)
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        try (ResponseBody responseBody = response.body()) {
                            if (!response.isSuccessful())
                                throw new IOException("Unexpected code " + response);
                            System.out.println(responseBody.string());
                        }
                    }
                });

            }
        });

        postReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONObject myObject = new JSONObject();
                    myObject.put("location", "Carlos");
                    myObject.put("id", new Integer(21));
                    config.POST(url, myObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });*/


    }
    /*
    private void getWS(){
        String url =  "http://10.0.2.2:8080/api/cow/1/";
      //  url = "https://www.googleapis.com/books/v1/volumes?";
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("error2");
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            String mMessage = response.body().string();
                            System.out.println("a " + mMessage);
                        } catch (IOException e) {
                            System.out.println("error");
                        }
                    }});

            }});

        }*/

    @Override
    public void onClick(View v) {
        Intent i;
        System.out.println("aaa");
        switch (v.getId()){
            case R.id.idAgregarVaca:
                i = new Intent(this, AgregarVaca.class);
                startActivity(i);
                System.out.println("aaa");
                break;
            case R.id.idAgregarRodeo:
                i = new Intent(this, AgregarRodeo.class);
                startActivity(i);
                System.out.println("boca amargo");
                break;
            case R.id.idAgregarAlertaRodeo:
                i = new Intent(this, AgregarRodeoAlerta.class);
                startActivity(i);
                System.out.println("te cogimos en europa ");
                break;
            case R.id.idAgregarAlertaVaca:
                i = new Intent(this, AgregarVacaAlerta.class);
                startActivity(i);
                System.out.println("en mendoza tmb");
                break;
            case R.id.idConsultarVaca:
                i = new Intent(this, ConsultarVaca.class);
                startActivity(i);
                System.out.println("maaaiaaaaameeeeee");
                break;
            case R.id.idConsultarRodeo:
                i = new Intent(this,ConsultarRodeo.class);
                startActivity(i);
                System.out.println("en todos lados");
                break;
            case R.id.idGenerarBCS:
                i = new Intent(this, GenerarBCS.class);
                startActivity(i);
                System.out.println("en todos lados");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}
