package com.example.indigoapp.views;

import androidx.appcompat.app.AppCompatActivity;
import com.example.indigoapp.R;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GalleryView extends AppCompatActivity {

    TextView textViewGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_view);

        textViewGallery = findViewById(R.id.textViewUpload);

        textViewGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GalleryView.this,Gallery.class);
                startActivity(intent);
            }
        });
    }
}
