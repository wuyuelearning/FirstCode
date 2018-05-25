package com.example.admin.firstcode.Chapter8.CameraAlbum;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.firstcode.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by wuyue on 2018/5/25.
 */

public class CameraAlbumActivity extends AppCompatActivity {

    public static final int TAKE_PHOTO = 1;
    private ImageView img_photo;
    private Button btn_take_photo;

    private Uri image_uri;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter8_camera_album_activity);

        btn_take_photo = (Button) findViewById(R.id.btn_take_photo);
        img_photo = (ImageView) findViewById(R.id.img_picture);

        btn_take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
            }
        });
    }

    private void takePhoto() {

        File outputImage = new File(getExternalCacheDir(), "chapter8_output_image.jpg");

        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (Build.VERSION.SDK_INT >= 24) {
            image_uri = FileProvider.getUriForFile(CameraAlbumActivity.this, "com.example.admin.firstcode.Chapter8.CameraAlbum.fileprovider", outputImage);
        } else {
            image_uri = Uri.fromFile(outputImage);
        }

        Intent intent = new Intent("android.media.action_IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        startActivityForResult(intent, TAKE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO: {
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(image_uri));
                        img_photo.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
