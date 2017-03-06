package com.alro2025.mascotas30;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Contacto extends AppCompatActivity implements View.OnClickListener {

    private Button btnEnviar;
    private Toolbar toolbar;
    private EditText edtNombre, edtEmail, edtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtMensaje = (EditText) findViewById(R.id.edtMensaje);
        toolbar = (Toolbar) findViewById(R.id.miActionBar);

        setSupportActionBar(toolbar);

        //botón de subir
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        //cambiamos el título de appbar
        ab.setTitle("Contacto");

        btnEnviar.setOnClickListener(this);
    }

    private void sendEmail() {
        //Obtenemos el contenido del email
        String email = "angel.alro2025@gmail.com";
        String subject = edtEmail.getText().toString().trim();
        String message = edtMensaje.getText().toString().trim();

        //Creamos el objeto SendEmail
        EnviarEmail ee = new EnviarEmail(this, email, subject, message);

        //Ejecutamos SendEmail para enviar el email
        ee.execute();
    }

    @Override
    public void onClick(View view) {
        sendEmail();
        edtNombre.setText("");
        edtEmail.setText("");
        edtMensaje.setText("");

    }
}

