package com.responsi.ngobrolkuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfilePicActivity extends AppCompatActivity {
    private ImageView ivpinkcircle;
    private CircleImageView ivprofilepic;
    private CardView buttonlanjut;
    private static final String TAG = ProfilePicActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;
    private static String gambarUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);
        buttonlanjut = findViewById(R.id.btnlanjut);
        ivpinkcircle = findViewById(R.id.pinkCircle);
        ivprofilepic = findViewById(R.id.profilePic);

        buttonlanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(ProfilePicActivity.this, ChatListActivity.class);
                startActivity(move);
            }
        });
        ivpinkcircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GALLERY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED){
            Toast.makeText(this, "cancel input image", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (requestCode == GALLERY_REQUEST_CODE){
            if (data != null){
                try {
                    Uri ImageUrl =data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), ImageUrl);
                    ivprofilepic.setImageBitmap(bitmap );
                    gambarUri = ImageUrl.toString();
                    buttonlanjut.setVisibility(View.VISIBLE);
                }
                catch (IOException e){
                    Toast.makeText(this, "can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}