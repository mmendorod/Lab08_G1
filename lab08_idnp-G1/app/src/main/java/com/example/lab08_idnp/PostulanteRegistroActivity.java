package com.example.lab08_idnp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import android.util.Log;

public class PostulanteRegistroActivity extends AppCompatActivity {
    private List<Postulante> postulantes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_registro);

        Button registrarButton = findViewById(R.id.registrar_button);
        registrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePostulante();
            }
        });
    }
    private void savePostulante() {
        EditText dniEditText = findViewById(R.id.dni_edit_text);
        EditText apellidoPaternoEditText = findViewById(R.id.apellido_paterno_edit_text);
        EditText apellidoMaternoEditText = findViewById(R.id.apellido_materno_edit_text);
        EditText nombresEditText = findViewById(R.id.nombres_edit_text);
        EditText fechaNacimientoEditText = findViewById(R.id.fecha_nacimiento_edit_text);
        EditText colegioProcedenciaEditText = findViewById(R.id.colegio_procedencia_edit_text);
        EditText carreraPostulaEditText = findViewById(R.id.carrera_postula_edit_text);

        String dni = dniEditText.getText().toString();
        String apellidoPaterno = apellidoPaternoEditText.getText().toString();
        String apellidoMaterno = apellidoMaternoEditText.getText().toString();
        String nombres = nombresEditText.getText().toString();
        String fechaNacimiento = fechaNacimientoEditText.getText().toString();
        String colegioProcedencia = colegioProcedenciaEditText.getText().toString();
        String carreraPostula = carreraPostulaEditText.getText().toString();

        postulantes.clear();

        Postulante newPostulante = new Postulante(dni, apellidoPaterno, apellidoMaterno, nombres,
                fechaNacimiento, colegioProcedencia, carreraPostula);

        postulantes.add(newPostulante);

        // Verificar la cantidad de postulantes antes y después de guardar
        Log.d("PostulanteRegistroActivity", "Cantidad de postulantes antes de guardar: " + postulantes.size());

        PostulanteDBHelper.savePrivateStorage(this, postulantes);

        // Verificar la cantidad de postulantes después de guardar
        List<Postulante> postulantesGuardados = PostulanteDBHelper.readStoragePostulante(this);
        Log.d("PostulanteRegistroActivity", "Cantidad de postulantes después de guardar: " + postulantesGuardados.size());
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }
}
