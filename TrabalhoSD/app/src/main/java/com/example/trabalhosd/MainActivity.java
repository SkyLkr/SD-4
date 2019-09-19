package com.example.trabalhosd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    private static final int port = 333;

    private Button bnt_conecta;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        bnt_conecta = (Button) findViewById(R.id.button_conectar);
        edit = (EditText) findViewById(R.id.editText_IP);

        bnt_conecta.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ip = edit.getText().toString();

                try {
                    Connection.connect(ip, port);

                    Intent trabalhoSD_Tela2 = new Intent(MainActivity.this,TrabalhoSD_Tela2.class);
                    startActivity(trabalhoSD_Tela2);
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG);
                }
            }
        }));
    }

}
