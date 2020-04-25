package com.example.thumbnaildownloader;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {
    Button downbtn;
    ImageView thumb;
    OutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final String urlid = getIntent().getStringExtra("videoid");
        String urlink = "https://i.ytimg.com/vi/"+urlid+"/hqdefault.jpg";
        thumb = findViewById(R.id.thumbimg);
        downbtn = findViewById(R.id.dwnbtn);

        Picasso.get().load(urlink).into(thumb);

        downbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ((BitmapDrawable)thumb.getDrawable()).getBitmap();
                String time = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(System.currentTimeMillis());
                File path = Environment.getExternalStorageDirectory();
                File dir = new File(path+"/DCIM/");
                dir.mkdirs();
                String imagename = time + ".PNG";
                File file = new File(dir,imagename);
                OutputStream out;
                try {
                    out = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG,100,out);
                    out.flush();
                    out.close();
                    Toast.makeText(getApplicationContext(),"image saved at"+dir.toString(),Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();

                }


            }
        });

    }



}
