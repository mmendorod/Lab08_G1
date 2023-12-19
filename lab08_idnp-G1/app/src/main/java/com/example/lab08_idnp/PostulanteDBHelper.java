package com.example.lab08_idnp;
import android.content.Context;
import android.util.Log;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PostulanteDBHelper {

    private static final String FILENAME = "postulantes.txt";

    public static void savePrivateStorage(Context context, List<Postulante> newPostulantes) {
        List<Postulante> existingPostulantes = readStoragePostulante(context);

        // Append new data to the existing list
        existingPostulantes.addAll(newPostulantes);

        try (FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // Write the entire updated list as a single object
            oos.writeObject(existingPostulantes);

            Log.d("PostulanteDBHelper", "Datos guardados correctamente");
        } catch (Exception e) {
            Log.e("PostulanteDBHelper", "Error al guardar datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Postulante> readStoragePostulante(Context context) {
        List<Postulante> postulantes = new ArrayList<>();
        try (FileInputStream fis = context.openFileInput(FILENAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Read the entire list as a single object
            Object obj = ois.readObject();
            if (obj instanceof List) {
                postulantes = (List<Postulante>) obj;
            }

            Log.d("PostulanteDBHelper", "Datos leídos correctamente");
        } catch (Exception e) {
            Log.e("PostulanteDBHelper", "Error al leer datos: " + e.getMessage());
            e.printStackTrace();
        }
        return postulantes;
    }
}


