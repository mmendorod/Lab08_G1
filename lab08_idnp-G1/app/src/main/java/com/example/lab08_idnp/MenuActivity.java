package com.example.lab08_idnp;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    private Button newButton;
    private Button infoButton;

    private Button viewButton;
    private TextView usernameTextView;

    private static final String TAG = "MenuActivitv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        newButton = findViewById(R.id.new_button);
        infoButton = findViewById(R.id.info_button);
        viewButton =findViewById(R.id.view_button);
        usernameTextView = findViewById(R.id.username_text_view); // Asignar el TextView

        // Obtener el valor del "username" del Intent
        String username = getIntent().getStringExtra("username");
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.apply();


        // Mostrar el "username" en el TextView
        usernameTextView.setText("Bienvenido, " + username);



        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, PostulanteInfoActivity.class);
                startActivity(intent);
            }
        });

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, PostulanteRegistroActivity.class);
                startActivity(intent);
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, PostulanteViewActivity.class);
                startActivity(intent);
            }
        });
    }


}

