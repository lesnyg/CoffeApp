package com.example.edu05.coffeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.edu05.coffeapp.managers.Bank;

import models.Account;

public class AccountCheckActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mIdEditText;
    private EditText mPasswordEditText;
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_check);

        mIdEditText = findViewById(R.id.id_edit);
        mPasswordEditText = findViewById(R.id.password_edit);
        mResultTextView = findViewById(R.id.result_text);

        findViewById(R.id.login_btn).setOnClickListener(this);
        findViewById(R.id.close_btn).setOnClickListener(this);
    }


    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_btn:
                Bank bank = Bank.newInstance();

                String id = mIdEditText.getText().toString();
                String pass = mPasswordEditText.getText().toString();

                Account account = bank.login(id,pass);
                if(account!=null){
                    mResultTextView.setText(account.toString());
                }

                break;
            case R.id.close_btn:
                finish();
                break;
        }
    }


}
