package com.example.hfyf;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.os.Environment.getExternalStoragePublicDirectory;

public class CameraActivity extends AppCompatActivity {
    Button btnTakePic;
    Button btnTakePicToHome;
    ImageView imageView;
    String pathToFile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        btnTakePic = findViewById(R.id.btnTakePic);
        btnTakePicToHome = findViewById(R.id.btnTakePicToHome);
        if(Build.VERSION.SDK_INT>=23){
            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }
        btnTakePicToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TakePicToHome = new Intent(CameraActivity.this, HomeActivity.class);
                startActivity(TakePicToHome);
            }
        });
        btnTakePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePictureAction();
            }
        });
        imageView = findViewById(R.id.image);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == 1){
                Bitmap bitmap = BitmapFactory.decodeFile(pathToFile);
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    private void takePictureAction() {
        Intent takePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePic.resolveActivity(getPackageManager()) != null){
            File photoFile = null;
            photoFile = createPhotoFile();
            if(photoFile != null) {
                pathToFile = photoFile.getAbsolutePath();
                Uri photoURI = FileProvider.getUriForFile(CameraActivity.this, "com.example.hfyf.fileprovider", photoFile);
                takePic.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePic, 1);
            }

        }

    }

    private File createPhotoFile() {
        String name = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File storageDir = getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(name, ".jpg", storageDir);
        } catch(IOException e){
            Log.d("myLog", "Excep: " + e.toString());
        }
        return image;
    }
}
