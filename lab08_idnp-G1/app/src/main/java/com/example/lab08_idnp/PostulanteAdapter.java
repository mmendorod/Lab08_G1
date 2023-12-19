package com.example.lab08_idnp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostulanteAdapter extends RecyclerView.Adapter<PostulanteAdapter.ViewHolder> {
    private List<Postulante> postulantes;
    public PostulanteAdapter(List<Postulante> postulantes) {
        this.postulantes = postulantes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_postulante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Postulante postulante = postulantes.get(position);
        holder.bind(postulante);
    }

    @Override
    public int getItemCount() {
        return postulantes.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewDni;
        private final TextView textViewApellidoPaterno;
        private final TextView textViewApellidoMaterno;
        private final TextView textViewNombre;
        private final TextView textViewFechaNacimiento;
        private final TextView textViewColegioProcedencia;
        private final TextView textViewCarreraPostula;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDni = itemView.findViewById(R.id.text_view_dni);
            textViewApellidoPaterno = itemView.findViewById(R.id.text_view_apellidoPaterno);
            textViewApellidoMaterno = itemView.findViewById(R.id.text_view_apellidoMaterno);
            textViewNombre = itemView.findViewById(R.id.text_view_nombre);
            textViewFechaNacimiento = itemView.findViewById(R.id.text_view_fechaNacimiento);
            textViewColegioProcedencia = itemView.findViewById(R.id.text_view_colegioProcedencia);
            textViewCarreraPostula = itemView.findViewById(R.id.text_view_carreraPostula);

        }
        public void bind(Postulante postulante) {
            textViewDni.setText(postulante.getDni());
            textViewApellidoPaterno.setText(postulante.getApellidoPaterno());
            textViewApellidoMaterno.setText(postulante.getApellidoMaterno());
            textViewNombre.setText(postulante.getNombres());
            textViewFechaNacimiento.setText(postulante.getFechaNacimiento());
            textViewColegioProcedencia.setText(postulante.getColegioProcedencia());
            textViewCarreraPostula.setText(postulante.getCarreraPostula());
        }

    }
}
