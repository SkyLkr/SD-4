package com.example.trabalhosd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private Button bnt_conecta;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnt_conecta = (Button) findViewById(R.id.button_conectar);
        edit = (EditText) findViewById(R.id.editText_IP);

        bnt_conecta.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trabalhoSD_Tela2 = new Intent(MainActivity.this,TrabalhoSD_Tela2.class);
                startActivity(trabalhoSD_Tela2);
            }
        }));
    }

}
