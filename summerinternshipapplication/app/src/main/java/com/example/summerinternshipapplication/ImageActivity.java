package com.example.summerinternshipapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        // Sets the ImageView to the image passed in to the activity
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(getIntent().getIntExtra("Image", 0));
    }
}