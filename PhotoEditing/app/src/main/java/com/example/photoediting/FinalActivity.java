package com.example.photoediting;

import static com.example.photoediting.MainActivity.imgUri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;
import com.example.photoediting.databinding.ActivityFinalBinding;

public class FinalActivity extends AppCompatActivity {
    ActivityFinalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFinalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent dsPhotoEditorIntent = new Intent(this, DsPhotoEditorActivity.class);
        dsPhotoEditorIntent.setData(imgUri);
        dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "PhotoEditing");
//
        startActivityForResult(dsPhotoEditorIntent,200);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 200:
                    Uri outputUri = data.getData();
                    // handle the result uri as you want, such as display it in an imageView;
                    binding.imgview.setImageURI(outputUri);
                    break;
            }
        }
    }
}