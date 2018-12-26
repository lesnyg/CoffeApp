package com.example.edu05.coffeapp.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.edu05.coffeapp.R;

public class ForResultActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE = 1000;
    private static final String TAG = ForResultActivity.class.getSimpleName();
    private EditText mValurEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);

        mValurEditText = findViewById(R.id.value_edit);
        findViewById(R.id.submit_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,TargetActivity.class);
        intent.putExtra("value",mValurEditText.getText().toString());
        //주거니 받거니
        startActivityForResult(intent, REQUEST_CODE);
    }

    //받을때 호출되는 콜백 메서드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data !=null) {
            Log.d(TAG, "onActivityResult:" + requestCode);
            Log.d(TAG, "onActivityResult:" + resultCode);
            Log.d(TAG, "onActivityResult:" + data);

            String result = data.getStringExtra("result");
            int value = data.getIntExtra("int", -1);
            Toast.makeText(this, result + ",int: " + value, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "데이터가 없습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
