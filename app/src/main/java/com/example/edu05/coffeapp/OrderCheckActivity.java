package com.example.edu05.coffeapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderCheckActivity extends AppCompatActivity implements View.OnClickListener
{

    private TextView mResultTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_check);

        mResultTextView = findViewById(R.id.result_text);
        findViewById(R.id.cancel_button).setOnClickListener(this);
        findViewById(R.id.ok_button).setOnClickListener(this);

        if(getIntent()!=null){
            String result = getIntent().getStringExtra("result");
            String comment = getIntent().getStringExtra("comment");
            mResultTextView.setText(result+"\n\n 코멘트 : "+comment);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancel_button:
                finish();
                break;
            case R.id.ok_button:
                String[] addresses = {"lsy@hanmail.net"};
                getComposeEmail(addresses, "주문요청", mResultTextView.getText().toString());
                break;
        }

    }

    private void getComposeEmail(String[] addresses,String subject,String text) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto :"));
        intent.putExtra(Intent.EXTRA_EMAIL,addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,text);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }

    }
}
