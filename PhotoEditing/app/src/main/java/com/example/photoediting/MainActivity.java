 package com.example.photoediting;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.photoediting.databinding.ActivityMainBinding;
import com.github.dhaval2404.imagepicker.ImagePicker;

 public class MainActivity extends AppCompatActivity {

    ActivityMainBinding Binding;
    public static Uri imgUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(Binding.getRoot());

        Binding.imgVAddImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.Companion.with(MainActivity.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .start();
            }
        });
    }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
         try {
             imgUri = data.getData();
             if (!imgUri.equals("")) ;
             startActivity(new Intent(MainActivity.this, FinalActivity.class));
         } catch (Exception e) {

         }
     }
 }