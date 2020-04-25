package com.example.thumbnaildownloader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText urltxt;
    Button clearbtn,submitbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urltxt = findViewById(R.id.urltxt);
        clearbtn = findViewById(R.id.clearbtn);
        submitbtn = findViewById(R.id.submitbtn);
        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urltxt.setText("");
            }
        });
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlid = String.valueOf(urltxt.getText());
                if(urlid.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Please Enter the URL",Toast.LENGTH_LONG).show();
                }else {

                    int len = urlid.length();
                     int i = urlid.indexOf('=');
                    if (i == -1) {
                        i = urlid.indexOf('/');
                        i +=10;
                    }

                    if (i == -1) {
                        Toast.makeText(getApplicationContext(), "URL is not correct", Toast.LENGTH_LONG).show();
                        urltxt.setText("");
                    } else {
                        String id = urlid.substring(i + 1, len);
                       // Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.putExtra("videoid", id);
                        // intent.putExtra("position", position);
                        startActivity(intent);

                    }


                    //char c = 'a';
                    // char[] char1 = urlid.toCharArray();
                    // while (c !='/' && c!='='){
                    //     c = char1[--len];
                    // }
                    //  String id = urlid.substring(len + 1, cpy);
                    //Toast.makeText(getApplicationContext(),id,Toast.LENGTH_LONG).show();
                    //Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    //intent.putExtra("videoid",id);
                    // intent.putExtra("position", position);
                    //  startActivity(intent);
                }
            }
        });
    }
}
