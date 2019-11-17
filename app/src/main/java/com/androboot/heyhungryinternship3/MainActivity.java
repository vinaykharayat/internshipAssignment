package com.androboot.heyhungryinternship3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_CODE =1;
    Button btn_choose_image;
    Button btn_upload;
    EditText editText;
    ProgressBar progressBar;
    TextView textViewShowUploads;
    ImageView imageView;

    Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_choose_image = findViewById(R.id.btn_choose_img);
        btn_upload= findViewById(R.id.btn_upload);
        editText= findViewById(R.id.text_file_name);
        progressBar= findViewById(R.id.progress_bar);
        textViewShowUploads= findViewById(R.id.text_view_show_uploads);
        imageView= findViewById(R.id.image_view);

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_choose_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
            }
        });

        textViewShowUploads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void openFileChooser() {
        Intent intent= new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE_CODE && resultCode==RESULT_OK && data!=null&& data.getData()!=null)
        {
            uri=data.getData();
            imageView.setImageURI(uri);
            
        }
    }
}
