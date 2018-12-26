package com.example.edu05.coffeapp.activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.edu05.coffeapp.R;

import java.io.ByteArrayInputStream;

public class BasketballActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball);

        if(getIntent() !=null){
            Uri data = this.getIntent().getData();
            if (data !=null){
                Toast.makeText(this,data.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onClickButton(View view) {
    }
}
