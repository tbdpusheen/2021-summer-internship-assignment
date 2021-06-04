package com.example.summerinternshipapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> images = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Field[] drawablesFields = R.drawable.class.getDeclaredFields();
        ArrayList<Drawable> drawables = new ArrayList<>();
        for (Field field : drawablesFields) {
            try {
                drawables.add(ContextCompat.getDrawable(this, field.getInt(null)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
    }

    //  ViewHolder
    private static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    // Adapter
    private static class Adapter extends RecyclerView.Adapter<ViewHolder> {

        private final Context context;
        Adapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            return new ViewHolder(inflater.inflate(0, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, ImageActivity.class);
                context.startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

}