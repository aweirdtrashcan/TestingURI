package com.aweirdtrashcan.testinguri;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image = (ImageView) findViewById(R.id.mImage);
        Button mBtn = findViewById(R.id.mBtn);

        Log.d("Logging name", getPackageName().toString());

        Uri uri = (new Uri.Builder())
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(getResources().getResourcePackageName(R.drawable.ic_action_name))
                .appendPath(getResources().getResourceTypeName(R.drawable.ic_action_name))
                .appendPath(getResources().getResourceEntryName(R.drawable.ic_action_name))
                .build();

        String stringUri = uri.toString();

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.setImageURI(Uri.parse(stringUri));
            }
        });
    }
}
