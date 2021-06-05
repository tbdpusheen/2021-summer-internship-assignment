package com.example.summerinternshipapplication;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Integer> images = new ArrayList<>();
        // Loops through all drawables with the prefix "flower_" and adds their id to an ArrayList
        for (int i = 1; getResources().getIdentifier("flower_" + i,
                "drawable", getPackageName()) != 0; i++) {
            images.add(getResources().getIdentifier("flower_" + i, "drawable", getPackageName()));
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new Adapter(this, images));
    }

    // ViewHolder for the RecyclerView
    private static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    // Adapter for the RecyclerView
    private static class Adapter extends RecyclerView.Adapter<ViewHolder> {

        private final Context context;
        private final ArrayList<Integer> images;

        Adapter(Context context, ArrayList<Integer> images) {
            this.context = context;
            this.images = images;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            return new ViewHolder(inflater.inflate(R.layout.item_image, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            // Sets the ImageView to the resource id of the current image
            holder.imageView.setImageResource(images.get(position));
            // When an image is selected, go to the image activity and pass in the selected image
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, ImageActivity.class);
                intent.putExtra("Image", (int) images.get(position));
                context.startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return images.size();
        }
    }
}