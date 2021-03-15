package com.cmraj.wallking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.io.IOException;

public class FullScreenWall extends AppCompatActivity {

    String large2x = "";
    PhotoView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_wall);

        getSupportActionBar().hide();

        Intent intent = getIntent();
        large2x = intent.getStringExtra("large2x");

        photoView = findViewById(R.id.photoView);

        Glide.with(this).load(large2x).into(photoView);

    }

    public void SetWallEvent(View view) {

        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        Bitmap bitmap = ((BitmapDrawable)photoView.getDrawable()).getBitmap();
        try {
            wallpaperManager.setBitmap(bitmap);
            Toast.makeText(this, "Wallpaper Set", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void DownWallEvent(View view) {

        DownloadManager downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(large2x);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        downloadManager.enqueue(request);
        Toast.makeText(this, "Download Start", Toast.LENGTH_SHORT).show();

    }
}