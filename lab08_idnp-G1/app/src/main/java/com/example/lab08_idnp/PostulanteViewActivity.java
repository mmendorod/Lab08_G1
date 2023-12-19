package com.example.lab08_idnp;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostulanteViewActivity extends AppCompatActivity {

    private List<Postulante> postulantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_view);

        postulantes = PostulanteDBHelper.readStoragePostulante(this);

        // Verificar la cantidad de postulantes después de leer
        Log.d("PostulanteViewActivity", "Cantidad de postulantes: " + postulantes.size());

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        PostulanteAdapter adapter = new PostulanteAdapter(postulantes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
